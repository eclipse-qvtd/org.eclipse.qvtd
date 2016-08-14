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

import java.util.Collections;
import java.util.List;

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
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TreeIterable;
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
	protected final @NonNull QVTr2QVTc qvtr2qvtc;

	public RelationalTransformationToTracePackage(@NonNull QVTr2QVTc qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}

	private void createTraceProperty(@Nullable Domain rDomain, org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull TypedElement tv, boolean manyTraces) {
		String vn = ClassUtil.nonNullState(tv.getName());
		Type c = ClassUtil.nonNullState(tv.getType());
		qvtr2qvtc.whenTraceProperty(rDomain, rc, vn, c, tv.isIsRequired(), manyTraces);
	}

	private void createTraceProperty(@Nullable Domain rDomain, org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull String name, @NonNull Type type, boolean isRequired) {
		qvtr2qvtc.whenTraceProperty(rDomain, rc, name, type, isRequired, false);
	}

	public org.eclipse.ocl.pivot.@NonNull Package doRelationalTransformationToTracePackage(@NonNull RelationalTransformation rTransformation) {
		org.eclipse.ocl.pivot.Package rPackage = rTransformation.getOwningPackage();
		org.eclipse.ocl.pivot.Package tracePackage = PivotFactory.eINSTANCE.createPackage();
		tracePackage.setName("P" + rTransformation.getName());
		tracePackage.setNsPrefix("P" + rTransformation.getName());
		StringBuilder s = new StringBuilder();
		getURI(rPackage, s);
		tracePackage.setURI(s.toString() + "/" + rTransformation.getName());
		qvtr2qvtc.putTracePackage(rTransformation, tracePackage);
		List<org.eclipse.ocl.pivot.@NonNull Class> ownedClasses = ClassUtil.nullFree(tracePackage.getOwnedClasses());
		for (@NonNull Rule rRule : ClassUtil.nullFree(rTransformation.getRule())) {
			if (rRule instanceof Relation) {
				ownedClasses.add(doRelationToTraceClass((Relation)rRule));
			}
		}
		CompilerUtil.normalizeNameables(ownedClasses);
		return tracePackage;
	}

	private org.eclipse.ocl.pivot.@NonNull Class doRelationToTraceClass(@NonNull Relation rRelation) {
		@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Class traceClass = PivotFactory.eINSTANCE.createClass();
		qvtr2qvtc.putRelationTrace(rRelation, traceClass);
		traceClass.setName("T" + rRelation.getName());
		for (@NonNull Variable rVariable : VariablesAnalysis.getMiddleDomainVariables(rRelation))  {
			createTraceProperty(null, traceClass, rVariable, false);
		}
		//
		//	Determine whether a navigation from the trace to an unambiguous ledft/right object can ever be possible.
		//
		boolean manyTraces = hasManyRootMatches(rRelation) || hasCollectionMemberMatches(rRelation) || hasMultiObjectMatches(rRelation);
		if (!manyTraces) {
			for (@NonNull Variable rVariable : ClassUtil.nullFree(rRelation.getVariable())) {
				if (hasManyVariableMatches(rRelation, rVariable)) {
					manyTraces = true;
					break;
				}
			}
		}
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
				TemplateExp rTemplateExp = ClassUtil.nonNullState(rDomainPattern.getTemplateExpression());
				doSubTemplateToTraceClassProps(rDomain, rTemplateExp, traceClass, manyTraces);
			}
		}
		Pattern rWhenPattern = rRelation.getWhen();
		if (rWhenPattern != null) {
			for (Predicate rWhenPredicate : ClassUtil.nullFree(rWhenPattern.getPredicate())) {
				OCLExpression rConditionExpression = ClassUtil.nonNullState(rWhenPredicate.getConditionExpression());
				if (rConditionExpression instanceof RelationCallExp) {
					RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
					List<@NonNull OCLExpression> rArguments = ClassUtil.nullFree(rInvocation.getArgument());
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

	/**
	 * Returns true if there are many subtemplate matches.  If manyTraces is set there may be many trace class instances referencing the same objects
	 * and so the implicit opposites must be Bags. Only very simple patterns with pedantically 1:1 relationships can avoid the Bags.
	 */
	private boolean doSubTemplateToTraceClassProps(@NonNull Domain rDomain, @NonNull TemplateExp te, org.eclipse.ocl.pivot.@NonNull Class rc, boolean manyTraces) {
		Variable tv = ClassUtil.nonNullState(te.getBindsTo());
		if (te instanceof CollectionTemplateExp) {
			CollectionTemplateExp cte = (CollectionTemplateExp) te;
			Variable collectionVariable = cte.getBindsTo();
			CollectionType collectionType = (CollectionType)collectionVariable.getType();
			Type elementType = ClassUtil.nonNullState(collectionType.getElementType());
			int argIndex = 0;
			for (@NonNull OCLExpression m : ClassUtil.nullFree(cte.getMember())) {
				if (m instanceof TemplateExp) {
					if (doSubTemplateToTraceClassProps(rDomain, (TemplateExp)m, rc, manyTraces)) {
						//						manyTraces = true;
					}
				}
				else {
					createTraceProperty(rDomain, rc, collectionVariable.getName() + "_" + argIndex, elementType, collectionType.isIsNullFree());
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
			for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(ote.getPart())) {
				Property referredProperty = pt.getReferredProperty();
				if (referredProperty.isIsMany()) {
					manyTraces = true;
				}
				OCLExpression value = ClassUtil.nonNullState(pt.getValue());
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
		List<@NonNull Domain> rDomains = ClassUtil.nullFree(rRelation.getDomain());
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
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
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
}
