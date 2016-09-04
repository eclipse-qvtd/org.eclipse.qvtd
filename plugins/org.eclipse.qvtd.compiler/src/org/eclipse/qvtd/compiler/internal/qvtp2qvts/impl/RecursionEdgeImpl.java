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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Role;

public class RecursionEdgeImpl extends EdgeImpl
{
	public static @NonNull RecursionEdgeImpl create(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		RecursionEdgeImpl edge = new RecursionEdgeImpl();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.isPrimary = isPrimary;
		return edge;
	}

	private boolean isPrimary = false;

	@Override
	public @NonNull Edge createEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode) {
		return create(edgeRole, sourceNode, targetNode, isPrimary);
	}

	@Override
	public @NonNull String getColor() {
		return Role.RECURSION_COLOR;
	}

	@Override
	public final boolean isRecursion() {
		return true;
	}
}