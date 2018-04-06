package javase05.t02;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesEditorTest {

    @Test
    void getProperty() {
        File file = new File("/Users/cherchok/IdeaProjects/se01/src/main/resources/m5t2/file1.properties");
        PropertiesEditor propertiesEditor = new PropertiesEditor();
        assertThrows(NoKeyException.class,()->propertiesEditor.getProperty(file,"2"));
    }

    @Test
    void getProperties() {
        File file = new File("/Users/cherchok/IdeaProjects/se01/src/main/resources/m5t2/file.txt");
        PropertiesEditor propertiesEditor = new PropertiesEditor();
        assertThrows(NotPropertyException.class,()->propertiesEditor.getProperties(file));
    }
}