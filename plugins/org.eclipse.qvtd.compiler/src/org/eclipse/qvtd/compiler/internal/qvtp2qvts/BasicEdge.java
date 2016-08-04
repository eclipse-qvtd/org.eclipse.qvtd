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

public class BasicEdge extends AbstractEdge
{
	public BasicEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		super(edgeRole, sourceNode, name, targetNode);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitBasicEdge(this);
	}

	@Override
	public boolean isSecondary() {
		return false;
	}
}