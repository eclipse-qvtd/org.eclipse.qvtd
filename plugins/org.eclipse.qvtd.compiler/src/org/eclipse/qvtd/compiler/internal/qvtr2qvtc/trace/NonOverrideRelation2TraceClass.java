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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * An OverrideRelation2TraceClass represents the mapping between a QVTr Relation without overrides
 * and the trace class for a QVTc Mapping.
 */
class NonOverrideRelation2TraceClass extends AbstractRelation2TraceClass
{
	protected NonOverrideRelation2TraceClass(@NonNull RelationAnalysis relationAnalysis) {
		super(relationAnalysis, relationAnalysis.getNameGenerator().createExecutionClassName(relationAnalysis.getRelation()));
		assert !QVTrelationUtil.hasOverrides(relation);
		resolveStatusProperty();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getInvocationClass() {
		return middleClass;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface() {
		return middleClass;
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2InvocationClass() {
		return this;
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2InvocationInterface() {
		return this;
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2TraceInterface() {
		return this;
	}

	@Override
	public @NonNull Property getStatusInterfaceProperty() {
		return ClassUtil.nonNullState(basicGetRelation2StatusProperty());
	}

	@Override
	public @NonNull Property getStatusTraceProperty() {
		return ClassUtil.nonNullState(basicGetRelation2StatusProperty());
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
		return middleClass;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceInterface() {
		return middleClass;
	}

	/**
	 * Return true if a status property is required to pass the result of an rInvocation is used.
	 * No such property is required if the result is only 'used' by a where predicate.
	 */
	protected boolean needsStatusProperty(@NonNull RelationCallExp rInvocation) {
		for (EObject eChild = rInvocation, eContainer; (eContainer = rInvocation.eContainer()) != null; eChild = eContainer) {
			if (eContainer instanceof Predicate) {
				EObject eContainerContainer = eContainer.eContainer();
				if (eContainerContainer instanceof Pattern) {
					EReference eContainmentFeature = eContainerContainer.eContainmentFeature();
					if (eContainmentFeature == QVTrelationPackage.Literals.RELATION__WHERE) {
						return false;
					}
				}
				return true;
			}
			else if (eContainer instanceof IfExp) {
				EReference eContainmentFeature = eChild.eContainmentFeature();
				if ((eContainmentFeature != PivotPackage.Literals.IF_EXP__OWNED_THEN) && (eContainmentFeature != PivotPackage.Literals.IF_EXP__OWNED_ELSE)) {
					return true;
				}
			}
			else if (eContainer instanceof LetExp) {
				EReference eContainmentFeature = eChild.eContainmentFeature();
				if (eContainmentFeature != PivotPackage.Literals.LET_EXP__OWNED_IN) {
					return true;
				}
			}
			else {
				return true;
			}
		}
		return false;			// Never happens
	}

	protected void resolveStatusProperty() {
		if (!relation.isIsAbstract()) {
			Iterable<@NonNull RelationCallExp> incomingInvocations = relationAnalysis.getIncomingInvocations();
			if (incomingInvocations != null) {
				boolean needsStatusProperty = false;
				for (@NonNull RelationCallExp invocation : incomingInvocations) {
					if (needsStatusProperty(invocation)) {
						needsStatusProperty = true;
						break;
					}
				}
				if (needsStatusProperty) {
					getStatusProperty();
				}
			}
		}
	}

	@Override
	public void synthesize() {
		super.synthesize();
	}
}