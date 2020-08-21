package com.verbitsky.task1.validators.figurecreatevalidator;

import com.verbitsky.task1.entity.point.AreaPoint;

public interface FigureCreationValidator {
    boolean isTetrahedronCreationPossible(AreaPoint ... points);
}
