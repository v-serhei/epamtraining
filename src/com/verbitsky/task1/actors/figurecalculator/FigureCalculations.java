package com.verbitsky.task1.actors.figurecalculator;

import com.verbitsky.task1.entity.figures.Figure;

public interface FigureCalculations {
    double calculateSquare (Figure figure);
    double calculateVolume (Figure figure);
    double calculateVolumeRatio (Figure figure, double subspaceHeight);
    boolean isFigureOnCoordinatesSquare (Figure figure);
}
