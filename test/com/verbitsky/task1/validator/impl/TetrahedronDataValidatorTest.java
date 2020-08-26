package com.verbitsky.task1.validator.impl;

import com.verbitsky.task1.validator.FigureDataValidator;
import com.verbitsky.task1.validator.impl.TetrahedronDataValidator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronDataValidatorTest {
    private FigureDataValidator validator;
    @BeforeClass
    public void setUp() {
        validator = new TetrahedronDataValidator();
    }

    @AfterClass
    public void tearDown() {
        validator = null;
    }

    /* Positive result tests*/
    @Test
    public void testValidateDataPositive() {
        String data = "1.0   1.0 1.0;   2.0       122.0 2.0;  3.0   3.0   3.0; 4.0   4.0    4.0;";
        Assert.assertTrue(validator.validateData(data));
    }

    /* Negative result tests: result = false or catch exception */
    @Test
    public void testValidateDataWithWrongData() {
        String data = "This is wrong data";
        Assert.assertFalse(validator.validateData(data));
    }

    @Test
    public void testValidateDataWithNullData() {
        Assert.assertFalse(validator.validateData(null));
    }
}