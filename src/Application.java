import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import service.CountFactorial;
import service.FileReader;
import storage.DataStorage;

public class Application {
    private static final DataStorage storage = new DataStorage();
    private static final String inputFileName = "input.txt";
    private static final String outputFileName = "output.txt";

    public static void main(String[] args) {
        DataStorage storage = new DataStorage();

        FileReader fileReader = new FileReader(inputFileName);
        fileReader.start(); // reading file

        try {
            fileReader.join();
            storage.addAll(fileReader.getData());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int threads = 10;
        for (int i = 0; i < threads; i++) {
                new CountFactorial(outputFileName).start(); // count and write
        }


    }
}
