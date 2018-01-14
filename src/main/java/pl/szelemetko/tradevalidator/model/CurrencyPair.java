package pl.szelemetko.tradevalidator.model;

import java.util.Currency;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CurrencyPair {

	private String code;
	
	@NotNull
	private Currency base;

	@NotNull
	private Currency quote;

	public CurrencyPair(String currencyPair) {
		this.code = currencyPair;
		this.base = findByCurrencyCode(currencyPair.substring(0, 3));
		this.quote = findByCurrencyCode(currencyPair.substring(3));
	}

	private Currency findByCurrencyCode(String currencyCode) {
		try {
			return Currency.getInstance(currencyCode);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	@JsonValue
	public String getCode() {
		return this.code;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		if (base != null) {
			result.append(base.getCurrencyCode());
		}

		if (quote != null) {
			result.append(quote.getCurrencyCode());
		}

		return result.toString();
	}
}
