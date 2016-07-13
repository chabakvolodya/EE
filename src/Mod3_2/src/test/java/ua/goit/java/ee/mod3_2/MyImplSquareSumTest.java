package ua.goit.java.ee.mod3_2;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.goit.java.ee.mod3_2.api.SquareSum;


/**
 * Created by Chucky on 11.07.2016.
 */
public class MyImplSquareSumTest {

    private SquareSum squareSum =  new MyImplSquareSum();

    @Test
    public void testGetSquareSum() throws Exception {
        int[] test = {2, 3, 4, 5, 6};
        int[] test2 = {45, 0, 84, 32, 17};

        Assert.assertEquals(90, squareSum.getSquareSum(test, 2), "VALUE = {2, 3, 4, 5, 6}");
        System.out.println();
        Assert.assertEquals(10394, squareSum.getSquareSum(test2, 3), "VALUE = {45, 0, 84, 32, 17}");
        System.out.println();
    }

    @Test
    public void testNumberOfThreadsMoreSizeArray() throws Exception {
        int[] test = {4, 3, 8, 5, 6};
        Assert.assertEquals(150, squareSum.getSquareSum(test, 10), "Number Of Threads More Size Array");
    }

    @Test
    public void testMaxInteger() throws Exception {
        int[] test = {Integer.MAX_VALUE};
        Assert.assertEquals(4611686014132420609L, squareSum.getSquareSum(test, 1), "MaxInteger");
    }

    @Test
    public void testZero() throws Exception {
        int[] test = {0, 0, 4, 5, 0};
        int[] test2 = {0, 0, 0, 0, 0};

        Assert.assertEquals(41, squareSum.getSquareSum(test, 2), "ZERO = {0, 0, 4, 5, 0}");
        Assert.assertEquals(0, squareSum.getSquareSum(test2, 3), "FULL ZERO = {0, 0, 0, 0, 0}");
    }

    @Test
    public void testNegativeNumbers() throws Exception {
        int[] test = {-2, -3, -4, -5, -6};
        int[] test2 = {-45, 0, -84, 32, 17};

        Assert.assertEquals(90, squareSum.getSquareSum(test, 2), "ZERO = {-2, -3, -4, -5, -6}");
        Assert.assertEquals(10394, squareSum.getSquareSum(test2, 3), "FULL ZERO = {-45, 0, -84, 32, 17}");
    }

}
