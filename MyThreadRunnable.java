package multithreading;

//class Hii implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("Hi");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//            }
//        }
//    }
//}

//class Helloo implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("Hello");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//            }
//        }
//    }
//}


public class MyThreadRunnable {

    public static void main(String[] args) {

        Runnable obj1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        };
        Runnable obj2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.setName("1st thread");
        t2.setName("2nd thread");

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        /*
         1, 5, 10
         */
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        t2.start();



    }
}
