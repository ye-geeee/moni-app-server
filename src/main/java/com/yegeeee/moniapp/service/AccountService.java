package com.yegeeee.moniapp.service;

import com.yegeeee.moniapp.domain.Account;
import com.yegeeee.moniapp.repository.AccountRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account addAccount(Account account) {
        accountRepository.findByName(account.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 계좌 정보입니다.");
                });

        return accountRepository.save(account);
    }

/*    public Long updateAccount(String name) {
        Account account = accountRepository.findByName(name)
                .get();

    };*/

    public List<Account> findAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findOne(Long accountId) {
        return accountRepository.findById(accountId);
    }
}
