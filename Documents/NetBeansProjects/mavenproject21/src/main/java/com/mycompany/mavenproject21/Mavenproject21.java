package com.mycompany.mavenproject21;

import java.util.Scanner;

public class Mavenproject21 {

    public static void main(String[] args) {

        Object arr[] = new Object[5];
        arr[0] = new RealBankAccount("ahmad", 36036036, 200, "dolar");
        arr[1] = new RealBankAccount("ali", 111, 500, "denar");
        arr[2] = new RealBankAccount("mohamed", 563, 500, "denar");
        arr[3] = new RealBankAccount("sami", 511, 1100, "denar");
        arr[4] = new RealBankAccount("rami", 1010, 2000, "dolar");

        printTopTHrea(arr);

    }

    public static void printByCurrancy(RealBankAccount arr[], String str) {

        for (int i = 0; i < arr.length; i++) {
            if (str.equalsIgnoreCase(arr[i].getCurrancy())) {
                System.out.println(arr[i]);
            }
        }
    }

    public static RealBankAccount[] getHighBalance(RealBankAccount arr[]) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getBalance() >= 1000000) {
                count++;
            }
        }
        RealBankAccount high[] = new RealBankAccount[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getBalance() >= 1000000) {
                high[index++] = arr[i];
            }
        }
        return high;
    }

    public static void printTopTHrea(Object arr[]) {

        RealBankAccount c[] = new RealBankAccount[arr.length];
        for (int i = 0; i < arr.length; i++) {
           
            c[i]=(RealBankAccount)arr[i];
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length - 1; j++) {
                if (c[j].getBalance() < c[j + 1].getBalance()) {
                    RealBankAccount temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(c[i]);
        }

    }
}
