package javase07.t02;

import javase05.t02.NoKeyException;
import javase05.t02.NotPropertyException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class SyncPropReader implements Runnable {
    private final File file;
    private Map<String, String> properties;


     public SyncPropReader(File file){
        this.file = file;
        properties = new HashMap<>();
    }

    @Override
    public void run() {
        try {
            System.out.println(getProperty("1"));
        } catch (NotPropertyException | NoKeyException | IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("SameParameterValue")
    private String getProperty(String key) throws NotPropertyException, IOException, NoKeyException {
        properties = getProperties();
        if (properties.containsKey(key)) {
            return properties.get(key);
        }
        return null;
    }

    public HashMap<String, String> getProperties() throws IOException, NotPropertyException, NoKeyException {
        if (isProperty(file)) {
            if(file.exists()){
                synchronized (file){
                    putProperty();
                }
            }
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

    private void putProperty() throws IOException, NoKeyException {
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                String[] keyValue = bufferedReader.readLine().split("=");
                if (keyValue.length >= 2) {
                    properties.put(keyValue[0].trim(), keyValue[1].trim());
                } else throw new NoKeyException("The key not found in "+file.getName());
            }
        } else throw new FileNotFoundException();
    }


}
