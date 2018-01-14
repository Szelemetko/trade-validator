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
public class OptionAmericanStyleValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {

		if (!trade.getType().equals(TradeType.OPTION)) {
			return result;
		}

		Option option = (Option) trade;

		if (option.getStyle().equals(OptionStyle.AMERICAN.name())) {

			if (option.getExerciseStartDate() == null) {

				result.addError(FieldName.EXERCISE_START_DATE, ErrorMessage.REQUIRED_FOR_AMERICAN_STYLE);

			} else {
				if (!option.getExerciseStartDate().isAfter(option.getTradeDate())
						|| !option.getExerciseStartDate().isBefore(option.getExpiryDate())) {

					result.addError(FieldName.EXERCISE_START_DATE,
							ErrorMessage.EXCECISE_START_DATE_BETWEEN_TRADE_AND_EXPIRY_DATE);

				}

			}
		}
		return result;

	}

}
