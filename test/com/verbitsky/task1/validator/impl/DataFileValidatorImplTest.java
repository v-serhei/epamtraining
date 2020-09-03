package com.verbitsky.task1.validator.impl;

import com.verbitsky.task1.validator.DataFileValidator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class DataFileValidatorImplTest {
    private DataFileValidator validator;
    @BeforeClass
    public void setUp() {

        validator = new DataFileValidatorImpl();
    }

    @AfterClass
    public void tearDown() {
        validator = null;
    }

    /* Positive result tests*/
    @Test
    public void testValidateDataFilePathPositive() {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("resources");
        pathBuilder.append(File.separator);
        pathBuilder.append("fileforcreation");
        pathBuilder.append(File.separator);
        pathBuilder.append("figureparametres.txt");
        Assert.assertTrue(validator.validateDataFilePath(pathBuilder.toString()));
    }

    @Test (description = "If file size > 0 - method returns false")
    public void testValidateEmptyDataFilePositive() {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("resources");
        pathBuilder.append(File.separator);
        pathBuilder.append("fileforcreation");
        pathBuilder.append(File.separator);
        pathBuilder.append("figureparametres.txt");
        System.out.println(pathBuilder.toString());
        Assert.assertFalse(validator.validateEmptyDataFile(pathBuilder.toString()));
    }



    /* Negative result tests: result = false or catch exception */
    @Test (expectedExceptions = RuntimeException.class)
    public void testValidateDataFilePathWithNullPath() {
        validator.validateDataFilePath(null);
    }

    @Test
    public void testValidateDataFilePathWithWrongPath() {
        String wrongPath = "Wrong file path";
        Assert.assertFalse(validator.validateDataFilePath(wrongPath));
    }

    @Test (description = "Path points to directory")
    public void testValidateDataFilePathNotAFile() {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("resources");
        pathBuilder.append(File.separator);
        pathBuilder.append("fileforcreation");
        Assert.assertFalse(validator.validateDataFilePath(pathBuilder.toString()));
    }

    @Test
    public void testValidateDataFilePathWithEmptyFile() {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("resources");
        pathBuilder.append(File.separator);
        pathBuilder.append("fileforcreation");
        pathBuilder.append(File.separator);
        pathBuilder.append("emptyfile.txt");
        Assert.assertTrue(validator.validateDataFilePath(pathBuilder.toString()));
    }
}