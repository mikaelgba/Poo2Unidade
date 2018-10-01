package ufpb.com.Poo.exceptions;

public class UsuarioSisTurJaExisteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public  UsuarioSisTurJaExisteException() {
		super();
	}
	public  UsuarioSisTurJaExisteException( String msgerro ) {
		super(msgerro);
	}
}
