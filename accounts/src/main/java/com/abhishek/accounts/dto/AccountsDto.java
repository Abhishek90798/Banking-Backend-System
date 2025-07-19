package com.abhishek.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp = "^$|[0-9]{10}",message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type can't be null or empty")
    private String accountType;

    @NotEmpty(message = "Branch Address can't be null or empty")
    private String branchAddress;
}
