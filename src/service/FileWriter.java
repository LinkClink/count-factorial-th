package service;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import exception.FileWriteException;

public class FileWriter extends Thread {
    private final String filePath;
    private String data;

    public FileWriter(String filePath, String data) {
        this.filePath = filePath;
        this.data = data;
    }

    @Override
    public void run() {
        Path path = Paths.get(filePath);
        try {
            //System.out.println("write " + data);
            Files.write(path, Collections.singleton(data + System.lineSeparator()),
                    StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileWriteException("Can`t write data to file ", e);
        }
    }
}
