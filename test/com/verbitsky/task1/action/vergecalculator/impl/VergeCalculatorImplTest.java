package com.verbitsky.task1.action.vergecalculator.impl;

import com.verbitsky.task1.action.vergecalculator.VergeCalculator;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.fail;

public class VergeCalculatorImplTest {
    private AreaPoint pointA;
    private AreaPoint pointB;
    private VergeCalculator calculator;

    @BeforeClass
    public void setUp() {
        pointA = new AreaPoint(1, 1, 1);
        pointB = new AreaPoint(-1, -1, 1);
        calculator = new VergeCalculatorImpl();
    }

    @AfterClass
    public void tearDown() {
        pointA = null;
        pointB = null;
        calculator = null;
    }

    /* Positive result tests*/
    @Test
    public void testCalculateVergeSizePositive() throws FigureException {
        double expected = 2.8284;
        double actual = calculator.calculateVergeSize(pointA, pointB);
        AssertJUnit.assertEquals("Wrong calculation result", expected, actual, 0.0001);
    }

    /* Negative result tests*/
    @Test(expectedExceptions = FigureException.class)
    public void testCalculateVergeSizeWithNullArgs() throws FigureException{
        calculator.calculateVergeSize(null, pointB);
        fail("Test failed - expected FigureException");
    }
}