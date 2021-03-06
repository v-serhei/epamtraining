package com.verbitsky.task1.reader.impl;

import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.reader.FileDataReader;
import com.verbitsky.task1.validator.DataFileValidator;
import com.verbitsky.task1.validator.impl.DataFileValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader implements FileDataReader {
    private static DataFileValidator fileValidator = new DataFileValidatorImpl();
    private static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readDataFromFile(String filePath) throws FigureException {
        if (!fileValidator.validateDataFilePath(filePath)) {
            logger.log(Level.ERROR, "DataReader: wrong data file path");
            throw new FigureException("DataReader: wrong data file path");
        }
        if (fileValidator.validateEmptyDataFile(filePath)) {
            logger.log(Level.ERROR, "DataReader: wrong data file - empty file");
            throw new FigureException("DataReader: wrong data file - empty file");
        }
        File file = new File(filePath);
        Stream<String> stringsStream;
        try {
            stringsStream = Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            logger.log(Level.ERROR, "File read error", ex);
            throw new FigureException("File read error", ex);
        }
        List<String> dataList = stringsStream.collect(Collectors.toList());
        logger.log(Level.INFO, "Read data from file successfully completed");
        return dataList;
    }

}
