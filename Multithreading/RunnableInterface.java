class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.err.println("Thread Interrupted");
        }
    }
    
}

public class RunnableInterface {
    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();
    }
}
