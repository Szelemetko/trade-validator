package pl.szelemetko.tradevalidator.validator.common;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Customer;
import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class CustomerValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		for(Customer customer: Customer.values()) {
			if(customer.name().equals(trade.getCustomer())) {
				return result;
			}
		}
		
		result.addError(FieldName.CUSTOMER, ErrorMessage.INVALID_CUSTOMER);
		
		return result;
	}

}
