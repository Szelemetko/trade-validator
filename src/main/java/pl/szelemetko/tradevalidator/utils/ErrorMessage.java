package pl.szelemetko.tradevalidator.utils;

public class ErrorMessage {
	
	// COMMON
	public static final String VALUE_DATE_BEFORE_TRADE_DATE = "value date cannot be before trade date";
	public static final String INVALID_CURRENCY_PAIR = "invalid currency pair";
	public static final String INVALID_CURRENCY = "invalid currency";
	public static final String INVALID_CUSTOMER = "invalid customer";
	public static final String INVALID_LEGAL_ENTITY = "invalid legal entity";
	public static final String INVALID_TYPE = "invalid trade type";
	public static final String NOT_A_WORKING_DAY = "is not a working day for ";
		
	// SPOT 
	public static final String INVALID_DATE_FOR_SPOT_TRADE ="trade date should be two days before value date for Spot trade";
	
	// FORWARD
	public static final String INVALID_DATE_FOR_FORWARD_TRADE ="trade date should be more than two days before value date for Forward trade";
	
	// OPTION
	public static final String INVALID_OPTION_STYLE = "invalid style";
	public static final String REQUIRED_FOR_AMERICAN_STYLE = "is required for AMERICAN style option";
	public static final String EXCECISE_START_DATE_BETWEEN_TRADE_AND_EXPIRY_DATE = "has to be after the trade date but before the expiry date";
	public static final String REQUIRED_BEFORE_DELIVER_DATE = "must be before delivery date";
	
	
	
}
