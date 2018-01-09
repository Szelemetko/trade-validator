package pl.szelemetko.tradevalidator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeValidationController {

	@GetMapping("/")
	public String validate () {
		return null;
	}
}
