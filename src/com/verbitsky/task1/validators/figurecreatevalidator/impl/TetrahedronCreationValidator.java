package com.verbitsky.task1.validators.figurecreatevalidator.impl;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.entity.verge.Verge;
import com.verbitsky.task1.validators.figurecreatevalidator.FigureCreationValidator;

public class TetrahedronCreationValidator implements FigureCreationValidator {
    @Override
    public boolean isTetrahedronCreationPossible(AreaPoint ... points) {
        if (points.length < 4) {
            return false;
        }
        AreaPoint a = points[0];
        AreaPoint b = points[1];
        AreaPoint c = points[2];
        AreaPoint s = points[3];
        Verge abVerge = new Verge(a, b);
        Verge acVerge = new Verge(a, c);
        Verge bcVerge = new Verge(b, c);
        Verge saVerge = new Verge(s, a);
        Verge sbVerge = new Verge(s, b);
        Verge scVerge = new Verge(s, c);
        if (abVerge.getVergeSize() == 0.0) {
            return false;
        }
        if (abVerge.getVergeSize() != acVerge.getVergeSize()) {
            return false;
        }
        if (acVerge.getVergeSize() != bcVerge.getVergeSize()) {
            return false;
        }
        if (saVerge.getVergeSize() != abVerge.getVergeSize()) {
            return false;
        }
        if (saVerge.getVergeSize() != sbVerge.getVergeSize()) {
            return false;
        }
        if (sbVerge.getVergeSize() != scVerge.getVergeSize()) {
            return false;
        }
        return true;
    }
}
