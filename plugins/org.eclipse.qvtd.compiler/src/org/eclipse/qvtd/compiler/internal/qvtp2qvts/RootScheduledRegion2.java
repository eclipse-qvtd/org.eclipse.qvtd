/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ContentsAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Visitor2;

import com.google.common.collect.Iterables;

public class RootScheduledRegion2 extends AbstractScheduledRegion implements RootScheduledRegion
{
	public static @NonNull BinaryOperator<@NonNull String> stringJoin(@NonNull String delimiter) {
		return (a, b) -> String.valueOf(a) + delimiter + String.valueOf(b);
	}

	private final @NonNull String name;
	protected final @NonNull CompleteModel completeModel;

	/**
	 * The input models that may introduce model elements for transformation.
	 */
	private final @NonNull Map<@NonNull Model, @NonNull DomainUsage> inputModels = new HashMap<>();

	private final @NonNull ContentsAnalysis contentsAnalysis;

	private final @NonNull RootCompositionRegion rootContainmentRegion = new RootCompositionRegion(getMultiRegion());

	public RootScheduledRegion2(@NonNull String name, @NonNull Region primaryRegion) {
		super(primaryRegion.getMultiRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		this.contentsAnalysis = new ContentsAnalysis(getSchedulerConstants());
	}

	/*	public RootScheduledRegion(@NonNull String name, @NonNull List<@NonNull Region> regions) {
		super(ClassUtil.nonNullState(regions.get(0)).getMultiRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		this.contentsAnalysis = new ContentsAnalysis(getSchedulerConstants());
		for (@NonNull Region region : regions) {
			addRegion(region);
		}
	} */

	@Override
	public <R> R accept(@NonNull Visitor2<R> visitor) {
		return ((Visitor<R>)visitor).visitRootScheduledRegion(this);
	}

	private void computeInputModels() {
		for (ClassDatumAnalysis classDatumAnalysis : getSchedulerConstants().getClassDatumAnalyses()) {
			DomainUsage domainUsage = classDatumAnalysis.getDomainUsage();
			if (domainUsage.isInput() && !domainUsage.isOutput()) {
				Type type = classDatumAnalysis.getClassDatum().getCompleteClass().getPrimaryClass();
				org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(type);
				if ((asPackage != null) && !PivotConstants.ORPHANAGE_URI.equals(asPackage.getURI())) {
					Model model = PivotUtil.getContainingModel(type);
					if (model != null) {
						inputModels.put(model, domainUsage);
					}
				}
			}
			//			if (!domainUsage.isEnforceable()) {
			//				Model model = PivotUtil.getContainingModel(classDatumAnalysis.getClassDatum().getType());
			//				if ((model != null) && !PivotConstants.ORPHANAGE_URI.equals(model.getExternalURI())) {
			//					inputModels.put(model, domainUsage);
			//				}
			//			}
		}
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendName(name);
		return s;
	}

	/**
	 * Create the Passed and Used Connections between all introducers and their corresponding consuming nodes.
	 */
	private void createConnections() {
		List<@NonNull Region> sortedCallableRegions = new ArrayList<>();
		Iterables.addAll(sortedCallableRegions, getCallableRegions());
		Collections.sort(sortedCallableRegions, NameUtil.NAMEABLE_COMPARATOR);
		for (Region region : sortedCallableRegions) {
			region.createIncomingConnections();
		}
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			writeDebugGraphs("4-bindings", true, true, false);
		}
		//		for (Region region : sortedCallableRegions) {
		//			region.checkIncomingConnections();
		//		}
	}

	/**
	 * Create a RootContainmentRegion that introduces model elements directly from the input model root, or from
	 * composition relationships that form part of an extended metamodel that is not known until run-time.
	 */
	private @NonNull RootCompositionRegion createRootContainmentRegion() {
		addRegion(rootContainmentRegion);
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			rootContainmentRegion.writeDebugGraphs(null);
		}
		return rootContainmentRegion;
	}

	public void createSchedule() {
		//
		//	Identify the input models.
		//
		computeInputModels();
		if (QVTp2QVTs.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.isActive()) {
			QVTp2QVTs.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.println(dumpInputModels().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify the content of each region.
		//
		for (@NonNull Region region : getRegions()) {
			contentsAnalysis.addRegion(region);
		}
		if (QVTp2QVTs.DUMP_CLASS_TO_REALIZED_NODES.isActive()) {
			QVTp2QVTs.DUMP_CLASS_TO_REALIZED_NODES.println(contentsAnalysis.dumpClass2newNode().reduce("", stringJoin("\n\t")));
		}
		if (QVTp2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.isActive()) {
			QVTp2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.println(contentsAnalysis.dumpClass2oldNode().reduce("", stringJoin("\n\t")));
		}
		//
		//	Create the root containment region to introduce all root and otherwise contained consumed classes.
		//
		createRootContainmentRegion();
		//
		//	Create a connection between each consumer and the corresponding introducer/producer.
		//
		createConnections();
		//		createSchedule2();
	}

	private Stream<String> dumpInputModels() {
		Stream<String> entries = inputModels.keySet().stream().map(
			k -> String.valueOf(k) + " : " + String.valueOf(inputModels.get(k)));
		return entries.sorted();
	}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return QVTscheduleConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @Nullable Iterable<@NonNull Node> getIntroducingOrNewNodes(@NonNull Node headNode) {
		ClassDatumAnalysis classDatumAnalysis = headNode.getClassDatumAnalysis();
		if (!classDatumAnalysis.getDomainUsage().isInput()) {
			return contentsAnalysis.getNewNodes(classDatumAnalysis);	// FIXME also dependsOn ??
		}
		List<@NonNull Node> nodes = new ArrayList<>();
		nodes.add(rootContainmentRegion.getIntroducerNode(headNode));
		for (@NonNull TypedModel dependsOn : QVTbaseUtil.getDependsOns(classDatumAnalysis.getTypedModel())) {
			ClassDatumAnalysis classDatumAnalysis2 = getScheduler().getClassDatumAnalysis(headNode.getCompleteClass().getPrimaryClass(), dependsOn);
			Iterable<@NonNull Node> newNodes = contentsAnalysis.getNewNodes(classDatumAnalysis2);
			if (newNodes != null) {
				for (@NonNull Node newNode : newNodes) {
					if (!nodes.contains(newNode)) {
						nodes.add(newNode);
					}
				}
			}
		}
		return nodes;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatumAnalysis requiredClassDatumAnalysis) {
		return contentsAnalysis.getNewEdges(edge, requiredClassDatumAnalysis);
	}

	@Override
	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return contentsAnalysis.getNewNodes(classDatumAnalysis);
	}

	@Override
	public @NonNull RootScheduledRegion2 getRootScheduledRegion() {
		return this;
	}

	public @NonNull QVTp2QVTs getScheduler() {
		return (QVTp2QVTs)getSchedulerConstants();
	}

	@Override
	protected @NonNull String getSymbolNamePrefix() {
		return "s_";
	}

	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Region region : getCallableRegions()) {
			region.toCallGraph(s);
		}
		for (@NonNull Connection connection : getConnections()) {
			connection.toRegionGraph(this, s);
		}
		s.popCluster();
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Region region : getRegions()) {
			region.toGraph(s);
		}
		for (@NonNull Node node : getNodes()) {
			s.appendNode(node);
		}
		for (@NonNull Edge edge : getEdges()) {
			s.appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		}
		for (@NonNull Connection connection : getConnections()) {
			connection.toGraph(s);
		}
		s.popCluster();
	}
}