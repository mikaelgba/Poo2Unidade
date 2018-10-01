package ufpb.com.Poo.models;

public class Shopping extends AtrativoTuristico {

	private String abertura;
	private String fechamento;
	
	public Shopping(String nome, String comoChegar, String site, String infoContato, String abertura, String fechamento, Endereco endereco) {
		super(nome,comoChegar, site, infoContato, endereco);
		this.abertura = abertura;
		this.fechamento = fechamento;	
	}
	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}
	public String getAbertura() {
		return abertura;
	}
	public void setFechamento(String fechamento) {
		this.fechamento = fechamento;
	}
	public String getFechamento() {
		return fechamento;
	}
	public String getDescricao() {
		return "Praia de nome "+super.getNome() + "\n" + "Com acesso " + super.getComoChegar() 
		+ "\n" + " Site " + super.getSite()+ "\n" + "Contato " + super.getInfoContato() 
		+ "\n" + "Abertura: " + getAbertura() + "\n" + "Encerramento: " + getFechamento();
	}
}
