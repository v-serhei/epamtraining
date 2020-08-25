package com.verbitsky.task2.entity.warehouse;

import com.verbitsky.task2.generator.WarehouseIdGenerator;

public abstract class Warehouse {
    private long warehouseId;

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId() {
        this.warehouseId = WarehouseIdGenerator.generateId();
    }

    @Override
    public String toString() {
        return "Base warehouse";
    }
}
