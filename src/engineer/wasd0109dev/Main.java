package engineer.wasd0109dev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        class Stack {
            final String[] stack;
            int top = 0;

            public Stack() {
                this.stack = new String[200];

            }

            public void push(String ch) {
                top++;
                this.stack[top] = ch;
            }

            public String pop() {
                String element = this.stack[top];
                top--;
                return element;
            }


        }
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        while (scanner.hasNext()) {
            String current = scanner.next();
            boolean isOperands = isOperator(current);
            if (!isOperands) {
                stack.push(current);
            } else {
                int secondOperands = Integer.parseInt(stack.pop());
                int firstOperands = Integer.parseInt(stack.pop());
                int results;
                char operator = current.charAt(0);
                switch (operator) {
                    case '+':
                        results = firstOperands + secondOperands;
                        break;
                    case '-':
                        results = firstOperands - secondOperands;
                        break;
                    case '*':
                        results = firstOperands * secondOperands;
                        break;
                    case '/':
                        results = firstOperands / secondOperands;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                stack.push(Integer.toString(results));
            }
        }
        System.out.println(stack.pop());
    }

    public static boolean isOperator(String str) {
        char operator = str.charAt(0);
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

}
