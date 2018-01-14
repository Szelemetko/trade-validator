package pl.szelemetko.tradevalidator.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import pl.szelemetko.tradevalidator.model.RequestMetric;
import pl.szelemetko.tradevalidator.service.MetricsService;

@Aspect
@Component
public class MetricsAspect {

	@Autowired
	MetricsService metricsService;
	
	@Pointcut("execution(* pl.szelemetko.tradevalidator.rest.TradeValidationRest.validate(..))")
	private void forSingleValidation(){}
	
	@Around("forSingleValidation()")
	public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		Object result = joinPoint.proceed();
		stopwatch.stop();
		
		long time = stopwatch.getLastTaskTimeMillis();
		
		metricsService.addMetric(new RequestMetric("individual validation", time));
		
		return result;

	}
}
