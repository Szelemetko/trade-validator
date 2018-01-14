package pl.szelemetko.tradevalidator.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames=true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true,
        defaultImpl = Trade.class)
@JsonSubTypes({
        @Type(value = Spot.class, name = TradeType.SPOT),
        @Type(value = Forward.class, name = TradeType.FORWARD),
        @Type(value = Option.class, name = TradeType.OPTION)
})
public class Trade {

	@NotNull
	private String customer;

	@NotNull
	private CurrencyPair ccyPair;

	@NotNull
	private String type;

	@NotNull
	private String direction;

	@NotNull
	private BigDecimal amount1;

	@NotNull
	private BigDecimal amount2;

	@NotNull
	private BigDecimal rate;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate tradeDate;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate valueDate;
	

	@NotNull
	private String legalEntity;

	@NotNull
	private String trader;

}
