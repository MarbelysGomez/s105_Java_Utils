package s105_Java_Utils.S105_N2exercise1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream("S105_N2ex.config.properties");
            properties.load(inputStream);
            inputStream.close();

            String dirName = properties.getProperty("s105_Java_Utils/S105_N2exercise1");
            String outputFile = properties.getProperty("outputFile");

            FileWriter fileWriter = new FileWriter(outputFile);
            DirectoryTxt_Parameterizing directoryTxtParameterizing = new DirectoryTxt_Parameterizing();
            directoryTxtParameterizing.listDirectory(new File(dirName), 0, fileWriter);
            fileWriter.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}