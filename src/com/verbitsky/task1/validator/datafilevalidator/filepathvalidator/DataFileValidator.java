package com.verbitsky.task1.validator.datafilevalidator.filepathvalidator;

public interface DataFileValidator {
    boolean validateDataFilePath(String path);
    boolean validateEmptyDataFile(String path);
}
