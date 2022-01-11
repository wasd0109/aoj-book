package engineer.wasd0109dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String sInput = br.readLine();
            int q = Integer.parseInt(br.readLine());
            String tInput = br.readLine();
            int[] s = new int[n + 1];
            String[] sInputs = sInput.split(" ");
            int[] t = new int[q];
            String[] tInputs = tInput.split(" ");
            for (int i = 0; i < sInputs.length; i++) {
                s[i] = Integer.parseInt(sInputs[i]);
            }
            for (int i = 0; i < tInputs.length; i++) {
                t[i] = Integer.parseInt(tInputs[i]);
            }

            int count = 0;
            for (int target : t) {
                if (binarySearch(s, target)) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean linearSearch(int[] numbers, int n, int target) {
        int[] a = numbers.clone();
        a[n] = target;
        int i = 0;
        while (a[i] != target) {
            i++;
        }
        return i != n;
    }

    public static boolean binarySearch(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] == target) {
                return true;
            } else if (numbers[mid] < target) {
                lo = mid + 1;

            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}