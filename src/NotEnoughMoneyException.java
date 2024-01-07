public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super("На счету недостаточно средств");
    }
}
