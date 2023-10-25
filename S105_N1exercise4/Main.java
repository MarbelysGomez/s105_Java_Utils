package s105_Java_Utils.S105_N1exercise4;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\IdeaProjects\\s1_Java_Language\\src\\main\\java\\s105_Java_Utils\\S105_N1exercise4\\ReaderTxtFile.txt";

        ReaderText readerText = new ReaderText(filePath);
        readerText.readFile();
    }
}
