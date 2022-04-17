package epam.advanced.practice4;

public class Part3 {
    private int counter = 0;
    private int counter2 = 0;

    public void compare() {
        System.out.println(counter > counter2 ? "first" : "second");
        counter++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter2++;
    }

    private final Object lockObject = new Object();

    public void compareSync() {
        synchronized (lockObject) {
            compare();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        System.out.println("NonSynchronized");
        runTaskNonSync(threadCount);

        System.out.println("Synchronized");
        runTaskSync(threadCount);
    }

    private static void runTaskNonSync(int threadCount) throws InterruptedException {
        Part3 counter = new Part3();
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(counter::compare);
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }
    }

    private static void runTaskSync(int threadCount) throws InterruptedException {
        Part3 counter = new Part3();
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(counter::compareSync);
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }
    }
}
