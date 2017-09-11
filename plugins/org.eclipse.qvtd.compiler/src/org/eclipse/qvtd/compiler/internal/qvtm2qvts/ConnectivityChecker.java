/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/**
 * ConnectivityChecker is a debug aid providing anslyses and consistency checks of a ScheduleModel.
 */
public class ConnectivityChecker
{
	public static final @NonNull TracingOption CONNECTIVITY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/connectivity");
	public static final @NonNull TracingOption CONNECTIVITY_CLASSDATUMS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/connectivity/classdatums");
	public static final @NonNull TracingOption CONNECTIVITY_CONNECTIONS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/connectivity/connections");
	public static final @NonNull TracingOption CONNECTIVITY_EDGES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/connectivity/edges");
	public static final @NonNull TracingOption CONNECTIVITY_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/connectivity/nodes");

	public static void checkConnectivity(@NonNull ScheduleManager scheduleManager) throws CompilerChainException {
		ConnectivityChecker connectivityChecker = new ConnectivityChecker(scheduleManager);
		connectivityChecker.analyze();
		if (ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.isActive()) {
			ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.println("SubClassDatums" + connectivityChecker.showSubClassDatums(new StringBuilder()));
			ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.println("SuperClassDatums" + connectivityChecker.showSuperClassDatums(new StringBuilder()));
		}
		if (ConnectivityChecker.CONNECTIVITY_CONNECTIONS.isActive()) {
			ConnectivityChecker.CONNECTIVITY_CONNECTIONS.println("Connection connectivity" + connectivityChecker.showConnectionConnectivity(new StringBuilder()));
		}
		if (ConnectivityChecker.CONNECTIVITY_NODES.isActive()) {
			ConnectivityChecker.CONNECTIVITY_NODES.println("Node connectivity" + connectivityChecker.showNodeConnectivity(new StringBuilder()));
		}
		if (ConnectivityChecker.CONNECTIVITY_EDGES.isActive()) {
			ConnectivityChecker.CONNECTIVITY_EDGES.println("Edge connectivity" + connectivityChecker.showEdgeConnectivity(new StringBuilder()));
		}
		String connectivityProblems = connectivityChecker.checkConnectivity("\t");
		if (connectivityProblems != null) {
			throw new CompilerChainException("Schedule has connectivity problems\n" + connectivityProblems);
		}
	}

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ScheduleModel scheduleModel;
	protected final @NonNull ScheduledRegion scheduledRegion;
	private final @NonNull Map<@NonNull String, @NonNull ClassDatum> name2classDatum = new HashMap<>();
	private final @NonNull Map<@NonNull String, @NonNull DatumConnection<?>> name2connection = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Set<@NonNull ClassDatum>> classDatum2subClassDatums = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Set<@NonNull ClassDatum>> classDatum2superClassDatums = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull DatumConnection<?>>> producer2connections = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull DatumConnection<?>>> consumer2connections = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Node>> producer2nodes = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Node>> consumer2nodes = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Edge>> producer2edges = new HashMap<>();
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Edge>> consumer2edges = new HashMap<>();

	public ConnectivityChecker(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
		this.scheduleModel = scheduleManager.getScheduleModel();
		this.scheduledRegion = RegionUtil.getOwnedScheduledRegion(scheduleModel);
	}

	protected @NonNull ClassDatum addClassDatum(@NonNull Node node) {
		ClassDatum classDatum = getNormalizedClassDatum(node);
		String name = RegionUtil.getName(classDatum);
		ClassDatum oldClassDatum = name2classDatum.put(name, classDatum);
		assert (oldClassDatum == null) || (oldClassDatum == classDatum);
		return classDatum;
	}

	public void analyze() {
		for (@NonNull ClassDatum classDatum : RegionUtil.getOwnedClassDatums(scheduleModel)) {
			analyzeClassDatums(classDatum);
		}
		for (@NonNull Connection connection : RegionUtil.getOwnedConnections(scheduledRegion)) {
			analyzeConnection(connection);
		}
		for (@NonNull Region region : RegionUtil.getOwnedRegions(scheduledRegion)) {
			analyzeRegion(region);
		}
	}

	/**
	 * Build the transitive classDatum2superClassDatums and classDatum2subClassDatums for classDatum and its superClassDatums.
	 */
	private @NonNull Set<@NonNull ClassDatum> analyzeClassDatums(@NonNull ClassDatum classDatum) {
		Set<@NonNull ClassDatum> superClassDatums = classDatum2superClassDatums.get(classDatum);
		if (superClassDatums == null) {
			superClassDatums = new HashSet<>();
			classDatum2superClassDatums.put(classDatum, superClassDatums);
			superClassDatums.add(classDatum);
			for (@NonNull ClassDatum superClassDatum : RegionUtil.getSuperClassDatums(classDatum)) {
				for (@NonNull ClassDatum transitiveSuperClassDatum : analyzeClassDatums(superClassDatum)) {
					superClassDatums.add(transitiveSuperClassDatum);
					Set<@NonNull ClassDatum> subClassDatums = classDatum2subClassDatums.get(transitiveSuperClassDatum);
					if (subClassDatums == null) {
						subClassDatums = new HashSet<>();
						classDatum2subClassDatums.put(transitiveSuperClassDatum, subClassDatums);
						subClassDatums.add(transitiveSuperClassDatum);
					}
					subClassDatums.add(classDatum);
				}
			}
		}
		return superClassDatums;
	}

	protected void analyzeConnection(@NonNull Connection connection) {
		DatumConnection<?> datumConnection = (DatumConnection<?>) connection;
		DatumConnection<?> oldDatumConnection = name2connection.put(RegionUtil.getName(datumConnection), datumConnection);
		assert oldDatumConnection == null;
		for (@NonNull Node sourceNode : datumConnection.getSourceNodes()) {
			ClassDatum classDatum = addClassDatum(sourceNode);
			List<@NonNull DatumConnection<?>> connections = producer2connections.get(classDatum);
			if (connections == null) {
				connections = new ArrayList<>();
				producer2connections.put(classDatum, connections);
			}
			//				assert !connections.contains(datumConnection);
			connections.add(datumConnection);
		}
		for (@NonNull Node targetNode : datumConnection.getTargetNodes()) {
			ClassDatum classDatum = addClassDatum(targetNode);
			List<@NonNull DatumConnection<?>> connections = consumer2connections.get(classDatum);
			if (connections == null) {
				connections = new ArrayList<>();
				consumer2connections.put(classDatum, connections);
			}
			//				assert !connections.contains(datumConnection);
			connections.add(datumConnection);
		}
	}

	protected void analyzeRegion(@NonNull Region region) {
		for (@NonNull Node node : RegionUtil.getOwnedNodes(region)) {
			if (node.isNew()) {
				ClassDatum classDatum = addClassDatum(node);
				List<@NonNull Node> nodes = producer2nodes.get(classDatum);
				if (nodes == null) {
					nodes = new ArrayList<>();
					producer2nodes.put(classDatum, nodes);
				}
				assert !nodes.contains(node);
				nodes.add(node);
			}
			if (node.isPredicated() || node.isSpeculated()) {
				ClassDatum classDatum = addClassDatum(node);
				List<@NonNull Node> nodes = consumer2nodes.get(classDatum);
				if (nodes == null) {
					nodes = new ArrayList<>();
					consumer2nodes.put(classDatum, nodes);
				}
				assert !nodes.contains(node);
				nodes.add(node);
			}
		}
		for (@NonNull Edge edge : RegionUtil.getOwnedEdges(region)) {
			if (edge.isRealized()) {
				ClassDatum classDatum = addClassDatum(RegionUtil.getSourceNode(edge));
				List<@NonNull Edge> edges = producer2edges.get(classDatum);
				if (edges == null) {
					edges = new ArrayList<>();
					producer2edges.put(classDatum, edges);
				}
				assert !edges.contains(edge);
				edges.add(edge);
			}
			if (edge.isPredicated()) {
				ClassDatum classDatum = addClassDatum(RegionUtil.getSourceNode(edge));
				List<@NonNull Edge> edges = consumer2edges.get(classDatum);
				if (edges == null) {
					edges = new ArrayList<>();
					consumer2edges.put(classDatum, edges);
				}
				assert !edges.contains(edge);
				edges.add(edge);
			}
		}
	}

	/**
	 * Return a non-null sequence of linePrefix strings for any connections problems, or null if ok.
	 */
	public @Nullable String checkConnectivity(@Nullable String linePrefix) {
		StringBuilder s = null;
		List<@NonNull String> names = new ArrayList<>(name2classDatum.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			ClassDatum classDatum = name2classDatum.get(name);
			assert classDatum != null;
			ClassDatumAnalysis classDatumAnalysis = scheduleManager.getClassDatumAnalysis(classDatum);
			DomainUsage domainUsage = classDatumAnalysis.getDomainUsage();
			if (domainUsage.isMiddle() || domainUsage.isOutput()) {
				int subProducers = getSubProducers(classDatum).size();
				List<@NonNull Node> producingNodes = producer2nodes.get(classDatum);
				List<@NonNull Node> consumingNodes = consumer2nodes.get(classDatum);
				int producers = producingNodes != null ? producingNodes.size() : 0;
				int consumers = consumingNodes != null ? consumingNodes.size() : 0;
				if ((consumers > 0) && (producers == 0) && (subProducers == 0)) {
					if (s == null) {
						s = new StringBuilder();
					}
					else {
						s.append("\n");
					}
					if (linePrefix != null) {
						s.append(linePrefix);
					}
					s.append(name);
					s.append(" is consumed but not produced");
				}
			}
		}
		return s != null ? s.toString() : null;
	}

	// FIXME this fudges the inconvenience that a ComposedNode has a Collection ClassDatum
	private @NonNull ClassDatum getNormalizedClassDatum(@NonNull Node node) {
		ClassDatum classDatum = RegionUtil.getClassDatum(node);
		org.eclipse.ocl.pivot.Class primaryClass = classDatum.getCompleteClass().getPrimaryClass();
		if (primaryClass instanceof CollectionType) {
			primaryClass = (org.eclipse.ocl.pivot.Class)PivotUtil.getElementType((CollectionType)primaryClass);
			classDatum = scheduleManager.getClassDatum(primaryClass, RegionUtil.getReferredTypedModel(classDatum));
		}
		return classDatum;
	}

	private @NonNull Set<@NonNull Node> getSubConsumers(@NonNull ClassDatum classDatum) {
		Set<@NonNull Node> subConsumers = new HashSet<>();
		Set<@NonNull ClassDatum> subClassDatums = classDatum2subClassDatums.get(classDatum);
		if (subClassDatums != null) {
			for (@NonNull ClassDatum subClassDatum : subClassDatums) {
				if (subClassDatum != classDatum) {
					List<@NonNull Node> subConsumingNodes = consumer2nodes.get(subClassDatum);
					if (subConsumingNodes != null) {
						subConsumers.addAll(subConsumingNodes);
					}
				}
			}
		}
		return subConsumers;
	}

	private @NonNull Set<@NonNull Node> getSubProducers(@NonNull ClassDatum classDatum) {
		Set<@NonNull Node> subProducers = new HashSet<>();
		Set<@NonNull ClassDatum> subClassDatums = classDatum2subClassDatums.get(classDatum);
		if (subClassDatums != null) {
			for (@NonNull ClassDatum subClassDatum : subClassDatums) {
				if (subClassDatum != classDatum) {
					List<@NonNull Node> subProducingNodes = producer2nodes.get(subClassDatum);
					if (subProducingNodes != null) {
						subProducers.addAll(subProducingNodes);
					}
				}
			}
		}
		return subProducers;
	}

	private @NonNull Set<@NonNull Node> getSuperConsumers(@NonNull ClassDatum classDatum) {
		Set<@NonNull Node> superConsumers = new HashSet<>();
		Set<@NonNull ClassDatum> superClassDatums = classDatum2superClassDatums.get(classDatum);
		if (superClassDatums != null) {
			for (@NonNull ClassDatum superClassDatum : superClassDatums) {
				if (superClassDatum != classDatum) {
					List<@NonNull Node> superConsumingNodes = consumer2nodes.get(superClassDatum);
					if (superConsumingNodes != null) {
						superConsumers.addAll(superConsumingNodes);
					}
				}
			}
		}
		return superConsumers;
	}

	private @NonNull Set<@NonNull Node> getSuperProducers(@NonNull ClassDatum classDatum) {
		Set<@NonNull Node> superProducers = new HashSet<>();
		Set<@NonNull ClassDatum> superClassDatums = classDatum2superClassDatums.get(classDatum);
		if (superClassDatums != null) {
			for (@NonNull ClassDatum superClassDatum : superClassDatums) {
				if (superClassDatum != classDatum) {
					List<@NonNull Node> superProducingNodes = producer2nodes.get(superClassDatum);
					if (superProducingNodes != null) {
						superProducers.addAll(superProducingNodes);
					}
				}
			}
		}
		return superProducers;
	}

	public @NonNull StringBuilder showConnectionConnectivity(@NonNull StringBuilder s) {
		List<@NonNull String> names = new ArrayList<>(name2classDatum.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			ClassDatum classDatum = name2classDatum.get(name);
			assert classDatum != null;
			List<@NonNull DatumConnection<?>> producingConnections = producer2connections.get(classDatum);
			List<@NonNull DatumConnection<?>> consumingConnections = consumer2connections.get(classDatum);
			int producers = producingConnections != null ? producingConnections.size() : 0;
			int consumers = consumingConnections != null ? consumingConnections.size() : 0;
			if ((consumers > 0) || (producers > 0)) {
				s.append("\n\t");
				s.append(producers);
				s.append("=>");
				s.append(consumers);
				s.append(" ");
				s.append(name);
			}
		}
		return s;
	}

	public @NonNull StringBuilder showEdgeConnectivity(@NonNull StringBuilder s) {
		List<@NonNull String> names = new ArrayList<>(name2classDatum.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			ClassDatum classDatum = name2classDatum.get(name);
			assert classDatum != null;
			int superProducers = 0;
			int superConsumers = 0;
			Set<@NonNull ClassDatum> superClassDatums = classDatum2superClassDatums.get(classDatum);
			if (superClassDatums != null) {
				for (@NonNull ClassDatum superClassDatum : superClassDatums) {
					if (superClassDatum != classDatum) {
						List<@NonNull Edge> superProducingEdges = producer2edges.get(superClassDatum);
						List<@NonNull Edge> superConsumingEdges = consumer2edges.get(superClassDatum);
						if (superProducingEdges != null) {
							superProducers += superProducingEdges.size();
						}
						if (superConsumingEdges != null) {
							superConsumers += superConsumingEdges.size();
						}
					}
				}
			}
			int subProducers = 0;
			int subConsumers = 0;
			Set<@NonNull ClassDatum> subClassDatums = classDatum2subClassDatums.get(classDatum);
			if (subClassDatums != null) {
				for (@NonNull ClassDatum subClassDatum : subClassDatums) {
					if (subClassDatum != classDatum) {
						List<@NonNull Edge> subProducingEdges = producer2edges.get(subClassDatum);
						List<@NonNull Edge> subConsumingEdges = consumer2edges.get(subClassDatum);
						if (subProducingEdges != null) {
							subProducers += subProducingEdges.size();
						}
						if (subConsumingEdges != null) {
							subConsumers += subConsumingEdges.size();
						}
					}
				}
			}
			List<@NonNull Edge> producingEdges = producer2edges.get(classDatum);
			List<@NonNull Edge> consumingEdges = consumer2edges.get(classDatum);
			int producers = producingEdges != null ? producingEdges.size() : 0;
			int consumers = consumingEdges != null ? consumingEdges.size() : 0;
			if ((consumers > 0) || (producers > 0) || (subConsumers > 0) || (subProducers > 0) || (superConsumers > 0) || (superProducers > 0)) {
				s.append("\n\t(");
				s.append(superProducers);
				s.append("),");
				s.append(producers);
				s.append(",(");
				s.append(subProducers);
				s.append(")=>(");
				s.append(superConsumers);
				s.append("),");
				s.append(consumers);
				s.append(",(");
				s.append(subConsumers);
				s.append(") ");
				s.append(name);
			}
		}
		return s;
	}

	public @NonNull StringBuilder showNodeConnectivity(@NonNull StringBuilder s) {
		List<@NonNull String> names = new ArrayList<>(name2classDatum.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			ClassDatum classDatum = name2classDatum.get(name);
			assert classDatum != null;
			int superProducers = getSuperProducers(classDatum).size();
			int superConsumers = getSuperConsumers(classDatum).size();
			int subProducers = getSubProducers(classDatum).size();
			int subConsumers = getSubConsumers(classDatum).size();
			List<@NonNull Node> producingNodes = producer2nodes.get(classDatum);
			List<@NonNull Node> consumingNodes = consumer2nodes.get(classDatum);
			int producers = producingNodes != null ? producingNodes.size() : 0;
			int consumers = consumingNodes != null ? consumingNodes.size() : 0;
			if ((consumers > 0) || (producers > 0) || (subConsumers > 0) || (subProducers > 0) || (superConsumers > 0) || (superProducers > 0)) {
				s.append("\n\t(");
				s.append(superProducers);
				s.append("),");
				s.append(producers);
				s.append(",(");
				s.append(subProducers);
				s.append(")=>(");
				s.append(superConsumers);
				s.append("),");
				s.append(consumers);
				s.append(",(");
				s.append(subConsumers);
				s.append(") ");
				s.append(name);
			}
		}
		return s;
	}

	public @NonNull StringBuilder showSubClassDatums(@NonNull StringBuilder s) {
		List<@NonNull String> names = new ArrayList<>(name2classDatum.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			ClassDatum classDatum = name2classDatum.get(name);
			assert classDatum != null;
			Set<@NonNull ClassDatum> subClassDatums = classDatum2subClassDatums.get(classDatum);
			if ((subClassDatums != null) && (subClassDatums.size() > 1)) {
				s.append("\n\t");
				s.append(name);
				List<@NonNull String> names2 = new ArrayList<>();
				for (@NonNull ClassDatum subClassDatum : subClassDatums) {
					if (subClassDatum != classDatum) {
						names2.add(RegionUtil.getName(subClassDatum));
					}
				}
				Collections.sort(names2);
				for (@NonNull String name2 : names2) {
					s.append("\n\t\t");
					s.append(name2);
				}
			}
		}
		return s;
	}

	public @NonNull StringBuilder showSuperClassDatums(@NonNull StringBuilder s) {
		List<@NonNull String> names = new ArrayList<>(name2classDatum.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			ClassDatum classDatum = name2classDatum.get(name);
			assert classDatum != null;
			Set<@NonNull ClassDatum> superClassDatums = classDatum2superClassDatums.get(classDatum);
			if ((superClassDatums != null) && (superClassDatums.size() > 1)) {
				s.append("\n\t");
				s.append(name);
				List<@NonNull String> names2 = new ArrayList<>();
				for (@NonNull ClassDatum superClassDatum : superClassDatums) {
					if (superClassDatum != classDatum) {
						names2.add(RegionUtil.getName(superClassDatum));
					}
				}
				Collections.sort(names2);
				for (@NonNull String name2 : names2) {
					s.append("\n\t\t");
					s.append(name2);
				}
			}
		}
		return s;
	}
}