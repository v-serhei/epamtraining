package com.verbitsky.task1.validator.figurecreatevalidator.impl;

import com.verbitsky.task1.action.vergecalculator.VergeCalculator;
import com.verbitsky.task1.action.vergecalculator.impl.VergeCalculatorImpl;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.validator.figurecreatevalidator.FigureCreationValidator;

import java.util.List;

public class TetrahedronCreationValidator implements FigureCreationValidator {
    private static VergeCalculator vergeCalculator = new VergeCalculatorImpl();
    @Override
    public boolean validateFigureCreation(List<AreaPoint> pointList) {
        if (pointList.size() != 4) {
            //todo log "wrong point count"
            return false;
        }
        AreaPoint a = pointList.get(0);
        AreaPoint b = pointList.get(1);
        AreaPoint c = pointList.get(2);
        AreaPoint s = pointList.get(3);
        double abVerge = vergeCalculator.calculateVergeSize(a, b);
        double acVerge = vergeCalculator.calculateVergeSize(a, c);
        double bcVerge = vergeCalculator.calculateVergeSize(b, c);
        double saVerge = vergeCalculator.calculateVergeSize(s, a);
        double sbVerge = vergeCalculator.calculateVergeSize(s, b);
        double scVerge = vergeCalculator.calculateVergeSize(s, c);
        if (abVerge == 0.0) {
            //todo log "wrong verge length"
            return false;
        }
        if (abVerge != acVerge) {
            //todo log "different verges size
            return false;
        }
        if (acVerge != bcVerge) {
            return false;
        }
        if (saVerge != abVerge) {
            return false;
        }
        if (saVerge != sbVerge) {
            return false;
        }
        if (sbVerge != scVerge) {
            return false;
        }
        return true;
    }
}
