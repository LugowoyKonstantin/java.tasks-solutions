package com.lugowoy.tasks.solutions.arrays.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 27.05.2018.
 */
@FunctionalInterface
public interface Determinant {

    boolean determine(Array<Subject> subjectArray);

    static boolean determineEquilibriumBetweenWeightOfSubjects(Array<Subject> subjectArray) {
        double sumWeightOfAllSubjects = calculateSumAllSubjects(subjectArray);
        boolean resultCheck = false;
        if ((sumWeightOfAllSubjects % 2) == 0) {
            resultCheck = true;
        }
        return resultCheck;
    }

    private static int calculateSumAllSubjects(Array<Subject> subjectArray) {
        int resultSum = 0;
        for (int i = 0; i < subjectArray.size(); i++) {
            resultSum += subjectArray.get(i).getWeight();
        }
        return resultSum;
    }

}
