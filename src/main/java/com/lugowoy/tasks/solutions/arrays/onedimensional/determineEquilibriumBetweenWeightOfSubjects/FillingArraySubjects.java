package com.lugowoy.tasks.solutions.arrays.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.tasks.solutions.arrays.onedimensional.determineEquilibriumBetweenWeightOfSubjects.Subject;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 27.05.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 *  with data of the object of the {@link Subject} class type.
 *
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 */
public class FillingArraySubjects implements FillingArray<Subject> {

    private Array<Integer> numbersArray;

    /**
     * Constructs a new object of {@link FillingArraySubjects} class, initializing the object with an array of integers.
     *  The values of the integer array are used to initialize the objects of the {@link Subject} class.
     *
     * @param numbersArray An array with integer values.
     * */
    public FillingArraySubjects(Array<Integer> numbersArray) {
        this.numbersArray = numbersArray;
    }

    /**
     * Fills an object of the {@link Array} class with data of the object of the {@link Subject} class.
     *
     * @param array The object of the {@link Array} class to be filled with data of the object of the {@link Subject} class.
     *
     * @throws IllegalArgumentException If object of the {@link Array} class argument is null.
     * */
    @Override
    public void fill(Array<Subject> array) {
        if (CheckerArray.checkLengthInArray(array)) {
            Subject[] subjects = new Subject[array.size()];
            this.initializeArrayElements(subjects, this.numbersArray);
            array.setArray(subjects);
        }
    }

    /**
     * Fills an array with data of the object of the {@link Subject} class.
     *
     * @param subjects The array to be filled with data of the object {@link Subject} class.
     *
     * @throws IllegalArgumentException If the array argument is null.
     * */
    @Override
    public void fill(Subject[] subjects) {
        if (CheckerArray.checkLengthInArray(subjects)) {
            this.initializeArrayElements(subjects, this.numbersArray);
        }
    }

    /**
     * Fills an array with data of the object of the {@link Subject} class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the object of the {@link Subject} class type.
     *
     * @return Created and filled array with data of the object of the {@link Subject} class type.
     * */
    @Override
    public Subject[] fill(int lengthArray) {
        Subject[] subjects = null;
        if (CheckerArray.checkLengthArray(lengthArray)) {
            subjects = new Subject[lengthArray];
            this.initializeArrayElements(subjects, this.numbersArray);
        }
        return subjects;
    }

    private void initializeArrayElements(Subject[] subjectArray, Array<Integer> numbersArray) {
        int idCounter = 1;
        for (int i = 0; i < subjectArray.length; i++) {
            subjectArray[i] = new Subject(idCounter, numbersArray.get(i));
            idCounter++;
        }
    }

}
