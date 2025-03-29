package com.giftsubscription;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {
    User user;
    boolean isValid = true;
    UserStorage userStorage = new UserStorage();

    public void registration() {
        Scanner scanner = new Scanner(System.in);
        isValid = true;
        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите вашу почту: ");
        String mail = scanner.nextLine();
        System.out.println("Введите ваш номер: ");
        String number = scanner.nextLine();
        System.out.println("Создайте будущий пароль: ");
        String password = scanner.nextLine();

        Checker<String> mailChecker = new MailChecker(mail, ValidationMode.REGISTRATION);
        if(mailChecker.isValid(userStorage)) {
            isValid = false;
            System.out.println(mailChecker.getErrorMessage());
        }
        Checker<String> numChecker = new NumberChecker(number);
        if(numChecker.isValid(userStorage)) {
            isValid = false;
            System.out.println(numChecker.getErrorMessage());
        }

        if (isValid) {
            user = new User(name, mail, number, password);
            userStorage.addUser(user);
            System.out.println(name + ", Аккаунт успешно зарегистировался!");
        } else {
            System.out.println("Повторите попытку!");
        }
    }

    public void authorization() {
            Scanner scanner = new Scanner(System.in);
            isValid = true;
            System.out.println("Введите вашу почту: ");
            String mail = scanner.nextLine();
            System.out.println("Введите ваш пароль: ");
            String password = scanner.nextLine();
            Checker<String> mailChecker = new MailChecker(mail, ValidationMode.AUTHORIZATION);
            if(!mailChecker.isValid(userStorage)) {
                isValid = false;
                System.out.println(mailChecker.getErrorMessage());
            } else {
                isValid = true;
            }
            Checker<String> passwordChecker = new PasswordChecker(password, mail);
            if(!passwordChecker.isValid(userStorage)) {
                isValid = false;
                System.out.println(passwordChecker.getErrorMessage());
            } else {
                isValid = true;
            }

            if(isValid) {
                user = userStorage.getUser(mail);
                System.out.println(user.getName() + ", Вы успешно вошли в систему!");
            } else {
                System.out.println("Повторите попытку!");
            }

    }

    public void aboutAccount() {

    }
    public void buySubscription() {

    }



}




