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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;

public interface NavigableEdge extends Edge, ConnectionEnd
{
	void addIncomingConnection(@NonNull EdgeConnection edgeConnection);
	void addOutgoingConnection(@NonNull EdgeConnection edgeConnection);

	/**
	 * Create an edgeRole edge from sourceNode to targetNode with the same property as this edge.	 * @param edgeRole
	 */
	@Override
	@NonNull NavigableEdge createEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode, @Nullable Boolean isPartial);

	@Override
	@NonNull NavigableEdge getForwardEdge();

	@Nullable EdgeConnection getIncomingConnection();

	@NonNull List<@NonNull EdgeConnection> getOutgoingConnections();

	/**
	 * Return the other edge in a pair of bidirectionally to-one edges, or null if unidirectional.
	 */
	@Nullable NavigableEdge getOppositeEdge();

	/**
	 * Return the property that this edge navigates from source to target.
	 */
	@NonNull Property getProperty();

	void removeIncomingConnection(@NonNull EdgeConnection edgeConnection);
	void removeOutgoingConnection(@NonNull EdgeConnection edgeConnection);
}