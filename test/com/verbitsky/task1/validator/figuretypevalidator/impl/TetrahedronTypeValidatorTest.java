package com.verbitsky.task1.validator.figuretypevalidator.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.validator.figuretypevalidator.FigureTypeValidator;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TetrahedronTypeValidatorTest {

    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private Figure tetrahedron;
    private Object nonTetrahedronObject;
    private FigureTypeValidator validator;

    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        tetrahedron = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
        validator = new TetrahedronTypeValidator();
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        tetrahedron = null;
        validator = null;
        nonTetrahedronObject = null;
    }

    @Test
    public void testIsObjectFigurePositive() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = validator.isObjectFigure(tetrahedron);
        } catch (FigureException e) {
            e.printStackTrace();
        }
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test
    public void testIsObjectFigureNegative() {
        boolean expected = false;
        boolean actual = false;
        try {
            actual = validator.isObjectFigure(nonTetrahedronObject);
        } catch (FigureException e) {
            e.printStackTrace();
        }
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = FigureException.class,
            expectedExceptionsMessageRegExp = ".*Method isObjectFigure getting null object.*")
    public void testIsObjectFigureException() throws FigureException {
        Figure emptyFigure = null;
        validator.isObjectFigure(emptyFigure);
        fail("Method isObjectFigure should throw FigureException when calling with null object");
    }
}