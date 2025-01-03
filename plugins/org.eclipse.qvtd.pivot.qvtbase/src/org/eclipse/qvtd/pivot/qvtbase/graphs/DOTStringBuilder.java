/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private final @NonNull Map<@Nullable Object, @NonNull Map<@NonNull Object, @NonNull String>> scope2node2name = new HashMap<>();
	private final @NonNull List<@NonNull String> clusterName = new ArrayList<>();
	private final @NonNull Map<@NonNull String, @NonNull String> attributes = new HashMap<>();
	private @NonNull Map<@NonNull Object, @NonNull String> node2name;
	private int nameCount = 0;

	public DOTStringBuilder() {
		this.node2name = new HashMap<>();
		scope2node2name.put(null, this.node2name);
		append("digraph ");
		append("schedule");
		append(" {");
		indents++;
		//		newLine();		-- one line to facitate dual use of toString() in debugger
		append("fontname=arial;");
		//		newLine();
		append("edge [fontname=arial,penwidth=2,arrowsize=1.5];");
		//		newLine();
		append("node [shape=rectangle,fontname=arial,penwidth=2];");
		//		newLine();
		append("nodesep=1;ranksep=1;compound=true;");
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
	public void appendAttributedEdge(@NonNull String sourceName, @NonNull GraphEdge edge, @NonNull String targetName) {
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

	@Override
	public void appendEdge(@NonNull ToGraphHelper toGraphHelper, @NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		String sourceName = appendNode(toGraphHelper, source);
		String targetName = appendNode(toGraphHelper, target);
		append(sourceName);
		append(" -> ");
		append(targetName);
		attributes.clear();
		edge.appendEdgeAttributes(toGraphHelper, sourceName, targetName);
		appendAttributes();
		newLine();
	}

	@Override
	public @NonNull String appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull GraphNode object) {
		String name = node2name.get(object);
		if (name == null) {
			Map<@NonNull Object, @NonNull String> globalNode2Name = scope2node2name.get(null);
			assert globalNode2Name != null;
			name = globalNode2Name.get(object);
		}
		if (name == null) {
			name = "a" + ++nameCount;
			node2name.put(object, name);
			attributes.clear();
			object.appendNode(toGraphHelper, name);
			newLine();
		}
		return name;
	}

	@Override
	public @NonNull String close() {
		if (indents > 0) {
			indents--;
			append("}");
			newLine();
		}
		return s.toString();
	}

	//	private @NonNull String getNodeName(@NonNull GraphNode node) {
	//		return ClassUtil.nonNullState(node2name.get(node));
	//	}

	public void newLine() {
		append("\n");
		indentPending = true;
	}

	@Override
	public void popCluster() {
		indents--;
		append("}");
		newLine();
	}

	@Override
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

	/*	public void pushCluster(/ *@NonNull* / String label) {
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
	} */

	@Override
	public void setArrowhead(@NonNull String value) {
		attributes.put("arrowhead", value);
	}

	@Override
	public void setArrowtail(@NonNull String value) {
		attributes.put("arrowtail", value);
	}

	@Override
	public void setColor(@NonNull String value) {
		attributes.put("color", value);
	}

	@Override
	public void setDir(@NonNull String direction) {
		attributes.put("dir", direction);
	}

	@Override
	public void setFillColor(@NonNull String value) {
		attributes.put("fillcolor", value);
	}

	@Override
	public void setHead() {
		attributes.put("head", "true");
	}

	@Override
	public void setHeadlabel(/*@NonNull*/ String value) {
		attributes.put("headlabel",  '"' + value + '"');
	}

	@Override
	public void setLabel(/*@NonNull*/ String value) {
		attributes.put("label",  '"' + value + '"');
	}

	public void setLhead(/*@NonNull*/ String value) {
		attributes.put("lhead", value);
	}

	public void setLtail(/*@NonNull*/ String value) {
		attributes.put("ltail", value);
	}

	@Override
	public void setPenwidth(@NonNull Integer value) {
		attributes.put("penwidth", value.toString());
	}

	@Override
	public void setScope(@Nullable Object scopeObject) {
		Map<@NonNull Object, @NonNull String> entry = scope2node2name.get(scopeObject);
		if (entry == null) {
			entry = new HashMap<>();
			scope2node2name.put(scopeObject, entry);
		}
		this.node2name = entry;
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
	public void setTaillabel(/*@NonNull*/ String value) {
		attributes.put("taillabel",  '"' + value + '"');
	}

	@Override
	public @NonNull String toString() {
		return s.toString();
	}
}