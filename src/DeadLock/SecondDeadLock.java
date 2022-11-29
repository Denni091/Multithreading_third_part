package DeadLock;

public class SecondDeadLock {

    private FirstDeadLock firstDeadLock;

    public FirstDeadLock getFirstDeadLock() {
        return firstDeadLock;
    }

    public void setFirstDeadLock(FirstDeadLock firstDeadLock) {
        this.firstDeadLock = firstDeadLock;
    }

    public synchronized String getStringSecondDeadLock() {
        return "Text from second class";
    }

    public synchronized String getStringFromFirstClass() {
        return firstDeadLock.getStringFirstDeadLock();
    }
}
