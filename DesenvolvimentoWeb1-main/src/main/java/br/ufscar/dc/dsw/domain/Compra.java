package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Compra {

	private Long id;
	private Date data;
	private Float valor;
	private Usuario usuario;
	private Veiculo veiculo;

	public Compra(Long id) {
		this.id = id;
	}

	public Compra(Date data, Float valor, Usuario usuario, Veiculo veiculo) {
		super();
		this.data = data;
		this.valor = valor;
		this.usuario = usuario;
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setPacote(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}