/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.environment;

import org.eclipse.emf.ecore.xmi.XMIResource;

public interface ICSTRootEnvironment extends ICSTNodeEnvironment
{
	/**
	 * Diagnose and AST nodes not mapped to CST nodes and vice-versa.
	 * <br>
	 * This is a debug facility, so output to to System.out.
	 */
	public void checkMappings();

	public XMIResource getASTNode();

	public int getCSTErrorTokens();
	
	public void postParse();

	public void validate();
}
