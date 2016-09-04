/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.VariableNodeImpl;

public abstract class AbstractVisitor<R> implements Visitor<R>
{
	public <@NonNull T extends R> T create(@NonNull Class<T> returnClass, @NonNull Visitable visitable) {
		R result = visitable.accept(this);
		if (result == null) {
			throw new NullPointerException("null return from SplitterVisitor for " + visitable.getClass().getSimpleName());
		}
		if (!returnClass.isAssignableFrom(result.getClass())) {
			throw new ClassCastException("bad return from SplitterVisitor for " + visitable.getClass().getSimpleName());
		}
		@SuppressWarnings("unchecked") T castVisitable = (T) result;
		return castVisitable;
	}

	@Override
	public R visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public R visitBasicEdgeConnection(@NonNull BasicEdgeConnection basicEdgeConnection) {
		return visiting(basicEdgeConnection);
	}

	@Override
	public R visitBasicNodeConnection(@NonNull BasicNodeConnection basicNodeConnection) {
		return visiting(basicNodeConnection);
	}

	@Override
	public R visitCyclicScheduledRegion(@NonNull CyclicScheduledRegion cyclicScheduledRegion) {
		return visitRegion(cyclicScheduledRegion);
	}

	@Override
	public R visitEdge(@NonNull Edge edge) {
		return visiting(edge);
	}

	@Override
	public R visitMappingRegion(@NonNull MappingRegion mappingRegion) {
		return visitRegion(mappingRegion);
	}

	@Override
	public R visitNavigableEdge(@NonNull NavigableEdge navigationEdge) {
		return visitEdge(navigationEdge);
	}

	@Override
	public R visitNode(@NonNull Node node) {
		return visiting(node);
	}

	@Override
	public R visitOperationRegion(@NonNull OperationRegion operationRegion) {
		return visitRegion(operationRegion);
	}

	@Override
	public R visitRegion(@NonNull Region region) {
		return visiting(region);
	}

	@Override
	public R visitRootCompositionRegion(@NonNull RootCompositionRegion rootCompositionRegion) {
		return visitRegion(rootCompositionRegion);
	}

	@Override
	public R visitRootScheduledRegion(@NonNull RootScheduledRegion rootScheduledRegion) {
		return visitRegion(rootScheduledRegion);
	}

	@Override
	public R visitVariableNode(@NonNull VariableNodeImpl variableNode) {
		return visitNode(variableNode);
	}
}