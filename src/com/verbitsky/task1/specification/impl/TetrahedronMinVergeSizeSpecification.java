package com.verbitsky.task1.specification.impl;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.specification.FigureSpecification;

public class TetrahedronMinVergeSizeSpecification implements FigureSpecification {
    private double minVergeLength;

    public TetrahedronMinVergeSizeSpecification(double minVergeLength) {
        this.minVergeLength = minVergeLength;
    }

    @Override
    public boolean specify(Figure figure) {
        return ((Tetrahedron) figure).getVergeLength() > minVergeLength;
    }
}