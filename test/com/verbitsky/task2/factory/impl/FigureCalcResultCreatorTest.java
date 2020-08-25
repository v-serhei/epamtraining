package com.verbitsky.task2.factory.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task2.entity.figurecalcresult.FigureCalcResult;
import com.verbitsky.task2.factory.CalcResultsCreator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class FigureCalcResultCreatorTest {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private Figure figure;
    private CalcResultsCreator resultsCreator;


    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        figure = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
        resultsCreator = new FigureCalcResultCreator();
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        figure = null;
        resultsCreator = null;
    }

    @Test
    public void testCreateCalcResultPositive() throws FigureException {
        FigureCalcResult calcResult = resultsCreator.createCalcResult(figure);
        Assert.assertNotNull(calcResult);
    }

    @Test (expectedExceptions = FigureException.class)
    public void testCreateCalcResultWithNullArgs() throws FigureException {
        resultsCreator.createCalcResult(null);
        fail("Test fail: expected FigureException");
    }
}