package br.ufscar.dc.dsw.domain;

public class Cliente {

	private Long id;
	private String email;
	private String senha;
	private String CPF;
	private String nome;
	private String telefone;
	private String sexo;
	private String nascimento;
	private String papel;

	public Cliente (Long id) {
		this.id = id;
	}
	public Cliente(String email, String senha, String CPF, String nome, String telefone, String sexo, String nascimento, String papel) {
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.papel = papel;
	}

	public Cliente(Long id,String email, String senha, String CPF, String nome, String telefone, String sexo, String nascimento, String papel) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.papel = papel;
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

	public void setSenha(String password) {
		this.senha = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo= sexo;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}
