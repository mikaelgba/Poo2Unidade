package ufpb.com.Poo.exceptions;

public class MunicipioNaoExisteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public MunicipioNaoExisteException(){
		super();
	}
	public MunicipioNaoExisteException( String msgErro ){
		super( msgErro );
	}
}
