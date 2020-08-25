package com.verbitsky.task2.factory;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task2.entity.figurecalcresult.FigureCalcResult;

public interface CalcResultsCreator {
    FigureCalcResult createCalcResult(Figure figure) throws FigureException;
}
