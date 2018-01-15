package pl.szelemetko.tradevalidator.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@JsonInclude(value=Include.NON_EMPTY)
@Data
@ToString
public class ValidationResult {
	@JsonProperty("trade")
	Trade trade;
	
	@JsonProperty("valid")
	private boolean valid;
	
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
	
	public ValidationResult() {
		this.errors = new ArrayList<>();
	}
	
	public boolean isValid() {
		return errors.isEmpty();
	}
	
	public boolean getValid() {
		return errors.isEmpty();
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
