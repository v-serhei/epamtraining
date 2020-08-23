package com.verbitsky.task1.validator.datavalidator.impl;

import com.verbitsky.task1.validator.datavalidator.FigureDataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronDataValidator implements FigureDataValidator {
    private static final String CORRECT_FILE_LINE_WITH_COORDINATES = "(\\s*((\\d+?\\.\\d{1,2})\\s*){3}\\s*?;){4}";
    private static Logger logger = LogManager.getLogger();
    @Override
    public boolean validateData(String line) {
        boolean result = line.matches(CORRECT_FILE_LINE_WITH_COORDINATES);
        if (result) {
            logger.log(Level.INFO, "Tetrahedron data validator: line is correct");
        } else {
            logger.log(Level.INFO, "Tetrahedron data validator: line is incorrect");
        }
        return result;
    }
}
