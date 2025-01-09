package Tråde;

import org.w3c.dom.css.Counter;

import java.util.concurrent.Semaphore;

// Her er et eksempel på en tråd, hvor vi har to tråde, som printer "Hello" og "World" på skærmen.
public class MyThread extends Thread {
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello ");
    }
}

    class MyThread1 extends Thread{
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("World");
        }
    }

    class Main {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            MyThread1 t2 = new MyThread1();
            t1.start();
            t2.start();
        }
    }


    // Her er et eksempel på en bank, hvor der er 3 kasserere og 10 kunder. Hvor vi bruger semaphores til at styre adgangen til kassererne.
    class Bank {
        private static final int NUM_CASHIERS = 3; // Antal kasserere
        private static final Semaphore semaphore = new Semaphore(NUM_CASHIERS);

        public static void main(String[] args) {
            for (int i = 1; i <= 10; i++) {
                int customerID = i;
                new Thread(() -> {
                    try {
                        System.out.println("Customer " + customerID + " is waiting for a cashier.");

                        // Få adgang til en kasserer
                        semaphore.acquire();
                        System.out.println("Customer " + customerID + " is being served by a cashier.");

                        // Simulerer service tid
                        Thread.sleep((long) (Math.random() * 5000));

                        System.out.println("Customer " + customerID + " is done being served.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // Frigør kasserer
                        semaphore.release();
                    }
                }).start();
            }
        }
    }

    class Taeller {
        public int taeller;

        public static void main(String[] args) {
            Taeller taeller = new Taeller();

            Thread taellerThread1 = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    synchronized (taeller) {
                        taeller.taeller++;
                        System.out.println("Tæller øget: " + taeller.taeller);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread taellerThread2 = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    synchronized (taeller) {
                        taeller.taeller--;
                        System.out.println("Tæller mindsket: " + taeller.taeller);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            taellerThread1.start();
            taellerThread2.start();



        }

        class taellerThread1 extends Thread {
            public void run() {
                taeller++;

            }
        }

        class taellerThread2 extends Thread {
            public void run() {

            }
        }
    }