package com.rickandmorty.rickandmorty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
class RickAndMortyApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}
	
	private String getRootUrl() {
		return "https://rickandmortyapi.com/api/character";
	}


	
	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() ,
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

}
