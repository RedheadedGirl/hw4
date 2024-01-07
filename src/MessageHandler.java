public class MessageHandler {

    public static void showBalance(int amount) {
        System.out.println(MessageCreator.balance(amount));
    }

    public static void wantToAdd() {
        System.out.println(MessageCreator.wantToAdd());
    }

    public static void wantToTake() {
        System.out.println(MessageCreator.wantToTake());
    }

    public static void cantTake() {
        System.out.println(MessageCreator.cantTake());
    }

    public static void insertSum() {
        System.out.println(MessageCreator.insertSum());
    }

    public static void wrongSum(String message) {
        System.out.println(MessageCreator.wrongSum(message));
    }

    public static void waitABitMore(String timeToWait) {
        System.out.println(MessageCreator.waitABitMore(timeToWait));
    }

    public static void insertCorrectPin() {
        System.out.println(MessageCreator.insertCorrectPin());
    }

    public static void oneSymbol() {
        System.out.println(MessageCreator.oneSymbol());
    }

    public static void digit() {
        System.out.println(MessageCreator.digit());
    }

    public static void successfulAuth() {
        System.out.println(MessageCreator.successfulAuth());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
