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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;

import com.google.common.collect.Iterables;

public abstract class AbstractNavigationEdge extends AbstractEdge implements NavigationEdge//, GraphStringBuilder.GraphNode
{
	protected final @NonNull Property source2targetProperty;
	private @Nullable EdgeConnection incomingConnection = null;
	private @Nullable List<@NonNull EdgeConnection> outgoingConnections = null;

	protected AbstractNavigationEdge(EdgeRole.@NonNull Navigation edgeRole, @NonNull Region region,
			@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		super(edgeRole, region, sourceNode, source2targetProperty.getName(), targetNode);
		this.source2targetProperty = source2targetProperty;
//		assert (source2targetProperty.eContainer() == null) || sourceNode.isClassNode();		// Pseudo navigations may be non-classes
	}

	@Override
	public final void addIncomingConnection(@NonNull EdgeConnection edgeConnection) {
		assert incomingConnection == null;
		assert Iterables.contains(edgeConnection.getTargetEdges(), this);
//		assert edge.getRegion() == getRegion();
		incomingConnection = edgeConnection;
	}

	@Override
	public final void addOutgoingConnection(@NonNull EdgeConnection edgeConnection) {
		assert Iterables.contains(edgeConnection.getSources(), this);
//		assert edge.getRegion() == getRegion();
		List<@NonNull EdgeConnection> outgoingConnections2 = outgoingConnections;
		if (outgoingConnections2 == null) {
			outgoingConnections = outgoingConnections2 = new ArrayList<@NonNull EdgeConnection>();
		}
		else {
			assert !outgoingConnections2.contains(edgeConnection);
		}
		outgoingConnections2.add(edgeConnection);
	}

	@Override
	public final @Nullable EdgeConnection getIncomingConnection() {
		return incomingConnection;
	}

	@Override
	public @Nullable String getLabel() {
		return ((EdgeRole.Navigation)getEdgeRole()).getLabel(source2targetProperty);
	}

	@Override
	public final @NonNull List<@NonNull EdgeConnection> getOutgoingConnections() {
		return outgoingConnections != null ? outgoingConnections : SchedulerConstants.EMPTY_EDGE_CONNECTION_LIST;
	}

	@Override
	public @NonNull Property getProperty() {
		return source2targetProperty;
	}

	@Override
	public final void removeIncomingConnection(@NonNull EdgeConnection edgeConnection) {
		assert Iterables.contains(edgeConnection.getTargetEdges(), this);
//		assert edge.getRegion() == getRegion();
		assert incomingConnection != null;
		incomingConnection = null;
	}

	@Override
	public final void removeOutgoingConnection(@NonNull EdgeConnection edgeConnection) {
		assert Iterables.contains(edgeConnection.getSources(), this);
//		assert edge.getRegion() == getRegion();
		List<EdgeConnection> outgoingConnections2 = outgoingConnections;
		assert outgoingConnections2 != null;
		boolean wasRemoved = outgoingConnections2.remove(edgeConnection);
		assert wasRemoved;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		if ((incomingConnection == null) && (outgoingConnections == null)) {
			super.toGraph(s);
		}
		else {
			appendEdgeWithNode(s);
		}
	}
}