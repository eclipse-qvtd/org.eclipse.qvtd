/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: DeclarativeQVTCompilationException.java,v 1.3 2008/10/21 08:31:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.compilation;

public abstract class DeclarativeQVTCompilationException extends Exception {

	protected int lineNumber;
	
	protected int startCharacter;
	
	protected int endCharacter;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1492308790290465113L;

	public DeclarativeQVTCompilationException(String message, int lineNumber,
			int startCharacter, int endCharacter ) {
		super(message);
		this.lineNumber = lineNumber;
		this.startCharacter = startCharacter;
		this.endCharacter = endCharacter;
	}

	
	
}
