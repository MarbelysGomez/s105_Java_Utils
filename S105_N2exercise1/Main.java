package s105_Java_Utils.S105_N2exercise1;

public class Main {
    public static void main(String[] args) {
        String configFilePath = "D:\\IdeaProjects\\s1_Java_Language\\src\\main\\java\\s105_Java_Utils\\S105_N2exercise1\\config.properties";

        DirectoryTxt_Parameterizing directoryTxt_Parameterizing = new DirectoryTxt_Parameterizing (configFilePath);
        directoryTxt_Parameterizing.listDirectory();
    }
}
