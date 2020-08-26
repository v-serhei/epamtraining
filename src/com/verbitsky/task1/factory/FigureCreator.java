package com.verbitsky.task1.factory;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.AreaPoint;
import com.verbitsky.task1.exception.FigureException;

import java.util.List;

public interface FigureCreator {
    Figure createFigure(List<AreaPoint> pointList) throws FigureException;
}
