import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String link = scanner.nextLine();
            try {
                readContent(link);
                break;
            } catch (MalformedURLException e) {
                System.out.println("Введен некорректный адрес. Введите заново");
            } catch (IOException e) {
                System.out.println("Не удалось прочитать содержимое. Попробуйте другой url");
            }
        }
    }

    private static void readContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
