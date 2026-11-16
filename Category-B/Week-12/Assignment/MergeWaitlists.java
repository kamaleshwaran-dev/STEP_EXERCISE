
class MergeWaitlists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node merge(Node first, Node second) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }

        if (first != null)
            tail.next = first;
        else
            tail.next = second;

        return dummy.next;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        a.next = new Node(8);
        a.next.next = new Node(15);

        Node b = new Node(5);
        b.next = new Node(8);
        b.next.next = new Node(20);
        b.next.next.next = new Node(25);

        Node result = merge(a, b);
        display(result);
    }
}

//Complexity:
// Time: O(n + m)
// Space: O(1) auxiliary space (one dummy node).