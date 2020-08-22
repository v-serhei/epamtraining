package com.verbitsky.task1.validator.datavalidator.impl;

import com.verbitsky.task1.validator.datavalidator.FigureDataValidator;

public class TetrahedronDataValidator implements FigureDataValidator {
    private static final String CORRECT_FILE_LINE_WITH_COORDINATES = "(\\s*((\\d+?\\.\\d{1,2})\\s*){3}\\s*?;){4}";

    @Override
    public boolean validateData(String line) {
        boolean result = line.matches(CORRECT_FILE_LINE_WITH_COORDINATES);
        if (!result) {
            //todo write log
        }
        return result;
    }
}
