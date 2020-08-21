package com.verbitsky.task1.validators.figuretypevalidator.impl;

import com.verbitsky.task1.entity.figures.impl.RightTetrahedron;

public class TetrahedronTypeValidator {
    public boolean isObjectTetrahedron(Object o) {
        return (o instanceof RightTetrahedron);
    }
}
