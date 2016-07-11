package ua.goit.java.ee.mod3_2;

import ua.goit.java.ee.mod3_2.api.SquareSum;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Chucky on 23.06.2016.
 */
public class MyImplSquareSum implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        if (values.length < numberOfThreads)
            numberOfThreads = values.length;

        Phaser phaser = new Phaser(1);
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<SquareSumPart> partResults = new ArrayList<>();

        int remainder = values.length % numberOfThreads;
        int defaultSize = values.length / numberOfThreads;
        int cursor = 0;

        for (int i = 0; i < numberOfThreads; i++) {

            int size = (remainder-- > 0)? defaultSize + 1 : defaultSize;

            SquareSumPart part = new SquareSumPart(phaser, values, cursor, cursor + size);
            executor.execute(part);
            partResults.add(part);
            cursor += size;
        }

        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
        executor.shutdown();

        long results = 0;

        for (SquareSumPart part : partResults) {
            System.out.println("Result thread: " + part.getResult());
            results += part.getResult();
        }

        return results;
    }

    public static class SquareSumPart implements Runnable {

        private int startIndex;
        private int partLength;
        private int[] array;
        private long result;
        private Phaser phaser;

        public SquareSumPart(Phaser p, int[] array, int startIndex, int partLength) {
            this.phaser = p;
            this.startIndex = startIndex;
            this.partLength = partLength;
            this.array = array;
            phaser.register();
        }

        @Override
        public void run() {

            for (int i = startIndex; i < partLength; i++) {
                result += Long.valueOf(array[i]) * array[i];
                startIndex += partLength;
            }

            phaser.arriveAndAwaitAdvance();
        }

        public long getResult() {
            phaser.arriveAndDeregister();

            return result;
        }
    }
}