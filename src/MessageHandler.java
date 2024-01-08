public class MessageHandler {

    private MessagePrintable messagePrintable;

    public MessageHandler(MessagePrintable messagePrintable) {
        this.messagePrintable = messagePrintable;
    }

    public void showBalance(int amount) {
        messagePrintable.printMessage("Баланс составляет " + amount + " рублей");
    }

    public void wantToAdd() {
        messagePrintable.printMessage("Вы собираетесь пополнить.");
    }

    public void wantToTake() {
        messagePrintable.printMessage("Вы собираетесь снять.");
    }

    public void cantTake() {
        messagePrintable.printMessage("Не удалось снять деньги");
    }

    public void insertSum() {
        messagePrintable.printMessage("Внесите сумму (введите сумму, кратную 100):");
    }

    public void wrongSum(String message) {
        messagePrintable.printMessage("Неверный формат суммы! " + message + " Введите заново");
    }

    public void waitABitMore(String timeToWait) {
        messagePrintable.printMessage(timeToWait + " Попробуйте повторить ввод позже. Для этого нажмите любую клавишу");
    }

    public void insertCorrectPin() {
        messagePrintable.printMessage("Введите верный пин");
    }

    public void oneSymbol() {
        messagePrintable.printMessage("Введите ОДИН символ");
    }

    public void digit() {
        messagePrintable.printMessage("Нужна именно цифра");
    }

    public void successfulAuth() {
        messagePrintable.printMessage("Вы авторизованы");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
