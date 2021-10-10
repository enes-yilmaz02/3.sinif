package com.ortaklar;

public class Encryption {
    private String keyword;
    private String secretKey;
    private Utils utils = new Utils();

    public Encryption(String keyword, String secretKey) {
        this.keyword = keyword;
        this.secretKey = secretKey;
    }

    public String encrypted() {
        // şifrelenecek değeri tutacak değişken tanımlandı
        StringBuilder encryptedValue = new StringBuilder();
        //secret step oktala çevrilecek olan sayıyı bölen  değerdir. her secret key 0 ile 10 arasında bir sayıdır.
        int secretStep = utils.secretSolver(this.secretKey);
        for (char c : this.keyword.toCharArray()) {
            // harfi oktala çeviriyoruz
            int calculatedValue = utils.toAsciiOctal(c);
            // burada oktal sayıyı secret steepe bölerek kalan ve bölüm değerlerini tutuyoruz
            String mod = String.valueOf(calculatedValue % secretStep);
            String remainder = String.valueOf(calculatedValue / secretStep);

            // her harf için şifreli metinde 4 basamak tutulacaktır. kalan var ise ilk rakam kalan olacak bölüm ise son değerde tutulacaktır.
            //  kalan ve bölüm değerleri 4 te küçük ise araya 0 konacaktır. kalan yoksa başa 0 koyulacaktır.
            // örn mod = 2 remainder= 23 basamak değeri 2023
            // orn mod = 0 remainder = 12 basamak değeri 0012 olacaktır.
            if (remainder.length() == 3) {
                encryptedValue.insert(0, "0" + remainder);
            } else if (remainder.length() == 2) {
                encryptedValue.insert(0, mod + "0" + remainder);
            } else {
                encryptedValue.insert(0, mod + "0" + "0" + remainder);
            }

        }
        return  encryptedValue.toString();
    }

}

