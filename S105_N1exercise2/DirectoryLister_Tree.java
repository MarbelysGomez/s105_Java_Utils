package s105_Java_Utils.S105_N1exercise2;

import java.io.File;
import java.util.Arrays;
public class DirectoryLister_Tree {
    private String dirName;
    public DirectoryLister_Tree(String dirName) {
        this.dirName = dirName;
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
    }
    private void printFileInfo(File file, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
                indent.append(" ");
        }
        String type = file.isDirectory() ? "D" : "F";
        String name = file.getName();
        String lastModified = new java.util.Date(file.lastModified()).toString();

        System.out.println(indent + "File: " + name + "(Last modified: " + lastModified + ")");
    }
}

