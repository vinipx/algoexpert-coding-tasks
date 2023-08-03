package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoNumberSumTest {
    /*
     * Write a private method that takes in a non-empty array of distinct integers and an integer
     * representing a target sum.
     *
     * Conditions:
     * 1. If any two numbers sum up to the target sum -> returns an array in any order.
     * 2. If no two numbers sum up to the target sum -> returns an empty array.
     *
     * Constraints:
     * 1. Sum should be obtained by summing two different integers in the array.
     * 2. You can't add a single integer to itself in order to obtain the target sum
     *
     * Samples:
     * {3, 5, -4, 8, 11, 1, -1, 6}   ->  10
     * {1, 2, 3, 4, 5, 6, 7, 8, 9}   ->  17
     */

    private int[] calculateSum(int[] array, int targetSum) {
        Set<Integer> containsSet = new HashSet<>();
        for (int i : array) {
            if (containsSet.contains(targetSum - i)) {
                return new int[] { targetSum - i, i };
            }
            containsSet.add(i);
        }
        return new int[0];
    }

    @Test
    public void unsortedWithNegativesArrayTest() {
        int[] array = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int[] ints = calculateSum(array, 10);
        System.out.println(Arrays.toString(ints));
        Assert.assertEquals(ints, new int[] {11, -1});
    }

    @Test
    public void sortedWithPositivesArrayTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints = calculateSum(array, 17);
        System.out.println(Arrays.toString(ints));
        Assert.assertEquals(ints, new int[] {8, 9});
    }
}
