package com.verbitsky.task1.validator.datavalidator.impl;

import com.verbitsky.task1.validator.datavalidator.FigureDataValidator;

public class TetrahedronDataValidator implements FigureDataValidator {
//todo Написать регулярку
    private static final String COORDINATE_REGEX = "111";
    //private static final int CORRECT_COORDINATES_COUNT = 12;

    @Override
    public boolean validateData(String line) {
        boolean result = line.matches(COORDINATE_REGEX);
        if (!result) {
            //todo write log

        }
        return result;
    }
}
