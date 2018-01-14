package pl.szelemetko.tradevalidator.validator.common;

import java.time.LocalDate;
import java.util.Currency;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pl.szelemetko.tradevalidator.model.CurrencyPair;
import pl.szelemetko.tradevalidator.model.FixerResponse;
import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class ValueDayNotOnCurrencyWorkingDayValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		CurrencyPair ccyPair = trade.getCcyPair();

		if (ccyPair.getBase() != null && ccyPair.getQuote() != null) {

			LocalDate valueDate = trade.getValueDate();
			
			try {
				if (!isWorkingDayForCurrency(valueDate, ccyPair.getBase())) {
					result.addError(FieldName.VALUE_DATE,
							valueDate + ErrorMessage.NOT_A_WORKING_DAY + ccyPair.getBase());
				}

				if (!isWorkingDayForCurrency(valueDate, ccyPair.getQuote())) {
					result.addError(FieldName.VALUE_DATE,
							valueDate + ErrorMessage.NOT_A_WORKING_DAY + ccyPair.getBase());
				}
			} catch (Exception e) {
				
				// should return a 500 in this case but skipped due to limited time for assignment
				
				result.addError(FieldName.VALUE_DATE,
						"Unable to check if value date is working day for currencies.");
			}

		}

		return result;

	}

	private boolean isWorkingDayForCurrency(LocalDate date, Currency currency) {
		RestTemplate restTemplate = new RestTemplate();
		FixerResponse response = restTemplate
				.getForObject("https://api.fixer.io/" + date + "?base=" + currency, FixerResponse.class);
		if (!response.getDate().equals(date)) {
			return false;
		}
		return true;

	}

}
