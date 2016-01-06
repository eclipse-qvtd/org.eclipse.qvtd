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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;

public abstract class AbstractNavigationEdge extends AbstractEdge implements NavigationEdge
{
	protected final @NonNull Property source2targetProperty;

	protected AbstractNavigationEdge(EdgeRole.@NonNull Navigation edgeRole, @NonNull Region region,
			@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		super(edgeRole, region, sourceNode, source2targetProperty.getName(), targetNode);
		this.source2targetProperty = source2targetProperty;
//		assert (source2targetProperty.eContainer() == null) || sourceNode.isClassNode();		// Pseudo navigations may be non-classes
	}

	@Override
	public @Nullable String getLabel() {
		return ((EdgeRole.Navigation)getEdgeRole()).getLabel(source2targetProperty);
	}

	@Override
	public @NonNull Property getProperty() {
		return source2targetProperty;
	}

	@Override
	public boolean isContainer() {
		Property target2sourceProperty = source2targetProperty.getOpposite();
		return (target2sourceProperty != null) && target2sourceProperty.isIsComposite();
	}

	@Override
	public boolean isContainment() {
		return source2targetProperty.isIsComposite();
	}
}