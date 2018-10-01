package ufpb.com.Poo.models;

public class TipoDeHospedagem {
	
	private String nome;
	private String site;
	private String infoContato;
	private String tipoDeHospedagem;
	private Endereco endereco;
	public static final String TIPO_HOTEL = "Hotel";
	public static final String TIPO_POUSADA = "Pousada";
	public static final String TIPO_ALBERGUE = "Albergue";
	public static final String TIPO_MOTEL = "Motel";
	public static final String TIPO_RESORT = "Resort";

	public TipoDeHospedagem(String nome, String site, String infoContato, String tipoDeHospedagem, Endereco endereco) {
		this.nome = nome;
		this.site = site;
		this.infoContato = infoContato;
		this.tipoDeHospedagem = tipoDeHospedagem;
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSite() {
		return this.site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getInfoContato() {
		return this.infoContato;
	}
	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}
	public String getTipoDeHospedagem() {
		return tipoDeHospedagem;
	}
	public void setTipoDeHospedagem(String tipoDeHospedagem) {
		this.tipoDeHospedagem = tipoDeHospedagem;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getDescricao() {
		return "Nome da hospedagem: " + getNome() + "\n" + "Site: " + getSite() + "\n" + "Contato: " + getInfoContato()
		+ "\n" + "Tipo " + getTipoDeHospedagem() ;
	}
}
