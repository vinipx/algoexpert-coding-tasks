package easy;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NonConstructibleChangeTest {
    /*
     * Given an array of positive integers representing the values of coins in your possession,
     * write a function that returns the minimum amount of change (the minimum sum of money)
     * that you CANNOT create.
     * The given coins can have any positive integer value and aren't necessarily unique.
     *
     * Samples:
     * {5, 7, 1, 1, 2, 3, 22} -> 20
     */

    private int getMinimumChange(int[] coins) {
        int min = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > min) {
                break;
            }
            min += coin;
        }
        return min;
    }

    @Test
    public void findNonConstructibleChangeTest() {
        int[] array = { 5, 7, 1, 1, 2, 3, 22 };
        int minimumChange = getMinimumChange(array);
        Assert.assertEquals(minimumChange, 20);
    }

}
