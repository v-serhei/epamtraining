package com.verbitsky.task1.validator.impl;

import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.validator.FigureTypeValidator;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        nonTetrahedronObject = new Object();
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

    /*  Positive result tests */
    @Test
    public void testIsObjectFigurePositive() {
        boolean expected = true;
        boolean actual = validator.isObjectFigure(tetrahedron);
        AssertJUnit.assertEquals(expected, actual);
    }

    /* Negative result tests */
    @Test
    public void testIsObjectFigureNegative() {
        boolean expected = false;
        boolean actual = validator.isObjectFigure(nonTetrahedronObject);
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test
    public void testIsObjectFigureException() {
        Figure emptyFigure = null;
        boolean expected = false;
        boolean actual = validator.isObjectFigure(emptyFigure);

    }
}