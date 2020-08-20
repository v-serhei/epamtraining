package com.verbitsky.task1;

import com.verbitsky.task1.exceptions.FigureException;
import com.verbitsky.task1.utils.filereader.FilePaths;
import com.verbitsky.task1.utils.filereader.ParametersForCreationReader;

import java.util.stream.Stream;

public class DeleteThis {
    public static void main(String[] args) {

        ParametersForCreationReader reader = new ParametersForCreationReader();
        try {
            Stream<String> stream = reader.readParametersFromFile(FilePaths.FILE_PATH_FOR_TETRAHEDRON_CREATE);
            stream
                    //.filter((s)->s.matches("%d"))
                    .forEach(System.out::println);

        } catch (FigureException e) {
            e.printStackTrace();
        }

    }
}
