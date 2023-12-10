package s105_Java_Utils.S105_N1exercise4;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ReaderText {

    public ReaderText () {
    }
    public void listDirectory(File directory, int level, FileWriter writer) throws IOException {
        File[] fileList = directory.listFiles();

        if (fileList != null) {
            Arrays.sort((fileList), Comparator.comparing(File::getName));

            for (File file : fileList) {
                for (int i = 0; i < level; i++) {
                    writer.write("\t");
                }
                if (file.isDirectory()) {
                    writer.write("D " + file.getName() + " (Last modified: " + new Date(file.lastModified()) + ")");
                    listDirectory(file, level + 1, writer);
                } else {
                    writer.write("F " + file.getName() + "(Last modified: " + new Date(file.lastModified()) + ")");
                }
            }
        } else {
            writer.write("Invalid directory.");
        }
    }
    public void displayFileContents(String fileName) {
        try {
           File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
