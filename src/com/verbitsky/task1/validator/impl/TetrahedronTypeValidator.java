package com.verbitsky.task1.validator.impl;

import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.validator.FigureTypeValidator;

public class TetrahedronTypeValidator implements FigureTypeValidator {
    @Override
    public boolean isObjectFigure(Object o) throws FigureException {
        boolean result;
        if (o == null) {
            throw new FigureException("Method isObjectFigure getting null object");
        }else {
            result = o instanceof Tetrahedron;
        }
        return result;
    }
}
