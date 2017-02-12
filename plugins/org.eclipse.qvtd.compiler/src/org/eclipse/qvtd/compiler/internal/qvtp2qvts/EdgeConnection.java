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

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;

/**
 * An EdgeConnection supports an existence dependency between the region(s) that produce a navigation edge
 * and the region(s) that consume it.
 */
public interface EdgeConnection extends DatumConnection
{
	void addUsedTargetEdge(@NonNull NavigableEdge targetEdge, boolean mustBeLater);
	@NonNull Property getProperty();
	@Override
	@NonNull Iterable<@NonNull NavigableEdge> getSources();
	@NonNull ConnectionRole getConnectionRole(@NonNull NavigableEdge targetEdge);
	@NonNull Iterable<@NonNull NavigableEdge> getTargetEdges();
	@Override
	@NonNull Map<@NonNull NavigableEdge, org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole> getTargets();
}