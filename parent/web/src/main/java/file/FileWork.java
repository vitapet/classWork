package file;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWork {
    File file;

    public FileWork(String path) {
        this.file = new File(path);
    }

    public void writeToFile(String[] strings) {
        try {
            FileWriter writer = new FileWriter(file);
            for (String item : strings) {
                writer.write(item);
                writer.append('\n');
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }
}
