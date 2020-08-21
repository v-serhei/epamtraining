package com.verbitsky.task1.validator.figurecreatevalidator.impl;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.entity.verge.Verge;
import com.verbitsky.task1.validator.figurecreatevalidator.FigureCreationValidator;

import java.util.List;

public class TetrahedronCreationValidator implements FigureCreationValidator {
    @Override
    public boolean validateFigureCreation(List<AreaPoint> pointList) {
        if (pointList.size() != 4) {
            //todo log "wrong point count"
            return false;
        }
        AreaPoint a = pointList.get(0);
        AreaPoint b = pointList.get(1);
        AreaPoint c = pointList.get(2);
        AreaPoint s = pointList.get(3);
        Verge abVerge = new Verge(a, b);
        Verge acVerge = new Verge(a, c);
        Verge bcVerge = new Verge(b, c);
        Verge saVerge = new Verge(s, a);
        Verge sbVerge = new Verge(s, b);
        Verge scVerge = new Verge(s, c);
        if (abVerge.getVergeSize() == 0.0) {
            //todo log "wrong verge length"
            return false;
        }
        if (abVerge.getVergeSize() != acVerge.getVergeSize()) {
            //todo log "different verges size
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
