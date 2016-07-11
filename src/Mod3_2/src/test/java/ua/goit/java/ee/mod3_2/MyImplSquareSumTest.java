package ua.goit.java.ee.mod3_2;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.goit.java.ee.mod3_2.api.SquareSum;


/**
 * Created by Chucky on 11.07.2016.
 */
public class MyImplSquareSumTest {

    private SquareSum squareSum =  new MyImplSquareSum();
    private int[] test = {2, 3, 4, 5, 6};
    private int[] test2 = {Integer.MAX_VALUE};


    @Test
    public void testGetSquareSum() throws Exception {
        Assert.assertEquals(90, squareSum.getSquareSum(test, 2));
        System.out.println();
        Assert.assertEquals(90, squareSum.getSquareSum(test, 3));
        System.out.println();
        Assert.assertEquals(4611686014132420609L, squareSum.getSquareSum(test2, 3));
    }
}
