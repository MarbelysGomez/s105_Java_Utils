package s105_Java_Utils.S105_N1exercise1;

public class Main {
    public static void main(String[] args) {

        if (args.length > 0) {
            String dirName = args[0];
            DirectoryLister directoryLister = new DirectoryLister(dirName);
            directoryLister.listDirectory();
        } else {
            System.out.println("Please provide a directory name as an argument.");
        }
    }
}