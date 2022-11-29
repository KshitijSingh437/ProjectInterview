package interviewQues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Laptop> list = new ArrayList<>();
        list.add(new Laptop("Dell", 16, 800));
        list.add(new Laptop("Apple", 8, 1200));
        list.add(new Laptop("Acer", 12, 700));

        //Collections.sort(list); --> this will not work

        Collections.sort(list); // now it will work since laptop class extends now Comparable interface.
        System.out.println(list);

        /*
            If we don't want to implement interfaces or, we want our own custom
             logic for sorting for other variables --> comparator
         */

        Comparator<Laptop> com = (lap1, lap2) -> {
            if (lap1.getRam() > lap2.getRam()) {
                return 1;
            } else if (lap1.getRam() < lap2.getRam()) {
                return -1;
            }
            return 0;
        };

       // list.stream().sorted(Collections.reverseOrder(Comparator.comparingInt(Laptop::getRam))).forEach(System.out::println);
        list.sort(com);
        System.out.println(list);

    }
}
