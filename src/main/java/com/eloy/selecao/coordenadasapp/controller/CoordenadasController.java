package com.eloy.selecao.coordenadasapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eloy.selecao.coordenadasapp.entity.Coordenadas;
import com.eloy.selecao.coordenadasapp.entity.PlannedStops;
import com.eloy.selecao.coordenadasapp.entity.RoutePlan;
import com.eloy.selecao.coordenadasapp.repository.CoordenadasRepository;
import com.eloy.selecao.coordenadasapp.repository.PlannedStopsRepository;
import com.eloy.selecao.coordenadasapp.repository.RoutePlanRepository;

@Controller
public class CoordenadasController {

	@Autowired
	CoordenadasRepository coordenadasRepository;

	@Autowired
	PlannedStopsRepository plannedStopsRepository;

	@Autowired
	RoutePlanRepository routePlanRepository;

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	private static Double toRad(Double value) {
		return value * Math.PI / 180;
	}

	public Double calcularDistancia(String cLat1, String cLat2, String pLat1, String pLat2) {

		final int R = 6371;
		Double lat1 = Double.parseDouble(cLat1);
		Double lon1 = Double.parseDouble(cLat2);
		Double lat2 = Double.parseDouble(pLat1);
		Double lon2 = Double.parseDouble(pLat2);
		Double latDistance = toRad(lat2 - lat1);
		Double lonDistance = toRad(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		Double distance = R * c;
		Double distanceInMeter = distance * 1000;

		return distanceInMeter;

	}

	private String smpDateFormatDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String formated = sdf.format(date);
		return formated;
	}

	@GetMapping(path = "/ReceiveCoordinate")
	public String showAddCoordenada(ModelMap model) {
		model.addAttribute("coordenadas", new Coordenadas(0, "-3.734652", "-38.469755",
				smpDateFormatDateToString(new Date()), getLoggedInUserName()));
		return "coordenada";
	}

	@PostMapping(path = "/ReceiveCoordinate")
	public String addCoordenada(ModelMap model, @Valid Coordenadas coordenada, BindingResult result) {
		List<PlannedStops> stop = plannedStopsRepository.findByRoutePlan_veiculoId(getLoggedInUserName());
		List<RoutePlan> rota = routePlanRepository.findByVeiculoId(getLoggedInUserName());
		Double distancia;

		if (result.hasErrors()) {
			return "coordenada";
		}
		// coordenada.setDiaHoraAtual(smpDateFormatDateToString(new Date()));
		coordenada.setVeiculoId(getLoggedInUserName());
		coordenadasRepository.save(coordenada);

		for (RoutePlan r : rota) {
			for (PlannedStops s : stop) {
				distancia = calcularDistancia(coordenada.getLat(), coordenada.getLng(), s.getLat(), s.getLng());
				if (distancia <= Double.parseDouble(s.getDeliveryRadius())) {
					s.setNumeroParadas(s.getNumeroParadas() + 1);
					plannedStopsRepository.save(s);
					if (s.getNumeroParadas() >= 3) {
						s.setAndamento("INICIADO");
						s.setTempoInicio(new Date());
						if (s.getRoutePlan().getDescRoutePlan() == r.getDescRoutePlan()) {
							r.setAndamento("EM PROGRESSO");
							routePlanRepository.save(r);
						}
						plannedStopsRepository.save(s);
					}
				} else if (s.getNumeroParadas() >= 3 && distancia >= Double.parseDouble(s.getDeliveryRadius())) {
					s.setAndamento("ENCERRADO");
					s.setTempoFinal(new Date());
					plannedStopsRepository.save(s);
					if (s.getRoutePlan().getDescRoutePlan() == r.getDescRoutePlan()) {
						r.setParadasAtendidas(r.getParadasAtendidas() + 1);
						routePlanRepository.save(r);
						if (r.getParadasAtendidas() >= 3) {
							r.setAndamento("CONCLUÍDA");
							routePlanRepository.save(r);
						}
					}

				}

			}
		}

		return "redirect:/lista-coordenadas";
	}

	@GetMapping(path = "/lista-coordenadas")
	public String showCoordenadas(ModelMap model) {
		model.put("coordenadas", coordenadasRepository.findByVeiculoId(getLoggedInUserName()));
		return "lista-coordenadas";
	}

}
