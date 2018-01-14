package pl.szelemetko.tradevalidator.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import pl.szelemetko.tradevalidator.model.Trade;
import pl.szelemetko.tradevalidator.model.ValidationResult;
import pl.szelemetko.tradevalidator.service.TradeValidationService;

@Slf4j
@RestController
@RequestMapping("/validate")
public class TradeValidationRest {

	@Autowired
	private TradeValidationService tradeValidationService;

	@PostMapping("")
	public ResponseEntity<?> validate(@Valid @RequestBody Trade trade, BindingResult result) {
		log.info("Single validation started: " + trade);		
		ValidationResult validationResult = new ValidationResult();
		
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				validationResult.addError(error.getField(), error.getDefaultMessage());
			}

			return ResponseEntity.ok().body(validationResult);
		}

		tradeValidationService.validateTrade(trade, validationResult);
		
		log.info("Single validaton finished: " + validationResult);
		
		return ResponseEntity.ok().body(validationResult);
	}

	@PostMapping("/bulk")
	public ResponseEntity<?> bulkValidate(@RequestBody @Valid List<Trade> trades, BindingResult result) {
		log.info("Bulk validation started: " + trades);
		
		
		List<ValidationResult> bulkValidationResult = tradeValidationService.bulkValidateTrade(trades);		
		
		log.info("Bulk validation finished: " + bulkValidationResult);
	
		return ResponseEntity.ok().body(bulkValidationResult);
	}
}
