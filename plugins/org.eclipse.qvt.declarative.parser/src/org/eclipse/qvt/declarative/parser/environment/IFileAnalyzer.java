/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: IFileAnalyzer.java,v 1.1 2008/08/18 07:47:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.environment;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.cst.CSTNode;

public interface IFileAnalyzer
{
	public CSTNode parseToCST();

	public Collection<? extends EObject> parseCSTtoAST(CSTNode cstNode, URI uri);
}
