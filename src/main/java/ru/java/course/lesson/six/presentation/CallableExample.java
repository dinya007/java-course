package ru.java.course.lesson.six.presentation;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> futureResult = executorService.submit(new ThreadToReturn());

        String result = futureResult.get();
        System.out.println(result);
        executorService.shutdown();
    }

    private static class ThreadToReturn implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Do some work!");
            Thread.currentThread().sleep(1000L);
            return "result";
        }
    }

}
