package javase05.t01;

import java.io.*;
import java.nio.file.NotDirectoryException;
import java.util.Objects;

public class FilesEditor {


    public void createFile(String path, String fileName) throws FileAlreadyExistException, IOException,
            FileNotCreatedException {
        File file = new File(path, fileName);
        if (file.exists()) throw new FileAlreadyExistException();
        if (!file.createNewFile()) throw new FileNotCreatedException();
    }

    public void removeFile(String path, String fileName) throws FileNotRemovedException, FileDoesNotExistException {
        File file = new File(path, fileName);
        if (file.exists()) {
            boolean removed = file.delete();
            if (!removed) throw new FileNotRemovedException();
        } else if (!file.exists()) throw new FileDoesNotExistException();
    }

    public void getFilesFromDir(String path) throws NotDirectoryException {
        File directory = new File(path);
        if (directory.isDirectory()) {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + " directory");
                } else if (!file.isDirectory()) {
                    System.out.println(file.getName() + " file");
                }
            }
        } else if (!directory.isDirectory()) throw new NotDirectoryException(directory.getName() + " is not directory");
    }

    public void editFile(String path, String fileName, String info) throws FileDoesNotExistException, IOException,
            NoInfoException {
        File file = new File(path, fileName);
        if (file.exists()) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            if (!info.isEmpty()) {
                bufferedWriter.write(info + " ");
                bufferedWriter.close();
            } else throw new NoInfoException();

        } else if (!file.exists()) throw new FileDoesNotExistException();
    }

    @SuppressWarnings("unused")
    public void readFile(String path, String fileName) throws FileDoesNotExistException, IOException {
        File file = new File(path, fileName);
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                bufferedReader.lines().forEach(System.out::println);
                bufferedReader.close();
        } else if (!file.exists()) throw new FileDoesNotExistException();
    }
}

