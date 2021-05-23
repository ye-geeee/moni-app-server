package com.yegeeee.moniapp.controller.dto;

import com.yegeeee.moniapp.domain.Account;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AccountResponseDto {

    private Long accountSeq;
    private final String name;
    private final Long budget;

    @Builder
    public AccountResponseDto(Account account) {
        this.name = account.getName();
        this.budget = account.getBudget();
    }
}
