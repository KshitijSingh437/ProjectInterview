package multithreading;

class Hi extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Hello extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class MyThread {

    /*
        Main Thread
     */
    public static void main(String[] args) throws InterruptedException {
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        obj1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        obj2.start();

        obj1.join();
        obj2.join();

        System.out.println(obj1.isAlive());

        System.out.println("Bye");

    }


}
