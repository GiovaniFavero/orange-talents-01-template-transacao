package br.com.zup.transactions.transactionsconsumer;

import br.com.zup.transactions.transactionconsultation.CreditCardRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class NewTransactionDto {

    private String id;
    private BigDecimal valor;
    private NewEstablishmentDto estabelecimento;
    private NewCardDto cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public NewEstablishmentDto getEstabelecimento() {
        return estabelecimento;
    }

    public NewCardDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transaction toModel(CreditCardRepository creditCardRepository) {
        Optional<CreditCard> optional = creditCardRepository.findByExternalId(this.cartao.getId());
        return new Transaction(this.id, this.valor, this.efetivadaEm,
                new Establishment(this.estabelecimento.getNome(), this.estabelecimento.getCidade(), this.estabelecimento.getEndereco()),
                optional.isPresent() ? optional.get() : new CreditCard(this.cartao.getId(), this.cartao.getEmail()));
    }

    @Override
    public String toString() {
        return "NewTransactionDto{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
