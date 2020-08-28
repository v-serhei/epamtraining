package com.verbitsky.task1.entity;

import com.verbitsky.task1.action.VergeCalculator;
import com.verbitsky.task1.action.impl.VergeCalculatorImpl;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.observer.FigureObserver;
import com.verbitsky.task1.observer.impl.TetrahedronObserver;
import com.verbitsky.task1.validator.FigureCreationValidator;
import com.verbitsky.task1.validator.impl.TetrahedronCreationValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Tetrahedron extends Figure {
    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private static final int THIRD_POINT_INDEX = 2;
    private static final int TOP_POINT_INDEX = 3;
    private static Logger logger = LogManager.getLogger();
    private AreaPoint pointA;
    private AreaPoint pointB;
    private AreaPoint pointC;
    private AreaPoint topPoint;
    private double vergeLength;
    private FigureObserver observer;

    public Tetrahedron(AreaPoint pointA, AreaPoint pointB, AreaPoint pointC, AreaPoint topPoint) {
        super.generateFigureId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.topPoint = topPoint;
        VergeCalculator vergeCalculator = new VergeCalculatorImpl();
        try {
            vergeLength = vergeCalculator.calculateVergeSize(pointA, pointB);
        } catch (FigureException e) {
            logger.log(Level.INFO, "Tetrahedron constructor: can't calculate verge size, cause: null AreaPoints");
        }

        observer = new TetrahedronObserver();
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

    public double getVergeLength() {
        return vergeLength;
    }

    public boolean setPoints(List <AreaPoint> points) {
        FigureCreationValidator validator = new TetrahedronCreationValidator();
        if (validator.validateFigureCreation(points)) {
            this.pointA = points.get(FIRST_POINT_INDEX);
            this.pointB = points.get(SECOND_POINT_INDEX);
            this.pointC = points.get(THIRD_POINT_INDEX);
            this.topPoint = points.get(TOP_POINT_INDEX);
            notifyObserver();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void generateFigureId() {
        super.generateFigureId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tetrahedron)) return false;

        Tetrahedron that = (Tetrahedron) o;

        if (Double.compare(that.getVergeLength(), getVergeLength()) != 0) return false;
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
        sb.append(vergeLength);
        return sb.toString();
    }

    private void notifyObserver () {
        observer.actionPerformed(this);
    }
}
