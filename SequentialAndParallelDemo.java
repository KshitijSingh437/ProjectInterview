package streamExamples;

import java.util.Arrays;
import java.util.List;

public class SequentialAndParallelDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        System.out.println("SEQUENTIAL STREAM");

        list.stream().forEach(i -> System.out.println(i + " : " + Thread.currentThread().getName()));

        System.out.println("\n");
        System.out.println("PARALLEL STREAM");
        list.stream().parallel().forEach(i -> System.out.println(i + " : " + Thread.currentThread().getName()));

    }
}
