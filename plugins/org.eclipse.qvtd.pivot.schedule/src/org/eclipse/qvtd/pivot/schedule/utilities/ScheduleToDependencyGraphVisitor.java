package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.ArrowType;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.LineType;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder.ShapeType;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleElement;
import org.eclipse.qvtd.pivot.schedule.util.AbstractExtendingScheduleVisitor;

public class ScheduleToDependencyGraphVisitor extends AbstractExtendingScheduleVisitor<String, GraphBuilder> {
	
	@NonNull private final String SOL_BASE03 = "#002b36";
	@NonNull private final String SOL_BASE02 = "#073642";
	@NonNull private final String SOL_BASE01 = "#586e75";
	@NonNull private final String SOL_BASE00 = "#657b83";
	@NonNull private final String SOL_BASE0 = "#839496";
	@NonNull private final String SOL_BASE1 = "#93a1a1";
	@NonNull private final String SOL_BASE2 = "#eee8d5";
	@NonNull private final String SOL_BASE3 = "#fdf6e3";
	@NonNull private final String SOL_YELLOW = "#b58900";
	@NonNull private final String SOL_ORANGE = "#cb4b16";
	@NonNull private final String SOL_RED = "#dc322f";
	@NonNull private final String SOL_MAGENTA = "#d33682";
	@NonNull private final String SOL_VIOLET = "#6c71c4";
	@NonNull private final String SOL_BLUE = "#268bd2";
	@NonNull private final String SOL_CYAN = "#2aa198";
	@NonNull private final String SOL_GREEN = "#859900";
	
	@NonNull private final String NODE_FILL_COLOR = SOL_BASE2;
	
	@NonNull private final String MAPPING_ACTION_COLOR = SOL_ORANGE;
	@NonNull private final String MAPPING_ACTION_SHAPE = ShapeType.hexagon.name();
	
	@NonNull private final String DATUM_INPUT_COLOR = SOL_BLUE;
	@NonNull private final String DATUM_MIDDLE_COLOR = SOL_VIOLET;
	@NonNull private final String DATUM_TARGET_COLOR = SOL_MAGENTA;
	@NonNull private final String DATUM_SHAPE = ShapeType.rectangle.name();
	
	@NonNull private final String SUPER_EDGE_COLOR = SOL_BASE01;
	@NonNull private final String PRODUCTION_EDGE_COLOR = SOL_BASE00;
	@NonNull private final String REQUISITE_EDGE_COLOR = SOL_GREEN;
	@NonNull private final String DEPENDENCY_ARROW_END = ArrowType.standard.name();
	@NonNull private final String SUPER_ARROW_END = ArrowType.delta.name();
	
	
	private Map<MutiNamedElementKeyImpl, Integer> nodeOrder = new HashMap<MutiNamedElementKeyImpl, Integer>();
	//private Map<CoreDomain, String> domainColor = new HashMap<CoreDomain, String>();
	private List<String> outputDirection;
	private String middleDirection;
	private String inputDirection;
	
	public ScheduleToDependencyGraphVisitor(GraphBuilder context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private String getClassId(ClassDatum object) {
		String id = //object.getDomain().getName() + "\n" +
				object.getType().getName();
		return id;
	}

	private String getDomainColor(CoreDomain domain) {
		if (domain != null) {
			if (domain.getName().equals(this.inputDirection)) {
				return DATUM_INPUT_COLOR;
			} else if (domain.getName().equals(this.middleDirection)) {
				return DATUM_MIDDLE_COLOR;
			} else if (this.outputDirection.contains(domain.getName())) {
				return DATUM_TARGET_COLOR;
			}
		}
		return SOL_BASE1;
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
		String order = getNodeOrder(object.getType(), object.getDomain()).toString();
		context.appendNode(order, DATUM_SHAPE, NODE_FILL_COLOR, datumLabel, getDomainColor(object.getDomain()));
		for (PropertyDatum pd : object.getPropertyDatums()) {
			visitPropertyDatum(pd);
		}
		for (AbstractDatum sd : object.getSuper()) {
			if (!nodeExists(((ClassDatum) sd).getType(), sd.getDomain()))
				visitClassDatum((ClassDatum) sd);
			String sdOrder = getNodeOrder(((ClassDatum) sd).getType(), sd.getDomain()).toString();
			context.appendEdge(sdOrder,
					order,
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
		for (AbstractDatum ad : object.getProductions()) {
			String targetId = null;
			lineType = LineType.line.name();
			if (ad instanceof ClassDatum) {
				targetId = getNodeOrder(((ClassDatum) ad).getType(), ad.getDomain()).toString();
			} else if (ad instanceof PropertyDatum) {
				targetId = getNodeOrder(((PropertyDatum) ad).getProperty(), ((PropertyDatum) ad).getClassDatum().getType(), ad.getDomain()).toString();
				if (((PropertyDatum) ad).getProperty().isIsImplicit())
					lineType = LineType.dashed.name();
			}
			assert targetId != null;
			context.appendEdge(order,
					targetId,
					PRODUCTION_EDGE_COLOR,
					lineType,
					ArrowType.none.name(),
					DEPENDENCY_ARROW_END);
		}
		for (AbstractDatum ad : object.getRequisites()) {
			String targetId = null;
			lineType = LineType.line.name();
			if (ad instanceof ClassDatum) {
				targetId = getNodeOrder(((ClassDatum) ad).getType(), ad.getDomain()).toString();
			} else if (ad instanceof PropertyDatum) {
				targetId = getNodeOrder(((PropertyDatum) ad).getProperty(), ((PropertyDatum) ad).getClassDatum().getType(), ad.getDomain()).toString();
				if (((PropertyDatum) ad).getProperty().isIsImplicit())
					lineType = LineType.dashed.name();
			}
			assert targetId != null;
			context.appendEdge(targetId,
					order,
					REQUISITE_EDGE_COLOR,
					lineType,
					ArrowType.none.name(),
					DEPENDENCY_ARROW_END);
		}
		return null;
	}

	@Override
	public @Nullable String visitPropertyDatum(PropertyDatum object) {
		String datumLabel = getPropertyId(object);
		Integer order = getNodeOrder(object.getProperty(), object.getClassDatum().getType(), object.getDomain());
		context.appendNode(order.toString(), DATUM_SHAPE, NODE_FILL_COLOR, datumLabel, getDomainColor(object.getDomain()));
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

}
