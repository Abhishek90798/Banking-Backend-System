package com.abhishek.accounts.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AccountsDto {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
