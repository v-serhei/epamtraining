package com.verbitsky.task2.action.sorter.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task2.action.sorter.FigureSorter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TetrahedronSorterTest {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private Figure figureA;
    private Figure figureB;
    private FigureSorter sorter;

    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        figureA = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
        areaPointA = new AreaPoint(3, 3, 3);
        areaPointB = new AreaPoint(-3, -3, 3);
        areaPointC = new AreaPoint(-3, 3, -3);
        areaPointTop = new AreaPoint(3, -3, -3);
        figureB = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
        sorter = new TetrahedronSorter();
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        figureA = null;
        figureB = null;
        sorter = null;
    }

    @Test
    public void testSortFiguresByIdPositive() {
        List<Figure> list = sorter.sortFiguresById(figureB, figureA);
        long firstId = list.get(0).getFigureId();
        long secondId = list.get(1).getFigureId();
        Assert.assertTrue(firstId <= secondId);
    }

    @Test
    public void testSortFiguresByFirstPointCoordinateXPositive() {
        List<Figure> list = sorter.sortFiguresById(figureB, figureA);
        double firstX = ((Tetrahedron) list.get(0)).getPointA().getXCoordinate();
        double secondX = ((Tetrahedron) list.get(0)).getPointA().getXCoordinate();
        Assert.assertTrue(firstX <= secondX);
    }

    @Test
    public void testTestSortFiguresByIdWithNullArgs() {
        List<Figure> list = sorter.sortFiguresById();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testTestSortFiguresByFirstPointCoordinateXWithNullArgs() {
        List<Figure> list = sorter.sortFiguresByFirstPointCoordinateX();
        Assert.assertTrue(list.isEmpty());
    }
}