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

public class SimpleNavigationEdge extends AbstractNavigationEdge implements SimpleEdge, Iterable<SimpleEdge>
{
	public SimpleNavigationEdge(EdgeRole.@NonNull Navigation edgeRole, @NonNull SimpleRegion region, @NonNull SimpleNode parentNode, @NonNull Property source2targetProperty, @NonNull SimpleNode childrenNode) {
		super(edgeRole, region, parentNode, source2targetProperty, childrenNode);
	}

/*	@Override
	public void cloneIn(@NonNull Region clonedRegion, @NonNull Map<Node, Node> node2clone) {
		SimpleNode clonedSourceNode = (SimpleNode) node2clone.get(getSource());
		SimpleNode clonedTargetNode = (SimpleNode) node2clone.get(getTarget());
		assert (clonedSourceNode != null) && (clonedTargetNode != null);
		new SimpleNavigationEdge((NavigationEdgeRole) getEdgeRole(), (SimpleRegion) clonedRegion, clonedSourceNode, source2targetProperty, clonedTargetNode);
	} */

	@Override
	public @NonNull Iterable<SimpleEdge> getSimpleEdges() {
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
	public Iterator<SimpleEdge> iterator() {
		return new SingletonIterator<SimpleEdge>(this);
	}
}