package com.verbitsky.task1.entity.point;

public class AreaPoint {
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public AreaPoint(double x, double y, double z) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.zCoordinate = z;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaPoint)) return false;
        AreaPoint point = (AreaPoint) o;
        return Double.compare(point.xCoordinate, xCoordinate) == 0 &&
                Double.compare(point.yCoordinate, yCoordinate) == 0 &&
                Double.compare(point.zCoordinate, zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        final int X_FACTOR = 13;
        final int Y_FACTOR = 17;
        final int Z_FACTOR = 19;
        double sum = getXCoordinate() * X_FACTOR + Y_FACTOR * getYCoordinate() + Z_FACTOR * getZCoordinate();
        return PRIME * (int) Math.round(sum == 0.0 ? PRIME + X_FACTOR : sum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("AreaPoint(x=")
                .append(xCoordinate)
                .append(", y=")
                .append(yCoordinate)
                .append(", z=")
                .append(zCoordinate)
                .append(')');
        return sb.toString();
    }
}
