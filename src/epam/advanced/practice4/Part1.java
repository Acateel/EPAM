package epam.advanced.practice4;

import java.lang.Thread;

public class Part1 {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                System.out.println(getName());
                try {
                    sleep(1000/3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    private static class MyRun implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000/3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread first = new MyThread();
        Thread second = new Thread(new MyRun());
        System.out.println("First");
        first.start();
        first.join();
        System.out.println("Second");
        second.start();

    }
}
