package com.abhishek.accounts.service.impl;

import com.abhishek.accounts.dto.CustomerDto;
import com.abhishek.accounts.repository.AccountsRepository;
import com.abhishek.accounts.repository.CustomerRepository;
import com.abhishek.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
