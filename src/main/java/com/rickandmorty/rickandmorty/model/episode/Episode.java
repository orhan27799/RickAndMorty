package com.rickandmorty.rickandmorty.model.episode;

import java.util.List;

public class Episode {
	

    private EpisodeInfo info;

    private List<EpisodeResult> results = null;

	public EpisodeInfo getInfo() {
		return info;
	}

	public void setInfo(EpisodeInfo info) {
		this.info = info;
	}

	public List<EpisodeResult> getResults() {
		return results;
	}

	public void setResults(List<EpisodeResult> results) {
		this.results = results;
	}
    
    

}
