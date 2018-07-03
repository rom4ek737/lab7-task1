package logger.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestLargeFile {
    private static final Logger logger = LogManager.getLogger(TestLargeFile.class);

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(TestLargeFile.class.getClassLoader().getResource("config.properties").getFile()));
        File file = new File(prop.getProperty("file1"));
        File file1 = new File(prop.getProperty("file2"));
        File file2 = new File(prop.getProperty("file3"));
        Reader reader = new Reader();
        long timestart = System.currentTimeMillis();
        reader.usualWriter(file);
        long timefinish = System.currentTimeMillis();
        logger.info("Usual writer time: " + (timefinish - timestart));
        long time2read = System.currentTimeMillis();
        reader.usualReader(file2);
        long time2read2 = System.currentTimeMillis();
        logger.info("Usual reader time: " + (time2read2 - time2read));

        long time2read6 = System.currentTimeMillis();
        reader.bufWriter(file1);
        long time2read7 = System.currentTimeMillis();
        logger.info("Buffered writer time: " + (time2read7 - time2read6));

        long time2read3 = System.currentTimeMillis();
        reader.bufReader(file2);
        long time2read4 = System.currentTimeMillis();
        logger.info("Buffered reader time: " + (time2read4 - time2read3));

        for (int i = 2; i <= 65536; i *= 2) {
            reader.differentSizeBuffer(file2, i);
        }
    }
}