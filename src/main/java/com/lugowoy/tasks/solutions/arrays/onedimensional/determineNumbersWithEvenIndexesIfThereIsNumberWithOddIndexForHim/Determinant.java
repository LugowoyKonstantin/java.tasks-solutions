package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndexForHim;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/**
 * Created by Konstantin Lugowoy on 07.05.2018.
 */
@FunctionalInterface
public interface Determinant {

    void determine(ArrayInts array);

    static void determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndexForHim(ArrayInts array) {
        int counterOfResult = 0;
        for (int i = 0; i < array.size(); i++) {
            if (checkEvenIndex(i)) {
                for (int j = 0; j < array.size(); j++) {
                    if (checkOddIndex(j) && checkIndexesNotEqual(i, j)) {
                        if (array.get(i) == (array.get(j))) {
                            System.out.printf("The number %d with even index %d is equal to the number %d with an odd index of %d.\n",
                                    array.get(i), i, array.get(j), j);
                            counterOfResult++;
                        }
                    }
                }
            }
        }
        if (counterOfResult == 0) {
            System.out.println("No numbers match the condition.");
        }
    }

    private static boolean checkEvenIndex(int i) {
        return i % 2 == 0;
    }

    private static boolean checkOddIndex(int j) {
        return (j == 0) || (j % 2 != 0);
    }

    private static boolean checkIndexesNotEqual(int i, int j) {
        return j != i;
    }

}
