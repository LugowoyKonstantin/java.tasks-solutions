package com.lugowoy.tasks.solutions.core.printNumbersInDescendingOrderOfLength;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Sort and print the numbers in descending order of their lengths.
 * <p>
 * Created by Konstantin Lugowoy on 09.08.2018.
 */

public class Main {

    private static final int MAX_VALUE = 10000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray, MAX_VALUE));

        System.out.println("Numbers in an array : " + integerArray);

        printNumbersInDescendingOrdersOfLength(integerArray);

        System.out.println("Result : " + integerArray);

    }

    private static void printNumbersInDescendingOrdersOfLength(Array<Integer> integerArray) {
        boolean toSort = true;
        while (toSort) {
            toSort = false;
            for (int j = 0; j < integerArray.size() - 1; j++) {
                if (countDigitOfNumber(integerArray.get(j)) < countDigitOfNumber(integerArray.get(j + 1))) {
                    int tmp = integerArray.get(j + 1);
                    integerArray.set(j + 1, integerArray.get(j));
                    integerArray.set(j, tmp);
                    toSort = true;
                }
            }
        }
    }

    private static int countDigitOfNumber(int number) {
        int moduleOfNumber = Math.abs(number);
        int digitCount = 0;
        while (moduleOfNumber > 0) {
            moduleOfNumber /= 10;
            digitCount++;
        }
        return digitCount;
    }

}
