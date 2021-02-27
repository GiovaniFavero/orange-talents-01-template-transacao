package br.com.zup.transactions.transactionsconsumer;

import br.com.zup.transactions.transactionconsultation.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class TransactionConsumerService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CreditCardRepository creditCardRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void listen(NewTransactionDto transactionDto) {
        System.out.println("Consuming......." + transactionDto.toString());
        Transaction transaction = transactionDto.toModel(creditCardRepository);
        entityManager.persist(transaction);
    }

}
