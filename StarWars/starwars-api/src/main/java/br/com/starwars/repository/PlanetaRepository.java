package br.com.starwars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.starwars.entity.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Integer>{
	
	List<Planeta> findByClima(String clima);
	
	List<Planeta> findByNome(String nome);
	
	@Query(value="select * from planeta p where lower(p.nome) like lower(concat('%',:nome,'%')) ",nativeQuery= true)
	List<Planeta> procurarPorNome(String nome);

}
