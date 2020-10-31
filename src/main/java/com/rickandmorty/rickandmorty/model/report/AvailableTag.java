package com.rickandmorty.rickandmorty.model.report;

import java.util.List;

public class AvailableTag {
	

    private String tag;
    
    private List<String> values = null;
    
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
    
    

}
