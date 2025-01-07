package KædedeStrukturer;

public class DoubleLinkedList {
    private DoubleNode head;

    public void addHistory(String action) {
        DoubleNode newNode = new DoubleNode(action);
        if (head == null) {
            head = newNode;
        } else {
            DoubleNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void printHistory() {
        DoubleNode current = head;
        while (current != null) {
            System.out.println(current.action);
            current = current.next;
        }
    }
}