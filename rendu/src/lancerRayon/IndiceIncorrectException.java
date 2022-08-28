package lancerRayon;

/** 
 * Exception levee si un indice est incorrecte.
 *
 */
public class IndiceIncorrectException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* Cree une nouvelle instance de IndiceIncorrectException 
	*/  
	public IndiceIncorrectException() {}  
	/** 
	* Cree une nouvelle instance de IndiceIncorrectException 
	* @param message Le message detaillant exception 
	*/  
	public IndiceIncorrectException(String message) {  
		super(message); 
	}  
	/** 
	* Cree une nouvelle instance de IndiceIncorrectException 
	* @param cause L'exception a l'origine de cette exception 
	*/  
	public IndiceIncorrectException(Throwable cause) {  
		super(cause); 
	}  
	/** 
	* Cree une nouvelle instance de IndiceIncorrectException 
	* @param message Le message detaillant exception 
	* @param cause L'exception a l'origine de cette exception 
	*/  
	public IndiceIncorrectException(String message, Throwable cause) {  
		super(message, cause); 
	} 
	
}
