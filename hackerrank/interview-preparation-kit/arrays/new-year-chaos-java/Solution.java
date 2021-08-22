// https://www.hackerrank.com/challenges/new-year-chaos/problem
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

class Result {
    public static void minimumBribes(List<Integer> q) {
        int bribeCount = 0;
        for (int i = 0; i < q.size(); i++) {
            int curValue = q.get(i);
            int diffInPosition = curValue - i - 1;
            if (diffInPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }
            // Count how many bribes the person received
            for (int j = Math.max(0, curValue - 2); j < i; j++) {
                if (q.get(j) > curValue) {
                    bribeCount++;
                }
            }
        }

        System.out.println(bribeCount);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
