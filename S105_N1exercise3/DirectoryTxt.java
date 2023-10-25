package s105_Java_Utils.S105_N1exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DirectoryTxt {
    private String dirName;
    private StringBuilder fileContent;
    public DirectoryTxt(String dirName) {
        this.dirName = dirName;
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
        saveTofile("output.txt", fileContent.toString());
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
    private void saveTofile(String filePath, String content) {
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
