package engineer.wasd0109dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int counter = 0;
        while (counter < n) {
            numbers[counter] = scanner.nextInt();
            counter++;
        }

        shellSort(numbers, numbers.length);
    }

    public static void insertionSort(int[] numbers, int length, int gap) {
        for (int i = gap; i < length; i++) {
            int currentValue = numbers[i];
            int index = i - gap;
            while (index >= 0 && numbers[index] > currentValue) {
                numbers[index + gap] = numbers[index];
                index = index - gap;
                count++;
            }
            numbers[index + gap] = currentValue;
        }
    }

    public static void shellSort(int[] numbers, int length) {
        List<Integer> gaps = new ArrayList<>();
        for (int i = 1; ; ) {
            if (i > length) {
                break;
            }
            gaps.add(i);
            i = 3 * i + 1;
        }
        Collections.reverse(gaps);
        for (int i = 0; i < gaps.size(); i++) {
            insertionSort(numbers, length, gaps.get(i));
        }
        System.out.println(gaps.size());
        printArray(gaps);
        System.out.println(count);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printArray(List<Integer> numbers) {
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0) {
                outputStr.append(numbers.get(i));
            } else {
                outputStr.append(" " + numbers.get(i));
            }

        }
        System.out.println(outputStr);
    }


    public static void printArray(int[] numbers) {
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                outputStr.append(numbers[i]);
            } else {
                outputStr.append(" " + numbers[i]);
            }

        }
        System.out.println(outputStr);
    }

}
