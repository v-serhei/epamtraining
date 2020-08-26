package com.verbitsky.task1.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public enum WareHouseManager {
    INSTANCE;
    private static Warehouse wareHouse = new FigureWarehouse();
    private static Logger logger = LogManager.getLogger();

    public void addFigureToWarehouse(Figure figure, FigureCalcResult calcResult) {
        if (figure == null || calcResult==null) {
            logger.log(Level.INFO,"Warehouse manager add method: received null objects");
            return;
        }
        wareHouse.getStorage().put(figure.getFigureId(), calcResult);
        logger.log(Level.INFO, "Warehouse manager: add calculation result to storage");
    }

    public void removeFigureFromWarehouse(Figure figure) {
        if (figure == null) {
            logger.log(Level.INFO,"Warehouse manager remove method: received null object");
            return;
        }
        wareHouse.getStorage().remove(figure.getFigureId());
        logger.log(Level.INFO, "Warehouse manager: remove calculation result from storage");
    }

    public void clearWarehouseStorage () {
        logger.log(Level.INFO, "Warehouse manager: clear storage");
        wareHouse.getStorage().clear();
    }

    public int getCurrentWarehouseSize() {
        return wareHouse.getStorage().size();
    }
}