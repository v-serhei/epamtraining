package com.verbitsky.task1.comparator;

import com.verbitsky.task1.entity.Tetrahedron;

import java.util.Comparator;

public enum TetrahedronComparator implements Comparator<Tetrahedron> {
    ID {
        @Override
        public int compare(Tetrahedron o1, Tetrahedron o2) {
            return Long.compare(o1.getFigureId(), o2.getFigureId());
        }
    },

    COORDINATE_X {
        @Override
        public int compare(Tetrahedron o1, Tetrahedron o2) {
            return Double.compare(o1.getPointA().getXCoordinate(), o2.getPointA().getXCoordinate());
        }
    },

    COORDINATE_Y {
        @Override
        public int compare(Tetrahedron o1, Tetrahedron o2) {
            return Double.compare(o1.getPointA().getYCoordinate(), o2.getPointA().getYCoordinate());
        }
    },

    COORDINATE_Z {
        @Override
        public int compare(Tetrahedron o1, Tetrahedron o2) {
            return Double.compare(o1.getPointA().getZCoordinate(), o2.getPointA().getZCoordinate());
        }
    }
}
