package com.example.treeassignment.service.mapper;



import com.example.treeassignment.model.Account;
import com.example.treeassignment.model.Statement;
import com.example.treeassignment.model.dto.AccountDTO;
import com.example.treeassignment.model.dto.StatementDTO;
import com.example.treeassignment.model.exstarnalEnum.AccountType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EntityToDTOConverter {


    public static AccountDTO convertToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setAccountType(String.valueOf(account.getAccountType()));
        accountDTO.setAccountNumber(account.getAccountNumber());
        return accountDTO;
    }
    public static StatementDTO convertToStatementDTO(Statement statement) {
        StatementDTO statementDTO = new StatementDTO();
        statementDTO.setId(statement.getId());
        statementDTO.setAccountId(statement.getAccount().getId());
        statementDTO.setDateField(statement.getDatefield().toString());
        statementDTO.setAmount((statement.getAmount()).toString());
        return statementDTO;
    }

    public static List<AccountDTO> convertToAccountDTOs(List<Account> accounts) {
        return accounts.stream().map(EntityToDTOConverter::convertToAccountDTO).collect(Collectors.toList());
    }

    public static List<StatementDTO> convertToStatementDTOs(List<Statement> statements) {
        return statements.stream().map(EntityToDTOConverter::convertToStatementDTO).collect(Collectors.toList());
    }
    public static Account convertToAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setAccountType(AccountType.valueOf(accountDTO.getAccountType()));
        account.setAccountNumber(accountDTO.getAccountNumber());
        return account;
    }
    public static Statement convertToStatement(StatementDTO statementDTO) {
        Statement statement = new Statement();
        statement.setId(statementDTO.getId());
        statement.setDatefield(LocalDate.parse(statementDTO.getDateField()));
        BigDecimal amountDto = new BigDecimal(statementDTO.getAmount());
        statement.setAmount(amountDto);

        // Assuming that Account ID is set in the DTO and you have a way to fetch Account entity
        Account account = new Account();
        account.setId(statementDTO.getAccountId());
        statement.setAccount(account);

        return statement;
    }
}