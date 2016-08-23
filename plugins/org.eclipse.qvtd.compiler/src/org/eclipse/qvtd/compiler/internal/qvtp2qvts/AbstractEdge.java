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
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder.GraphNode;

/**
 * AbstractEdge.
 */
public abstract class AbstractEdge implements Edge
{
	private @NonNull EdgeRole edgeRole;
	protected final @NonNull Region region;
	private @NonNull Node sourceNode;
	private @NonNull Node targetNode;
	protected final @Nullable String name;

	protected AbstractEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		this.edgeRole = edgeRole;
		this.region = sourceNode.getRegion();
		this.sourceNode = sourceNode;
		this.name = name;
		this.targetNode = targetNode;
		assert sourceNode != targetNode;
		region.addEdge(this);
		sourceNode.addOutgoingEdge(this);
		targetNode.addIncomingEdge(this);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
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
		final Node sourceNode = getSource();
		final Node targetNode = getTarget();
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

	@Override
	public void destroy() {
		this.sourceNode.removeOutgoingEdge(this);
		this.targetNode.removeIncomingEdge(this);
		this.region.removeEdge(this);
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
		return edgeRole.getColor();
	}

	@Override
	public @NonNull EdgeRole getEdgeRole() {
		return edgeRole;
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
		return isNavigation() ? 2*Role.LINE_WIDTH : Role.LINE_WIDTH;
	}

	@Override
	public @NonNull Region getRegion() {
		return region;
	}

	@Override
	public @NonNull Node getSource() {
		return sourceNode;
	}

	public @Nullable String getStyle() {
		return isMatched() ? null : "dashed";
	}

	@Override
	public @NonNull Node getTarget() {
		return targetNode;
	}

	@Override
	public boolean isCast() {
		return edgeRole.isCast();
	}

	@Override
	public boolean isComputation() {
		return edgeRole.isComputation();
	}

	@Override
	public boolean isConstant() {
		return edgeRole.isConstant();
	}

	@Override
	public boolean isExpression() {
		return edgeRole.isExpression();
	}

	@Override
	public boolean isLoaded() {
		return edgeRole.isLoaded();
	}

	@Override
	public final boolean isMatched() {
		return sourceNode.isMatched() && targetNode.isMatched();
	}

	@Override
	public boolean isNavigation() {
		return edgeRole.isNavigation();
	}

	@Override
	public boolean isNew() {
		return edgeRole.isNew();
	}

	@Override
	public boolean isOld() {
		return edgeRole.isOld();
	}

	@Override
	public boolean isPredicate() {
		return edgeRole.isPredicate();
	}

	@Override
	public boolean isPredicated() {
		return edgeRole.isPredicated();
	}

	@Override
	public boolean isRealized() {
		return edgeRole.isRealized();
	}

	@Override
	public boolean isRecursion() {
		return edgeRole.isRecursion();
	}

	protected void mergeRole(@NonNull EdgeRole edgeRole) {
		if (this.edgeRole != edgeRole) {
			this.edgeRole = this.edgeRole.merge(edgeRole);
		}
	}

	@Override
	public void setSource(@NonNull Node sourceNode) {
		this.sourceNode.removeOutgoingEdge(this);
		this.sourceNode = sourceNode;
		this.sourceNode.addOutgoingEdge(this);
	}

	@Override
	public void setTarget(@NonNull Node targetNode) {
		this.targetNode.removeIncomingEdge(this);
		this.targetNode = targetNode;
		this.targetNode.addIncomingEdge(this);
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.appendEdge(getSource(), this, getTarget());
	}

	@Override
	public @NonNull String toString() {
		return edgeRole.toString() + "(" + getSource().toString() + "=>" + getName() + "=>" + getTarget().toString() + ")";
	}
}