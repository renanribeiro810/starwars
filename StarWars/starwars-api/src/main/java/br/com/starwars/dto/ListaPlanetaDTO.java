package br.com.starwars.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaPlanetaDTO {
	
	private List<PlanetaDTO> results;

	public List<PlanetaDTO> getResults() {
		return results;
	}

	public void setResults(List<PlanetaDTO> results) {
		this.results = results;
	}
	
	

}
