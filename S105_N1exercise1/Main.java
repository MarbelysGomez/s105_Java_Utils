package s105_Java_Utils.S105_N1exercise1;

public class Main {
    public static void main(String[] args) {
        String dirName = "D:\\IdeaProjects\\s1_Java_Language\\src\\main\\java\\s105_Java_Utils\\S105_N1exercise1";
        DirectoryLister directoryLister = new DirectoryLister(dirName);
        directoryLister.listDirectory();
    }
}
