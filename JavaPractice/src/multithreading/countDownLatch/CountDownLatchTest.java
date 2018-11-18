package multithreading.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

// CountDownLatch demo using practice example from Java Language Features Book
public class CountDownLatchTest {

    public static void main(String[] args) {
        // Create a countdown latch with 2 as its counter
        CountDownLatch latch = new CountDownLatch(2);
        // Create and start the main service
        LatchMainService ms = new LatchMainService(latch);
        ms.start();
        // Create and start two helper services
        for (int i = 1; i <= 2; i++) {
            LatchHelperService lhs = new LatchHelperService(i, latch);
            lhs.start();
        }
    }
}

class LatchMainService extends Thread {
    private final CountDownLatch latch;

    public LatchMainService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Main service is waiting for helper services to start...");
            latch.await();
            System.out.println("Main service has started...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LatchHelperService extends Thread {
    private final int ID;
    private final CountDownLatch latch;
    private final Random random = new Random();

    public LatchHelperService(int ID, CountDownLatch latch) {
        this.ID = ID;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            int startupTime = random.nextInt(30) + 1;
            System.out.println("Service #" + ID + " starting in "
                    + startupTime + " seconds...");
            Thread.sleep(startupTime * 1000);
            System.out.println("Service #" + ID + " has started...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Count down on the latch to indicate that it has started
            this.latch.countDown();
        }
    }
}