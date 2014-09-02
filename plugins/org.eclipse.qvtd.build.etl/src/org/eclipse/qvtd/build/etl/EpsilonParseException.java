package org.eclipse.qvtd.build.etl;

/**
 * The Class EpsilonStandaloneException.
 */
public class EpsilonParseException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4172842347806568754L;
	
	/**
	 * Instantiates a new epsilon standalone exception.
	 *
	 * @param msg the msg
	 */
	public EpsilonParseException(String msg){
		super(msg);
	}

    /**
     * Instantiates a new epsilon standalone exception.
     *
     * @param msg the msg
     * @param t the previous Throwable cause
     */
    public EpsilonParseException(String msg, Throwable t){
    	super(msg,t);
    } 

}
