package com.example.treeassignment.model.dto;

import com.example.treeassignment.model.exstarnalEnum.AccountType;

public class AccountDTO {
    private Long id;
    private String accountType;
    private String accountNumber;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}