public class Problem5_SplitListInHalf {
    static class Node {
        int data; Node next;
        Node(int d) { data = d; }
    }

    // Time: O(n), Space: O(1)
    // First half gets the extra middle node when length is odd.
    static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        return second;
    }

    static Node build(int... vals) {
        Node head = null, tail = null;
        for (int v : vals) {
            Node n = new Node(v);
            if (head == null) head = tail = n; else { tail.next = n; tail = n; }
        }
        return head;
    }

    static String str(Node head) {
        if (head == null) return "(empty list)";
        StringBuilder sb = new StringBuilder();
        for (Node c = head; c != null; c = c.next) {
            sb.append(c.data);
            if (c.next != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node h = build(1, 2, 3, 4, 5);
        Node second = splitListInHalf(h);
        System.out.println("First half: " + str(h) + "   Returned: " + str(second));
        h = build(1, 2, 3, 4);
        second = splitListInHalf(h);
        System.out.println("First half: " + str(h) + "   Returned: " + str(second));
    }
}