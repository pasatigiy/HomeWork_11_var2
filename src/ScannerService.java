import java.util.Scanner;

public class ScannerService {
    public String scannerPath (){
        System.out.println("Введите путь к файлу.");
        Scanner scan = new Scanner(System.in);
        String path = scan.next();
        return path;
    }
}
