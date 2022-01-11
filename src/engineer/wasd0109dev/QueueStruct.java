package engineer.wasd0109dev;

import java.util.Scanner;

public class QueueStruct {
    public static void main(String[] args) {
        class Program {
            int processTime;
            final String name;
            boolean completed = false;

            public boolean isCompleted() {
                return completed;
            }

            public Program(int processTime, String name) {
                this.processTime = processTime;
                this.name = name;
            }

            public int getProcessTime() {
                return processTime;
            }

            public String getName() {
                return name;
            }

            public boolean process(int maxProcessTime) {
                if (this.processTime - maxProcessTime <= 0) {
                    this.processTime = 0;
                    this.completed = true;
                    return true;
                }
                this.processTime -= maxProcessTime;
                return false;
            }


        }
        class Queue {
            final Program[] programQueues;
            int head;
            int tail;

            public Queue(int n) {
                this.programQueues = new Program[n + 10];
                this.head = 0;
                this.tail = 0;
            }

            public boolean isEmpty() {
                return this.head == this.tail;
            }

            public Program dequeue() {
                Program p = this.programQueues[head];
                if (head + 1 == this.programQueues.length) {
                    head = 0;
                } else {
                    head++;
                }
                return p;
            }

            public void enqueue(Program p) {
                this.programQueues[tail] = p;
                if (tail + 1 == this.programQueues.length) {
                    tail = 0;
                } else {
                    tail++;
                }
            }

            public int getLength() {
                return this.tail - this.head;
            }
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxProcessTime = scanner.nextInt();

        Queue programQueues = new Queue(n);
        while (programQueues.getLength() < n) {
            String pName = scanner.next();
            int pTime = scanner.nextInt();
            Program p = new Program(pTime, pName);
            programQueues.enqueue(p);
        }
        int timer = 0;
        while (!programQueues.isEmpty()) {
            Program currentP = programQueues.dequeue();
            int remainingProcessTime = currentP.getProcessTime();
            boolean isCompleted = currentP.process(maxProcessTime);
            if (isCompleted) {
                timer += remainingProcessTime;
                System.out.println(currentP.name + " " + timer);
            } else {
                timer += maxProcessTime;
                programQueues.enqueue(currentP);
            }
        }
    }

}
