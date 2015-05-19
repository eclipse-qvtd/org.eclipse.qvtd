/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.ArrowType;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.LineType;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.ShapeType;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.ParameterDerivation;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleElement;
import org.eclipse.qvtd.pivot.schedule.util.AbstractExtendingScheduleVisitor;

public class ScheduleToCallGraph extends AbstractExtendingScheduleVisitor<String, GraphBuilder> {
	
	private final List<String> SOL_BASE = Arrays.asList("#fdf6e3", "#eee8d5", "#93a1a1", "#839496", "#657b83", "#586e75", "#073642", "#002b36");
	@NonNull private final int SOL_BACKROUND = 0;
	@NonNull private final int SOL_BACKROUND_HL = 1;
	@NonNull private final int SOL_SECONDARY = 2;
	@NonNull private final int SOL_NONE = 3;
	@NonNull private final int SOL_PRIMARY = 4;
	@NonNull private final int SOL_OPTIONAL = 5;
	
	@NonNull private final String SOL_YELLOW = "#b58900";
	@NonNull private final String SOL_ORANGE = "#cb4b16";
	@NonNull private final String SOL_RED = "#dc322f";
	@NonNull private final String SOL_MAGENTA = "#d33682";
	@NonNull private final String SOL_VIOLET = "#6c71c4";
	@NonNull private final String SOL_BLUE = "#268bd2";
	@NonNull private final String SOL_CYAN = "#2aa198";
	@NonNull private final String SOL_GREEN = "#859900";
	
	@NonNull private final String NODE_FILL_COLOR;
	
	@NonNull private final String MAPPING_ACTION_COLOR = SOL_ORANGE;
	@NonNull private final String MAPPING_ACTION_SHAPE = ShapeType.hexagon.name();
	@NonNull private final String LOOP_SHAPE = ShapeType.rectangle.name();
	
	@NonNull private final String SUPER_EDGE_COLOR;
	@NonNull private final String PRODUCTION_EDGE_COLOR;
	@NonNull private final String REQUISITE_EDGE_COLOR = SOL_GREEN;
	@NonNull private final String REQUISITE_MULTIPLE_EDGE_COLOR = SOL_RED;
	@NonNull private final String DEPENDENCY_ARROW_END = ArrowType.standard.name();
	@NonNull private final String DEPENDENCY_LOOP_ARROW_END = ArrowType.transparent_circle.name();
	@NonNull private final String SUPER_ARROW_END = ArrowType.delta.name();
	
	
	private Map<MutiNamedElementKeyImpl, Integer> nodeOrder = new HashMap<MutiNamedElementKeyImpl, Integer>();
	//private Map<CoreDomain, String> domainColor = new HashMap<CoreDomain, String>();
	private List<String> outputDirection;
	private boolean onlyClassDatums;
//	private int loopNodeId;
	
	public ScheduleToCallGraph(GraphBuilder context) {
		this(context, false);
	}
	
	public ScheduleToCallGraph(GraphBuilder context, boolean darkTheme) {
		super(context);
		if (darkTheme) {
			Collections.reverse(SOL_BASE);
		}
		NODE_FILL_COLOR = SOL_BASE.get(SOL_BACKROUND_HL);
		SUPER_EDGE_COLOR = SOL_BASE.get(SOL_SECONDARY);
		PRODUCTION_EDGE_COLOR = SOL_BASE.get(SOL_PRIMARY);
	}

	protected @NonNull String getMappingLabel(@NonNull MappingAction object) {
		String id = object.getMapping().getName() + "\n" + "(" + object.getOrder() + ")"; 
		return id;
	}

	/**
	 * @param eo
	 * @return
	 */
	private Integer getNodeOrder(@NonNull NamedElement... elements) {
		MutiNamedElementKeyImpl key = new MutiNamedElementKeyImpl(elements);
		Integer order;
		if (nodeOrder.containsKey(key)) {
			order = nodeOrder.get(key);
		} else {
			order = nodeOrder.size()+1;
			nodeOrder.put(key, order);
		}
		return order;
	}

	public List<String> getOutputDirection() {
		if (this.outputDirection == null)
			this.outputDirection = new ArrayList<String>();
		return this.outputDirection;
	}
	
//	private String getPropertyId(PropertyDatum object) {
//		String id = //object.getDomain().getName() + "\n" +
//				object.getClassDatum().getType().getName() + "\n." + object.getProperty().getName();
//		return id;
//	}
	
//	private boolean nodeExists(@NonNull NamedElement... elements) {
//		MutiNamedElementKeyImpl key = new MutiNamedElementKeyImpl(elements);
//		return nodeOrder.containsKey(key);
//	}
	
	@Override
	@Nullable
	public String visiting(ScheduleElement visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}

	@Override
	public @Nullable String visitMappingAction(MappingAction object) {
		
		String mappingLabel;
		String order;
		if (object.getMapping() != null) {
			mappingLabel = getMappingLabel(object);
			order = getNodeOrder(object.getMapping()).toString();
		}
		else {
			mappingLabel = "root";
			order  = "0";
		}
		context.appendNode(order, MAPPING_ACTION_SHAPE, NODE_FILL_COLOR, mappingLabel, MAPPING_ACTION_COLOR);
//		String lineType = LineType.line.name();
		int childCount = 0;
		for (AbstractAction mc : object.getChildren()) {
			@SuppressWarnings("unused")
			boolean allLoop = false;
			StringBuilder loopVars = new StringBuilder();
			String sep = "";
			for (ParameterDerivation pd : mc.getParameterDerivations()) {
				// Add nodes for loops
				if (pd.getPrimaryParameter() == null) {
					allLoop = true;
					loopVars.append(pd.getSecondaryParameter().getDataParameter().getVariable().getName());
					break;
				} else {
					//String pdOrder = String.valueOf(loopNodeId++);
					//context.appendNode(pdOrder, LOOP_SHAPE, NODE_FILL_COLOR, mappingLabel, MAPPING_ACTION_COLOR);
					loopVars.append(sep);
					loopVars.append(pd.getSecondaryParameter().getDataParameter().getVariable().getName());
				    sep = ",";
				}
			}
			String targetId = null;
			targetId = getNodeOrder(((MappingAction) mc).getMapping()).toString();
			assert targetId != null;
			context.appendEdge(order,
					targetId,
					PRODUCTION_EDGE_COLOR,
					LineType.line.name(),
					ArrowType.none.name(),
					DEPENDENCY_ARROW_END,
					loopVars.toString() + "(" + String.valueOf(childCount++) + ")");
		}
		return null;
	}

	@Override
	public @Nullable String visitSchedule(Schedule object) {
		
		context.open();
		// First the datums so the nodes exist
//		loopNodeId = object.getActions().size()+1;
		for (AbstractAction aa : object.getActions()) {
			if (aa instanceof MappingAction) {
				MappingAction ma = (MappingAction) aa;
				//if (ma.getMapping() != null)
					visitMappingAction(ma);
			}
		}
		context.close();
		return null;
	}

	public boolean isOnlyClassDatums() {
		return onlyClassDatums;
	}

	public void setOnlyClassDatums(boolean onlyClassDatums) {
		this.onlyClassDatums = onlyClassDatums;
	}

}
