package com.verbitsky.task1.action.figurecalculator.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronCalculatorTest {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private Figure tetrahedron;

    @BeforeClass
    public void setUp() {
        AreaPoint areaPointA = new AreaPoint(1,-1,-1);
        AreaPoint areaPointB= new AreaPoint(-1,-1,1);
        AreaPoint areaPointC= new AreaPoint(-1,1,-1);
        AreaPoint areaPointTop= new AreaPoint(1,1,1);
        Figure tetrahedron = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        tetrahedron = null;
    }

    @Test
    public void testCalculateSquare() {

    }

    @Test
    public void testCalculateVolume() {
    }

    @Test
    public void testCalculateVolumeRatio() {
    }

    @Test
    public void testIsFigureOnCoordinatesPlane() {
    }
}