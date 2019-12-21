package com.giof71.monitoring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.giof71.monitoring.dto.structure.decorated.concrete.HostList;

@RestController
public class ConsumeWebService {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/hosts")
	public HostList list() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(
			"http://localhost:8079/host-management/hosts/", 
			HttpMethod.GET, 
			entity, 
			HostList.class).getBody();
	}

	@RequestMapping(value = "/count")
	public Long getCount() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(
			"http://localhost:8079/host-management/count", 
			HttpMethod.GET, 
			entity, 
			Long.class).getBody();
	}
}