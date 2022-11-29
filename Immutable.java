package interviewQues;

import java.util.HashMap;
import java.util.Map;

public final class Immutable {

    private final String name;
    private final int rollNo;
    private final Map<String, String> map;

    public Immutable(String name, int rollNo, Map<String, String> map) {
        this.name = name;
        this.rollNo = rollNo;
        Map<String, String> tempMap = new HashMap<>();
        // Collections perform the deep copy.
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.map = tempMap;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        // returning the copy object reference not the actual object reference.
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }

}

class Tester {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("FIRST", "1");
        map.put("SECOND", "2");

        String name = "Navin";
        int rollNo = 111;

        Immutable test = new Immutable(name, rollNo, map);

        System.out.println(test.getName());
        System.out.println(test.getRollNo());
        System.out.println(test.getMap());

        // Constructor break
        map.put("THIRD", "3");
        System.out.println(test.getMap());

        // getter break
        test.getMap().put("FOURTH", "4");
        System.out.println(test.getMap());


    }
}