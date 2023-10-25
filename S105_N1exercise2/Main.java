package s105_Java_Utils.S105_N1exercise2;

public class Main {
    public static void main(String[] args) {
        String dirName = "D:\\IdeaProjects\\s1_Java_Language\\src\\main\\java\\s105_Java_Utils\\S105_N1exercise2";

        DirectoryLister_Tree directoryLister = new DirectoryLister_Tree(dirName);
        directoryLister.listDirectory();
    }
}

