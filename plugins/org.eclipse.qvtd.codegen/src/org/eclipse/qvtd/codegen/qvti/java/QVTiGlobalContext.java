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
package org.eclipse.qvtd.codegen.qvti.java;
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


import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.examples.pivot.Property;

/**
 * A JUnitGlobalContext maintains the Java-specific global context for generation of code.
 */
public class QVTiGlobalContext extends JavaGlobalContext
{
	private /*@LazyNonNull*/ CGValuedElement evaluatorParameter = null;
	private /*@LazyNonNull*/ CGValuedElement idResolver = null;
	private /*@LazyNonNull*/ Map<Property, String> toMiddleProperties = null;

	public QVTiGlobalContext(@NonNull JavaCodeGenerator codeGenerator) {
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
			toMiddleProperties.put(pivotProperty, nameManager.getGlobalSymbolName(null, "OPPOSITE_OF_" + pivotProperty.getOwningType().getName() + "_" + pivotProperty.getName()));
		}
	}

	public @NonNull CGValuedElement getEvaluatorParameter() {
		CGValuedElement evaluatorParameter2 = evaluatorParameter;
		if (evaluatorParameter2 == null) {
			evaluatorParameter = evaluatorParameter2 = CGModelFactory.eINSTANCE.createCGParameter();
			evaluatorParameter2.setName(JavaConstants.EVALUATOR_NAME);
			evaluatorParameter2.setValueName(JavaConstants.EVALUATOR_NAME);
			evaluatorParameter2.setTypeId(analyzer.getTypeId(JavaConstants.EVALUATOR_TYPE_ID));
		}
		return evaluatorParameter2;
	}
	
	public @NonNull CGValuedElement getIdResolverVariable() {
		CGValuedElement idResolver2 = idResolver;
		if (idResolver2 == null) {
			idResolver = idResolver2 = CGModelFactory.eINSTANCE.createCGParameter();
			idResolver2.setName(JavaConstants.ID_RESOLVER_NAME);
			idResolver2.setValueName(JavaConstants.ID_RESOLVER_NAME);
			idResolver2.setTypeId(analyzer.getTypeId(JavaConstants.ID_RESOLVER_TYPE_ID));
		}
		return idResolver2;
	}
	
	public @Nullable Map<Property, String> getToMiddleProperties() {
		return toMiddleProperties;
	}
}