package streamExamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestNumber {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12, 16, 45, 11, 18, 22, 19, 20, 45);

//        Integer num = list.stream().distinct().sorted((a, b) -> {
//            if (a > b) {
//                return -1;
//            } else {
//                return 1;
//            }
//        }).skip(1).findFirst().orElse(0);
        Integer num = list.stream().distinct().
                sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println(num);
    }
}
