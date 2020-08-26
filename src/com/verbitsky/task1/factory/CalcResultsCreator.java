package com.verbitsky.task1.factory;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.entity.FigureCalcResult;

public interface CalcResultsCreator {
    FigureCalcResult createCalcResult(Figure figure) throws FigureException;
}
