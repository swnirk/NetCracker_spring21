public class MyThreads {

    private int i = 0;

    public synchronized int increment() {
        while (i <= 100) {
            System.out.println("Now i = " + i);
            i++;
        }
        return i;
    }
    public static void main(String[] args) {

        MyThreads inc = new MyThreads();
        Thread thread1 = new Thread(String.valueOf(inc.increment()));
        thread1.start();
        Thread thread2 = new Thread(String.valueOf(inc.increment()));
        thread2.start();

    }
}
