public class Problem3_RemoveFirstKNodes {
    static class Node {
        int data; Node next;
        Node(int d) { data = d; }
    }

    static Node removeFirstKNodes(Node head, int k) {
        while (k > 0 && head != null) {
            head = head.next;
            k--;
        }
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
        if (head == null) { System.out.println("(empty list)"); return; }
        StringBuilder sb = new StringBuilder();
        for (Node c = head; c != null; c = c.next) {
            sb.append(c.data);
            if (c.next != null) sb.append(" -> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(removeFirstKNodes(build(1, 2, 3, 4, 5), 2));
        print(removeFirstKNodes(build(1, 2), 5));
    }
}