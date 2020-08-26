package com.verbitsky.task1.reader;

import com.verbitsky.task1.exception.FigureException;
import com.verbitsky.task1.reader.impl.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class DataReaderTest {
    private DataReader reader = new DataReader();
    private String correctFile;
    private String emptyFile;

    @BeforeClass
    public void setUp() {
        reader = new DataReader();
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("data");
        pathBuilder.append(File.separator);
        pathBuilder.append("fileforcreation");
        emptyFile = pathBuilder.toString();
        pathBuilder.append(File.separator);
        pathBuilder.append("figureparametres.txt");
        correctFile = pathBuilder.toString();
    }

    @AfterClass
    public void tearDown() {
        reader = null;
        correctFile = null;
        emptyFile = null;
    }

    /* Positive result tests*/
    @Test
    public void testReadDataFromFilePositive() throws FigureException {
        List<String> dataList = reader.readDataFromFile(correctFile);
        boolean result = (dataList == null);
        Assert.assertFalse(result);
    }

    @Test
    public void testReadDataFromFileWrongFullDataInFilePositive() throws FigureException {
        StringBuilder sb = new StringBuilder();
        sb.append("data");
        sb.append(File.separator);
        sb.append("fileforcreation");
        sb.append(File.separator);
        sb.append("fullwrongdata.txt");
        List<String> dataList = reader.readDataFromFile(sb.toString());
        boolean result = (dataList == null);
        Assert.assertFalse(result);
    }

    /* Negative result tests*/
    @Test(expectedExceptions = FigureException.class)
    public void testReadDataFromFileEmptyFile() throws FigureException {
        reader.readDataFromFile(emptyFile);
    }

    @Test(expectedExceptions = FigureException.class)
    public void testReadDataFromFileWrongFilePath() throws FigureException {
        reader.readDataFromFile("WrongFilePath");
    }
}