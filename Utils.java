package com.ortaklar;

public class Utils {


    public int toAsciiOctal(char value) {
        return Integer.parseInt(Integer.toOctalString((int) value));
    }

    public int toAsciiDecimal(String octalString) {
        int decimal=Integer.parseInt(octalString,8);

        return decimal;
    }

    public int secretSolver(String secretKey) {
        int secretStep = 0;
        int sum = 0;
        for (char c :secretKey.toCharArray()) {
            sum += toAsciiOctal(c);
        }
        secretStep = sum %10 ;
        return secretStep;
    }

}
