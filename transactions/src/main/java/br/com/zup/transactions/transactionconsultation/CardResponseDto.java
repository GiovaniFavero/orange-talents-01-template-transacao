package br.com.zup.transactions.transactionconsultation;

import br.com.zup.transactions.transactionsconsumer.CreditCard;

public class CardResponseDto {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CardResponseDto(CreditCard creditCard) {
        this.id = creditCard.getExternalId();
        this.email = creditCard.getEmail();
    }

    @Override
    public String toString() {
        return "NewCardDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
