package com.verbitsky.task1.validator.impl;

import com.verbitsky.task1.validator.DataFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class DataFileValidatorImpl implements DataFileValidator {
    private static Logger logger = LogManager.getLogger();

    //return true if data file is empty
    @Override
    public boolean validateEmptyDataFile(String path) {
        File file = new File(path);
        boolean result = (file.length() == 0);
        if (result) {
            logger.log(Level.INFO, "Data file validator: Empty file: " + path);
        }
        return result;
    }

    //returns true if file path is correct
    @Override
    public boolean validateDataFilePath(String path) {
        boolean result = false;
        if (!isEmptyOrNull(path)) {
            File file = new File(path);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    result = true;
                } else {
                    logger.log(Level.INFO, "Data file validator: Not a file: "+ path);
                }
            }else {
                logger.log(Level.INFO, "Data file validator: Wrong file path: " + path);
            }
        }
        return result;
    }

    //returns true if path null or empty
    private boolean isEmptyOrNull(String path) {
        if (path != null || !path.isEmpty()) {
            return false;
        }
        logger.log(Level.INFO, "Data file validator: Empty or Null file path");
        return true;
    }
}
