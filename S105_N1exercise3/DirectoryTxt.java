package s105_Java_Utils.S105_N1exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DirectoryTxt {
    private FileWriter writer;

    public DirectoryTxt(FileWriter writer) {
        this.writer = writer;
    }
    public void listDirectory(File directory, int level) throws IOException {
        File[] fileList = directory.listFiles();

        if (fileList != null) {
            Arrays.sort(fileList, Comparator.comparing(File::getName));

            for (File file : fileList) {
                for (int i = 0; i < level; i++) {
                    writer.write("\t");
                }
                if (file.isDirectory()) {
                    writer.write("D " + file.getName() + " (Last modified: " + new Date(file.lastModified()) + ")");
                    listDirectory(file, level + 1);
                } else {
                    writer.write("F " + file.getName() + "(Last modified: " + new Date(file.lastModified()) + ")");
                }
            }
        } else {
            writer.write("Invalid directory.");
        }
    }
}
