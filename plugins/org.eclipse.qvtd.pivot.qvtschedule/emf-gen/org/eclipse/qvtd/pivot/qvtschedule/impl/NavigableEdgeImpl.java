/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigable Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class NavigableEdgeImpl extends EdgeImpl implements NavigableEdge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigableEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NAVIGABLE_EDGE;
	}

	private @Nullable Property source2targetProperty = null;		// null is only permitted during construction


	/**
	 * Non-null if this edge is part of a bidirectional pair.
	 */
	private @Nullable NavigableEdge oppositeEdge = null;

	/**
	 * True if this edge is the auto-created second half of a bidirectional pair.
	 */
	private boolean isSecondary = false;

	private @Nullable EdgeConnection incomingConnection = null;
	private @Nullable List<@NonNull EdgeConnection> outgoingConnections = null;

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
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getColor());
		@Nullable
		NavigableEdge oppositeEdge2 = oppositeEdge;
		if (oppositeEdge2 != null) {
			String oppositeLabel = oppositeEdge2.getLabel();
			if ((oppositeLabel != null) && !oppositeEdge2.getProperty().getName().equals(((Node)source).getClassDatumAnalysis().getCompleteClass().getName())) {
				s.setTaillabel(oppositeLabel);
			}
		}
		String label = getLabel();
		if (label != null) {
			s.setHeadlabel(label);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		if (!isSecondary() && (oppositeEdge2 != null)) {
			s.setDir("both");
			s.setArrowtail("vee");
		}
		s.setArrowhead("normal");
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(source, this, target);
	}

	@Override
	public void destroy() {
		NavigableEdge oppositeEdge = this.oppositeEdge;
		if (oppositeEdge != null) {
			this.oppositeEdge = null;
			oppositeEdge.destroy();
		}
		else {
			super.destroy();
		}
	}

	@Override
	public @NonNull String getDisplayName() {
		Property source2targetProperty2 = source2targetProperty;
		if (source2targetProperty2 != null) {
			org.eclipse.ocl.pivot.Class owningClass = source2targetProperty2.getOwningClass();
			if (owningClass != null) {
				return owningClass.getName() + "::" + source2targetProperty2.getName();
			}
			else {
				return "" + source2targetProperty2.getName();
			}
		}
		else {
			return "null";
		}
	}

	@Override
	public @NonNull NavigableEdge getForwardEdge() {
		if (isSecondary) {
			assert oppositeEdge != null;
			return oppositeEdge;
		}
		else {
			return this;
		}
	}


	@Override
	public final @Nullable EdgeConnection getIncomingConnection() {
		return incomingConnection;
	}

	@Override
	public @Nullable String getLabel() {
		@Nullable
		Property source2targetProperty2 = source2targetProperty;
		if (source2targetProperty2 == null) {
			return "null";
		}
		else if (source2targetProperty2.eContainer() != null) {
			return source2targetProperty2.getName() + "\\n" + PivotUtil.getMultiplicity(source2targetProperty2);
		}
		else {
			return source2targetProperty2.getName();
		}
	}

	@Override
	public @Nullable NavigableEdge getOppositeEdge() {
		return oppositeEdge;
	}

	@Override
	public final @NonNull List<@NonNull EdgeConnection> getOutgoingConnections() {
		return outgoingConnections != null ? outgoingConnections : QVTscheduleConstants.EMPTY_EDGE_CONNECTION_LIST;
	}

	@Override
	public @NonNull Property getProperty() {
		return ClassUtil.nonNullState(source2targetProperty);
	}

	protected void initialize(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		setProperty(source2targetProperty);
	}

	protected void initializeOpposite(@NonNull NavigableEdgeImpl oppositeEdge) {
		this.oppositeEdge = oppositeEdge;
		oppositeEdge.oppositeEdge = this;
		if (this.getProperty().isIsImplicit()) {
			this.isSecondary = true;
		}
		else {
			oppositeEdge.isSecondary = true;
		}
	}

	@Override
	public boolean isSecondary() {
		return isSecondary;
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
		@SuppressWarnings("unused")boolean wasRemoved = outgoingConnections2.remove(edgeConnection);
		//			assert wasRemoved;   -- destroy subverts this
	}

	public void setProperty(Property source2targetProperty) {
		this.source2targetProperty = source2targetProperty;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		if (isSecondary()) {
			// Let primary draw a bidirectional edge
		}
		else if ((incomingConnection == null) && (outgoingConnections == null)) {
			super.toGraph(s);
		}
		else {
			appendEdgeWithNode(s);
		}
	}

	//	@Override
	//	public void setSource(@Nullable Node sourceNode) {
	//		assert (sourceNode == null) || !sourceNode.isOperation();
	//		super.setSource(sourceNode);
	//	}

	//	@Override
	//	public void setTarget(@Nullable Node targetNode) {
	//		assert (targetNode == null) || !targetNode.isOperation();
	//		super.setTarget(targetNode);
	//	}

} //NavigableEdgeImpl
