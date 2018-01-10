package pl.szelemetko.tradevalidator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Service
public class TradeValidationService {

	@Autowired
	private List<TradeValidator> validators;

	
	public ValidationResult validateTrade(Trade trade, ValidationResult validationResult) {
		for(TradeValidator validator: validators) {
			validationResult = validator.validate(trade, validationResult);
		}
		return validationResult;
	}
	
	@Override
	public String toString() {
		return "TradeValidationService [" + (validators != null ? "validators=" + validators : "") + "]";
	}
	
	
}
