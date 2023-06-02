import java.util.*;

public class TimeoutManager {
    protected PriorityQueue<TimeoutItem> pq = new PriorityQueue<TimeoutItem>();
    protected MillisecondClock clock;

    public TimeoutManager(MillisecondClock clock) {
        this.clock = clock;
    }

    public PriorityQueue<TimeoutItem> getPriorityQueue() {
        return pq;
    }

    public void addTimeout(CallbackMethod callback, int delayBeforeCallback) {
        TimeoutItem timeoutItem = new TimeoutItem(callback, clock.getTime() + delayBeforeCallback);
        pq.add(timeoutItem);
    }

    public void update() {
        int currentTime = clock.getTime();
        while (!pq.isEmpty() && pq.peek().getCallbackTime() <= currentTime) {
            TimeoutItem timeoutItem = pq.poll();
            timeoutItem.callCallback();
        }
    }
}
