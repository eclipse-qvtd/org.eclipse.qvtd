/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;

/**
 * A SimpleNode together with SimpleEdges define the content of a SimpleRegion (no merging).
 */
public interface SimpleNode extends Node
{
	void addTypedElement(@NonNull TypedElement typedElement);
	@NonNull Iterable<@NonNull SimpleNavigationEdge> getCastEdges();
	@Override
	@Nullable SimpleNavigationEdge getNavigationEdge(@NonNull Property source2targetProperty);
	@Override
	@Nullable SimpleNode getNavigationTarget(@NonNull Property source2targetProperty);
	@Nullable SimpleEdge getPredicateEdge(@NonNull Property source2targetProperty);
	@Override
	@NonNull SimpleRegion getRegion();
	@NonNull Iterable<@NonNull ? extends SimpleEdge> getResultEdges();
	void mergeRole(@NonNull NodeRole nodeRole);
}