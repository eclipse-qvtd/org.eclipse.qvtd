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
 * $Id: QVTCoreCompilationException.java,v 1.3 2008/10/21 08:31:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.compilation;

public class QVTCoreCompilationException extends
		DeclarativeQVTCompilationException {

	public QVTCoreCompilationException(String message, int lineNumber, int startCharacter,
			int endCharacter) {
		super(message, lineNumber, startCharacter, endCharacter);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3613629919927749266L;

}
