package br.com.zup.transactions.transactionsconsumer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String transactionId;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private LocalDateTime effectiveDate;
    @Embedded
    private Establishment establishment;
    @ManyToOne(cascade = CascadeType.ALL)
    private CreditCard creditCard;

    public Transaction(@NotBlank String transactionId, @NotNull BigDecimal amount, @NotNull LocalDateTime effectiveDate, Establishment establishment, CreditCard creditCard) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.effectiveDate = effectiveDate;
        this.establishment = establishment;
        this.creditCard = creditCard;
    }

    @Deprecated
    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
