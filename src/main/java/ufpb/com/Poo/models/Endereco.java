package ufpb.com.Poo.models;

public class Endereco {
    private String bairro;
	private String rua;
	private String numero;
	
	public Endereco( String bairro, String rua, String numero){
	    this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}
	public String getRua(){
		return this.rua;
	}
	public void setRua(String rua){
		this.rua = rua;
	}
	public String getNumero(){
		return this.numero;
	}
	public void setNumero(String numero){
		this.numero = numero;
	}
	public String getBairro(){
		return this.bairro;
	}
	public void setBairro(String bairro){
		this.bairro = bairro;
	}
}
