/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class GraphMLBuilder implements GraphBuilder
{
	protected static @NonNull String NULL_PLACEHOLDER = "\"<null>\""; //$NON-NLS-1$
	
	protected final @NonNull XMLStringBuilder s = new XMLStringBuilder();
	private int edgeCount = 0;
	
	public GraphMLBuilder() {}
	
	public void appendArrows(@NonNull String source, @NonNull String target) {
		s.pushTag("y:Arrows");
			s.appendElement("source", source);
			s.appendElement("target", target);
		s.popTag();
	}
	
	public void appendData(@NonNull String key) {
		s.pushTag("data");
		s.appendElement("key", key);
		s.popTag();
	}

	@Override
	public void appendEdge(@NonNull String sourceId, @NonNull String targetId, @NonNull String lineColor,
			@NonNull String lineType, @NonNull String sourceArrowType, @NonNull String targetArrowType) {
		s.pushTag("edge");
			s.appendElement("id", "e" + ++edgeCount);
			s.appendElement("source", sourceId);
			s.appendElement("target", targetId);
			s.pushTag("data");
				s.appendElement("key", "d9");
				s.pushTag("y:PolyLineEdge");
					appendLineStyle(lineColor, lineType);
					appendArrows(sourceArrowType, targetArrowType);
				s.popTag();
			s.popTag();
		s.popTag();
	}

	public void appendFill(@NonNull String fillColor) {
		s.pushTag("y:Fill");
			s.appendElement("color", fillColor);
			s.appendElement("transparent", "false");
		s.popTag();
	}

	public void appendGeometry(@Nullable Integer height, @Nullable Integer width, @Nullable Integer x, @Nullable Integer y ) {
		s.pushTag("y:Geometry");
			if (height != null) {
				s.appendElement("height", height.toString());
			}
			if (width != null) {
				s.appendElement("width", width.toString());
			}
			if (x != null) {
				s.appendElement("x", x.toString());
			}
			if (y != null) {
				s.appendElement("y", y.toString());
			}
		s.popTag();
	}

	protected void appendLabel(/*@NonNull*/ String label) {
		s.appendText("y:NodeLabel", label);
	}
	
	public void appendLineStyle(@NonNull String lineColor, @NonNull String lineType) {
		s.pushTag("y:LineStyle");
			s.appendElement("color", lineColor);
			s.appendElement("type", lineType);
			s.appendElement("width", "1.0");
		s.popTag();
	}

	@Override
	public void appendNode(/*@NonNull*/ String id, @NonNull String shapeName, @NonNull String fillColor, int height, int width, String label) {
		s.pushTag("node");
			s.appendElement("id", id);
			appendData("d5");
			s.pushTag("data");
				s.appendElement("key", "d6");
				s.pushTag("y:ShapeNode");
					appendGeometry(height, width, null, null);
					appendFill(fillColor);
					appendLabel(label);
					appendShape(shapeName);
				s.popTag();
			s.popTag();
		s.popTag();
	}

	public void appendShape(@NonNull String shapeName) {
		s.pushTag("y:Shape");
			s.appendElement("type", shapeName);
		s.popTag();
	}

	@Override
	public void close() {
		s.popTag();
		s.popTag();
	}

	@Override
	public void open() {
		s.pushTag("graphml");
			s.appendElement("xmlns", "http://graphml.graphdrawing.org/xmlns");
			s.appendNewLineElement("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			s.appendNewLineElement("xmlns:y", "http://www.yworks.com/xml/graphml");
			s.appendNewLineElement("xmlns:yed", "http://www.yworks.com/xml/yed/3");
			s.appendNewLineElement("xsi:schemaLocation", "http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.1/graphml.xsd");
			s.pushTag("key");
				s.appendElement("attr.name", "description");
				s.appendElement("attr.type", "string");
				s.appendElement("for", "node");
				s.appendElement("id", "d5");
			s.popTag();
			s.pushTag("key");
				s.appendElement("for", "node");
				s.appendElement("id", "d6");
				s.appendElement("yfiles.type", "nodegraphics");
			s.popTag();
			s.pushTag("key");
				s.appendElement("attr.name", "description");
				s.appendElement("attr.type", "string");
				s.appendElement("for", "edge");
				s.appendElement("id", "d8");
			s.popTag();
			s.pushTag("key");
				s.appendElement("for", "edge");
				s.appendElement("id", "d9");
				s.appendElement("yfiles.type", "edgegraphics");
			s.popTag();
			s.pushTag("graph");
				s.appendElement("edgedefault", "directed");
				s.appendElement("id", "G");
	}
}
