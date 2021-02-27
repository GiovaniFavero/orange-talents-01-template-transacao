package br.com.zup.transactions.transactionsconsumer;

import javax.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String externalId;
    private String email;

    public CreditCard(String externalId, String email) {
        this.externalId = externalId;
        this.email = email;
    }

    @Deprecated
    public CreditCard() {
    }

    public String getExternalId() {
        return externalId;
    }

    public String getEmail() {
        return email;
    }
}
