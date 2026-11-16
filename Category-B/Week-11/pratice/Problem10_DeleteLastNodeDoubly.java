public class Problem10_DeleteLastNodeDoubly {
    static class DNode {
        int data; DNode prev, next;
        DNode(int d) { data = d; }
    }

    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        DNode current = head;
        while (current.next.next != null) current = current.next;
        current.next.prev = null;
        current.next = null;
        return head;
    }

    static DNode build(int... vals) {
        DNode head = null, tail = null;
        for (int v : vals) {
            DNode n = new DNode(v);
            if (head == null) head = tail = n;
            else { tail.next = n; n.prev = tail; tail = n; }
        }
        return head;
    }

    static void print(DNode head) {
        if (head == null) { System.out.println("(empty list)"); return; }
        StringBuilder sb = new StringBuilder();
        for (DNode c = head; c != null; c = c.next) {
            sb.append(c.data);
            if (c.next != null) sb.append(" <-> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(deleteLastNodeDoubly(build(1, 2, 3)));
        print(deleteLastNodeDoubly(build(5)));
    }
}