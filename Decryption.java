package com.ortaklar;

import java.util.ArrayList;
import java.util.List;

public class Decryption {
    private String decryptedValue;
    private String secretKey;
    private Utils utils = new Utils();

    public Decryption(String decryptedValue, String secretKey) {
        this.decryptedValue = decryptedValue;
        this.secretKey = secretKey;
    }

    public String decrypted() {
        int secretStep = utils.secretSolver(this.secretKey);
        List<String> splitValues = new ArrayList();
        int lenght = decryptedValue.length();
        for (int i = 0; i < lenght; i++) {
            if (i % 4 == 0) {
                int mod = 0;
                int remainder = 0;
                String chars = decryptedValue.substring(decryptedValue.length() - 4);
                decryptedValue = decryptedValue.substring(0, decryptedValue.length() - 4);
                if (chars.startsWith("0")) {
                    while (chars.startsWith("0")) {
                        chars = chars.substring(1);
                    }
                    remainder = Integer.parseInt(chars);

                    splitValues.add(String.valueOf(remainder));
                } else {
                    mod = Integer.parseInt(chars.substring(0, 1));
                    chars = chars.substring(1);
                    while (chars.startsWith("0")) {
                        chars = chars.substring(1);
                    }
                    remainder = Integer.parseInt(chars);

                }
                splitValues.add(String.valueOf(remainder * secretStep + mod));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String value : splitValues) {
            char c = (char) utils.toAsciiDecimal(value);
            stringBuilder.insert(0, c);
        }
        return stringBuilder.reverse().toString();
    }
}
