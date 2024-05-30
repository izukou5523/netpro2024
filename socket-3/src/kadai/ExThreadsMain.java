package kadai;

public class ExThreadsMain {
    public static void main(String[] args) {
        final int numThreads = 5;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new WorkerThread(i + 1), "Thread-" + (i + 1));
            threads[i].start();
        }
    }

    static class WorkerThread implements Runnable {
        private int threadNumber;

        public WorkerThread(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        public void run() {
            System.out.println("Thread " + threadNumber + " is starting...");

            // Simulate some work
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + threadNumber + " is working... iteration " + (i + 1));
                try {
                    Thread.sleep(1000); // Simulating work for 1 second
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }

            System.out.println("Thread " + threadNumber + " has finished its work.");
        }
    }
}

