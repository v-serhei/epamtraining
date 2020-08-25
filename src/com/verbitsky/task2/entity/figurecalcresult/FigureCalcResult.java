package com.verbitsky.task2.entity.figurecalcresult;

import com.verbitsky.task1.entity.figure.Figure;

public abstract class FigureCalcResult {
    private Figure figure;

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "Base calculation results for figure";
    }
}
