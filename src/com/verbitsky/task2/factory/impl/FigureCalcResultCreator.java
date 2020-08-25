package com.verbitsky.task2.factory.impl;

import com.verbitsky.task1.action.figurecalculator.FigureCalculator;
import com.verbitsky.task1.action.figurecalculator.impl.TetrahedronCalculator;
import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task2.entity.figurecalcresult.FigureCalcResult;
import com.verbitsky.task2.entity.figurecalcresult.impl.TetrahedronCalcResult;
import com.verbitsky.task2.factory.CalcResultsCreator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureCalcResultCreator implements CalcResultsCreator {
    private static FigureCalculator figureCalculator;
    private static Logger logger = LogManager.getLogger();

    public FigureCalcResultCreator() {
        figureCalculator = new TetrahedronCalculator();
    }

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
