package com.verbitsky.task1.actors.figurecalculator;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.entity.figures.Figure;
import com.verbitsky.task1.entity.figures.Tetrahedron;
import com.verbitsky.task1.entity.verge.Verge;
import com.verbitsky.task1.utils.validators.figuretypechecker.TetrahedronTypeChecker;

import static java.lang.Math.*;

public class TetrahedronCalculator implements FigureCalculations {

    private static final double ROUND_FACTOR = 100.0;
    private TetrahedronTypeChecker tetrahedronTypeChecker = new TetrahedronTypeChecker();


    @Override
    public double calculateSquare(Figure figure) {
        if (tetrahedronTypeChecker.isObjectTetrahedron(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            Verge verge = tetrahedron.getVerge();
            double res = pow (verge.getVergeSize(), 2)* sqrt(3);
            return roundResult(res);
        }
        return 0;
    }

    @Override
    public double calculateVolume(Figure figure) {
        if (tetrahedronTypeChecker.isObjectTetrahedron(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            Verge verge = tetrahedron.getVerge();
            double res = (pow(verge.getVergeSize(), 3) * sqrt(2)) / 12;
            return roundResult(res);
        }
        return 0;
    }

    @Override
    public double calculateVolumeRatio(Figure figure, double subspaceHeight) {
        if (tetrahedronTypeChecker.isObjectTetrahedron(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            AreaPoint buf = tetrahedron.getPointA();
            AreaPoint reducedAPoint = new AreaPoint(buf.getX(), subspaceHeight, buf.getZ());
            buf = tetrahedron.getPointB();
            AreaPoint reducedBPoint = new AreaPoint(buf.getX(), subspaceHeight, buf.getZ());
            buf = tetrahedron.getPointC();
            AreaPoint reducedCPoint = new AreaPoint(buf.getX(), subspaceHeight, buf.getZ());

            double fullTetrahedronVolume = calculateVolume(tetrahedron);
            double reducedTetrahedronVolume = calculateVolume(
                    new Tetrahedron(reducedAPoint, reducedBPoint, reducedCPoint, tetrahedron.getHeightPoint()));
            double remainFigureVolume = fullTetrahedronVolume - reducedTetrahedronVolume;

            if (remainFigureVolume > reducedTetrahedronVolume) {
                return roundResult(remainFigureVolume/reducedTetrahedronVolume);
            } else {
                return roundResult(reducedTetrahedronVolume/remainFigureVolume);
            }
        }
        return 0;
    }

    @Override
    public boolean isFigureOnCoordinatesSquare(Figure figure) {
        if (tetrahedronTypeChecker.isObjectTetrahedron(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            AreaPoint a = tetrahedron.getPointA();
            AreaPoint b = tetrahedron.getPointB();
            AreaPoint c = tetrahedron.getPointC();

            if (a.getX()==0 && b.getX() ==0 && c.getX() ==0) {
                return true;
            }
            if (a.getY()==0 && b.getY() ==0 && c.getY() ==0) {
                return true;
            }

            if (a.getZ()==0 && b.getZ() ==0 && c.getZ() ==0) {
                return true;
            }
        }
        return false;
    }

    private double roundResult(double value) {
        return round(sqrt(value) * ROUND_FACTOR) / ROUND_FACTOR;
    }
}
