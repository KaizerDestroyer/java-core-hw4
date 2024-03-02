package com.iksgroup;

import java.util.Scanner;

public class Main {
    private static Account account;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите начальный баланс: ");
            double initialBalance = scanner.nextDouble();
            account = new Account(initialBalance);
            System.out.println();

            while (true) {
                printOperations();
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Текущий баланс: " + account.getBalance());
                    buySomething(account.getBalance());
                    System.out.println();
                } else if (choice == 2) {
                    System.out.print("Введите сумму пополнения: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println();
                } else if (choice == 3) {
                    System.out.print("Введите сумму снятия: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println();
                } else if (choice == 0) {
                    System.out.println("Программа завершена.");
                    break;
                } else {
                    System.out.println("Неверный выбор. Пожалуйста, выберите действие снова.");
                }
            }
        } catch (IllegalArgumentException | InsufficientFundsException exception) {
            System.out.println(exception.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void printOperations() {
        String operations = """
                Доступные операции: 
                1. Просмотр баланса
                2. Пополнение
                3. Снятие
                0. Завершить программу
                """;
        System.out.println(operations);
    }

    public static void buySomething(double balance) {
        if (balance <= 1000)
            System.out.println("Мало что можно купить(");
        else if (balance > 1000 && balance <= 10000)
            System.out.println("Уже можно взять что-то поинтересней");
        else
            System.out.println("Да ты богач)");
    }
}