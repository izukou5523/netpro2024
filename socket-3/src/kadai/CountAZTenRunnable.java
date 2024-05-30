package kadai;

import java.util.concurrent.CountDownLatch;

public class CountAZTenRunnable implements Runnable {
    private char myChar;
    private int count;
    private CountDownLatch latch;

    public CountAZTenRunnable(char c, CountDownLatch latch) {
        this.myChar = c;
        this.count = 0;
        this.latch = latch;
    }

    public static void main(String[] args) {
        final int numThreads = 26;
        CountDownLatch latch = new CountDownLatch(1);
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            char c = (char) (97 + i);
            threads[i] = new Thread(new CountAZTenRunnable(c, latch), c + "-thread");
            threads[i].start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                latch.countDown(); // すべてのスレッドを1秒ごとに進行させる
                latch = new CountDownLatch(1); // 新しいラッチを作成
                Thread.sleep(1000); // 1秒間一時停止
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                latch.await(); // ラッチが0になるのを待つ
                count++;
                System.out.println(myChar + "" + count);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
