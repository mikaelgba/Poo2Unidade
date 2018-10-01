package ufpb.com.Poo.models;

public class EventoProgramado extends AtrativoTuristico {
	
	private String dataInicio;
	private String dataFim;
	private String tipo;
	public static final String FESTA_ABERTA = "Festa Aberta";
	public static final String FESTA_PRIVADA = "Festa Privada";
	public float entrada;

	public EventoProgramado(String nome, String comoChegar, String site, String infoContato, String dataInicio,
			String dataFim, String tipo, float entrada, Endereco endereco) {
		super(nome, comoChegar, site, infoContato, endereco);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;
		this.entrada = entrada;
	}
	public String getDataInicio() {
		return this.dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return this.dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getEntrada() {
		return this.entrada;
	}
	public void setEntrada(float entrada) {
		this.entrada = entrada;
	}
	public String getDescricao() {
		return "Evento de nome " + super.getNome() + "\n"  + "Acesso por " + getComoChegar() + "\n" + "Com Site " + super.getSite()
				+ "\n" + "Com contato " + super.getInfoContato() + "" + "\n" + "Inicia " + this.dataInicio + "\n"
				+ "Termina " + this.dataFim + "\n" + "De tipo " + this.tipo + "\n" + "Valor da entrada: " + this.getEntrada();
	}
}
