package com.example.treeassignment.controller;


import com.example.treeassignment.handler.AccountNotFoundException;
import com.example.treeassignment.handler.DateNotinvaledFormatException;
import com.example.treeassignment.model.Account;
import com.example.treeassignment.model.ResponseModel;
import com.example.treeassignment.model.dto.AccountDTO;
import com.example.treeassignment.service.AccountService;
import com.example.treeassignment.service.mapper.AccountMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AccountDTO createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return accountService.saveAccount(accountDTO) ;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseModel<ResponseEntity<?>> getAccountById(@PathVariable Long id)throws AccountNotFoundException {

        try {
            Account account = accountService.getAccountById(id);
            AccountDTO accountDTO = AccountMapper.convertToAccountDTO(account);

            return new ResponseModel("the Data Retirement", ResponseEntity.ok(accountDTO).getBody());
        } catch (AccountNotFoundException ex) {
            return new ResponseModel("400", ResponseEntity.badRequest().body(ex.getMessage()));
        }



    }

}