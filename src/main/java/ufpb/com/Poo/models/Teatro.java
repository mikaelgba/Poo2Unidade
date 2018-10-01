package ufpb.com.Poo.models; 

public class Teatro extends AtrativoTuristico{
	
	private String tipo;
    private int Capacidade;
    private double Ingresso;
    private String InfoEspetaculo;
    private String abertura;
	private String fechamento;
   
    public Teatro( String nome, String comoChegar, String site, String infoContato, String tipo, 
    		int Capacidade, double Ingresso, String InfoEspetaculo, String abertura, String fechamento, Endereco endereco) { 
        super(nome,comoChegar, site, infoContato, endereco);
        this.tipo =tipo;
        this.Capacidade = Capacidade;
        this.Ingresso = Ingresso; 
        this.InfoEspetaculo = InfoEspetaculo;
        this.abertura = abertura;
        this.fechamento = fechamento; 
    }   
    public int getCapacidade(){
         return this.Capacidade;
    }    
    public void setCapacidade( int Capacidade){
          this.Capacidade = Capacidade;
    }
    public double getIngresso(){
         return this.Ingresso;
    }    
    public void setIngresso( double Ingresso){
          this.Ingresso = Ingresso;
    }
    public String getInfoEspetaculo(){
        return this.InfoEspetaculo;
    }
    public void setInfoEspetaculo( String InfoEspetaculo){
        this.InfoEspetaculo = InfoEspetaculo;
    }
	public String getAbertura() {
		return abertura;
	}
	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}
	public String getFechamento() {
		return fechamento;
	}
	public void setFechamento(String fechamento) {
		this.fechamento = fechamento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return "Praia de nome "+super.getNome() + "\n" + "Com acesso " + super.getComoChegar() 
		+ "\n" + " Site " + super.getSite()+ "\n" + "Contato " + super.getInfoContato() 
		+ "\n" + "Tipo: " + getTipo() + "\n" + "Capacidade: " + getCapacidade() 
		+ "\n" + "ingresso: " + getIngresso() + "\n" + "Informa��es do espetaculo: " + getInfoEspetaculo()
		+ "\n" + "Abertura: " + getAbertura() + "\n" + "Encerramento: " + getFechamento();
	}
}
