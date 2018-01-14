package pl.szelemetko.tradevalidator.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.validator.TradeValidator;

@Service
public class TradeValidationService {

	@Autowired
	private List<TradeValidator> validators;

	
	public ValidationResult validateTrade(@Valid Trade trade, ValidationResult validationResult) {
				
		for(TradeValidator validator: validators) {
			validationResult = validator.validate(trade, validationResult);
		}
						
		return validationResult;
	}
	
	public List<ValidationResult> bulkValidateTrade(@Valid List<Trade> trades) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/validate").build().toUri();
		
		System.out.println(location);
		List<ValidationResult> bulkValidationResult = Collections.synchronizedList(new ArrayList<>());		
		
		trades.stream()
				.forEach( trade -> {
					ValidationResult validationResult = restTemplate.postForObject(location, trade, ValidationResult.class);
					validationResult.setTrade(trade);
					bulkValidationResult.add(validationResult);
				});
		
		return bulkValidationResult;
	}
	
	@Override
	public String toString() {
		return "TradeValidationService [" + (validators != null ? "validators=" + validators : "") + "]";
	}
	
	
	
	
}
