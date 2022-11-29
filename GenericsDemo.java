package interviewQues;

import java.util.ArrayList;

class Container<T extends Number> {

    T value;

    public void show() {
        System.out.println(value.getClass().getName());
    }

    public void show(ArrayList<? extends T> obj) {

    }
}

public class GenericsDemo {

    public static void main(String[] args) {

        Container<Number> con = new Container<>();
        con.value = 1;
        con.show();
        con.show(new ArrayList<Number>());

    }

}
