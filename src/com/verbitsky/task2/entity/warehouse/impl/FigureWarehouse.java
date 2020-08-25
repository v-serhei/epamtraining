package com.verbitsky.task2.entity.warehouse.impl;

import com.verbitsky.task2.entity.figurecalcresult.FigureCalcResult;
import com.verbitsky.task2.entity.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class FigureWarehouse extends Warehouse {
    private Map<Long, FigureCalcResult> wareHouse;

    public FigureWarehouse() {
        setWarehouseId();
        wareHouse = new HashMap<>();
    }

    public Map<Long, FigureCalcResult> getWareHouse() {
        return wareHouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FigureWarehouse)) return false;

        FigureWarehouse that = (FigureWarehouse) o;

        return getWareHouse() != null ? getWareHouse().equals(that.getWareHouse()) : that.getWareHouse() == null;
    }

    @Override
    public int hashCode() {
        return getWareHouse() != null ? getWareHouse().hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Figure warehouse, id=");
        sb.append(getWarehouseId());
        sb.append(": number of figures in storage=");
        sb.append(wareHouse.size());
        return sb.toString();
    }
}
