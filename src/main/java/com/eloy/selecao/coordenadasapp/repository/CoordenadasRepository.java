package com.eloy.selecao.coordenadasapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eloy.selecao.coordenadasapp.entity.Coordenadas;

@Repository
public interface CoordenadasRepository extends CrudRepository<Coordenadas, Long> {
	
	List<Coordenadas> findByVeiculoId(String veiculoId);
	List<Coordenadas> findByIdCord(long idCord);
}
