package KædedeStrukturer;

public class SingleLinkedList {
    private Node head;

    public void add(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remove(String name) {
        if (head == null) return false;

        if (head.contact.getName().equals(name)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.contact.getName().equals(name)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }

        return false;
    }

    public Contact search(String name) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equals(name)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }
}