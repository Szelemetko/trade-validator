package pl.szelemetko.tradevalidator.validator.common;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.CurrencyPair;
import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class CurrencyPairValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {

		CurrencyPair currencyPair = trade.getCcyPair();
		if(currencyPair.getBase() == null || currencyPair.getQuote() == null) {
			result.addError(FieldName.CURRENCY_PAIR, ErrorMessage.INVALID_CURRENCY_PAIR);
		} 
				
		return result;
	}

}
