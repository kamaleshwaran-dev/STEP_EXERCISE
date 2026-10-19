public class RoundRobinGameTurns {
    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    static class CircularLinkedList {
        Node tail;

        void addLast(String name) {
            Node node = new Node(name);

            if (tail == null) {
                tail = node;
                tail.next = tail;
            } else {
                node.next = tail.next;
                tail.next = node;
                tail = node;
            }
        }

        void printTurns(int turns) {
            if (tail == null) {
                return;
            }

            Node current = tail.next;

            for (int i = 0; i < turns; i++) {
                System.out.print(current.name);

                if (i < turns - 1) {
                    System.out.print(" ");
                }

                current = current.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList players = new CircularLinkedList();

        players.addLast("Asha");
        players.addLast("Ravi");
        players.addLast("Neha");

        players.printTurns(7);
    }
}

//Complexity:
//- addLast: \(O(1)\)
//- Printing turns turns: \(O(\text{turns})\)