package com.verbitsky.task2.manager;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task2.entity.figurecalcresult.FigureCalcResult;
import com.verbitsky.task2.factory.CalcResultsCreator;
import com.verbitsky.task2.factory.impl.FigureCalcResultCreator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WareHouseManagerTest {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private Figure figure;

    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        figure = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        figure = null;
    }

    /* Positive tests results*/
    @Test
    public void testRemoveFigureFromWarehousePositive() throws FigureException {
        WareHouseManager.clearWarehouseStorage();
        CalcResultsCreator resultsCreator = new FigureCalcResultCreator();
        FigureCalcResult calcResult = resultsCreator.createCalcResult(figure);
        WareHouseManager.addFigureToWarehouse(figure, calcResult);
        int sizeBefore = WareHouseManager.getCurrentWarehouseSize();
        WareHouseManager.removeFigureFromWarehouse(figure);
        int sizeAfter = WareHouseManager.getCurrentWarehouseSize();
        Assert.assertNotEquals(sizeAfter, sizeBefore);
    }

    @Test
    public void testAddFigureToWarehousePositive() throws FigureException {
        WareHouseManager.clearWarehouseStorage();
        CalcResultsCreator resultsCreator = new FigureCalcResultCreator();
        FigureCalcResult calcResult = resultsCreator.createCalcResult(figure);
        int sizeBefore = WareHouseManager.getCurrentWarehouseSize();
        WareHouseManager.addFigureToWarehouse(figure, calcResult);
        int sizeAfter = WareHouseManager.getCurrentWarehouseSize();
        System.out.println("before=" + sizeBefore + " after=" + sizeAfter);
        Assert.assertNotEquals(sizeAfter, sizeBefore);
    }

    /* Negative tests results*/
    @Test
    public void testAddFigureToWarehouseWithNullArgs() {
        WareHouseManager.clearWarehouseStorage();
        int sizeBefore = WareHouseManager.getCurrentWarehouseSize();
        WareHouseManager.addFigureToWarehouse(figure, null);
        int sizeAfter = WareHouseManager.getCurrentWarehouseSize();
        System.out.println("before=" + sizeBefore + " after=" + sizeAfter);
        Assert.assertEquals(sizeAfter, sizeBefore);
    }

    @Test
    public void testRemoveFigureFromWarehouseWithNullArgs() throws FigureException {
        WareHouseManager.clearWarehouseStorage();
        CalcResultsCreator resultsCreator = new FigureCalcResultCreator();
        FigureCalcResult calcResult = resultsCreator.createCalcResult(figure);
        WareHouseManager.addFigureToWarehouse(figure, calcResult);
        int sizeBefore = WareHouseManager.getCurrentWarehouseSize();
        WareHouseManager.removeFigureFromWarehouse(null);
        int sizeAfter = WareHouseManager.getCurrentWarehouseSize();
        Assert.assertEquals(sizeAfter, sizeBefore);
    }
}