package javase05.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PropertiesEditor {
    private Map<String, String> properties;

    PropertiesEditor() {
        properties = new HashMap<>();
    }

    public String getProperty(File file, String key) throws NotPropertyException, IOException, NoKeyException {
        properties = getProperties(file);
        if (properties.containsKey(key)) {
            return properties.get(key);
        }
        return null;
    }

    public HashMap<String, String> getProperties(File file) throws IOException, NotPropertyException, NoKeyException {
        if (isProperty(file)) {
            putProperty(file);
        } else throw new NotPropertyException(file.getName() + " not *.properties");
        return (HashMap<String, String>) properties;
    }

    private boolean isProperty(File file) {

        String filename = file.getName();
        String extension = "";
        char[] chars = filename.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '.') {
                extension = filename.substring(i + 1, filename.length());
            }
        }
        return extension.equals("properties");
    }

    private void putProperty(File file) throws IOException, NoKeyException {
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                String[] keyValue = bufferedReader.readLine().split("=");
                if (keyValue.length >= 2) {
                    properties.put(keyValue[0].trim(), keyValue[1].trim());
                } else throw new NoKeyException("The key not found in "+file.getName());
            }
        } else throw new FileNotFoundException(); // this exception i took from previous task
    }
}
