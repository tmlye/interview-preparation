// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
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

    public static int makeAnagram(String a, String b) {
        int deletionCount = 0;
        int[] countsA = countChars(a);
        int[] countsB = countChars(b);

        for (int i = 0; i < 26; i++) {
            deletionCount += Math.abs(countsA[i] - countsB[i]);
        }

        return deletionCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
