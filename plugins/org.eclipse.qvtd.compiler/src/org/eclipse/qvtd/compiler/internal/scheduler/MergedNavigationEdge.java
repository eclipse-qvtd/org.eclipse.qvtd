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
import org.eclipse.ocl.pivot.Property;

/**
 * MergedEdge contributes a merge of multiple edges as part of a MergedRegion.
 */
public class MergedNavigationEdge extends MergedEdge implements NavigationEdge
{
	protected final @NonNull Property source2targetProperty;
	
	public MergedNavigationEdge(@NonNull MergedRegion mergedRegion, @NonNull MergedNode sourceNode, @NonNull NavigationEdge primaryEdge, @NonNull MergedNode targetNode) {
		super(mergedRegion, sourceNode, primaryEdge, targetNode);
		source2targetProperty = primaryEdge.getProperty();
	}

	@Override
	public @NonNull String getLabel() {
		return getName() + "\\n" + SchedulerConstants.getMultiplicity(source2targetProperty);
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