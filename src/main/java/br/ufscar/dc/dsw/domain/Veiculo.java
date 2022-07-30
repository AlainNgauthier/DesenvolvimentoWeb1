package br.ufscar.dc.dsw.domain;

public class Veiculo {
	private Long id;
	private String placa;
	private String chassi;
	private String modelo;
	private String descricao;
	private Integer ano;
	private Float kilometragem;
	private Float valor;
	private Usuario loja;
	
	public Veiculo(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public Float getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Float kilometragem) {
		this.kilometragem = kilometragem;
	}
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	public Usuario getAgencia() {
		return loja;
	}

	public void setAgencia(Usuario loja) {
		this.loja = loja;
	}
}