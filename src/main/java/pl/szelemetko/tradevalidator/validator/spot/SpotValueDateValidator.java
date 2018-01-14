package pl.szelemetko.tradevalidator.validator.spot;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.TradeType;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;


@Component
public class SpotValueDateValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		if (trade.getType().equals(TradeType.SPOT) &&
			!trade.getTradeDate().plusDays(2).equals(trade.getValueDate())) {
			result.addError(FieldName.VALUE_DATE, ErrorMessage.INVALID_DATE_FOR_SPOT_TRADE);
		}

		return result;
	}

}
