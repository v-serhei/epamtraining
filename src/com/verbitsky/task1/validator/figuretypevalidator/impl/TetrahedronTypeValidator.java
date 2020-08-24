package com.verbitsky.task1.validator.figuretypevalidator.impl;

import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.validator.figuretypevalidator.FigureTypeValidator;

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
