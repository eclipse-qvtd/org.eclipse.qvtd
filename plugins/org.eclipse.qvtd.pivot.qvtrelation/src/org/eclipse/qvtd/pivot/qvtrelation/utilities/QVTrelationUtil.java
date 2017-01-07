/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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
import java.util.List;

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
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;

public class QVTrelationUtil extends QVTbaseUtil
{

	public static class Internal extends QVTbaseUtil.Internal
	{
		public static List<@NonNull OCLExpression> getOwnedArgumentsList(@NonNull RelationCallExp rInvocation) {
			return ClassUtil.nullFree(rInvocation.getArgument());
		}
	}

	public static final @NonNull String DUMMY_VARIABLE_NAME = "_";

	public static @Nullable Relation getContainingRelation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Relation) {
				return (Relation) eObject;
			}
		}
		return null;
	}

	public static org.eclipse.ocl.pivot.@NonNull Class getIdentifies(@NonNull Key rKey) {
		return ClassUtil.nonNullState(rKey.getIdentifies());
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

	public static @NonNull Iterable<@NonNull OCLExpression> getOwnedMembers(@NonNull CollectionTemplateExp rCollectionTemplateExp) {
		return ClassUtil.nullFree(rCollectionTemplateExp.getMember());
	}

	public static @NonNull Iterable<@NonNull PropertyTemplateItem> getOwnedParts(@NonNull ObjectTemplateExp eObject) {
		return ClassUtil.nullFree(eObject.getPart());
	}

	public static @NonNull Iterable<@NonNull DomainPattern> getOwnedPatterns(@NonNull RelationDomain rRelationDomain) {
		return ClassUtil.nullFree(rRelationDomain.getPattern());
	}

	public static @NonNull Iterable<@NonNull Relation> getOwnedRelations(@NonNull RelationalTransformation rTransformation) {
		return Iterables.filter(ClassUtil.nullFree(rTransformation.getRule()), Relation.class);
	}

	public static @NonNull OCLExpression getOwnedValue(@NonNull PropertyTemplateItem rPropertyTemplateItem) {
		return ClassUtil.nonNullState(rPropertyTemplateItem.getValue());
	}

	public static @NonNull Iterable<@NonNull Variable> getOwnedVariable(@NonNull Relation rRelation) {
		return ClassUtil.nullFree(rRelation.getVariable());
	}

	public static @NonNull Property getReferredProperty(@NonNull PropertyTemplateItem rPropertyTemplateItem) {
		return ClassUtil.nonNullState(rPropertyTemplateItem.getReferredProperty());
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

	/**
	 * Return the domain of a given root variable.
	 * Throws an IllegalStateException if there is no such domain.
	 */
	public static @NonNull RelationDomain getRootVariableDomain(@NonNull Variable rootVariable) {
		Relation relation = ClassUtil.nonNullState(getContainingRelation(rootVariable));
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

	public static @NonNull TemplateExp getOwnedTemplateExpression(@NonNull DomainPattern rDomainPattern) {
		return ClassUtil.nonNullState(rDomainPattern.getTemplateExpression());
	}

	public static @NonNull Transformation loadTransformation(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformation(RelationModel.class, environmentFactory, transformationURI, keepDebug);
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