package service;

import java.math.BigInteger;

public class CountFactorial extends Thread {
    private final String fileName;

    public CountFactorial( String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void run() {
        BigInteger factorial = null;
        if (number.bitLength() > 0) {
            factorial = number.multiply(number);
            //System.out.println("count " + number);
        }
        File file = new File();
        file.write(fileName, String.format("ix (%s) = ir (%s)", number, factorial));
//        FileWriter fileWriter = new FileWriter(fileName, number.toString());
//        fileWriter.start();
    }
}
