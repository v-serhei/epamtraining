package com.verbitsky.task1.factory.impl;

import com.verbitsky.task1.action.FigureCalculator;
import com.verbitsky.task1.action.impl.TetrahedronCalculator;
import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.FigureCalcResult;
import com.verbitsky.task1.entity.TetrahedronCalcResult;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.factory.CalcResultsCreator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureCalcResultCreator implements CalcResultsCreator {
    private static FigureCalculator figureCalculator = TetrahedronCalculator.INSTANCE;
    private static Logger logger = LogManager.getLogger();

    @Override
    public FigureCalcResult createCalcResult(Figure figure) throws FigureException {
        if (figure == null) {
            throw new FigureException ("FigureCalcResultCreator: received figure = null");
        }
        double square = 0;
        double volume = 0;
        try {
            square = figureCalculator.calculateSquare(figure);
            volume = figureCalculator.calculateVolume(figure);
        } catch (FigureException e) {
            logger.log(Level.INFO, "FigureCalcResultCreator: calculation of figure's parameters fail");
        }
        FigureCalcResult calcResult = new TetrahedronCalcResult(figure, square, volume);
        return calcResult;
    }
}
