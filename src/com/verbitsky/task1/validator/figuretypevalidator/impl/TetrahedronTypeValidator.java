package com.verbitsky.task1.validator.figuretypevalidator.impl;

import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.validator.figuretypevalidator.FigureTypeValidator;

public class TetrahedronTypeValidator implements FigureTypeValidator {
    @Override
    public boolean isObjectFigure(Object o) {
        return (o instanceof Tetrahedron);
    }
}
