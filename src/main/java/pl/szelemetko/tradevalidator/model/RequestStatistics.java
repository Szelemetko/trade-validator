package pl.szelemetko.tradevalidator.model;

import lombok.Data;

@Data
public class RequestStatistics {

	private int requestsCount;
	private long minTime;
	private long maxTime;
	private double averageTime;
	private long quantile95Time;
}
