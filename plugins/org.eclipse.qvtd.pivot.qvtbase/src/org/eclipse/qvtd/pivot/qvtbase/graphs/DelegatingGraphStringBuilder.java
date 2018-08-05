/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.graphs;

import org.eclipse.jdt.annotation.NonNull;

public abstract class DelegatingGraphStringBuilder implements GraphStringBuilder
{
	protected final @NonNull GraphStringBuilder delegate;

	protected DelegatingGraphStringBuilder(@NonNull GraphStringBuilder delegate) {
		this.delegate = delegate;
	}

	@Override
	public void appendAttributedEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		delegate.appendAttributedEdge(source, edge, target);
	}

	@Override
	public void appendAttributedNode(@NonNull String nodeName) {
		delegate.appendAttributedNode(nodeName);
	}

	@Override
	public void appendEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		delegate.appendEdge(source, edge, target);
	}

	@Override
	public @NonNull String appendNode(@NonNull GraphNode node) {
		return delegate.appendNode(node);
	}

	@Override
	public void popCluster() {
		delegate.popCluster();
	}

	@Override
	public void pushCluster() {
		delegate.pushCluster();
	}

	@Override
	public void setArrowhead(@NonNull String arrowhead) {
		delegate.setArrowhead(arrowhead);
	}

	@Override
	public void setArrowtail(@NonNull String arrowtail) {
		delegate.setArrowtail(arrowtail);
	}

	@Override
	public void setColor(@NonNull String color) {
		delegate.setColor(color);
	}

	@Override
	public void setDir(@NonNull String color) {
		delegate.setDir(color);
	}

	@Override
	public void setFillColor(@NonNull String color) {
		delegate.setFillColor(color);
	}

	@Override
	public void setHead() {
		delegate.setHead();
	}

	@Override
	public void setHeadlabel(String string) {
		delegate.setHeadlabel(string);
	}

	@Override
	public void setLabel(String string) {
		delegate.setLabel(string);
	}

	@Override
	public void setPenwidth(@NonNull Integer penwidth) {
		delegate.setPenwidth(penwidth);
	}

	@Override
	public void setShape(@NonNull String shape) {
		delegate.setShape(shape);
	}

	@Override
	public void setStyle(@NonNull String style) {
		delegate.setStyle(style);
	}

	@Override
	public void setTaillabel(String string) {
		delegate.setTaillabel(string);
	}

	@Override
	public @NonNull String toString() {
		return delegate.toString();
	}
}