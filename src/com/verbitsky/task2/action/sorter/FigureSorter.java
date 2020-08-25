package com.verbitsky.task2.action.sorter;

import com.verbitsky.task1.entity.figure.Figure;

import java.util.List;

public interface FigureSorter {
    List<Figure> sortFiguresById(Figure... figures);

    List<Figure> sortFiguresByFirstPointCoordinateX(Figure... figures);

    List<Figure> sortFiguresById(List<Figure> figures);

    List<Figure> sortFiguresByFirstPointCoordinateX(List<Figure> figures);
}
