package com.abhishek.accounts.service;

import com.abhishek.accounts.dto.CustomerDto;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);
}
