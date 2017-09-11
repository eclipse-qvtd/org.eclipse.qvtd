/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateUtil;

import com.google.common.collect.Iterables;

public class QVTrelationUtil extends QVTtemplateUtil
{
	public static class Internal extends QVTtemplateUtil.Internal
	{
		public static @NonNull List<@NonNull Variable> getBindsToList(@NonNull DomainPattern rDomainPattern) {
			return ClassUtil.nullFree(rDomainPattern.getBindsTo());
		}

		public static @NonNull List<@NonNull OCLExpression> getOwnedArgumentsList(@NonNull RelationCallExp rInvocation) {
			return ClassUtil.nullFree(rInvocation.getArgument());
		}

		public static @NonNull List<@NonNull Domain> getOwnedDomainsList(@NonNull Relation rRelation) {
			return ClassUtil.nullFree(rRelation.getDomain());
		}

		public static @NonNull List<@NonNull Key> getOwnedKeysList(@NonNull RelationalTransformation rRelationalTransformation) {
			return ClassUtil.nullFree(rRelationalTransformation.getOwnedKey());
		}

		public static @NonNull List<@NonNull Property> getOwnedPartsList(@NonNull Key rKey) {
			return ClassUtil.nullFree(rKey.getPart());
		}

		public static @NonNull List<@NonNull Rule> getOwnedRelationsList(@NonNull RelationalTransformation rRelationalTransformation) {
			return ClassUtil.nullFree(rRelationalTransformation.getRule());
		}

		public static @NonNull List<@NonNull Variable> getOwnedVariablesList(@NonNull Relation rRelation) {
			return ClassUtil.nullFree(rRelation.getVariable());
		}
	}

	public static final class KeyComparator implements Comparator<@NonNull Key>
	{
		public static final @NonNull KeyComparator INSTANCE = new KeyComparator();

		@Override
		public int compare(@NonNull Key o1, @NonNull Key o2) {
			String n1 = getName(getIdentifies(o1));
			String n2 = getName(getIdentifies(o2));
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static final class RelationCallExpComparator implements Comparator<@NonNull RelationCallExp>
	{
		public static final @NonNull RelationCallExpComparator INSTANCE = new RelationCallExpComparator();

		@Override
		public int compare(@NonNull RelationCallExp o1, @NonNull RelationCallExp o2) {
			String n1 = getName(getReferredRelation(o1));
			String n2 = getName(getReferredRelation(o2));
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static final @NonNull String DUMMY_VARIABLE_NAME = "_";

	public static @Nullable RelationDomain basicGetContainingRelationDomain(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof RelationDomain) {
				return (RelationDomain) eObject;
			}
		}
		return null;
	}

	public static @Nullable Relation basicGetOverridden(@NonNull Relation relation) {
		return (Relation) relation.getOverridden();
	}

	public static @NonNull Relation getBaseRelation(@NonNull Relation relation) {
		Relation aRelation = relation;
		int i = 0;
		for (Rule aRule; (aRule = aRelation.getOverridden()) instanceof Relation; ) {
			aRelation = (Relation) aRule;
			if (i++ > 100) {	// More than a 100 is probably a cycle. Try again with an accurate cycle check
				Set<Relation> relations = new HashSet<>();
				aRelation = relation;
				relations.add(relation);
				while ((aRule = aRelation.getOverridden()) instanceof Relation) {
					aRelation = (Relation) aRule;
					if (!relations.add(aRelation)) {
						System.err.println("Cyclic override of '" + relation + "' ignored.");
						return relation;
					}
				}
			}
		}
		return aRelation;
	}

	public static @NonNull Variable getBindsTo(@NonNull TemplateExp rTemplateExp) {
		return ClassUtil.nonNullState(rTemplateExp.getBindsTo());
	}

	public static @NonNull Predicate getContainingPredicate(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Predicate) {
				return (Predicate) eObject;
			}
		}
		throw new IllegalStateException();
	}

	public static @NonNull Relation getContainingRelation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Relation) {
				return (Relation) eObject;
			}
		}
		throw new IllegalStateException();
	}

	public static @NonNull RelationalTransformation getContainingTransformation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof RelationalTransformation) {
				return (RelationalTransformation) eObject;
			}
		}
		throw new IllegalStateException();
	}

	public static org.eclipse.ocl.pivot.@NonNull Class getIdentifies(@NonNull Key rKey) {
		return ClassUtil.nonNullState(rKey.getIdentifies());
	}

	public static @NonNull Variable getOverriddenVariable(@NonNull Relation overriddenRelation, @NonNull Variable overridingRootVariable) {
		RelationDomain overridingDomain = QVTrelationUtil.getRootVariableDomain(overridingRootVariable);
		List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(overridingDomain);
		int rootVariableIndex = rootVariables.indexOf(overridingRootVariable);
		assert rootVariableIndex >= 0;
		RelationDomain overriddenRelationDomain = QVTrelationUtil.getRelationDomain(overriddenRelation, QVTrelationUtil.getTypedModel(overridingDomain));
		List<@NonNull Variable> overriddenRootVariables = QVTrelationUtil.getRootVariables(overriddenRelationDomain);
		assert rootVariableIndex < overriddenRootVariables.size();
		return overriddenRootVariables.get(rootVariableIndex);
	}

	public static @NonNull Iterable<@NonNull Relation> getOverrides(@NonNull Relation rRelation) {
		return Iterables.filter(ClassUtil.nullFree(rRelation.getOverrides()), Relation.class);
	}

	public static @NonNull Iterable<@NonNull OCLExpression> getOwnedArguments(@NonNull RelationCallExp rInvocation) {
		return ClassUtil.nullFree(rInvocation.getArgument());
	}

	public static @NonNull Iterable<@NonNull RelationDomain> getOwnedDomains(@NonNull Relation rRelation) {
		return Iterables.filter(ClassUtil.nullFree(rRelation.getDomain()), RelationDomain.class);
	}

	public static @NonNull Iterable<@NonNull Key> getOwnedKey(@NonNull RelationalTransformation rTransformation) {
		return ClassUtil.nullFree(rTransformation.getOwnedKey());
	}

	public static @NonNull Iterable<@NonNull Property> getOwnedOppositeParts(@NonNull Key rKey) {
		return ClassUtil.nullFree(rKey.getOppositePart());
	}

	public static @NonNull Iterable<@NonNull Property> getOwnedParts(@NonNull Key rKey) {
		return ClassUtil.nullFree(rKey.getPart());
	}

	public static @NonNull Iterable<@NonNull DomainPattern> getOwnedPatterns(@NonNull RelationDomain rRelationDomain) {
		return ClassUtil.nullFree(rRelationDomain.getPattern());
	}

	public static @NonNull Iterable<@NonNull Relation> getOwnedRelations(@NonNull RelationalTransformation rTransformation) {
		return Iterables.filter(ClassUtil.nullFree(rTransformation.getRule()), Relation.class);
	}

	public static @NonNull TemplateExp getOwnedTemplateExpression(@NonNull DomainPattern rDomainPattern) {
		return ClassUtil.nonNullState(rDomainPattern.getTemplateExpression());
	}

	public static @NonNull Iterable<@NonNull Variable> getOwnedVariables(@NonNull Relation rRelation) {
		return ClassUtil.nullFree(rRelation.getVariable());
	}

	public static @NonNull ObjectTemplateExp getOwningObjectTemplateExp(@NonNull  PropertyTemplateItem rPropertyTemplateItem) {
		return ClassUtil.nonNullState(rPropertyTemplateItem.getObjContainer());
	}

	public static @NonNull Relation getReferredRelation(@NonNull RelationCallExp rInvocation) {
		return ClassUtil.nonNullState(rInvocation.getReferredRelation());
	}

	/**
	 * Return the domain of the argumentIndex'th argument of rInvocation
	 */
	public static @NonNull RelationDomain getRelationCallExpArgumentDomain(@NonNull RelationCallExp rInvocation, int argumentIndex) {
		Relation rRelation = rInvocation.getReferredRelation();
		assert rRelation != null;
		int iFirst = 0;
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			RelationDomain rRelationDomain = (RelationDomain)rDomain;
			int iNext = iFirst + rRelationDomain.getRootVariable().size();
			if (argumentIndex < iNext) {
				return rRelationDomain;
			}
			iFirst = iNext;
		}
		throw new IndexOutOfBoundsException(argumentIndex + " > " + iFirst + " for " + rRelation);
	}

	public static @NonNull RelationDomain getRelationDomain(@NonNull Relation qvtrRelation, @NonNull TypedModel typedModel) {
		for (@NonNull RelationDomain rRelationDomain : getOwnedDomains(qvtrRelation)) {
			if (rRelationDomain.getTypedModel() == typedModel) {
				return rRelationDomain;
			}
		}
		throw new IllegalArgumentException("No " + typedModel.getName() + " domain in " + qvtrRelation.getName());
	}

	/**
	 * Return the domain of a given root variable.
	 * Throws an IllegalStateException if there is no such domain.
	 */
	public static @NonNull RelationDomain getRootVariableDomain(@NonNull Variable rootVariable) {
		Relation relation = getContainingRelation(rootVariable);
		for (@NonNull Domain domain : ClassUtil.nullFree(relation.getDomain())) {
			RelationDomain relationDomain = (RelationDomain)domain;
			for (@NonNull DomainPattern domainPattern : ClassUtil.nullFree(relationDomain.getPattern())) {
				TemplateExp templateExpression = domainPattern.getTemplateExpression();
				if (rootVariable == templateExpression.getBindsTo()) {
					return relationDomain;
				}
			}
		}
		throw new IllegalStateException("No RelationDomain for " + rootVariable);
	}

	/**
	 * Return all the root variables of relation in RelationCallExp order.
	 */
	public static @NonNull List<@NonNull Variable> getRootVariables(@NonNull Relation relation) {
		List<@NonNull Variable> rootVariables = new ArrayList<@NonNull Variable>();
		for (@NonNull Domain domain : ClassUtil.nullFree(relation.getDomain())) {
			for (@NonNull DomainPattern domainPattern : ClassUtil.nullFree(((RelationDomain)domain).getPattern())) {
				TemplateExp templateExpression = domainPattern.getTemplateExpression();
				Variable rootVariable = templateExpression.getBindsTo();
				assert rootVariable != null;
				rootVariables.add(rootVariable);
			}
		}
		return rootVariables;
	}

	/**
	 * Return all the root variables of relationDomain (in partial RelationCallExp order).
	 */
	public static @NonNull List<@NonNull Variable> getRootVariables(@NonNull RelationDomain relationDomain) {
		List<@NonNull Variable> rootVariables = new ArrayList<@NonNull Variable>();
		for (@NonNull DomainPattern domainPattern : ClassUtil.nullFree(relationDomain.getPattern())) {
			TemplateExp templateExpression = domainPattern.getTemplateExpression();
			Variable rootVariable = templateExpression.getBindsTo();
			assert rootVariable != null;
			rootVariables.add(rootVariable);
		}
		return rootVariables;
	}

	public static @NonNull RelationalTransformation getTransformation(@NonNull Relation rRelation) {
		return (RelationalTransformation) ClassUtil.nonNullState(rRelation.getTransformation());
	}

	/**
	 * Return true if rRelation participates in a hierarchy of overriding/overridden relations.
	 */
	public static boolean hasOverrides(@NonNull Relation rRelation) {
		return (rRelation.getOverridden() != null) || !rRelation.getOverrides().isEmpty();
	}

	//	public static @NonNull Pattern getWhen(@NonNull Relation rRelation) {
	//		return ClassUtil.nonNullState(rRelation.getWhen());
	//	}

	//	public static @NonNull Pattern getWhere(@NonNull Relation rRelation) {
	//		return ClassUtil.nonNullState(rRelation.getWhere());
	//	}

	public static @NonNull RelationalTransformation loadTransformation(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
		try {
			return (RelationalTransformation) loadTransformation(RelationModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	public static @NonNull Resource loadTransformations(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformations(RelationModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}
}