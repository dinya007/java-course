package ru.java.course.homework.reznikova.elena.two.one;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class FIFOQueue2 extends FIFOQueue {
    ArrayList<LocalDateTime> timeQueue;
    private int timeLimit = 0;

    public FIFOQueue2() {
        super();
        this.timeQueue = new ArrayList<>();
    }

    public FIFOQueue2(int limit) {
        super();
        this.timeQueue = new ArrayList<>();
        this.timeLimit = limit;
    }

    @Override
    public void add(String newElement) {
        super.add(newElement);
        this.timeQueue.add(LocalDateTime.now());
    }

    @Override
    public String get() {
        String temp = "";
        LocalDateTime time;
        if (this.queue.size() == 0) {
            throw new NullPointerException("Очередь пуста!");
        } else {
            Iterator<String> iterText = this.queue.iterator();
            Iterator<LocalDateTime> iterTime = this.timeQueue.iterator();
            while (iterText.hasNext()) {
                temp = iterText.next();
                time = iterTime.next();
                iterText.remove();
                iterTime.remove();
                if (LocalDateTime.now().minus(this.timeLimit, ChronoUnit.MINUTES).isBefore(time)) {
                    break;
                }
            }
        }
        if (this.queue.size() == 0) {
            throw new NullPointerException("Очередь пуста!");
        }
        return temp;
    }

}
