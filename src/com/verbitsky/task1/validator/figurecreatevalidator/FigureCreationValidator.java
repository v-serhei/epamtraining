package com.verbitsky.task1.validator.figurecreatevalidator;

import com.verbitsky.task1.entity.point.AreaPoint;

import java.util.List;

public interface FigureCreationValidator {
    boolean validateFigureCreation(List<AreaPoint> pointList);
}
