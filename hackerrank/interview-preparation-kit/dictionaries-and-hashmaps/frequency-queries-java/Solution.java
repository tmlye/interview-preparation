// https://www.hackerrank.com/challenges/frequency-queries/problem
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

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Set<Integer>> frequenciesToValues = new HashMap<>();
        Map<Integer, Integer> valuesToFrequencies = new HashMap<>();
        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int value = query.get(1);

            if (operation == 1) {
                int currentFrequency = valuesToFrequencies.containsKey(value)
                    ? valuesToFrequencies.get(value)
                    : 0;
                int newFrequency = currentFrequency + 1;
                valuesToFrequencies.put(value, newFrequency);

                if (currentFrequency > 0) {
                    Set<Integer> valuesWithCurrentFrequency = frequenciesToValues.get(currentFrequency);
                    valuesWithCurrentFrequency.remove(value);
                    if (valuesWithCurrentFrequency.size() == 0) frequenciesToValues.remove(currentFrequency);
                }

                Set<Integer> valuesWithNewFrequency = frequenciesToValues.containsKey(newFrequency)
                    ? frequenciesToValues.get(newFrequency)
                    : new HashSet<Integer>();
                valuesWithNewFrequency.add(value);
                frequenciesToValues.put(newFrequency, valuesWithNewFrequency);
            } else if (operation == 2) {
                Integer currentFrequency = valuesToFrequencies.get(value);
                if (currentFrequency == null) continue;
                int newFrequency = currentFrequency - 1;
                Set<Integer> valuesWithCurrentFrequency = frequenciesToValues.get(currentFrequency);
                valuesWithCurrentFrequency.remove(value);
                if (valuesWithCurrentFrequency.size() == 0) frequenciesToValues.remove(currentFrequency);
                if (newFrequency == 0) {
                    valuesToFrequencies.remove(value);
                } else {
                    valuesToFrequencies.put(value, newFrequency);
                    Set<Integer> valuesWithNewFrequency = frequenciesToValues.containsKey(newFrequency)
                        ? frequenciesToValues.get(newFrequency)
                        : new HashSet<>();
                    valuesWithNewFrequency.add(value);
                    frequenciesToValues.put(newFrequency, valuesWithNewFrequency);
                }
            } else if (operation == 3) {
                if (frequenciesToValues.containsKey(value)) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
