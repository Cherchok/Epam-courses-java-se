package javase05.t01;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.NotDirectoryException;

class FilesEditorTest {
    private String path = "/Users/cherchok/IdeaProjects/se01/src/main/resources/m5t1/";
    private String fileName = "file1.txt";

    @Test
    void createFile() throws IOException, FileNotCreatedException {
        FilesEditor fileEditor = new FilesEditor();
        try {
            fileEditor.createFile(path, fileName);
            Assert.fail("FileAlreadyExistException");
        } catch (FileAlreadyExistException e) {
            Assert.assertNotEquals("", e.getMessage());
        }

    }

    @Test
    void removeFile() throws FileNotRemovedException {
        String fileName2 = "file2.txt";
        FilesEditor filesEditor = new FilesEditor();
        try {
            filesEditor.removeFile(path, fileName2);
            Assert.fail("FileDoesNotExistException");
        } catch (FileDoesNotExistException e) {
            Assert.assertNotEquals("", e.getMessage());
        }

    }

    @Test
    void getFilesFromDir() {
        String path2 = "/Users/cherchok/IdeaProjects/se01/src/main/resources/m5t1/file1.txt";
        FilesEditor filesEditor = new FilesEditor();
        try {
            filesEditor.getFilesFromDir(path2);
            Assert.fail("NotDirectoryException");
        } catch (NotDirectoryException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }


    @Test
    void editFile() throws IOException, FileDoesNotExistException {
        FilesEditor filesEditor = new FilesEditor();
        try {
            String info="";
            filesEditor.editFile(path,fileName, info);
            Assert.fail("NoInfoException");
        } catch (NoInfoException e) {
            Assert.assertNotEquals("",e.getMessage());
        }
    }
}