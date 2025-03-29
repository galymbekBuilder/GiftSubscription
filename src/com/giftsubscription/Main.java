package com.giftsubscription;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Добро пожаловать в наш сервис!\n1.Регистрация\n2.Авторизация\n3.Выход");
            int answer = scanner.nextInt();
            scanner.nextLine();
            switch (answer) {
                case 1 -> account.registration();
                case 2 -> handleAuthorization(account);
                case 3 -> {
                    System.out.println("Выход из системы...");
                    return;
                }
            }
        }
    }
    public static void handleAuthorization(Account account) {
        account.authorization();

    }
}