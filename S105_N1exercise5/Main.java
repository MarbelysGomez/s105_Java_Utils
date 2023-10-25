package s105_Java_Utils.S105_N1exercise5;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\IdeaProjects\\s1_Java_Language\\src\\main\\java\\s105_Java_Utils\\S105_N1exercise4\\ReaderTxtFile.txt";

        try (FileOutputStream fileOut = new FileOutputStream("Object.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            SerializedClass serializedClass = new SerializedClass(filePath);
            out.writeObject(serializedClass);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing object: " + e.getMessage());
            e.printStackTrace();
        }
        try (FileInputStream fileInput =  new FileInputStream("Object.ser");
             ObjectInputStream in = new ObjectInputStream(fileInput)) {
            SerializedClass serializedClass = (SerializedClass) in.readObject();
            System.out.println("Objecto deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing object: " + e.getMessage());
            e.printStackTrace();
        }
    }
}