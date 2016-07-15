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

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class BasicSimpleEdge extends AbstractEdge implements SimpleEdge
{
	public BasicSimpleEdge(@NonNull EdgeRole edgeRole, @NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @Nullable String name, @NonNull SimpleNode targetNode) {
		super(edgeRole, region, sourceNode, name, targetNode);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitBasicSimpleEdge(this);
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
	public Iterator<@NonNull SimpleEdge> iterator() {
		return new SingletonIterator<@NonNull SimpleEdge>(this);
	}
}