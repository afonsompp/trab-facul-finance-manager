package br.com.saolucas.financemanager.transactions.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TransactionTypeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTransactionType {
	String message() default "The type of this record is invalid";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
