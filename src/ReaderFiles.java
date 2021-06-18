import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReaderFiles {
    public ReaderFiles(String path) {

    }

    public FileReader readFiles(String path) throws FileNotFoundException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ioException) {
                    System.out.println(ioException.getMessage());
                }
            }
        }
        return fileReader;
    }
}

