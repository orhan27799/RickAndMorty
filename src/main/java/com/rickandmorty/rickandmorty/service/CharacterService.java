package com.rickandmorty.rickandmorty.service;

import com.rickandmorty.rickandmorty.model.character.CharacterResult;
import com.rickandmorty.rickandmorty.model.character.Characters;

public interface CharacterService {

	public Characters listCharacter(long page, String sortBy);

	public CharacterResult getCharacter(int id);

}
