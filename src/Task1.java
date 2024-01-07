import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new PinValidator());
        terminal.getPinValidator().validate();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Проверить баланс - 1. Внести деньги - 2. Снять деньги - 3. Выйти - 4");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    terminal.checkBalance();
                    break;
                case "2":
                    terminal.addMoney();
                    break;
                case "3":
                    terminal.takeMoney();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Ввод должен быть 1, 2 или 3. Введите корректно.");
            }
        }
    }
}