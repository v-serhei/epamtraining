package com.verbitsky.task1.validator.figuretypevalidator.impl;

import com.verbitsky.task1.entity.figure.impl.Tetrahedron;

public class TetrahedronTypeValidator {
    public boolean isObjectTetrahedron(Object o) {
        return (o instanceof Tetrahedron);
    }
}
