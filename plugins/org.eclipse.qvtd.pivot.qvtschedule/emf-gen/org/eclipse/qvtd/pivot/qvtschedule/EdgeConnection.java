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
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

/**
 * @generated
 */
public interface EdgeConnection extends DatumConnection<NavigableEdge>
{
	void addUsedTargetEdge(@NonNull NavigableEdge targetEdge, boolean mustBeLater);
	@NonNull Property getProperty();
	@Override
	@NonNull Iterable<@NonNull NavigableEdge> getSources();
	@NonNull ConnectionRole getConnectionRole(@NonNull NavigableEdge targetEdge);
	@NonNull Iterable<@NonNull NavigableEdge> getTargetEdges();
	@Override
	@NonNull Map<@NonNull NavigableEdge, @NonNull ConnectionRole> getTargets();
}