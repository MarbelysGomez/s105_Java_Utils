package s105_Java_Utils.S105_N1exercise4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            try {
                FileWriter fileWriter = new FileWriter("output.txt");
                ReaderText readerText = new ReaderText();
                readerText.listDirectory(new File(fileName), 0 , fileWriter);
                fileWriter.close();

                readerText.displayFileContents(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please provide a directory name as an argument.");
        }
    }
}
