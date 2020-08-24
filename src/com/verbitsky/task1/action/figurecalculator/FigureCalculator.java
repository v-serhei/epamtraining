package com.verbitsky.task1.action.figurecalculator;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.exception.FigureException;

public interface FigureCalculator {
    double calculateSquare (Figure figure) throws FigureException;
    double calculateVolume (Figure figure) throws FigureException;
    double calculateVolumeRatio (Figure figure, double subspaceHeight) throws FigureException;
    boolean isFigureOnCoordinatesPlane(Figure figure) throws FigureException;
}
