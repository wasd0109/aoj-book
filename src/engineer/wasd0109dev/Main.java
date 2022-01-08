package engineer.wasd0109dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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
            final List<Program> programQueues;

            public Queue(int n) {
                this.programQueues = new ArrayList<>();
            }

            public boolean isEmpty() {
                return this.programQueues.isEmpty();
            }

            public Program shift() {
                return this.programQueues.remove(0);
            }

            public void push(Program p) {
                this.programQueues.add(p);
            }

            public int getLength() {
                return this.programQueues.size();
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
            programQueues.push(p);
        }
        int timer = 0;
        while (!programQueues.isEmpty()) {
            Program currentP = programQueues.shift();
            int remainingProcessTime = currentP.getProcessTime();
            boolean isCompleted = currentP.process(maxProcessTime);
            if (isCompleted) {
                timer += remainingProcessTime;
                System.out.println(currentP.name + " " + timer);
            } else {
                timer += maxProcessTime;
                programQueues.push(currentP);
            }
        }
    }


}
