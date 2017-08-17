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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
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

/**
 * An AbstractRelation2TraceClass represents the mapping between a QVTr Relation and the future trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a top/non-top relation.
 */
abstract class AbstractRelation2TraceClass extends AbstractRelation2MiddleClass implements Relation2TraceClass
{
	/**
	 * The Property that provides the success/failure/not-ready state of the traced mapping.
	 */
	private @Nullable Property successProperty = null;

	/**
	 * Each Relation2TraceClass which directly consumes this Relation2TraceClass.
	 */
	private final @NonNull List<@NonNull Relation2TraceClass> consumedByRelation2TraceClasses = new ArrayList<>();

	/**
	 * Each Relation2TraceClass which this Relation2TraceClass directly consumes.
	 */
	private final @NonNull List<@NonNull Relation2TraceClass> consumedRelation2TraceClasses = new ArrayList<>();

	/**
	 * Each Relation2TraceClass that transitively consumes this Relation2TraceClass.
	 */
	private @Nullable Set<@NonNull Relation2TraceClass> transitivelyConsumedByRelation2TraceClasses = null;

	/**
	 * Each Relation2TraceClass that is transitively consumed by this Relation2TraceClass.
	 */
	private @Nullable Set<@NonNull Relation2TraceClass> transitivelyConsumedRelation2TraceClasses = null;

	/**
	 * Each Relation2TraceClass that is both transitively consumed by and consumes this Relation2TraceClass.
	 */
	private @Nullable Set<@NonNull Relation2TraceClass> cyclicRelation2TraceClasses = null;

	/**
	 * RelationCallExp invocations within the when pattern.
	 */
	private final @NonNull List<@NonNull RelationCallExp> whenInvocations = new ArrayList<>();

	/**
	 * RelationCallExp invocations within the where pattern.
	 */
	private final @NonNull List<@NonNull RelationCallExp> whereInvocations = new ArrayList<>();

	private @NonNull Map<@NonNull RelationCallExp, @NonNull Invocation2TraceProperty> invocation2invocation2traceProperty = new HashMap<>();

	protected AbstractRelation2TraceClass(@NonNull RelationAnalysis relationAnalysis, @NonNull String traceClassName) {
		super(relationAnalysis, traceClassName);
		//		traceClass.setIsAbstract(relation.isIsAbstract());
		Pattern whenPattern = relation.getWhen();
		if (whenPattern != null) {
			for (@NonNull EObject whenExpression : new TreeIterable(whenPattern, false)) {
				if (whenExpression instanceof RelationCallExp) {
					whenInvocations.add((RelationCallExp)whenExpression);
				}
			}
		}
		Pattern wherePattern = relation.getWhere();
		if (wherePattern != null) {
			for (@NonNull EObject whereExpression : new TreeIterable(wherePattern, false)) {
				if (whereExpression instanceof RelationCallExp) {
					whereInvocations.add((RelationCallExp)whereExpression);
				}
			}
		}
		if (!relation.isIsAbstract()) {
			if (relation.getOverridden() != null) {
				getSuccessProperty();		// Overridden relation needs overriding success to control-execution.
			}
			else if (relationAnalysis.getIncomingWhenInvocations() != null) {
				getSuccessProperty();		// Invoking relation needs invoked success to control execution.
			}
		}
	}

	@Override
	public void addConsumedBy(@NonNull Relation2TraceClass consumedByRelation2TraceClass) {
		if (!consumedByRelation2TraceClasses.contains(consumedByRelation2TraceClass)) {
			consumedByRelation2TraceClasses.add(consumedByRelation2TraceClass);
		}
		consumedByRelation2TraceClass.addConsumedInternal(this);
	}

	@Override
	public void addConsumedInternal(@NonNull Relation2TraceClass consumedRelation2TraceClass) {
		if (!consumedRelation2TraceClasses.contains(consumedRelation2TraceClass)) {
			consumedRelation2TraceClasses.add(consumedRelation2TraceClass);
		}
	}

	@Override
	public void analyzeInheritance() {
		//		Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
		//		if (overriddenRelation != null) {
		//			Relation2TraceClass.@NonNull Internal overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation);
		//			traceClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceInterface());
		//		}
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

	protected void analyzePredicateVariables() {
		//
		//	Prepare a trace property for each invocation argument variable - typically just narrowing
		//	an indeterminate typed model to a specific one.
		//
		Pattern rWhenPattern = relation.getWhen();
		if (rWhenPattern != null) {
			analyzePredicateVariables(rWhenPattern, true);
		}
		Pattern rWherePattern = relation.getWhere();
		if (rWherePattern != null) {
			analyzePredicateVariables(rWherePattern, false);
		}
	}

	/**
	 * Traverse a Pattern hierarchy to prepare/refine a trace property for each invocation argument variable.
	 */
	private void analyzePredicateVariables(@NonNull Pattern rPattern, boolean isWhen) {
		for (@NonNull Predicate rPredicate : QVTrelationUtil.getOwnedPredicates(rPattern)) {
			OCLExpression rConditionExpression = QVTrelationUtil.getConditionExpression(rPredicate);
			if (rConditionExpression instanceof RelationCallExp) {
				RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
				if (!invokedRelation.isIsTopLevel()) {
					String invocationPropertyName = isWhen ? nameGenerator.createWhenInvocationPropertyName(invokedRelation) : nameGenerator.createWhereInvocationPropertyName(invokedRelation);
					getInvocation2TraceProperty(invocationPropertyName, rInvocation);
				}
				else {
					List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
					for (int i = 0; i < rArguments.size(); i++) {
						OCLExpression rArgument = rArguments.get(i);
						if (rArgument instanceof VariableExp) {
							VariableDeclaration rVariable = QVTrelationUtil.getReferredVariable((VariableExp)rArgument);
							RelationDomain rDomain = QVTrelationUtil.getRelationCallExpArgumentDomain(rInvocation, i);
							getVariableDeclaration2MiddleProperty(rDomain.getTypedModel(), rVariable, false);
						}
					}
				}
			}
		}
	}

	@Override
	public void analyzeProperties() throws CompilerChainException {
		boolean manyTraces = analyzeTraceMultiplicity();
		analyzeSharedVariables();
		analyzeRootTemplateVariables(manyTraces);
		analyzeNonRootTemplateVariables(manyTraces);
		analyzePredicateVariables();
	}

	protected void analyzeSharedVariables() {
		//
		//	Implicit/iterator variables do not have unit trace opposites.
		//
		for (@NonNull Variable rVariable : QVTrelationUtil.getOwnedVariables(relation)) {
			if (!(rVariable instanceof IteratorVariable) && !(rVariable instanceof TemplateVariable) && !rVariable.isIsImplicit()) {
				assert rVariable instanceof SharedVariable;
				getVariableDeclaration2MiddleProperty(null, rVariable, false);
			}
		}
	}

	/**
	 * Descend the templateExp hierarchy to prepare a trace property for each bound variable.
	 */
	private void analyzeTemplateVariables(@NonNull TemplateExp templateExp, @NonNull TypedModel rTypedModel, boolean isOneToOne) {
		Variable templateVariable = QVTrelationUtil.getBindsTo(templateExp);
		VariableDeclaration2MiddleProperty variableDeclaration2TraceProperty = basicGetVariableDeclaration2MiddleProperty(templateVariable);
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
							getVariableDeclaration2MiddleProperty(null, itemVariable, false);
						}
						else {
							assert itemVariable instanceof TemplateVariable;
							getVariableDeclaration2MiddleProperty(rTypedModel, itemVariable, isNestedOneToOne);
							analyzeTemplateVariables(templateValueExpression, rTypedModel, isOneToOne);
						}
					}
					else if (valueExpression instanceof VariableExp) {
						VariableExp variableExpression = (VariableExp)valueExpression;
						Variable itemVariable = QVTrelationUtil.getReferredVariable(variableExpression);
						getVariableDeclaration2MiddleProperty(null, itemVariable, isNestedOneToOne);
					}
				}
			}
			else if (templateExp instanceof CollectionTemplateExp) {
				for (@NonNull OCLExpression memberExpression : QVTrelationUtil.getOwnedMembers((CollectionTemplateExp)templateExp)) {
					if (memberExpression instanceof TemplateExp) {
						TemplateExp templateValueExpression = (TemplateExp)memberExpression;
						Variable itemVariable = QVTrelationUtil.getBindsTo(templateValueExpression);
						assert itemVariable instanceof TemplateVariable;
						getVariableDeclaration2MiddleProperty(rTypedModel, itemVariable, false);
						analyzeTemplateVariables(templateValueExpression, rTypedModel, false);
					}
					else if (memberExpression instanceof VariableExp) {
						VariableExp variableExpression = (VariableExp)memberExpression;
						Variable itemVariable = QVTrelationUtil.getReferredVariable(variableExpression);
						getVariableDeclaration2MiddleProperty(null, itemVariable, false);
					}
				}
			}
		}
	}

	@Override
	public @Nullable Iterable<@NonNull Relation2TraceClass> getConsumedByRelation2TraceClasses() {
		return consumedByRelation2TraceClasses;
	}

	@Override
	public @Nullable Iterable<@NonNull Relation2TraceClass> getConsumedRelation2TraceClasses() {
		return consumedRelation2TraceClasses;
	}

	@Override
	public @Nullable Iterable<@NonNull Relation2TraceClass> getCyclicRelation2TraceClasses() {
		return cyclicRelation2TraceClasses;
	}

	private Invocation2TraceProperty getInvocation2TraceProperty(@NonNull String name, @NonNull RelationCallExp rInvocation) {
		Invocation2TraceProperty invocation2TraceProperty = new Invocation2TraceProperty(this, name, QVTrelationUtil.getReferredRelation(rInvocation));
		invocation2TraceProperty.getMiddleProperty();
		Invocation2TraceProperty oldInvocation2TraceProperty = invocation2invocation2traceProperty.put(rInvocation, invocation2TraceProperty);
		assert oldInvocation2TraceProperty == null;
		return invocation2TraceProperty;
	}

	//	@Override
	protected @NonNull Property getSuccessProperty() {
		Property successProperty2 = successProperty;
		if (successProperty2 == null) {
			Type booleanType = relationalTransformation2tracePackage.getBooleanType();
			successProperty = successProperty2 = PivotUtil.createProperty(QVTrNameGenerator.TRACECLASS_SUCCESS_PROPERTY_NAME, booleanType);
			successProperty2.setIsRequired(false);
			middleClass.getOwnedProperties().add(successProperty2);
		}
		return successProperty2;
	}

	@Override
	public @NonNull Property getTraceProperty(@NonNull RelationCallExp rInvocation) {
		Invocation2TraceProperty invocation2TraceProperty = invocation2invocation2traceProperty.get(rInvocation);
		assert invocation2TraceProperty != null;
		return invocation2TraceProperty.getMiddleProperty();
	}

	@Override
	public @NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedByRelation2TraceClasses() {
		Set<@NonNull Relation2TraceClass> transitivelyConsumedByRelation2TraceClasses2 = transitivelyConsumedByRelation2TraceClasses;
		if (transitivelyConsumedByRelation2TraceClasses2 == null) {
			transitivelyConsumedByRelation2TraceClasses2 = getTransitivelyConsumedByRelation2TraceClasses(new HashSet<>());
		}
		return transitivelyConsumedByRelation2TraceClasses2;
	}
	@Override
	public @NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedByRelation2TraceClasses(@NonNull Set<@NonNull Relation2TraceClass> accumulator) {
		Set<@NonNull Relation2TraceClass> transitivelyConsumedByRelation2TraceClasses2 = this.transitivelyConsumedByRelation2TraceClasses;
		if (transitivelyConsumedByRelation2TraceClasses2 != null) {
			accumulator.addAll(transitivelyConsumedByRelation2TraceClasses2);
		}
		else {
			for (@NonNull Relation2TraceClass consumedByRelation2TraceClass : consumedByRelation2TraceClasses) {
				if (accumulator.add(consumedByRelation2TraceClass)) {
					consumedByRelation2TraceClass.getTransitivelyConsumedByRelation2TraceClasses(accumulator);
				}
			}
		}
		return accumulator;
	}

	@Override
	public @NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedRelation2TraceClasses() {
		Set<@NonNull Relation2TraceClass> transitivelyConsumedRelation2TraceClasses2 = transitivelyConsumedRelation2TraceClasses;
		if (transitivelyConsumedRelation2TraceClasses2 == null) {
			transitivelyConsumedRelation2TraceClasses2 = getTransitivelyConsumedRelation2TraceClasses(new HashSet<>());
		}
		return transitivelyConsumedRelation2TraceClasses2;
	}
	@Override
	public @NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedRelation2TraceClasses(@NonNull Set<@NonNull Relation2TraceClass> accumulator) {
		Set<@NonNull Relation2TraceClass> transitivelyConsumedRelation2TraceClasses2 = this.transitivelyConsumedRelation2TraceClasses;
		if (transitivelyConsumedRelation2TraceClasses2 != null) {
			accumulator.addAll(transitivelyConsumedRelation2TraceClasses2);
		}
		else {
			for (@NonNull Relation2TraceClass consumedRelation2TraceClass : consumedRelation2TraceClasses) {
				if (accumulator.add(consumedRelation2TraceClass)) {
					consumedRelation2TraceClass.getTransitivelyConsumedRelation2TraceClasses(accumulator);
				}
			}
		}
		return accumulator;
	}

	@Override
	public @NonNull Iterable<@NonNull RelationCallExp> getWhenInvocations() {
		return whenInvocations;
	}

	@Override
	public @NonNull Iterable<@NonNull RelationCallExp> getWhereInvocations() {
		return whereInvocations;
	}

	//		public void installConsumedByDependencies() {
	//			for (@NonNull Relation2TraceClass consumedRelation2TraceClass : getTransitivelyConsumedRelation2TraceClasses()) {
	//				ClassUtil.nonNullState(consumedRelation2TraceClass.transitivelyConsumedByRelation2TraceClasses).add(this);
	//			}
	//		}

	/*		public void installDependencyCycles() throws CompilerChainException {
		Set<@NonNull Relation2TraceClass> cyclicRelation2TraceClasses2 = cyclicRelation2TraceClasses = new HashSet<>(getTransitivelyConsumedByRelation2TraceClasses());
		cyclicRelation2TraceClasses2.retainAll(getTransitivelyConsumedRelation2TraceClasses());
		if (!cyclicRelation2TraceClasses2.isEmpty()) {
			traceClass.getSuperClasses().add(relationalTransformation2tracePackage.getSpeculatableClass());
		}
	} */

	@Override
	public void installConsumesDependencies() throws CompilerChainException {
		/*		for (@NonNull RelationCallExp whenInvocation : whenInvocations) {
			Relation whenInvokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
			if (whenInvokedRelation.isIsTopLevel()) {
				Relation2TraceClass.@NonNull Internal invokedRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(whenInvokedRelation);
				invokedRelation2TraceClass.addConsumedBy(this);
			}
			else {
				for (Relation2TraceClass.@NonNull Internal invocation2TraceClass : relationalTransformation2tracePackage.getInvocation2TraceClasses(whenInvocation)) {
					addConsumedBy(invocation2TraceClass);
					invocation2TraceClass.addConsumedBy(this);
				}
			}
		}
		for (@NonNull RelationCallExp whereInvocation : whereInvocations) {
			Relation whereInvokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
			if (whereInvokedRelation.isIsTopLevel()) {
				Relation2TraceClass.@NonNull Internal invokedRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(whereInvokedRelation);
				invokedRelation2TraceClass.addConsumedBy(this);
			}
			else {
				for (Relation2TraceClass.@NonNull Internal invocation2TraceClass : relationalTransformation2tracePackage.getInvocation2TraceClasses(whereInvocation)) {
					addConsumedBy(invocation2TraceClass);
					invocation2TraceClass.addConsumedBy(this);
				}
			}
		} */
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class synthesize() {
		super.synthesize();
		CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedPropertiesList(middleClass));
		return middleClass;
	}
}