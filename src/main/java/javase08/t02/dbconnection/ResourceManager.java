package javase08.t02.dbconnection;

import java.util.ResourceBundle;

public class ResourceManager {

    private final static ResourceManager instance = new ResourceManager();

    private static ResourceBundle rb = ResourceBundle.getBundle(
            "m8t2/connection");

    public static ResourceManager getInstance() {
        return instance;
    }

    public static String getValues(String key) {
        return rb.getString(key);
    }
}
