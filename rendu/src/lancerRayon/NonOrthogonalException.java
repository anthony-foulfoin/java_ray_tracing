package lancerRayon;

/** 
 * Exception levee si 2 vecteurs normalement orthogonaux ne le sont pas.
 *
 */
public class NonOrthogonalException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* Cree une nouvelle instance de NonOrthogonalException 
	*/  
	public NonOrthogonalException() {}  
	/** 
	* Cree une nouvelle instance de NonOrthogonalException 
	* @param message Le message detaillant exception 
	*/  
	public NonOrthogonalException(String message) {  
		super(message); 
	}  
	/** 
	* Cree une nouvelle instance de NonOrthogonalException 
	* @param cause L'exception a l'origine de cette exception 
	*/  
	public NonOrthogonalException(Throwable cause) {  
		super(cause); 
	}  
	/** 
	* Cree une nouvelle instance de NonOrthogonalException 
	* @param message Le message detaillant exception 
	* @param cause L'exception a l'origine de cette exception 
	*/  
	public NonOrthogonalException(String message, Throwable cause) {  
		super(message, cause); 
	} 
	
}
