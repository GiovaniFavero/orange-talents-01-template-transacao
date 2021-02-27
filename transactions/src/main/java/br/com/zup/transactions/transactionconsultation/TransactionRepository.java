package br.com.zup.transactions.transactionconsultation;

import br.com.zup.transactions.transactionsconsumer.Transaction;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTop10ByCreditCardExternalIdOrderByEffectiveDateDesc(String creditCardId);

}
