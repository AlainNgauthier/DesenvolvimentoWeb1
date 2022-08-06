package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Usuario {
	private Long id;
	private String email;
	private String senha;
	private String nome;
	private Date nascimento;
	private String sexo;
	private String cpf;
	private String cnpj;
	private String categoria;
	private String telefone;
	private String descricao;
	
	public Usuario(Long id) {
		this.id = id;
	}
	
	//ADMIN
	public Usuario(String email, String senha, String nome, String categoria) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public Usuario(Long id, String email, String senha, String nome, String categoria) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	//CLIENTE
	public Usuario(String email, String senha, String nome, Date nascimento, String sexo,  String cpf, String categoria, String telefone) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.categoria = categoria;
		this.telefone = telefone;
	}
	
	public Usuario(Long id, String email, String senha, String nome, Date nascimento, String sexo,  String cpf, String categoria, String telefone) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.categoria = categoria;
		this.telefone = telefone;
	}
	
	//LOJA
	public Usuario(String email, String senha, String nome, String cnpj, String categoria, String descricao) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.categoria = categoria;
		this.cnpj = cnpj;
		this.descricao = descricao;
	}
	
	public Usuario(Long id, String email, String senha, String nome, String cnpj, String categoria, String descricao) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.categoria = categoria;
		this.cnpj = cnpj;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascnascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}