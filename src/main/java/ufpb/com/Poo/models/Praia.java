package ufpb.com.Poo.models;

public class Praia extends AtrativoTuristico{
	
	private boolean periTuba;
	private boolean propBanho;
	private String tipoOrla;
	public static final String TIPO_MAR_ABERTO = "Mar Aberto";
	public static final String TIPO_PEQUENAS_ONDAS = "Pequenas Ondas";
	public static final String TIPO_MAR_ABRIGADO = "Mar Abrigado";
	public static final String TIPO_ONDAS_MEDIAS = "Ondas Medias";
	public static final String TIPO_PISCINAS_NATURAIS = "Piscinas Naturais";
	public static final String TIPO_ONDAS_FORTES = "Ondas Forte";
	
	public Praia(String nome, String comoChegar, String site, 
			String infoContato, boolean periTuba, boolean propBanho, String tipoOrla, Endereco endereco ) {
		super(nome, comoChegar, site, infoContato, endereco);
		this.periTuba = false;
		this.propBanho = false;
		this.tipoOrla = "";	
	}
	public String getDescricao() {
		return "Praia de nome "+super.getNome() + "\n" + "Com acesso " + super.getComoChegar() 
		+ "\n" + " Site " + super.getSite()+ "\n" + "Contato " + super.getInfoContato() 
		+ "\n"+ "Com perigo de apari��o de Tubar�o " + getPeriTuba() + "\n" + " Propria para banho " + getPropBanho() + "\n" + "Tipo " + getTipoOrla();
	}
	public String getTipoOrla() {
		return this.tipoOrla;
	}
	public void setTipoOrla( String tipoOrla ) {
		this.tipoOrla = tipoOrla;
	}
	public boolean getPropBanho(){
		return this.propBanho;
	}
	public void setPropriaParaBanho( boolean propBanho ) {
		this.propBanho = propBanho;
	}
	public boolean getPeriTuba() {
		return this.periTuba;
	}
	public void setPeriTuba( boolean periTuba ) {
		this.periTuba = periTuba;
	}
}



