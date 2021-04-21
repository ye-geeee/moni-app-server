package com.yegeeee.moniapp.controller;

import com.yegeeee.moniapp.controller.dto.AccountSaveRequestDto;
import com.yegeeee.moniapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Long create(@RequestBody AccountSaveRequestDto requestDto) {
        return accountService.addAccount(requestDto.toEntity()).getId();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Long update(@RequestBody AccountSaveRequestDto requestDto) {
        return accountService.updateAccount(requestDto.toEntity().getName());
    }

}
