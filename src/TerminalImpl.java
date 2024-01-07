import java.util.Scanner;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public void checkBalance() {
        MessageHandler.showBalance(server.getBalance());
    }

    @Override
    public void addMoney() {
        MessageHandler.wantToAdd();
        server.addMoney(insertSum());
    }

    @Override
    public void takeMoney() {
        MessageHandler.wantToTake();
        try {
            server.subtractMoney(insertSum());
        } catch (NotEnoughMoneyException ex) {
            MessageHandler.cantTake();
        }
    }

    public PinValidator getPinValidator() {
        return pinValidator;
    }

    private int insertSum() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            MessageHandler.insertSum();
            String line = scanner.nextLine();
            try {
                int sum = Integer.parseInt(line);
                if (sum % 100 != 0) {
                    throw new NumberFormatException("Не кратно 100.");
                }
                if (sum < 0) {
                    throw new NumberFormatException("Меньше 0.");
                }
                return sum;
            } catch (NumberFormatException numberFormatException) {
                MessageHandler.wrongSum(numberFormatException.getMessage());
            }
        }
    }
}
