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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

/**
 * An EdgeConnection supports an existence dependency between the region(s) that produce a navigation edge
 * and the region(s) that consume it.
 */
public interface EdgeConnection extends DatumConnection
{
	void addUsedTargetEdge(@NonNull NavigationEdge targetEdge, boolean mustBeLater);
	@NonNull Property getProperty();
	@Override
	@NonNull Iterable<@NonNull NavigationEdge> getSources();
	@NonNull ConnectionRole getConnectionRole(@NonNull NavigationEdge targetEdge);
	@NonNull Iterable<@NonNull NavigationEdge> getTargetEdges();
	@Override
	@NonNull Map<@NonNull NavigationEdge, @NonNull ConnectionRole> getTargets();
}