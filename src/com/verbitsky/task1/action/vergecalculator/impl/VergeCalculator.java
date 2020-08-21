package com.verbitsky.task1.action.vergecalculator.impl;

import com.verbitsky.task1.action.vergecalculator.VergeCalculation;
import com.verbitsky.task1.entity.point.AreaPoint;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.round;

public class VergeCalculator implements VergeCalculation {
    private static final double ROUND_FACTOR = 100.0;

    @Override
    public double calculateVergeSize(AreaPoint a, AreaPoint b) {
        double subX = b.getX() - a.getX();
        double subY = b.getY() - a.getY();
        double subZ = b.getZ() - a.getZ();
        double sumOfPow = pow(subX, 2) + pow(subY, 2) + pow(subZ, 2);
        //returns rounded result with two digits of rounding accuracy
        return round(sqrt(sumOfPow) * ROUND_FACTOR) / ROUND_FACTOR;
    }
}
