package s105_Java_Utils.S105_N1exercise3;

import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        if (args.length > 0) {
            String dirName = args[0];
            try {
                FileWriter fileWriter = new FileWriter("output.txt");
                DirectoryTxt directoryTxt = new DirectoryTxt(fileWriter);
                directoryTxt.listDirectory(new File(dirName), 0);
            } catch (Exception e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Please provide a directory name as an argument.");
        }
    }
}

