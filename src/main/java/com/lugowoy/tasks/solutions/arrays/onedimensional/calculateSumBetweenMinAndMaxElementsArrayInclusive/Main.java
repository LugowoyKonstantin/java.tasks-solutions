package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumBetweenMinAndMaxElementsArrayInclusive;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Calculate the sum of array elements located between the minimum and maximum
 * elements inclusive.
 *
 * <p>Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final String RESULT_SUM_BETWEEN_MIN_AND_MAX_ELEMENTS =
            "Sum of array elements between the min and max elements inclusive is : %d";

    public static void main(String[] args) {

        int lengthArray = Helper.readConsoleArrayLength(Helper.INPUT_LENGTH_ARRAY,
                                                        Capacity.UPPER.get());

        ArrayInts array = new ArrayInts(new HelperFiller().getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFiller.INT_NEGATIVE_TEN, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Original array : " + array + "\n");

        Helper.EXECUTOR.execute(() -> {

        DeterminantArrayElementIndex determinant =
                DeterminantArrayElementIndex::determineMinElementIndex;
        int indexMinElement = determinant.determineArrayElementIndex(array);
        System.out.println("Index min element in the array is : " + indexMinElement);

        determinant = DeterminantArrayElementIndex::determineMaxElementIndex;
        int indexMaxElement = determinant.determineArrayElementIndex(array);
        System.out.println("Index max element in the array is : " + indexMaxElement);

        CalculationSumBetweenElementsArray calc = new CalculationSumBetweenElementsArray();
        int resultSum = calc.calculateSumBetweenMinAndMaxInclusive(array,
                                                                   indexMinElement,
                                                                   indexMaxElement);

        System.out.printf(RESULT_SUM_BETWEEN_MIN_AND_MAX_ELEMENTS, resultSum);

        }, new OutputExecutionTimeToConsole());

    }

}