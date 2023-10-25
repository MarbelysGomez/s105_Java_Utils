package s105_Java_Utils.S105_N1exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderText {
    private String filePath;

    public ReaderText (String filePath) {
        this.filePath = filePath;
    }
    public void readFile () {
        File file = new File(filePath);

        if(file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
            } catch (IOException e){
                System.out.println("Error reading file: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid file path.");
        }
    }
}
