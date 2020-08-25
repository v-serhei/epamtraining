package com.verbitsky.task2.action.sorter.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task2.action.sorter.FigureSorter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TetrahedronSorter implements FigureSorter {
    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Figure> sortFiguresById(List<Figure> figures) {
        if (figures != null && !figures.isEmpty()) {
            figures.sort(Comparator.comparingLong(Figure::getFigureId));
            logger.log(Level.INFO, "TetrahedronSorter: items sorted by figureId field");
        } else {
            logger.log(Level.INFO, "TetrahedronSorter: empty or null arguments");
        }
        return figures;
    }

    @Override
    public List<Figure> sortFiguresByFirstPointCoordinateX(List<Figure> figures) {
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
                return Double.compare(firstX, secondX);
            });
            logger.log(Level.INFO, "TetrahedronSorter: items sorted by figureId field");
        } else {
            logger.log(Level.INFO, "TetrahedronSorter: empty or null arguments");
        }
        return figures;
    }

    @Override
    public List<Figure> sortFiguresById(Figure... figures) {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        list = sortFiguresById(list);
        return list;
    }

    @Override
    public List<Figure> sortFiguresByFirstPointCoordinateX(Figure... figures) {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        list = sortFiguresByFirstPointCoordinateX(list);
        return list;
    }
}
