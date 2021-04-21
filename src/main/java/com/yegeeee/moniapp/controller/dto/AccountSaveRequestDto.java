package com.yegeeee.moniapp.controller.dto;

import com.yegeeee.moniapp.domain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountSaveRequestDto {
    private String name;
    private Long budget;

    @Builder
    public AccountSaveRequestDto(String name, Long budget) {
        this.name = name;
        this.budget = budget;
    }

    public Account toEntity() {
        return Account.builder()
                .name(name)
                .budget(budget)
                .build();
    }
}
