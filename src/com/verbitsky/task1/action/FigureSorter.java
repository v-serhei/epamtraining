package com.verbitsky.task1.action;

import com.verbitsky.task1.entity.Figure;

import java.util.List;

public interface FigureSorter {

    void sortFiguresById(List<Figure> figures, boolean reversedOrder);

    void sortFiguresByFirstPointCoordinateX(List<Figure> figures, boolean reversedOrder);
}
