/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvti;
/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;

/**
 * A JavaLocalContext maintains the Java-specific context for generation of coide from a CGOperation.
 */
public class QVTiLocalContext extends JavaLocalContext
{
	public QVTiLocalContext(@NonNull QVTiGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext, cgScope);
	}
	
	public QVTiLocalContext(@NonNull QVTiLocalContext parentContext, @NonNull CGElement cgScope) {
		super(parentContext, cgScope);
	}

	@Override
	public @NonNull QVTiLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new QVTiLocalContext(this, cgScope);
	}

	/*
	 * If the self parameter has a known type other than Object, we add a CGCastParamter that casts the passed parameter self_0:Object to a better self.
	 * Otherwise we just rename the passed parameter to be self. The self parameter is of course maintained in the outer name context.
	 */
	@Override
	public @NonNull CGParameter getCastParameter(@NonNull CGParameter cgParameter) {
		if (cgParameter instanceof CGCastParameter) {
			return cgParameter;
		}
		if (JavaConstants.SELF_NAME.equals(cgParameter.getName())) {
			JavaLocalContext parentContext2 = parentContext;
			if (parentContext2 != null) {
				return parentContext2.getCastParameter(cgParameter);
			}
			else {
				CGParameter cgCastParameter = basicGetCastParameter(cgParameter);
				if (cgCastParameter == null) {
					cgCastParameter = createCastParameter(cgParameter);
					cgCastParameter.setValueName(globalContext.getSelfName());
					addCastParameter(cgParameter, cgCastParameter);
				}
				return cgCastParameter;
			}
		}
		return super.getCastParameter(cgParameter);
	}

	@Override
	public @NonNull CGValuedElement getEvaluatorParameter() {
		return getGlobalContext().getEvaluatorParameter();
	}

	@Override
	public @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}
	
	@Override
	public @NonNull CGValuedElement getIdResolverVariable() {
		return getGlobalContext().getIdResolverVariable();
	}
}
