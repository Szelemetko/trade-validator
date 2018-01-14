package pl.szelemetko.tradevalidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestMetric implements Comparable<RequestMetric>{

	private String type;
	private long time;
	
	
	
	@Override
	public int compareTo(RequestMetric rm) {
		return (int)(time - rm.time);
	}

	
}
