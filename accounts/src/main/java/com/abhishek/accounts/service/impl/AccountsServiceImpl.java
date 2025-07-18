package com.abhishek.accounts.service.impl;

import com.abhishek.accounts.constants.AccountsConstants;
import com.abhishek.accounts.dto.CustomerDto;
import com.abhishek.accounts.entity.Accounts;
import com.abhishek.accounts.entity.Customer;
import com.abhishek.accounts.exception.CustomerAlreadyExistsException;
import com.abhishek.accounts.mapper.CustomerMapper;
import com.abhishek.accounts.repository.AccountsRepository;
import com.abhishek.accounts.repository.CustomerRepository;
import com.abhishek.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer=CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customer.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given Mobile Number: "+customer.getMobileNumber());
        }else{
            customer.setCreatedAt(LocalDateTime.now());
            customer.setCreatedBy("Anonymus");
            Customer savedCustomer=customerRepository.save(customer);
            savedCustomer.setCreatedAt(LocalDateTime.now());
            savedCustomer.setCreatedBy("Anonymus");
            accountsRepository.save(createNewAccount(savedCustomer));
        }

    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
