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
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleElement;
import org.eclipse.qvtd.pivot.schedule.util.AbstractExtendingScheduleVisitor;

public class ScheduleToDependecyGraphVisitor extends AbstractExtendingScheduleVisitor<String, GraphBuilder> {
	
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
	@NonNull private final String MAPPING_ACTION_SHAPE = "hexagon";
	
	@NonNull private final String DATUM_INPUT_COLOR = SOL_BLUE;
	@NonNull private final String DATUM_MIDDLE_COLOR = SOL_VIOLET;
	@NonNull private final String DATUM_TARGET_COLOR = SOL_MAGENTA;
	@NonNull private final String DATUM_SHAPE = "rectangle";
	
	
	private Map<MutiNamedElementKeyImpl, Integer> nodeOrder = new HashMap<MutiNamedElementKeyImpl, Integer>();
	//private Map<CoreDomain, String> domainColor = new HashMap<CoreDomain, String>();
	private List<String> outputDirection;
	private String middleDirection;
	private String inputDirection;
	
	public ScheduleToDependecyGraphVisitor(GraphBuilder context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private String getClassId(ClassDatum object) {
		String id = object.getDomain().getName() + "\n" +
				object.getType().getName();
		return id;
	}

	private String getDomainColor(CoreDomain domain) {
		if (domain.getName().equals(this.inputDirection)) {
			return DATUM_INPUT_COLOR;
		} else if (domain.getName().equals(this.middleDirection)) {
			return DATUM_MIDDLE_COLOR;
		} else if (this.outputDirection.contains(domain.getName())) {
			return DATUM_TARGET_COLOR;
		} else {
			return "#000000";
		}
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

	public void setInputDirection(String name) {
		this.inputDirection = name;
	}

	public void setMiddleDirection(String name) {
		this.middleDirection = name;		
	}

	@Override
	public @Nullable String visitClassDatum(ClassDatum object) {
		String datumLabel = getClassId(object);
		Integer order = getNodeOrder(object.getType(), object.getDomain());
		context.appendNode(order.toString(), DATUM_SHAPE, NODE_FILL_COLOR, datumLabel, getDomainColor(object.getDomain()));
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
		Integer order = getNodeOrder(object.getMapping());
		context.appendNode(order.toString(), MAPPING_ACTION_SHAPE, NODE_FILL_COLOR, mappingLabel, MAPPING_ACTION_COLOR);
		return null;
	}

	@Override
	public @Nullable String visitPropertyDatum(PropertyDatum object) {
		// TODO Auto-generated method stub
		return super.visitPropertyDatum(object);
	}

	@Override
	public @Nullable String visitSchedule(Schedule object) {
		
		context.open();
		for (AbstractAction aa : object.getActions()) {
			if (aa instanceof MappingAction) {
				MappingAction ma = (MappingAction) aa;
				if (ma.getMapping() != null)
					visitMappingAction(ma);
			}
		}
		for (AbstractDatum ad : object.getDatums()) {
			if (ad instanceof ClassDatum) {
				visitClassDatum((ClassDatum) ad);
			}
		}
		context.close();
		return null;
	}

}
