package com.verbitsky.task1.action.vergecalculator;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.exception.FigureException;

public interface VergeCalculator {
     double calculateVergeSize(AreaPoint a, AreaPoint b) throws FigureException;
}
