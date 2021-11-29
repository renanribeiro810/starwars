package br.com.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwars.dto.ListaPlanetaDTO;
import br.com.starwars.entity.Planeta;
import br.com.starwars.service.PlanetaService;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {
	
	//LINK PARA UTILIZAR O SWAGGER 
	//http://localhost:8080/swagger-ui.html#/
	
	@Autowired
	PlanetaService planetaService;
	
	@GetMapping("lista-planeta-api")
	public List<ListaPlanetaDTO> list() throws Exception{
		return planetaService.getList();
	}
	
	@PostMapping("")
	public Planeta save(@RequestBody Planeta planeta) {
		return planetaService.save(planeta);
	}
	
	@GetMapping("/listar-planeta-banco")
		public List<Planeta> getAll(@RequestParam(required=false) Integer pagina, @RequestParam(required=false) Integer qtdRegistro){
			return planetaService.getAll(pagina, qtdRegistro);
		}
	
	@GetMapping("/find-name")
	public List<Planeta> getName(@RequestParam String nome){
		return planetaService.findByNome(nome);
	}
	
	@DeleteMapping("/delete/{idPlaneta}")
	public ResponseEntity<Void> delete(@PathVariable Integer idPlaneta){
		planetaService.delete(idPlaneta);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	

}
