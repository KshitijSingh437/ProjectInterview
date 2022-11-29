package interviewQues;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        // Map is Interface    -- > HashMap is class implementation
        Map<String, String> number = new HashMap<>();
        number.put("Neha", "123456");
        number.put("Dia", "098765");
        number.put(null, "1234");


        /*
                1. HashMap is not thread safe and un-synchronized. Also allows one "null" key.
                2. HashTable is thread safe and synchronized. Does not allow null key.
                3. In LinkedHashMap insertion order is fixed.
         */

        for (Map.Entry<String, String> m : number.entrySet()) {
            System.out.println(m.getKey() + ": " + m.getValue());
        }

        //number.forEach((key, value) -> System.out.println(key + ": " + value));


    }
}
