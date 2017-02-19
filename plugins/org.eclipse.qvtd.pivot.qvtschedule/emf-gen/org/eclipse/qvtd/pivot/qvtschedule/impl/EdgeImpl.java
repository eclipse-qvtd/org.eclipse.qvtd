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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Visitor2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class EdgeImpl extends ElementImpl implements Edge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.EDGE;
	}

	private @Nullable EdgeRole edgeRole = null;		// null is only permitted during construction
	private @Nullable Node sourceNode = null;		// null is only permitted during construction
	private @Nullable Node targetNode = null;		// null is only permitted during construction
	private @Nullable String name = null;

	@Override
	public <R> R accept(@NonNull Visitor2<R> visitor) {
		return visitor.visitEdge(this);
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getColor());
		String label = getLabel();
		if (label != null) {
			s.setLabel(label);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		String arrowhead = getArrowhead();
		if (arrowhead != null) {
			s.setArrowhead(arrowhead);
		}
		String arrowtail = getArrowtail();
		if (arrowtail != null) {
			s.setArrowtail(arrowtail);
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(source, this, target);
	}

	protected void appendEdgeWithNode(@NonNull GraphStringBuilder s) {
		final Node sourceNode = getEdgeSource();
		final Node targetNode = getEdgeTarget();
		s.appendEdge(sourceNode, this, targetNode);
		/*		GraphEdge graphEdge1 = new GraphEdge()
		{
			@Override
			public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
				s.setColor(getColor());
				s.setPenwidth(getPenwidth());
				s.appendAttributedEdge(source, this, target);
			}

			@Override
			public @NonNull GraphNode getSource() {
				return sourceNode;
			}

			@Override
			public @NonNull GraphNode getTarget() {
				return AbstractEdge.this;
			}
		};
		GraphEdge graphEdge2 = new GraphEdge()
		{
			@Override
			public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
				s.setColor(getColor());
				s.setPenwidth(getPenwidth());
				s.appendAttributedEdge(source, this, target);
			}

			@Override
			public @NonNull GraphNode getSource() {
				return AbstractEdge.this;
			}

			@Override
			public @NonNull GraphNode getTarget() {
				return targetNode;
			}
		};
		s.appendNode(this);
		s.appendEdge(graphEdge1.getSource(), graphEdge1, graphEdge1.getTarget());
		s.appendEdge(graphEdge2.getSource(), graphEdge2, graphEdge2.getTarget()); */
	}

	/*	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		String name = getName();
/ *		String indexText = getIndexText();
		if (indexText != null) {
			name = name + "\\n " + indexText;
		} * /
		s.setLabel(name);
		s.setShape("ellipse");
//		String style = getStyle();
//		if (style != null) {
//			s.setStyle(style);
//		}
		s.setColor(getColor());
		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
	} */

	private void connect() {
		Node sourceNode2 = this.sourceNode;
		Node targetNode2 = this.targetNode;
		assert sourceNode2 != null;
		assert targetNode2 != null;
		assert sourceNode2 != targetNode2;
		Region region = QVTscheduleUtil.getRegion(sourceNode2);
		assert region == targetNode2.getRegion();
		region.addEdge(this);
		sourceNode2.addOutgoingEdge(this);
		targetNode2.addIncomingEdge(this);
		assert !sourceNode2.isDependency() || targetNode2.isDependency() || targetNode2.isOperation();	// sourceNode2.isDependency() implies (targetNode2.isDependency() or targetNode2.isOperation())
		assert !targetNode2.isDependency() || sourceNode2.isDependency();								// targetNode2.isDependency() implies sourceNode2.isDependency()
	}

	@Override
	public void destroy() {
		Node sourceNode2 = this.sourceNode;
		Node targetNode2 = this.targetNode;
		if ((sourceNode2 != null) && (targetNode2 != null)) {
			Region region = QVTscheduleUtil.getRegion(sourceNode2);
			sourceNode2.removeOutgoingEdge(this);
			targetNode2.removeIncomingEdge(this);
			region.removeEdge(this);
		}
	}

	private void disconnect() {
		if (this.sourceNode != null) {
			this.sourceNode.removeOutgoingEdge(this);
		}
		if (this.targetNode != null) {
			this.targetNode.removeIncomingEdge(this);
		}
		this.sourceNode = null;
		this.targetNode = null;
	}

	@Override
	public String getArrowhead() {
		return null;
	}

	@Override
	public String getArrowtail() {
		return isNavigation() ? "vee" : null;
	}

	@Override
	public @NonNull String getColor() {
		assert edgeRole != null;
		return QVTscheduleUtil.getColor(edgeRole);
	}

	@Override
	public @NonNull EdgeRole getEdgeRole() {
		return ClassUtil.nonNullState(edgeRole);
	}

	@Override
	public @NonNull Edge getForwardEdge() {
		return this;
	}

	@Override
	public @Nullable String getLabel() {
		return name;
	}

	@Override
	public @Nullable String getName() {
		return name;
	}

	public @NonNull Integer getPenwidth() {
		return isNavigation() ? 2*QVTscheduleConstants.LINE_WIDTH : QVTscheduleConstants.LINE_WIDTH;
	}

	@Override
	public @NonNull Region getRegion() {
		return QVTscheduleUtil.getRegion(ClassUtil.nonNullState(sourceNode));
	}

	@Override
	public @NonNull Node getEdgeSource() {
		return ClassUtil.nonNullState(sourceNode);
	}

	public @Nullable String getStyle() {
		return isMatched() ? null : "dashed";
	}

	@Override
	public @NonNull Node getEdgeTarget() {
		return ClassUtil.nonNullState(targetNode);
	}

	protected void initialize(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		setEdgeRole(edgeRole);
		setName(name);
		setSource(sourceNode);
		setTarget(targetNode);
	}

	@Override
	public boolean isCast() {
		return false;
	}

	@Override
	public boolean isComputation() {
		return false;
	}

	@Override
	public boolean isConstant() {
		assert edgeRole != null;
		return edgeRole.isConstant();
	}

	@Override
	public final boolean isDependency() {
		return ClassUtil.nonNullState(sourceNode).isDependency();
	}

	@Override
	public boolean isExpression() {
		return false;
	}

	@Override
	public boolean isLoaded() {
		assert edgeRole != null;
		return edgeRole.isLoaded();
	}

	@Override
	public final boolean isMatched() {
		return ClassUtil.nonNullState(sourceNode).isMatched() && ClassUtil.nonNullState(targetNode).isMatched();
	}

	@Override
	public boolean isNavigation() {
		return false;
	}

	@Override
	public boolean isNew() {
		assert edgeRole != null;
		return edgeRole.isNew();
	}

	@Override
	public boolean isOld() {
		assert edgeRole != null;
		return edgeRole.isOld();
	}

	@Override
	public boolean isPartial() {
		return false;
	}

	@Override
	public boolean isPredicate() {
		return false;
	}

	@Override
	public boolean isPredicated() {
		assert edgeRole != null;
		return edgeRole.isPredicated();
	}

	@Override
	public boolean isRealized() {
		assert edgeRole != null;
		return edgeRole.isRealized();
	}

	@Override
	public boolean isRecursion() {
		return false;
	}

	@Override
	public boolean isSecondary() {
		return false;
	}

	@Override
	public boolean isUnconditional() {
		return ClassUtil.nonNullState(sourceNode).isUnconditional() && ClassUtil.nonNullState(targetNode).isUnconditional();
	}

	protected void mergeRole(@NonNull EdgeRole edgeRole) {
		if (this.edgeRole != edgeRole) {
			assert this.edgeRole != null;
			this.edgeRole = QVTscheduleUtil.mergeToMoreKnownPhase(this.edgeRole, edgeRole);
		}
	}

	public void setEdgeRole(@NonNull EdgeRole edgeRole) {
		this.edgeRole = edgeRole;
	}


	public void setName(@Nullable String name) {
		this.name = name;
	}

	@Override
	public void setSource(@Nullable Node sourceNode) {
		if (this.sourceNode != sourceNode) {
			if (sourceNode == null) {
				disconnect();
			}
			else {
				if (this.sourceNode != null) {
					//					this.sourceNode.removeOutgoingEdge(this);
					disconnect();
				}
				this.sourceNode = sourceNode;
				if (this.targetNode != null) {
					connect();
				}
			}
		}
	}

	@Override
	public void setTarget(@Nullable Node targetNode) {
		if (this.targetNode != targetNode) {
			if (targetNode == null) {
				disconnect();
			}
			else {
				if (this.targetNode != null) {
					//					this.targetNode.removeIncomingEdge(this);
					disconnect();
				}
				this.targetNode = targetNode;
				if (this.sourceNode != null) {
					connect();
				}
			}
		}
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.appendEdge(getEdgeSource(), this, getEdgeTarget());
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getEdgeRole().getPhase());
		s.append("-");
		s.append(getClass().getSimpleName().replace("Impl",  ""));
		s.append("(");
		s.append(String.valueOf(sourceNode));
		s.append("=>");
		s.append(String.valueOf(name));
		s.append("=>");
		s.append(String.valueOf(targetNode));
		s.append(")");
		return s.toString();
	}

} //EdgeImpl