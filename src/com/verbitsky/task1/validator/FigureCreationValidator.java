package com.verbitsky.task1.validator;

import com.verbitsky.task1.entity.AreaPoint;

import java.util.List;

public interface FigureCreationValidator {
    boolean validateFigureCreation(List<AreaPoint> pointList);
}
