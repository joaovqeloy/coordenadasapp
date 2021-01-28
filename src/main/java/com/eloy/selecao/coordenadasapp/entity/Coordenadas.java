package com.eloy.selecao.coordenadasapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_COORDENADAS")
public class Coordenadas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COORDENADAS")
	private long idCord;
	
	@NotNull
	@Column(name = "LAT")
	private String lat;
	
	@NotNull
	@Column(name = "LNG")
	private String lng;
	
	@NotNull
	@Column(name = "DT_DIA_HORA_ATUAL")
	private String diaHoraAtual;
	
	@NotNull
	@Column(name = "NM_VEICULO_ID")
	private String veiculoId;
	
	protected Coordenadas() {
		
	}

	public Coordenadas(long idCord, String lat, String lng, String diaHoraAtual, String veiculoId) {
		super();
		this.idCord = idCord;
		this.lat = lat;
		this.lng = lng;
		this.diaHoraAtual = diaHoraAtual;
		this.veiculoId = veiculoId;
	}

	public long getIdCord() {
		return idCord;
	}

	public void setIdCord(long idCord) {
		this.idCord = idCord;
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

	public String getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(String veiculoId) {
		this.veiculoId = veiculoId;
	}

	public String getDiaHoraAtual() {
		return diaHoraAtual;
	}

	public void setDiaHoraAtual(String diaHoraAtual) {
		this.diaHoraAtual = diaHoraAtual;
	}

	@Override
	public String toString() {
		return "Coordenadas [lat=" + lat + ", lng=" + lng + ", diaHoraAtual=" + diaHoraAtual + ", veiculoId="
				+ veiculoId + "]";
	}

}
