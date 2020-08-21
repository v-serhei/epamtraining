package com.verbitsky.task1.actions.figurecalculator;

import com.verbitsky.task1.entity.figures.Figure;

public interface FigureCalculation {
    double calculateSquare (Figure figure);
    double calculateVolume (Figure figure);
    double calculateVolumeRatio (Figure figure, double subspaceHeight);
    boolean isFigureOnCoordinatesSquare (Figure figure);
}
