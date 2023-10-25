package s105_Java_Utils.S105_N1exercise1;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {
    private String dirName;

    public DirectoryLister(String dirName) {
        this.dirName = dirName;
    }
    public void listDirectory() {
        File directory = new File(dirName);

        if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();

            if (fileList != null) {
                Arrays.sort((fileList));

                for (File file : fileList) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Invalid directory.");
            }
        }
    }
}
