package com.yegeeee.moniapp.controller;

import com.yegeeee.moniapp.controller.dto.AccountResponseDto;
import com.yegeeee.moniapp.controller.dto.AccountSaveRequestDto;
import com.yegeeee.moniapp.controller.dto.AccountUpdateRequestDto;
import com.yegeeee.moniapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> findAll() {
        List<AccountResponseDto> accountResponseDtoList = accountService.findAll();
        return new ResponseEntity<List<AccountResponseDto>>(accountResponseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{accountId}")
    public ResponseEntity<AccountResponseDto> findById(@PathVariable("accountId") Long accountId) {
        AccountResponseDto accountResponse = accountService.findById(accountId);
        return new ResponseEntity<AccountResponseDto>(accountResponse, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody AccountSaveRequestDto requestDto) {
        Long savedAccountId = accountService.save(requestDto);
        return new ResponseEntity<Long>(savedAccountId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{accountId}")
    public ResponseEntity update(@PathVariable("accountId") Long accountId,
                                 @RequestBody AccountUpdateRequestDto requestDto) {
        Long updatedAccountId = accountService.update(accountId, requestDto);
        return new ResponseEntity<Long>(updatedAccountId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{accountId}")
    public ResponseEntity deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.delete(accountId);
        return new ResponseEntity<Long>(accountId, HttpStatus.NO_CONTENT);
    }
}
