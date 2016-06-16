/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
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
	 * Add the NavigationAssignment "cVariable.cProperty := cExpression" to the cBottomPattern inverting the usage
	 * of a Collection element assignment to "cExpression.cOppositeProperty := cVariable".
	 */
	void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression);

	/**
	 * Perform diagnostic checks at the end of the analysis.
	 */
	void check();

	/**
	 * The Core pattern in which the core variable is declared. Returns null for the 'this' variable.
	 */
	@Nullable CorePattern getCorePattern();

	/**
	 * The core variable for this analysis.
	 */
	@NonNull Variable getCoreVariable();

	/**
	 * The relation variable for this analysis. Returns null if the core variable is an additional synthesized artefact.
	 */
	@Nullable Variable getRelationVariable();

	/**
	 * Accumulate the definition of this variable by rTemplateExp in an enforced domain.
	 * If rKey is non-null the enforcement correlates with rKey.
	 */
	void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @Nullable Key rKey);

	/**
	 * Accumulate the references of this variable by an enforced domain.
	 */
	void setIsEnforcedReferred();

	/**
	 * Accumulate the usage of this variable as a domain root variable.
	 */
	void setIsRoot();

	/**
	 * Accumulate the definition of this variable by the not-enforced cOtherDomain.
	 */
	void setOtherBound(@NonNull CoreDomain cOtherDomain);

	/**
	 * Accumulate the reference of this variable by the not-enforced otherDomain.
	 */
	void setOtherReferred(@NonNull CoreDomain cOtherDomain);
	
	/**
	 * Accumulate the reference of this variable by the predicate in cPredicateArea.
	 */
	void setPredicate(@NonNull Area cPredicateArea);

	/**
	 * Accumulate the usage of this variable in a when predicate for the cWhenDomain.
	 */
	void setWhen(@NonNull CoreDomain cWhenDomain);

	/**
	 * Accumulate the usage of this variable in a where corollary for the cWhereDomain.
	 */
	void setWhere(@NonNull CoreDomain cWhereDomain);
}