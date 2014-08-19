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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.examples.pivot.Property;

/**
 * A QVTiGlobalContext maintains the Java-specific global context for generation of QVTi code.
 */
public class QVTiGlobalContext extends JavaGlobalContext<QVTiCodeGenerator>
{
	private /*@LazyNonNull*/ Map<Property, String> toMiddleProperties = null;

	public QVTiGlobalContext(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		nameManager.reserveName(JavaConstants.EVALUATOR_NAME, null);
		nameManager.reserveName("modelObjects", null);
	}

	public void addToMiddleProperty(@NonNull Property pivotProperty) {
		assert !pivotProperty.isImplicit();
		if (toMiddleProperties == null) {
			toMiddleProperties = new HashMap<Property, String>();
		}
		if (!toMiddleProperties.containsKey(pivotProperty)) {
			toMiddleProperties.put(pivotProperty, nameManager.getGlobalSymbolName(null, "OPPOSITE_OF_" + pivotProperty.getOwningClass().getName() + "_" + pivotProperty.getName()));
		}
	}
	
	@Override
	protected @NonNull QVTiLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new QVTiLocalContext(this, cgScope);
	}

	public @Nullable Map<Property, String> getToMiddleProperties() {
		return toMiddleProperties;
	}
}
