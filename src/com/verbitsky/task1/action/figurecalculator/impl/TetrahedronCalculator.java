package com.verbitsky.task1.action.figurecalculator.impl;

import com.verbitsky.task1.action.figurecalculator.FigureCalculator;
import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.validator.figuretypevalidator.impl.TetrahedronTypeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

public class TetrahedronCalculator implements FigureCalculator {
    private static Logger logger = LogManager.getLogger();
    private static final double ROUND_FACTOR = 100.0;
    private TetrahedronTypeValidator tetrahedronTypeValidator = new TetrahedronTypeValidator();

    @Override
    public double calculateSquare(Figure figure) {
        double result = 0.0;
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            result = pow(tetrahedron.getVergeSize(), 2) * sqrt(3);
            logger.log(Level.INFO, "Calculate tetrahedron square: result = " + roundResult(result));
        } else {
            logger.log(Level.INFO, "Calculate tetrahedron square: received object is not an instance of Tetrahedron");
        }
        return roundResult(result);

    }

    @Override
    public double calculateVolume(Figure figure) {
        double result = 0.0;
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            result = (pow(tetrahedron.getVergeSize(), 3) * sqrt(2)) / 12;
            logger.log(Level.INFO, "Calculate tetrahedron volume: result = " + roundResult(result));
        } else {
            logger.log(Level.INFO, "Calculate tetrahedron volume: received object is not an instance of Tetrahedron");
        }
        return roundResult(result);
    }

    @Override
    public double calculateVolumeRatio(Figure figure, double subspaceHeight) {
        double result = 0.0;
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
                result = roundResult(remainFigureVolume / reducedTetrahedronVolume);
            } else {
                result = roundResult(reducedTetrahedronVolume / remainFigureVolume);
            }
            logger.log(Level.INFO, "Calculate tetrahedrons ratio: result = " + result);
        } else {
            logger.log(Level.INFO, "Calculate tetrahedron ratio: received object is not an instance of Tetrahedron");
        }
        return result;
    }

    @Override
    public boolean isFigureOnCoordinatesPlane(Figure figure) {
        boolean flag = false;
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            flag = true;
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            AreaPoint a = tetrahedron.getPointA();
            AreaPoint b = tetrahedron.getPointB();
            AreaPoint c = tetrahedron.getPointC();
            if (a.getXCoordinate() == 0 && b.getXCoordinate() == 0 && c.getXCoordinate() == 0) {
                logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedrons is on YZ-coordinates plane");
                return true;
            }
            if (a.getYCoordinate() == 0 && b.getYCoordinate() == 0 && c.getYCoordinate() == 0) {
                logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedrons is on XZ-coordinates plane");
                return true;
            }
            if (a.getZCoordinate() == 0 && b.getZCoordinate() == 0 && c.getZCoordinate() == 0) {
                logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedrons is on XY-coordinates plane");
                return true;
            }
        } else {
            logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: received object is not an instance of Tetrahedron");
        }
        logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedrons not located on any coordinate plane");
        return false;
    }

    private double roundResult(double value) {
        return round(sqrt(value) * ROUND_FACTOR) / ROUND_FACTOR;
    }
}
