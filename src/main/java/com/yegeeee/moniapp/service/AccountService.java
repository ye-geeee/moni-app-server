package com.yegeeee.moniapp.service;

import com.yegeeee.moniapp.controller.dto.AccountResponseDto;
import com.yegeeee.moniapp.controller.dto.AccountSaveRequestDto;
import com.yegeeee.moniapp.controller.dto.AccountUpdateRequestDto;
import com.yegeeee.moniapp.domain.Account;
import com.yegeeee.moniapp.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    public List<AccountResponseDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AccountResponseDto findById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[account id = " + id + "] No proper account information found"));
        return new AccountResponseDto(account);
    }

    public Long save(AccountSaveRequestDto accountSaveRequestDto) {
        accountRepository.findByName(accountSaveRequestDto.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("account already exists");
                });
        return accountRepository.save(accountSaveRequestDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, AccountUpdateRequestDto accountUpdateRequestDto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[account id = " + id + "] No proper account information found"));
        account.update(accountUpdateRequestDto.getBudget());
        return id;
    }

    @Transactional
    public void delete(Long id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[account id = " + id + "] No proper account information found"));
        accountRepository.delete(account);
    }

    public Account findAccount(Account account) {
        return accountRepository.findByName(account.getName()).orElse(null);
    }
}
