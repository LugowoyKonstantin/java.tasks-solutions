package com.lugowoy.tasks.solutions.core.printAllThreeDigitNumbersThatDoNotHaveSameDigits;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Output all three-digit numbers, in the decimal notation of which there are no identical digits.
 * <p>
 * Created by Konstantin Lugowoy on 13.07.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray));

        System.out.println("Numbers : " + array);
        System.out.println();

        Array<Integer> resultArray = getAllThreeDigitNumbersThatDoNotHaveSameDigits(array);
        if (resultArray.size() > 0) {
            System.out.println("Result numbers : " + resultArray);
        } else {
            System.out.println("No numbers are found that satisfy the condition.");
        }

    }

    private static Array<Integer> getAllThreeDigitNumbersThatDoNotHaveSameDigits(Array<Integer> array) {
        Array<Integer> resultArray = new Array<>(0);
        for (int i = 0; i < array.size(); i++) {
            String stringOfValue = Integer.toString(array.get(i));
            if ((stringOfValue.startsWith("-") && (stringOfValue.length() == 4)) || (stringOfValue.matches("\\d{3}"))) {
                int tmpValue = array.get(i);
                int firstDigit = tmpValue % 10;
                tmpValue /= 10;
                int secondDigit = tmpValue % 10;
                int thirdDigit = tmpValue / 10;
                if (!((firstDigit == secondDigit) || (secondDigit == thirdDigit) || (thirdDigit == firstDigit))) {
                    resultArray.add(array.get(i));
                }
            }
        }
        return resultArray;
    }

}
