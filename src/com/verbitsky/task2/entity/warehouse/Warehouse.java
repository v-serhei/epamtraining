package com.verbitsky.task2.entity.warehouse;

import com.verbitsky.task2.entity.figurecalcresult.FigureCalcResult;
import com.verbitsky.task2.generator.WarehouseIdGenerator;

import java.util.HashMap;
import java.util.Map;

public abstract class Warehouse {
    private long warehouseId;
    private Map<Long, FigureCalcResult> storage;

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId() {
        this.warehouseId = WarehouseIdGenerator.generateId();
    }

    public Map<Long, FigureCalcResult> getStorage() {
        return storage;
    }

    public void setWareHouse() {
        this.storage = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Base warehouse";
    }
}
