package com.rickandmorty.rickandmorty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rickandmorty.rickandmorty.model.report.Endpoint;
import com.rickandmorty.rickandmorty.service.ReportService;

@Service
public class ReportServiceImpl  implements ReportService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String metricUrl="http://localhost:8080/actuator/metrics/http.server.requests";
	
	@Override
	public Endpoint getEndpoint(String uri) {
	        ResponseEntity<Endpoint> response = restTemplate.getForEntity(metricUrl + uri, Endpoint.class);
	        return response.getBody();
	}

}
