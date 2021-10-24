package br.com.saolucas.financemanager.transactions.domain.dto;

import br.com.saolucas.financemanager.transactions.domain.Transaction;
import br.com.saolucas.financemanager.transactions.domain.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionResponse {
	
	private Long id;
	private TransactionType type;
	private String description;
	private BigDecimal amount;
	private LocalDateTime createdAt;
	
	public TransactionResponse(Transaction transaction) {
		this.id = transaction.getId();
		this.type = transaction.getType();
		this.description = transaction.getDescription();
		this.amount = transaction.getAmount();
		this.createdAt = transaction.getCreatedAt();
		
	}
	
	public TransactionResponse() {
	}
	
	public Long getId() {
		return id;
	}
	
	public TransactionType getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public static List<TransactionResponse> mapToTransactionResponse(List<Transaction> transactions) {
		return transactions.stream().map(TransactionResponse::new).collect(Collectors.toList());
	}
}
