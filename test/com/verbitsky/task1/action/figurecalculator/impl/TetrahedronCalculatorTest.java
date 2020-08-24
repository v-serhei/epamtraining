package com.verbitsky.task1.action.figurecalculator.impl;

import com.verbitsky.task1.action.figurecalculator.FigureCalculator;
import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronCalculatorTest {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private Figure tetrahedron;
    private FigureCalculator figureCalculator;

    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        tetrahedron = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
        figureCalculator = new TetrahedronCalculator();
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        tetrahedron = null;
        figureCalculator = null;
    }

    @Test
    public void testCalculateSquare() {
        double expected = 13.8564;
        double actual = 0;
        try {
            actual = figureCalculator.calculateSquare(tetrahedron);
        } catch (FigureException e) {
            e.printStackTrace();
        }
        AssertJUnit.assertEquals("Wrong calculation result", expected, actual, 0.0001);
    }

    @Test
    public void testCalculateVolume() throws FigureException {
        double expected = 2.6666;
        double actual = figureCalculator.calculateVolume(tetrahedron);
        AssertJUnit.assertEquals("Wrong calculation result", expected, actual, 0.0001);
    }

    @Test
    public void testCalculateVolumeRatio() {
        //double expected
    }

    @Test
    public void testIsFigureOnCoordinatesPlane() {
    }
}