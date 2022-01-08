package engineer.wasd0109dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int currentValue = numbers[i];
            int previousIndex = i - 1;
            while (previousIndex >= 0 && numbers[previousIndex] > currentValue) {
                numbers[previousIndex + 1] = numbers[previousIndex];
                previousIndex--;
            }
            numbers[previousIndex + 1] = currentValue;
            System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", "").replace(",", ""));
        }
    }

    public static void bubbleSort(int[] numbers) {
        boolean flag = true;
        int counter = 0;
        int lastUnsortedIndex = 0;
        while (flag) {
            flag = false;
            for (int i = numbers.length - 1; i >= lastUnsortedIndex + 1; i--) {
                if (numbers[i] < numbers[i - 1]) {
                    int temp = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = temp;
                    flag = true;
                    counter++;
                }
            }
        }
        printArray(numbers);
        System.out.println(counter);
    }

    public static void selectionSort(int[] numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            if (numbers[i] != numbers[minIndex]) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
                counter++;
            }
        }
        printArray(numbers);
        System.out.println(counter);
    }


    public static void printArray(int[] numbers) {
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                outputStr.append(numbers[i]);
            } else {
                outputStr.append(" ");
                outputStr.append(numbers[i]);
            }

        }
        System.out.println(outputStr);
    }


    public static void printArray(String[] items) {
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            if (i == 0) {
                outputStr.append(items[i]);
            } else {
                outputStr.append(" ");
                outputStr.append(items[i]);
            }

        }
        System.out.println(outputStr);
    }


    public static void bubbleSort(String[] inputs) {
        boolean flag = true;
        int lastUnsortedIndex = 0;
        String[] sorted = inputs.clone();
        while (flag) {
            flag = false;
            for (int i = sorted.length - 1; i >= lastUnsortedIndex + 1; i--) {
                if (getValue(sorted[i]) < getValue(sorted[i - 1])) {
                    String temp = sorted[i - 1];
                    sorted[i - 1] = sorted[i];
                    sorted[i] = temp;
                    flag = true;

                }
            }
        }
        printArray(sorted);
        boolean isStable = isStable(inputs, sorted);
        if (isStable) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
    }

    public static void selectionSort(String[] inputs) {
        String[] sorted = inputs.clone();
        for (int i = 0; i < sorted.length; i++) {
            int minIndex = i;
            for (int j = i; j < sorted.length; j++) {
                if (getValue(sorted[j]) < getValue(sorted[minIndex])) {
                    minIndex = j;
                }
            }
            if (getValue(sorted[i]) != getValue(sorted[minIndex])) {
                String temp = sorted[i];
                sorted[i] = sorted[minIndex];
                sorted[minIndex] = temp;

            }
        }
        printArray(sorted);
        boolean isStable = isStable(inputs, sorted);
        if (isStable) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
    }

    public static boolean isStable(String[] original, String[] sorted) {
        for (int i = 0; i < original.length; i++) {
            for (int j = i + 1; j < original.length; j++) {
                for (int k = 0; k < original.length; k++) {
                    for (int l = k + 1; l < original.length; l++) {
                        if (getValue(original[i]) == getValue(original[j]) && original[i].equals(sorted[l]) && original[j].equals(sorted[k]))
                            return false;
                    }
                }
            }

        }
        return true;
    }


    public static int getValue(String input) {
        return Character.getNumericValue(input.charAt(1));
    }

    public static void insertionSort(int[] numbers, int length, int gap) {
        for (int i = gap; i < length; i++) {
            int currentValue = numbers[i];
            int index = i - gap;
            while (index >= 0 && numbers[index] > currentValue) {
                numbers[index + gap] = numbers[index];
                index = index - gap;

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
        for (Integer gap : gaps) {
            insertionSort(numbers, length, gap);
        }
        System.out.println(gaps.size());
        printArray(gaps);

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
                outputStr.append(" ");
                outputStr.append(numbers.get(i));
            }

        }
        System.out.println(outputStr);
    }


}
