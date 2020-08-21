package com.verbitsky.task1.parser;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.validator.datavalidator.FigureDataValidator;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String LINE_SEPARATOR = ";;";

    public List<AreaPoint> parseAreaPointsFromLine(String line, FigureDataValidator dataValidator) {
        if (dataValidator.validateData(line)) {
            String [] coordinates = line.split(LINE_SEPARATOR);
            double[] coordinates1 = convertStringArrayToDouble(coordinates);
            List <AreaPoint> points = createPointsFromCoordinate(coordinates1);
            return points;
        } else {
            return null;
        }
    }
    private double[] convertStringArrayToDouble (String [] strings) {
        double [] doubles = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            doubles[i] = Double.parseDouble(strings[i]);
        }
        return doubles;
    }

    private List<AreaPoint> createPointsFromCoordinate (double [] coordinates) {
        List <AreaPoint> result = new ArrayList<>();
        for (int i = 0; i <coordinates.length-1; i+=3) {
            result.add(new AreaPoint(coordinates[i], coordinates[i+1] ,coordinates[i+2]));
        }
        return result;
    }
}
