package s105_Java_Utils.S105_N1exercise5;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        if (args.length > 0) {
            String fileName = args[0];
            try {
                FileWriter fileWriter = new FileWriter("output.txt");
                SerializedClass serializedClass = new SerializedClass();
                serializedClass.listDirectory(new File(fileName), 0, fileWriter);
                fileWriter.close();

                serializedClass.displayFileContents(fileName);

                serializedClass.serializeObject(serializedClass, "serializedObject.ser");

                SerializedClass deserializedObject = serializedClass.deserializationObject("serializedObject.ser");

                System.out.println("Deserialized object is an instance of " + deserializedObject.getClass().getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please provide a directory name as an argument.");
        }
    }
}
