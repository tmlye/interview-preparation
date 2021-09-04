// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
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

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : b.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (char c : a.toCharArray()) {
            if (!charMap.containsKey(c)) {
                return false;
            } else {
                if (charMap.get(c) == 1) {
                    charMap.remove(c);
                } else {
                    charMap.put(c, charMap.get(c) - 1);
                }
            }
        }

        return true;
    }

    public static int sherlockAndAnagrams(String s) {
        int anagramCount = 0;
        char[] chars = s.toCharArray();
        // The maximum length of a substring is s.length -1
        // The minumum length of a substring is 1
        for (int substringLength = 1; substringLength <= chars.length - 1; substringLength++) {
            for (int i = 0; i < chars.length - substringLength; i++) {
                for (int j = i + 1; j <= chars.length - substringLength; j++) {
                    String a = s.substring(i, i + substringLength);
                    String b = s.substring(j, j + substringLength);
                    if (isAnagram(a, b)) {
                        anagramCount++;
                    }
                }
            }
        }

        return anagramCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

