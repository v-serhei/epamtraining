package com.verbitsky.task1.factory.figurefactory;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.point.AreaPoint;

import java.util.List;

public interface FigureCreator {
    Figure createFigure(List<AreaPoint> pointList);
}