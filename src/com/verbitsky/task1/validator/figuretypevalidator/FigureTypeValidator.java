package com.verbitsky.task1.validator.figuretypevalidator;

import com.verbitsky.task1.exception.FigureException;

public interface FigureTypeValidator {
    boolean isObjectFigure(Object o) throws FigureException;
}
