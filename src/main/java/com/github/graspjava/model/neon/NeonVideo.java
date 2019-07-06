package com.github.graspjava.model.neon;

public class NeonVideo {
	
	private String description;
	
	private String url;

	public NeonVideo(String description, String url) {
		super();
		this.description = description;
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "NeonVideo [description=" + description + ", url=" + url + "]";
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
