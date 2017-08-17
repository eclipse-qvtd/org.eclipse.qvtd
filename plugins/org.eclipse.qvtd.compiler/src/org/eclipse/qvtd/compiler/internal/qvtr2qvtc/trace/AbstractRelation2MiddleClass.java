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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;

/**
 * An AbstractRelation2MiddleClass represents the mapping between a QVTr Relation and the future trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a top/non-top relation.
 */
abstract class AbstractRelation2MiddleClass implements Relation2MiddleClass
{
	protected final @NonNull RelationAnalysis relationAnalysis;

	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;

	protected final @NonNull  QVTrNameGenerator nameGenerator;

	/**
	 * The relation to be mapped to a trace class and mapping.
	 */
	protected final @NonNull Relation relation;

	/**
	 * The Class that realizes the middle class.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class middleClass;

	/**
	 * Lazily created null-free Bag of middleClass.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class bagOfMiddleClass = null;

	/**
	 * Name to corresponding future middle property
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Element2MiddleProperty> name2element2middleProperty = new HashMap<>();

	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull VariableDeclaration2MiddleProperty> variable2variableDeclaration2middleProperty = new HashMap<>();

	protected AbstractRelation2MiddleClass(@NonNull RelationAnalysis relationAnalysis, @NonNull String middleClassName) {
		this.relationAnalysis = relationAnalysis;
		this.relationalTransformation2tracePackage = relationAnalysis.getRelationalTransformation2TracePackage();
		this.nameGenerator = relationalTransformation2tracePackage.getNameGenerator();
		this.relation = relationAnalysis.getRelation();
		this.middleClass = PivotUtil.createClass(relationalTransformation2tracePackage.getUniqueMiddleClassName(this, middleClassName));
	}

	protected void analyzeRootTemplateVariables(boolean manyTraces) {
		//
		//	Prepare a middle property for each root variable.
		//
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			TypedModel rTypedModel = rDomain.getTypedModel();
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
				Variable bindsTo = QVTrelationUtil.getBindsTo(rTemplateExp);
				getVariableDeclaration2MiddleProperty(rTypedModel, bindsTo, !manyTraces);
			}
		}
	}

	//
	//	Determine the trace variables and whether they have a to-one opposite
	//
	protected boolean analyzeTraceMultiplicity() {
		//
		//	Determine whether a navigation from the trace to an unambiguous left/right object can ever be possible.
		//
		boolean manyTraces = hasManyRootMatches() || hasCollectionMemberMatches() || hasMultiObjectMatches();
		if (!manyTraces) {
			for (@NonNull Variable rVariable : QVTrelationUtil.getOwnedVariables(relation)) {
				if (hasManyVariableMatches(rVariable)) {
					manyTraces = true;
					break;
				}
			}
		}
		return manyTraces;
	}

	@Override
	public @Nullable Property basicGetMiddleProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2MiddleProperty variableDeclaration2middleProperty = variable2variableDeclaration2middleProperty.get(rVariable);
		if (variableDeclaration2middleProperty == null) {
			return null;
		}
		return variableDeclaration2middleProperty.getMiddleProperty();
	}

	protected @Nullable VariableDeclaration2MiddleProperty basicGetVariableDeclaration2MiddleProperty(@NonNull VariableDeclaration variable) {
		return variable2variableDeclaration2middleProperty.get(variable);
	}

	@Override
	public int compareTo(@NonNull Relation2MiddleClass that) {
		return ClassUtil.safeCompareTo(this.middleClass.getName(), that.getMiddleClass().getName());
	}

	protected @NonNull VariableDeclaration2MiddleProperty createVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		return new VariableDeclaration2MiddleProperty(this, rTypedModel, variable, isNestedOneToOne);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getBagOfMiddleClass() {
		Class bagOfMiddleClass2 = bagOfMiddleClass;
		if (bagOfMiddleClass2 == null) {
			bagOfMiddleClass = bagOfMiddleClass2 = relationalTransformation2tracePackage.getBagType(middleClass);
		}
		return bagOfMiddleClass2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getMiddleClass() {
		return middleClass;
	}

	@Override
	public @NonNull Property getMiddleProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2MiddleProperty variableDeclaration2middleProperty = getVariableDeclaration2MiddleProperty(rVariable);
		return variableDeclaration2middleProperty.getMiddleProperty();
	}

	@Override
	public @NonNull QVTrNameGenerator getNameGenerator() {
		return nameGenerator;
	}

	@Override
	public @NonNull Relation getRelation() {
		return relation;
	}

	@Override
	public @NonNull RelationAnalysis getRelationAnalysis() {
		return relationAnalysis;
	}

	@Override
	public @NonNull Element2MiddleProperty getRelation2TraceProperty() {
		throw new UnsupportedOperationException("Only non-ttop relations have an invocation trace property");
	}

	@Override
	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return relationalTransformation2tracePackage;
	}

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2middleProperty, @NonNull String name) {
		return nameGenerator.getUniqueName(name2element2middleProperty, name, element2middleProperty);
	}

	protected @NonNull VariableDeclaration2MiddleProperty getVariableDeclaration2MiddleProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		VariableDeclaration2MiddleProperty variableDeclaration2middleProperty = variable2variableDeclaration2middleProperty.get(variable);
		if (variableDeclaration2middleProperty != null) {
			variableDeclaration2middleProperty.refineProperty(rTypedModel, isNestedOneToOne);
		}
		else {
			variableDeclaration2middleProperty = createVariableDeclaration2TraceProperty(rTypedModel, variable, isNestedOneToOne);
			variable2variableDeclaration2middleProperty.put(variable, variableDeclaration2middleProperty);
		}
		return variableDeclaration2middleProperty;
	}

	@Override
	public @NonNull VariableDeclaration2MiddleProperty getVariableDeclaration2MiddleProperty(@NonNull VariableDeclaration variable) {
		return ClassUtil.nonNullState(variable2variableDeclaration2middleProperty.get(variable));
	}

	private boolean hasCollectionMemberMatches() {
		for (EObject eObject : new TreeIterable(relation, true)) {
			if (eObject instanceof CollectionTemplateExp) {
				List<OCLExpression> members = ((CollectionTemplateExp)eObject).getMember();
				if (members.size() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return true if there may be more than one trace instance for a given root variable.
	 */
	private boolean hasManyRootMatches() {
		//
		//	Only a single root variable in each of just two domains gurantees just one trace per root variable.
		//
		List<@NonNull Domain> rDomains = QVTrelationUtil.Internal.getOwnedDomainsList(relation);
		if (rDomains.size() > 2) {
			return true;
		}
		else {
			for (@NonNull Domain rDomain : rDomains) {
				List<Variable> rootVariables = ((RelationDomain)rDomain).getRootVariable();
				if (rootVariables.size() > 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasManyVariableMatches(@NonNull Variable rVariable) {
		for (@NonNull Domain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			Iterable<@NonNull Variable> bindsTo = QVTr2QVTcUtil.getRelationDomainBindsTo((RelationDomain) rDomain);
			if (Iterables.contains(bindsTo, rVariable)) {
				return false;
			}
		}
		for (@NonNull EObject eObject : new TreeIterable(relation, true)) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if (referredVariable == rVariable) {
					EObject eContainer = eObject.eContainer();
					if (eContainer instanceof OperationCallExp) {
						OperationCallExp operationCallExp = (OperationCallExp)eContainer;
						Operation referredOperation = operationCallExp.getReferredOperation();
						assert referredOperation != null;
						if (operationCallExp.getOwnedArguments().equals(Collections.singletonList(eObject)) && "includes".equals(referredOperation.getName())) {		// FIXME stronger test
							return true;
						}
					}
					// FIXME more cases
				}
			}
		}
		return false;
	}

	private boolean hasMultiObjectMatches() {
		for (EObject eObject : new TreeIterable(relation, true)) {
			if (eObject instanceof PropertyTemplateItem) {
				Property referredProperty = ((PropertyTemplateItem)eObject).getReferredProperty();
				if (referredProperty.isIsMany()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class synthesize() {
		//
		//	Create a middle property for each prepared middle property.
		//
		for (@NonNull Element2MiddleProperty element2middleProperty : name2element2middleProperty.values()) {
			element2middleProperty.getMiddleProperty();
		}
		return middleClass;
	}

	@Override
	public String toString() {
		return middleClass.getName();
	}
}