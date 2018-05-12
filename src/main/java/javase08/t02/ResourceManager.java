package javase08.t02;

import java.util.ResourceBundle;

public class ResourceManager {
private final static ResourceManager instance = new ResourceManager();
    private static ResourceBundle rb = ResourceBundle.getBundle(
            "/Users/cherchok/IdeaProjects/se01/src/main/resources/m8t2/connection");

public static ResourceManager getInstance(){
    return instance;
}
    public static String getValues(String key) {
        return rb.getString(key);
    }
}
