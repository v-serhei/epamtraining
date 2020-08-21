package com.verbitsky.task1.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    public List<String> readDataFromFile(String filePath) {
        File file = new File(filePath);
        Stream<String> stringsStream;
        try {
            stringsStream = Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            //todo написать в лог
            throw new RuntimeException("File read error", ex);
        }
        List<String> dataList = stringsStream.collect(Collectors.toList());
        return dataList;
    }
}
