import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ScannerService scannerService = new ScannerService();
        String path = scannerService.scannerPath();

        CreatorFiles creatorFiles = new CreatorFiles(path);
        creatorFiles.createFiles(path);

        ReaderFiles readerFiles = new ReaderFiles(path);
        try {
            readerFiles.readFiles(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        WriterFiles writerFiles = null;
        try {
            writerFiles = new WriterFiles(readerFiles.readFiles(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert writerFiles != null;
            writerFiles.writeFiles(readerFiles.readFiles(path));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
