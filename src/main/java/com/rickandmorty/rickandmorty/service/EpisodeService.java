package com.rickandmorty.rickandmorty.service;

import com.rickandmorty.rickandmorty.model.episode.Episode;
import com.rickandmorty.rickandmorty.model.episode.EpisodeResult;

public interface EpisodeService {
	
	public Episode listEpisode(long page, String sortBy);

	public EpisodeResult getEpisode(int id);

}
