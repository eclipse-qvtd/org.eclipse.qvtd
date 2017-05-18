/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * Invocation2TraceProperty defines the requirements on the trace property for an invocation signature.
 */
class Invocation2TraceProperty extends Element2TraceProperty
{
	/**
	 * The invocation whose use is persisted by the signature property.
	 */
	//		final @NonNull RelationCallExp invocation;

	public Invocation2TraceProperty(@NonNull Relation2TraceClass relation2traceClass, @NonNull String name, @NonNull RelationCallExp invocation) {
		super(relation2traceClass, name, relation2traceClass.getRelationalTransformation2TracePackage().getRelation2TraceClass(QVTrelationUtil.getReferredRelation(invocation)).getSignatureClass(), true);
	}

	/**
	 * Create the trace Property for a signatureClass with a type.
	 *
	protected @NonNull Property createSignatureProperty() {
		Property signatureProperty = PivotFactory.eINSTANCE.createProperty();
		signatureProperty.setName(name);
		signatureProperty.setType(type);
		signatureProperty.setIsRequired(false);
		signatureProperty.setIsResolveProxies(false);
		signatureProperty.setIsTransient(true);
		signatureProperty.setOwningClass(relation2traceClass.getSignatureClass());
		return signatureProperty;
	} */

	/**
	 * Create the trace Property for a signatureClass with a type.
	 */
	@Override
	protected @NonNull Property createTraceProperty() {
		//		return ((AbstractRelation2TraceClass) relation2traceClass).createProperty(null, relation2traceClass.getTraceClass(), name, type, isRequired, true);
		Property signatureProperty = PivotFactory.eINSTANCE.createProperty();
		signatureProperty.setName(name);
		signatureProperty.setType(type);
		signatureProperty.setIsRequired(false);
		//		signatureProperty.setIsResolveProxies(false);
		//		signatureProperty.setIsTransient(true);		-- FIXME transient has no determinate xmi:id
		signatureProperty.setOwningClass(relation2traceClass.getTraceClass());
		return signatureProperty;
	}
}