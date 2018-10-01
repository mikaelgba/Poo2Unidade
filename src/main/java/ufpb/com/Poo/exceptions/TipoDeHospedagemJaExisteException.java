package ufpb.com.Poo.exceptions;

public class TipoDeHospedagemJaExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public TipoDeHospedagemJaExisteException(){
		super();
	}
	public TipoDeHospedagemJaExisteException( String msgErro ){
		super(msgErro);
	}
}
