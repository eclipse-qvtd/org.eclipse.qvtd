/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * A QVTiLocalContext maintains the Java-specific local context for generation of QVTi code.
 */
public class QVTiLocalContext extends JavaLocalContext<@NonNull QVTiCodeGenerator>
{
	public QVTiLocalContext(@NonNull QVTiGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext, cgScope);
	}

	@Override
	public @Nullable CGValuedElement createExecutorVariable(@Nullable String contextName) {
		return null;
	}

	@Override
	public @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}

	@Override
	public @NonNull String getValueName(@NonNull CGValuedElement cgElement) {
		String valueName = cgElement.getValueName();
		if (valueName != null) {
			return valueName;
		}
		if (cgElement instanceof CGVariableExp) {
			CGVariable cgVariable = ((CGVariableExp)cgElement).getReferredVariable();
			if (cgVariable != null) {
				Element asVariable = cgVariable.getAst();
				if (asVariable instanceof Parameter) {
					EObject asContainer = asVariable.eContainer();
					if (asContainer instanceof TypedModel) {
						Transformation asTransformation = ((TypedModel)asContainer).getTransformation();
						if (asTransformation != null) {
							int index = asTransformation.getModelParameter().indexOf(asContainer);
							String name = QVTiGlobalContext.MODELS_NAME + "[" + index + "/*" + ((TypedModel)asContainer).getName() + "*/]";
							return name;
						}
					}
				}
			}
		}
		return super.getValueName(cgElement);
	}
}
