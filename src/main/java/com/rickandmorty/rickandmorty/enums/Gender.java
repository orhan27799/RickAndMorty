package com.rickandmorty.rickandmorty.enums;

import com.google.gson.annotations.SerializedName;

public enum Gender {

	@SerializedName("unknown")
	UNKNOWN,

	@SerializedName("Female")
	FEMALE,

	@SerializedName("Male")
	MALE,

	@SerializedName("Genderless")
	GENDERLESS

}
