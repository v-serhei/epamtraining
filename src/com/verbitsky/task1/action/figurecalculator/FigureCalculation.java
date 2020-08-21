package com.verbitsky.task1.action.figurecalculator;

import com.verbitsky.task1.entity.figure.Figure;

public interface FigureCalculation {
    double calculateSquare (Figure figure);
    double calculateVolume (Figure figure);
    double calculateVolumeRatio (Figure figure, double subspaceHeight);
    boolean isFigureOnCoordinatesSquare (Figure figure);
}
