package com.verbitsky.task1.specification.impl;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Tetrahedron;
import com.verbitsky.task1.specification.FigureSpecification;

public class TetrahedronMaxVergeSizeSpecification implements FigureSpecification {
    private double maxVergeLength;

    public TetrahedronMaxVergeSizeSpecification(double maxVergeLength) {
        this.maxVergeLength = maxVergeLength;
    }

    @Override
    public boolean specify(Figure figure) {
        return ((Tetrahedron) figure).getVergeLength() < maxVergeLength;
    }
}