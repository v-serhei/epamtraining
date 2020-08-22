package com.verbitsky.task1.parser;

import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.validator.datavalidator.FigureDataValidator;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    /*
        GROUP_COORDINATES_SEPARATOR
        separate points coordinate in line, for example: (first group)1.0 1.0 1.0 ; (second group) 2.0 2.0 2.0
     */
    private static final String GROUP_COORDINATES_SEPARATOR = ";";
    private static final String DEFAULT_COORDINATE_SEPARATOR = " ";
    private static final String MULTIPLE_SPACES = "\\s+";

    public List<AreaPoint> parseAreaPointsFromLine(String line, FigureDataValidator figureDataValidator) {
        boolean correctData = figureDataValidator.validateData(line);
        List<AreaPoint> points = new ArrayList<>();
        if (correctData) {
            double[] numericCoordinates = getNumericCoordinatesFromLine(line);
            points = createPointsFromCoordinates(numericCoordinates);
        }
        return points;
    }

    private double[] getNumericCoordinatesFromLine(String line) {
        String buf = line.replaceAll(GROUP_COORDINATES_SEPARATOR, DEFAULT_COORDINATE_SEPARATOR);
        buf = clearMultipleSpaces(buf);
        String[] strCoordinates = buf.split(DEFAULT_COORDINATE_SEPARATOR);
        double[] coordinatesArray = convertStringArrayToDouble(strCoordinates);
        return coordinatesArray;
    }

    private double[] convertStringArrayToDouble(String[] strings) {
        double[] doubles = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            doubles[i] = Double.parseDouble(strings[i]);
        }
        return doubles;
    }

    private List<AreaPoint> createPointsFromCoordinates(double[] coordinates) {
        List<AreaPoint> result = new ArrayList<>();
        for (int i = 0; i < coordinates.length - 1; i += 3) {
            result.add(new AreaPoint(coordinates[i], coordinates[i + 1], coordinates[i + 2]));
        }
        return result;
    }

    private String clearMultipleSpaces(String line) {
        String result = line.replaceAll(MULTIPLE_SPACES, DEFAULT_COORDINATE_SEPARATOR);
        return result.trim();
    }

}
