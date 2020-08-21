package com.verbitsky.task1.reader;

import com.verbitsky.task1.exception.FigureException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Datareader {
    public Stream<String> readParametersFromFile(String filePath) throws FigureException {
        File file = new File(filePath);
        Stream<String> stringStream = null;
        if (file.exists()) {
            try {
                stringStream = Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
            } catch (IOException e) {
                //todo переделать
                e.printStackTrace();
            }
        }else {
            throw new FigureException("Can't read a file with parameters - file doesn't exist");
        }
        return stringStream;
    }
}