package com.verbitsky.task1.validator.figurecreatevalidator.impl;

import com.verbitsky.task1.action.vergecalculator.VergeCalculator;
import com.verbitsky.task1.action.vergecalculator.impl.VergeCalculatorImpl;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.validator.figurecreatevalidator.FigureCreationValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TetrahedronCreationValidator implements FigureCreationValidator {
    private static Logger logger = LogManager.getLogger();
    private static VergeCalculator vergeCalculator = new VergeCalculatorImpl();
    @Override
    public boolean validateFigureCreation(List<AreaPoint> pointList) {
        if (pointList.size() != 4) {
            logger.log(Level.INFO, "Tetrahedron creation validator: wrong points count");
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
            logger.log(Level.INFO, "Tetrahedron creation validator: wrong verge length");
            return false;
        }
        if (abVerge != acVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: different verges size");
            return false;
        }
        if (acVerge != bcVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: different verges size");
            return false;
        }
        if (saVerge != abVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: different verges size");
            return false;
        }
        if (saVerge != sbVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: different verges size");
            return false;
        }
        if (sbVerge != scVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: different verges size");
            return false;
        }
        logger.log(Level.INFO, "Tetrahedron creation validator: creation is possible");
        return true;
    }
}
