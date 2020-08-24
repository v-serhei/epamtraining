package com.verbitsky.task1.validator.figurecreatevalidator.impl;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.validator.figurecreatevalidator.FigureCreationValidator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronCreationValidatorTest {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    FigureCreationValidator validator;

    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        validator = new TetrahedronCreationValidator();
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        validator = null;
    }

    /*  Positive result tests */
    @Test (description = "Test creation with correct arguments")
    public void testValidateFigureCreation() {
        List<AreaPoint> pointList = new ArrayList<>();
        pointList.add(areaPointA);
        pointList.add(areaPointB);
        pointList.add(areaPointC);
        pointList.add(areaPointTop);
        Assert.assertTrue(validator.validateFigureCreation(pointList));
    }

    /* Negative result tests */
    @Test (description = "Test creation with null list")
    public void testValidateFigureCreationWithNullArgs() {
        List<AreaPoint> pointList = null;
        Assert.assertFalse(validator.validateFigureCreation(pointList));
    }

    @Test (description = "Test creation with empty list")
    public void testValidateFigureCreationWithEmptyList() {
        List<AreaPoint> pointList = new ArrayList<>();
        Assert.assertFalse(validator.validateFigureCreation(pointList));
    }

    @Test (description = "Test creation with null AreaPoint")
    public void testValidateFigureCreationWithNullAreaPoint() {
        List<AreaPoint> pointList = new ArrayList<>();
        AreaPoint aNullpoint = null;
        pointList.add(areaPointA);
        pointList.add(areaPointB);
        pointList.add(areaPointC);
        pointList.add(aNullpoint);
        Assert.assertFalse(validator.validateFigureCreation(pointList));
    }

    @Test (description = "Test creation with null verge")
    public void testValidateFigureCreationWithNullVerge() {
        List<AreaPoint> pointList = new ArrayList<>();
        AreaPoint areaPointD = new AreaPoint(0, 0, 0);
        AreaPoint areaPointE = new AreaPoint(0, 0, 0);
        pointList.add(areaPointA);
        pointList.add(areaPointB);
        pointList.add(areaPointD);
        pointList.add(areaPointE);
        Assert.assertFalse(validator.validateFigureCreation(pointList));
    }

    @Test (description = "Test creation with different verge length")
    public void testValidateFigureCreationWithDifferentVerges() {
        List<AreaPoint> pointList = new ArrayList<>();
        AreaPoint areaPointD = new AreaPoint(1, 2, 3);
        AreaPoint areaPointE = new AreaPoint(10, 11, 12);
        pointList.add(areaPointA);
        pointList.add(areaPointB);
        pointList.add(areaPointD);
        pointList.add(areaPointE);
        Assert.assertFalse(validator.validateFigureCreation(pointList));
    }


}