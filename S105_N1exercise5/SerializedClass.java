package s105_Java_Utils.S105_N1exercise5;

import java.io.*;

public class SerializedClass implements Serializable {
    private String filePath;

    public SerializedClass (String filePath) {
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
