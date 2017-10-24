package ru.java.course.lesson.seven.presentation;

import ru.java.course.lesson.six.presentation.ConcurrentUtil;

public class ProducerConsumerPresentation {

    public static void main(String[] args) throws InterruptedException {
        Queue<Object> queue = new Queue<>();
        ConcurrentUtil.shoot(() -> {
            queue.push(new Object());
            Object take = queue.take();
        }, 4, 3);

    }

}
