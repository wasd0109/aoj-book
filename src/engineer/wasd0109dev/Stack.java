package engineer.wasd0109dev;

public class Stack {
    String[] stack;
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