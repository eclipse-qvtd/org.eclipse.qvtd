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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;

/**
 * A Boundary describes an edge between the reachable nodes of two head groups.
 */
class Boundary implements Nameable
{
	protected final @NonNull SimpleGroup sourceGroup;
	protected final @NonNull Edge edge;
	protected final @NonNull SimpleGroup targetGroup;
	protected final @NonNull String name;

	public Boundary(@NonNull SimpleGroup sourceGroup, @NonNull Edge edge, @NonNull SimpleGroup targetGroup) {
		this.sourceGroup = sourceGroup;
		this.edge = edge;
		this.targetGroup = targetGroup;
		this.name = sourceGroup.getName() + "==>" + edge.getName() + "==>" + targetGroup.getName();
	}

	public @NonNull Edge getEdge() {
		return edge;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull SimpleGroup getSourceGroup() {
		return sourceGroup;
	}

	public @NonNull SimpleGroup getTargetGroup() {
		return targetGroup;
	}

	public boolean isReverseNavigable() {
		if (!(edge instanceof NavigationEdge)) {
			return false;
		}
		Property forwardProperty = ((NavigationEdge)edge).getProperty();
		Property reverseProperty = forwardProperty.getOpposite();
		if (reverseProperty == null) {
			return false;
		}
		return !reverseProperty.isIsImplicit();
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}