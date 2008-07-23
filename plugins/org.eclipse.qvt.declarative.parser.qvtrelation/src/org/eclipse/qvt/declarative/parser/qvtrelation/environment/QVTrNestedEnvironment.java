/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import org.eclipse.ocl.cst.CSTNode;

public class QVTrNestedEnvironment extends QVTrEnvironment<IQVTrEnvironment>
{
	public QVTrNestedEnvironment(IQVTrEnvironment env, CSTNode cstNode) {
		super(env, cstNode);
	}	
}
