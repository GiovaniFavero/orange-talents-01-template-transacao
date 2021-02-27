package br.com.zup.transactions.transactionconsultation;

import br.com.zup.transactions.transactionsconsumer.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDto {

    private String id;
    private BigDecimal amount;
    private EstablishmentResponseDto establishment;
    private CardResponseDto creditCard;
    private LocalDateTime effectiveDate;

    public TransactionResponseDto(Transaction transaction) {
        this.id = transaction.getTransactionId();
        this.amount = transaction.getAmount();
        this.effectiveDate = transaction.getEffectiveDate();
        this.establishment = new EstablishmentResponseDto(transaction.getEstablishment());
        this.creditCard = new CardResponseDto(transaction.getCreditCard());
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public EstablishmentResponseDto getEstablishment() {
        return establishment;
    }

    public CardResponseDto getCreditCard() {
        return creditCard;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }
}
