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
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import org.eclipse.ocl.cst.CSTNode;

public class QVTcNestedEnvironment extends QVTcEnvironment<IQVTcEnvironment, IQVTcEnvironment>
{
	public QVTcNestedEnvironment(IQVTcEnvironment env, CSTNode cstNode) {
		super(env, cstNode);
	}
}
