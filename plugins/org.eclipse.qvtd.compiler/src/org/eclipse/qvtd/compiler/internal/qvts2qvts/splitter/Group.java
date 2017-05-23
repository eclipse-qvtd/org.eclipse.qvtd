/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A Group participates in a hierarchy of groups that determine the scheduling of a multi-head region.
 */
interface Group extends Nameable
{
	@NonNull Iterable<@NonNull Node> getHeadNodes();

	@NonNull Iterable<@NonNull Node> getReachableNodes();

	@Override
	@NonNull String toString();

	void toString(@NonNull StringBuilder s, int depth);
}