/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * DomainUsage or rather the derived DomainUsageConstant and DomainUsageVariable identify the results of
 * the DomainUsageAnalysis of a Pivot AST node.
 */
public interface DomainUsage
{
	/**
	 * Source name of an EAnnotation that identifies domain usage of an EReference.
	 */
	static final @NonNull String QVT_DOMAINS_ANNOTATION_SOURCE = "http://www.eclipse.org/qvt#Domains";
	/**
	 * Key of an EAnnotation that identifies domain usage of an EReference. Values are the names of the Transformation ModelParameters.
	 */
	static final @NonNull String QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN = "referredDomain";

	/**
	 * Return the TypedModel for this usage, null for none, non-null for one, Exception for more than one.
	 * Note that a primitive TypedModel may be returned for DataType usage; it has no container.
	 */
	@Nullable TypedModel getTypedModel() throws IllegalStateException;

	/**
	 * Return all the TypedModels for this usage. Note that a primitive TypedModel may be returned for DataType usage; it has no container.
	 */
	@NonNull Iterable<TypedModel> getTypedModels();

	/**
	 * Return true if this usage has been resolve to zero or more TypedModels, false if it is an unresolved variable usage. 
	 */
	boolean isConstant();
	
	public interface Internal extends DomainUsage, Comparable<DomainUsage.Internal>
	{
		void addUsedBy(@NonNull Element element);
		@NonNull DomainUsage cloneVariable();
		@Nullable Iterable<Element> getElements();
		int getMask();
	}
}
