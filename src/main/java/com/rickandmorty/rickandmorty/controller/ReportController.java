package com.rickandmorty.rickandmorty.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rickandmorty.rickandmorty.model.report.EndPoints;
import com.rickandmorty.rickandmorty.model.report.Endpoint;
import com.rickandmorty.rickandmorty.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getIndex() {
		
		return "reports";
		
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public EndPoints getEndPoint() {
	
		Endpoint endpoint=reportService.getEndpoint("");
		List<Endpoint> endpoints=new ArrayList<Endpoint>();
		List<String> urlList=new ArrayList<String>();
 		for (String endPointUrl : endpoint.getAvailableTags().get(2).getValues()) {
			if(!endPointUrl.contains("actuator")) {
				Endpoint endpoint2=reportService.getEndpoint("?tag=uri:"+endPointUrl);
				endpoints.add(endpoint2);
				urlList.add(endPointUrl);
			}
			
		}
 		EndPoints points=new EndPoints();
 		points.setEndpoints(endpoints);
 		points.setUrlList(urlList);
		return points;
		
	}

}
