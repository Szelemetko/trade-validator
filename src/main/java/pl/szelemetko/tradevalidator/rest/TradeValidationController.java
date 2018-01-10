package pl.szelemetko.tradevalidator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.service.TradeValidationService;

@RestController
public class TradeValidationController {

	@Autowired
	private TradeValidationService tradeValidationService;
		
	@PostMapping("/")
	public ValidationResult validate (@RequestBody Trade trade) {
		System.out.println(tradeValidationService);
		ValidationResult validationResult= new ValidationResult();
		tradeValidationService.validateTrade(trade, validationResult);
		return validationResult;
	}
}
