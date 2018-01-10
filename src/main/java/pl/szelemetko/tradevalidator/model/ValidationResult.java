package pl.szelemetko.tradevalidator.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationResult {

	@JsonProperty("errors")
	private List<ValidationError> errors;
	
	public void addError(ValidationError error) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(error);
	}
	
	public void addError(String field, String message) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(new ValidationError(field,message));
	}
	
}
