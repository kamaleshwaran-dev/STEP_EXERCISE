public class Problem1_PrintCircular {
    static class Node {
        int data; Node next;
        Node(int d) { data = d; }
    }

    static void printCircular(Node head) {
        if (head == null) { System.out.println(); return; }
        Node current = head;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(current.data).append(" ");
            current = current.next;
        } while (current != head);
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Node a = new Node(10), b = new Node(20), c = new Node(30);
        a.next = b; b.next = c; c.next = a;
        printCircular(a);
        printCircular(null);
    }
}