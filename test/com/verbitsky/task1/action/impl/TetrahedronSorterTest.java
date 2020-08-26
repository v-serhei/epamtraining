package com.verbitsky.task1.action.impl;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.action.FigureSorter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronSorterTest {
    private static final int FIRST_FIGURE_INDEX = 0;
    private static final int SECOND_FIGURE_INDEX = 1;
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
    /* Positive tests results */
    @Test
    public void testSortFiguresById() {
        List<Figure> list = new ArrayList<>();
        list.add (figureB);
        list.add (figureA);
        sorter.sortFiguresById(list, false);
        long firstId = list.get(FIRST_FIGURE_INDEX).getFigureId();
        long secondId = list.get(SECOND_FIGURE_INDEX).getFigureId();
        Assert.assertTrue(firstId <= secondId);
    }
    @Test
    public void testSortFiguresByIReversedOrder() {
        List<Figure> list = new ArrayList<>();
        list.add (figureB);
        list.add (figureA);
        sorter.sortFiguresById(list, true);
        long firstId = list.get(FIRST_FIGURE_INDEX).getFigureId();
        long secondId = list.get(SECOND_FIGURE_INDEX).getFigureId();
        Assert.assertTrue(secondId <= firstId);
    }

    @Test
    public void testSortFiguresByFirstPointCoordinateX() {
        List<Figure> list = new ArrayList<>();
        list.add (figureB);
        list.add (figureA);
        sorter.sortFiguresByFirstPointCoordinateX(list, false);
        double firstX = ((Tetrahedron) list.get(FIRST_FIGURE_INDEX)).getPointA().getXCoordinate();
        double secondX = ((Tetrahedron) list.get(SECOND_FIGURE_INDEX)).getPointA().getXCoordinate();
        Assert.assertTrue(firstX <= secondX);
    }

    @Test
    public void testSortFiguresByFirstPointCoordinateXReversedOrder() {
        List<Figure> list = new ArrayList<>();
        list.add (figureB);
        list.add (figureA);
        sorter.sortFiguresByFirstPointCoordinateX(list, true);
        double firstX = ((Tetrahedron) list.get(FIRST_FIGURE_INDEX)).getPointA().getXCoordinate();
        double secondX = ((Tetrahedron) list.get(SECOND_FIGURE_INDEX)).getPointA().getXCoordinate();
        Assert.assertTrue(secondX <= firstX);
    }
}