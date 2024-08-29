package com.example.treeassignment.model;

import com.example.treeassignment.model.exstarnalEnum.AccountType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Account.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String accountNumber;
    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<Statement> statements;
}
