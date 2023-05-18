class MainThread {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        thread.setName("My Thread");
        System.out.println(thread);

        for(int i = 0; i < 5; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}