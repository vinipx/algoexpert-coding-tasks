package easy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortedSquaredArrayTest {
    /*
     * Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns
     * a new array of the same length with the squares of the original integers also sorted in ascending order.
     *
     * Samples:
     * {1, 2, 3, 5, 6, 8, 9}    -> {1, 4, 9, 25, 36, 64, 81}
     * {-5, -4, -3, -2, -1}     -> {1, 4, 9, 16, 25}
     * {-10, -5, 0, 5, 10}      -> {0, 25, 25, 100, 100}
     */

    private int[] sortedSquaredArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int index = array.length - 1;
        int[] resultArray = new int[array.length];
        while (left <= right) {
            int resultLeft = array[left] * array[left];
            int resultRight = array[right] * array[right];
            if (resultLeft <= resultRight) {
                resultArray[index] = resultRight;
                index--;
                right--;
            } else {
                resultArray[index] = resultLeft;
                index--;
                left++;
            }
        }
        return resultArray;
    }

    @Test(dataProvider = "dataProvider")
    public void sortAscendingSquaredArrayTest(int[] sample, int[] result) {
        int[] sortedArray = sortedSquaredArray(sample);
        Assert.assertEquals(sortedArray, result);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][] {
            { new int[] { 1, 2, 3, 5, 6, 8, 9 }, new int[] { 1, 4, 9, 25, 36, 64, 81 } },
            { new int[] { -5, -4, -3, -2, -1 }, new int[] { 1, 4, 9, 16, 25 } },
            { new int[] { -10, -5, 0, 5, 10 }, new int[] { 0, 25, 25, 100, 100 } },
        };
    }
}
