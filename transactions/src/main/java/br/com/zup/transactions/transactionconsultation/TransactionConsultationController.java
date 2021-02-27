package br.com.zup.transactions.transactionconsultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionConsultationController {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;

    @GetMapping("/{creditCardId}")
    public ResponseEntity<List<TransactionResponseDto>> getTransactions(@PathVariable String creditCardId) {
        if (this.creditCardRepository.countByExternalId(creditCardId) == 0) {
            return ResponseEntity.notFound().build();
        }
        List<TransactionResponseDto> transactions =
                this.transactionRepository.findTop10ByCreditCardExternalIdOrderByEffectiveDateDesc(creditCardId).stream().map(TransactionResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(transactions);
    }

}
