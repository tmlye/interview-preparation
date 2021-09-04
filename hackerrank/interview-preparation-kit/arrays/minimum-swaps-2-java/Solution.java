// https://www.hackerrank.com/challenges/minimum-swaps-2/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static void swap(int[] arr, int fromIndex, int toIndex) {
        int buffer = arr[toIndex];
        arr[toIndex] = arr[fromIndex];
        arr[fromIndex] = buffer;
    }

    private static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == i + 1) {
                i++;
                continue;
            }

            swap(arr, i, arr[i] - 1);
            swaps++;
        }

        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
