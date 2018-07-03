package logger.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Reader {
    private static final Logger logger = LogManager.getLogger(Reader.class);
    public void usualWriter(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < 10000000; i++) {
            fileWriter.write("Hello everybody" + i);
        }
        fileWriter.close();
    }

    public void usualReader(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        int number;
        while ((number = fileReader.read()) != -1) {
            int a = 1;
        }
        fileReader.close();
    }

    public void bufReader(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "asd";
        while (line != null) {
            line = reader.readLine();
        }
        fileReader.close();
    }

    public void bufWriter(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 10000000; i++) {
            bufferedWriter.write("Hello everybody" + i);
        }
        fileWriter.close();
    }

    public void differentSizeBuffer(File file, int i) throws IOException {
        FileReader fileReader = new FileReader(file);
        logger.info("Start different buffer");
        BufferedReader bufferedReader = new BufferedReader(fileReader, i);
        String line = "sdfsd";
        long timeStart = System.currentTimeMillis();
        while (line != null) {
            line = bufferedReader.readLine();
        }
        long timeFinish = System.currentTimeMillis();
        logger.info("Buffer " + i + " " + (timeFinish - timeStart));
    }
}
