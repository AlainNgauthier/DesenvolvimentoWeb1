package br.ufscar.dc.dsw.domain;

public class Veiculo {
	private Long id;
	private Usuario loja;
	private String placa;
	private String chassi;
	private String modelo;
	private String descricao;
	private Integer ano;
	private Float kilometragem;
	private Float valor;
	
	
	public Veiculo(Long id) {
		this.id = id;
	}
	
	public Veiculo(Usuario loja, String placa, String chassi, String modelo, String descricao, Integer ano, Float kilometragem, Float valor) {
		super();
		this.loja = loja;
		this.placa = placa;
		this.chassi = chassi;
		this.modelo = modelo;
		this.descricao = descricao;
		this.ano = ano;
		this.kilometragem = kilometragem;
		this.valor = valor;
	}
	
	public Veiculo(Long id, Usuario loja, String placa, String chassi, String modelo, String descricao, Integer ano, Float kilometragem, Float valor) {
		super();
		this.id = id;
		this.loja = loja;
		this.placa = placa;
		this.chassi = chassi;
		this.modelo = modelo;
		this.descricao = descricao;
		this.ano = ano;
		this.kilometragem = kilometragem;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Usuario getLoja() {
		return loja;
	}

	public void setLoja(Usuario loja) {
		this.loja = loja;
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
	
	
}