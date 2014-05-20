/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;

/**
 * A QVTiLocalContext maintains the Java-specific local context for generation of QVTi code.
 */
public class QVTiLocalContext extends JavaLocalContext
{
	public QVTiLocalContext(@NonNull QVTiGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext, cgScope);
	}

	@Override
	public @Nullable CGValuedElement createEvaluatorVariable() {
		return null;
	}

	@Override
	public @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}
}
