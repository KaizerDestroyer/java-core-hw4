package com.iksgroup;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным.");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) { throw new IllegalArgumentException("Сумма депозита должна быть положительной."); }
        balance += amount;
        System.out.println("Счет успешно пополнен на: " + amount);
        System.out.println("Текущий баланс: " + getBalance());
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount > balance) { throw new InsufficientFundsException(balance, amount); }
        else {
            balance -= amount;
            System.out.println("Со счета снято: " + amount);
            System.out.println("Текущий баланс: " + getBalance());
        }
    }

    public double getBalance() {
        return balance;
    }
}

