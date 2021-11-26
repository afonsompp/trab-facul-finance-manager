package br.com.saolucas.financemanager.transactions.domain.dto;

import br.com.saolucas.financemanager.transactions.domain.Transaction;
import br.com.saolucas.financemanager.transactions.domain.TransactionType;
import br.com.saolucas.financemanager.transactions.validator.ValidTransactionType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransactionRequest {
	@NotNull
	@ValidTransactionType
	private String type;
	@NotBlank
	private String description;
	@NotNull
	@Positive
	private BigDecimal amount;
	@NotNull
	@Positive
	private String userId;
	
	public TransactionRequest() {
	}
	
	public String getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public Transaction toTransaction() {
		return new Transaction(TransactionType.valueOf(type.toUpperCase()), description, amount, userId);
	}
}
