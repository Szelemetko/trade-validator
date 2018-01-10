package pl.szelemetko.tradevalidator.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(Include.NON_NULL)	
public class Trade {

	@JsonProperty("customer")
	private String customer;

	@JsonProperty("ccyPair")
	private String ccyPair;

	@JsonProperty("type")
	private String type;

	@JsonProperty("direction")
	private String direction;

	@JsonProperty("tradeDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date tradeDate;

	@JsonProperty("amount1")
	private BigDecimal amount1;

	@JsonProperty("amount2")
	private BigDecimal amount2;

	@JsonProperty("rate")
	private BigDecimal rate;

	@JsonProperty("valueDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date valueDate;

	@JsonProperty("legalEntity")
	private String legalEntity;

	@JsonProperty("trader")
	private String trader;
	
	@JsonProperty("style")
	private String style;
	
	@JsonProperty("strategy")
	private String strategy;
	
	@JsonProperty("deliveryDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	
	@JsonProperty("expiryDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expiryDate;
	
	@JsonProperty("payCcy")
	private Currency payCcy;
	
	@JsonProperty("premium")
	private BigDecimal premium;
	
	@JsonProperty("premiumCcy")
	private Currency premiumCcy;
	
	@JsonProperty("premiumType")
	private String premiumType;
	
	@JsonProperty("premiumDate")
	@JsonFormat( pattern = "yyyy-MM-dd")
	private Date premiumDate;

	public Trade () {
		
	}
	
	public Trade(String customer, String ccyPair, String type, String direction, Date tradeDate, BigDecimal amount1,
			BigDecimal amount2, BigDecimal rate, Date valueDate, String legalEntity, String trader, String style,
			String strategy, Date deliveryDate, Date expiryDate, Currency payCcy, BigDecimal premium,
			Currency premiumCcy, String premiumType, Date premiumDate) {
		this.customer = customer;
		this.ccyPair = ccyPair;
		this.type = type;
		this.direction = direction;
		this.tradeDate = tradeDate;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.rate = rate;
		this.valueDate = valueDate;
		this.legalEntity = legalEntity;
		this.trader = trader;
		this.style = style;
		this.strategy = strategy;
		this.deliveryDate = deliveryDate;
		this.expiryDate = expiryDate;
		this.payCcy = payCcy;
		this.premium = premium;
		this.premiumCcy = premiumCcy;
		this.premiumType = premiumType;
		this.premiumDate = premiumDate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCcyPair() {
		return ccyPair;
	}

	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public BigDecimal getAmount2() {
		return amount2;
	}

	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Currency getPayCcy() {
		return payCcy;
	}

	public void setPayCcy(Currency payCcy) {
		this.payCcy = payCcy;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public Currency getPremiumCcy() {
		return premiumCcy;
	}

	public void setPremiumCcy(Currency premiumCcy) {
		this.premiumCcy = premiumCcy;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public Date getPremiumDate() {
		return premiumDate;
	}

	public void setPremiumDate(Date premiumDate) {
		this.premiumDate = premiumDate;
	}

	@Override
	public String toString() {
		return "Trade [" + (customer != null ? "customer=" + customer + ", " : "")
				+ (ccyPair != null ? "ccyPair=" + ccyPair + ", " : "") + (type != null ? "type=" + type + ", " : "")
				+ (direction != null ? "direction=" + direction + ", " : "")
				+ (tradeDate != null ? "tradeDate=" + tradeDate + ", " : "")
				+ (amount1 != null ? "amount1=" + amount1 + ", " : "")
				+ (amount2 != null ? "amount2=" + amount2 + ", " : "") + (rate != null ? "rate=" + rate + ", " : "")
				+ (valueDate != null ? "valueDate=" + valueDate + ", " : "")
				+ (legalEntity != null ? "legalEntity=" + legalEntity + ", " : "")
				+ (trader != null ? "trader=" + trader + ", " : "") + (style != null ? "style=" + style + ", " : "")
				+ (strategy != null ? "strategy=" + strategy + ", " : "")
				+ (deliveryDate != null ? "deliveryDate=" + deliveryDate + ", " : "")
				+ (expiryDate != null ? "expiryDate=" + expiryDate + ", " : "")
				+ (payCcy != null ? "payCcy=" + payCcy + ", " : "")
				+ (premium != null ? "premium=" + premium + ", " : "")
				+ (premiumCcy != null ? "premiumCcy=" + premiumCcy + ", " : "")
				+ (premiumType != null ? "premiumType=" + premiumType + ", " : "")
				+ (premiumDate != null ? "premiumDate=" + premiumDate : "") + "]";
	}
	
	

	

}
