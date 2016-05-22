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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTrelationUtil extends QVTbaseUtil
{
	public static final @NonNull String DUMMY_VARIABLE_NAME = "_";

	public static @Nullable Relation getContainingRelation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Relation) {
				return (Relation) eObject;
			}
		}
		return null;
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

	public static @NonNull Transformation loadTransformation(@NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		return loadTransformation(RelationModel.class, environmentFactory, transformationURI, keepDebug);
	}

	public static @NonNull Resource loadTransformations(@NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		return loadTransformations(RelationModel.class, environmentFactory, transformationURI, keepDebug);
	}
}