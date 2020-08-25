package com.verbitsky.task2.manager;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task2.entity.figurecalcresult.FigureCalcResult;
import com.verbitsky.task2.entity.warehouse.Warehouse;
import com.verbitsky.task2.entity.warehouse.impl.FigureWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WareHouseManager {
    private static Warehouse wareHouse = new FigureWarehouse();
    private static Logger logger = LogManager.getLogger();

    private WareHouseManager() {
    }

    public void addFigureToWarehouse(Figure figure, FigureCalcResult calcResult) {
        wareHouse.getStorage().put(figure.getFigureId(), calcResult);
        logger.log(Level.INFO, "Warehouse manager: add calculation result to storage");
    }

    public void removeFigureFromWarehouse (Figure figure) {
        wareHouse.getStorage().remove(figure.getFigureId());
        logger.log(Level.INFO, "Warehouse manager: remove calculation result from storage");
    }
}
