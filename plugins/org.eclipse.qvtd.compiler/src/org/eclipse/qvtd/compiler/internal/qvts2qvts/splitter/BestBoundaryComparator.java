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

import java.util.Comparator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;

/**
 * BestBoundaryComparator supports comparison of boundaries so that more easily realizeable cross-boundary iterations are sorted first.
 */
class BestBoundaryComparator implements Comparator<@NonNull Boundary>
{
	public static final @NonNull BestBoundaryComparator INSTANCE = new BestBoundaryComparator();

	@Override
	public int compare(@NonNull Boundary o1, @NonNull Boundary o2) {
		// boolean: true better than false
		boolean b1 = o1.isReverseNavigable();
		boolean b2 = o2.isReverseNavigable();
		if (b1 != b2) {
			return b1 ? -1 : 1;
		}
		Edge e1 = o1.getEdge();
		Edge e2 = o2.getEdge();
		b1 = e1.isConstant();
		b2 = e2.isConstant();
		if (b1 != b2) {
			return b1 ? -1 : 1;
		}
		b1 = e1.isLoaded();
		b2 = e2.isLoaded();
		if (b1 != b2) {
			return b1 ? -1 : 1;
		}
		b1 = e1.isPredicated();
		b2 = e2.isPredicated();
		if (b1 != b2) {
			return b1 ? -1 : 1;
		}
		return ClassUtil.safeCompareTo(o1.getName(), o2.getName());
	}
}