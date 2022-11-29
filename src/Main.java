import DeadLock.FirstDeadLock;
import DeadLock.SecondDeadLock;
import Lock.WorkWithLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        FirstDeadLock firstDeadLock = new FirstDeadLock();
        SecondDeadLock secondDeadLock = new SecondDeadLock();
        firstDeadLock.setSecondDeadLock(secondDeadLock);
        secondDeadLock.setFirstDeadLock(firstDeadLock);

        Thread firstThread = new Thread(() -> System.out.println(firstDeadLock.getStringFromSecondDeadLock()));
        Thread secondThread = new Thread(() -> System.out.println(secondDeadLock.getStringFromFirstClass()));
        firstThread.start();
        secondThread.start();
        lock();
        getDecrementValue();

    }

    public static synchronized void getDecrementValue() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                Thread thread = new Thread(() -> {
                    atomicCounter.incrementAndGet();
                });
                thread.start();
            }
        });
        Thread.sleep(3000);
        System.out.println("Atomic: " + atomicCounter.get());
        executorService.shutdownNow();
    }

    public static void lock() {
        WorkWithLock workWithLock = new WorkWithLock();

        Thread thread = new Thread((() -> {
            workWithLock.manSay();
            workWithLock.womanSay();
            workWithLock.babySay();
        }));
        thread.start();
    }
}