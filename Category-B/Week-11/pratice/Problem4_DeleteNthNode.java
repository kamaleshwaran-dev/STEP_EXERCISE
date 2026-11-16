public class Problem4_DeleteNthNode {
    static class Node {
        int data; Node next;
        Node(int d) { data = d; }
    }

    static Node deleteNthNode(Node head, int n) {
        if (head == null) return null;
        if (n == 1) return head.next;
        Node current = head;
        for (int i = 1; i < n - 1; i++) current = current.next;
        current.next = current.next.next;
        return head;
    }

    static Node build(int... vals) {
        Node head = null, tail = null;
        for (int v : vals) {
            Node n = new Node(v);
            if (head == null) head = tail = n; else { tail.next = n; tail = n; }
        }
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node c = head; c != null; c = c.next) {
            sb.append(c.data);
            if (c.next != null) sb.append(" -> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(deleteNthNode(build(10, 20, 30, 40), 3));
        print(deleteNthNode(build(10, 20, 30, 40), 1));
    }
}