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
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
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
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * RelationalTransformationToTracePackage performs the first part of the QVTr2QVTc transformation.
 * This involves synthesis of the QVTc middle model that defines the trace classes.
 */
public class RelationalTransformation2TracePackage
{
	/**
	 * A Rule2TraceClass represents the mapping between a Relation or RelationCallExp and a TraceClass/Mapping
	 */
	protected abstract static class Rule2TraceClass implements Comparable<@NonNull Rule2TraceClass>
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
		private final @NonNull List<@NonNull Rule2TraceClass> consumedByRule2traceClasses = new ArrayList<>();

		/**
		 * Each Rule2TraceClass which this Rule2TraceClass directly consumes.
		 */
		private final @NonNull List<@NonNull Rule2TraceClass> consumedRule2traceClasses = new ArrayList<>();

		/**
		 * Each Rule2TraceClass that transitively consumes this Rule2TraceClass.
		 */
		private @Nullable Set<@NonNull Rule2TraceClass> transitivelyConsumedByRule2traceClasses = null;

		/**
		 * Each Rule2TraceClass that is transitively consumed by this Rule2TraceClass.
		 */
		private @Nullable Set<@NonNull Rule2TraceClass> transitivelyConsumedRule2traceClasses = null;

		/**
		 * Each Rule2TraceClass that is both transitively consumed by and consumes this Rule2TraceClass.
		 */
		private @Nullable Set<@NonNull Rule2TraceClass> cyclicRule2traceClasses = null;

		public Rule2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
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

		public void addConsumedBy(@NonNull Rule2TraceClass consumedByRule2traceClass) {
			if (!consumedByRule2traceClasses.contains(consumedByRule2traceClass)) {
				consumedByRule2traceClasses.add(consumedByRule2traceClass);
			}
			if (!consumedByRule2traceClass.consumedRule2traceClasses.contains(this)) {
				consumedByRule2traceClass.consumedRule2traceClasses.add(this);
			}
		}

		@Override
		public int compareTo(@NonNull Rule2TraceClass that) {
			return ClassUtil.safeCompareTo(this.traceClass.getName(), that.traceClass.getName());
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

		public @Nullable Iterable<@NonNull Rule2TraceClass> getConsumedByRule2traceClasses() {
			return consumedByRule2traceClasses;
		}

		public @Nullable Iterable<@NonNull Rule2TraceClass> getConsumedRule2traceClasses() {
			return consumedRule2traceClasses;
		}

		public @Nullable Iterable<@NonNull Rule2TraceClass> getCyclicRule2traceClasses() {
			return cyclicRule2traceClasses;
		}

		public @NonNull Relation getRelation() {
			return relation;
		}

		public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
			return traceClass;
		}

		public @NonNull Set<@NonNull Rule2TraceClass> getTransitivelyConsumedByRule2traceClasses() {
			Set<@NonNull Rule2TraceClass> transitivelyConsumedByRule2traceClasses2 = transitivelyConsumedByRule2traceClasses;
			if (transitivelyConsumedByRule2traceClasses2 == null) {
				transitivelyConsumedByRule2traceClasses2 = getTransitivelyConsumedByRule2traceClasses(new HashSet<>());
			}
			return transitivelyConsumedByRule2traceClasses2;
		}
		private @NonNull Set<@NonNull Rule2TraceClass> getTransitivelyConsumedByRule2traceClasses(@NonNull Set<@NonNull Rule2TraceClass> accumulator) {
			Set<@NonNull Rule2TraceClass> transitivelyConsumedByRule2traceClasses2 = this.transitivelyConsumedByRule2traceClasses;
			if (transitivelyConsumedByRule2traceClasses2 != null) {
				accumulator.addAll(transitivelyConsumedByRule2traceClasses2);
			}
			else {
				for (@NonNull Rule2TraceClass consumedByRule2traceClass : consumedByRule2traceClasses) {
					if (accumulator.add(consumedByRule2traceClass)) {
						consumedByRule2traceClass.getTransitivelyConsumedByRule2traceClasses(accumulator);
					}
				}
			}
			return accumulator;
		}

		public @NonNull Set<@NonNull Rule2TraceClass> getTransitivelyConsumedRule2traceClasses() {
			Set<@NonNull Rule2TraceClass> transitivelyConsumedRule2traceClasses2 = transitivelyConsumedRule2traceClasses;
			if (transitivelyConsumedRule2traceClasses2 == null) {
				transitivelyConsumedRule2traceClasses2 = getTransitivelyConsumedRule2traceClasses(new HashSet<>());
			}
			return transitivelyConsumedRule2traceClasses2;
		}
		private @NonNull Set<@NonNull Rule2TraceClass> getTransitivelyConsumedRule2traceClasses(@NonNull Set<@NonNull Rule2TraceClass> accumulator) {
			Set<@NonNull Rule2TraceClass> transitivelyConsumedRule2traceClasses2 = this.transitivelyConsumedRule2traceClasses;
			if (transitivelyConsumedRule2traceClasses2 != null) {
				accumulator.addAll(transitivelyConsumedRule2traceClasses2);
			}
			else {
				for (@NonNull Rule2TraceClass consumedRule2traceClass : consumedRule2traceClasses) {
					if (accumulator.add(consumedRule2traceClass)) {
						consumedRule2traceClass.getTransitivelyConsumedRule2traceClasses(accumulator);
					}
				}
			}
			return accumulator;
		}

		public @NonNull Iterable<@NonNull RelationCallExp> getWhenInvocations() {
			return whenInvocations;
		}

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
			for (EObject eObject : new TreeIterable(relation, true)) {
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

		public void installConsumesDependencies() throws CompilerChainException {
			for (@NonNull RelationCallExp whenInvocation : whenInvocations) {
				Relation whenInvokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
				if (whenInvokedRelation.isIsTopLevel()) {
					Rule2TraceClass invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(whenInvokedRelation);
					invokedRelation2TraceClass.addConsumedBy(this);
				}
				else {
					Rule2TraceClass invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(whenInvocation);
					addConsumedBy(invocation2TraceClass);
					invocation2TraceClass.addConsumedBy(this);
				}
			}
			for (@NonNull RelationCallExp whereInvocation : whereInvocations) {
				Relation whereInvokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
				if (whereInvokedRelation.isIsTopLevel()) {
					Rule2TraceClass invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(whereInvokedRelation);
					invokedRelation2TraceClass.addConsumedBy(this);
				}
				else {
					Rule2TraceClass invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(whereInvocation);
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

		public org.eclipse.ocl.pivot.@NonNull Class transform() throws CompilerChainException {
			Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
			if (overriddenRelation != null) {
				Rule2TraceClass overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(overriddenRelation);
				name2property.putAll(overriddenRelation2TraceClass.name2property);
				traceClass.getSuperClasses().add(overriddenRelation2TraceClass.traceClass);
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

	/**
	 * A AbstractRelation2TraceClass represents the mapping between a QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
	 */
	protected static abstract class AbstractRelation2TraceClass extends Rule2TraceClass
	{
		protected AbstractRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
			super(relationalTransformation2tracePackage, relation);
			String name = "T" + relation.getName();
			traceClass.setName(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
		}

		/*		@Override
		public void installConsumesDependencies() throws CompilerChainException {
			Iterable<@NonNull RelationCallExp> rWhenInvocations = relationalTransformation2tracePackage.qvtr2qvtc.getWhenInvocationsOf(relation);
			if (rWhenInvocations != null) {
				for (@NonNull RelationCallExp rWhenInvocation : rWhenInvocations) {
					//					Rule2TraceClass invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(rWhenInvocation);
					Relation rInvokingRelation = QVTrelationUtil.getContainingRelation(rWhenInvocation);
					Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(rInvokingRelation);
					invokingRelation2TraceClass.addConsumer(this);		// invoker consumers the invoked result
					//					addConsumer(invokingRelation2TraceClass);
				}
			}
			Iterable<@NonNull RelationCallExp> rWhereInvocations = relationalTransformation2tracePackage.qvtr2qvtc.getWhereInvocationsOf(relation);
			if (rWhereInvocations != null) {
				for (@NonNull RelationCallExp rWhereInvocation : rWhereInvocations) {
					//					Rule2TraceClass invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(rWhenInvocation);
					Relation rInvokingRelation = QVTrelationUtil.getContainingRelation(rWhereInvocation);
					Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(rInvokingRelation);
					addConsumer(invokingRelation2TraceClass);
				}
			}
		} */
	}

	/**
	 * A NonTopRelation2TraceClass represents the mapping between a non-top level QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
	 */
	protected static class NonTopRelation2TraceClass extends AbstractRelation2TraceClass
	{
		protected NonTopRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
			super(relationalTransformation2tracePackage, relation);
			//			traceClass.setIsAbstract(true);
		}
	}

	/**
	 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
	 */
	protected static class TopRelation2TraceClass extends AbstractRelation2TraceClass
	{
		protected TopRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
			super(relationalTransformation2tracePackage, relation);
		}
	}

	/**
	 * A AbstractInvocation2TraceClass represents the mapping between an invoked QVTr Relation and a QVTr mapping trace class.
	 */
	protected static abstract class AbstractInvocation2TraceClass extends Rule2TraceClass
	{
		protected final @NonNull Relation invokingRelation;

		protected AbstractInvocation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage,
				@NonNull Relation invokedRelation, @NonNull Relation invokingRelation) throws CompilerChainException {
			super(relationalTransformation2tracePackage, invokedRelation);
			this.invokingRelation = invokingRelation;
		}
	}

	/**
	 * A WhenInvocation2TraceClass represents the mapping between an when-invoked QVTr Relation and a QVTr mapping trace class.
	 */
	protected static class WhenInvocation2TraceClass extends AbstractInvocation2TraceClass
	{
		protected WhenInvocation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage,
				@NonNull Relation invokedRelation, @NonNull Relation invokingRelation) throws CompilerChainException {
			super(relationalTransformation2tracePackage, invokedRelation, invokingRelation);
			String name = "T" + invokingRelation.getName() + "_when_" + invokedRelation.getName();
			traceClass.setName(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
			Rule2TraceClass superRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokedRelation);
			traceClass.getSuperClasses().add(superRelation2TraceClass.getTraceClass());
			name2property.putAll(superRelation2TraceClass.name2property);
		}

		//		@Override
		//		public void installConsumesDependencies() throws CompilerChainException {
		//			Rule2TraceClass invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(relation);
		//			Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokingRelation);
		//			invokedRelation2TraceClass.addConsumer(this);
		//			invokingRelation2TraceClass.addConsumer(this);
		//		}
	}

	/**
	 * A WhereInvocation2TraceClass represents the mapping between an where-invoked QVTr Relation and a QVTr mapping trace class.
	 */
	protected static class WhereInvocation2TraceClass extends AbstractInvocation2TraceClass
	{
		protected WhereInvocation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage,
				@NonNull Relation invokedRelation, @NonNull Relation invokingRelation) throws CompilerChainException {
			super(relationalTransformation2tracePackage, invokedRelation, invokingRelation);
			String name = "T" + invokingRelation.getName() + "_where_" + invokedRelation.getName();
			traceClass.setName(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
			Rule2TraceClass superRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokedRelation);
			traceClass.getSuperClasses().add(superRelation2TraceClass.getTraceClass());
			name2property.putAll(superRelation2TraceClass.name2property);
		}

		//		@Override
		//		public void installConsumesDependencies() throws CompilerChainException {
		//			Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokingRelation);
		//			addConsumedBy(invokingRelation2TraceClass);
		//		}
	}

	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull RelationalTransformation rTransformation;
	private final org.eclipse.ocl.pivot.@NonNull Package tracePackage;

	/**
	 * The "Speculatable" class to be added to the trace package.
	 */
	//	private org.eclipse.ocl.pivot.@Nullable Class speculatableClass = null;

	/**
	 * The "Speculation" class to be added to the trace package.
	 */
	//	private org.eclipse.ocl.pivot.@Nullable Class speculationClass = null;

	/**
	 * Name to corresponding trace class
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Rule2TraceClass> name2rule2traceClass = new HashMap<>();

	/**
	 * Map of relation to trace class. The trace class is set null at the start of conversion enabling cycles to be ddetected.
	 */
	protected final @NonNull Map<@NonNull Relation, @Nullable Rule2TraceClass> relation2rule2traceClass = new HashMap<>();

	/**
	 * Map of invocation to trace class. The trace class is set null at the start of conversion enabling cycles to be ddetected.
	 */
	protected final @NonNull Map<@NonNull RelationCallExp, @Nullable Rule2TraceClass> invocation2rule2traceClass = new HashMap<>();

	public RelationalTransformation2TracePackage(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationalTransformation rTransformation) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.rTransformation = rTransformation;
		this.tracePackage = createTracePackage();
	}

	/**
	 * Build the inter-Rule2TraceClass dependencies.
	 */
	protected void createDependencies() throws CompilerChainException {
		List<@NonNull Rule2TraceClass> rule2TraceClasses2 = new ArrayList<>(name2rule2traceClass.values());
		Collections.sort(rule2TraceClasses2);
		//
		//	Establish the Rule2TraceClass directly consumes Rule2TraceClass dependencies
		//
		for (@NonNull Rule2TraceClass rule2TraceClass : rule2TraceClasses2) {
			rule2TraceClass.installConsumesDependencies();
		}
		//
		//	Identify the dependency cycles
		//
		//		for (@NonNull Rule2TraceClass rule2TraceClass : rule2TraceClasses2) {
		//			rule2TraceClass.installDependencyCycles();
		//		}
		//
		//	Display the dependencies
		//
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Rule2TraceClass rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedRule2traceClasses = Lists.newArrayList(rule2TraceClasses.getConsumedRule2traceClasses());
				Collections.sort(consumedRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedRule2traceClass : consumedRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(directlyConsumedTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Rule2TraceClass rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedRule2traceClasses = new ArrayList<>(rule2TraceClasses.getTransitivelyConsumedRule2traceClasses());
				Collections.sort(consumedRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedRule2traceClass : consumedRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(transitivelyConsumedTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Rule2TraceClass rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedByRule2traceClasses = Lists.newArrayList(rule2TraceClasses.getConsumedByRule2traceClasses());
				Collections.sort(consumedByRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedByRule2traceClass : consumedByRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedByRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(directlyConsumedByTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Rule2TraceClass rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> consumedByRule2traceClasses = new ArrayList<>(rule2TraceClasses.getTransitivelyConsumedByRule2traceClasses());
				Collections.sort(consumedByRule2traceClasses);;
				for (@NonNull Rule2TraceClass consumedByRule2traceClass : consumedByRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(consumedByRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(transitivelyConsumedByTraceClasses)" + s.toString());
		}
		if (QVTr2QVTc.CALL_TREE.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Rule2TraceClass rule2TraceClasses : rule2TraceClasses2) {
				s.append("\n\t" + rule2TraceClasses.toString() + "(");
				boolean isFirst = true;
				List<@NonNull Rule2TraceClass> cyclicRule2traceClasses = Lists.newArrayList(rule2TraceClasses.getCyclicRule2traceClasses());
				Collections.sort(cyclicRule2traceClasses);;
				for (@NonNull Rule2TraceClass cyclicRule2traceClass : cyclicRule2traceClasses) {
					if (!isFirst) {
						s.append(",");
					}
					s.append(cyclicRule2traceClass.toString());
					isFirst = false;
				}
				s.append(")");
			}
			QVTr2QVTc.CALL_TREE.println("traceClass(cyclicTraceClasses)" + s.toString());
		}
	}

	protected void createRelation2TraceClass(@NonNull Relation rRelation) throws CompilerChainException {
		Rule2TraceClass rule2traceClass = relation2rule2traceClass.get(rRelation);
		assert rule2traceClass == null;
		if (relation2rule2traceClass.containsKey(rRelation)) {
			throw new CompilerChainException("Overrides cycle detected for " + rRelation);
		}
		rule2traceClass = rRelation.isIsTopLevel() ? new TopRelation2TraceClass(this, rRelation) : new NonTopRelation2TraceClass(this, rRelation);
		qvtr2qvtc.putRelationTrace(rRelation, rule2traceClass.getTraceClass());
		relation2rule2traceClass.put(rRelation, null);
		rule2traceClass.transform();
		relation2rule2traceClass.put(rRelation, rule2traceClass);
	}

	/**
	 * Create a Rule2TraceClass for every QVTc Mapping and its middle model trace Class to be synthesized.
	 */
	protected void createRule2TraceClasses() throws CompilerChainException {
		Iterable<@NonNull Relation> rRelations = QVTrelationUtil.getOwnedRelations(rTransformation);
		//
		//	 Create each relation Rule2TraceClass.
		//
		for (@NonNull Relation rRelation : rRelations) {
			createRelation2TraceClass(rRelation);
		}
		//
		//	 Create each invocation Rule2TraceClass.
		//
		for (@NonNull Relation rRelation : rRelations) {
			Rule2TraceClass relation2TraceClass = getRule2TraceClass(rRelation);
			for (@NonNull RelationCallExp whenInvocation : relation2TraceClass.getWhenInvocations()) {
				Relation whenInvokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
				if (!whenInvokedRelation.isIsTopLevel()) {
					createWhenInvocation2TraceClass(whenInvocation);
				}
			}
			for (@NonNull RelationCallExp whereInvocation : relation2TraceClass.getWhereInvocations()) {
				Relation whereInvokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
				if (!whereInvokedRelation.isIsTopLevel()) {
					createWhereInvocation2TraceClass(whereInvocation);
				}
			}
		}
	}

	protected void createTraceClasses() {
		//
		//	Create the trace classes
		//
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = new ArrayList<>(name2rule2traceClass.size());
		for (@NonNull Rule2TraceClass rule2TraceClass : name2rule2traceClass.values()) {
			traceClasses.add(rule2TraceClass.getTraceClass());
		}
		CompilerUtil.normalizeNameables(traceClasses);
		tracePackage.getOwnedClasses().addAll(traceClasses);
	}

	protected org.eclipse.ocl.pivot.@NonNull Package createTracePackage() {
		org.eclipse.ocl.pivot.Package rPackage = rTransformation.getOwningPackage();
		org.eclipse.ocl.pivot.Package tracePackage = PivotFactory.eINSTANCE.createPackage();
		tracePackage.setName("P" + rTransformation.getName());
		tracePackage.setNsPrefix("P" + rTransformation.getName());
		StringBuilder sURI = new StringBuilder();
		getURI(rPackage, sURI);
		tracePackage.setURI(sURI.toString() + "/" + rTransformation.getName());
		qvtr2qvtc.putTracePackage(rTransformation, tracePackage);
		return tracePackage;
	}

	protected void createWhenInvocation2TraceClass(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		Relation invokingRelation = QVTrelationUtil.getContainingRelation(rInvocation);
		assert !invokedRelation.isIsTopLevel();
		WhenInvocation2TraceClass invocation2traceClass = new WhenInvocation2TraceClass(this, invokedRelation, invokingRelation);
		qvtr2qvtc.putInvocationTrace(rInvocation, invocation2traceClass.getTraceClass());
		Rule2TraceClass oldRule2traceClass = invocation2rule2traceClass.put(rInvocation, invocation2traceClass);
		assert oldRule2traceClass == null;
		invocation2traceClass.transform();
	}

	protected void createWhereInvocation2TraceClass(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
		Relation invokingRelation = QVTrelationUtil.getContainingRelation(rInvocation);
		assert !invokedRelation.isIsTopLevel();
		WhereInvocation2TraceClass invocation2traceClass = new WhereInvocation2TraceClass(this, invokedRelation, invokingRelation);
		qvtr2qvtc.putInvocationTrace(rInvocation, invocation2traceClass.getTraceClass());
		Rule2TraceClass oldRule2traceClass = invocation2rule2traceClass.put(rInvocation, invocation2traceClass);
		assert oldRule2traceClass == null;
		invocation2traceClass.transform();
	}

	/**
	 * Return the type of a Bag of traceClass for use as the indeterminate opposite property of a trace property.
	 */
	protected org.eclipse.ocl.pivot.@NonNull Class getBagType(org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		return qvtr2qvtc.getEnvironmentFactory().getCompleteEnvironment().getBagType(traceClass, true, null, null);
	}

	protected @NonNull Rule2TraceClass getInvocation2TraceClass(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		return ClassUtil.nonNullState(invocation2rule2traceClass.get(rInvocation));
	}

	public @NonNull Iterable<@NonNull Variable> getMiddleDomainVariables(@NonNull Relation rRelation) {
		return qvtr2qvtc.getMiddleDomainVariables(rRelation);
	}

	protected @NonNull Rule2TraceClass getRule2TraceClass(@NonNull Relation rRelation) throws CompilerChainException {
		return ClassUtil.nonNullState(relation2rule2traceClass.get(rRelation));
	}

	/*	protected org.eclipse.ocl.pivot.@NonNull Class getSpeculatableClass() {
		org.eclipse.ocl.pivot.Class speculatableClass2 = speculatableClass;
		if (speculatableClass2 == null) {
			//			org.eclipse.ocl.pivot.Class speculationClass2 = getSpeculationClass();
			org.eclipse.ocl.pivot.Class speculatableInterface = PivotUtil.createClass(Speculatable.class.getSimpleName());
			speculatableInterface.setInstanceClassName(Speculatable.class.getName());
			speculatableInterface.setIsAbstract(true);
			speculatableInterface.setIsInterface(true);
			tracePackage.getOwnedClasses().add(speculatableInterface);
			speculatableClass2 = speculatableClass = PivotUtil.createClass("Abstract" + Speculatable.class.getSimpleName());
			speculatableClass2.setIsAbstract(true);
			speculatableClass2.setIsInterface(false);
			speculatableClass2.getSuperClasses().add(speculatableInterface);
			Type speculationClass = getSpeculationClass();
			Type speculationsType = qvtr2qvtc.getEnvironmentFactory().getCompleteEnvironment().getBagType(speculationClass, true, null, null);
			Property referredSpeculationsProperty = PivotUtil.createProperty(QVTrNameGenerator.TRACECLASS_REFERRED_SPECULATIONS_PROPERTY_NAME, speculationsType);
			referredSpeculationsProperty.setIsRequired(true);
			referredSpeculationsProperty.setIsResolveProxies(false);
			speculatableClass2.getOwnedProperties().add(referredSpeculationsProperty);
			Property speculationProperty = PivotUtil.createProperty(QVTrNameGenerator.TRACECLASS_SPECULATION_PROPERTY_NAME, speculationClass);
			speculationProperty.setIsRequired(false);
			speculationProperty.setIsResolveProxies(false);
			speculatableClass2.getOwnedProperties().add(speculationProperty);
			Type booleanType = qvtr2qvtc.getStandardLibrary().getBooleanType();
			Property successProperty = PivotUtil.createProperty(QVTrNameGenerator.TRACECLASS_SUCCESS_PROPERTY_NAME, booleanType);
			successProperty.setIsRequired(true);
			speculatableClass2.getOwnedProperties().add(successProperty);
			tracePackage.getOwnedClasses().add(speculatableClass2);
		}
		return speculatableClass2;
	} */

	/*	protected org.eclipse.ocl.pivot.@NonNull Class getSpeculationClass() {
		org.eclipse.ocl.pivot.Class speculationClass2 = speculationClass;
		if (speculationClass2 == null) {
			speculationClass2 = speculationClass = PivotUtil.createClass(Speculation.class.getSimpleName());
			speculationClass2.setInstanceClassName(Speculation.class.getName());
			speculationClass2.setIsAbstract(true);
			speculationClass2.setIsInterface(true);
			tracePackage.getOwnedClasses().add(speculationClass2);
		}
		return speculationClass2;
	} */

	protected @NonNull String getUniqueTraceClassName(@NonNull Rule2TraceClass mapping2traceClass, @NonNull String name) {
		String uniqueName = name;
		int suffix = 0;
		while (name2rule2traceClass.get(uniqueName) != null) {
			uniqueName = name + ++suffix;
		}
		name2rule2traceClass.put(uniqueName, mapping2traceClass);
		return uniqueName;
	}

	private String getURI(org.eclipse.ocl.pivot.Package rPackage, @NonNull StringBuilder s) {
		if (rPackage == null) {
			s.append("http://www.eclipse.org/qvtd-example");
		}
		else if (rPackage.getURI() != null) {
			s.append(rPackage.getURI());
		}
		else {
			getURI(rPackage.getOwningPackage(), s);
			s.append("/");
			s.append(rPackage.getName());
		}
		return null;
	}

	@Override
	public String toString() {
		return rTransformation.toString();
	}

	public org.eclipse.ocl.pivot.@NonNull Package transform() throws CompilerChainException {
		//
		//	 Create a Rule2TraceClass for each Relation and each where Invocation.
		//
		createRule2TraceClasses();
		//
		//	 Create the Rule2TraceClass to Rule2TraceClass dependencies.
		//
		createDependencies();
		//
		//	Create the trace package
		//
		createTraceClasses();
		return tracePackage;
	}
}