/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A AbstractInvocation2TraceClass represents the mapping between an invoked QVTr Relation and a QVTr mapping trace class.
 */
abstract class AbstractInvocation2TraceClass extends AbstractRule2TraceClass
{
	protected final @NonNull Relation invokingRelation;
	protected final Rule2TraceClass.@NonNull Internal invokedRelation2TraceClass;

	protected AbstractInvocation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage,
			@NonNull Relation invokedRelation, @NonNull Relation invokingRelation) throws CompilerChainException {
		super(relationalTransformation2tracePackage, invokedRelation);
		this.invokingRelation = invokingRelation;
		this.invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokedRelation);
	}

	@Override
	public @NonNull Map<@NonNull String, @NonNull Property> getName2Property() {
		return invokedRelation2TraceClass.getName2Property();
	}

	@Override
	public @NonNull Iterable<@NonNull RelationCallExp> getWhenInvocations() {
		return invokedRelation2TraceClass.getWhenInvocations();
	}

	@Override
	public @NonNull Iterable<@NonNull RelationCallExp> getWhereInvocations() {
		return invokedRelation2TraceClass.getWhereInvocations();
	}

	@Override
	public void installConsumesDependencies() throws CompilerChainException {}

	@Override
	public void transform() throws CompilerChainException {
		Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
		if (overriddenRelation != null) {
			Rule2TraceClass.@NonNull Internal overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(overriddenRelation);
			traceClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceClass());
		}
	}
}