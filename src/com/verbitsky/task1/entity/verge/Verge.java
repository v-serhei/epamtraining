package com.verbitsky.task1.entity.verge;

import com.verbitsky.task1.action.vergecalculator.impl.VergeCalculator;
import com.verbitsky.task1.entity.point.AreaPoint;

public class Verge {
    private double vergeSize;

    public Verge(AreaPoint a, AreaPoint b) {
        VergeCalculator calculator = new VergeCalculator();
        this.vergeSize = calculator.calculateVergeSize(a , b);
    }

    public Verge(double vergeSize) {
        this.vergeSize = vergeSize;
    }


    public double getVergeSize() {
        return vergeSize;
    }
}
