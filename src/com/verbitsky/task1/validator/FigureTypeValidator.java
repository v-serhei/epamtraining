package com.verbitsky.task1.validator;

import com.verbitsky.task1.exception.FigureException;

public interface FigureTypeValidator {
    boolean isObjectFigure(Object o) throws FigureException;
}
