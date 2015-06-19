/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Property;

/**
 * A QVTiGlobalContext maintains the Java-specific global context for generation of QVTi code.
 */
public class QVTiGlobalContext extends JavaGlobalContext<QVTiCodeGenerator>
{
	public static final @NonNull String MODELS_NAME = "models";
	
	/**
	 * Map from an oppositeProperty that requites a cache to the global name of that cache. 
	 */
	private /*@LazyNonNull*/ Map<Property, String> oppositeProperty2oppositeCacheName = null;

	public QVTiGlobalContext(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		nameManager.reserveName(JavaConstants.EXECUTOR_NAME, null);
		nameManager.reserveName(MODELS_NAME, null);
	}

	public String addOppositeProperty(@NonNull Property pivotProperty) {
		assert !pivotProperty.isIsImplicit();
		if (oppositeProperty2oppositeCacheName == null) {
			oppositeProperty2oppositeCacheName = new HashMap<Property, String>();
		}
		if (!oppositeProperty2oppositeCacheName.containsKey(pivotProperty)) {
			oppositeProperty2oppositeCacheName.put(pivotProperty, nameManager.getGlobalSymbolName(null, "OPPOSITE_OF_" + pivotProperty.getOwningClass().getName() + "_" + pivotProperty.getName()));
		}
		return oppositeProperty2oppositeCacheName.get(pivotProperty);
	}
	
	@Override
	protected @NonNull QVTiLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new QVTiLocalContext(this, cgScope);
	}

	public @Nullable Map<Property, String> getOppositeProperties() {
		return oppositeProperty2oppositeCacheName;
	}
}
