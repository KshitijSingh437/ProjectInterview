package interviewQues;

public class EvenOddUsingThread implements Runnable {

    static int i = 1;
    Object object;

    public EvenOddUsingThread(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {

        // System.out.println(Runtime.getRuntime().availableProcessors());

        Object obj = new Object();
        Runnable th1 = new EvenOddUsingThread(obj);
        Runnable th2 = new EvenOddUsingThread(obj);
        new Thread(th1, "even").start();
        new Thread(th2, "odd").start();


    }

    @Override
    public void run() {

        while (i <= 10) {
            if (i % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    i++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (i % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    i++;
                    object.notify();
                }
            }
        }

    }


}
