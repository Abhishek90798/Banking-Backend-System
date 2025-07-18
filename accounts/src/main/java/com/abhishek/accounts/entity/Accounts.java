package com.abhishek.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity{

    @Column(name = "customer_id")
    private Long customerId;
    @Id
    @Column(name="account_number")
    private Long accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name="branch_address")
    private String branchAddress;
}
