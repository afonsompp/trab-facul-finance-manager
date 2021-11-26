package br.com.saolucas.financemanager.transactions;

import br.com.saolucas.financemanager.transactions.domain.Transaction;
import br.com.saolucas.financemanager.transactions.domain.dto.TransactionRequest;
import br.com.saolucas.financemanager.transactions.domain.dto.TransactionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@Validated
public class TransactionController {
	
	private final TransactionRepository transactionRepository;
	
	public TransactionController(
			TransactionRepository transactionRepository) {this.transactionRepository = transactionRepository;}
	
	@PostMapping
	public ResponseEntity<TransactionResponse> saveTransaction(
			@Valid @RequestBody final TransactionRequest transactionRequest) {
		
		Transaction savedTransaction = transactionRepository.save(transactionRequest.toTransaction());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedTransaction.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new TransactionResponse(savedTransaction));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<TransactionResponse>> transactionsByUserId(
			@NotNull @PathVariable("userId") String userId) {
		List<Transaction> transactions = transactionRepository.findByUserId(userId);
		
		if (transactions.isEmpty())
			return ResponseEntity.notFound().build();
		
		List<TransactionResponse> transactionsResponse = TransactionResponse.mapToTransactionResponse(transactions);
		
		return ResponseEntity.ok(transactionsResponse);
	}
}
