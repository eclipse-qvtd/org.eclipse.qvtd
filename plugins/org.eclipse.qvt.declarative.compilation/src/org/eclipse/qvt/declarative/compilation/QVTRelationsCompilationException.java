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
 * $Id: QVTRelationsCompilationException.java,v 1.2 2008/10/09 17:21:10 qglineur Exp $
 */
package org.eclipse.qvt.declarative.compilation;

public class QVTRelationsCompilationException extends
		DeclarativeQVTCompilationException {

	public QVTRelationsCompilationException(int lineNumber, int startCharacter,
			int endCharacter) {
		super(lineNumber, startCharacter, endCharacter);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2611237267419675520L;

}
