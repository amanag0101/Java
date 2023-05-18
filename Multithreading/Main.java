class Thread1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++)
            System.out.println("Thread1");
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++)
            System.out.println("Thread 2");
    }
}

class Thread3 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++)
            System.out.println("Thread 3");
    }
    
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread(new Thread3());

        t1.start();
        t1.join();
        t2.start();
        t3.start();
    }
}