/*******************************************************************************
 * Copyright (c) 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
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
