package com.verbitsky.task1.action.vergecalculator.impl;

import com.verbitsky.task1.action.vergecalculator.VergeCalculator;
import com.verbitsky.task1.entity.point.AreaPoint;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

public class VergeCalculatorImpl implements VergeCalculator {
    private static final double ROUND_FACTOR = 100.0;
    private static Logger logger = LogManager.getLogger();

    @Override
    public double calculateVergeSize(AreaPoint a, AreaPoint b) {
        double subX = b.getXCoordinate() - a.getXCoordinate();
        double subY = b.getYCoordinate() - a.getYCoordinate();
        double subZ = b.getZCoordinate() - a.getZCoordinate();
        double sumOfPow = pow(subX, 2) + pow(subY, 2) + pow(subZ, 2);
        //round result with two digits of rounding accuracy
        double result = round(sqrt(sumOfPow) * ROUND_FACTOR) / ROUND_FACTOR;
        logger.log(Level.INFO, "Calculate verge size: result = " + result);
        return result;
    }
}
