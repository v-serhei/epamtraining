package com.verbitsky.task1.validator.datafilevalidator.filevalidator;

public interface DataFileValidator {
    boolean validateDataFilePath(String path);
    boolean validateEmptyDataFile(String path);
}
