package com.eloy.selecao.coordenadasapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PLANNED_STOPS")
public class PlannedStops {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PLANNED_STOP")
	private long idPlannedStop;

	@NotNull
	@Column(name = "LAT")
	private String lat;

	@NotNull
	@Column(name = "LNG")
	private String lng;

	@NotNull
	@Column(name = "DS_DESCRIPTION")
	private String description;

	@NotNull
	@Column(name = "VLR_DELIVERY_RADIUS")
	private String deliveryRadius;

	@NotNull
	@Column(name = "FLG_ANDAMENTO")
	private String andamento;
	
	@Column(name= "NR_PARADAS")
	private int numeroParadas;
	
	@Column(name = "DT_FINAL")
	private Date tempoFinal;
	
	@Column(name = "DT_INICIO")
	private Date tempoInicio;

	@JoinColumn(name = "FK_ROUTE_PLAN", referencedColumnName = "ID_ROUTE_PLAN")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private RoutePlan routePlan;

	protected PlannedStops() {
		
	}
	
	public PlannedStops(long idPlannedStop, @NotNull String lat, @NotNull String lng, @NotNull String description,
			@NotNull String deliveryRadius, @NotNull String andamento) {
		super();
		this.idPlannedStop = idPlannedStop;
		this.lat = lat;
		this.lng = lng;
		this.description = description;
		this.deliveryRadius = deliveryRadius;
		this.andamento = andamento;
	}
	
	public long getIdPlannedStop() {
		return idPlannedStop;
	}

	public void setIdPlannedStop(long idPlannedStop) {
		this.idPlannedStop = idPlannedStop;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeliveryRadius() {
		return deliveryRadius;
	}

	public void setDeliveryRadius(String deliveryRadius) {
		this.deliveryRadius = deliveryRadius;
	}

	public String getAndamento() {
		return andamento;
	}

	public void setAndamento(String andamento) {
		this.andamento = andamento;
	}

	public RoutePlan getRoutePlan() {
		return routePlan;
	}

	public void setRoutePlan(RoutePlan routePlan) {
		this.routePlan = routePlan;
	}

	public int getNumeroParadas() {
		return numeroParadas;
	}

	public void setNumeroParadas(int numeroParadas) {
		this.numeroParadas = numeroParadas;
	}

	public Date getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(Date tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	public Date getTempoInicio() {
		return tempoInicio;
	}

	public void setTempoInicio(Date tempoInicio) {
		this.tempoInicio = tempoInicio;
	}

	@Override
	public String toString() {
		return "PlannedStops [lat=" + lat + ", lng=" + lng + ", description=" + description + ", deliveryRadius="
				+ deliveryRadius + ", andamento=" + andamento + "]";
	}
	




}
