package org.eclipse.qvtd.pivot.schedule.utilities;

import org.eclipse.jdt.annotation.NonNull;

public interface GraphStringBuilder
{
	public static interface GraphNode
	{
		void appendNode(@NonNull GraphStringBuilder graphStringBuilder, @NonNull String nodeName);
	}
	
	public static interface GraphEdge
	{
		void appendEdgeAttributes(@NonNull GraphStringBuilder s);
		void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target);
		@NonNull GraphNode getSource();
		@NonNull GraphNode getTarget();
	}

	void appendAttributedEdge(@NonNull GraphEdge edge);
	void appendAttributedEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target);
	void appendAttributedNode(@NonNull String nodeName);
	void appendEdge(@NonNull GraphEdge edge);
	void appendEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target);
	@NonNull String appendNode(@NonNull GraphNode node);
	void popCluster();
	void pushCluster();
	void setArrowhead(@NonNull String arrowhead);
	void setColor(@NonNull String color);
	void setHead();
	void setLabel(/*@NonNull*/ String string);
	void setPenwidth(@NonNull Integer penwidth);
	void setShape(@NonNull String shape);
	void setStyle(@NonNull String style);
}