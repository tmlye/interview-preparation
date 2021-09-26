// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
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

    private static int[] countChars(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 97]++;
        }
        return counts;
    }

    public static String isValid(String s) {
        if (s.length() == 1) return "YES";
        int[] counts = countChars(s);
        Arrays.sort(counts);
        int i = 0;
        while (counts[i] == 0) i++;

        int last = counts.length - 1;
        int minMaxDiff = counts[last] - counts[i];

        if (counts[i] == 1 && counts[i + 1] == counts[last]) return "YES";
        if (minMaxDiff > 1) return "NO";
        if (minMaxDiff == 1 && counts.length > 1) {
            if (counts[last] - 1  == counts[last - 1]) return "YES";
            if (counts[i] + 1 == counts[i + 1]) return "YES";

            return "NO";
        }

        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
