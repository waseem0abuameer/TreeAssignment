package com.example.treeassignment.model.dto;

public class StatementDTO {

    private Long accountId;
    private String dateField;
    private String amount;

    public StatementDTO() {
    }

    public StatementDTO( Long accountId, String dateField, String amount) {
        this.accountId = accountId;
        this.dateField = dateField;
        this.amount = amount;
    }



    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getDateField() {
        return dateField;
    }

    public void setDateField(String dateField) {
        this.dateField = dateField;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}