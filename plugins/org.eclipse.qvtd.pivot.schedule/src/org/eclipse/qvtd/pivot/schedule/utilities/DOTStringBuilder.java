package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class DOTStringBuilder implements GraphStringBuilder
{
	/**
	 * Indicates where a required element in the AST was <code>null</code>, so
	 * that it is evident in the debugger that something was missing.
	 */
	protected static @NonNull String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$

	private final @NonNull StringBuilder s = new StringBuilder();
	private int indents = 0;
	private boolean indentPending = false;
	private final @NonNull Map<Object,String> node2name = new HashMap<Object,String>();
	private final @NonNull Map<String, Set<String>> edges = new HashMap<String, Set<String>>();
	private final @NonNull List<String> clusterName = new ArrayList<String>();
	private final @NonNull Map<String,String> attributes = new HashMap<String,String>();
	
	public DOTStringBuilder() {
		append("digraph ");
		append("schedule");
		append(" {");
		indents++;
//		newLine();		-- one line to facitate dual use of toString() in debugger
		append("fontname=arial;");
//		newLine();
		append("edge [fontname=arial,penwidth=2];");
//		newLine();
		append("node [shape=rectangle,fontname=arial,penwidth=2];");
//		newLine();
		append("compound=true;");
		newLine();
	}

	public void append(@Nullable Number number) {
		if (indentPending) {
			indentPending = false;
			for (int i = 0; i < indents; i++) {
				append("  ");
			}
		}
		if (number != null) {
			s.append(number.toString());
		}
		else {
			s.append(NULL_PLACEHOLDER);
		}
	}

	public void append(@Nullable String string) {
		if (indentPending) {
			indentPending = false;
			for (int i = 0; i < indents; i++) {
				append("  ");
			}
		}
		if (string != null) {
			s.append(string);
		}
		else {
			s.append(NULL_PLACEHOLDER);
		}
	}

	@Override
	public void appendAttributedEdge(@NonNull GraphEdge edge) {
	}

	@Override
	public void appendAttributedEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
	}

	@Override
	public void appendAttributedNode(@NonNull String nodeName) {
		boolean isHead = attributes.containsKey("head");
		if (isHead) {
			append("{rank=source;");
		}
		append(nodeName);
		appendAttributes();
		if (isHead) {
			append("}");
		}
	}

	private void appendAttributes() {
		boolean isFirst = true;
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			if (isFirst) {
				s.append("[");
			}
			else {
				s.append(",");
			}
			isFirst = false;
			s.append(entry.getKey());
			s.append("=");
			s.append(entry.getValue());
		}
		if (!isFirst) {
			s.append("]");
		}
		attributes.clear();
	}

	public void appendEdge(@NonNull GraphEdge edge) {
		String sourceName = appendNode(edge.getSource());
		String targetName = appendNode(edge.getTarget());
		Set<String> edgeSet = edges.get(sourceName);
		if (edgeSet == null) {
			edgeSet = new HashSet<String> ();
			edges.put(sourceName, edgeSet);
		}
		if (edgeSet.add(targetName)) {
			append(sourceName);
			append(" -> ");
			append(targetName);
			attributes.clear();
			edge.appendEdgeAttributes(this);
			appendAttributes();
			newLine();
		}
	}

	public void appendEdge(@NonNull GraphNode source, @NonNull GraphNode target) {
		String sourceName = appendNode(source);
		String targetName = appendNode(target);
		Set<String> edgeSet = edges.get(sourceName);
		if (edgeSet == null) {
			edgeSet = new HashSet<String> ();
			edges.put(sourceName, edgeSet);
		}
		if (edgeSet.add(targetName)) {
			append(sourceName);
			append(" -> ");
			append(targetName);
//			if (source instanceof DOTNode) {
//				attributes.clear();
//				((DOTNode)source).appendEdgeAttributes(this, target);
//				appendAttributes();
//			}
			newLine();
		}
	}

	public void appendEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		String sourceName = appendNode(source);
		String targetName = appendNode(target);
//		Set<String> edgeSet = edges.get(sourceName);
//		if (edgeSet == null) {
//			edgeSet = new HashSet<String> ();
//			edges.put(sourceName, edgeSet);
//		}
//		if (edgeSet.add(targetName)) {
			append(sourceName);
			append(" -> ");
			append(targetName);
			attributes.clear();
			edge.appendEdgeAttributes(this);
			appendAttributes();
			newLine();
//		}
	}

	public void appendEdge(@NonNull GraphNode source, @NonNull GraphNode target, @Nullable String suffix) {
		String sourceName = appendNode(source);
		String targetName = appendNode(target);
		Set<String> edgeSet = edges.get(sourceName);
		if (edgeSet == null) {
			edgeSet = new HashSet<String> ();
			edges.put(sourceName, edgeSet);
		}
		if (edgeSet.add(targetName)) {
			append(sourceName);
			append(" -> ");
			append(targetName);
			if (suffix != null) {
				append(suffix);
			}
			newLine();
		}
	}

	public @NonNull String appendNode(@NonNull GraphNode object) {
		String name = node2name.get(object);
		if (name == null) {
			name = "a" + node2name.size();
			node2name.put(object, name);
			attributes.clear();
			object.appendNode(this, name);
			newLine();
		}
		return name;
	}

	public @NonNull String appendNode(@NonNull Object object, /*@NonNull*/ String label) {
		String name = node2name.get(object);
		if (name == null) {
			name = "a" + node2name.size();
			node2name.put(object, name);
		}
		append(name);
		append("[label=\"" + label + "\"];");
		newLine();
		return name;
	}

	public void newLine() {
		append("\n");
		indentPending = true;
	}

	public void popCluster() {
		indents--;
		append("}");
		newLine();
	}

	public void pushCluster() {
		String name = "cluster_" + clusterName.size();
		clusterName.add(name);
		append("subgraph " + name + " {");
		indents++;
		newLine();
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			append(entry.getKey());
			append("=");
			append(entry.getValue());
			append(";");
			newLine();
		}
		attributes.clear();
	}

	public void pushCluster(/*@NonNull*/ String label) {
		String name = "cluster_" + clusterName.size();
		clusterName.add(name);
		append("subgraph " + name + " {");
		indents++;
		newLine();
		append("color=grey;");
		newLine();
		if (label != null) {
			append("label=\"" + label + "\";");
			newLine();
		}
	}

	public void setArrowhead(@NonNull String value) {
		attributes.put("arrowhead", value);
	}

	@Override
	public void setColor(@NonNull String value) {
		attributes.put("color", value);
	}

	@Override
	public void setHead() {
		attributes.put("head", "true");
	}

	public void setLabel(/*@NonNull*/ String value) {
		attributes.put("label",  '"' + value + '"');
	}

	public void setLhead(/*@NonNull*/ String value) {
		attributes.put("lhead",  value);
	}

	public void setLtail(/*@NonNull*/ String value) {
		attributes.put("ltail", value);
	}

	@Override
	public void setPenwidth(@NonNull Integer value) {
		attributes.put("penwidth", value.toString());
	}

	@Override
	public void setShape(@NonNull String value) {
		attributes.put("shape", value);
	}
	@Override
	public void setStyle(@NonNull String value) {
		attributes.put("style", value);
	}
	
	@Override
	public @NonNull String toString() {
		if (indents > 0) {
			indents--;
			append("}");
			newLine();
		}
		return s.toString();
	}
}