package s105_Java_Utils.S105_N1exercise2;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        if (args.length > 0) {
            String dirName = args[0];
            DirectoryLister_Tree directoryLister_Tree = new DirectoryLister_Tree();
            directoryLister_Tree.listDirectory(new File(dirName), 0);
        } else {
            System.out.println("Please provide a directory name as an argument.");
        }
    }
}

