package com.verbitsky.task1.actions.figurecalculator.impl;

import com.verbitsky.task1.actions.figurecalculator.FigureCalculation;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.entity.figures.Figure;
import com.verbitsky.task1.entity.figures.impl.RightTetrahedron;
import com.verbitsky.task1.entity.verge.Verge;
import com.verbitsky.task1.validators.figuretypevalidator.impl.TetrahedronTypeValidator;

import static java.lang.Math.*;

public class TetrahedronCalculator implements FigureCalculation {
    private static final double ROUND_FACTOR = 100.0;
    private TetrahedronTypeValidator tetrahedronTypeValidator = new TetrahedronTypeValidator();

    @Override
    public double calculateSquare(Figure figure) {
        if (tetrahedronTypeValidator.isObjectTetrahedron(figure)) {
            RightTetrahedron rightTetrahedron = (RightTetrahedron) figure;
            Verge verge = rightTetrahedron.getVerge();
            double res = pow(verge.getVergeSize(), 2) * sqrt(3);
            return roundResult(res);
        }
        return 0;
    }

    @Override
    public double calculateVolume(Figure figure) {
        if (tetrahedronTypeValidator.isObjectTetrahedron(figure)) {
            RightTetrahedron rightTetrahedron = (RightTetrahedron) figure;
            Verge verge = rightTetrahedron.getVerge();
            double res = (pow(verge.getVergeSize(), 3) * sqrt(2)) / 12;
            return roundResult(res);
        }
        return 0;
    }

    @Override
    public double calculateVolumeRatio(Figure figure, double subspaceHeight) {
        if (tetrahedronTypeValidator.isObjectTetrahedron(figure)) {
            RightTetrahedron rightTetrahedron = (RightTetrahedron) figure;
            AreaPoint buf = rightTetrahedron.getPointA();
            AreaPoint reducedAPoint = new AreaPoint(buf.getX(), subspaceHeight, buf.getZ());
            buf = rightTetrahedron.getPointB();
            AreaPoint reducedBPoint = new AreaPoint(buf.getX(), subspaceHeight, buf.getZ());
            buf = rightTetrahedron.getPointC();
            AreaPoint reducedCPoint = new AreaPoint(buf.getX(), subspaceHeight, buf.getZ());
            double fullTetrahedronVolume = calculateVolume(rightTetrahedron);
            double reducedTetrahedronVolume = calculateVolume(
                    new RightTetrahedron(reducedAPoint, reducedBPoint, reducedCPoint, rightTetrahedron.getHeightPoint()));
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
        if (tetrahedronTypeValidator.isObjectTetrahedron(figure)) {
            RightTetrahedron rightTetrahedron = (RightTetrahedron) figure;
            AreaPoint a = rightTetrahedron.getPointA();
            AreaPoint b = rightTetrahedron.getPointB();
            AreaPoint c = rightTetrahedron.getPointC();

            if (a.getX() == 0 && b.getX() == 0 && c.getX() == 0) {
                return true;
            }
            if (a.getY() == 0 && b.getY() == 0 && c.getY() == 0) {
                return true;
            }
            if (a.getZ() == 0 && b.getZ() == 0 && c.getZ() == 0) {
                return true;
            }
        }
        return false;
    }

    private double roundResult(double value) {
        return round(sqrt(value) * ROUND_FACTOR) / ROUND_FACTOR;
    }
}
