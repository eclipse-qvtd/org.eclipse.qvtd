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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;

/**
 * An AbstractRelation2TraceClass represents the mapping between a QVTr Relation and the trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a top/non-top overrides/non-overrides.
 */
abstract class AbstractRelation2TraceClass extends AbstractRelation2MiddleType implements Relation2TraceClass
{
	private @Nullable Map<@NonNull RelationCallExp, @NonNull Invocation2TraceProperty> invocation2relation2traceProperty = null;

	/**
	 * Name to corresponding future trace property
	 */
	private final @NonNull Map<@NonNull String, @Nullable Element2MiddleProperty> name2element2traceProperty = new HashMap<>();

	protected AbstractRelation2TraceClass(@NonNull RelationAnalysis relationAnalysis, @NonNull String middleClassName) {
		super(relationAnalysis, middleClassName);
		//		traceClass.setIsAbstract(relation.isIsAbstract());
		//		if (relation.isIsAbstract()) {
		//		middleClass.getOwningPackage().getOwnedClasses().remove(middleClass);
		//		}
	}

	/*	@Override
	public void analyzeInheritance() {
				Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
				if (overriddenRelation != null) {
					Relation2TraceClass.@NonNull Internal overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation);
					traceClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceInterface());
				}
	} */

	@Override
	public void analyze() throws CompilerChainException {
		boolean manyTraces = analyzeTraceMultiplicity();
		analyzeSharedVariables();
		analyzeRootTemplateVariables(manyTraces);
		analyzeNonRootTemplateVariables(manyTraces);
		analyzeInvocationVariables();
	}

	protected void analyzeInvocationVariable(@NonNull RelationCallExp rInvocation) {
		Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		if (!invokedRelation.isIsTopLevel()) {
			getInvocation2TraceProperty(rInvocation);
		}
	}

	/**
	 * Create child trace properties for each invocation of a non-top relation.
	 */
	protected void analyzeInvocationVariables() {
		Iterable<@NonNull RelationCallExp> outgoingInvocations = relationAnalysis.getOutgoingInvocations();
		if (outgoingInvocations != null) {
			for (@NonNull RelationCallExp rInvocation : outgoingInvocations) {
				analyzeInvocationVariable(rInvocation);
			}
		}
		//
		//	Prepare a trace property for each invocation argument variable - typically just narrowing
		//	an indeterminate typed model to a specific one.
		/*
		Pattern rWhenPattern = relation.getWhen();
		if (rWhenPattern != null) {
			analyzePredicateVariables(rWhenPattern, true);
		}
		Pattern rWherePattern = relation.getWhere();
		if (rWherePattern != null) {
			analyzePredicateVariables(rWherePattern, false);
		} */
		Iterable<@NonNull RelationCallExp> outgoingWhereInvocations = relationAnalysis.getOutgoingWhereInvocations();
		if (outgoingWhereInvocations != null) {
			for (@NonNull RelationCallExp rInvocation : outgoingWhereInvocations) {
				//				analyzeInvocationVariable(rInvocation);
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
				if (!invokedRelation.isIsTopLevel()) {
					//					getInvocation2TraceProperty(rInvocation);
					getInvocation2TraceProperty(rInvocation).getTraceProperty();
				}
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

	protected void analyzeNonRootTemplateVariables(boolean manyTraces) {
		//
		//	Traverse the domain patterns to prepare a trace property for each bound variable.
		//
		// FIXME to handle the obscure case of a diamond traversal in which the second path discovers that
		//  unitOpposites apply, we should preferentially descend unit paths, deferring non-unit paths til later.
		//
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
				TypedModel rTypedModel = QVTrelationUtil.getTypedModel(rDomain);
				analyzeTemplateVariables(rTemplateExp, rTypedModel, !manyTraces);
			}
		}
	}

	/**
	 * Traverse a Pattern hierarchy to prepare/refine a trace property for each invocation argument variable.
	 *
	private void analyzePredicateVariables(@NonNull Pattern rPattern, boolean isWhen) {
		for (@NonNull Predicate rPredicate : QVTrelationUtil.getOwnedPredicates(rPattern)) {
			OCLExpression rConditionExpression = QVTrelationUtil.getConditionExpression(rPredicate);
			if (rConditionExpression instanceof RelationCallExp) {
				RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
				if (!invokedRelation.isIsTopLevel()) {
					String invocationPropertyName = isWhen ? nameGenerator.createWhenInvocationPropertyName(invokedRelation) : nameGenerator.createWhereInvocationPropertyName(invokedRelation);
					//					getInvocation2TraceProperty(invocationPropertyName, rInvocation);
				}
				else {
					List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
					for (int i = 0; i < rArguments.size(); i++) {
						OCLExpression rArgument = rArguments.get(i);
						if (rArgument instanceof VariableExp) {
							VariableDeclaration rVariable = QVTrelationUtil.getReferredVariable((VariableExp)rArgument);
							RelationDomain rDomain = QVTrelationUtil.getRelationCallExpArgumentDomain(rInvocation, i);
							getVariableDeclaration2TraceProperty(rDomain.getTypedModel(), rVariable, false);
						}
					}
				}
			}
		}
	} */

	protected void analyzeSharedVariables() {
		//
		//	Implicit/iterator variables do not have unit trace opposites.
		//
		for (@NonNull Variable rVariable : QVTrelationUtil.getOwnedVariables(relation)) {
			if (!(rVariable instanceof IteratorVariable) && !(rVariable instanceof TemplateVariable) && !rVariable.isIsImplicit()) {
				assert rVariable instanceof SharedVariable;
				getVariableDeclaration2TraceProperty(null, rVariable, false);
			}
		}
	}

	/**
	 * Descend the templateExp hierarchy to prepare a trace property for each bound variable.
	 */
	private void analyzeTemplateVariables(@NonNull TemplateExp templateExp, @NonNull TypedModel rTypedModel, boolean isOneToOne) {
		Variable templateVariable = QVTrelationUtil.getBindsTo(templateExp);
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = basicGetVariableDeclaration2TraceProperty(templateVariable);
		if (variableDeclaration2TraceProperty != null) {
			if (templateExp instanceof ObjectTemplateExp) {
				for (@NonNull PropertyTemplateItem rPropertyTemplateItem : QVTrelationUtil.getOwnedParts((ObjectTemplateExp)templateExp)) {
					boolean isNestedOneToOne = false;
					Property property = QVTrelationUtil.getReferredProperty(rPropertyTemplateItem);
					if (!property.isIsMany()) {
						Property oppositeProperty = property.getOpposite();
						if ((oppositeProperty != null) && !oppositeProperty.isIsMany()) {
							isNestedOneToOne = isOneToOne;
						}
					}
					OCLExpression valueExpression = QVTrelationUtil.getOwnedValue(rPropertyTemplateItem);
					if (valueExpression instanceof TemplateExp) {
						TemplateExp templateValueExpression = (TemplateExp)valueExpression;
						Variable itemVariable = QVTrelationUtil.getBindsTo(templateValueExpression);
						if (QVTrelationUtil.getElementalType(QVTrelationUtil.getType(itemVariable)) instanceof DataType) {
							getVariableDeclaration2TraceProperty(null, itemVariable, false);
						}
						else {
							assert itemVariable instanceof TemplateVariable;
							getVariableDeclaration2TraceProperty(rTypedModel, itemVariable, isNestedOneToOne);
							analyzeTemplateVariables(templateValueExpression, rTypedModel, isOneToOne);
						}
					}
					else if (valueExpression instanceof VariableExp) {
						VariableExp variableExpression = (VariableExp)valueExpression;
						Variable itemVariable = QVTrelationUtil.getReferredVariable(variableExpression);
						getVariableDeclaration2TraceProperty(null, itemVariable, isNestedOneToOne);
					}
				}
			}
			else if (templateExp instanceof CollectionTemplateExp) {
				for (@NonNull OCLExpression memberExpression : QVTrelationUtil.getOwnedMembers((CollectionTemplateExp)templateExp)) {
					if (memberExpression instanceof TemplateExp) {
						TemplateExp templateValueExpression = (TemplateExp)memberExpression;
						Variable itemVariable = QVTrelationUtil.getBindsTo(templateValueExpression);
						assert itemVariable instanceof TemplateVariable;
						getVariableDeclaration2TraceProperty(rTypedModel, itemVariable, false);
						analyzeTemplateVariables(templateValueExpression, rTypedModel, false);
					}
					else if (memberExpression instanceof VariableExp) {
						VariableExp variableExpression = (VariableExp)memberExpression;
						Variable itemVariable = QVTrelationUtil.getReferredVariable(variableExpression);
						getVariableDeclaration2TraceProperty(null, itemVariable, false);
					}
				}
			}
		}
	}

	public @NonNull String createInvocationClassName() {
		return relationAnalysis.getNameGenerator().createInvocationClassName(relation);
	}

	public @NonNull String createInvocationInterfaceName() {
		return relationAnalysis.getNameGenerator().createInvocationInterfaceName(relation);
	}

	public @NonNull Property createProperty(@NonNull String name, @NonNull Type type) {
		String uniqueName = QVTrNameGenerator.getUniqueName(name2element2traceProperty.keySet(), name);
		Property property = PivotUtil.createProperty(uniqueName, type);
		//FIXME		name2element2traceProperty.put(uniqueName, property);
		return property;
	}

	public @NonNull String createTraceInterfaceName() {
		return relationAnalysis.getNameGenerator().createTraceInterfaceName(relation);
	}

	@Override
	public @NonNull Invocation2TraceProperty getInvocation2TraceProperty(@NonNull RelationCallExp rInvocation) {
		Map<@NonNull RelationCallExp, @NonNull Invocation2TraceProperty> invocation2relation2traceProperty2 = invocation2relation2traceProperty;
		if (invocation2relation2traceProperty2 == null) {
			invocation2relation2traceProperty = invocation2relation2traceProperty2 = new HashMap<>();
		}
		Invocation2TraceProperty relation2traceProperty = invocation2relation2traceProperty2.get(rInvocation);
		if (relation2traceProperty == null) {
			Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
			Relation2TraceClass invokedRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(invokedRelation);
			relation2traceProperty = new Invocation2TraceProperty(this, invokedRelation2TraceClass.getRelation2InvocationClass());
			invocation2relation2traceProperty2.put(rInvocation, relation2traceProperty);
		}
		return relation2traceProperty;
	}

	@Override
	public @NonNull AbstractRelation2TraceClass getRelation2TraceClass() {
		return this;
	}

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return QVTrNameGenerator.getUniqueName(name2element2traceProperty, name, element2traceProperty);
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
		for (RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			if (!relationDomain.isIsEnforceable()) {
				for (EObject eObject : new TreeIterable(relationDomain, true)) {
					if (eObject instanceof PropertyTemplateItem) {
						Property referredProperty = QVTrelationUtil.getReferredProperty((PropertyTemplateItem)eObject);
						if (referredProperty.isIsMany()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	protected void reservePropertyName(@NonNull String name) {
		assert !name2element2traceProperty.containsKey(name);
		name2element2traceProperty.put(name, null);
	}

	@Override
	public void synthesize() {
		Map<@NonNull RelationCallExp, @NonNull Invocation2TraceProperty> invocation2relation2traceProperty2 = invocation2relation2traceProperty;
		if (invocation2relation2traceProperty2 != null) {
			for (@NonNull Invocation2TraceProperty relation2traceProperty : invocation2relation2traceProperty2.values()) {
				relation2traceProperty.synthesize();
			}
		}
		super.synthesize();
	}
}