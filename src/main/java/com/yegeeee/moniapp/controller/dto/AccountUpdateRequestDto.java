package com.yegeeee.moniapp.controller.dto;

import com.yegeeee.moniapp.domain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountUpdateRequestDto {
    private Long budget;

    @Builder
    AccountUpdateRequestDto(Long budget) {
        this.budget = budget;
    }

    public Account toEntity() {
        return Account.builder()
                .budget(budget)
                .build();
    }
}
