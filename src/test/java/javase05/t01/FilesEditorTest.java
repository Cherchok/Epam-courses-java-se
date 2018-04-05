package javase05.t01;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NotDirectoryException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FilesEditorTest {
    private String path = "/Users/cherchok/IdeaProjects/se01/src/main/resources/m5t1/";
    private String fileName = "file1.txt";

    @Test
    void createFile() {
        FilesEditor fileEditor = new FilesEditor();
        assertThrows(FileAlreadyExistException.class, () -> fileEditor.createFile(path, fileName));


    }

    @Test
    void removeFile() throws FileNotRemovedException {
        String fileName2 = "file2.txt";
        FilesEditor filesEditor = new FilesEditor();
        assertThrows(FileDoesNotExistException.class, () -> filesEditor.removeFile(path, fileName2));

    }

    @Test
    void getFilesFromDir() {
        String path2 = "/Users/cherchok/IdeaProjects/se01/src/main/resources/m5t1/file1.txt";
        FilesEditor filesEditor = new FilesEditor();
        assertThrows(NotDirectoryException.class, () -> filesEditor.getFilesFromDir(path2));
    }


    @Test
    void editFile() throws IOException, FileDoesNotExistException {
        FilesEditor filesEditor = new FilesEditor();
        String info = "";
        assertThrows(NoInfoException.class, () -> filesEditor.editFile(path, fileName, info));

    }
}