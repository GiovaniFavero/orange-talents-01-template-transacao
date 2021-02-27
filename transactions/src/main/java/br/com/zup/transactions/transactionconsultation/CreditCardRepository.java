package br.com.zup.transactions.transactionconsultation;

import br.com.zup.transactions.transactionsconsumer.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    Long countByExternalId(String externalId);

    Optional<CreditCard> findByExternalId(String externalId);
}
