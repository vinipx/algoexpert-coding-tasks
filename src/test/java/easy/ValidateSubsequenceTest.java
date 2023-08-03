package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateSubsequenceTest {
    /*
     * Given two non-empty arrays of integers, write a function that determines whether the second array
     * is a subsequence of the first one.
     *
     * Conditions:
     * 1. A subsequence is a set of numbers that aren't necessarily adjacent but are in the same order
     *
     * Samples:
     * {5, 1, 22, 25, 6, -1, 8, 10} and {1, 6, -1, 10} -> true
     * {5, 1, 22, 25, 6, -1, 8, 10} and {5, 1, 22, 25, 6, -1, 8, 10} ->  true
     * {5, 1, 22, 25, 6, -1, 8, 10} and {22, 25, 6} ->  true
     * {5, 1, 22, 25, 6, -1, 8, 10} and {5, -1, 8, 10} ->  true
     */

    private boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrayPointerIndex = 0;
        int sequencePointerIndex = 0;
        while (arrayPointerIndex < array.size() && sequencePointerIndex < sequence.size()) {
            if (Objects.equals(array.get(arrayPointerIndex), sequence.get(sequencePointerIndex))) {
                sequencePointerIndex++;
            }
            arrayPointerIndex++;
        }
        return sequencePointerIndex == sequence.size();
    }

    @Test(dataProvider = "dataProvider")
    public void subsequenceTest(int[] sequence) {
        int[] array = { 5, 1, 22, 25, 6, -1, 8, 10 };
        List<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }
        List<Integer> sequenceList = new ArrayList<>();
        for (int i : sequence) {
            sequenceList.add(i);
        }
        Assert.assertTrue(isValidSubsequence(arrayList, sequenceList));
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][] { { 1, 6, -1, 10 }, { 5, 1, 22, 25, 6, -1, 8, 10 }, { 22, 25, 6 }, { 5, -1, 8, 10 } };
    }
}
