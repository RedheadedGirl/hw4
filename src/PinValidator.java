import java.util.Scanner;

import static java.lang.Character.isDigit;

public class PinValidator {

    public void validate() {
        String pass = "1234";
        String pin = "";
        Scanner s = new Scanner(System.in);
        int amountNotCorrectPin = 0;
        while (!pass.equals(pin)) {
            pin = "";
            if (amountNotCorrectPin >= 3) {
                long t = System.currentTimeMillis();
                long end = t + 10000;
                while(System.currentTimeMillis() < end) {
                    if (s.nextLine() != null) {
                        try {
                            throw new AccountIsLockedException((end - System.currentTimeMillis()) / 1000 + " сек");
                        } catch (AccountIsLockedException ex) {
                            MessageHandler.waitABitMore(ex.getMessage());
                        }
                    }
                }
                amountNotCorrectPin = 0;
            }
            MessageHandler.insertCorrectPin();
            for (int i = 0; i < pass.length(); i++) {
                MessageHandler.printMessage(i + 1 + " символ: ");
                String next = s.next();
                if (next.length() != 1) {
                    MessageHandler.oneSymbol();
                    i--;
                    continue;
                }
                if (!isDigit(next.charAt(0))) {
                    MessageHandler.digit();
                    i--;
                    continue;
                }
                pin = pin + next;
            }
            amountNotCorrectPin++;
        }
        MessageHandler.successfulAuth();

    }
}
