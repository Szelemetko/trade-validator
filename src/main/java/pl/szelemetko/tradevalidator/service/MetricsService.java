package pl.szelemetko.tradevalidator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;

import org.springframework.stereotype.Service;

import pl.szelemetko.tradevalidator.model.RequestMetric;
import pl.szelemetko.tradevalidator.model.RequestStatistics;

@Service
public class MetricsService {

	private List<RequestMetric> requests = new ArrayList<>();
	
	public RequestStatistics getStatistics() {
		RequestStatistics statistics = new RequestStatistics();
		statistics.setRequestsCount(getNumberOfRequest());
		statistics.setMinTime(getMinProcessingTime());
		statistics.setMaxTime(getMaxProcessingTime());
		statistics.setAverageTime(getAvgProcessingTime());
		statistics.setQuantile95Time(get95QuantileProcessingTime());
		return statistics;
	}
	
	public void addMetric(RequestMetric requestMetric) {
		requests.add(requestMetric);
	}
	
	public int getNumberOfRequest() {
		return requests.size();
	}
	
	public long getMinProcessingTime() {
		OptionalLong opt = requests.stream().mapToLong(request -> request.getTime()).min();
		return opt.orElseGet(() -> 0);
	}
	
	public long getMaxProcessingTime() {
		OptionalLong opt = requests.stream().mapToLong(request -> request.getTime()).max();
		return opt.orElseGet(() -> 0);
	}
	
	public double getAvgProcessingTime() {
		OptionalDouble opt = requests.stream().mapToLong(request -> request.getTime()).average();
		return opt.orElseGet(() -> 0);
	}
	
	public long get95QuantileProcessingTime() {
		
		if (requests.isEmpty()) {
			return 0;
		}
		
		LongSummaryStatistics statistics = requests.stream().mapToLong(request -> request.getTime()).summaryStatistics();
		int position = (int) Math.floor((statistics.getCount()) * 0.95);
		Collections.sort(requests);
		return requests.get(position).getTime();
		
	}
	
}
