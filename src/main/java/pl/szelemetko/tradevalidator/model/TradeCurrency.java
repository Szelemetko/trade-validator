package pl.szelemetko.tradevalidator.model;

import java.util.Currency;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
public class TradeCurrency {

	
	private String code;
	
	private Currency currency;

	public TradeCurrency() {
		
	}
	
	public TradeCurrency(String currency) {
		this.code = currency;
		try {
			this.currency = Currency.getInstance(currency);
		} catch (IllegalArgumentException e) {
			this.currency = null;
		}
	}
	
	public void setCurrency(String currency) {
		try {
			this.currency = Currency.getInstance(currency);
		} catch (IllegalArgumentException e) {
			this.currency = null;
		}
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@JsonValue
	public String getCode() {
		return code;
	}
}
