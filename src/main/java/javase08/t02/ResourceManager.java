package javase08.t02;

import java.util.ResourceBundle;

public class ResourceManager {
    public static final String DRIVER = "driver";
    public static final String URL = "url";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String POOLSIZE = "poolsize";

    private static ResourceBundle rb = ResourceBundle.getBundle(
            "/Users/cherchok/IdeaProjects/se01/src/main/resources/m8t2/connection");

    private ResourceManager() {
    }

    public static String getValues(String key) {
        return rb.getString(key);
    }
}
