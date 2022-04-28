package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import exception.FileWriteException;

public class File {
    private String filePath;
    private String data;


    public synchronized void write(String filePath, String data) {
        Path path = Paths.get(filePath);
        try {
            //System.out.println("write " + data);
            Files.write(path, Collections.singleton(data),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileWriteException("Can`t write data to file ", e);
        }
    }
}
