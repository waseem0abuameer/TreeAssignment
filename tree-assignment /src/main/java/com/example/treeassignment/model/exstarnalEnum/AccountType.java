package com.example.treeassignment.model.exstarnalEnum;

/**
 * The enum Account type.
 */
public enum AccountType {
    CURRENT("Current"),
    SAVINGS("Savings");
    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
