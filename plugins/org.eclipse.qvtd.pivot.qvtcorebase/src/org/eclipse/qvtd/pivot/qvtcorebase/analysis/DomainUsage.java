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

/**
 * DomainUsage or rather the derived DomainUsageConstant and DomainUsageVariable identify the results of
 * the DomainUsageAnalysis of a Pivot AST node.
 */
public interface DomainUsage extends Comparable<DomainUsage>
{
	/**
	 * Source name of an EAnnotation that identifies domain usage of an EReference.
	 */
	public static final @NonNull String QVT_DOMAINS_ANNOTATION_SOURCE = "http://www.eclipse.org/qvt#Domains";
	/**
	 * Key of an EAnnotation that identifies domain usage of an EReference. Values are the names of the Domain enumeration.
	 */
	public static final @NonNull String QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN = "referredDomain";
	/**
	 * The names of the possible domain usage.
	 */
	enum Domain { PRIMITIVE, SOURCE, MIDDLE, TARGET, ERROR };

	void addUsedBy(@NonNull Element element);
	@Nullable Iterable<Element> getElements();
	int getMask();
	boolean isError();
	boolean isMiddle();
	boolean isPrimitive();
	boolean isSource();
	boolean isTarget();
}
