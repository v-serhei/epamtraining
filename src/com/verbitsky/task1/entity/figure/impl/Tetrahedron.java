package com.verbitsky.task1.entity.figure.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.entity.verge.Verge;

import java.util.Objects;

public class Tetrahedron extends Figure {

    private AreaPoint pointA;
    private AreaPoint pointB;
    private AreaPoint pointC;
    private AreaPoint heightPoint;
    private Verge verge;

    public Tetrahedron(AreaPoint pointA, AreaPoint pointB, AreaPoint pointC, AreaPoint heightPoint) {
        setFigureId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.heightPoint = heightPoint;
        verge = new Verge(pointA, pointB);
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

    public AreaPoint getHeightPoint() {
        return heightPoint;
    }

    public Verge getVerge() {
        return verge;
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
                Objects.equals(heightPoint, that.heightPoint);
    }

    @Override
    public int hashCode() {
        return getPointA().hashCode()
                + getPointB().hashCode()
                + getPointC().hashCode()
                + getHeightPoint().hashCode();
    }
    //todo ToString
}
