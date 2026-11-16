
class BrowserTabStrip {
    static class Node {
        String name;
        Node prev, next;

        Node(String name) {
            this.name = name;
        }
    }

    Node head, current;

    void open(String name) {
        Node n = new Node(name);

        if (current == null) {
            head = current = n;
        } else {
            n.next = current.next;
            n.prev = current;

            if (current.next != null)
                current.next.prev = n;

            current.next = n;
            current = n;
        }
        print();
    }

    void close() {
        if (current == null) return;

        Node old = current;

        if (old.next != null)
            current = old.next;
        else
            current = old.prev;

        if (old.prev != null)
            old.prev.next = old.next;
        else
            head = old.next;

        if (old.next != null)
            old.next.prev = old.prev;

        if (current == null)
            head = null;

        System.out.print("CLOSE " + old.name + ": ");
        print();
    }

    void back() {
        if (current == null || current.prev == null) {
            System.out.println("BACK: already at first tab");
            return;
        }
        current = current.prev;
        System.out.print("BACK: ");
        print();
    }

    void forward() {
        if (current == null || current.next == null) {
            System.out.println("FORWARD: already at last tab");
            return;
        }
        current = current.next;
        System.out.print("FORWARD: ");
        print();
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            if (temp == current)
                System.out.print("[" + temp.name + "]");
            else
                System.out.print(temp.name);

            if (temp.next != null)
                System.out.print(" <-> ");

            temp = temp.next;
        }
        System.out.println();
    }

    void printBackward() {
        Node temp = head;
        if (temp == null) return;

        while (temp.next != null)
            temp = temp.next;

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.name);
            if (temp.prev != null)
                System.out.print(" <-> ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BrowserTabStrip b = new BrowserTabStrip();

        b.open("Mail");
        b.open("Docs");
        b.open("Maps");
        b.back();
        b.back();
        b.back();
        b.open("Drive");
        b.close();
        b.forward();
        b.close();
        b.printBackward();
    }
}

//Complexity:
// Open: O(1)
// Close: O(1)
// Back: O(1)
// Forward: O(1)
// Print backward: O(n)