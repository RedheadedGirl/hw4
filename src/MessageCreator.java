public class MessageCreator {

    public static String balance(int amount) {
        return "Баланс составляет " + amount + " рублей";
    }

    public static String wantToAdd() {
        return "Вы собираетесь пополнить.";
    }

    public static String wantToTake() {
        return "Вы собираетесь снять.";
    }

    public static String cantTake() {
        return "Не удалось снять деньги";
    }

    public static String insertSum() {
        return "Внесите сумму (введите сумму, кратную 100):";
    }

    public static String wrongSum(String message) {
        return "Неверный формат суммы! " + message + " Введите заново";
    }

    public static String waitABitMore(String timeToWait) {
        return "Подождите еще немного: " + timeToWait;
    }

    public static String insertCorrectPin() {
        return "Введите верный пин";
    }

    public static String oneSymbol() {
        return "Введите ОДИН символ";
    }

    public static String digit() {
        return "Нужна именно цифра";
    }

    public static String successfulAuth() {
        return "Вы авторизованы";
    }




}
