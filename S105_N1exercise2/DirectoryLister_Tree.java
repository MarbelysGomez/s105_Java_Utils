package s105_Java_Utils.S105_N1exercise2;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DirectoryLister_Tree {
    public DirectoryLister_Tree() {
    }
    public void listDirectory(File directory, int level) {
        File[] fileList = directory.listFiles();

        if (fileList != null) {
            Arrays.sort((fileList), Comparator.comparing(File::getName));

            for (File file : fileList) {
                for(int i= 0; i < level; i++) {
                    System.out.print("\t");
                }
                if (file.isDirectory()) {
                    System.out.println("D " + file.getName() + " (Last modified: " + new Date(file.lastModified()) + ")");
                    listDirectory(file,level + 1);
                } else{
                    System.out.println("F " + file.getName() + "(Last modified: " + new Date(file.lastModified()) + ")");
                }
            }
        } else {
            System.out.println("Unable to access directory.");
        }
    }
}
