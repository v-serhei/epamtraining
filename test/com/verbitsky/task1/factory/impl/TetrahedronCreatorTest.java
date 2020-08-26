package com.verbitsky.task1.factory.impl;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.factory.impl.TetrahedronCreator;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.fail;

public class TetrahedronCreatorTest {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private TetrahedronCreator creator;

    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        creator = new TetrahedronCreator();
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        creator = null;
    }

    /*Positive tests results*/
    @Test
    public void testCreateFigureFromListPositive() throws FigureException {
        List<AreaPoint> pointList = new ArrayList<>();
        pointList.add(areaPointA);
        pointList.add(areaPointB);
        pointList.add(areaPointC);
        pointList.add(areaPointTop);
        Figure testFigure = creator.createFigure(pointList);
        boolean result = testFigure.equals(null);
        AssertJUnit.assertFalse(result);
    }

    @Test
    public void testTestCreateFigureFromArrayPositive() throws FigureException {
        Figure testFigure = creator.createFigure(areaPointA, areaPointB, areaPointC, areaPointTop);
        boolean result = testFigure.equals(null);
        AssertJUnit.assertFalse(result);
    }

    @Test
    public void testCreateFiguresFromFile() throws FigureException {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("data");
        pathBuilder.append(File.separator);
        pathBuilder.append("fileforcreation");
        pathBuilder.append(File.separator);
        pathBuilder.append("onefigure.txt");
        List<Figure> list = creator.createFiguresFromFile(pathBuilder.toString());
        Figure testFigure = list.get(0);
        boolean result = testFigure.equals(null);
        AssertJUnit.assertFalse(result);
    }

    /*Negative tests results*/
    @Test(expectedExceptions = FigureException.class)
    public void testCreateFigureWithWrongArgs() throws FigureException {
        List<AreaPoint> pointList = new ArrayList<>();
        creator.createFigure(pointList);
        fail("Expected NullPointerException");
    }
}