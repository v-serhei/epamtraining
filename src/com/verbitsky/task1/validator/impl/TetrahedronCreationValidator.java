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
    public static final int FIRST_POINT_INDEX = 0;
    public static final int SECOND_POINT_INDEX = 1;
    public static final int THIRD_POINT_INDEX = 2;
    public static final int FOURTH_POINT_INDEX = 3;
    public static final int REQUIRED_POINTS_COUNT = 4;
    public static final int NEGATIVE_VERGE_LENGTH = 0;
    private static Logger logger = LogManager.getLogger();
    private static VergeCalculator vergeCalculator = new VergeCalculatorImpl();

    @Override
    public boolean validateFigureCreation(List<AreaPoint> pointList) {
        if (pointList == null) {
            logger.log(Level.INFO, "Tetrahedron creation validator:" +
                    " creation impossible - received null AreaPoint list");
            return false;
        }
        if (pointList.size() != REQUIRED_POINTS_COUNT) {
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
        AreaPoint pointA = pointList.get(FIRST_POINT_INDEX);
        AreaPoint pointB = pointList.get(SECOND_POINT_INDEX);
        AreaPoint pointC = pointList.get(THIRD_POINT_INDEX);
        AreaPoint pointTop = pointList.get(FOURTH_POINT_INDEX);
        double abVerge;
        double acVerge;
        double bcVerge;
        double saVerge;
        double sbVerge;
        double scVerge;
        try {
            abVerge = vergeCalculator.calculateVergeSize(pointA, pointB);
            acVerge = vergeCalculator.calculateVergeSize(pointA, pointC);
            bcVerge = vergeCalculator.calculateVergeSize(pointB, pointC);
            saVerge = vergeCalculator.calculateVergeSize(pointTop, pointA);
            sbVerge = vergeCalculator.calculateVergeSize(pointTop, pointB);
            scVerge = vergeCalculator.calculateVergeSize(pointTop, pointC);
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
            if (verge <= NEGATIVE_VERGE_LENGTH) {
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
