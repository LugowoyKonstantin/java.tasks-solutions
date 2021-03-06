package com.lugowoy.tasks.solutions.arrays.onedimensional.createArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * There are zero elements in an integer array. Create an array of the index of these elements.
 * <p> Created by Konstantin Lugowoy on 12-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts originalIntegerArray = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Elements of of the original array : " + originalIntegerArray);
        System.out.println();

        ArrayInts integerArrayIndexZero = FILLING.fillArray(originalIntegerArray);

        System.out.print("Index of zero elements of the original array : ");
        if (integerArrayIndexZero.size() != 0) {
            for (int i = 0; i < integerArrayIndexZero.size(); i++) {
                System.out.print(integerArrayIndexZero.get(i) + " ");
            }
        } else {
            System.out.println("It does not contain zero elements.");
        }

    }

    private static final Filling FILLING = originalArray -> {
        ArrayInts tmpArray = new ArrayInts(0);
        if (CheckerArray.checkLengthInArray(originalArray)) {
            for (int i = 0; i < originalArray.size(); i++) {
                if (originalArray.get(i) == 0) {
                    tmpArray.add(i);
                }
            }
        }
        return tmpArray;
    };

}
