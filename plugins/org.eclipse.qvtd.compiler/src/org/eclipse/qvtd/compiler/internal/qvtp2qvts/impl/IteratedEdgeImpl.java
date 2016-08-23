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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.BasicEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;

public class IteratedEdgeImpl extends BasicEdge
{
	public static @NonNull IteratedEdgeImpl create(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		IteratedEdgeImpl edge = new IteratedEdgeImpl();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	@Override
	public @NonNull BasicEdge createEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode) {
		return create(edgeRole, sourceNode, getName(), targetNode);
	}

	@Override
	public final boolean isComputation() {
		return true;
	}

	//	@Override
	//	public final boolean isIterated() {
	//		return true;
	//	}
}