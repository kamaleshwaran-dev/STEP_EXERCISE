class EditorUndoHistory {
    String[] stack;
    int top = -1;
    int capacity;

    EditorUndoHistory(int n) {
        capacity = n;
        stack = new String[n];
    }

    void type(String word) {
        if (top == capacity - 1) {
            System.out.println("rejected: history full");
            return;
        }

        stack[++top] = word;
        display();
    }

    void undo() {
        if (top == -1) {
            System.out.println("rejected: nothing to undo");
            return;
        }

        top--;
        display();
    }

    void display() {
        if (top == -1) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);
            if (i < top)
                System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EditorUndoHistory e = new EditorUndoHistory(3);

        e.type("Hi");
        e.type("there");
        e.type("all");
        e.type("now");

        e.undo();
        e.undo();
        e.undo();
        e.undo();
    }
}

//Complexity:
// TYPE: O(n) including display; O(1) stack operation.
// UNDO: O(n) including display; O(1) stack operation.
// Space: O(n).