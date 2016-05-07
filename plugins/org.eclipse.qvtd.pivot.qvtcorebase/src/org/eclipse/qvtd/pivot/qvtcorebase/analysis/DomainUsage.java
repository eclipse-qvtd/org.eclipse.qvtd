/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
 * 
 * The usage identifies the domain and so typed model in which the used element participates. 
 * 
 * For AST nodes such as VariableExp or IfExp that propagate computed values, the usage is the domain(s) in which
 * the value may be stored. $primitive$ for DataTypes defined by OCL.
 * 
 * For AST nodes such as PropertyCallExp and PropertyAssignment that define model structure, the usage is equivalent
 * to the XMI model in which the AST node is serialized, if each typed model is individually serialized.
 * 
 * In the case of navigations, the domain is the domain in which the host (Property.owningClass) exists. It does not
 * matter what the target value is; it may be in another domain. The reference is in the owningClass' domain.
 * 
 * For resolved usage a DomainUsageConstant returns the domain. For unresolved usage a DomainUsageVariable identifies
 * the possibilities. Further analysis may enable the possibilities to be trimmed and eventually converted to a constant.
 * A DomainUsageVariable tracks its clients so that a resolution to a constant is propagated to all clients. 
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
	 * 
	 * @deprecated specify a context
	 */
	@Deprecated
	@Nullable TypedModel getTypedModel() throws IllegalStateException;
	
	/**
	 * Return the TypedModel for this usage, null for none, non-null for one, Exception for more than one.
	 * Note that a primitive TypedModel may be returned for DataType usage; it has no container.
	 * 
	 * Any ambiguous usgae is diagnosed with respect to the optional context.
	 */
	@Nullable TypedModel getTypedModel(@Nullable Element context) throws IllegalStateException;

	/**
	 * Return all the TypedModels for this usage. Note that a primitive TypedModel may be returned for DataType usage; it has no container.
	 */
	@NonNull Iterable<@NonNull TypedModel> getTypedModels();

	/**
	 * Return true if this usage includes usage in a checkable domain.
	 * @deprecated use isInput()
	 */
	@Deprecated
	boolean isCheckable();

	/**
	 * Return true if this usage has been resolve to zero or more TypedModels, false if it is an unresolved variable usage. 
	 */
	boolean isConstant();

	/**
	 * Return true if this usage includes usage in an enforceable domain.
	 * @deprecated use isOutput()
	 */
	@Deprecated
	boolean isEnforceable();

	/**
	 * Return true if this usage includes usage in an input domain, a domain that is fully not-enforceable transformation-wide.
	 */
	boolean isInput();

	/**
	 * Return true if this usage includes usage in the middle domain, a domain that is partially enforceable transformation-wide.
	 */
	boolean isMiddle();

	/**
	 * Return true if this usage includes usage in no domain.
	 */
	boolean isNone();

	/**
	 * Return true if this usage includes usage in an output domain, a domain that is fully enforceable transformation-wide.
	 */
	boolean isOutput();

	/**
	 * Return true if this usage includes usage in a primitive domain, a domain that is just used.
	 */
	boolean isPrimitive();
	
	public interface Internal extends DomainUsage, Comparable<DomainUsage.Internal>
	{
		void addUsedBy(@NonNull Element element);
		@NonNull DomainUsage cloneVariable();
		@Nullable Iterable<Element> getElements();
		int getMask();
	}
}
