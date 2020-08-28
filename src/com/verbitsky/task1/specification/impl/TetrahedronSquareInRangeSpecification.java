package com.verbitsky.task1.specification.impl;

import com.verbitsky.task1.action.impl.TetrahedronCalculator;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.specification.FigureSpecification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class TetrahedronSquareInRangeSpecification implements FigureSpecification {
    private double minSquare;

    public TetrahedronSquareInRangeSpecification(double minSquare) {
        this.minSquare = minSquare;
    }

    @Override
    public boolean specify(Figure figure) {
        boolean result = false;
        try {
            double figureSquare = TetrahedronCalculator.INSTANCE.calculateSquare(figure);
            result = figureSquare > minSquare;
        } catch (FigureException e) {
            LogManager.getLogger().log(Level.INFO, "Can't calculate figure square");
        }
        return result;
    }
}
