package pl.szelemetko.tradevalidator.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class FixerResponse {

	private String base;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	//private Map<String,String> rates;
}
