package com.mycompany.mavenproject21;

import java.util.Scanner;

public class RealBankAccount  implements BankAccount {

    private double balance;
    private String currancy;
    private String name;
    private int pasword;
    Scanner in = new Scanner(System.in);

    public RealBankAccount(String name, int pasword, double balance, String currancy) {
        this.balance = balance;
        this.name = name;
        this.pasword = pasword;
        this.currancy = currancy;
    }

    public void withDrow() {
        boolean flag = true;
        double p = 0;

        while (true) {
            System.out.println("plese inter the pasword");
            int pas = in.nextInt();
            if (this.pasword != pas) {
                System.out.println("your pasword is rwong plese try again");
                continue;
            }
            break;
        }
        while (flag) {
            while (true) {
                System.out.println("plese inter the amount you want to diposite");
                p = in.nextDouble();
                if (this.balance < p) {
                    System.out.println("plese inter a vaild amount");
                    continue;
                }
                break;
            }

            this.balance -= p;
            System.out.println("Amount Withdrawn Successfully");
            System.out.println("the recent amount is " + balance);
            System.out.println("do you want to with draw again (y) or (n)");
            char c = in.next().charAt(0);
            if (c == 'N' || c == 'n') {
                flag = false;
            }

        }
        System.out.println("**********thank you " + this.name + " ************");
    }

    public void diposite() {

        double amount = 0;

        while (true) {
            System.out.println("plese inter your pasword");
            int pas = in.nextInt();
            if (this.pasword != pas) {
                continue;
            }
            break;
        }

        System.out.println("plese inter the amount tou want to diposite");
        amount = in.nextDouble();
        this.balance = amount;
        System.out.println("Amount diposite Successfully");
        System.out.println("your amount is " + this.balance);
        boolean flag = true;
        while (flag) {
            System.out.println("do you want to dopisetr again(y)(n)");
            char c = in.next().charAt(0);
            if (c == 'n' || c == 'N') {
                break;
            }
        }
        System.out.println("*************thank you " + this.name + " ***********");
    }

    public void transform() {

        double amount = 0;

        while (true) {
            System.out.println("plese inter your pasword");
            int pas = in.nextInt();
            if (this.pasword != pas) {
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("plese inter the amount you want to tranform");
            amount = in.nextDouble();
            if (this.balance < amount) {
                System.out.println("plese inter a vaild amount");
                continue;
            }
            break;
        }
        this.balance -= amount;
        System.out.println("Amount tranformed Successfully");
        System.out.println("the recent amount is " + balance);
        System.out.println("*************thank you " + this.name + " ***********");
    }
    @Override
    public String toString() {
        return "BankAcount{" + "balance=" + balance + ", currancy=" + currancy + ", name=" + name + ", pasword=" + pasword + '}';
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrancy() {
        return currancy;
    }

    public String getName() {
        return name;
    }

    public int getPasword() {
        return pasword;
    }

    @Override
    public void withDraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deposite() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void tranform() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
