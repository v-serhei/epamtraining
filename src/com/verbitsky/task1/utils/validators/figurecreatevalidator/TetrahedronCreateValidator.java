package com.verbitsky.task1.utils.validators.figurecreatevalidator;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.entity.verge.Verge;

public class TetrahedronCreateValidator {
    public boolean isTetrahedronCreationPossible(AreaPoint a, AreaPoint b, AreaPoint c, AreaPoint s) {
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
