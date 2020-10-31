package com.rickandmorty.rickandmorty.enums;

import com.google.gson.annotations.SerializedName;

public enum Status {
	@SerializedName("unknown")
	UNKNOWN,

	@SerializedName("Alive")
	ALIVE,

	@SerializedName("Dead")
	DEAD

}
