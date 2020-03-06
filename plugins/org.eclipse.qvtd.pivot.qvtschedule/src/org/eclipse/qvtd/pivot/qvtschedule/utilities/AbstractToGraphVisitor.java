/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.Comparator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;

/** This code is rescued but has never worked properly */
public abstract class AbstractToGraphVisitor extends AbstractExtendingQVTscheduleVisitor<@Nullable String, @NonNull GraphStringBuilder> implements ToGraphHelper, ToGraphVisitor2
{
	public static class EdgeComparator implements Comparator<@NonNull Edge>
	{
		@Override
		public int compare(@NonNull Edge e1, @NonNull Edge e2) {
			int sec1 = 0;
			int sec2 = 0;
			if (e1.isSecondary()) {
				sec1 = 1;
				NavigationEdge o1 = ((NavigationEdge)e1).getOppositeEdge();
				assert o1 != null;
				e1 = o1;
			}
			if (e2.isSecondary()) {
				sec2 = 1;
				NavigationEdge o2 = ((NavigationEdge)e2).getOppositeEdge();
				assert o2 != null;
				e2 = o2;
			}
			int diff = sec1 - sec2;
			if (diff != 0) {
				return diff;
			}
			String n1 = e1.getName();
			String n2 = e2.getName();
			diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			String s1 = e1.toString();
			String s2 = e2.toString();
			diff = ClassUtil.safeCompareTo(s1, s2);
			if (diff != 0) {
				return diff;
			}
			return 0;
		}
	}

	public static class NodeComparator implements Comparator<@NonNull Node>
	{
		@Override
		public int compare(@NonNull Node o1, @NonNull Node o2) {
			String n1 = o1.getName();
			String n2 = o2.getName();
			int diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			String s1 = o1.toString();
			String s2 = o2.toString();
			diff = ClassUtil.safeCompareTo(s1, s2);
			if (diff != 0) {
				return diff;
			}
			int i1 = o1.getOwningRegion().getOwnedNodes().indexOf(o1);
			int i2 = o2.getOwningRegion().getOwnedNodes().indexOf(o2);
			diff = i1 - i2;
			if (diff != 0) {
				return diff;
			}
			return 0;
		}
	}

	protected static final EdgeComparator EDGE_COMPARATOR = new EdgeComparator();
	protected static final NodeComparator NODE_COMPARATOR = new NodeComparator();

	protected AbstractToGraphVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	protected void appendEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		context.appendEdge(this, source, edge, target);
	}

	protected @NonNull String appendNode(@NonNull GraphNode node) {
		return context.appendNode(this, node);
	}

	public @NonNull String close() {
		return context.close();
	}

	protected @NonNull String getColor(@NonNull GraphElement element) {
		return element.getColor();
	}

	@Override
	public @NonNull GraphStringBuilder getContext() {
		return context;
	}

	@Override
	public @NonNull GraphStringBuilder getGraphStringBuilder() {
		return context;
	}

	protected @NonNull String getLabel(@NonNull GraphNode graphNode) {
		String label = "";
		if (graphNode instanceof Node) {
			Node node = (Node)graphNode;
			label = node.getLabel();
		}
		return label;
	}

	protected @Nullable String getShape(@NonNull GraphNode graphNode) {
		String shape = null;
		if (graphNode instanceof Node) {
			Node node = (Node)graphNode;
			shape = node.getShape();
		}
		return shape;
	}

	protected @Nullable String getStyle(@NonNull GraphNode graphNode) {
		String style = null;
		if (graphNode instanceof Node) {
			Node node = (Node)graphNode;
			style = node.getStyle();
		}
		return style;
	}

	protected boolean isConditional(GraphNode graphNode) {
		boolean isConditional = false;
		if (graphNode instanceof Node) {
			Node node = (Node) graphNode;
			isConditional = node.getUtility().isConditional();
		}
		else if (graphNode instanceof Edge) {
			Edge edge = (Edge) graphNode;
			isConditional = edge.getUtility().isConditional();
		}
		return isConditional;
	}

	protected boolean isExpression(GraphNode graphNode) {
		boolean isExpression = false;
		if (graphNode instanceof Node) {
			Node node = (Node) graphNode;
			isExpression = node.isExpression();
		}
		return isExpression;
	}

	protected boolean isHead(@NonNull GraphNode graphNode) {
		boolean isHead = false;
		if (graphNode instanceof Node) {
			Node node = (Node) graphNode;
			isHead = node.isHead();
		}
		return isHead;
	}

	@Override
	public void setColor(@NonNull GraphElement element) {
		String color = getColor(element);
		context.setColor(color);
	}

	@Override
	public void setHead(@NonNull GraphNode graphNode) {
		boolean isHead = isHead(graphNode);
		if (isHead) {
			context.setHead();
		}
	}

	@Override
	public void setLabel(@NonNull GraphNode graphNode) {
		String label = getLabel(graphNode);
		context.setLabel(label);
	}

	@Override
	public void setPenwidth(@NonNull GraphNode graphNode) {
		boolean isHead = isHead(graphNode);
		boolean isExpression = /*isExpression*/isConditional(graphNode);
		context.setPenwidth(isHead ? QVTscheduleConstants.HEAD_WIDTH : !isExpression ? 2*QVTscheduleConstants.LINE_WIDTH : QVTscheduleConstants.LINE_WIDTH);
	}

	@Override
	public void setShapeAndStyle(@NonNull GraphNode graphNode) {
		String shape = getShape(graphNode);
		String style = getStyle(graphNode);
		if (shape != null) {
			context.setShape(shape);
		}
		if (style != null) {
			context.setStyle(style);
		}
	}

	@Override
	public @NonNull String toString() {
		return context.toString();
	}

	public void visit(@NonNull Graphable graphable) {
		graphable.acceptGraphVisitor(this);
	}

	@Override
	public @Nullable String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}
}