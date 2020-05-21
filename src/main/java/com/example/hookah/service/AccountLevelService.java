package com.example.hookah.service;

import com.example.hookah.model.AccountLevel;
import com.example.hookah.repository.AccountLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountLevelService {

    private final AccountLevelRepository accountLevelRepository;

    public List<AccountLevel> getAll(Sort sort) {
        return accountLevelRepository.findAll(sort);
    }

    public Optional<AccountLevel> getAccountLevelByValue(Long value) {
        return accountLevelRepository.findFirstByValueIsLessThanEqual(value);
    }

    public AccountLevel create(AccountLevel accountLevel) {
        accountLevel.setId(null);
        return accountLevelRepository.save(accountLevel);
    }

    public AccountLevel update(AccountLevel accountLevel) {
        Optional<AccountLevel> optionalAccountLevel = accountLevelRepository.findById(accountLevel.getId());
        if (!optionalAccountLevel.isPresent()) {
            //TODO: throw exception
            return null;
        }

        AccountLevel oldAccountLevel = optionalAccountLevel.get();
        oldAccountLevel.setName(accountLevel.getName());
        oldAccountLevel.setValue(accountLevel.getValue());

        return accountLevelRepository.save(accountLevel);
    }

    public void delete(Long id) {
        if (!accountLevelRepository.findById(id).isPresent()) {
            //TODO: throw exception
            return;
        }

        accountLevelRepository.deleteById(id);
    }

}
