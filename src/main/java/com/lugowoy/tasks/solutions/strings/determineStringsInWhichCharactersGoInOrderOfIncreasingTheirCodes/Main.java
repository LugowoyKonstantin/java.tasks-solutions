package com.lugowoy.tasks.solutions.strings.determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Determine a string, the characters in which are in the strict order of increasing their codes.
 * If there are several such strings, find the first one.
 * <p> Created by LugowoyKonstantin on 27.09.2018.
 */
public class Main {

    private static final int LENGTH_STRING = 5;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<String> stringArray = new Array<>(new FillingArrayRandomValueStrings("english").fill(lengthOfArray, LENGTH_STRING));

        System.out.println("Strings in an array : " + stringArray);

        String resultString = determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes(stringArray);
        if (resultString.equals("")) {
            System.out.println("No strings matching the condition.");
        } else {
            System.out.println("Result : " + resultString);
            for (int i = 0; i < resultString.length(); i++) {
                System.out.print((int)resultString.charAt(i) + ", ");
            }
        }
    }

    private static String determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes(Array<String> stringArray) {
        String resultString = "";
        int codeOfCharValue = Integer.MIN_VALUE;
        if (CheckerArray.checkLengthInArray(stringArray)) {
            for (int i = 0; i < stringArray.size(); i++) {
                String strValue = stringArray.get(i);
                for (int j = 0; j < strValue.length(); j++) {
                    int codeOfCurrentChar = strValue.charAt(j);
                    if (codeOfCurrentChar > codeOfCharValue) {
                        codeOfCharValue = codeOfCurrentChar;
                        resultString = strValue;
                    } else {
                        resultString = "";
                        break;
                    }
                }
                if (!resultString.equals("")) {
                    break;
                } else {
                    codeOfCharValue = Integer.MIN_VALUE;
                }
            }
        }
        return resultString;
    }

}
