// https://www.hackerrank.com/challenges/count-triplets-1/problem
// This is not the correct solution but didn't just want to copy-paste someone else's
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        long max = Long.MIN_VALUE;
        Map<Long, Long> numberToCount = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            long newValue = arr.get(i);
            if (newValue != 1 && newValue % r != 0L) continue;
            if (newValue > max) max = newValue;
            Long currentCount = numberToCount.get(newValue);
            numberToCount.put(newValue, currentCount == null ? 1L : currentCount + 1L);
        }

        for (long i = 1; i <= max / (r * r); i = i*r) {
            long currentNumCount = numberToCount.getOrDefault(i, 0L);
            long nextNumCount = numberToCount.getOrDefault(i*r, 0L);
            long lastNumCount = numberToCount.getOrDefault(i * r * r, 0L);
            // If one of them doesn't exist, this number is not the start of a triplet
            if (currentNumCount == 0L || nextNumCount == 0L || lastNumCount == 0L) {
                continue;
            }

            count += currentNumCount * nextNumCount * lastNumCount;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
