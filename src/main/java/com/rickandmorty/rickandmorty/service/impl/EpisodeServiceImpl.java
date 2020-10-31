package com.rickandmorty.rickandmorty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rickandmorty.rickandmorty.model.episode.Episode;
import com.rickandmorty.rickandmorty.model.episode.EpisodeResult;
import com.rickandmorty.rickandmorty.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {
	

	@Autowired
	private RestTemplate restTemplate;
	
	private final String API_URL="https://rickandmortyapi.com/api/";
	

	@Override
	public Episode listEpisode(long page, String sortBy) {
	        
	        ResponseEntity<Episode> response = restTemplate.getForEntity(API_URL + "/episode/" + ((page == 0) ? "" : "?page=" + page), Episode.class);
	        return response.getBody();	
	}

	@Override
	public EpisodeResult getEpisode(int id) {
	        ResponseEntity<EpisodeResult> response = restTemplate.getForEntity(API_URL + "/episode/" + id, EpisodeResult.class);
	        return response.getBody();
	}

}
