package streamExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfCharacter {

    public static void main(String[] args) {

        String s = "kshitij";

        Map<String, Long> count = Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> l = Arrays.stream(s.split("")).distinct().collect(Collectors.toList());
        System.out.println(l);
        System.out.println(count);
    }

}
