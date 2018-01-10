package pl.szelemetko.tradevalidator.validator;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationError;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;

@Component
public class ValueDateBeforeTradeDateValidator implements TradeValidator {

	private String field = "valueDate=";
	
	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		if (trade.getValueDate() != null &&
			trade.getTradeDate() != null &&	
			trade.getValueDate().compareTo(trade.getTradeDate()) < 0
			) {
			result.addError(FieldName.VALUE_DATE, ErrorMessage.VALUE_DATE_BEFORE_TRADE_DATE);
		}
		return result;
	}

	public ValueDateBeforeTradeDateValidator() {
		
	}
}
