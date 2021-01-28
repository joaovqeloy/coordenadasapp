package com.eloy.selecao.coordenadasapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eloy.selecao.coordenadasapp.entity.PlannedStops;
import com.eloy.selecao.coordenadasapp.entity.RoutePlan;

@Repository
public interface PlannedStopsRepository extends CrudRepository<PlannedStops, Long>{
	List<PlannedStops> findByRoutePlan(String routePlan);
	
	@Query
	List<PlannedStops> findByRoutePlan_veiculoId(String veiculoId) ;
	
	List<PlannedStops> findByIdPlannedStop(long idPlannedStop);
	
	List<PlannedStops> findByRoutePlan(RoutePlan routePlan);
	
	PlannedStops findByDescription(String description);
}
