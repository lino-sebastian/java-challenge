import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ChallengeTwoResult {

    public static void miniMaxSum(List<Integer> arr) {
        Queue<Long> queue = new LinkedList<>();
        for (Integer integer : arr) {
            queue.add((long) integer);
        }

        List<Long> sumList = new ArrayList<>();

        Long popedValue = queue.remove();
        Long temp = 0L;
        for (int j = arr.size(); j > 0; j--) {
            long sum = 0L;
            for (Long longValue : queue) {
                sum = sum + longValue;
            }
            sumList.add(sum);
            temp = popedValue;
            popedValue = queue.remove();
            queue.add(temp);
        }
        Long minInteger = sumList.stream().min(Comparator.comparing(Long::valueOf)).get();
        Long maxInteger = sumList.stream().max(Comparator.comparing(Long::valueOf)).get();
        System.out.println(minInteger + " " + maxInteger);
    }

}

public class ChallengeTwoSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ChallengeTwoResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}
