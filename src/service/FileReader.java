package service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import exception.FileReadException;

public class FileReader extends Thread {
    private List<String> data = new ArrayList<>();
    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        Path path = Paths.get(filePath);
        try {
            data.addAll(Files.readAllLines(path, Charset.defaultCharset()));
            //System.out.println("read data" + data);
        } catch (IOException e) {
            throw new FileReadException("Can`t read data from file ", e);
        }
    }

    public List<String> getData() {
        return data;
    }
}
