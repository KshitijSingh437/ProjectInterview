package streamExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 49, 32);
        System.out.println("\n");
        System.out.println("All the even numbers exist in the list");

        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        System.out.println("\n");
        System.out.println("All the numbers starting with 1");

        list.stream().map(String::valueOf).filter(s -> s.startsWith("1")).forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Duplicate elements in a given integers list");

        Set<Integer> set = new HashSet<>();
        list.stream().filter(n -> !set.add(n)).forEach(System.out::println);

        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).forEach(System.out::println);

        list.stream().filter(i -> Collections.frequency(list, i) > 1).distinct().forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Find first element in a given integers list");

        list.stream().findFirst().ifPresent(System.out::println);

        System.out.println("\n");
        System.out.println("Total number of elements present in the list");

        long count = list.stream().count();
        System.out.println(count);

        System.out.println("\n");
        System.out.println("Maximum value element present in the list");

        int doubleMax = list.stream().mapToInt(Integer::intValue).summaryStatistics().getMax();
        System.out.println(doubleMax);
        int max = list.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(max);

        System.out.println("\n");
        System.out.println("First non-repeated character in the string");

        String input = "Java is Awesome";

        Character res1 = input.chars().mapToObj(s -> Character.toLowerCase((char) s)).collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting())).entrySet().stream().
                filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst().orElse(null);
        System.out.println(res1);

        System.out.println("\n");
        System.out.println("First Repeated character in the string");

        Character res2 = input.chars().mapToObj(s -> Character.toLowerCase((char) s)).collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting())).entrySet().stream().
                filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst().orElse(null);
        System.out.println(res2);

        System.out.println("\n");
        System.out.println("Flat Map Demo");

        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        innerList.add(2);
        innerList.add(3);
        listOfLists.add(innerList);
        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(100);
        innerList2.add(101);
        innerList2.add(102);
        listOfLists.add(innerList2);

        System.out.println(listOfLists);

        listOfLists.stream().flatMap(i -> i.stream()).collect(Collectors.toList()).forEach(System.out::println);
    }
}
