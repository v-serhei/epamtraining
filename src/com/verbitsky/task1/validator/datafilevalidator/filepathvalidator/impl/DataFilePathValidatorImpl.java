package com.verbitsky.task1.validator.datafilevalidator.filepathvalidator.impl;

import com.verbitsky.task1.validator.datafilevalidator.filepathvalidator.DataFilePathValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class DataFilePathValidatorImpl implements DataFilePathValidator {
    private static Logger logger = LogManager.getLogger();


    private boolean isEmptyFile(String path) {
        File file = new File(path);
        logger.log(Level.INFO, "Data file validator: Empty file " + path);
        return file.length() == 0;
    }

    @Override
    public boolean validateDataFilePath(String path) {
        boolean correctFilePath = validateFilePath(path);
        boolean result = false;
        if (correctFilePath) {
            result = isEmptyFile(path);
        }
        return result;
    }

    private boolean validateFilePath(String path) {
        if (path == null || path.isEmpty()) {
            logger.log(Level.INFO, "Data file validator: Empty file path");
            return false;
        }
        File file = new File(path);
        if (file.isDirectory()) {
            logger.log(Level.INFO, "Data file validator: Not a file " + path);
            return false;
        }
        return file.exists();
    }
}
