package com.verbitsky.task1.entity.figures;

import com.verbitsky.task1.entity.verge.Verge;
import com.verbitsky.task1.entity.point.AreaPoint;

import java.util.Objects;

public class Tetrahedron extends Figure {
    private static int tetrahedronCount = 1;
    private int id;


    private AreaPoint pointA;
    private AreaPoint pointB;
    private AreaPoint pointC;
    private AreaPoint heightPoint;

    private Verge verge;

    public Tetrahedron(AreaPoint pointA, AreaPoint pointB, AreaPoint pointC, AreaPoint heightPoint) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.heightPoint = heightPoint;
        verge = new Verge(pointA, pointB);
        this.setId(tetrahedronCount);
        tetrahedronCount++;
    }

    public int getId() {
        return id;
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
        return id == that.id &&
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
                + getHeightPoint().hashCode()
                + getId();
    }
}
