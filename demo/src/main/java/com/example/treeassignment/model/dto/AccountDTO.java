package com.example.treeassignment.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class AccountDTO {
    private Long id;
    @NotEmpty(message = "Account Type cannot be null or Empty")
    private String accountType;
    @NotEmpty(message = "Account Number cannot be null or Empty")
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