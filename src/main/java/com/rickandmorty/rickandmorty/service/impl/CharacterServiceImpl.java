package com.rickandmorty.rickandmorty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rickandmorty.rickandmorty.model.character.CharacterResult;
import com.rickandmorty.rickandmorty.model.character.Characters;
import com.rickandmorty.rickandmorty.service.CharacterService;

@Service
public class CharacterServiceImpl  implements CharacterService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String API_URL="https://rickandmortyapi.com/api/";

	@Override
	public Characters listCharacter(long page, String sortBy) {
	      
	        ResponseEntity<Characters> response = restTemplate.getForEntity(API_URL + "/character/" + ((page == 0) ? "" : "?page=" + page), Characters.class);
	        return response.getBody();		
	}

	@Override
	public CharacterResult getCharacter(int id) {
		   return restTemplate.getForObject(API_URL + "/character/" + id,
	                CharacterResult.class);
	}

}
