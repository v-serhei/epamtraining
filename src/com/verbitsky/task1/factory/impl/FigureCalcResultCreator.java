package com.verbitsky.task1.factory.impl;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.FigureCalcResult;
import com.verbitsky.task1.entity.TetrahedronCalcResult;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.factory.CalcResultsCreator;

public class FigureCalcResultCreator implements CalcResultsCreator {

    @Override
    public FigureCalcResult createCalcResult(Figure figure, double figureSquare, double figureVolume) throws FigureException {
        if (figure == null) {
            throw new FigureException("Received null argument Figure");
        }
        if (figureSquare <= 0 || figureVolume <= 0) {
            throw new FigureException("Received wrong value of square or volume");
        }
        FigureCalcResult calcResult = new TetrahedronCalcResult(figure, figureSquare, figureVolume);
        return calcResult;
    }
}
