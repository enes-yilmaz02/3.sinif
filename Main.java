package com.ortaklar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String islem="Welcome To Encryption and Decryption Algorithims. "
                     +"Transactions-->"
                     +"1)Encryption :"
                     +"2)Decryption :";

        System.out.println("Please Select a Transaction Type (1 or 2 ?): ");
        Scanner tr=new Scanner(System.in);
        int transactions=tr.nextInt();
        if(transactions==1){
            Scanner sc=new Scanner(System.in);
            System.out.println("Şifrelenecek Metni Giriniz:  ");
            String in=sc.nextLine();
            Scanner an=new Scanner(System.in);
            System.out.println("Gizleyecek anahtarı giriniz:  ");
            String anahtar=an.nextLine();
            Encryption encryption = new Encryption(in, anahtar);
            System.out.println(encryption.encrypted());
        }
        else if(transactions==2){
            Scanner scan=new Scanner(System.in);
            System.out.println("Please , Enter The Encrypted Message: ");
            String EncryptionMessage=scan.nextLine();
            Scanner result=new Scanner(System.in);
            System.out.println("please ,Enter a Key: ");
            String ResultKey=result.nextLine();
            Decryption decryption = new Decryption(EncryptionMessage, ResultKey);
            System.out.println(decryption.decrypted());
        }
       

        
       
    }


}
