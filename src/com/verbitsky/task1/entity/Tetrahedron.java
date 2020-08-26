package com.verbitsky.task1.entity;

import com.verbitsky.task1.action.VergeCalculator;
import com.verbitsky.task1.action.impl.VergeCalculatorImpl;
import com.verbitsky.task1.exception.FigureException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

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
            vergeSize = 0;
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
        return this.getFigureId() == that.getFigureId() &&
                Objects.equals(pointA, that.pointA) &&
                Objects.equals(pointB, that.pointB) &&
                Objects.equals(pointC, that.pointC) &&
                Objects.equals(topPoint, that.topPoint);
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
        sb
                .append("Tetrahedron: id=")
                .append(getFigureId())
                .append(" points (")
                .append("A: ")
                .append(pointA)
                .append("B: ")
                .append(pointB)
                .append("C: ")
                .append(pointA)
                .append("Top: ")
                .append(topPoint)
                .append(")")
                .append(" verge size=")
                .append(vergeSize);
        return sb.toString();
    }
}
