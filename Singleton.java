package interviewQues;

public class Singleton {
    private static Singleton instance = null;
    public String s;

    private Singleton() {
        s = "Hello I am a string part of Singleton class";
    }

    public static synchronized Singleton getInstance() {
        // To ensure only one instance is created
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

//    public static Singleton getInstance() {
//        if (instance == null) {
//            //synchronized block to remove overhead
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    // if instance is null, initialize
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
}

class Test {

    public static void main(String[] args) {
        // Instantiating Singleton class with variable x
        Singleton x = Singleton.getInstance();
        // Instantiating Singleton class with variable y
        Singleton y = Singleton.getInstance();
        // instantiating Singleton class with variable z
        Singleton z = Singleton.getInstance();
        // Now  changing variable of instance x
        // via toUpperCase() method
        x.s = (x.s).toUpperCase();

        // Print and display commands
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");

        // Now again changing variable of instance x
        z.s = (z.s).toLowerCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }
}