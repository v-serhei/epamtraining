package com.verbitsky.task1.validator;

public interface DataFileValidator {
    boolean validateDataFilePath(String path);

    boolean validateEmptyDataFile(String path);
}
