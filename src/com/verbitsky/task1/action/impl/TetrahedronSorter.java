package com.verbitsky.task1.action.impl;

import com.verbitsky.task1.action.FigureSorter;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Tetrahedron;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TetrahedronSorter implements FigureSorter {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void sortFiguresById(List<Figure> figures, boolean reversedOrder) {
        if (figures != null && !figures.isEmpty()) {
            figures.sort((o1, o2) -> {
                if (reversedOrder) {
                    return Long.compare(o2.getFigureId(), o1.getFigureId());
                } else {
                    return Long.compare(o1.getFigureId(), o2.getFigureId());
                }
            });
            logger.log(Level.INFO, "TetrahedronSorter: items sorted by figureId field");
        } else {
            logger.log(Level.INFO, "TetrahedronSorter: empty or null arguments");
        }
    }

    @Override
    public void sortFiguresByFirstPointCoordinateX(List<Figure> figures, boolean reversedOrder) {
        if (figures != null && !figures.isEmpty()) {
            figures.sort((o1, o2) -> {
                double firstX = 0;
                double secondX = 0;
                try {
                    firstX = ((Tetrahedron) o1).getPointA().getXCoordinate();
                    secondX = ((Tetrahedron) o2).getPointA().getXCoordinate();
                } catch (ClassCastException ex) {
                    logger.log(Level.INFO, "TetrahedronSorter: unsupported figure type, true sorting results not granted");
                }
                if (reversedOrder) {
                    return Double.compare(secondX, firstX);
                } else {
                    return Double.compare(firstX, secondX);
                }
            });
            logger.log(Level.INFO, "TetrahedronSorter: items sorted by first point coordinate X");
        } else {
            logger.log(Level.INFO, "TetrahedronSorter: empty or null arguments");
        }
    }
}
