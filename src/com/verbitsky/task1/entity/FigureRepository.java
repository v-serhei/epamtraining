package com.verbitsky.task1.entity;

import com.verbitsky.task1.specification.FigureSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum FigureRepository {
    INSTANCE;
    private List<Tetrahedron> figureList = new ArrayList<>();

    public List<Tetrahedron> query(FigureSpecification figureSpecification) {
        List<Tetrahedron> result = figureList.stream()
                .filter(figureSpecification::specify)
                .collect(Collectors.toList());
        return result;
    }

    public int size() {
        return figureList.size();
    }

    public boolean add(Tetrahedron tetrahedron) {
        return figureList.add(tetrahedron);
    }

    public boolean remove(Tetrahedron o) {
        return figureList.remove(o);
    }

    public void sort(Comparator<? super Tetrahedron> c) {
        figureList.sort(c);
    }

    public Tetrahedron get(int index) {
        return figureList.get(index);
    }

    public Tetrahedron remove(int index) {
        return figureList.remove(index);
    }
}
