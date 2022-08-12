package br.ufscar.dc.dsw.domain;

public class Proposta {

	private Long id;
	private String data_p;
	private Float valor;
	private Veiculo veiculo;
	private Cliente cliente;
	private Loja loja;
	private String estado;
	private int parcelamento;

	public Proposta (Long id,String estado, String data_p, Float valor, int parcelamento, Veiculo veiculo, Cliente cliente, Loja loja) {
		this.id = id;
		this.estado = estado;
		this.data_p = data_p;
		this.valor = valor;
		this.parcelamento = parcelamento;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.loja = loja;
	}
	
	public Proposta (String estado, String data_p, Float valor, int parcelamento, Veiculo veiculo, Cliente cliente, Loja loja) {
		this.estado = estado;
		this.data_p = data_p;
		this.valor = valor;
		this.parcelamento = parcelamento;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.loja = loja;
	}
	public Proposta (Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getData() {
		return data_p;
	}

	public void setData(String data_p) {
		this.data_p = data_p;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public int getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(int parcelamento) {
		this.parcelamento = parcelamento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}	
}