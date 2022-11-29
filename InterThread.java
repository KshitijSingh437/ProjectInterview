package multithreading;

class A {

    int num;
    boolean value = false;

    public void getNum() {
        while (!value) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Get : " + num);
        value = false;
        notify();
    }

    public void setNum(int num) {
        while (value) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Set : " + num);
        this.num = num;
        value = true;
        notify();
    }
}

class Producer implements Runnable {

    A aObj;

    Producer(A a) {
        this.aObj = a;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    @Override
    public void run() {

        int i = 0;

        while (true) {
            aObj.setNum(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
    }

}

class Consumer implements Runnable {

    A aObj;

    Consumer(A a) {
        this.aObj = a;
        Thread t = new Thread(this, "Consumer");
        t.start();

    }

    @Override
    public void run() {
        while (true) {
            aObj.getNum();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class InterThread {

    public static void main(String[] args) {

        A a = new A();
        new Producer(a);
        new Consumer(a);


    }
}


