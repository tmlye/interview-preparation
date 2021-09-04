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
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineWordToCount = new HashMap<>();

        for (String m : magazine) {
            if (!magazineWordToCount.containsKey(m)) {
                magazineWordToCount.put(m, 1);
            } else {
                magazineWordToCount.put(m, magazineWordToCount.get(m) + 1);
            }
        }

        for (String n : note) {
            if (magazineWordToCount.containsKey(n)) {
                int count = magazineWordToCount.get(n);
                if (count <= 1) {
                    magazineWordToCount.remove(n);
                } else {
                    magazineWordToCount.put(n, count - 1);
                }
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
