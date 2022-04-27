import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ChallengeOneResult {

    public static void plusMinus(List<Integer> arr) {
        final int[] positiveCount = {0};
        final int[] negativeCount = {0};
        final int[] zeroCount = {0};
        arr.forEach(integerValue -> {
            if (integerValue > 0) {
                positiveCount[0]++;
            } else if (integerValue < 0) {
                negativeCount[0]++;
            } else {
                zeroCount[0]++;
            }
        });
        System.out.printf("%.6f%n", (float) positiveCount[0] / arr.size());
        System.out.printf("%.6f%n", (float) negativeCount[0] / arr.size());
        System.out.printf("%.6f%n", (float) zeroCount[0] / arr.size());
    }

}

public class ChallengeOneSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ChallengeOneResult.plusMinus(arr);

        bufferedReader.close();
    }
}
