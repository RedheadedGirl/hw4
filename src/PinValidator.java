import java.util.Scanner;

import static java.lang.Character.isDigit;

public class PinValidator implements Validator {

    private MessageHandler messageHandler;

    public PinValidator(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public void validate() {
        String pass = "1234";
        String pin = "";
        int amountNotCorrectPin = 0;
        while (!pass.equals(pin)) {
            pin = "";
            if (amountNotCorrectPin >= 3) {
                messageHandler.waitABitMore("Aккаунт заблокирован на 10 сек.");
                checkNoInput();
                amountNotCorrectPin = 0;
            }
            pin = insertPin(pass.length());
            amountNotCorrectPin++;
        }
        messageHandler.successfulAuth();

    }

    @Override
    public String insertPin(int passwordLength) {
        String pin = "";
        Scanner s = new Scanner(System.in);
        messageHandler.insertCorrectPin();
        for (int i = 0; i < passwordLength; i++) {
            messageHandler.printMessage(i + 1 + " символ: ");
            String next = s.next();
            if (next.length() != 1) {
                messageHandler.oneSymbol();
                i--;
                continue;
            }
            if (!isDigit(next.charAt(0))) {
                messageHandler.digit();
                i--;
                continue;
            }
            pin = pin + next;
        }
        return pin;
    }

    void checkNoInput() {
        Scanner s = new Scanner(System.in);
        long insertEnabled = System.currentTimeMillis() + 10000;
        while(System.currentTimeMillis() < insertEnabled) {
            try {
                if (s.nextLine() != null && System.currentTimeMillis() < insertEnabled) {
                    throw new AccountIsLockedException((insertEnabled - System.currentTimeMillis()) / 1000 + " сек");
                }
            } catch (AccountIsLockedException ex) {
                messageHandler.waitABitMore(ex.getMessage());
            }
        }
    }
}
