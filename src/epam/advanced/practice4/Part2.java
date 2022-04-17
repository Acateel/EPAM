package epam.advanced.practice4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) throws InterruptedException {
        InputStream defaultThread = System.in;
        System.setIn(new MyInputStream());

        Thread spamThread = new Thread(){
            public void run(){
                Spam.main(null);
            }
        };
        spamThread.start();
        spamThread.join();

        System.setIn(defaultThread);
    }
    private static class MyInputStream extends InputStream{
        boolean firstStart = true;
        byte[] enter = "\n".getBytes(StandardCharsets.UTF_8);
        int index = -1;
        @Override
        public int read() throws IOException {
            if(firstStart) {
                firstStart = false;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 10; // \n in utf-8
            }
            return -1;
        }
    }
}
