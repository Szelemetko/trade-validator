package pl.szelemetko.tradevalidator.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public class Option extends Trade {
	
	@NotNull
	private String style;
	
	@NotNull
	private String strategy;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate deliveryDate;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	
	@NotNull
	private TradeCurrency payCcy;
	
	@NotNull
	private BigDecimal premium;
	
	@NotNull
	private TradeCurrency premiumCcy;
	
	@NotNull
	private String premiumType;
	
	@NotNull
	@JsonFormat( pattern = "yyyy-MM-dd")
	private LocalDate premiumDate;
	
	@JsonFormat( pattern = "yyyy-MM-dd")
	private LocalDate exerciseStartDate;
	
	
}
