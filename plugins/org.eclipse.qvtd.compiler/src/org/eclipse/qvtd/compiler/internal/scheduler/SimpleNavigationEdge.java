/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

public class SimpleNavigationEdge extends AbstractNavigationEdge implements SimpleEdge, Iterable<@NonNull SimpleEdge>
{
	public SimpleNavigationEdge(EdgeRole.@NonNull Navigation edgeRole, @NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
		super(edgeRole, region, sourceNode, source2targetProperty, targetNode);
	}

	@Override
	public @NonNull String getDisplayName() {
		return source2targetProperty.getOwningClass().getName() + "::" + source2targetProperty.getName();
	}

	@Override
	public @NonNull Iterable<@NonNull SimpleEdge> getSimpleEdges() {
		return this;
	}

	@Override
	public @NonNull SimpleNode getSource() {
		return (SimpleNode) super.getSource();
	}

	@Override
	public @NonNull SimpleNode getTarget() {
		return (SimpleNode) super.getTarget();
	}

	@Override
	public @NonNull Iterator<@NonNull SimpleEdge> iterator() {
		return new SingletonIterator<@NonNull SimpleEdge>(this);
	}
}