package com.rickandmorty.rickandmorty.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rickandmorty.rickandmorty.model.character.CharacterResult;
import com.rickandmorty.rickandmorty.model.episode.Episode;
import com.rickandmorty.rickandmorty.model.episode.EpisodeResult;
import com.rickandmorty.rickandmorty.service.CharacterService;
import com.rickandmorty.rickandmorty.service.EpisodeService;

@Controller
@RequestMapping("/episode")
public class EpisodeController {
	
	@Autowired
	private EpisodeService  episodeService;
	
	@Autowired
	private CharacterService characterService;
	
	

	@RequestMapping(value="/")
	public String getIndex() {
		
		return "episodes";
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public Episode listEpisode(Model model,@RequestParam(name="page",required=false,defaultValue="0") long page, @RequestParam(name="sortBy",required=false,defaultValue="") String sortBy) {
		
		  Episode episode = episodeService.listEpisode(page, sortBy);
		  
		  if (sortBy.equals("name")) {
              Comparator<EpisodeResult> compareName = (EpisodeResult r1, EpisodeResult r2) -> r1.getName().compareTo(r2.getName());
              episode.getResults().sort(compareName);
          } else if (sortBy.equals("characters")) {
              Comparator<EpisodeResult> compareByEpisode = (EpisodeResult r1, EpisodeResult r2) -> (String.valueOf(r1.getCharacters().size())).compareTo(String.valueOf(r2.getCharacters().size()));
              episode.getResults().sort(compareByEpisode);
          }
		  
		return episode;
		
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@ResponseBody
	public EpisodeResult getEpisode(@RequestParam(name="id",required=true)  int  id,Model model) throws URISyntaxException {
		EpisodeResult result=episodeService.getEpisode(id);
		List<CharacterResult> characterResults=new ArrayList<CharacterResult>();
		for (String chacracterURL : result.getCharacters()) {
			URI uri = new URI(chacracterURL);
			String path = uri.getPath();
			String idStr = path.substring(path.lastIndexOf('/') + 1);
			int characterId = Integer.parseInt(idStr);
			CharacterResult characterResult=characterService.getCharacter(characterId);
			characterResults.add(characterResult);
			
		}
		result.setCharacterResults(characterResults);
		return result;
		
	}


}
