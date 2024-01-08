import java.util.Scanner;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;
    private MessageHandler messageHandler;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator, MessageHandler messageHandler) {
        this.server = server;
        this.pinValidator = pinValidator;
        this.messageHandler = messageHandler;
    }

    @Override
    public void checkBalance() {
        messageHandler.showBalance(server.getBalance());
    }

    @Override
    public void addMoney() {
        messageHandler.wantToAdd();
        server.addMoney(insertSum());
    }

    @Override
    public void takeMoney() {
        messageHandler.wantToTake();
        try {
            server.subtractMoney(insertSum());
        } catch (NotEnoughMoneyException ex) {
            messageHandler.cantTake();
        }
    }

    public PinValidator getPinValidator() {
        return pinValidator;
    }

    private int insertSum() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            messageHandler.insertSum();
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
                messageHandler.wrongSum(numberFormatException.getMessage());
            }
        }
    }
}
