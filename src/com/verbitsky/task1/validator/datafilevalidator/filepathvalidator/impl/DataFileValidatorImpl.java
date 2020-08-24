package com.verbitsky.task1.validator.datafilevalidator.filepathvalidator.impl;

import com.verbitsky.task1.validator.datafilevalidator.filepathvalidator.DataFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class DataFileValidatorImpl implements DataFileValidator {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean validateEmptyDataFile(String path) {
        File file = new File(path);
        logger.log(Level.INFO, "Data file validator: Empty file " + path + "file size=" + file.length());
        return file.length() == 0;
    }

    @Override
    public boolean validateDataFilePath(String path) {
        boolean result = false;
        if (!isEmptyOrNull(path)) {
            File file = new File(path);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    result = true;
                } else {
                    logger.log(Level.INFO, "Data file validator: Not a file "+ path);
                }
            }else {
                logger.log(Level.INFO, "Data file validator: Wrong file path " + path);
            }
        }
        return result;
    }

    private boolean isEmptyOrNull(String path) {
        if (path != null || !path.isEmpty()) {
            logger.log(Level.INFO, "Data file validator: Empty or Null file path");
            return false;
        }
        return true;
    }
}
