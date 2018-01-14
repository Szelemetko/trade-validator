package pl.szelemetko.tradevalidator.validator.option;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.Option;
import pl.szelemetko.tradevalidator.model.OptionStyle;
import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.TradeType;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class OptionStyleValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		
		if (!trade.getType().equals(TradeType.OPTION)) {
			return result;
		}

		Option option = (Option) trade;
		for (OptionStyle style : OptionStyle.values()) {
			if (option.getStyle().equals(style.name())) {;
				return result;
			}
		}
		
		result.addError(FieldName.STYLE, ErrorMessage.INVALID_OPTION_STYLE);

		return result;
	}

}