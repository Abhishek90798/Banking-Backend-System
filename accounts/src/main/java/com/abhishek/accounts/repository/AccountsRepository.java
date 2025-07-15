package com.abhishek.accounts.repository;

import com.abhishek.accounts.entity.Accounts;
import com.abhishek.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
}
