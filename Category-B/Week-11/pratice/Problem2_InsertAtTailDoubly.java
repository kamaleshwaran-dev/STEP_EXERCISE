public class Problem2_InsertAtTailDoubly {
    static class DNode {
        int data; DNode prev, next;
        DNode(int d) { data = d; }
    }

    static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) return newNode;
        DNode tail = head;
        while (tail.next != null) tail = tail.next;
        tail.next = newNode;
        newNode.prev = tail;
        return head;
    }

    static void print(DNode head) {
        StringBuilder sb = new StringBuilder();
        for (DNode c = head; c != null; c = c.next) {
            sb.append(c.data);
            if (c.next != null) sb.append(" <-> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        DNode head = null;
        for (int v : new int[]{1, 2, 3}) head = insertAtTailDoubly(head, v);
        print(insertAtTailDoubly(head, 4));
        print(insertAtTailDoubly(null, 7));
    }
}