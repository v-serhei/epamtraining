package com.verbitsky.task1.action;

import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.exception.FigureException;

public interface VergeCalculator {
    double calculateVergeSize(AreaPoint a, AreaPoint b) throws FigureException;
}
