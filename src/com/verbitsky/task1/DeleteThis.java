package com.verbitsky.task1;

import com.verbitsky.task1.generator.FigureIdGenerator;

public class DeleteThis {
    public static void main(String[] args) {
/*
        Datareader reader = new Datareader();
        try {
            Stream<String> stream = reader.readParametersFromFile(FilePaths.FILE_PATH_FOR_TETRAHEDRON_CREATE);
            stream
                    //.filter((s)->s.matches("%d"))
                    .forEach(System.out::println);

        } catch (FigureException e) {
            e.printStackTrace();
        }
*/


        for (int i = 0; i < 30; i++) {
            System.out.println(FigureIdGenerator.generateId());

        }
    }
}
