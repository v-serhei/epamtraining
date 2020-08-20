package com.verbitsky.task1.entity.point;

public class AreaPoint {
    private double x;
    private double y;
    private double z;

    public AreaPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaPoint)) return false;
        AreaPoint point = (AreaPoint) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        final int X_FACTOR = 13;
        final int Y_FACTOR = 17;
        final int Z_FACTOR = 19;
        double sum = getX() * X_FACTOR + Y_FACTOR * getY() + Z_FACTOR * getZ();
        return PRIME * (int) Math.round(sum == 0.0 ? PRIME + X_FACTOR : sum);
    }
}
