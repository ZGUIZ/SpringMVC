package com.zguiz.bean;

public class Customer {
    private int userId;
    private String account;
    private String password;
    private int balance;

    public Customer() {
    }

    public Customer(int userId, String account, String password, int balance) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
