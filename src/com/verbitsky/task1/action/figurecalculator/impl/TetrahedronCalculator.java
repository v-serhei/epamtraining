package com.verbitsky.task1.action.figurecalculator.impl;

import com.verbitsky.task1.action.figurecalculator.FigureCalculator;
import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.validator.figuretypevalidator.impl.TetrahedronTypeValidator;

import static java.lang.Math.*;

public class TetrahedronCalculator implements FigureCalculator {
    private static final double ROUND_FACTOR = 100.0;
    private TetrahedronTypeValidator tetrahedronTypeValidator = new TetrahedronTypeValidator();

    @Override
    public double calculateSquare(Figure figure) {
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            double res = pow(tetrahedron.getVergeSize(), 2) * sqrt(3);
            return roundResult(res);
        }
        return 0;
    }

    @Override
    public double calculateVolume(Figure figure) {
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            double res = (pow(tetrahedron.getVergeSize(), 3) * sqrt(2)) / 12;
            return roundResult(res);
        }
        return 0;
    }

    @Override
    public double calculateVolumeRatio(Figure figure, double subspaceHeight) {
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            AreaPoint buf = tetrahedron.getPointA();
            AreaPoint reducedAPoint = new AreaPoint(buf.getXCoordinate(), subspaceHeight, buf.getZCoordinate());
            buf = tetrahedron.getPointB();
            AreaPoint reducedBPoint = new AreaPoint(buf.getXCoordinate(), subspaceHeight, buf.getZCoordinate());
            buf = tetrahedron.getPointC();
            AreaPoint reducedCPoint = new AreaPoint(buf.getXCoordinate(), subspaceHeight, buf.getZCoordinate());
            double fullTetrahedronVolume = calculateVolume(tetrahedron);
            double reducedTetrahedronVolume = calculateVolume(
                    new Tetrahedron(reducedAPoint, reducedBPoint, reducedCPoint, tetrahedron.getTopPoint()));
            double remainFigureVolume = fullTetrahedronVolume - reducedTetrahedronVolume;
            if (remainFigureVolume > reducedTetrahedronVolume) {
                return roundResult(remainFigureVolume / reducedTetrahedronVolume);
            } else {
                return roundResult(reducedTetrahedronVolume / remainFigureVolume);
            }
        }
        return 0;
    }

    @Override
    public boolean isFigureOnCoordinatesSquare(Figure figure) {
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            AreaPoint a = tetrahedron.getPointA();
            AreaPoint b = tetrahedron.getPointB();
            AreaPoint c = tetrahedron.getPointC();

            if (a.getXCoordinate() == 0 && b.getXCoordinate() == 0 && c.getXCoordinate() == 0) {
                return true;
            }
            if (a.getYCoordinate() == 0 && b.getYCoordinate() == 0 && c.getYCoordinate() == 0) {
                return true;
            }
            if (a.getZCoordinate() == 0 && b.getZCoordinate() == 0 && c.getZCoordinate() == 0) {
                return true;
            }
        }
        return false;
    }

    private double roundResult(double value) {
        return round(sqrt(value) * ROUND_FACTOR) / ROUND_FACTOR;
    }
}
