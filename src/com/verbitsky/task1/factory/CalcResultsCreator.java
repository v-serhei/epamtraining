package com.verbitsky.task1.factory;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.FigureCalcResult;
import com.verbitsky.task1.exception.FigureException;

public interface CalcResultsCreator {
    FigureCalcResult createCalcResult(Figure figure, double figureSquare, double figureVolume) throws FigureException;
}
