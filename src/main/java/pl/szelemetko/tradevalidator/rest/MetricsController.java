package pl.szelemetko.tradevalidator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.szelemetko.tradevalidator.model.RequestStatistics;
import pl.szelemetko.tradevalidator.service.MetricsService;

@RestController
public class MetricsController {

	@Autowired
	MetricsService metricsService;	
	
	@GetMapping("/validation/metrics")
	public RequestStatistics getMetrics() {
		return metricsService.getStatistics();
	}
}
