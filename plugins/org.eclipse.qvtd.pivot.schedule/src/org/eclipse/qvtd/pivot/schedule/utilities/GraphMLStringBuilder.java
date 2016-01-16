package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder;

public class GraphMLStringBuilder extends GraphMLBuilder implements GraphStringBuilder
{
	private static final @NonNull Map<String, String> colorName2colorCode = new HashMap<String, String>();
	static {
		colorName2colorCode.put("black", "#000000");
		colorName2colorCode.put("brown", "#993300");
		colorName2colorCode.put("blue", "#0000ff");
		colorName2colorCode.put("cyan", "#00ffff");
		colorName2colorCode.put("green", "#00ff00");
		colorName2colorCode.put("magenta", "#ff00ff");
		colorName2colorCode.put("orange", "#ffcc00");
		colorName2colorCode.put("red", "#ff0000");
		colorName2colorCode.put("white", "#ffffff");
		colorName2colorCode.put("yellow", "#ffff00");
	}

	private final @NonNull Map<Object,String> node2name = new HashMap<Object,String>();
	private int graphCount = 0;
	private @NonNull String color = "#cccccc";
	private @Nullable String label = null;
	private @NonNull String penwidth = "2.0";
	private @NonNull String shape = "rectangle";
	private @NonNull LineType lineType = LineType.line;
	private @NonNull String labelColor = "#000000";
	private @NonNull ArrowType sourceArrowType = ArrowType.none;
	private @NonNull ArrowType targetArrowType = ArrowType.delta;
	
	public GraphMLStringBuilder() {
		open();
	}

	@Override
	public void appendAttributedEdge(@NonNull GraphEdge edge) {
		String sourceName = appendNode(edge.getSource());
		String targetName = appendNode(edge.getTarget());
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
					appendArrows(sourceArrowType.name(), targetArrowType.name());
					appendEdgeLabel(label, labelColor);
				s.popTag();
			s.popTag();
		s.popTag();
		resetAttributes();
	}

//	@Override
	public void appendAttributedEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		String sourceName = appendNode(source);
		String targetName = appendNode(target);
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
					appendArrows(sourceArrowType.name(), targetArrowType.name());
					appendEdgeLabel(label, labelColor);
				s.popTag();
			s.popTag();
		s.popTag();
		resetAttributes();
	}

	@Override
	public void appendAttributedNode(@NonNull String nodeName) {
		String id = nodeName;
		String shapeName = shape;
		String fillColor = "#ffffff";
		String lineColor = color;
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

	public void appendEdge(@NonNull GraphEdge edge) {
		resetAttributes();
		edge.appendEdgeAttributes(this);
		resetAttributes();
	}

	@Override
	public void appendEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		resetAttributes();
		edge.appendEdgeAttributes(this, source, target);
		resetAttributes();
	}
	
	public @NonNull String appendNode(@NonNull GraphNode object) {
		String name = node2name.get(object);
		if (name == null) {
			name = "a" + node2name.size();
			node2name.put(object, name);
			if (object instanceof GraphNode) {
				resetAttributes();
				((GraphNode)object).appendNode(this, name);
			}
			else {
//				append(name);
			}
//			newLine();
		}
		return name;
	}

	public void popCluster() {
		s.popTag();
		s.popTag();
	}

	public void pushCluster() {
		s.pushTag("node");
			s.appendElement("id", "gn" + graphCount++);
			appendData("d5");
			s.pushTag("data");
				s.appendElement("key", "d6");
				s.pushTag("y:ShapeNode");
	//				appendGeometry(height, width, null, null);
					appendFill("#ffffff");
					s.appendTextBegin("y:NodeLabel");
					s.appendElement("fontSize", "16");
					s.appendElement("modelName", "sides");
					s.appendElement("modelPosition", "n");
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
		label = null;
		lineType = LineType.line;
		penwidth = "2.0";
		shape = "rectangle";
		sourceArrowType = ArrowType.none;
		targetArrowType = ArrowType.delta;
	}

	@Override
	public void setArrowhead(@NonNull String arrowhead) {
		if ("oinv".equals(arrowhead)) {
			sourceArrowType = ArrowType.delta;
			targetArrowType = ArrowType.none;
		}
	}

	@Override
	public void setColor(@NonNull String colorName) {
		String colorCode = colorName2colorCode.get(colorName);
		color = colorCode != null ? colorCode : "#777777";
	}

	@Override
	public void setHead() {
		// TODO Auto-generated method stub
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
	public void setShape(@NonNull String shape) {
		this.shape = shape;
	}

	@Override
	public void setStyle(@NonNull String style) {
		if ("dashed".equals(style)) {
			lineType = LineType.dashed;
		}
		else if ("dotted".equals(style)) {
			lineType = LineType.dotted;
		}
		if ("rounded".equals(style)) {
			shape = ShapeType.roundrectangle.toString();
		}
	}
	
	@Override
	public @NonNull String toString() {
		close();
		return super.toString();
	}
}