package com.verbitsky.task1.factory.figurefactory.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.factory.figurefactory.FigureCreator;
import com.verbitsky.task1.parser.DataParser;
import com.verbitsky.task1.reader.DataReader;
import com.verbitsky.task1.validator.datavalidator.FigureDataValidator;
import com.verbitsky.task1.validator.datavalidator.impl.TetrahedronDataValidator;
import com.verbitsky.task1.validator.figurecreatevalidator.FigureCreationValidator;
import com.verbitsky.task1.validator.figurecreatevalidator.impl.TetrahedronCreationValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TetrahedronCreator implements FigureCreator {
    //read coordinates from txt file
    private static DataReader dataFileReader = new DataReader();
    //check the ability to create Tetrahedron
    private static FigureCreationValidator creationValidator = new TetrahedronCreationValidator();
    //check string data for correctness
    private static FigureDataValidator dataValidator = new TetrahedronDataValidator();
    //parse coordinates from strings
    private static DataParser lineParser = new DataParser();

    @Override
    public Figure createFigure(List<AreaPoint> pointList) {
        Tetrahedron tetrahedron = null;
        if (creationValidator.validateFigureCreation(pointList)) {
            //todo log this
            tetrahedron = new Tetrahedron(pointList.get(0), pointList.get(1), pointList.get(2), pointList.get(3));
        } else {
            //todo log this подумать надо ли тут элс
        }
        return tetrahedron;
    }

    public Figure createFigure(AreaPoint... pointList) {
        List <AreaPoint> areaPointList = Arrays.asList(pointList);
        Tetrahedron tetrahedron = (Tetrahedron) createFigure(areaPointList);
        return tetrahedron;
    }

    public List<Figure> createFiguresFromFile(String path) {
        List<String> lines = dataFileReader.readDataFromFile(path);
        List<Figure> figures = new ArrayList<>();
        for (String line : lines) {
            List <AreaPoint> pointList = lineParser.parseAreaPointsFromLine(line, dataValidator);
            Figure figure = createFigure(pointList);
            if (figure != null) {
                figures.add(figure);
            } else {
                //todo log строка файла № + counter содержит некорректные данные для создания фигуры class.forname
            }
        }
        return figures;
    }


}
