/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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

public interface GraphStringBuilder
{
	public static interface GraphElement
	{
		@NonNull String getColor();
	}

	public static interface GraphNode extends GraphElement
	{
		void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName);
	}

	public static interface GraphEdge extends GraphElement
	{
		void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName);
		@NonNull GraphNode getEdgeSource();
		@NonNull GraphNode getEdgeTarget();
	}

	//	void appendAttributedEdge(@NonNull GraphEdge edge);
	void appendAttributedEdge(@NonNull String sourceName, @NonNull GraphEdge edge, @NonNull String targetName);
	void appendAttributedNode(@NonNull String nodeName);
	//	void appendEdge(@NonNull GraphEdge edge);
	void appendEdge(@NonNull ToGraphHelper toGraphHelper, @NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target);
	@NonNull String appendNode(@NonNull ToGraphHelper toGraphHelper,  @NonNull GraphNode node);
	void popCluster();
	void pushCluster();
	void setArrowhead(@NonNull String arrowhead);
	void setArrowtail(@NonNull String arrowtail);
	void setColor(@NonNull String color);
	void setDir(@NonNull String color);
	void setFillColor(@NonNull String color);
	void setHead();
	void setHeadlabel(/*@NonNull*/ String string);
	void setLabel(/*@NonNull*/ String string);
	void setPenwidth(@NonNull Integer penwidth);
	void setShape(@NonNull String shape);
	void setStyle(@NonNull String style);
	void setTaillabel(/*@NonNull*/ String string);
	@Override
	@NonNull String toString();
}