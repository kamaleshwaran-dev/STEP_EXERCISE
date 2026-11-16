
class CounsellingList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node partition(Node head, int passMark) {
        Node lowHead = null, lowTail = null;
        Node highHead = null, highTail = null;

        while (head != null) {
            Node next = head.next;
            head.next = null;

            if (head.data < passMark) {
                if (lowHead == null)
                    lowHead = lowTail = head;
                else {
                    lowTail.next = head;
                    lowTail = head;
                }
            } else {
                if (highHead == null)
                    highHead = highTail = head;
                else {
                    highTail.next = head;
                    highTail = head;
                }
            }

            head = next;
        }

        if (lowHead == null)
            return highHead;

        lowTail.next = highHead;
        return lowHead;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(55);
        head.next = new Node(32);
        head.next.next = new Node(78);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(40);
        head.next.next.next.next.next = new Node(35);

        head = partition(head, 40);
        display(head);
    }
}

//Complexity:
// Time: O(n)
// Space: O(1) auxiliary space.