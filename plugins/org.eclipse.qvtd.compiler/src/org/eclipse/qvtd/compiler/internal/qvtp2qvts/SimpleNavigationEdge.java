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
import org.eclipse.ocl.pivot.Property;

public class SimpleNavigationEdge extends AbstractNavigationEdge
{
	public SimpleNavigationEdge(EdgeRole.@NonNull Navigation edgeRole, @NonNull Region region, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		super(edgeRole, region, sourceNode, source2targetProperty, targetNode);
		//		assert !sourceNode.isOperation();			// FIXME testExample2_V2 violates this to cast an intermediate "if"
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSimpleNavigationEdge(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return source2targetProperty.getOwningClass().getName() + "::" + source2targetProperty.getName();
	}
}