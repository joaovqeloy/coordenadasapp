package com.eloy.selecao.coordenadasapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.eloy.selecao.coordenadasapp.repository.RoutePlanRepository;

@Controller
public class RoutePlanController {
	
	@Autowired
	RoutePlanRepository routePlanRepository;
	
	private String getLoggedInUserName() {
		Object principal = 
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();			
		}
		return principal.toString();
	}
	
	
	@GetMapping(path = "/lista-route-plan")
	public String showRoutePlan(ModelMap model) {
		model.put("routeplan", routePlanRepository.findByVeiculoId(getLoggedInUserName()));
		return "route-plan";
	}
}
