package com.verbitsky.task1.entity;

public class TetrahedronCalcResult extends FigureCalcResult {
    private double planeSquare;
    private double volume;

    public TetrahedronCalcResult(Figure figure, double planeSquare, double volume) {
        setFigure(figure);
        this.planeSquare = planeSquare;
        this.volume = volume;
    }

    public double getPlaneSquare() {
        return planeSquare;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TetrahedronCalcResult)) return false;

        TetrahedronCalcResult that = (TetrahedronCalcResult) o;

        if (Double.compare(that.planeSquare, planeSquare) != 0) return false;
        return Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(planeSquare);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Calculation results for Tetrahedron, id=");
        sb.append(getFigure().getFigureId());
        sb.append(": plane square=");
        sb.append(getPlaneSquare());
        sb.append(", volume=");
        sb.append(getVolume());
        return sb.toString();
    }
}
