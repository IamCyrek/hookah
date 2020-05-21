package com.example.hookah.controller;

import com.example.hookah.model.AccountLevel;
import com.example.hookah.service.AccountLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.hookah.configuration.Constants.API_ACCOUNT_LEVELS;

@RestController
@RequestMapping(API_ACCOUNT_LEVELS)
@RequiredArgsConstructor
public class AccountLevelController {

    private final AccountLevelService accountLevelService;

    @GetMapping
    public List<AccountLevel> getAll(@SortDefault(sort = {"value", "id"}) Sort sort) {
        return accountLevelService.getAll(sort);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountLevel create(@Valid @RequestBody AccountLevel accountLevel) {
        return accountLevelService.create(accountLevel);
    }

    @PutMapping
    public AccountLevel update(@Valid @RequestBody AccountLevel accountLevel) {
        return accountLevelService.update(accountLevel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) {
        accountLevelService.delete(id);
    }

}
