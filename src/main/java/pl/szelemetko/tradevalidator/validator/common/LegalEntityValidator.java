package pl.szelemetko.tradevalidator.validator.common;

import org.springframework.stereotype.Component;

import pl.szelemetko.tradevalidator.model.LegalEntity;
import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.utils.ErrorMessage;
import pl.szelemetko.tradevalidator.utils.FieldName;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Component
public class LegalEntityValidator implements TradeValidator {

	@Override
	public ValidationResult validate(Trade trade, ValidationResult result) {
		for(LegalEntity legalEntity: LegalEntity.values()) {
			if(legalEntity.getName().equals(trade.getLegalEntity())) {
				return result;
			}
		}
		
		result.addError(FieldName.LEGAL_ENTITY, ErrorMessage.INVALID_LEGAL_ENTITY);
		
		return result;
	}

}
