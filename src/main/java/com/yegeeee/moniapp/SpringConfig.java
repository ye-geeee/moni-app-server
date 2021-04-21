package com.yegeeee.moniapp;

import com.yegeeee.moniapp.repository.AccountRepository;
import com.yegeeee.moniapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.JavaBean;

@Configuration
public class SpringConfig {

    private final AccountRepository accountRepository;

    @Autowired
    public SpringConfig(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Bean
    public AccountService accountService() {
        return new AccountService(accountRepository);
    }
}
