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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;

/**
 * An AbstractRelation2TraceClass represents the mapping between a QVTr Relation and the future trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a top/non-top relation.
 */
abstract class AbstractRelation2TraceClass implements Relation2TraceClass
{
	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;

	/**
	 * The relation to be mapped to a trace class and mapping.
	 */
	protected final @NonNull Relation relation;

	/**
	 * The Class that realizes the middle model trace class.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class traceClass;

	/**
	 * The Class that realizes a signature interface to for a static invocation of this trace class.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class signatureClass = null;

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

	/**
	 * Name to corresponding future trace property
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Element2TraceProperty> name2element2traceProperty = new HashMap<>();

	/**
	 * Lazily created null-free Bag of traceClass.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class bagOfTraceClass = null;

	private @NonNull Map<@NonNull NamedElement, @NonNull Element2TraceProperty> element2element2traceProperty = new HashMap<>();

	protected AbstractRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		this.relationalTransformation2tracePackage = relationalTransformation2tracePackage;
		this.relation = relation;
		String traceClassName = relationalTransformation2tracePackage.getNameGenerator().createTraceClassName(relation);
		this.traceClass = PivotUtil.createClass(relationalTransformation2tracePackage.getUniqueTraceClassName(this, traceClassName));
		traceClass.setIsAbstract(relation.isIsAbstract());
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

	/**
	 * Traverse a Pattern hierarchy to prepare/refine a trace property for each invocation argument variable.
	 */
	private void analyzePredicateVariables(@NonNull Pattern rPattern) {
		for (@NonNull Predicate rPredicate : QVTrelationUtil.getOwnedPredicates(rPattern)) {
			OCLExpression rConditionExpression = QVTrelationUtil.getConditionExpression(rPredicate);
			if (rConditionExpression instanceof RelationCallExp) {
				RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
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

	@Override
	public void analyzeProperties() throws CompilerChainException {
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
		//
		//	Determine the trace variables and whether they have a to-one opposite
		//
		//
		//	Implicit/iterator variables do not have unit trace opposites.
		//
		for (@NonNull Variable rVariable : QVTrelationUtil.getOwnedVariables(relation)) {
			if (!(rVariable instanceof IteratorVariable) && !(rVariable instanceof TemplateVariable) && !rVariable.isIsImplicit()) {
				getVariableDeclaration2TraceProperty(null, rVariable, false);
			}
		}
		//
		//	Prepare a trace property for each root variable.
		//
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			TypedModel rTypedModel = rDomain.getTypedModel();
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
				Variable bindsTo = QVTrelationUtil.getBindsTo(rTemplateExp);
				getVariableDeclaration2TraceProperty(rTypedModel, bindsTo, !manyTraces);
			}
		}
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
		//
		//	Prepare a trace property for each invocation argument variable - typically just narrowing
		//	an indeterminate typed model to a specific one.
		//
		Pattern rWhenPattern = relation.getWhen();
		if (rWhenPattern != null) {
			analyzePredicateVariables(rWhenPattern);
		}
		Pattern rWherePattern = relation.getWhere();
		if (rWherePattern != null) {
			analyzePredicateVariables(rWherePattern);
		}
	}

	/**
	 * Descend the templateExp hierarchy to prepare a trace property for each bound variable.
	 */
	private void analyzeTemplateVariables(@NonNull TemplateExp templateExp, @NonNull TypedModel rTypedModel, boolean isOneToOne) {
		Variable templateVariable = QVTrelationUtil.getBindsTo(templateExp);
		if (element2element2traceProperty.containsKey(templateVariable)) {
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

	@Override
	public @Nullable Class basicGetSignatureClass() {
		return signatureClass;
	}

	@Override
	public @Nullable Property basicGetSignatureProperty(@NonNull NamedElement rNamedElement) {
		Element2TraceProperty variableDeclaration2TraceProperty = element2element2traceProperty.get(rNamedElement);
		if (variableDeclaration2TraceProperty == null) {
			return null;
		}
		return variableDeclaration2TraceProperty.getSignatureProperty();
	}

	@Override
	public @Nullable Property basicGetTraceProperty(@NonNull NamedElement rNamedElement) {
		Element2TraceProperty element2TraceProperty = element2element2traceProperty.get(rNamedElement);
		if (element2TraceProperty == null) {
			return null;
		}
		return element2TraceProperty.getTraceProperty();
	}

	@Override
	public int compareTo(@NonNull Relation2TraceClass that) {
		return ClassUtil.safeCompareTo(this.traceClass.getName(), that.getTraceClass().getName());
	}

	public @NonNull Property createTraceProperty(@Nullable TypedModel rTypedModel, org.eclipse.ocl.pivot.@NonNull Class owningClass,
			@NonNull String name, org.eclipse.ocl.pivot.@NonNull Class type, boolean isRequired, boolean unitOpposite) {
		String domainName = rTypedModel != null ? rTypedModel.getName() : null;
		Property traceProperty = PivotFactory.eINSTANCE.createProperty();
		traceProperty.setName(name);
		traceProperty.setType(type);
		traceProperty.setIsRequired(isRequired);
		if (domainName != null) {
			Annotation domainAnnotation = PivotFactory.eINSTANCE.createAnnotation();
			domainAnnotation.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE);
			Detail domainDetail = PivotFactory.eINSTANCE.createDetail();
			domainDetail.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN);
			domainDetail.getValues().add(domainName);
			domainAnnotation.getOwnedDetails().add(domainDetail);
			traceProperty.getOwnedAnnotations().add(domainAnnotation);
		}
		traceProperty.setOwningClass(owningClass);
		if (!(type instanceof DataType)) {
			Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
			oppositeProperty.setName(traceClass.getName());		// FIXME unique, mutable Class
			oppositeProperty.setType(unitOpposite ? traceClass : getBagOfTraceClass());
			oppositeProperty.setIsRequired(!unitOpposite);
			oppositeProperty.setIsImplicit(true);
			oppositeProperty.setOwningClass(type);
			traceProperty.setOpposite(oppositeProperty);
			oppositeProperty.setOpposite(traceProperty);
			//				putTrace(oppositeProperty, type);
		}
		//			putTrace(traceProperty, traceClass);
		return traceProperty;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getBagOfTraceClass() {
		Class bagOfTraceClass2 = bagOfTraceClass;
		if (bagOfTraceClass2 == null) {
			bagOfTraceClass = bagOfTraceClass2 = relationalTransformation2tracePackage.getBagType(traceClass);
		}
		return bagOfTraceClass2;
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
		Invocation2TraceProperty invocation2TraceProperty = new Invocation2TraceProperty(this, name, rInvocation);
		invocation2TraceProperty.getTraceProperty();
		Element2TraceProperty oldInvocation2TraceProperty = element2element2traceProperty.put(rInvocation, invocation2TraceProperty);
		assert oldInvocation2TraceProperty ==  null;
		return invocation2TraceProperty;
	}

	@Override
	public @NonNull QVTrNameGenerator getNameGenerator() {
		return relationalTransformation2tracePackage.getNameGenerator();
	}

	@Override
	public @NonNull Relation getRelation() {
		return relation;
	}

	@Override
	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return relationalTransformation2tracePackage;
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
	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
		return traceClass;
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
	public @NonNull String getUniqueTracePropertyName(@NonNull Element2TraceProperty variableDeclaration2TraceProperty, @NonNull String name) {
		return relationalTransformation2tracePackage.getNameGenerator().getUniqueName(name2element2traceProperty, name, variableDeclaration2TraceProperty);
	}

	private @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = (VariableDeclaration2TraceProperty) element2element2traceProperty.get(variable);
		if (variableDeclaration2TraceProperty != null) {
			variableDeclaration2TraceProperty.refineTraceProperty(rTypedModel, isNestedOneToOne);
		}
		else {
			variableDeclaration2TraceProperty = new VariableDeclaration2TraceProperty(this, rTypedModel, variable, isNestedOneToOne);
			element2element2traceProperty.put(variable, variableDeclaration2TraceProperty);
		}
		return variableDeclaration2TraceProperty;
	}

	@Override
	public @NonNull Iterable<@NonNull RelationCallExp> getWhenInvocations() {
		return whenInvocations;
	}

	@Override
	public @NonNull Iterable<@NonNull RelationCallExp> getWhereInvocations() {
		return whereInvocations;
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
	public void synthesize() {
		//
		//	Create a trace property for each prepared trace property.
		//
		for (@NonNull NamedElement traceVariable : element2element2traceProperty.keySet()) {
			Element2TraceProperty vd2tp = element2element2traceProperty.get(traceVariable);
			assert vd2tp != null;
			vd2tp.getTraceProperty();
		}
		for (@NonNull RelationCallExp whenInvocation : getWhenInvocations()) {
			Relation invokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
			if (!invokedRelation.isIsTopLevel()) {
				String name = getNameGenerator().createWhenInvocationPropertyName(invokedRelation);
				getInvocation2TraceProperty(name, whenInvocation);
			}
		}
		for (@NonNull RelationCallExp whereInvocation : getWhereInvocations()) {
			Relation invokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
			if (!invokedRelation.isIsTopLevel()) {
				String name = getNameGenerator().createWhereInvocationPropertyName(invokedRelation);
				getInvocation2TraceProperty(name, whereInvocation);
			}
		}
		CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedPropertiesList(traceClass));
		org.eclipse.ocl.pivot.Class signatureClass = basicGetSignatureClass();
		if (signatureClass != null) {
			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
				TypedModel rTypedModel = rDomain.getTypedModel();
				for (@NonNull Variable rootVariable : QVTrelationUtil.getRootVariables(rDomain)) {
					Element2TraceProperty rootVariableDeclaration2TraceProperty = element2element2traceProperty.get(rootVariable);
					assert rootVariableDeclaration2TraceProperty != null;
					rootVariableDeclaration2TraceProperty.getSignatureProperty();
				}
			}
			CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedPropertiesList(signatureClass));
		}
		/*		assert QVTrelationUtil.Internal.getOwnedPropertiesList(traceClass).size() == variable2variableDeclaration2traceProperty.size();
				for (@NonNull Property property : QVTrelationUtil.getOwnedProperties(traceClass)) {
			Property oppositeProperty = property.getOpposite();
			boolean isMany = property.isIsMany() || ((oppositeProperty != null) && oppositeProperty.isIsMany());
			boolean unitOpposite = (oppositeProperty != null) && !oppositeProperty.isIsMany();
			VariableDeclaration variable = NameUtil.getNameable(variable2variableDeclaration2traceProperty.keySet(), property.getName());
			if (variable != null) {
				VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = variable2variableDeclaration2traceProperty.get(variable);
				assert variableDeclaration2TraceProperty != null;
				if (variableDeclaration2TraceProperty.unitOpposite != unitOpposite) {
					System.out.println("Inconsistent " + property + " in " + relation);
				}
				else {
					System.out.println("Consistent " + property + " in " + relation);
				}
			}
			else {
				if (!isMany) {
					System.out.println("Inconsistent extra " + property + " in " + relation);
				}
				else {
					System.out.println("Missing " + property + " in " + relation);
				}
				//				assert property.isIsMany();
			}
		} */
	}

	@Override
	public String toString() {
		return traceClass.getName();
	}
}