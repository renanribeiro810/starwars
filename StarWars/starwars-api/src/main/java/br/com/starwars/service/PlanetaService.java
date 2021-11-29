package br.com.starwars.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.starwars.dto.ListaPlanetaDTO;
import br.com.starwars.entity.Planeta;
import br.com.starwars.repository.PlanetaRepository;

@Service
public class PlanetaService {
	

	
	@Autowired
	PlanetaRepository planetaRepository;
	
	
	public Planeta save(Planeta planeta) {
		return planetaRepository.save(planeta);
	}
	//https://swapi.dev/api/planets
	public List<ListaPlanetaDTO> getList() {
		RestTemplate rest = new RestTemplate();
		List<ListaPlanetaDTO> lista = new ArrayList<>();

		for (int i = 1; i <= 6; i++) {

			ResponseEntity<ListaPlanetaDTO> response =
			        rest.exchange("https://swapi.dev/api/planets/?page="+i,
			                    HttpMethod.GET, null, ListaPlanetaDTO.class);
			lista.add(response.getBody());
		}
		return lista;
	}
	
	public Planeta findById(Integer idPlaneta) {
		Optional<Planeta> p = planetaRepository.findById(idPlaneta);
		if(p != null) {
			return p.get();
		}
		return null;
	}
	
	public List<Planeta> getAll(Integer pagina, Integer qtdRegistro){
		Pageable page = null;
		List<Planeta> lista = new ArrayList<>();
			if(null != pagina && null != qtdRegistro) {
				page = PageRequest.of(pagina, qtdRegistro);
				Page<Planeta> listaPaginada = planetaRepository.findAll(page);
				lista = listaPaginada.getContent();
			return lista;
		}
			return planetaRepository.findAll();
	}
	
	public List<Planeta> findByNome(String nome) {
		return planetaRepository.procurarPorNome(nome);
	}
	
	public void delete(Integer idPlaneta) {
		Planeta planeta = findById(idPlaneta);
		planetaRepository.delete(planeta);
	}
	


}
