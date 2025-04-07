package me.dio;

import jakarta.persistence.*;
import java.math.BigDecimal;  // Importe BigDecimal

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private String agency;

    // Opção 1: Usando BigDecimal (recomendado para valores monetários)
    @Column(precision = 15, scale = 2)  // 15 dígitos no total, 2 decimais
    private BigDecimal balance;

    // Opção 1: Usando BigDecimal
    @Column(name = "additional_limit", precision = 15, scale = 2)
    private BigDecimal limit;

    // Opção 2: Se preferir usar float (não recomendado para valores monetários)
    // private float balance;  // Sem anotações precision/scale
    // private float limit;    // Sem anotações precision/scale

    public Account() {}

    // Getters e Setters (atualize-os para BigDecimal se usar a opção 1)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    // ... outros getters e setters permanecem iguais
}