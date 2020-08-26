package com.verbitsky.task1.entity;

import com.verbitsky.task1.action.VergeCalculator;
import com.verbitsky.task1.action.impl.VergeCalculatorImpl;
import com.verbitsky.task1.exception.FigureException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tetrahedron extends Figure {
    private static Logger logger = LogManager.getLogger();
    private AreaPoint pointA;
    private AreaPoint pointB;
    private AreaPoint pointC;
    private AreaPoint topPoint;
    private double vergeSize;

    public Tetrahedron(AreaPoint pointA, AreaPoint pointB, AreaPoint pointC, AreaPoint topPoint) {
        setFigureId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.topPoint = topPoint;
        VergeCalculator vergeCalculator = new VergeCalculatorImpl();
        try {
            vergeSize = vergeCalculator.calculateVergeSize(pointA, pointB);
        } catch (FigureException e) {
            logger.log(Level.INFO, "Tetrahedron constructor: can't calculate verge size, cause: null AreaPoints");
        }
    }

    public AreaPoint getPointA() {
        return pointA;
    }

    public AreaPoint getPointB() {
        return pointB;
    }

    public AreaPoint getPointC() {
        return pointC;
    }

    public AreaPoint getTopPoint() {
        return topPoint;
    }

    public double getVergeSize() {
        return vergeSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tetrahedron)) return false;

        Tetrahedron that = (Tetrahedron) o;

        if (Double.compare(that.getVergeSize(), getVergeSize()) != 0) return false;
        if (getPointA() != null ? !getPointA().equals(that.getPointA()) : that.getPointA() != null) return false;
        if (getPointB() != null ? !getPointB().equals(that.getPointB()) : that.getPointB() != null) return false;
        if (getPointC() != null ? !getPointC().equals(that.getPointC()) : that.getPointC() != null) return false;
        return getTopPoint() != null ? getTopPoint().equals(that.getTopPoint()) : that.getTopPoint() == null;
    }

    @Override
    public int hashCode() {
        return getPointA().hashCode()
                + getPointB().hashCode()
                + getPointC().hashCode()
                + getTopPoint().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tetrahedron: id=");
        sb.append(getFigureId());
        sb.append(" points (A: ");
        sb.append(pointA);
        sb.append("B: ");
        sb.append(pointB);
        sb.append("C: ");
        sb.append(pointA);
        sb.append("Top: ");
        sb.append(topPoint);
        sb.append(") verge size=");
        sb.append(vergeSize);
        return sb.toString();
    }
}
