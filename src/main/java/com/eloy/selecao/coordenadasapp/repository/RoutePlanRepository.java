package com.eloy.selecao.coordenadasapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.eloy.selecao.coordenadasapp.entity.RoutePlan;

@Repository
public interface RoutePlanRepository extends CrudRepository<RoutePlan, Long>{

	List<RoutePlan> findByVeiculoId(String veiculoId);
}
