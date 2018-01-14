package pl.szelemetko.tradevalidator.validator.common;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class ValueDateBeforeTradeDateValidator implements TradeValidator {
	
	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		if (trade.getValueDate().compareTo(trade.getTradeDate()) < 0) {
			result.addError(FieldName.VALUE_DATE, ErrorMessage.VALUE_DATE_BEFORE_TRADE_DATE);
		}
		
		return result;
	}

}
