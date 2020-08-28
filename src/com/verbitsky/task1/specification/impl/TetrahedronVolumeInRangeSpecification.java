package com.verbitsky.task1.specification.impl;

import com.verbitsky.task1.action.impl.TetrahedronCalculator;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.specification.FigureSpecification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class TetrahedronVolumeInRangeSpecification implements FigureSpecification {
    private double maxVolume;
    private double minVolume;

    public TetrahedronVolumeInRangeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Figure figure) {
        boolean result = false;
        try {
            double figureSquare = TetrahedronCalculator.INSTANCE.calculateVolume(figure);
            result = figureSquare >= minVolume && figureSquare <= maxVolume;
        } catch (FigureException e) {
            LogManager.getLogger().log(Level.INFO, "Can't calculate figure volume");
        }
        return result;
    }
}
