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
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.ArrowType;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.LineType;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.ShapeType;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleElement;
import org.eclipse.qvtd.pivot.schedule.util.AbstractExtendingScheduleVisitor;

public class ScheduleToDependencyGraphVisitor extends AbstractExtendingScheduleVisitor<String, GraphBuilder> {
	
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
	
	@NonNull private final String DATUM_INPUT_COLOR = SOL_BLUE;
	@NonNull private final String DATUM_MIDDLE_COLOR = SOL_VIOLET;
	@NonNull private final String DATUM_TARGET_COLOR = SOL_MAGENTA;
	@NonNull private final String DATUM_SHAPE = ShapeType.rectangle.name();
	
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
	private String middleDirection;
	private String inputDirection;
	private boolean onlyClassDatums;
	
	public ScheduleToDependencyGraphVisitor(GraphBuilder context) {
		this(context, false);
	}
	
	public ScheduleToDependencyGraphVisitor(GraphBuilder context, boolean darkTheme) {
		super(context);
		if (darkTheme) {
			Collections.reverse(SOL_BASE);
		}
		NODE_FILL_COLOR = SOL_BASE.get(SOL_BACKROUND_HL);
		SUPER_EDGE_COLOR = SOL_BASE.get(SOL_SECONDARY);
		PRODUCTION_EDGE_COLOR = SOL_BASE.get(SOL_PRIMARY);
	}

	private String getClassId(ClassDatum object) {
		String id = //object.getDomain().getName() + "\n" +
				object.getType().getName();
		return id;
	}

	private String getDomainColor(TypedModel domain) {
		if (domain != null) {
			if (domain.getName().equals(this.inputDirection)) {
				return DATUM_INPUT_COLOR;
			} else if (domain.getName().equals(this.middleDirection)) {
				return DATUM_MIDDLE_COLOR;
			} else if (this.outputDirection.contains(domain.getName())) {
				return DATUM_TARGET_COLOR;
			}
		}
		return SOL_BASE.get(SOL_OPTIONAL);
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
		Integer order = 0;
		if (nodeOrder.containsKey(key)) {
			order = nodeOrder.get(key);
		} else {
			order = nodeOrder.size();
			nodeOrder.put(key, order);
		}
		return order;
	}

	public List<String> getOutputDirection() {
		if (this.outputDirection == null)
			this.outputDirection = new ArrayList<String>();
		return this.outputDirection;
	}
	
	private String getPropertyId(PropertyDatum object) {
		String id = //object.getDomain().getName() + "\n" +
				object.getClassDatum().getType().getName() + "\n." + object.getProperty().getName();
		return id;
	}
	
	private boolean nodeExists(@NonNull NamedElement... elements) {
		MutiNamedElementKeyImpl key = new MutiNamedElementKeyImpl(elements);
		return nodeOrder.containsKey(key);
	}

	public void setInputDirection(String name) {
		this.inputDirection = name;
	}

	public void setMiddleDirection(String name) {
		this.middleDirection = name;		
	}

	@Override
	public @Nullable String visitClassDatum(ClassDatum object) {
		String datumLabel = getClassId(object);
		String order = getNodeOrder(object.getType(), object.getTypedModel()).toString();
		context.appendNode(order, DATUM_SHAPE, NODE_FILL_COLOR, datumLabel, getDomainColor(object.getTypedModel()));
		for (PropertyDatum pd : object.getPropertyDatums()) {
			visitPropertyDatum(pd);
		}
		for (AbstractDatum sd : object.getSuper()) {
			if (!nodeExists(((ClassDatum) sd).getType(), sd.getTypedModel()))
				visitClassDatum((ClassDatum) sd);
			String sdOrder = getNodeOrder(((ClassDatum) sd).getType(), sd.getTypedModel()).toString();
			context.appendEdge(order,
					sdOrder,
					SUPER_EDGE_COLOR,
					LineType.dotted.name(),
					ArrowType.none.name(),
					SUPER_ARROW_END);
		}
		return null;
	}
	
	@Override
	@Nullable
	public String visiting(ScheduleElement visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}

	@Override
	public @Nullable String visitMappingAction(MappingAction object) {
		
		String mappingLabel = getMappingLabel(object);
		String order = getNodeOrder(object.getMapping()).toString();
		context.appendNode(order, MAPPING_ACTION_SHAPE, NODE_FILL_COLOR, mappingLabel, MAPPING_ACTION_COLOR);
		String lineType = LineType.line.name();
		for(DataParameter out : object.getResults()) {
			String targetId = null;
			targetId = getNodeOrder(((ClassDatum) out.getDatum()).getType(), ((ClassDatum) out.getDatum()).getTypedModel()).toString();
			assert targetId != null;
			context.appendEdge(order,
					targetId,
					PRODUCTION_EDGE_COLOR,
					LineType.line.name(),
					ArrowType.none.name(),
					DEPENDENCY_ARROW_END);
		}
		for (AbstractDatum ad : object.getProductions()) {
			String targetId = null;
			lineType = LineType.line.name();
			if (ad instanceof PropertyDatum) {
				targetId = getNodeOrder(((PropertyDatum) ad).getProperty(), ((PropertyDatum) ad).getClassDatum().getType(), ad.getTypedModel()).toString();
				assert targetId != null;
				if (((PropertyDatum) ad).getProperty().isIsImplicit())
					lineType = LineType.dashed.name();
				context.appendEdge(order,
						targetId,
						PRODUCTION_EDGE_COLOR,
						lineType,
						ArrowType.none.name(),
						DEPENDENCY_ARROW_END);
			}
		}
		// One edge per data parameter of the ClassDatum
		List<DataParameter> visited = new ArrayList<DataParameter>();
		String edgeColor;
		String targetArrow;
		String targetId = null;
		for (DataParameter in : object.getParameters()) {
			visited.add(in);
			lineType = LineType.line.name();
			edgeColor = REQUISITE_EDGE_COLOR;
			targetArrow = DEPENDENCY_ARROW_END;
			targetId = null;
			targetId = getNodeOrder(((ClassDatum) in.getDatum()).getType(), ((ClassDatum) in.getDatum()).getTypedModel()).toString();
			assert targetId != null;
			// If two or more DataParameters have this Type, its a MULTIPLE Type dependency
			int dpCount = 0;
			for (DataParameter dp2 : object.getParameters()) {
				if (!visited.contains(dp2) && !dp2.equals(in) && dp2.getDatum().equals(in.getDatum())) {
					dpCount++;
				}
			}
			if (dpCount > 0)
				edgeColor = REQUISITE_MULTIPLE_EDGE_COLOR;
				// If the DataParameter can be derived, the line is dotted
				/*
				for (ParameterDerivation pd : object.getParameterDerivations()) {
					if (pd.getSecondaryParameter().getDataParameter().getDatum().equals(ad)) {
						if (pd.getPrimaryParameter() != null)
							lineType = LineType.dotted.name(); // FIXME Might not work for multiple derived parameters
						if (pd.getSecondaryParameter().isIsLoop()) {
							targetArrow = DEPENDENCY_LOOP_ARROW_END;
						}
					}
				}
				*/
			context.appendEdge(targetId,
					order,
					edgeColor,
					lineType,
					ArrowType.none.name(),
					targetArrow);
		}
		for (AbstractDatum ad : object.getRequisites()) {
			// One edge per data parameter of the ClassDatum
			edgeColor = REQUISITE_EDGE_COLOR;
			targetArrow = DEPENDENCY_ARROW_END;
			targetId = null;
			lineType = LineType.line.name();
			if (ad instanceof PropertyDatum) {
				targetId = getNodeOrder(((PropertyDatum) ad).getProperty(), ((PropertyDatum) ad).getClassDatum().getType(), ad.getTypedModel()).toString();
				assert targetId != null;
				if (((PropertyDatum) ad).getProperty().isIsImplicit())
					lineType = LineType.dashed.name();
				// Primary and Secondary Information
				context.appendEdge(targetId,
						order,
						edgeColor,
						lineType,
						ArrowType.none.name(),
						targetArrow);
			}
		}
		return null;
	}

	@Override
	public @Nullable String visitPropertyDatum(PropertyDatum object) {
		String datumLabel = getPropertyId(object);
		String order = getNodeOrder(object.getProperty(), object.getClassDatum().getType(), object.getTypedModel()).toString();
		context.appendNode(order, DATUM_SHAPE, NODE_FILL_COLOR, datumLabel, getDomainColor(object.getTypedModel()));
		for (AbstractDatum sd : object.getSuper()) {
			if (!nodeExists(object.getProperty(), object.getClassDatum().getType(), object.getTypedModel()))
				visitPropertyDatum((PropertyDatum) sd);
			String sdOrder = getNodeOrder(((PropertyDatum) sd).getProperty(), ((PropertyDatum) sd).getClassDatum().getType(), sd.getTypedModel()).toString();
			context.appendEdge(order,
					sdOrder,
					SUPER_EDGE_COLOR,
					LineType.dotted.name(),
					ArrowType.none.name(),
					SUPER_ARROW_END);
		}
		return null;
	}

	@Override
	public @Nullable String visitSchedule(Schedule object) {
		
		context.open();
		// First the datums so the nodes exist
		for (AbstractDatum ad : object.getDatums()) {
			if (ad instanceof ClassDatum) {
				visitClassDatum((ClassDatum) ad);
			}
		}
		for (AbstractAction aa : object.getActions()) {
			if (aa instanceof MappingAction) {
				MappingAction ma = (MappingAction) aa;
				if (ma.getMapping() != null)
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
