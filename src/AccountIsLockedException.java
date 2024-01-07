public class AccountIsLockedException extends RuntimeException {

    public AccountIsLockedException(String message) {
        super("Aккаунт заблокирован на 10 сек. Осталось " + message);
    }
}
