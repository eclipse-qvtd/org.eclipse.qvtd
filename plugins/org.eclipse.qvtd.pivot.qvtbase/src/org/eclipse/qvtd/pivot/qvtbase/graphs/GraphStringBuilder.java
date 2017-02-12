/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.graphs;

import org.eclipse.jdt.annotation.NonNull;

public interface GraphStringBuilder
{
	public static interface GraphNode
	{
		void appendNode(@NonNull GraphStringBuilder graphStringBuilder, @NonNull String nodeName);
	}

	public static interface GraphEdge
	{
		//		void appendEdgeAttributes(@NonNull GraphStringBuilder s);
		void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target);
		@NonNull GraphNode getEdgeSource();
		@NonNull GraphNode getEdgeTarget();
	}

	//	void appendAttributedEdge(@NonNull GraphEdge edge);
	void appendAttributedEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target);
	void appendAttributedNode(@NonNull String nodeName);
	//	void appendEdge(@NonNull GraphEdge edge);
	void appendEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target);
	@NonNull String appendNode(@NonNull GraphNode node);
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
}