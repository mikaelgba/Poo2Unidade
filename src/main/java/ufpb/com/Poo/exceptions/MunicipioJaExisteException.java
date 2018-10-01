package ufpb.com.Poo.exceptions;

public class MunicipioJaExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MunicipioJaExisteException(){
		super();
	}
	public MunicipioJaExisteException( String msgErro ){
		super( msgErro );
	}
}
