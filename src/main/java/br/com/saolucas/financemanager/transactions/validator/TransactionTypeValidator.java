package br.com.saolucas.financemanager.transactions.validator;

import br.com.saolucas.financemanager.transactions.domain.TransactionType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransactionTypeValidator implements ConstraintValidator<ValidTransactionType, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		for (var type : TransactionType.values())
			if (value.equalsIgnoreCase(type.name()))
				return true;
		
		return false;
	}
}
