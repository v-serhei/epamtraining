package com.verbitsky.task1.factory.impl;

import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.entity.WareHouseManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TetrahedronCreatorTestTask2 {
    private AreaPoint areaPointA;
    private AreaPoint areaPointB;
    private AreaPoint areaPointC;
    private AreaPoint areaPointTop;
    private TetrahedronCreator figureCreator;

    @BeforeClass
    public void setUp() {
        areaPointA = new AreaPoint(1, 1, 1);
        areaPointB = new AreaPoint(-1, -1, 1);
        areaPointC = new AreaPoint(-1, 1, -1);
        areaPointTop = new AreaPoint(1, -1, -1);
        figureCreator = new TetrahedronCreator();
    }

    @AfterClass
    public void tearDown() {
        areaPointA = null;
        areaPointB = null;
        areaPointC = null;
        areaPointTop = null;
        figureCreator = null;
    }

    /* Task 2 tests */
    /* Positive test result */
    @Test
    public void testSaveFigureToWarehousePositive() throws FigureException {
        WareHouseManager.INSTANCE.clearWarehouseStorage();
        Figure figure = new Tetrahedron(areaPointA, areaPointB, areaPointC, areaPointTop);
        int storageSizeBefore = WareHouseManager.INSTANCE.getCurrentWarehouseSize();
        figureCreator.saveFigureToWarehouse(figure);
        int storageSizeAfter = WareHouseManager.INSTANCE.getCurrentWarehouseSize();
        Assert.assertNotEquals(storageSizeBefore, storageSizeAfter);
    }

    /* Negative test result */
    @Test(expectedExceptions = FigureException.class)
    public void testSaveFigureToWarehouseWithNullArgs() throws FigureException {
        figureCreator.saveFigureToWarehouse(null);
        fail("Test fail: expected FigureException");
    }

}
