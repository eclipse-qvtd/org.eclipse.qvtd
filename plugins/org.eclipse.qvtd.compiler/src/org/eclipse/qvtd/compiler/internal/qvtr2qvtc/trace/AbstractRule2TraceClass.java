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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;

/**
 * An AbstractRule2TraceClass represents the mapping between a Relation or RelationCallExp and a TraceClass/Mapping
 */
abstract class AbstractRule2TraceClass implements Rule2TraceClass.Internal
{
	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;

	/**
	 * The relation to be mapped to a trace class and mapping.
	 */
	protected final @NonNull Relation relation;

	/**
	 * RelationCallExp invocations within the when pattern.
	 */
	private final @NonNull List<@NonNull RelationCallExp> whenInvocations = new ArrayList<>();

	/**
	 * RelationCallExp invocations within the where pattern.
	 */
	private final @NonNull List<@NonNull RelationCallExp> whereInvocations = new ArrayList<>();

	/**
	 * The Class that realizes the middle model trace class.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class traceClass = ClassUtil.nonNullState(PivotFactory.eINSTANCE.createClass());

	/**
	 * Lazily created null-free Bag of traceClass.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class bagOfTraceClass = null;

	/**
	 * Map from trace property name to trace property.
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Property> name2property = new HashMap<>();

	/**
	 * Each Rule2TraceClass which directly consumes this Rule2TraceClass.
	 */
	private final @NonNull List<Rule2TraceClass.@NonNull Internal> consumedByRule2traceClasses = new ArrayList<>();

	/**
	 * Each Rule2TraceClass which this Rule2TraceClass directly consumes.
	 */
	private final @NonNull List<Rule2TraceClass.@NonNull Internal> consumedRule2traceClasses = new ArrayList<>();

	/**
	 * Each Rule2TraceClass that transitively consumes this Rule2TraceClass.
	 */
	private @Nullable Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedByRule2traceClasses = null;

	/**
	 * Each Rule2TraceClass that is transitively consumed by this Rule2TraceClass.
	 */
	private @Nullable Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedRule2traceClasses = null;

	/**
	 * Each Rule2TraceClass that is both transitively consumed by and consumes this Rule2TraceClass.
	 */
	private @Nullable Set<Rule2TraceClass.@NonNull Internal> cyclicRule2traceClasses = null;

	public AbstractRule2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		this.relationalTransformation2tracePackage = relationalTransformation2tracePackage;
		this.relation = relation;
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

	protected void addAllProperties(Rule2TraceClass.@NonNull Internal superRelation2TraceClass) {
		name2property.putAll(superRelation2TraceClass.getName2property());
	}

	@Override
	public void addConsumedBy(Rule2TraceClass.@NonNull Internal consumedByRule2traceClass) {
		if (!consumedByRule2traceClasses.contains(consumedByRule2traceClass)) {
			consumedByRule2traceClasses.add(consumedByRule2traceClass);
		}
		consumedByRule2traceClass.addConsumedInternal(this);
	}

	@Override
	public void addConsumedInternal(Rule2TraceClass.@NonNull Internal consumedRule2traceClass) {
		if (!consumedRule2traceClasses.contains(consumedRule2traceClass)) {
			consumedRule2traceClasses.add(consumedRule2traceClass);
		}
	}

	@Override
	public int compareTo(@NonNull Rule2TraceClass that) {
		return ClassUtil.safeCompareTo(this.traceClass.getName(), that.getTraceClass().getName());
	}

	private void createTraceProperty(@Nullable Domain rDomain, @NonNull TypedElement tv, boolean manyTraces) throws CompilerChainException {
		String vn = QVTrelationUtil.getName(tv);
		Type c = QVTrelationUtil.getType(tv);
		createTraceProperty(rDomain, vn, c, tv.isIsRequired(), manyTraces);
	}

	/**
	 * Lazily create the name Property for a traceClass with a type. If manyTraces is set there may be many trace class instances referencing the same object through
	 * the trace property and so the implicit opposite must be a Bag.
	 */
	private void createTraceProperty(@Nullable Domain rDomain, @NonNull String name, @NonNull Type type, boolean isRequired, boolean manyTraces) throws CompilerChainException {
		Property traceProperty = name2property.get(name);
		if (traceProperty != null) {
			if ((type != traceProperty.getType()) || isRequired != traceProperty.isIsRequired()) {
				throw new CompilerChainException("Inconsistent redefined property '" + name + "' for " + relation);
			}
		}
		else {
			traceProperty = PivotFactory.eINSTANCE.createProperty();
			traceProperty.setName(name);
			traceProperty.setType(type);
			traceProperty.setIsRequired(isRequired);
			if (rDomain != null) {
				Annotation domainAnnotation = PivotFactory.eINSTANCE.createAnnotation();
				domainAnnotation.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE);
				Detail domainDetail = PivotFactory.eINSTANCE.createDetail();
				domainDetail.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN);
				domainDetail.getValues().add(rDomain.getName());
				domainAnnotation.getOwnedDetails().add(domainDetail);
				traceProperty.getOwnedAnnotations().add(domainAnnotation);
			}
			name2property.put(name, traceProperty);
			traceProperty.setOwningClass(traceClass);
			if (!(type instanceof DataType)) {
				Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
				oppositeProperty.setName(traceClass.getName());		// FIXME unique, mutable Class
				oppositeProperty.setType(manyTraces ? getBagOfTraceClass() : traceClass);
				oppositeProperty.setIsRequired(manyTraces);
				//				oppositeProperty.setType(traceClass);
				//				oppositeProperty.setIsRequired(false);
				oppositeProperty.setIsImplicit(true);
				oppositeProperty.setOwningClass((org.eclipse.ocl.pivot.@NonNull Class)type);
				traceProperty.setOpposite(oppositeProperty);
				oppositeProperty.setOpposite(traceProperty);
				//				putTrace(oppositeProperty, type);
			}
			//			putTrace(traceProperty, traceClass);
		}
	}

	/**
	 * Returns true if there are many subtemplate matches.  If manyTraces is set there may be many trace class instances referencing the same objects
	 * and so the implicit opposites must be Bags. Only very simple patterns with pedantically 1:1 relationships can avoid the Bags.
	 * @throws CompilerChainException
	 */
	private boolean doSubTemplateToTraceClassProps(@NonNull Domain rDomain, @NonNull TemplateExp te, boolean manyTraces) throws CompilerChainException {
		Variable tv = QVTrelationUtil.getBindsTo(te);
		if (te instanceof CollectionTemplateExp) {
			CollectionTemplateExp cte = (CollectionTemplateExp) te;
			Variable collectionVariable = QVTrelationUtil.getBindsTo(cte);
			CollectionType collectionType = (CollectionType)QVTrelationUtil.getType(collectionVariable);
			Type elementType = QVTrelationUtil.getElementType(collectionType);
			int argIndex = 0;
			for (@NonNull OCLExpression m : QVTrelationUtil.getOwnedMembers(cte)) {
				if (m instanceof TemplateExp) {
					if (doSubTemplateToTraceClassProps(rDomain, (TemplateExp)m, manyTraces)) {
						//						manyTraces = true;
					}
				}
				else if (!(m instanceof VariableExp)) {
					createTraceProperty(rDomain, collectionVariable.getName() + "_" + argIndex, elementType, collectionType.isIsNullFree(), false);
				}
				argIndex++;
			}
			//			Variable rv = cte.getRest();
			//			if (rv != null) {
			//				createTraceProperty(rDomain, rc, rv, isMany);
			//			}
			createTraceProperty(rDomain, tv, manyTraces);			// ?? not required for CollectionTemplateExp's
		}
		else if (te instanceof ObjectTemplateExp) {
			ObjectTemplateExp ote = (ObjectTemplateExp) te;
			for (@NonNull PropertyTemplateItem pt : QVTrelationUtil.getOwnedParts(ote)) {
				Property referredProperty = QVTrelationUtil.getReferredProperty(pt);
				if (referredProperty.isIsMany()) {
					manyTraces = true;
				}
				OCLExpression value = QVTrelationUtil.getOwnedValue(pt);
				if (value instanceof TemplateExp) {
					Property oppositeProperty = referredProperty.getOpposite();
					boolean nestedManyTraces = manyTraces;
					if ((oppositeProperty != null) && oppositeProperty.isIsMany()) {
						nestedManyTraces = true;
					}
					if (doSubTemplateToTraceClassProps(rDomain, (TemplateExp)value, nestedManyTraces)) {
						//						manyTraces = true;
					}
				}
			}
			createTraceProperty(rDomain, tv, manyTraces);			// ?? not required for CollectionTemplateExp's
		}
		return manyTraces;
	}

	protected org.eclipse.ocl.pivot.@NonNull Class getBagOfTraceClass() {
		Class bagOfTraceClass2 = bagOfTraceClass;
		if (bagOfTraceClass2 == null) {
			bagOfTraceClass = bagOfTraceClass2 = relationalTransformation2tracePackage.getBagType(traceClass);
		}
		return bagOfTraceClass2;
	}

	@Override
	public @Nullable Iterable<Rule2TraceClass.@NonNull Internal> getConsumedByRule2traceClasses() {
		return consumedByRule2traceClasses;
	}

	@Override
	public @Nullable Iterable<Rule2TraceClass.@NonNull Internal> getConsumedRule2traceClasses() {
		return consumedRule2traceClasses;
	}

	@Override
	public @Nullable Iterable<Rule2TraceClass.@NonNull Internal> getCyclicRule2traceClasses() {
		return cyclicRule2traceClasses;
	}

	@Override
	public @NonNull Map<@NonNull String, @NonNull Property> getName2property() {
		return name2property;
	}

	public @NonNull Relation getRelation() {
		return relation;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
		return traceClass;
	}

	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedByRule2traceClasses() {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedByRule2traceClasses2 = transitivelyConsumedByRule2traceClasses;
		if (transitivelyConsumedByRule2traceClasses2 == null) {
			transitivelyConsumedByRule2traceClasses2 = getTransitivelyConsumedByRule2traceClasses(new HashSet<>());
		}
		return transitivelyConsumedByRule2traceClasses2;
	}
	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedByRule2traceClasses(@NonNull Set<Rule2TraceClass.@NonNull Internal> accumulator) {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedByRule2traceClasses2 = this.transitivelyConsumedByRule2traceClasses;
		if (transitivelyConsumedByRule2traceClasses2 != null) {
			accumulator.addAll(transitivelyConsumedByRule2traceClasses2);
		}
		else {
			for (Rule2TraceClass.@NonNull Internal consumedByRule2traceClass : consumedByRule2traceClasses) {
				if (accumulator.add(consumedByRule2traceClass)) {
					consumedByRule2traceClass.getTransitivelyConsumedByRule2traceClasses(accumulator);
				}
			}
		}
		return accumulator;
	}

	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedRule2traceClasses() {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedRule2traceClasses2 = transitivelyConsumedRule2traceClasses;
		if (transitivelyConsumedRule2traceClasses2 == null) {
			transitivelyConsumedRule2traceClasses2 = getTransitivelyConsumedRule2traceClasses(new HashSet<>());
		}
		return transitivelyConsumedRule2traceClasses2;
	}
	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedRule2traceClasses(@NonNull Set<Rule2TraceClass.@NonNull Internal> accumulator) {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedRule2traceClasses2 = this.transitivelyConsumedRule2traceClasses;
		if (transitivelyConsumedRule2traceClasses2 != null) {
			accumulator.addAll(transitivelyConsumedRule2traceClasses2);
		}
		else {
			for (Rule2TraceClass.@NonNull Internal consumedRule2traceClass : consumedRule2traceClasses) {
				if (accumulator.add(consumedRule2traceClass)) {
					consumedRule2traceClass.getTransitivelyConsumedRule2traceClasses(accumulator);
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
	public void installConsumesDependencies() throws CompilerChainException {
		for (@NonNull RelationCallExp whenInvocation : whenInvocations) {
			Relation whenInvokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
			if (whenInvokedRelation.isIsTopLevel()) {
				Rule2TraceClass.@NonNull Internal invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(whenInvokedRelation);
				invokedRelation2TraceClass.addConsumedBy(this);
			}
			else {
				Rule2TraceClass.@NonNull Internal invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(whenInvocation);
				addConsumedBy(invocation2TraceClass);
				invocation2TraceClass.addConsumedBy(this);
			}
		}
		for (@NonNull RelationCallExp whereInvocation : whereInvocations) {
			Relation whereInvokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
			if (whereInvokedRelation.isIsTopLevel()) {
				Rule2TraceClass.@NonNull Internal invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(whereInvokedRelation);
				invokedRelation2TraceClass.addConsumedBy(this);
			}
			else {
				Rule2TraceClass.@NonNull Internal invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(whereInvocation);
				addConsumedBy(invocation2TraceClass);
				invocation2TraceClass.addConsumedBy(this);
			}
		}
	}

	//		public void installConsumedByDependencies() {
	//			for (@NonNull Rule2TraceClass consumedRule2traceClass : getTransitivelyConsumedRule2traceClasses()) {
	//				ClassUtil.nonNullState(consumedRule2traceClass.transitivelyConsumedByRule2traceClasses).add(this);
	//			}
	//		}

	/*		public void installDependencyCycles() throws CompilerChainException {
		Set<@NonNull Rule2TraceClass> cyclicRule2traceClasses2 = cyclicRule2traceClasses = new HashSet<>(getTransitivelyConsumedByRule2traceClasses());
		cyclicRule2traceClasses2.retainAll(getTransitivelyConsumedRule2traceClasses());
		if (!cyclicRule2traceClasses2.isEmpty()) {
			traceClass.getSuperClasses().add(relationalTransformation2tracePackage.getSpeculatableClass());
		}
	} */

	@Override
	public String toString() {
		return traceClass.getName();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class transform() throws CompilerChainException {
		Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
		if (overriddenRelation != null) {
			Rule2TraceClass.@NonNull Internal overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(overriddenRelation);
			addAllProperties(overriddenRelation2TraceClass);
			traceClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceClass());
		}

		for (@NonNull Variable rVariable : relationalTransformation2tracePackage.getMiddleDomainVariables(relation))  {
			createTraceProperty(null, rVariable, false);
		}
		/*			if (invocation != null) {
			for (@NonNull Variable rVariable : VariablesAnalysis.getMiddleDomainVariables(QVTrelationUtil.getReferredRelation(invocation)))  {
				createTraceProperty(null, traceClass, rVariable, false);
			}
		} */
		//			if (consumedByRule2traceClasses.size() > 0) {
		//				Type booleanType = relationalTransformation2tracePackage.qvtr2qvtc.getStandardLibrary().getBooleanType();
		//				createTraceProperty(null, traceClass, QVTrNameGenerator.TRACECLASS_SUCCESS_PROPERTY_NAME, booleanType, true, false);
		//				assert relationalTransformation2tracePackage.speculatableClass != null;
		//				traceClass.getSuperClasses().add(relationalTransformation2tracePackage.speculatableClass);
		//			}
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
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
				doSubTemplateToTraceClassProps(rDomain, rTemplateExp, manyTraces);
			}
		}
		Pattern rWhenPattern = relation.getWhen();
		if (rWhenPattern != null) {
			for (@NonNull Predicate rWhenPredicate : QVTrelationUtil.getOwnedPredicates(rWhenPattern)) {
				OCLExpression rConditionExpression = QVTrelationUtil.getConditionExpression(rWhenPredicate);
				if (rConditionExpression instanceof RelationCallExp) {
					RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
					List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
					for (int i = 0; i < rArguments.size(); i++) {
						OCLExpression rArgument = rArguments.get(i);
						if (rArgument instanceof VariableExp) {
							VariableDeclaration rVariable = ((VariableExp)rArgument).getReferredVariable();
							assert rVariable != null;
							RelationDomain rDomain = QVTrelationUtil.getRelationCallExpArgumentDomain(rInvocation, i);
							createTraceProperty(rDomain, rVariable, manyTraces);
							//							createTraceProperty(rDomain, rVariable.getType(), rVariable, isMany);			// ?? not required for CollectionTemplateExp's
						}
					}
				}
			}
		}
		CompilerUtil.normalizeNameables(ClassUtil.nullFree(traceClass.getOwnedProperties()));
		return traceClass;
	}
}