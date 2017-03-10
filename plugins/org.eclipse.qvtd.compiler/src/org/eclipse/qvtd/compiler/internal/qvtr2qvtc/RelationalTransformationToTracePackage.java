/*******************************************************************************
 * Copyright (c) 2014, 2016 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

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

/*public*/ class RelationalTransformationToTracePackage
{
	public class Relation2TraceClass
	{
		protected final @NonNull Relation relation;
		protected final @Nullable RelationCallExp invocation;
		protected final org.eclipse.ocl.pivot.@NonNull Class traceClass;
		protected final @NonNull Map<@NonNull String, @NonNull Property> name2property = new HashMap<>();

		protected Relation2TraceClass(@NonNull Relation relation) {
			this.relation = relation;
			this.invocation = null;
			this.traceClass = ClassUtil.nonNullState(PivotFactory.eINSTANCE.createClass());
			String name = "T" + relation.getName();
			traceClass.setName(getUniqueTraceClassName(this, name));
			qvtr2qvtc.putRelationTrace(relation, traceClass);
		}

		protected Relation2TraceClass(@NonNull RelationCallExp invocation, @NonNull String separator) throws CompilerChainException {
			this.relation = QVTrelationUtil.getReferredRelation(invocation);
			this.invocation = invocation;
			this.traceClass = ClassUtil.nonNullState(PivotFactory.eINSTANCE.createClass());
			String invokedName = QVTrelationUtil.getContainingRelation(invocation).getName();
			String name = "T" + invokedName + separator + relation.getName();
			traceClass.setName(getUniqueTraceClassName(this, name));
			qvtr2qvtc.putInvocationTrace(invocation, traceClass);
			Relation2TraceClass superRelation2TraceClass = getRelation2TraceClass(relation);
			//			traceClass.getSuperClasses().add(superRelation2TraceClass.getTraceClass());
			//			name2property.putAll(superRelation2TraceClass.name2property);
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
				traceProperty = qvtr2qvtc.whenTraceProperty(rDomain, rc, name, type, isRequired, manyTraces);
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

		private boolean hasCollectionMemberMatches(@NonNull Relation rRelation) {
			for (EObject eObject : new TreeIterable(rRelation, true)) {
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
		private boolean hasManyRootMatches(@NonNull Relation rRelation) {
			//
			//	Only a single root variable in each of just two domains gurantees just one trace per root variable.
			//
			List<@NonNull Domain> rDomains = QVTrelationUtil.Internal.getOwnedDomainsList(rRelation);
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

		private boolean hasManyVariableMatches(@NonNull Relation rRelation, @NonNull Variable rVariable) {
			for (@NonNull Domain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
				Iterable<@NonNull Variable> bindsTo = QVTr2QVTcUtil.getRelationDomainBindsTo((RelationDomain) rDomain);
				if (Iterables.contains(bindsTo, rVariable)) {
					return false;
				}
			}
			for (EObject eObject : new TreeIterable(rRelation, true)) {
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

		private boolean hasMultiObjectMatches(@NonNull Relation rRelation) {
			for (EObject eObject : new TreeIterable(rRelation, true)) {
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
		public String toString() {
			return relation.toString();
		}

		public org.eclipse.ocl.pivot.@NonNull Class transform() throws CompilerChainException {
			Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
			if (overriddenRelation != null) {
				Relation2TraceClass overriddenRelation2TraceClass = getRelation2TraceClass(overriddenRelation);
				name2property.putAll(overriddenRelation2TraceClass.name2property);
				traceClass.getSuperClasses().add(overriddenRelation2TraceClass.traceClass);
			}

			for (@NonNull Variable rVariable : VariablesAnalysis.getMiddleDomainVariables(relation))  {
				createTraceProperty(null, traceClass, rVariable, false);
			}
			if (invocation != null) {
				for (@NonNull Variable rVariable : VariablesAnalysis.getMiddleDomainVariables(invocation.getReferredRelation()))  {
					createTraceProperty(null, traceClass, rVariable, false);
				}
			}
			if (testableRelations.contains(relation) ) {
				Type booleanType = qvtr2qvtc.getStandardLibrary().getBooleanType();
				createTraceProperty(null, traceClass, QVTrNameGenerator.TRACECLASS_SUCCESS_PROPERTY_NAME, booleanType, false, false);
			}
			//
			//	Determine whether a navigation from the trace to an unambiguous left/right object can ever be possible.
			//
			boolean manyTraces = hasManyRootMatches(relation) || hasCollectionMemberMatches(relation) || hasMultiObjectMatches(relation);
			if (!manyTraces) {
				for (@NonNull Variable rVariable : QVTrelationUtil.getOwnedVariables(relation)) {
					if (hasManyVariableMatches(relation, rVariable)) {
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

	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull RelationalTransformation rTransformation;
	private @NonNull Set<@NonNull Relation> testableRelations = new HashSet<>();

	/**
	 * Name to corresponding trace class
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Relation2TraceClass> name2relation2traceClass = new HashMap<>();

	/**
	 * Map of relation to trace class. The trace class is set null at the start of conversion enabling cycles to be ddetected.
	 */
	protected final @NonNull Map<@NonNull Relation, @Nullable Relation2TraceClass> relation2relation2traceClass = new HashMap<>();

	/**
	 * Map of invocation to trace class. The trace class is set null at the start of conversion enabling cycles to be ddetected.
	 */
	protected final @NonNull Map<@NonNull RelationCallExp, @Nullable Relation2TraceClass> invocation2relation2traceClass = new HashMap<>();

	public RelationalTransformationToTracePackage(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationalTransformation rTransformation) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.rTransformation = rTransformation;
		for (@NonNull EObject eObject : new TreeIterable(rTransformation, false)) {
			if ((eObject instanceof RelationCallExp) && !(eObject.eContainer() instanceof Predicate)) {
				testableRelations.add(QVTrelationUtil.getReferredRelation((RelationCallExp)eObject));
			}
		}
	}

	protected @NonNull Relation2TraceClass getInvocation2TraceClass(@NonNull RelationCallExp rInvocation, @NonNull String separator) throws CompilerChainException {
		Relation2TraceClass relation2traceClass = new Relation2TraceClass(rInvocation, separator);
		Relation2TraceClass oldRelation2traceClass = invocation2relation2traceClass.put(rInvocation, relation2traceClass);
		assert oldRelation2traceClass == null;
		relation2traceClass.transform();
		return relation2traceClass;
	}

	protected @NonNull Relation2TraceClass getRelation2TraceClass(@NonNull Relation rRelation) throws CompilerChainException {
		Relation2TraceClass relation2traceClass = relation2relation2traceClass.get(rRelation);
		if (relation2traceClass == null) {
			if (relation2relation2traceClass.containsKey(rRelation)) {
				throw new CompilerChainException("Overrides cycle detected for " + rRelation);
			}
			relation2traceClass = new Relation2TraceClass(rRelation);
			relation2relation2traceClass.put(rRelation, null);
			relation2traceClass.transform();
			relation2relation2traceClass.put(rRelation, relation2traceClass);
		}
		return relation2traceClass;
	}

	private @NonNull String getUniqueTraceClassName(@NonNull Relation2TraceClass relation2traceClass, @NonNull String name) {
		String uniqueName = name;
		int suffix = 0;
		while (name2relation2traceClass.get(uniqueName) != null) {
			uniqueName = name + ++suffix;
		}
		name2relation2traceClass.put(uniqueName, relation2traceClass);
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
		org.eclipse.ocl.pivot.Package rPackage = rTransformation.getOwningPackage();
		org.eclipse.ocl.pivot.Package tracePackage = PivotFactory.eINSTANCE.createPackage();
		tracePackage.setName("P" + rTransformation.getName());
		tracePackage.setNsPrefix("P" + rTransformation.getName());
		StringBuilder s = new StringBuilder();
		getURI(rPackage, s);
		tracePackage.setURI(s.toString() + "/" + rTransformation.getName());
		qvtr2qvtc.putTracePackage(rTransformation, tracePackage);
		for (@NonNull Relation rRelation : QVTrelationUtil.getOwnedRelations(rTransformation)) {
			//			if (rRelation.isIsTopLevel()) {
			getRelation2TraceClass(rRelation);
			//			}
		}
		for (@NonNull Relation rRelation : QVTrelationUtil.getOwnedRelations(rTransformation)) {
			if (!rRelation.isIsTopLevel()) {
				Iterable<@NonNull RelationCallExp> whenInvocations = qvtr2qvtc.getWhenRelationCallExpsForRelation(rRelation);
				if (whenInvocations != null) {
					for (@NonNull RelationCallExp rInvocation : whenInvocations) {
						getInvocation2TraceClass(rInvocation, "_when_");
					}
				}
				Iterable<@NonNull RelationCallExp> whereInvocations = qvtr2qvtc.getWhereRelationCallExpsForRelation(rRelation);
				if (whereInvocations != null) {
					for (@NonNull RelationCallExp rInvocation : whereInvocations) {
						getInvocation2TraceClass(rInvocation, "_where_");
					}
				}
			}
		}
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = new ArrayList<>(name2relation2traceClass.size());
		for (@NonNull Relation2TraceClass relation2TraceClass : name2relation2traceClass.values()) {
			traceClasses.add(relation2TraceClass.getTraceClass());
		}
		CompilerUtil.normalizeNameables(traceClasses);
		tracePackage.getOwnedClasses().addAll(traceClasses);
		return tracePackage;
	}
}
