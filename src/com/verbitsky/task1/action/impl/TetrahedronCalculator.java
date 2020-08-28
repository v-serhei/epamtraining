package com.verbitsky.task1.action.impl;

import com.verbitsky.task1.action.FigureCalculator;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.validator.impl.TetrahedronTypeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

public enum TetrahedronCalculator implements FigureCalculator {
    INSTANCE;
    private static Logger logger = LogManager.getLogger();
    private static TetrahedronTypeValidator tetrahedronTypeValidator = new TetrahedronTypeValidator();

    @Override
    public double calculateSquare(Figure figure) throws FigureException {
        if (figure ==null) {
            throw new FigureException("Calculate tetrahedron square: method call with null");
        }
        double result = 0.0;
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            double verge = tetrahedron.getVergeLength();
            result = pow(verge, 2) * sqrt(3);
            logger.log(Level.INFO, "Calculate tetrahedron square: result = " + result);
        } else {
            logger.log(Level.INFO, "Calculate tetrahedron square: received object is not an instance of Tetrahedron");
        }
        return result;
    }

    @Override
    public double calculateVolume(Figure figure) throws FigureException {
        if (figure ==null) {
            throw new FigureException("Calculate tetrahedron volume: method call with null");
        }
        double result = 0.0;
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            result = (pow(tetrahedron.getVergeLength(), 3) * sqrt(2)) / 12;
            logger.log(Level.INFO, "Calculate tetrahedron volume: result = " + result);
        } else {
            logger.log(Level.INFO, "Calculate tetrahedron volume: received object is not an instance of Tetrahedron");
        }
        return result;
    }

    @Override
    public double calculateVolumeRatio(Figure figure, double subspaceHeight) throws FigureException {
        if (figure ==null || subspaceHeight == 0) {
            throw new FigureException("Calculate tetrahedrons ratio: method call with null");
        }
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
                result = remainFigureVolume / reducedTetrahedronVolume;
            } else {
                result = reducedTetrahedronVolume / remainFigureVolume;
            }
            logger.log(Level.INFO, "Calculate tetrahedrons ratio: result = " + result);
        } else {
            logger.log(Level.INFO, "Calculate tetrahedron ratio: received object is not an instance of Tetrahedron");
        }
        return result;
    }

    public boolean isFigureOnCoordinatesPlane(Figure figure) throws FigureException {
        if (figure ==null) {
            throw new FigureException("Is tetrahedrons on coordinates plane: method call with null");
        }
        if (tetrahedronTypeValidator.isObjectFigure(figure)) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            AreaPoint pointA = tetrahedron.getPointA();
            AreaPoint pointB = tetrahedron.getPointB();
            AreaPoint pointC = tetrahedron.getPointC();
            if (pointA.getXCoordinate() == 0 && pointB.getXCoordinate() == 0 && pointC.getXCoordinate() == 0) {
                logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedron is on YZ-coordinates plane");
                return true;
            }
            if (pointA.getYCoordinate() == 0 && pointB.getYCoordinate() == 0 && pointC.getYCoordinate() == 0) {
                logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedron is on XZ-coordinates plane");
                return true;
            }
            if (pointA.getZCoordinate() == 0 && pointB.getZCoordinate() == 0 && pointC.getZCoordinate() == 0) {
                logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedron is on XY-coordinates plane");
                return true;
            }
        } else {
            logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: received object is not an instance of Tetrahedron");
        }
        logger.log(Level.INFO, "Is tetrahedrons on coordinates plane: Tetrahedron not located on any coordinate plane");
        return false;
    }
}
