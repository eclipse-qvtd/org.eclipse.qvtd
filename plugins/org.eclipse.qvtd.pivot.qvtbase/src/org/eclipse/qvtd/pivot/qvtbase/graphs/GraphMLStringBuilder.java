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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class GraphMLStringBuilder extends GraphMLBuilder implements GraphStringBuilder
{
	private static final @NonNull Map<String, String> colorName2colorCode = new HashMap<String, String>();
	static {
		colorName2colorCode.put("black", "#000000");
		colorName2colorCode.put("brown", "#993300");
		colorName2colorCode.put("blue", "#0000ff");
		colorName2colorCode.put("cyan", "#00ffff");
		colorName2colorCode.put("darkorange", "#ffcc00");
		colorName2colorCode.put("gray", "#cccccc");
		colorName2colorCode.put("green", "#00ff00");
		colorName2colorCode.put("green3", "#00ff00");
		colorName2colorCode.put("lightblue1", "#ccccff");
		colorName2colorCode.put("lightcyan1", "#ccffff");
		colorName2colorCode.put("lightgray", "#dddddd");
		colorName2colorCode.put("magenta", "#ff00ff");
		colorName2colorCode.put("orange", "#ffcc00");
		colorName2colorCode.put("palegreen1", "#ccffcc");
		colorName2colorCode.put("palegoldenrod", "#ffeecc");
		colorName2colorCode.put("pink1", "#ffcccc");
		colorName2colorCode.put("red", "#ff0000");
		colorName2colorCode.put("white", "#ffffff");
		colorName2colorCode.put("yellow", "#ffff00");
	}

	private final @NonNull Map<@Nullable Object, @NonNull Map<@NonNull Object, @NonNull String>> scope2node2name = new HashMap<>();
	private @NonNull Map<@NonNull Object, @NonNull String> node2name;
	private int nameCount = 0;
	private int graphCount = 0;
	private @NonNull String color = "#cccccc";
	private @NonNull String fillColor = "#ffffff";
	private @Nullable String label = null;
	private @NonNull String penwidth = "2.0";
	private @NonNull String shape = "rectangle";
	private @NonNull LineType lineType = LineType.line;
	private @NonNull String labelColor = "#000000";
	private @Nullable ArrowType sourceArrowType = null;
	private @Nullable String sourceLabel = null;
	private @Nullable ArrowType targetArrowType = null;
	private @Nullable String targetLabel = null;

	public GraphMLStringBuilder() {
		this.node2name = new HashMap<>();
		scope2node2name.put(null, this.node2name);
		open();
	}

	@Override
	public void appendAttributedEdge(@NonNull String sourceName, @NonNull GraphEdge edge, @NonNull String targetName) {
		String sourceId = sourceName;
		String targetId = targetName;
		String lineColor = color;
		Double width = Double.valueOf(penwidth);
		s.pushTag("edge");
		appendEdgeId();
		appendEdgeSource(sourceId);
		appendEdgeTarget(targetId);
		s.pushTag("data");
		s.appendElement("key", "d9");
		s.pushTag("y:PolyLineEdge");
		appendLineStyle(new LineStyle(lineColor, lineType, width));
		appendArrows(sourceArrowType != null ? sourceArrowType.name() : ArrowType.none.name(), targetArrowType != null ? targetArrowType.name() : ArrowType.delta.name());
		appendEdgeLabel(labelColor, sourceLabel, label, targetLabel);
		s.popTag();
		s.popTag();
		s.popTag();
		resetAttributes();
	}

	@Override
	public void appendAttributedNode(@NonNull String nodeName) {
		String id = nodeName;
		String shapeName = shape;
		//		String fillColor = fillColor;
		String lineColor = color;
		//		LineType lineType = LineType.line;
		Double width = Double.valueOf(penwidth);
		s.pushTag("node");
		s.appendElement("id", NODEID_PREFIX + id);
		appendData("d5");
		s.pushTag("data");
		s.appendElement("key", "d6");
		s.pushTag("y:ShapeNode");
		Geometry g = new Geometry();
		g.adjustToText(label, 12, shapeName);
		appendGeometry(g);
		appendFill(fillColor);
		appendBorder(new BorderStyle(lineColor, lineType, width));
		appendNodeLabel(label, labelColor);
		appendShape(shapeName);
		s.popTag();
		s.popTag();
		s.popTag();
		resetAttributes();
	}

	@Override
	public void appendEdge(@NonNull ToGraphHelper toGraphHelper, @NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		String sourceName = appendNode(toGraphHelper, source);
		String targetName = appendNode(toGraphHelper, target);
		resetAttributes();
		edge.appendEdgeAttributes(toGraphHelper, sourceName, targetName);
		resetAttributes();
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
			resetAttributes();
			object.appendNode(toGraphHelper, name);
		}
		return name;
	}

	//	private @NonNull String getNodeName(@NonNull GraphNode node) {
	//		return ClassUtil.nonNullState(node2name.get(node));
	//	}

	@Override
	public void popCluster() {
		s.popTag();
		s.popTag();
	}

	@Override
	public void pushCluster() {
		s.pushTag("node");
		s.appendElement("id", "gn" + graphCount++);
		appendData("d5");
		s.pushTag("data");
		s.appendElement("key", "d6");
		s.pushTag("y:ShapeNode");
		//				appendGeometry(height, width, null, null);
		appendFill("#ffffff");
		String lineColor = color;
		Double width = Double.valueOf(penwidth);
		appendBorder(new BorderStyle(lineColor, lineType, width));
		s.appendTextBegin("y:NodeLabel");
		s.appendElement("fontSize", "16");
		s.appendElement("modelName", "internal");
		s.appendElement("modelPosition", "t");
		s.appendTextEnd(label);
		//				appendShape(shapeName);
		s.popTag();
		s.popTag();
		s.pushTag("graph");
		s.appendElement("id", "gg" + graphCount++);
		s.appendElement("edgedefault", "directed");
	}

	protected void resetAttributes() {
		color = "#000000";
		fillColor = "#ffffff";
		label = null;
		sourceLabel = null;
		targetLabel = null;
		lineType = LineType.line;
		penwidth = "2.0";
		shape = "rectangle";
		sourceArrowType = null;
		targetArrowType = null;
	}

	@Override
	public void setArrowhead(@NonNull String arrowhead) {
		//		if ("oinv".equals(arrowhead)) {
		//			sourceArrowType = ArrowType.delta;
		//			targetArrowType = ArrowType.none;
		//		}
		if ("diamond".equals(arrowhead)) {
			targetArrowType = ArrowType.diamond;
		}
		else if ("none".equals(arrowhead)) {
			targetArrowType = ArrowType.none;
		}
		else if ("normal".equals(arrowhead)) {
			targetArrowType = ArrowType.delta;
		}
		else if ("odiamond".equals(arrowhead)) {
			targetArrowType = ArrowType.white_diamond;
		}
		else if ("vee".equals(arrowhead)) {
			targetArrowType = ArrowType.standard;
		}
	}

	@Override
	public void setArrowtail(@NonNull String arrowtail) {
		if ("diamond".equals(arrowtail)) {
			sourceArrowType = ArrowType.diamond;
		}
		else if ("none".equals(arrowtail)) {
			sourceArrowType = ArrowType.none;
		}
		else if ("normal".equals(arrowtail)) {
			sourceArrowType = ArrowType.delta;
		}
		else if ("odiamond".equals(arrowtail)) {
			sourceArrowType = ArrowType.white_diamond;
		}
		else if ("vee".equals(arrowtail)) {
			sourceArrowType = ArrowType.standard;
		}
	}

	@Override
	public void setColor(@NonNull String colorName) {
		String colorCode = colorName2colorCode.get(colorName);
		color = colorCode != null ? colorCode : "#777777";
	}

	@Override
	public void setDir(@NonNull String direction) {
	}

	@Override
	public void setFillColor(@NonNull String colorName) {
		String colorCode = colorName2colorCode.get(colorName);
		fillColor = colorCode != null ? colorCode : "#777777";
	}

	@Override
	public void setHead() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setHeadlabel(/*@NonNull*/ String label) {
		String replace = "  " + label.replace("\\n", "  \n  ") + "  ";
		if (replace.length() < 10) {
			replace = "   " + replace + "    ";
		}
		this.sourceLabel = replace;
	}

	@Override
	public void setLabel(/*@NonNull*/ String label) {
		String replace = "  " + label.replace("\\n", "  \n  ") + "  ";
		if (replace.length() < 10) {
			replace = "   " + replace + "    ";
		}
		this.label = replace;
	}

	@Override
	public void setPenwidth(@NonNull Integer penwidth) {
		this.penwidth = penwidth.toString();
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
	public void setShape(@NonNull String shape) {
		this.shape = shape;
	}

	@SuppressWarnings("null")
	@Override
	public void setStyle(@NonNull String style) {
		if (style.indexOf("dashed") >= 0) {
			lineType = LineType.dashed;
		}
		else if (style.indexOf("dotted") >= 0) {
			lineType = LineType.dashed_dotted;
		}
		if ("rectangle".equals(shape) && (style.indexOf("rounded") >= 0)) {
			shape = ShapeType.roundrectangle.toString();
		}
	}

	@Override
	public void setTaillabel(/*@NonNull*/ String label) {
		String replace = "  " + label.replace("\\n", "  \n  ") + "  ";
		if (replace.length() < 10) {
			replace = "   " + replace + "    ";
		}
		this.targetLabel = replace;
	}
}