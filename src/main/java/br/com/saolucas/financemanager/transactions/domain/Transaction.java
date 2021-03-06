package br.com.saolucas.financemanager.transactions.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private BigDecimal amount;
	@Column(nullable = false)
	private String userId;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public Transaction(String type, String description, BigDecimal amount, String userId) {
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.userId = userId;
	}
	
	public Transaction() {
	}
	
	public Long getId() {
		return id;
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
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
