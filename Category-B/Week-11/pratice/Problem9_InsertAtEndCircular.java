public class Problem9_InsertAtEndCircular {
    static class Node {
        int data; Node next;
        Node(int d) { data = d; }
    }

    static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node last = head;
        while (last.next != head) last = last.next;
        last.next = newNode;
        newNode.next = head;
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        Node c = head;
        do {
            sb.append(c.data).append(" -> ");
            c = c.next;
        } while (c != head);
        sb.append("(back to ").append(head.data).append(")");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Node a = new Node(1), b = new Node(2), c = new Node(3);
        a.next = b; b.next = c; c.next = a;
        print(insertAtEndCircular(a, 4));
        print(insertAtEndCircular(null, 9));
    }
}