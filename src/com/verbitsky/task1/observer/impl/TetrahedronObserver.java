package com.verbitsky.task1.observer.impl;

import com.verbitsky.task1.entity.Figure;
import com.verbitsky.task1.entity.Warehouse;
import com.verbitsky.task1.observer.FigureObserver;

public class TetrahedronObserver implements FigureObserver {
    @Override
    public void actionPerformed(Figure figure) {
        Warehouse.INSTANCE.updateCalculations(figure);
    }
}
