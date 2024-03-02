package com.iksgroup;

public class InsufficientFundsException extends Exception{
      private double amount;

    public InsufficientFundsException(double balance, double amount) {
        super("Недостаточно средств на балансе. Текущий баланс: " + balance + ", не хватает для снятия: " + (amount - balance)  );
    }

}
