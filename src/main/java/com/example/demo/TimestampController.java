package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TimestampController {

	@Value("${backend-url}")
	String backend_url;
	
	@GetMapping("/{date}")
	public Object getCurrentTime(@PathVariable String date) {
		RestTemplate restTemplate=new RestTemplate();
		String url=backend_url+date;
		return restTemplate.getForObject(url, Object.class);	
	}
	
	@GetMapping("/")
	public Object getCurrentTimeEmpty() {
		RestTemplate restTemplate=new RestTemplate();
		String url=backend_url;
		return restTemplate.getForObject(url, Object.class);	
	}
	
}
