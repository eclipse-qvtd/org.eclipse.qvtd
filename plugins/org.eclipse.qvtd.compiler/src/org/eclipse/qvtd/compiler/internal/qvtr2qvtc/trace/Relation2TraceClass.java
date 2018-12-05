/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public interface Relation2TraceClass extends Relation2MiddleType
{
	@NonNull Element2MiddleProperty getInvocation2TraceProperty(@NonNull RelationCallExp rInvocation);

	/**
	 * Return the class used to invoke the non-top relation.
	 */
	org.eclipse.ocl.pivot.@NonNull Class getInvocationClass();

	@NonNull Property getStatusInterfaceProperty();

	/**
	 * Return the interface of the class used to invoke the non-top relation. Interface and class differ when the relation has overrides.
	 */
	org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface();

	@NonNull Relation2MiddleType getRelation2InvocationClass();

	@NonNull Relation2MiddleType getRelation2InvocationInterface();

	@NonNull Relation2MiddleType getRelation2TraceInterface();

	@NonNull Property getStatusTraceProperty();

	/**
	 * Return the class used to trace execution of the relation.
	 */
	org.eclipse.ocl.pivot.@NonNull Class getTraceClass();

	/**
	 * Return the interface of the class used to trace execution of the relation. Interface and class differ when the relation has overrides.
	 */
	org.eclipse.ocl.pivot.@NonNull Class getTraceInterface();
}