package org.eclipse.qvtd.compiler.internal.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class DOTStringBuilder
{
	public static interface DOTNode
	{
		void appendNode(@NonNull DOTStringBuilder s, @NonNull String nodeName);
	}
	
	public static interface DOTEdge
	{
		@NonNull DOTNode getSource();
		@NonNull DOTNode getTarget();
		void appendEdgeAttributes(@NonNull DOTStringBuilder s);
	}
	
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
	}

	public void appendEdge(@NonNull DOTEdge edge) {
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

	public void appendEdge(@NonNull Object source, @NonNull Object target) {
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

	public void appendEdge(@NonNull Object source, @NonNull Object target, @Nullable String suffix) {
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

	public @NonNull String appendNode(@NonNull Object object) {
		String name = node2name.get(object);
		if (name == null) {
			name = "a" + node2name.size();
			node2name.put(object, name);
			if (object instanceof DOTNode) {
				attributes.clear();
				((DOTNode)object).appendNode(this, name);
			}
			else {
				append(name);
			}
			newLine();
		}
		return name;
	}

	public void appendNameAndAttributes(@NonNull String nodeName) {
		s.append(nodeName);
		appendAttributes();
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
		attributes.put("arrowhead",  value);
	}

	public void setColor(@NonNull String value) {
		attributes.put("color",  value);
	}

	public void setLabel(/*@NonNull*/ String value) {
		attributes.put("label",  '"' + value + '"');
	}

	public void setPenwidth(@NonNull String value) {
		attributes.put("penwidth",  value);
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