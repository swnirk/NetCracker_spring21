import java.util.concurrent.locks.Lock;

public class TwoThread {

    private int count = 0;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    //flag define what stream made: change or set count
    boolean countSet = false;

    //read count
    synchronized int get() throws InterruptedException {
        while (!countSet)
            wait();
        countSet = false;
        notify();
        return count;
    }

    //write count
    synchronized void put(int n) throws InterruptedException {
        while (countSet)
            wait();
        count = n;
        countSet = true;
        notify();
    }

    public void runA() throws InterruptedException {
        while (count != 5) {
            Thread.sleep(1000);
            count = get();
            System.out.println(Thread.currentThread().getName() + " is working: count = " + count);
        }
    }

    public void runB() throws InterruptedException {
        while (count != 6) {
            Thread.sleep(1000);
            count++;
            put(count);
            System.out.println(Thread.currentThread().getName() + " is working: count = " + count);
            if(count == 6)
                System.out.println("count > 5 -> Thread-A is stopped");
        }
    }

    public void methodA(int count) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-A");
        threadA.start();
    }

    public void methodB () throws InterruptedException {

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-B");
        threadB.start();
    }

    public static void main(String args[]) throws InterruptedException {

        TwoThread thread = new TwoThread();
        thread.methodA(thread.count);
        thread.methodB();
    }
}


