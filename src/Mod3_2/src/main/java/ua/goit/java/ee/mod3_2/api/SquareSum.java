package ua.goit.java.ee.mod3_2.api;

import java.util.concurrent.TimeoutException;

/**
 * Created by Chucky on 16.06.2016.
 */
public interface SquareSum {
    long getSquareSum(int[] values, int numberOfThreads) throws TimeoutException, InterruptedException;
}
