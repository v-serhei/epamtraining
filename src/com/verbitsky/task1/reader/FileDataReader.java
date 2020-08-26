package com.verbitsky.task1.reader;

import com.verbitsky.task1.exception.FigureException;

import java.util.List;

public interface FileDataReader {
    List<String> readDataFromFile(String filePath) throws FigureException;
}
