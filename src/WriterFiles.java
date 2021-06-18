import java.io.*;

public class WriterFiles {
    public WriterFiles(FileReader fileReader) {
    }

    public void writeFiles(FileReader fileReader) throws IOException {

        FileWriter fileWriterInvalid = null;
        FileWriter fileWriterValid = null;
        try {
            File validNumber = new File("ValidNumber.txt");
            File invalidNumber = new File("InvalidNumber.txt");

            fileWriterInvalid = new FileWriter(invalidNumber, true);
            fileWriterValid = new FileWriter(validNumber, true);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                System.out.println(str);
                if (str.length() == 15) {
                    fileWriterValid.write(str + "\n");
                } else {
                    if (str.length() != 15) {
                        fileWriterInvalid.write(str + " не соотвествует длина" + "\n");
                    }
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } finally {
            if (fileWriterInvalid != null) {
                try {
                    fileWriterInvalid.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
            if (fileWriterValid != null) {
                try {
                    fileWriterValid.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }


        }


    }
}
