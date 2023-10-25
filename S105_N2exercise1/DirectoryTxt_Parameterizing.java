package s105_Java_Utils.S105_N2exercise1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class DirectoryTxt_Parameterizing {
    private String dirName;
    private String outputFileName;
    private String outputDirectory;
    private StringBuilder fileContent;
    public DirectoryTxt_Parameterizing (String configFilePath) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(configFilePath));
            this.dirName = properties.getProperty("directoryToRead");
            this.outputFileName = properties.getProperty("outputFileName");
            this.outputDirectory = properties.getProperty("outputDirectory");
        } catch (IOException e) {
            System.out.println("An error ocurred while reading the configuration file.");
            e.printStackTrace();
        } if (this.dirName == null) {
            System.out.println("Directory name is not set in the properties file.");
        } if (this.outputFileName == null) {
            System.out.println("Output file name is not set in the properties file.");
        } if (this.outputDirectory == null) {
            System.out.println("Output directory is not set in the properties");
        }
        this.fileContent = new StringBuilder();
    }
    public void listDirectory() {
        File directory = new File(dirName);

        if (directory.isDirectory()) {
            listContents(directory, 0);
        } else {
            System.out.println("Invalid directory.");
        }
    }
    private void listContents(File directory, int level) {
        File[] fileList = directory.listFiles();

        if(fileList != null) {
            Arrays.sort(fileList);

            for (File file : fileList) {
                printFileInfo(file, level);

                if(file.isDirectory()) {
                    listContents(file, level + 1);
                }
            }
        }
        saveToFile(outputDirectory + File.separator + outputFileName, fileContent.toString());
    }
    private void printFileInfo(File file, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append(" ");
        }
        String type = file.isDirectory() ? "D" : "F";
        String name = file.getName();
        String lastModified = new java.util.Date(file.lastModified()).toString();

        fileContent.append(indent).append("File: ").append(name).append("(Last modified: ").append(lastModified).append(")\n");
    }
    private void saveToFile(String filePath, String content) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
