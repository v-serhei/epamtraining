package com.verbitsky.task1.entity;

public class FigureWarehouse extends Warehouse {

    public FigureWarehouse() {
        setWarehouseId();
        setWareHouse();
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FigureWarehouse)) return false;

        FigureWarehouse that = (FigureWarehouse) o;

        return getStorage() != null ? getStorage().equals(that.getStorage()) : that.getStorage() == null;
    }

    @Override
    public int hashCode() {
        return getStorage() != null ? getStorage().hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Figure warehouse, id=");
        sb.append(getWarehouseId());
        sb.append(": number of figures in storage=");
        sb.append(getStorage().size());
        return sb.toString();
    }
}
