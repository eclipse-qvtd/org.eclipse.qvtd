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
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
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
 * A AbstractRelation2TraceClass represents the mapping between a QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a top/non-top relation.
 */
abstract class AbstractRelation2TraceClass extends AbstractRule2TraceClass
{
	/**
	 * VariableDeclaration2TraceProperty accumulates the requirements on the trace property for a pattern variable.
	 *
	 * Its relation TypedModel may be initially null (unknown) and set non-null once encounterted as a template binding.
	 *
	 * Its unitOpposite may evolve to true if any mechanism for unit usage is encountered.
	 */
	class VariableDeclaration2TraceProperty
	{
		/**
		 * The typed model within which the variable's reference is located. null for unknown or primitive.
		 */
		@Nullable TypedModel rTypedModel;

		/**
		 * The variable whose value is persisted by the trace property.
		 */
		@NonNull VariableDeclaration variable;

		/**
		 * True if there is known to be at most one instance of the trace class for each value of the trace variable.
		 * False if there might be more than one.
		 */
		boolean unitOpposite;

		VariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean unitOpposite) {
			this.rTypedModel = rTypedModel;
			this.variable = variable;
			this.unitOpposite = unitOpposite;
		}

		@Override
		public String toString() {
			return String.valueOf(rTypedModel) + " - " + variable + " - " + (unitOpposite ? "SINGLE" : "MULTIPLE");
		}
	}

	/**
	 * RelationCallExp invocations within the when pattern.
	 */
	private final @NonNull List<@NonNull RelationCallExp> whenInvocations = new ArrayList<>();

	/**
	 * RelationCallExp invocations within the where pattern.
	 */
	private final @NonNull List<@NonNull RelationCallExp> whereInvocations = new ArrayList<>();

	/**
	 * Map from trace property name to trace property.
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Property> name2property = new HashMap<>();

	/**
	 * Lazily created null-free Bag of traceClass.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class bagOfTraceClass = null;

	private @NonNull Map<@NonNull VariableDeclaration, @NonNull VariableDeclaration2TraceProperty> variable2variableDeclaration2traceProperty = new HashMap<>();

	protected AbstractRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		super(relationalTransformation2tracePackage, relation, relationalTransformation2tracePackage.getNameGenerator().createTraceClassName(relation));
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

	protected void addAllProperties(Rule2TraceClass.@NonNull Internal superRelation2TraceClass) {
		name2property.putAll(superRelation2TraceClass.getName2Property());
	}

	@Override
	public void analyzeInheritance() {
		Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
		if (overriddenRelation != null) {
			Rule2TraceClass.@NonNull Internal overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(overriddenRelation);
			traceClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceInterface());
		}
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
		if (variable2variableDeclaration2traceProperty.containsKey(templateVariable)) {
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

	/**
	 * Lazily create the name Property for a traceClass with a type. If unitOpposite is not set there may be many trace class instances referencing the same object through
	 * the trace property and so the implicit opposite must be a Bag.
	 */
	private void createTraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean unitOpposite) throws CompilerChainException {
		String domainName = rTypedModel != null ? rTypedModel.getName() : null;
		String name = QVTrelationUtil.getName(variable);
		org.eclipse.ocl.pivot.@NonNull Class type = QVTrelationUtil.getClass(variable);
		boolean isRequired = variable.isIsRequired();
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
			if (domainName != null) {
				Annotation domainAnnotation = PivotFactory.eINSTANCE.createAnnotation();
				domainAnnotation.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE);
				Detail domainDetail = PivotFactory.eINSTANCE.createDetail();
				domainDetail.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN);
				domainDetail.getValues().add(domainName);
				domainAnnotation.getOwnedDetails().add(domainDetail);
				traceProperty.getOwnedAnnotations().add(domainAnnotation);
			}
			name2property.put(name, traceProperty);
			traceProperty.setOwningClass(traceClass);
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
		}
	}

	protected org.eclipse.ocl.pivot.@NonNull Class getBagOfTraceClass() {
		Class bagOfTraceClass2 = bagOfTraceClass;
		if (bagOfTraceClass2 == null) {
			bagOfTraceClass = bagOfTraceClass2 = relationalTransformation2tracePackage.getBagType(traceClass);
		}
		return bagOfTraceClass2;
	}

	@Override
	public @NonNull Map<@NonNull String, @NonNull Property> getName2Property() {
		return name2property;
	}

	private @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = variable2variableDeclaration2traceProperty.get(variable);
		if (variableDeclaration2TraceProperty != null) {
			if (rTypedModel != null) {
				if (variableDeclaration2TraceProperty.rTypedModel == null) {
					variableDeclaration2TraceProperty.rTypedModel = rTypedModel;
				}
				else {
					assert variableDeclaration2TraceProperty.rTypedModel == rTypedModel;
				}
			}
			if (isNestedOneToOne && !variableDeclaration2TraceProperty.unitOpposite) {
				variableDeclaration2TraceProperty.unitOpposite = true;
			}
		}
		else {
			variableDeclaration2TraceProperty = new VariableDeclaration2TraceProperty(rTypedModel, variable, isNestedOneToOne);
			variable2variableDeclaration2traceProperty.put(variable, variableDeclaration2TraceProperty);
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

	@Override
	public void installConsumesDependencies() throws CompilerChainException {
		for (@NonNull RelationCallExp whenInvocation : whenInvocations) {
			Relation whenInvokedRelation = QVTrelationUtil.getReferredRelation(whenInvocation);
			if (whenInvokedRelation.isIsTopLevel()) {
				Rule2TraceClass.@NonNull Internal invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(whenInvokedRelation);
				invokedRelation2TraceClass.addConsumedBy(this);
			}
			else {
				for (Rule2TraceClass.@NonNull Internal invocation2TraceClass : relationalTransformation2tracePackage.getInvocation2TraceClasses(whenInvocation)) {
					addConsumedBy(invocation2TraceClass);
					invocation2TraceClass.addConsumedBy(this);
				}
			}
		}
		for (@NonNull RelationCallExp whereInvocation : whereInvocations) {
			Relation whereInvokedRelation = QVTrelationUtil.getReferredRelation(whereInvocation);
			if (whereInvokedRelation.isIsTopLevel()) {
				Rule2TraceClass.@NonNull Internal invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(whereInvokedRelation);
				invokedRelation2TraceClass.addConsumedBy(this);
			}
			else {
				for (Rule2TraceClass.@NonNull Internal invocation2TraceClass : relationalTransformation2tracePackage.getInvocation2TraceClasses(whereInvocation)) {
					addConsumedBy(invocation2TraceClass);
					invocation2TraceClass.addConsumedBy(this);
				}
			}
		}
	}

	@Override
	public void synthesize() throws CompilerChainException {
		//
		//	Create a trace property for each prepared trace property.
		//
		for (@NonNull VariableDeclaration traceVariable : variable2variableDeclaration2traceProperty.keySet()) {
			VariableDeclaration2TraceProperty vd2tp = variable2variableDeclaration2traceProperty.get(traceVariable);
			assert vd2tp != null;
			createTraceProperty(vd2tp.rTypedModel, vd2tp.variable, vd2tp.unitOpposite);
		}
		CompilerUtil.normalizeNameables(ClassUtil.nullFree(traceClass.getOwnedProperties()));
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
}