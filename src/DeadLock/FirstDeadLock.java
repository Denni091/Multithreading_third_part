package DeadLock;

public class FirstDeadLock {

    private SecondDeadLock secondDeadLock;

    public SecondDeadLock getSecondDeadLock() {
        return secondDeadLock;
    }

    public void setSecondDeadLock(SecondDeadLock secondDeadLock) {
        this.secondDeadLock = secondDeadLock;
    }

    public synchronized String getStringFirstDeadLock() {
        return "Text from first class";
    }

    public synchronized String getStringFromSecondDeadLock() {
        return secondDeadLock.getStringSecondDeadLock();
    }
}
