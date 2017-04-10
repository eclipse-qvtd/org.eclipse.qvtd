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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
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
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
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

/**
 * RelationalTransformationToTracePackage performs the first part of the QVTr2QVTc transformation.
 * This involves synthesis of the QVTc middle model that defines the trace classes.
 */
public class RelationalTransformationToTracePackage
{
	/**
	 * A Rule2TraceClass represents the mapping between a Relation or RelationCallExp and a TraceClass/Mapping
	 */
	protected abstract static class Rule2TraceClass
	{
		protected final @NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage;

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

		protected final org.eclipse.ocl.pivot.@NonNull Class traceClass = ClassUtil.nonNullState(PivotFactory.eINSTANCE.createClass());
		protected final @NonNull Map<@NonNull String, @NonNull Property> name2property = new HashMap<>();

		public Rule2TraceClass(@NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
			this.relationalTransformation2tracePackage = relationalTransformation2tracePackage;
			this.relation = relation;
		}

		private void createTraceProperty(@Nullable Domain rDomain, org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull TypedElement tv, boolean manyTraces) throws CompilerChainException {
			String vn = QVTrelationUtil.getName(tv);
			Type c = QVTrelationUtil.getType(tv);
			createTraceProperty(rDomain, rc, vn, c, tv.isIsRequired(), manyTraces);
		}

		private void createTraceProperty(@Nullable Domain rDomain, org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull String name, @NonNull Type type, boolean isRequired, boolean manyTraces) throws CompilerChainException {
			Property traceProperty = name2property.get(name);
			if (traceProperty != null) {
				if ((type != traceProperty.getType()) || isRequired != traceProperty.isIsRequired()) {
					throw new CompilerChainException("Inconsistent redefined property '" + name + "' for " + relation);
				}
			}
			else {
				traceProperty = relationalTransformation2tracePackage.qvtr2qvtc.whenTraceProperty(rDomain, rc, name, type, isRequired, manyTraces);
				name2property.put(name, traceProperty);
			}
		}

		/**
		 * Returns true if there are many subtemplate matches.  If manyTraces is set there may be many trace class instances referencing the same objects
		 * and so the implicit opposites must be Bags. Only very simple patterns with pedantically 1:1 relationships can avoid the Bags.
		 * @throws CompilerChainException
		 */
		private boolean doSubTemplateToTraceClassProps(@NonNull Domain rDomain, @NonNull TemplateExp te, org.eclipse.ocl.pivot.@NonNull Class rc, boolean manyTraces) throws CompilerChainException {
			Variable tv = QVTrelationUtil.getBindsTo(te);
			if (te instanceof CollectionTemplateExp) {
				CollectionTemplateExp cte = (CollectionTemplateExp) te;
				Variable collectionVariable = QVTrelationUtil.getBindsTo(cte);
				CollectionType collectionType = (CollectionType)QVTrelationUtil.getType(collectionVariable);
				Type elementType = QVTrelationUtil.getElementType(collectionType);
				int argIndex = 0;
				for (@NonNull OCLExpression m : QVTrelationUtil.getOwnedMembers(cte)) {
					if (m instanceof TemplateExp) {
						if (doSubTemplateToTraceClassProps(rDomain, (TemplateExp)m, rc, manyTraces)) {
							//						manyTraces = true;
						}
					}
					else if (!(m instanceof VariableExp)) {
						createTraceProperty(rDomain, rc, collectionVariable.getName() + "_" + argIndex, elementType, collectionType.isIsNullFree(), false);
					}
					argIndex++;
				}
				//			Variable rv = cte.getRest();
				//			if (rv != null) {
				//				createTraceProperty(rDomain, rc, rv, isMany);
				//			}
				createTraceProperty(rDomain, rc, tv, manyTraces);			// ?? not required for CollectionTemplateExp's
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
						if (doSubTemplateToTraceClassProps(rDomain, (TemplateExp)value, rc, nestedManyTraces)) {
							//						manyTraces = true;
						}
					}
				}
				createTraceProperty(rDomain, rc, tv, manyTraces);			// ?? not required for CollectionTemplateExp's
			}
			return manyTraces;
		}

		public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
			return traceClass;
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

		public org.eclipse.ocl.pivot.@NonNull Class transform() throws CompilerChainException {
			for (@NonNull Variable rVariable : VariablesAnalysis.getMiddleDomainVariables(relation))  {
				createTraceProperty(null, traceClass, rVariable, false);
			}
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
					doSubTemplateToTraceClassProps(rDomain, rTemplateExp, traceClass, manyTraces);
				}
			}
			Pattern rWhenPattern = relation.getWhen();
			if (rWhenPattern != null) {
				for (Predicate rWhenPredicate : QVTrelationUtil.getOwnedPredicates(rWhenPattern)) {
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
								createTraceProperty(rDomain, traceClass, rVariable, manyTraces);
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
		protected AbstractRelation2TraceClass(@NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
			super(relationalTransformation2tracePackage, relation);
			String name = "T" + relation.getName();
			traceClass.setName(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
		}
	}

	/**
	 * A NonTopRelation2TraceClass represents the mapping between a non-top level QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
	 */
	protected static class NonTopRelation2TraceClass extends AbstractRelation2TraceClass
	{
		protected NonTopRelation2TraceClass(@NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
			super(relationalTransformation2tracePackage, relation);
			//			traceClass.setIsAbstract(true);
		}
	}

	/**
	 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
	 */
	protected static class TopRelation2TraceClass extends AbstractRelation2TraceClass
	{
		protected TopRelation2TraceClass(@NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
			super(relationalTransformation2tracePackage, relation);
		}
	}

	/**
	 * A AbstractInvocation2TraceClass represents the mapping between an invoked QVTr Relation and a QVTr mapping trace class.
	 */
	protected static abstract class AbstractInvocation2TraceClass extends Rule2TraceClass
	{
		protected final @NonNull Relation invokingRelation;

		protected AbstractInvocation2TraceClass(@NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage,
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
		protected WhenInvocation2TraceClass(@NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage,
				@NonNull Relation invokedRelation, @NonNull Relation invokingRelation) throws CompilerChainException {
			super(relationalTransformation2tracePackage, invokedRelation, invokingRelation);
			String name = "T" + invokingRelation.getName() + "_when_" + invokedRelation.getName();
			traceClass.setName(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
			Rule2TraceClass superRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokedRelation);
			traceClass.getSuperClasses().add(superRelation2TraceClass.getTraceClass());
			name2property.putAll(superRelation2TraceClass.name2property);
		}
	}

	/**
	 * A WhereInvocation2TraceClass represents the mapping between an where-invoked QVTr Relation and a QVTr mapping trace class.
	 */
	protected static class WhereInvocation2TraceClass extends AbstractInvocation2TraceClass
	{
		protected WhereInvocation2TraceClass(@NonNull RelationalTransformationToTracePackage relationalTransformation2tracePackage,
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

	public RelationalTransformationToTracePackage(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationalTransformation rTransformation) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.rTransformation = rTransformation;
		this.tracePackage = createTracePackage();
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

	protected @NonNull Rule2TraceClass getInvocation2TraceClass(@NonNull RelationCallExp rInvocation) throws CompilerChainException {
		return ClassUtil.nonNullState(invocation2rule2traceClass.get(rInvocation));
	}

	protected @NonNull Rule2TraceClass getRule2TraceClass(@NonNull Relation rRelation) throws CompilerChainException {
		return ClassUtil.nonNullState(relation2rule2traceClass.get(rRelation));
	}

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
		//	Create the trace package
		//
		createTraceClasses();
		return tracePackage;
	}
}
