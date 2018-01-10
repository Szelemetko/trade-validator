package pl.szelemetko.tradevalidator.validator;

import java.util.Currency;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;

@Component
public class ValidateCurrencyPair implements TradeValidator {

	private String message = "value date cannot fall on weekend or non-working day for currency";
	
	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {

		String currencyPair = trade.getCcyPair();
		if(currencyPair.length() != 6) {
			result.addError(FieldName.CURRENCY_PAIR, ErrorMessage.INVALID_CURRENCY_PAIR);
		} else {
			String baseCurrency = currencyPair.substring(0, 3);
			try {
				Currency.getInstance(baseCurrency);
			} catch(IllegalArgumentException e) {
				result.addError(FieldName.CURRENCY_PAIR, baseCurrency + ErrorMessage.INVALID_CURRENCY);
			}
			
			String quoteCurrency = currencyPair.substring(3,6);
			try {
				Currency.getInstance(quoteCurrency);
			} catch(IllegalArgumentException e) {
				result.addError(FieldName.CURRENCY_PAIR, quoteCurrency + ErrorMessage.INVALID_CURRENCY);
			}
			
		}
				
		return result;
	}

}
