/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * A VariableAnalysis accumulates the usage of a core or relation variable and eventually synthesizes an appropriate core variable.
 *
 * @noimplement Clients should extend AbstractVariableAnalysis.
 */
public interface VariableAnalysis
{

	/**
	 * The relation variable for this analysis. Returns null if the core variable is an additional synthesized artefact.
	 */
	@Nullable Variable getRelationVariable();

	/**
	 * Return true if this variable is associated with a when clause.
	 */
	boolean hasWhenDomain();

	/**
	 * Accumulate the definition of this variable by rTemplateExp in an enforced domain.
	 * If rKey is non-null the enforcement correlates with rKey.
	 */
	void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @NonNull TypedModel rEnforcedTypedModel, @Nullable Key rKey);

	/**
	 * Accumulate the references of this variable by an enforced domain.
	 */
	void setIsEnforcedReferred();

	/**
	 * Accumulate the usage of this variable as a domain root variable.
	 */
	void setIsRoot();

	/**
	 * Accumulate the definition of this variable by the not-enforced rOtherTypedModel.
	 */
	void setOtherBound(@NonNull TypedModel rOtherTypedModel);

	/**
	 * Accumulate the reference of this variable by the not-enforced rOtherTypedModel.
	 */
	void setOtherReferred(@NonNull TypedModel rOtherTypedModeln);

	/**
	 * Accumulate the reference of this variable by the predicate in rPredicateTypedModel.
	 */
	void setPredicate(@NonNull TypedModel rPredicateTypedModel);

	/**
	 * Accumulate the usage of this variable in a when predicate for the rWhenTypedModel.
	 */
	void setWhen(@NonNull TypedModel rWhenTypedModel);

	/**
	 * Accumulate the usage of this variable in a where corollary for the rWhereTypedModel.
	 */
	void setWhere(@NonNull TypedModel rWhereTypedModel);
}