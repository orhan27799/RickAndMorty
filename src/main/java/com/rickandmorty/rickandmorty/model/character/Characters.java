package com.rickandmorty.rickandmorty.model.character;

import java.util.List;

public class Characters {
	

    private CharacterInfo info;

    private List<CharacterResult> results = null;

	public CharacterInfo getInfo() {
		return info;
	}

	public void setInfo(CharacterInfo info) {
		this.info = info;
	}

	public List<CharacterResult> getResults() {
		return results;
	}

	public void setResults(List<CharacterResult> results) {
		this.results = results;
	}
    
    

}
