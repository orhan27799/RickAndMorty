package com.rickandmorty.rickandmorty.model.episode;

import java.util.List;

import com.rickandmorty.rickandmorty.model.character.CharacterResult;

public class EpisodeResult {
	
	    private int id;
	    
	    private String name;
	    
	    private String airDate;
	    
	    private String episode;
	    
	    private List<String> characters = null;
	    
	    private List<CharacterResult> characterResults = null;
	    
	    private String url;
	    
	    private String created;
	    
	    private String season;
	    
	    private String seasonEpisode;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAirDate() {
			return airDate;
		}

		public void setAirDate(String airDate) {
			this.airDate = airDate;
		}

		public String getEpisode() {
			return episode;
		}

		public void setEpisode(String episode) {
			this.episode = episode;
		}

		public List<String> getCharacters() {
			return characters;
		}

		public void setCharacters(List<String> characters) {
			this.characters = characters;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getCreated() {
			return created;
		}

		public void setCreated(String created) {
			this.created = created;
		}

		public String getSeason() {
			return season;
		}

		public void setSeason(String season) {
			this.season = season;
		}

		public String getSeasonEpisode() {
			return seasonEpisode;
		}

		public void setSeasonEpisode(String seasonEpisode) {
			this.seasonEpisode = seasonEpisode;
		}

		public List<CharacterResult> getCharacterResults() {
			return characterResults;
		}

		public void setCharacterResults(List<CharacterResult> characterResults) {
			this.characterResults = characterResults;
		}
	    
	    

}
