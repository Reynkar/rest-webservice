package hu.pangalo.rest.webservice.service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

	private Integer counter = 0;

	private Integer latencyInSeconds = 0;

	public Integer incrementCounter() {
		return ++counter;
	}

	public Integer getLatencyInSeconds() {
		return latencyInSeconds;
	}

	public void setLatencyInSeconds(Integer latencyInSeconds) {
		this.latencyInSeconds = latencyInSeconds;
	}
}
