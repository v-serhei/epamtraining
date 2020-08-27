package com.verbitsky.task1.observer.impl;

import com.verbitsky.task1.action.impl.TetrahedronCalculator;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.FigureCalcResult;
import com.verbitsky.task1.entity.TetrahedronCalcResult;
import com.verbitsky.task1.entity.Warehouse;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.observer.FigureObserver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class TetrahedronObserver implements FigureObserver {
    @Override
    public void actionPerformed(Figure figure) {
        try {
            double square = TetrahedronCalculator.INSTANCE.calculateSquare(figure);
            double volume = TetrahedronCalculator.INSTANCE.calculateVolume(figure);
            FigureCalcResult result = new TetrahedronCalcResult(figure, square, volume);
            Warehouse.INSTANCE.put(figure.getFigureId(), result);
        } catch (FigureException e) {
            LogManager.getLogger().log(Level.INFO, "Can't calculate figure parameters");
        }
    }
}
