package com.lugowoy.tasks.solutions.arrays.onedimensional.determineLeastCommonMultipleOfArrayOfNumbers;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/**
 * Created by Konstantin Lugowoy on 09.05.2018.
 */
@FunctionalInterface
public interface DeterminantLeastCommonMultiple {

    int determine(ArrayInts array);

    static int determineLeastCommonMultiple(ArrayInts array) {
        int resultValueOfLeastCommonMultiple = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            resultValueOfLeastCommonMultiple = calculateLeastCommonMultipleOfTwoNumbers(array, resultValueOfLeastCommonMultiple, i);
        }
        return Math.abs(resultValueOfLeastCommonMultiple);
    }

    private static int calculateLeastCommonMultipleOfTwoNumbers(ArrayInts array, int resultValueOfLeastCommonMultiple, int i) {
        return resultValueOfLeastCommonMultiple * array.get(i)
                           / calculateGreatestCommonDivisorOfTwoNumbers(resultValueOfLeastCommonMultiple, array.get(i));
    }

    private static int calculateGreatestCommonDivisorOfTwoNumbers(int firstNumber, int secondNumber) {
        int resultValueOfGCD = 0;
        int moduleOfFirstNumber = Math.abs(firstNumber), moduleOfSecondNumber = Math.abs(secondNumber);
        while ((moduleOfFirstNumber != 0) && (moduleOfSecondNumber != 0)) {
            int tmp = moduleOfFirstNumber % moduleOfSecondNumber;
            moduleOfFirstNumber = moduleOfSecondNumber;
            moduleOfSecondNumber = tmp;
            resultValueOfGCD = moduleOfFirstNumber;
        }
        return resultValueOfGCD;
    }

}
