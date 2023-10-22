package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class Task16 implements Task {

    @Override
    public void run() {
        System.out.println("\n16.Сгенерируйте миллион рандомных чисел и посчитайте их сумму используя parallelStream с двумя потоками.\n");
        long number = 1000000;

        final int parallelism = 2;
        ForkJoinPool forkJoinPool = null;
        try {
            forkJoinPool = new ForkJoinPool(parallelism);
            final Long sum = forkJoinPool.submit(() ->
                    LongStream.generate(() -> ThreadLocalRandom.current().nextLong())
                            .limit(number)
                            .parallel()
                            .sum()
            ).get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            if (forkJoinPool != null) {
                forkJoinPool.shutdown();
            }
        }
    }
}
