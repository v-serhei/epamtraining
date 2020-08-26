package com.verbitsky.task1.validator.impl;

import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.validator.FigureTypeValidator;

public class TetrahedronTypeValidator implements FigureTypeValidator {
    @Override
    public boolean isObjectFigure(Object object) {
        if (object == null) {
            return false;
        }
        return object instanceof Tetrahedron;
    }
}
