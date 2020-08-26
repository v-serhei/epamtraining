package com.verbitsky.task1.validator.impl;

import com.verbitsky.task1.action.VergeCalculator;
import com.verbitsky.task1.action.impl.VergeCalculatorImpl;
import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.validator.FigureCreationValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronCreationValidator implements FigureCreationValidator {
    private static Logger logger = LogManager.getLogger();
    private static VergeCalculator vergeCalculator = new VergeCalculatorImpl();

    @Override
    public boolean validateFigureCreation(List<AreaPoint> pointList) {
        if (pointList == null) {
            logger.log(Level.INFO, "Tetrahedron creation validator:" +
                    " creation impossible - received null AreaPoint list");
            return false;
        }
        if (pointList.size() != 4) {
            logger.log(Level.INFO, "Tetrahedron creation validator:" +
                    " creation impossible - wrong points count");
            return false;
        }
        for (AreaPoint areaPoint : pointList) {
            if (areaPoint == null) {
                logger.log(Level.INFO, "Tetrahedron creation validator:" +
                        " creation impossible - one of AreaPoints in list is null");
                return false;
            }
        }
        AreaPoint a = pointList.get(0);
        AreaPoint b = pointList.get(1);
        AreaPoint c = pointList.get(2);
        AreaPoint s = pointList.get(3);
        double abVerge;
        double acVerge;
        double bcVerge;
        double saVerge;
        double sbVerge;
        double scVerge;
        try {
            abVerge = vergeCalculator.calculateVergeSize(a, b);
            acVerge = vergeCalculator.calculateVergeSize(a, c);
            bcVerge = vergeCalculator.calculateVergeSize(b, c);
            saVerge = vergeCalculator.calculateVergeSize(s, a);
            sbVerge = vergeCalculator.calculateVergeSize(s, b);
            scVerge = vergeCalculator.calculateVergeSize(s, c);
        } catch (FigureException ex) {
            logger.log(Level.INFO, "Tetrahedron creation validator: " +
                    "creation impossible - can't calculate all verges length");
            return false;
        }
        List<Double> verges = new ArrayList<>();
        verges.add(acVerge);
        verges.add(abVerge);
        verges.add(bcVerge);
        verges.add(saVerge);
        verges.add(sbVerge);
        verges.add(scVerge);
        for (Double verge : verges) {
            if (verge <= 0.0) {
                logger.log(Level.INFO, "Tetrahedron creation validator: creation impossible - wrong verge length");
                return false;
            }
        }
        if (abVerge != acVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: creation impossible - different verges length");
            return false;
        }
        if (acVerge != bcVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: creation impossible - different verges length");
            return false;
        }
        if (saVerge != abVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: creation impossible - different verges length");
            return false;
        }
        if (saVerge != sbVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: creation impossible - different verges length");
            return false;
        }
        if (sbVerge != scVerge) {
            logger.log(Level.INFO, "Tetrahedron creation validator: creation impossible - different verges length");
            return false;
        }
        logger.log(Level.INFO, "Tetrahedron creation validator: creation possible");
        return true;
    }
}
