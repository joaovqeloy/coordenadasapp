package com.eloy.selecao.coordenadasapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_ROUTE_PLAN")
public class RoutePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ROUTE_PLAN")
	private long idRoutePlan;

	@NotNull
	@Column(name = "NM_ROUTE_PLAN")
	private String descRoutePlan;

	@NotNull
	@Column(name = "NM_VEICULO_ID")
	private String veiculoId;
	
	@Column(name = "NR_PARADAS_ATENDIDAS")
	private int paradasAtendidas;

	@NotNull
	@Column(name = "FLG_ANDAMENTO")
	private String andamento;

	protected RoutePlan() {

	}

	public RoutePlan(long idRoutePlan, @NotNull String descRoutePlan, @NotNull String veiculoId,
			@NotNull String andamento) {
		super();
		this.idRoutePlan = idRoutePlan;
		this.descRoutePlan = descRoutePlan;
		this.veiculoId = veiculoId;
		this.andamento = andamento;
	}

	public long getIdRoutePlan() {
		return idRoutePlan;
	}

	public void setIdRoutePlan(long idRoutePlan) {
		this.idRoutePlan = idRoutePlan;
	}

	public String getDescRoutePlan() {
		return descRoutePlan;
	}

	public void setDescRoutePlan(String descRoutePlan) {
		this.descRoutePlan = descRoutePlan;
	}

	public String getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(String veiculoId) {
		this.veiculoId = veiculoId;
	}
	

	public String getAndamento() {
		return andamento;
	}

	public void setAndamento(String andamento) {
		this.andamento = andamento;
	}

	public int getParadasAtendidas() {
		return paradasAtendidas;
	}

	public void setParadasAtendidas(int paradasAtendidas) {
		this.paradasAtendidas = paradasAtendidas;
	}

	@Override
	public String toString() {
		return "RoutePlan [descRoutePlan=" + descRoutePlan + ", veiculoId=" + veiculoId + ", andamento=" + andamento
				+ "]";
	}



}
