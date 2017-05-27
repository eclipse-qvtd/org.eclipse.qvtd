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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A NonTopRelation2TraceClass represents the mapping between a non-top level QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
 */
class NonTopRelation2TraceClass extends AbstractRelation2TraceClass
{

	/**
	 * VariableDeclaration2TraceProperty accumulates the requirements on the trace property for a pattern variable.
	 *
	 * Its relation TypedModel may be initially null (unknown) and set non-null once encountered as a template binding.
	 *
	 * Its unitOpposite may evolve to true if any mechanism for unit usage is encountered.
	 */
	class VariableDeclaration2SignatureOrTraceProperty extends VariableDeclaration2TraceProperty
	{
		/**
		 * The lazily created signature property.
		 */
		private @Nullable Property signatureProperty;

		public VariableDeclaration2SignatureOrTraceProperty(@NonNull NonTopRelation2TraceClass relation2traceClass, @Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean unitOpposite) {
			super(relation2traceClass, rTypedModel, variable, unitOpposite);
		}

		public @NonNull Property getSignatureProperty() {
			Property signatureProperty2 = signatureProperty;
			if (signatureProperty2 == null) {
				signatureProperty = signatureProperty2 = createProperty(((NonTopRelation2TraceClass)relation2traceClass).getSignatureClass(), false);
			}
			return signatureProperty2;
		}
	}

	/**
	 * The Class that realizes a signature interface to for a static invocation of this trace class.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class signatureClass = null;

	protected NonTopRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		super(relationalTransformation2tracePackage, relation);
		//			traceClass.setIsAbstract(true);
		getSignatureClass();
	}

	@Override
	public void analyzeProperties() throws CompilerChainException {
		super.analyzeProperties();
		for (@NonNull Variable rRoot : QVTrelationUtil.getRootVariables(relation)) {
			getSignatureProperty(rRoot);
		}
	}

	@Override
	public @Nullable Class basicGetSignatureClass() {
		return signatureClass;
	}

	@Override
	protected @NonNull VariableDeclaration2TraceProperty createVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		return new VariableDeclaration2SignatureOrTraceProperty(this, rTypedModel, variable, isNestedOneToOne);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getSignatureClass() {
		org.eclipse.ocl.pivot.Class signatureClass2 = signatureClass;
		if (signatureClass2 == null) {
			String name = relationalTransformation2tracePackage.getNameGenerator().createSignatureClassName(traceClass);
			signatureClass = signatureClass2 = PivotUtil.createClass(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
		}
		return signatureClass2;
	}

	@Override
	public @NonNull Property getSignatureProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = basicGetVariableDeclaration2TraceProperty(rVariable);
		assert variableDeclaration2TraceProperty != null;
		return ((VariableDeclaration2SignatureOrTraceProperty)variableDeclaration2TraceProperty).getSignatureProperty();
	}

	@Override
	public void synthesize() {
		super.synthesize();
		org.eclipse.ocl.pivot.Class signatureClass = getSignatureClass();
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			for (@NonNull Variable rootVariable : QVTrelationUtil.getRootVariables(rDomain)) {
				VariableDeclaration2TraceProperty rootVariableDeclaration2TraceProperty = basicGetVariableDeclaration2TraceProperty(rootVariable);
				assert rootVariableDeclaration2TraceProperty != null;
				((VariableDeclaration2SignatureOrTraceProperty)rootVariableDeclaration2TraceProperty).getSignatureProperty();
			}
		}
		CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedPropertiesList(signatureClass));
	}
}