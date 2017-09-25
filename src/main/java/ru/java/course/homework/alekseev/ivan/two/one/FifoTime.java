package ru.java.course.homework.alekseev.ivan.two.one;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

public class FifoTime extends Fifo {

    private LocalDateTime[] created = new LocalDateTime[0];

    private final long lifetime;
    private final TemporalUnit timeMeasure;

    public FifoTime(long lifetime, TemporalUnit timeMeasure) {
        this.lifetime = lifetime;
        this.timeMeasure = timeMeasure;
    }

    public void push(String element) {
        super.push(element);

        created = Arrays.copyOf(created, created.length + 1);
        created[created.length - 1] = LocalDateTime.now();
    }

    private LocalDateTime getFirstTime() {
        return created[0];
    }

    public String pull() {
        String str;

        do {

            str = super.pull();
            created = Arrays.copyOfRange(created, 1, created.length);

        } while (!this.isEmpty() && this.getFirstTime().plus(lifetime, timeMeasure).isBefore(LocalDateTime.now()));

        return str;
    }
}
