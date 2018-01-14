package pl.szelemetko.tradevalidator.validator.forward;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.TradeType;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class ForwardValueDateValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		if (trade.getType().equals(TradeType.FORWARD) &&
			trade.getTradeDate().plusDays(2).compareTo(trade.getValueDate()) > 1) {
			result.addError(FieldName.VALUE_DATE, ErrorMessage.INVALID_DATE_FOR_FORWARD_TRADE);
		}

		return result;
	}

	
}
