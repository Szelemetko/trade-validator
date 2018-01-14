package pl.szelemetko.tradevalidator.validator;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;


public interface TradeValidator {

	public ValidationResult validate(Trade trade, ValidationResult result);
}
