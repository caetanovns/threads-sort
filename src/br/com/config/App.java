package br.com.config;

public class App {

    private static String RESOURCE = "/res/";

    public static final String FILE = "file_";
    public static final int NUMBER_FILES = 10;
    public static final Integer THREAD_NUMBER = NUMBER_FILES;

    public static String folder(){
        return System.getProperty("user.dir") + RESOURCE + '/';
    }

}
