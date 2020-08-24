package com.verbitsky.task1.factory.figurefactory.impl;

import com.verbitsky.task1.entity.figure.Figure;
import com.verbitsky.task1.entity.figure.impl.Tetrahedron;
import com.verbitsky.task1.entity.point.AreaPoint;
import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.factory.figurefactory.FigureCreator;
import com.verbitsky.task1.parser.DataParser;
import com.verbitsky.task1.reader.DataReader;
import com.verbitsky.task1.validator.datafilevalidator.DataFileValidator;
import com.verbitsky.task1.validator.datafilevalidator.impl.DataFileValidatorImpl;
import com.verbitsky.task1.validator.datavalidator.FigureDataValidator;
import com.verbitsky.task1.validator.datavalidator.impl.TetrahedronDataValidator;
import com.verbitsky.task1.validator.figurecreatevalidator.FigureCreationValidator;
import com.verbitsky.task1.validator.figurecreatevalidator.impl.TetrahedronCreationValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TetrahedronCreator implements FigureCreator {
    private static Logger logger = LogManager.getLogger();
    //read coordinates from txt file
    private static DataReader dataFileReader = new DataReader();
    //check the ability to create Tetrahedron
    private static FigureCreationValidator creationValidator = new TetrahedronCreationValidator();
    //check string data for correctness
    private static FigureDataValidator dataValidator = new TetrahedronDataValidator();
    //parse coordinates from strings
    private static DataParser lineParser = new DataParser();
    //data file validator
    private static DataFileValidator fileValidator = new DataFileValidatorImpl();

    @Override
    public Figure createFigure(List<AreaPoint> pointList) {
        Tetrahedron tetrahedron = null;
        try {
            if (creationValidator.validateFigureCreation(pointList)) {
                tetrahedron = new Tetrahedron(pointList.get(0), pointList.get(1), pointList.get(2), pointList.get(3));
            }
        } catch (FigureException e) {
            logger.log(Level.INFO, "Tetrahedron creator: received null object in createFigure method");
        }
        logger.log(Level.INFO, "Created figure: " + tetrahedron);
        return tetrahedron;
    }

    public Figure createFigure(AreaPoint... pointList) {
        List<AreaPoint> areaPointList = Arrays.asList(pointList);
        Tetrahedron tetrahedron = (Tetrahedron) createFigure(areaPointList);
        return tetrahedron;
    }

    public List<Figure> createFiguresFromFile(String path) {
        boolean flag = false;
        if (!fileValidator.validateDataFile(path)) {
            logger.log(Level.ERROR, "Wrong data file, shutdown program");
            throw new RuntimeException("TetrahedronCreator: wrong data file");
        }
        List<String> lines = dataFileReader.readDataFromFile(path);
        List<Figure> figures = new ArrayList<>();
        for (String line : lines) {
            logger.log(Level.INFO, "Created figure from file: try to create figure from " + line);
            List<AreaPoint> pointList = lineParser.parseAreaPointsFromLine(line, dataValidator);
            Figure figure = createFigure(pointList);
            if (figure != null) {
                figures.add(figure);
            }
        }
        return figures;
    }
}
