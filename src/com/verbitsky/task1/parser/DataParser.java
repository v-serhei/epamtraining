package com.verbitsky.task1.parser;

import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.validator.FigureDataValidator;

import java.util.List;

public interface DataParser {
    List<AreaPoint> parseAreaPointsFromLine(String line, FigureDataValidator figureDataValidator);
}
