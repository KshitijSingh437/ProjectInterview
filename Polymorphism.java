package interviewQues;

/*
    1. Compile Time ---> STATIC ---> METHOD OVERLOADING
    2. Run time  ---> DYNAMIC DISPATCH ---> METHOD OVERRIDING
 */

class Parent {

    static void Print() {
        System.out.println("parent class");
    }
}

class subclass1 extends Parent {

    static void Print() {
        System.out.println("subclass1");
    }
}

class subclass2 extends Parent {

   static void Print() {
        System.out.println("subclass2");
    }
}


public class Polymorphism {

    static int Multiply(int a, int b) {
        return a * b;
    }

    static int Multiply(int a, int b, int c) {
        return a * b * c;
    }

    static double Multiply(double a, double b) {
        return a * b;
    }

    static void res(String obj) {
        System.out.println("I AM STRING");
    }

    static void res(Object obj) {
        System.out.println("I AM OBJECT");
    }

    public static void main(String[] args) {
        System.out.println(Polymorphism.Multiply(2, 4));
        System.out.println(Polymorphism.Multiply(2, 4, 6));
        System.out.println(Polymorphism.Multiply(5.5, 6.3));

        Polymorphism.res(null);

        Parent a;

        a = new subclass1();
        a.Print();


    }
}
