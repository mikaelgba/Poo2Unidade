package ufpb.com.Poo.models;

public class Restaurante{
	
    private String nome;
    private String site;
    private String infoContato;
    private Endereco endereco;
    private String classificacao;
    public static final String TIPO_UMA = "*";
    public static final String TIPO_DUAS = "**";
    public static final String TIPO_TRES = "***";
    public static final String TIPO_QUATRO = "****";
    public static final String TIPO_CINCO = "*****";
    private String tipoDeRestaurante;
    public static final String TIPO_RESTAURANTE = "Restaurante";
    public static final String TIPO_BAR = "Bar";
    public static final String TIPO_LANCHONETE = "Lanchonete";
    public static final String TIPO_CAFETERIA = "Cafeteria";
    public static final String TIPO_FAST_FOOD = "Fast food";
    public static final String TIPO_FOOD_TRUCK = "Food truck";
    
    public Restaurante (String nome, String site, String infoContato, Endereco endereco, String classificacao, String tipoDeRestaurante){
        this.nome = nome;
        this.site = site;
        this.infoContato = infoContato;
        this.endereco = endereco;
        this.classificacao = classificacao;
        this.tipoDeRestaurante = tipoDeRestaurante;
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
    public Endereco getEndereco(){
        return this.endereco;
    }
    public void setEndereco (Endereco endereco){
        this.endereco = endereco;
    }
    public String getClassificacao(){
        return this.classificacao;
    }
    public void setClassificacao (String classificacao){
        this.classificacao = classificacao;
    }
    public String getTipoDeRestaurante() {
    	return this.tipoDeRestaurante;
    }
    public void setTipoDeResratrante( String tipoDeRestaurante ) {
    	this.tipoDeRestaurante = tipoDeRestaurante;
    }
    public String getDescricao() {
        return "Nome do Restaurante: "+ getNome()+ "\n" + "Com Site "+ getSite() + "\n" + "Com contato "
    +getInfoContato() + "\n" + "Classifica��o " +getClassificacao() + "\n" + "Tipo: " + getTipoDeRestaurante();
    }   
}