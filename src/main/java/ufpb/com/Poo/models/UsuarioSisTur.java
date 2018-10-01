package ufpb.com.Poo.models;

public class UsuarioSisTur {

	private String nome;
	private String cpf;
	private String Rg;
	private String numero;

	public UsuarioSisTur(String nome, String cpf, String rg, String numero) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.Rg = rg;
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return Rg;
	}
	public void setRg(String rg) {
		Rg = rg;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
