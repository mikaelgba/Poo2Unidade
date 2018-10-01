package ufpb.com.Poo.exceptions;

public class AtrativoJaExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AtrativoJaExisteException() {
		super();
	}
	public AtrativoJaExisteException( String msgerro ) {
		super( msgerro );
	}
}
