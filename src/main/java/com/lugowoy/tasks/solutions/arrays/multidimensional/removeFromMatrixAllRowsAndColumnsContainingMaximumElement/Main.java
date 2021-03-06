package com.lugowoy.tasks.solutions.arrays.multidimensional.removeFromMatrixAllRowsAndColumnsContainingMaximumElement;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Find the maximum element(s) in the matrix and remove from the matrix all the
 * rows and columns containing it.
 *
 * <p>Created by Konstantin Lugowoy on 31.10.2018.
 */
public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, BOUND));

        System.out.println("Matrix : \n" + matrix + "\n");

        IndexMaximumMatrixElement indexMax = new IndexMaximumMatrixElement(matrix);
        indexMax.setIndexesMatrixRowAndColumn();

        Helper.EXECUTOR.execute(
                () -> removeFromMatrixAllRowsAndColumnsContainingMaximumElement(
                        matrix, indexMax.indexMaxElementMatrixRow,
                        indexMax.indexMaxElementMatrixColumn),
                new OutputExecutionResultToConsole(), Helper.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts removeFromMatrixAllRowsAndColumnsContainingMaximumElement(
            @NotNull final MatrixInts matrix, final int indexMatrixRow,
            final int indexMatrixColumn) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int[][] tmpInts = new int[matrix.getRows() - 1][matrix.getColumns() - 1];
        int row = 0;
        for (int i = 0; i < matrix.getRows() - 1; i++) {
            if (i > indexMatrixRow - 1) {
                row = 1;
            }
            int column = 0;
            for (int j = 0; j < matrix.getColumns() - 1; j++) {
                if (j > indexMatrixColumn - 1) {
                    column = 1;
                }
                tmpInts[i][j] = matrix.getElement(i + row, j + column);
            }
        }
        matrix.setMatrix(tmpInts);
        return matrix;
    }

    private static class IndexMaximumMatrixElement {

        private MatrixInts matrix;

        private int indexMaxElementMatrixRow;
        private int indexMaxElementMatrixColumn;

        private IndexMaximumMatrixElement(MatrixInts matrix) {
            this.matrix = matrix;
        }

        private void setIndexesMatrixRowAndColumn() {
            int resultMaxElement = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    int elementOfMatrix = matrix.getElement(i, j);
                    if (elementOfMatrix > resultMaxElement) {
                        this.indexMaxElementMatrixRow = i;
                        this.indexMaxElementMatrixColumn = j;
                        resultMaxElement = elementOfMatrix;
                    }
                }
            }
        }

    }

}
