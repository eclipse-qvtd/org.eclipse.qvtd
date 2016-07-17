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
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;

/**
 * A Connection is a directed hyper edge between one or more source nodes in one or more regions and
 * one or more target nodes in one or more target regions.
 */
public interface Connection extends /*Edge*/ Nameable, Symbolable, Visitable
{
	void destroy();

	/**
	 * Return a non-standard style for the arrow head.
	 */
	@Nullable String getArrowhead();

	/**
	 * Return the color with which this edge is drawn.
	 */
	@NonNull String getColor();

	@NonNull ConnectionRole getConnectionRole();

	/**
	 * Return a formatted label to accompany the edge, or null for no label.
	 */
	@Nullable String getLabel();
	@NonNull ScheduledRegion getRegion();

	void toCallGraph(@NonNull GraphStringBuilder s);
	void toGraph(@NonNull GraphStringBuilder s);
	void toRegionGraph(@NonNull ScheduledRegion scheduledRegion, @NonNull GraphStringBuilder s);
}