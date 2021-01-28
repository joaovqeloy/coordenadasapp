package com.eloy.selecao.coordenadasapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.eloy.selecao.coordenadasapp.repository.CoordenadasRepository;
import com.eloy.selecao.coordenadasapp.repository.PlannedStopsRepository;
import com.eloy.selecao.coordenadasapp.repository.RoutePlanRepository;

@Controller
public class PlannedStopsController {

	@Autowired
	CoordenadasRepository coordenadasRepository;

	@Autowired
	PlannedStopsRepository plannedStopsRepository;

	@Autowired
	RoutePlanRepository routePlanRepository;

	@GetMapping(path = "/planned-stops")
	public String showPlannedStops(ModelMap model) {
		String name = getLoggedInUserName();
		model.put("plannedstops", plannedStopsRepository.findByRoutePlan_veiculoId(name));
		
		return "planned-stops";
	}



	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

}
