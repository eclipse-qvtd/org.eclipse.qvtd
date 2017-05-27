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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * VariableDeclaration2TraceProperty accumulates the requirements on the trace property for a pattern variable.
 *
 * Its relation TypedModel may be initially null (unknown) and set non-null once encountered as a template binding.
 *
 * Its unitOpposite may evolve to true if any mechanism for unit usage is encountered.
 */
class VariableDeclaration2TraceProperty extends Element2TraceProperty
{
	/**
	 * The typed model within which the variable's reference is located. null for unknown or primitive.
	 */
	private @Nullable TypedModel rTypedModel;

	/**
	 * The variable whose value is persisted by the trace property.
	 */
	//		final @NonNull VariableDeclaration variable;

	/**
	 * True if there is known to be at most one instance of the trace class for each value of the trace variable.
	 * False if there might be more than one.
	 */
	private boolean unitOpposite;

	public VariableDeclaration2TraceProperty(@NonNull Relation2TraceClass relation2traceClass, @Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean unitOpposite) {
		super(relation2traceClass, relation2traceClass.getNameGenerator().createTracePropertyName(variable), QVTrelationUtil.getClass(variable), variable.isIsRequired());
		this.rTypedModel = rTypedModel;
		//			this.variable = variable;
		this.unitOpposite = unitOpposite;
	}

	protected @NonNull Property createProperty(org.eclipse.ocl.pivot.@NonNull Class owningClass, boolean unitOpposite) {
		return ((AbstractRelation2TraceClass) relation2traceClass).createProperty(rTypedModel, owningClass, name, type, isRequired, unitOpposite);
	}

	/**
	 * Create the name Property for a traceClass with a type. If unitOpposite is not set there may be many trace class instances referencing the same object through
	 * the trace property and so the implicit opposite must be a Bag.
	 */
	@Override
	protected @NonNull Property createTraceProperty() {
		return createProperty(relation2traceClass.getTraceClass(), unitOpposite);
	}

	protected @Nullable TypedModel getrTypedModel() {
		return rTypedModel;
	}

	public void refineTraceProperty(@Nullable TypedModel rTypedModel, boolean isNestedOneToOne) {
		if (rTypedModel != null) {
			if (this.rTypedModel == null) {
				this.rTypedModel = rTypedModel;
			}
			else {
				assert this.rTypedModel == rTypedModel;
			}
		}
		if (isNestedOneToOne && !this.unitOpposite) {
			this.unitOpposite = true;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(rTypedModel) + "!" + super.toString() + " " + (unitOpposite ? "SINGLE" : "MULTIPLE");
	}
}