package com.verbitsky.task1.entity.figure;

import com.verbitsky.task1.generator.FigureIdGenerator;

public abstract class Figure {
    private long figureId;

    public void setFigureId() {
        this.figureId = FigureIdGenerator.generateId();
    }

    public long getFigureId() {
        return figureId;
    }

    @Override
    public String toString() {
        return "BaseFigure: figureId = "+ figureId;
    }
}
