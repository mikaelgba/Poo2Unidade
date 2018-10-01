package ufpb.com.Poo.models;

public abstract class AtrativoTuristico {
	
	private String nome;
	private String comoChegar;
	private String site;
	private String infoContato;
	private Endereco enderco;
	
	public AtrativoTuristico(String nome, String comoChegar, String site, String infoContato, Endereco endereco){
		this.nome = nome;
		this.comoChegar = comoChegar;
		this.site = site;
		this.infoContato = infoContato;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome( String nome ){
		this.nome = nome;
	}
	public String getComoChegar(){
		return this.comoChegar;
	}
	public void setComoChegar( String comoChegar ){
		this.comoChegar = comoChegar;
	}
	public String getSite(){
		return this.site;
	}
	public void setSite( String site ){
		this.site = site;
	}
	public String getInfoContato(){
		return this.infoContato;
	}
	public void setInfoContato( String infoContato ){
		this.infoContato = infoContato;
	}
	public String getDescricao() {
		return "Atrativo Tursitico de Nome: "+ getNome() + "\n" +" Acesso por "+getComoChegar() + "\n" +" Com Site "+ getSite() + "\n" +" Com contato "+getInfoContato();
	}
	public Endereco getEnderco() {
		return enderco;
	}
	public void setEnderco(Endereco enderco) {
		this.enderco = enderco;
	}

    void setLongetude(AtrativoTuristico SetAtrati) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}