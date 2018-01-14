package pl.szelemetko.tradevalidator.validator.common;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.TradeType;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class TradeTypeValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		for(String tradeType: TradeType.values()) {
			if(tradeType.equals(trade.getType())) {
				return result;
			}
		}
		
		result.addError(FieldName.TYPE, ErrorMessage.INVALID_TYPE);
		
		return result;
	}


}
