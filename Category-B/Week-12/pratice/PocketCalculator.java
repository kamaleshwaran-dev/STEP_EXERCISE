
class PocketCalculator {
    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    static String toPostfix(String infix) {
        char[] stack = new char[infix.length()];
        int top = -1;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack[++top] = c;
            } else if (c == ')') {
                while (top >= 0 && stack[top] != '(')
                    result.append(stack[top--]);
                top--;
            } else {
                while (top >= 0 && stack[top] != '(' &&
                       precedence(stack[top]) >= precedence(c))
                    result.append(stack[top--]);

                stack[++top] = c;
            }
        }

        while (top >= 0)
            result.append(stack[top--]);

        return result.toString();
    }

    static int evaluate(String postfix) {
        int[] stack = new int[postfix.length()];
        int top = -1;

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack[++top] = c - '0';
            } else {
                int b = stack[top--];
                int a = stack[top--];

                switch (c) {
                    case '+': stack[++top] = a + b; break;
                    case '-': stack[++top] = a - b; break;
                    case '*': stack[++top] = a * b; break;
                    case '/':
                        if (b == 0)
                            throw new ArithmeticException("Division by zero");
                        stack[++top] = a / b;
                        break;
                }
            }
        }

        return stack[top];
    }

    public static void main(String[] args) {
        String[] expressions = {
            "2+3*4",
            "(2+3)*4",
            "8/2-3"
        };

        for (String exp : expressions) {
            String postfix = toPostfix(exp);
            System.out.println(postfix + " = " + evaluate(postfix));
        }
    }
}

//Complexity:
// Conversion: O(n) time, O(n) space.
// Evaluation: O(n) time, O(n) space.