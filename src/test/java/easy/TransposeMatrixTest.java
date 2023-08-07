package easy;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TransposeMatrixTest {
    /*
     * Given a 2D array of integers called Matrix, write a function that returns the transpose of the matrix.
     *
     * Samples:
     * [
     * [1, 2, 3]
     * ]
     *
     * Result:
     * [
     * [1],
     * [2],
     * [3]
     * ]
     */

    private int[][] transposeMatrix(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int[][] newMatrix = new int[columnSize][rowSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    @Test
    public void transposeMatrixTest() {
        int[][] matrix = { { 1, 2, 3 } };
        int[][] newMatrix = transposeMatrix(matrix);
        int[][] resultMatrix = { { 1 }, { 2 }, { 3 } };

        System.out.println("Matrix " + Arrays.deepToString(matrix) + "\n" + "New Matrix " + Arrays.deepToString(newMatrix) + "\n" + "Result Matrix " + Arrays.deepToString(resultMatrix));
        Assert.assertEquals(resultMatrix, newMatrix);
    }

}
