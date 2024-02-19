package hu.pangalo.rest.webservice.controller;


import hu.pangalo.rest.webservice.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

	private static final Logger logger = LoggerFactory.getLogger(RestController.class);

	@Autowired
	CounterService counterService;

	@GetMapping
	public ResponseEntity<String> helloWorld() {
		Integer counter = counterService.incrementCounter();
		logger.info("counter: " + counter);
		return ResponseEntity.ok("Hello World! in-memory counter: " + counter);
	}

	@GetMapping(path = "/latened-response")
	public ResponseEntity<String> latenedResponse() throws InterruptedException {
		Integer latency = counterService.getLatencyInSeconds();
		logger.info("entered latened reponse, latency in seconds: " + latency);
		Thread.sleep(latency.intValue() * 1000);
		logger.info("latened reponse calling finished");
		return ResponseEntity.ok("latened reponse calling finished");
	}

	@PostMapping(path = "/latency/{latency}")
	public ResponseEntity<String> setLatency(@PathVariable Integer latency) {
		counterService.setLatencyInSeconds(latency);
		logger.info("latency set to " + latency + " seconds!");
		return ResponseEntity.ok("latency set to " + latency + " seconds!");
	}
}
