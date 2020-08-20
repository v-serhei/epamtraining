package com.verbitsky.task1.utils.validators.figuretypechecker;

import com.verbitsky.task1.entity.figures.Tetrahedron;

public class TetrahedronTypeChecker {
    public boolean isObjectTetrahedron(Object o) {
        return (o instanceof Tetrahedron);
    }
}
