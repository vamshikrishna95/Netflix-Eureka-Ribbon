package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ControllerClass {

	RestTemplate restTemplate;

	/*@Autowired
	DiscoveryClient discoverClient;*/
	
	@Autowired
	LoadBalancerClient loadBalancerClient;

	@RequestMapping("test")
	public String test() throws RestClientException, IOException {
		restTemplate=new RestTemplate();
		ResponseEntity<String> str1 = null;
		//List<ServiceInstance> list=discoverClient.getInstances("EMPLOYEE-PRODUCER");
		//ServiceInstance set=list.get(0);
		ServiceInstance set=loadBalancerClient.choose("employee-producer");
		String str=set.getUri().toString();
		str=str+"/test";
		try {
			 str1 = restTemplate.exchange(str, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return str1.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
}
