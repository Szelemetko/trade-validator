package pl.szelemetko.tradevalidator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName("error")
public class ValidationError {

	@JsonProperty("field")
	private String field;
	
	@JsonProperty("error")
	private String message;

	public ValidationError() {
		
	}
	
	public ValidationError(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Error [" + (field != null ? "field=" + field + ", " : "")
				+ (message != null ? "message=" + message : "") + "]";
	}
	
	
	
}
