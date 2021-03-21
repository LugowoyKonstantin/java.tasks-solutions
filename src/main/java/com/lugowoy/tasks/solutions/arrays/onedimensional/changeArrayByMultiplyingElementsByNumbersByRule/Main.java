package com.lugowoy.tasks.solutions.arrays.onedimensional.changeArrayByMultiplyingElementsByNumbersByRule;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given integers a1, a2, ..., an. It is required to multiply all the terms of
 * the sequence a1, a2, ... by the square of its smallest term, if ak ≥ 0, and
 * the square of its largest term, if ak ≤ 0.
 *
 * <p>Created by Konstantin Lugowoy on 25.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in, System.out,
                                                 ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Array : " + array + "\n");

        new Executor().execute(() -> {
            DeterminantElementArray<ArrayInts> determinant =
                    DeterminantElementArray::determineMinElement;
            int minValue = determinant.determine(array);

            determinant = DeterminantElementArray::determineMaxElement;
            int maxValue = determinant.determine(array);

            MultiplyingArrayElements<ArrayInts, Integer> multiply =
                    MultiplyingArrayElements::multiplyElementsBySquareMinOrMaxValue;
            multiply.multiply(array, minValue, maxValue);

            System.out.println("Result array : " + array);
        }, new OutputExecutionTimeToConsole());

    }

}
