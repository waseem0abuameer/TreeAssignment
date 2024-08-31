package com.example.treeassignment.service;

import com.example.treeassignment.handler.AccountNotFoundException;
import com.example.treeassignment.model.Account;
import com.example.treeassignment.model.dto.AccountDTO;
import com.example.treeassignment.repository.AccountRepository;
import com.example.treeassignment.service.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static com.example.treeassignment.util.StringUtils.maskString;

@Service
public class AccountService {


    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDTO  saveAccount(AccountDTO accountDTO) throws AccountNotFoundException {
        Account account = AccountMapper.convertToAccount(accountDTO);
            accountRepository.save(account);
        return AccountMapper.convertToAccountDTO(account);
    }

    @Transactional
    public List<Account> saveAllAccounts(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        accounts.stream()
                .forEach(account -> account.setAccountNumber(maskString(account.getAccountNumber())));

              return AccountMapper.convertToAccountDTOs(accounts);

    }

    public Account getAccountById(Long id) throws AccountNotFoundException {
        try {
            return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        }catch (Exception e) {
            throw new AccountNotFoundException("Account not found");
        }
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}