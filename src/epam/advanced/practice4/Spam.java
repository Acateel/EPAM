package epam.advanced.practice4;

import java.util.Objects;
import java.util.Scanner;

public class Spam {
    private Thread[] threads;

    public Spam(String[] messages, int[] intervals) {
        threads = new Thread[messages.length];
        for (int i = 0; i < messages.length; i++) {
            threads[i] = new Worker(messages[i], intervals[i]);
        }
    }

    public void start() {
        for (var thread : threads) {
            thread.start();
        }
    }

    public void stop() {
        for (var thread : threads) {
            thread.stop();
        }
    }

    private static class Worker extends Thread {
        String message;
        int interval;

        public Worker(String message, int interval) {
            this.message = message;
            this.interval = interval;
        }

        @Override
        public void run() {
            try {
                sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        String[] messages = new String[]{"first", "second", "third", "fourth"};
        int[] intervals = new int[]{100, 1000, 500, 2500};
        Spam spam = new Spam(messages, intervals);
        spam.start();
        String command = new Scanner(System.in).nextLine();
        if(Objects.equals(command, "")){
            spam.stop();
        }
    }
}
