package com.verbitsky.task1.action.impl;

import com.verbitsky.task1.action.VergeCalculator;
import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class VergeCalculatorImpl implements VergeCalculator {
    private static Logger logger = LogManager.getLogger();

    @Override
    public double calculateVergeSize(AreaPoint a, AreaPoint b) throws FigureException {
        if (a == null || b == null) {
            throw new FigureException("Method calculateVergeSize: received null object");
        }
        double subX = b.getXCoordinate() - a.getXCoordinate();
        double subY = b.getYCoordinate() - a.getYCoordinate();
        double subZ = b.getZCoordinate() - a.getZCoordinate();
        double sumOfPow = pow(subX, 2) + pow(subY, 2) + pow(subZ, 2);
        double result = sqrt(sumOfPow);
        logger.log(Level.INFO, "Calculate verge size: result = " + result);
        return result;
    }
}
