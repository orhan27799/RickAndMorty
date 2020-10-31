package com.rickandmorty.rickandmorty.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rickandmorty.rickandmorty.model.character.CharacterResult;
import com.rickandmorty.rickandmorty.model.character.Characters;
import com.rickandmorty.rickandmorty.model.episode.EpisodeResult;
import com.rickandmorty.rickandmorty.service.CharacterService;
import com.rickandmorty.rickandmorty.service.EpisodeService;
/**
 * 
 * @author orhan
 *
 */
@Controller
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	@Autowired
	private EpisodeService episodeService;
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value="/")
	public String getIndex() {
		
		return "characters";
	}
	
	
	/**
	 * 
	 * @param page pagination gelen parametre
	 * @param sortBy sıralama için gelen paramatre
	 * @return Karakterleri listesini dönderir
	 * 
	 *  O(1)+O(1)+....+ O(1)=O(1) 
	 */  
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public Characters listCharacter(@RequestParam(name="page",required=false,defaultValue="0") long page, @RequestParam(name="sortBy",required=false,defaultValue="") String sortBy) {
		
		  Characters character = characterService.listCharacter(page, sortBy);
		  
		  if (sortBy.equals("name")) {
              Comparator<CharacterResult> compareName = (CharacterResult r1, CharacterResult r2) -> r1.getName().compareTo(r2.getName());
              character.getResults().sort(compareName);
          } else if (sortBy.equals("episode")) {
              Comparator<CharacterResult> compareByEpisode = (CharacterResult r1, CharacterResult r2) -> (String.valueOf(r1.getEpisode().size())).compareTo(String.valueOf(r2.getEpisode().size()));
              character.getResults().sort(compareByEpisode);
          }
		  
		return character;
		
	}
	
	/**
	 * 
	 * @param id karakter id
	 * @return   CharacterResult türünde verir dönderir
	 * @throws URISyntaxException
	 * 
	 *  O(1)+O(1)+....+ O(n)=O(n) - Tüm Url'ler  üzerinde işlem yapıyor 1'den N' kadar 
	 */
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@ResponseBody
	public CharacterResult getCharacter(@RequestParam(name="id",required=true)  int  id) throws URISyntaxException {
		CharacterResult result=characterService.getCharacter(id);
		List<EpisodeResult> episodeResults=new ArrayList<EpisodeResult>();
		
		for (String eposideURL : result.getEpisode()) {
			URI uri = new URI(eposideURL);
			String path = uri.getPath();
			String idStr = path.substring(path.lastIndexOf('/') + 1);
			int epositeId = Integer.parseInt(idStr);
			EpisodeResult episodeResult=episodeService.getEpisode(epositeId);
			episodeResults.add(episodeResult);
		}
	    result.setEpisodeResults(episodeResults);
		return result;
		
	}

}
