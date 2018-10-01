/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpb.com.Poo.exceptions;

/**
 *
 * @author User
 */
public class AtrativoNaoExisteException extends Exception{
    
    private static final long serialVersionUID = 1L;
	
	public AtrativoNaoExisteException() {
		super();
	}
	public AtrativoNaoExisteException( String msgerro ) {
		super( msgerro );
	}
    
}
