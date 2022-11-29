package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WorkWithLock {
    Lock lock = new ReentrantLock();

    public void manSay() {
        lock.lock();
        for (int i = 0; i < 2; i++) {
            System.out.println("Hello everyone");
        }
    }

    public void womanSay() {
        lock.lock();
        for (int i = 0; i < 2; i++) {
            System.out.println("Hello, today is nice day");
        }
    }

    public void babySay() {
        for (int i = 0; i < 2; i++) {
            System.out.println("I need a toy");
        }
        lock.unlock();
    }
}
