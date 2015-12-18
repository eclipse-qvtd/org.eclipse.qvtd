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

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class GraphMLBuilder implements GraphBuilder
{	
	protected static final @NonNull String EDGEID_PREFIX = "e";
	protected static final @NonNull String NODEID_PREFIX = "n";

	public class BorderStyle extends LineStyle {
		
		@NonNull public final static String TAG = "y:BorderStyle";
		
		public BorderStyle(String color, LineType type) {
			super(color, type);
		}

		public BorderStyle(String color, LineType type, Double width) {
			super(color, type, width);
		}
	}
	
	public class Geometry {
		
		@NonNull public final static String TAG = "y:Geometry";
		@NonNull public final static String HEIGHT_KEY = "height";
		@NonNull public final static String WIDTH_KEY = "width";
		@NonNull public final static String X_KEY = "x";
		@NonNull public final static String Y_KEY = "y";
		
		public final int MIN_HEIGHT = 30;
		public final int MIN_WIDTH = 30;
		public final double PADDING_FACTOR = 1.065;
		
		private double height;
		private double width;
		private double x_pos;
		private double y_pos;
		
		public Geometry() {
			this.height = MIN_HEIGHT;
			this.width = MIN_WIDTH;
			this.x_pos = 0.0;
			this.y_pos = 0.0;
		}

		public Geometry(double height, double width, double x_pos,
				double y_pos) {
			super();
			this.height = height;
			this.width = width;
			this.x_pos = x_pos;
			this.y_pos = y_pos;
		}

		public void adjustToText(String text, int fontSize, String shapeName) {
			
			Font font = new Font("Dialog", Font.PLAIN, fontSize);
			// get metrics from the graphics
			BufferedImage image = new BufferedImage(MIN_HEIGHT, MIN_WIDTH, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = (Graphics2D) image.getGraphics();
			FontMetrics metrics = g2.getFontMetrics(font);
			// get the height of a line of text in this
			// font and render context
			int hgt = metrics.getHeight();
			// get the advance of my text in this font
			// and render context
			//int adv = metrics.stringWidth(text);
			// calculate the size of a box to hold the
			// text with some padding.
			int maxW = 0;
			String[] split = text.split("\r\n|\r|\n");
			int numLines = split.length;
			for (String s : split) {
				int w = metrics.stringWidth(s);
				maxW = w > maxW ? w : maxW;
			}
			int adv = maxW;
			//System.out.println("Adjust: " + text);
			switch (ShapeType.valueOf(shapeName)) {
	            case hexagon: this.width = adv*PADDING_FACTOR+(0.1*adv);
	            	break;
	            case rectangle:
	            default: this.width = adv*PADDING_FACTOR;
	            	break;
	        }
			//System.out.println(adv);
			this.height = hgt*numLines*PADDING_FACTOR;
		}
		
	}
	
	public class LineStyle {
		
		@NonNull public final static String TAG = "y:LineStyle";
		@NonNull public static final String COLOR_KEY = "color";
		@NonNull public static final String TYPE_KEY = "type";
		@NonNull public static final String WIDTH_KEY = "width";
		
		private String color;
		private LineType type;
		private Double width = 1.0;
		
		public LineStyle(String color, LineType type) {
			super();
			this.color = color;
			this.type = type;
		}

		public LineStyle(String color, LineType type, Double width) {
			super();
			this.color = color;
			this.type = type;
			this.width = width;
		}

		public String getColor() {
			return color;
		}

		public LineType getType() {
			return type;
		}

		public Double getWidth() {
			return width;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
		public void setType(LineType type) {
			this.type = type;
		}

		public void setWidth(Double width) {
			this.width = width;
		}
		 
	}
	
	public enum LineType {
		line, dashed, dotted
	}
	
	public enum ShapeType {
		rectangle, roundrectangle, ellipse, parallelogram, hexagon, octagon, diamond, triangle, trapezoid, trapezoid2, rectangle3d
	}
	
	public enum ArrowType {
		standard, delta, diamond, white_diamond, white_delta, none, plain, concave, convex, circle, dash, transparent_circle, skewed_dash, t_shape
	}
	
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
	
	public void appendBorder(BorderStyle ls) {
		// TODO Auto-generated method stub
		s.pushTag(BorderStyle.TAG);
			s.appendElement(BorderStyle.COLOR_KEY, ls.getColor().toString());
			s.appendElement(BorderStyle.TYPE_KEY, ls.getType().toString());
			s.appendElement(BorderStyle.WIDTH_KEY, ls.getWidth().toString());
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
			appendEdgeId();
			appendEdgeSource(sourceId);
			appendEdgeTarget(targetId);
			s.pushTag("data");
				s.appendElement("key", "d9");
				s.pushTag("y:PolyLineEdge");
					appendLineStyle(new LineStyle(lineColor, LineType.valueOf(lineType)));
					appendArrows(sourceArrowType, targetArrowType);
				s.popTag();
			s.popTag();
		s.popTag();
	}
	
	@Override
	public void appendEdge(@NonNull String sourceId, @NonNull String targetId,
			@NonNull String lineColor, @NonNull String lineType,
			@NonNull String sourceArrowType, @NonNull String targetArrowType,
			@NonNull String label) {
		s.pushTag("edge");
		appendEdgeId();
		appendEdgeSource(sourceId);
		appendEdgeTarget(targetId);
		s.pushTag("data");
			s.appendElement("key", "d9");
			s.pushTag("y:PolyLineEdge");
				appendLineStyle(new LineStyle(lineColor, LineType.valueOf(lineType)));
				appendArrows(sourceArrowType, targetArrowType);
				appendEdgeLabel(label, lineColor);
			s.popTag();
		s.popTag();
	s.popTag();
	}

	protected void appendEdgeId() {
		s.appendElement("id", EDGEID_PREFIX + edgeCount++);
	}

	protected void appendEdgeSource(@NonNull String sourceId) {
		s.appendElement("source", NODEID_PREFIX + sourceId);
	}

	protected void appendEdgeTarget(@NonNull String targetId) {
		s.appendElement("target", NODEID_PREFIX + targetId);
	}
	
	public void appendFill(@NonNull String fillColor) {
		s.pushTag("y:Fill");
			s.appendElement("color", fillColor);
			s.appendElement("transparent", "false");
		s.popTag();
	}

	public void appendGeometry(Geometry g) {
		// TODO Auto-generated method stub
		s.pushTag(Geometry.TAG);
		s.appendElement(Geometry.HEIGHT_KEY, String.valueOf(g.height));
		s.appendElement(Geometry.WIDTH_KEY, String.valueOf(g.width));
		s.appendElement(Geometry.X_KEY, String.valueOf(g.x_pos));
		s.appendElement(Geometry.Y_KEY, String.valueOf(g.y_pos));
		s.popTag();
	}
	
	protected void appendEdgeLabel(@Nullable String label, String labelColor) {
		if (label !=  null) {
			s.pushTag("y:EdgeLabel");
				s.appendElement("textColor", labelColor);
			s.appendValueAndPopTag(label);
		}
	}

	public void appendGeometry(@Nullable Integer height, @Nullable Integer width, @Nullable Integer x, @Nullable Integer y ) {
		s.pushTag(Geometry.TAG);
			if (height != null) {
				s.appendElement(Geometry.HEIGHT_KEY, height.toString());
			}
			if (width != null) {
				s.appendElement(Geometry.WIDTH_KEY, width.toString());
			}
			if (x != null) {
				s.appendElement(Geometry.X_KEY, x.toString());
			}
			if (y != null) {
				s.appendElement(Geometry.Y_KEY, y.toString());
			}
		s.popTag();
	}

	protected void appendLabel(/*@NonNull*/ String label) {
		s.appendText("y:NodeLabel", label);
	}

	public void appendLineStyle(@NonNull LineStyle ls) {
		s.pushTag(LineStyle.TAG);
			s.appendElement(LineStyle.COLOR_KEY, ls.getColor().toString());
			s.appendElement(LineStyle.TYPE_KEY, ls.getType().toString());
			s.appendElement(LineStyle.WIDTH_KEY, ls.getWidth().toString());
		s.popTag();
	}

	@Override
	public void appendNode(/*@NonNull*/ String id, @NonNull String shapeName, @NonNull String fillColor, int height, int width, String label) {
		s.pushTag("node");
			s.appendElement("id", NODEID_PREFIX + id);
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

	@Override
	public void appendNode(@NonNull String id, @NonNull String shapeName,
			@NonNull String fillColor, String label, @NonNull String labelColor) {
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
					appendBorder(new BorderStyle(labelColor, LineType.line));
					appendNodeLabel(label, labelColor);
					appendShape(shapeName);
				s.popTag();
			s.popTag();
		s.popTag();
	}
	
	protected void appendNodeLabel(@Nullable String label, String labelColor) {
		if (label != null) {
			s.pushTag("y:NodeLabel");
				s.appendElement("textColor", labelColor);
			s.appendValueAndPopTag(label);
		}
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

	@Override
	public String toString() {
		return s.toString();
	}



}
