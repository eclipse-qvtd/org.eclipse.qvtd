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
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class RootScheduledRegion extends AbstractScheduledRegion
{
	public static final class IsPassedBindingEdgePredicate implements Predicate<@NonNull NodeConnection>
	{
		public static final @NonNull IsPassedBindingEdgePredicate INSTANCE = new IsPassedBindingEdgePredicate();

		@Override
		public boolean apply(@NonNull NodeConnection connection) {
			return connection.isPassed();
		}
	}

	public static final class IsUsedBindingEdgePredicate implements Predicate<@NonNull NodeConnection>
	{
		public static final @NonNull IsUsedBindingEdgePredicate INSTANCE = new IsUsedBindingEdgePredicate();

		@Override
		public boolean apply(@NonNull NodeConnection connection) {
			return connection.isUsed();
		}
	}

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

	private final @NonNull RootCompositionRegion rootContainmentRegion = new RootCompositionRegion(multiRegion);

	public RootScheduledRegion(@NonNull String name, @NonNull Region primaryRegion) {
		super(primaryRegion.getMultiRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		this.contentsAnalysis = new ContentsAnalysis(getSchedulerConstants());
	}

	public RootScheduledRegion(@NonNull String name, @NonNull List<Region> regions) {
		super(ClassUtil.nonNullState(regions.get(0)).getMultiRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		this.contentsAnalysis = new ContentsAnalysis(getSchedulerConstants());
		for (@SuppressWarnings("null")@NonNull Region region : regions) {
			addRegion(region);
		}
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRootScheduledRegion(this);
	}

	/**
	 * Propagate all used binding edges up to an ordering edge in their common region.
	 *
//	@SuppressWarnings("unused")
	private void accumulateOrderingDependencies() {
		Region2Order region2order = new Region2Order();
		region2order.computeRegionOrdering(getCallableRegions());


		for (Edge usedBindingEdge : getUsedBindingEdges()) {
			if (region2orderingEdge2usedEdges == null) {
				region2orderingEdge2usedEdges = new HashMap<>();
			}
			Node targetNode = usedBindingEdge.getTarget();
//			Iterable<Node> passedBindingSources = targetNode.getUsedBindingSources();
			for (@SuppressWarnings("null")@NonNull Node sourceNode : targetNode.getUsedBindingSources()) {
				Set<Edge> orderingEdges = region2depths.accumulateOrderingDependency(sourceNode, targetNode);
				for (Edge orderingEdge : orderingEdges) {
					Region commonRegion = orderingEdge.getRegion();
					Map<Edge, Set<Edge>> orderingEdge2usedEdges = region2orderingEdge2usedEdges.get(commonRegion);
					if (orderingEdge2usedEdges == null) {
						orderingEdge2usedEdges = new HashMap<>();
						region2orderingEdge2usedEdges.put(commonRegion, orderingEdge2usedEdges);
					}
					Set<Edge> usedEdges = orderingEdge2usedEdges.get(orderingEdge);
					if (usedEdges == null) {
						usedEdges = new HashSet<>();
						orderingEdge2usedEdges.put(orderingEdge, usedEdges);
					}
					usedEdges.add(usedBindingEdge);
					System.out.println("Ordering used children of " + commonRegion.getName() + " for " + usedBindingEdge);
				}
			}
		}
		for (Region region : getRegions()) {
			for (Edge recursionEdge : region.getRecursionEdges()) {
				if (region2orderingEdge2usedEdges == null) {
					region2orderingEdge2usedEdges = new HashMap<>();
				}
				Node targetNode = recursionEdge.getTarget();
//			Iterable<Node> passedBindingSources = targetNode.getUsedBindingSources();
//			for (@SuppressWarnings("null")@NonNull Node sourceNode : targetNode.getUsedBindingSources()) {
				Node sourceNode = recursionEdge.getSource();
				if (targetNode.isHead()) {
					for (@SuppressWarnings("null")@NonNull Node targetCallingNode : targetNode.getPassedBindingSources()) {
						for (@SuppressWarnings("null")@NonNull Node sourceCallingNode : sourceNode.getUsedBindingSources()) {	// Check same region
							Set<Edge> orderingEdges = region2depths.accumulateOrderingDependency(sourceCallingNode, targetCallingNode);
							for (Edge orderingEdge : orderingEdges) {
								Region commonRegion = orderingEdge.getRegion();
								Map<Edge, Set<Edge>> orderingEdge2usedEdges = region2orderingEdge2usedEdges.get(commonRegion);
								if (orderingEdge2usedEdges == null) {
									orderingEdge2usedEdges = new HashMap<>();
									region2orderingEdge2usedEdges.put(commonRegion, orderingEdge2usedEdges);
								}
								Set<Edge> recursionEdges = orderingEdge2usedEdges.get(orderingEdge);
								if (recursionEdges == null) {
									recursionEdges = new HashSet<>();
									orderingEdge2usedEdges.put(orderingEdge, recursionEdges);
								}
								recursionEdges.add(recursionEdge);
								System.out.println("Ordering recursive children of " + commonRegion.getName() + " for " + recursionEdges);
							}
						}
					}
				}
			}
		}
		return region2orderingEdge2usedEdges;
	} */

	/*	private void assignDepths() {
		Map<Region, Integer> region2depth = new HashMap<>();
		for (Region region : getRegions()) {
			region.computeDepths(region2depth);
		}
		for (Map.Entry<Region, Integer> entry : region2depth.entrySet()) {
			System.out.println(entry.getValue() + " : " + entry.getKey().getName());
		}
	} */

	/**
	 * Create the bindings and if necessary a join node to ensure that all sources of usedNode's
	 * ClassDatum are ready before any usedNode's region executes..
	 *
	private void addUsedInputNode(@NonNull Node usedNode) {
		ClassDatumAnalysis classDatumAnalysis = usedNode.getClassDatumAnalysis();
		Node joinNode = classDatumAnalysis2joinNodes.get(classDatumAnalysis);
		if (joinNode == null) {
			joinNode = Nodes.JOIN.createNode(this, "-all-", classDatumAnalysis);
			classDatumAnalysis2joinNodes.put(classDatumAnalysis, joinNode);
			List<Node> nodes = introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);
			if (nodes != null) {
				for (@SuppressWarnings("null")@NonNull Node node : nodes) {
					Edges.PASSED_BINDING.createEdge(this, node, null, joinNode);
				}
			}
			List<Node> realizedNodes = producedClassDatumAnalysis2realizedNodes.get(classDatumAnalysis);
			if (realizedNodes != null) {
				for (@SuppressWarnings("null")@NonNull Node realizedNode : realizedNodes) {
					Edges.PASSED_BINDING.createEdge(this, realizedNode, null, joinNode);
				}
			}
		}
		Edges.USED_BINDING.createEdge(this, joinNode, null, usedNode);
	} */

	/*	private void computeProperty2introducedClasses() {
		//
		//	Find the composite properties for each consumed class and its super classes, and accumulate
		//	the container classes of all used properties as additional consumed classes.
		//
		Set<ClassDatumAnalysis> allConsumedClassDatumAnalyses = new HashSet<>(consumedClassDatumAnalysis2headNodes.keySet());
		List<ClassDatumAnalysis> allConsumedClassDatumAnalysesList = new ArrayList<>(allConsumedClassDatumAnalyses);
		for (int i = 0; i < allConsumedClassDatumAnalysesList.size(); i++) {
			ClassDatumAnalysis consumedClassDatumAnalysis = allConsumedClassDatumAnalysesList.get(i);
			for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis consumedSuperClassDatumAnalysis : consumedClassDatumAnalysis.getSuperClassDatumAnalyses()) {
				Set<Property> compositeProperties = containedClassDatumAnalysisClosure2compositeProperties.get(consumedSuperClassDatumAnalysis);
				if (compositeProperties != null) {
					for (Property compositeProperty : compositeProperties) {
						Set<Property> consumedCompositeProperties = consumedClassDatumAnalysis2compositionProperties.get(consumedClassDatumAnalysis);
						if (consumedCompositeProperties == null) {
							consumedCompositeProperties = new HashSet<>();
							consumedClassDatumAnalysis2compositionProperties.put(consumedClassDatumAnalysis, consumedCompositeProperties);
						}
						consumedCompositeProperties.add(compositeProperty);
						Set<ClassDatumAnalysis> introducedClassDatumAnalyses = consumedCompositeProperty2introducedClassDatumAnalyses.get(compositeProperty);
						if (introducedClassDatumAnalyses == null) {
							introducedClassDatumAnalyses = new HashSet<>();
							consumedCompositeProperty2introducedClassDatumAnalyses.put(compositeProperty, introducedClassDatumAnalyses);
						}
						introducedClassDatumAnalyses.add(consumedSuperClassDatumAnalysis);
						org.eclipse.ocl.pivot.Class containerClass = compositeProperty.getOwningClass();
						assert containerClass != null;
						ClassDatumAnalysis containerSuperClassDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(containerClass, consumedSuperClassDatumAnalysis.getDomainUsage());
						if (allConsumedClassDatumAnalyses.add(containerSuperClassDatumAnalysis)) {
							allConsumedClassDatumAnalysesList.add(containerSuperClassDatumAnalysis);
						}
					}
				}
			}
		}
		assert allConsumedClassDatumAnalyses.size() == allConsumedClassDatumAnalysesList.size();
		//
		//	Find the composite properties for which a superclass of a contained class is a consumed class.
		//
		for (Entry<ClassDatumAnalysis, Set<Property>> entry : containedClassDatumAnalysisClosure2compositeProperties.entrySet()) {
			ClassDatumAnalysis classDatumAnalysis = entry.getKey();
			for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis superClassDatumAnalysis : classDatumAnalysis.getSuperClassDatumAnalyses()) {
				if (consumedClassDatumAnalysis2headNodes.get(superClassDatumAnalysis) != null) {
					for (Property compositeProperty : entry.getValue()) {
						Set<ClassDatumAnalysis> introducedClassDatumAnalyses = consumedCompositeProperty2introducedClassDatumAnalyses.get(compositeProperty);
						if (introducedClassDatumAnalyses == null) {
							introducedClassDatumAnalyses = new HashSet<>();
							consumedCompositeProperty2introducedClassDatumAnalyses.put(compositeProperty, introducedClassDatumAnalyses);
						}
						introducedClassDatumAnalyses.add(superClassDatumAnalysis);
					}
				}
			}
		}
	} */

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

	/*	private void computeProperty2introducedClasses() {
		//
		//	Find the composite properties for each consumed class and its super classes, and accumulate
		//	the container classes of all used properties as additional consumed classes.
		//
		Set<ClassDatumAnalysis> allConsumedClassDatumAnalyses = new HashSet<>(consumedClassDatumAnalysis2headNodes.keySet());
		List<ClassDatumAnalysis> allConsumedClassDatumAnalysesList = new ArrayList<>(allConsumedClassDatumAnalyses);
		for (int i = 0; i < allConsumedClassDatumAnalysesList.size(); i++) {
			ClassDatumAnalysis consumedClassDatumAnalysis = allConsumedClassDatumAnalysesList.get(i);
			for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis consumedSuperClassDatumAnalysis : consumedClassDatumAnalysis.getSuperClassDatumAnalyses()) {
				Set<Property> compositeProperties = containedClassDatumAnalysisClosure2compositeProperties.get(consumedSuperClassDatumAnalysis);
				if (compositeProperties != null) {
					for (Property compositeProperty : compositeProperties) {
						Set<Property> consumedCompositeProperties = consumedClassDatumAnalysis2compositionProperties.get(consumedClassDatumAnalysis);
						if (consumedCompositeProperties == null) {
							consumedCompositeProperties = new HashSet<>();
							consumedClassDatumAnalysis2compositionProperties.put(consumedClassDatumAnalysis, consumedCompositeProperties);
						}
						consumedCompositeProperties.add(compositeProperty);
						Set<ClassDatumAnalysis> introducedClassDatumAnalyses = consumedCompositeProperty2introducedClassDatumAnalyses.get(compositeProperty);
						if (introducedClassDatumAnalyses == null) {
							introducedClassDatumAnalyses = new HashSet<>();
							consumedCompositeProperty2introducedClassDatumAnalyses.put(compositeProperty, introducedClassDatumAnalyses);
						}
						introducedClassDatumAnalyses.add(consumedSuperClassDatumAnalysis);
						org.eclipse.ocl.pivot.Class containerClass = compositeProperty.getOwningClass();
						assert containerClass != null;
						ClassDatumAnalysis containerSuperClassDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(containerClass, consumedSuperClassDatumAnalysis.getDomainUsage());
						if (allConsumedClassDatumAnalyses.add(containerSuperClassDatumAnalysis)) {
							allConsumedClassDatumAnalysesList.add(containerSuperClassDatumAnalysis);
						}
					}
				}
			}
		}
		assert allConsumedClassDatumAnalyses.size() == allConsumedClassDatumAnalysesList.size();
		//
		//	Find the composite properties for which a superclass of a contained class is a consumed class.
		//
		for (Entry<ClassDatumAnalysis, Set<Property>> entry : containedClassDatumAnalysisClosure2compositeProperties.entrySet()) {
			ClassDatumAnalysis classDatumAnalysis = entry.getKey();
			for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis superClassDatumAnalysis : classDatumAnalysis.getSuperClassDatumAnalyses()) {
				if (consumedClassDatumAnalysis2headNodes.get(superClassDatumAnalysis) != null) {
					for (Property compositeProperty : entry.getValue()) {
						Set<ClassDatumAnalysis> introducedClassDatumAnalyses = consumedCompositeProperty2introducedClassDatumAnalyses.get(compositeProperty);
						if (introducedClassDatumAnalyses == null) {
							introducedClassDatumAnalyses = new HashSet<>();
							consumedCompositeProperty2introducedClassDatumAnalyses.put(compositeProperty, introducedClassDatumAnalyses);
						}
						introducedClassDatumAnalyses.add(superClassDatumAnalysis);
					}
				}
			}
		}
	} */

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString("s_");
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
		//		RootCompositionRegion rootContainmentRegion = new RootCompositionRegion(multiRegion);
		/*		Set<ClassDatumAnalysis> rootClassDatumAnalyses = new HashSet<>();
		for (Entry<Property, Set<ClassDatumAnalysis>> entry : consumedCompositeProperty2introducedClassDatumAnalyses.entrySet()) {
			@SuppressWarnings("null")@NonNull Property parent2childrenProperty = entry.getKey();
			Property childrenToParentProperty = parent2childrenProperty.getOpposite();
			if ((childrenToParentProperty == null) || !childrenToParentProperty.isIsRequired()) {
				for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis consumedClassDatumAnalysis : entry.getValue()) {
					if (rootClassDatumAnalyses.add(consumedClassDatumAnalysis)) {
						ClassNode introducedNode = rootContainmentRegion.addClassDatumAnalysis(consumedClassDatumAnalysis);
						addIntroducedNode(introducedNode);
					}
				}
			}
		} */
		addRegion(rootContainmentRegion);

		/*		for (@NonNull Region region : getCallableRegions()) {
			for (@NonNull Node node : region.getHeadNodes()) {
				if (node.isLoaded()) {
					Node introducedNode = rootContainmentRegion.getIntroducerNode(node);
					contentsAnalysis.addIntroducedNode(introducedNode);
				}
			}
		} */
		/*		for (Map.Entry<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> entry : consumedClassDatumAnalysis2headNodes.entrySet()) {
			@NonNull ClassDatumAnalysis classDatumAnalysis = entry.getKey();
			CompleteClass completeClass = classDatumAnalysis.getCompleteClass();
			Type childType = completeClass.getPrimaryClass();
			if (childType instanceof DataType) {
				continue;
			}
			@NonNull List<@NonNull Node> nodes = entry.getValue();
			for (@NonNull Node node : nodes) {
				Property compositeProperty = null;
				for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
					Property property = edge.getProperty();
					if (property.isIsComposite()) {
						compositeProperty = property;
						break;
					}
				}
				Node introducedNode = rootContainmentRegion.addClassDatumAnalysis(classDatumAnalysis, compositeProperty);
				addIntroducedNode(introducedNode);
			}
		} */
		/*		for (Map.Entry<@NonNull Property, @NonNull Set<@NonNull ClassDatumAnalysis>> entry : consumedCompositeProperty2introducedClassDatumAnalyses.entrySet()) {
			@NonNull Property parent2childrenProperty = entry.getKey();
			@NonNull Set<@NonNull ClassDatumAnalysis> classDatumAnalyses = entry.getValue();
			TypedModel typedModel = classDatumAnalyses.iterator().next().getTypedModel();
			DomainUsage usage = getSchedulerConstants().getDomainUsage(typedModel);
			assert usage.isInput();



//			ChildCompositionRegion containmentRegion = new ChildCompositionRegion(multiRegion, parent2childrenProperty, typedModel);
//			Node headNode = containmentRegion.getComposingNode();
//			CompleteClass parentClass = headNode.getCompleteClass();
//			addConsumedNode(headNode);
			for (@NonNull ClassDatumAnalysis classDatumAnalysis : classDatumAnalyses) {
				Node introducedNode = rootContainmentRegion.addClassDatumAnalysis(classDatumAnalysis, parent2childrenProperty);
				addIntroducedNode(introducedNode);
				CompleteClass childClass = introducedNode.getCompleteClass();
				Type childType = childClass.getPrimaryClass();
				if (childType instanceof CollectionType) {
					@SuppressWarnings("null")@NonNull Type elementType = ((CollectionType)childType).getElementType();
					childClass = getSchedulerConstants().getEnvironmentFactory().getCompleteModel().getCompleteClass(elementType);
				}
//				if (childClass.conformsTo(parentClass)) {
//					Edges.PRIMARY_RECURSION.createEdge(containmentRegion, introducedNode, headNode);
//				}
			}
		} */


		/*		Set<ClassDatumAnalysis> consumedClassDatumAnalyses = consumedClassDatumAnalysis2headNodes.keySet();		// FIXME all consumed classes
		for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis consumedClassDatumAnalysis : consumedClassDatumAnalyses) {
			boolean canBeAtRoot = !consumedClassDatumAnalysis.getDomainUsage().isOutput();
			if (consumedClassDatumAnalysis.getClassDatum().getType() instanceof DataType) {
				canBeAtRoot = false;
			}
			else {
				Set<Property> containments = containedClassDatumAnalysis2compositeProperties.get(consumedClassDatumAnalysis);
				if (containments != null) {
					Set<Property> containments2 = new HashSet<>();		// FIXME omits independent containers
					for (Property property : consumedClassDatumAnalysis.getCompleteClass().getProperties((FeatureFilter)null)) {
						Property oppositeProperty = property.getOpposite();
						if ((oppositeProperty != null) && oppositeProperty.isIsComposite() && oppositeProperty.isIsRequired()) {
							containments2.add(oppositeProperty);
						}
					}
//					assert containments.equals(containments2);
					for (Property containment : containments) {
						Property container = containment.getOpposite();
						if ((container != null) && container.isIsRequired()) {
							canBeAtRoot = false;
							break;
						}
					}
				}
			}
			if (canBeAtRoot) {
				Node introducedNode = rootContainmentRegion.addClassDatumAnalysis(consumedClassDatumAnalysis);
				addIntroducedNode(introducedNode);
			}
		} */
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

	/*	private void propagateSharedNodes(@NonNull Node outerSource, @NonNull Node innerSource, @NonNull Map<Node, Node> innerNode2outerNode) {
		for (NavigationEdge outerEdge : outerSource.getNavigationEdges()) {
			Node innerTarget = outerSource.getNavigationTarget(outerEdge.getProperty());
			if (innerTarget != null) {
				Node outerTarget = outerEdge.getTarget();
				Node oldNode = innerNode2outerNode.put(innerTarget, outerTarget);
				assert (oldNode == null) || (oldNode == outerTarget);
				if (oldNode != null) {
					propagateSharedNodes(outerTarget, innerTarget, innerNode2outerNode);
				}
			}
		}
	}

	private void propagatePassedEdges(@NonNull Node outerSource, @NonNull Node innerSource, @NonNull Map<Node, Node> innerNode2outerNode, @NonNull Map<Node, Edge> innerNode2edge) {
		for (NavigationEdge outerEdge : outerSource.getNavigationEdges()) {
			Node innerTarget = outerSource.getNavigationTarget(outerEdge.getProperty());
			if (innerTarget != null) {
				Node outerTarget = outerEdge.getTarget();
				Node oldNode = innerNode2outerNode.put(innerTarget, outerTarget);
				assert (oldNode == null) || (oldNode == outerTarget);
				if (oldNode != null) {
					propagatePassedEdges(outerTarget, innerTarget, innerNode2outerNode, innerNode2edge);
				}
			}
		}
	} */

	/*	private void propagateCommonNavigations(@NonNull Region region, Map<Node, List<Node>> outerNode2outerNodes, @NonNull Map<Region, Map<NavigationEdge, NavigationEdge>> region2innerEdge2outerEdge) {
//		Map<Node, Set<Node>> node2consumers = new HashMap<>();
		for (Node outerNode : region.getNodes()) {
			for (Edge edge : outerNode.getOutgoingPassedBindingEdges()) {
				Node innerNode = edge.getTarget();
				Iterable<Edge> incomingPassedBindingEdges = innerNode.getIncomingPassedBindingEdges();
				if (Iterables.size(incomingPassedBindingEdges) == 1) {				// FIXME is passing to multi-called regions viable?
					Map<Node, List<Node>> innerNode2outerNodes = new HashMap<>();
					for (Map.Entry<Node, List<Node>> entry : outerNode2outerNodes.entrySet()) {
						innerNode2outerNodes.put(entry.getKey(), new ArrayList<>(entry.getValue()));
					}
					assert outerNode == edge.getSource();
					List<Node> outerNodes = innerNode2outerNodes.get(innerNode);
					if (outerNodes == null) {
						List<Node> outerOuterNodes = outerNode2outerNodes.get(outerNode);
						outerNodes = outerOuterNodes != null ? new ArrayList<>(outerOuterNodes) : new ArrayList<>();
						innerNode2outerNodes.put(innerNode, outerNodes);
					}
					if (!outerNodes.contains(outerNode)) {
						outerNodes.add(outerNode);
					}
					propagateCommonNavigations(innerNode, innerNode2outerNodes, region2innerEdge2outerEdge);
					propagateCommonNavigations(innerNode.getRegion(), innerNode2outerNodes, region2innerEdge2outerEdge);

				}
			}
		}
	} */

	/**
	 * Recursively propagate the common navigation paths at innerSourceNode to all nodes navigable from
	 * it accumulating equivalent navigations in innerNode2outerNodes.
	 *
	private void propagateCommonNavigations(@NonNull Node innerSourceNode, @NonNull Map<Node, List<Node>> innerNode2outerNodes, @NonNull Map<Region, Map<NavigationEdge, NavigationEdge>> region2innerEdge2outerEdge) {
		Region innerRegion = innerSourceNode.getRegion();
		Map<NavigationEdge, NavigationEdge> innerEdge2outerEdge = region2innerEdge2outerEdge.get(innerRegion);
		if (innerEdge2outerEdge == null) {
			innerEdge2outerEdge = new HashMap<>();
			region2innerEdge2outerEdge.put(innerRegion, innerEdge2outerEdge);
		}
		List<Node> outerSourceNodes = innerNode2outerNodes.get(innerSourceNode);
		for (NavigationEdge innerEdge : innerSourceNode.getNavigationEdges()) {
			Node innerTargetNode = innerEdge.getTarget();
			if (innerTargetNode.isClassNode() && !innerEdge.getProperty().isIsMany()) {
				List<Node> outerTargetNodes = innerNode2outerNodes.get(innerTargetNode);
				if (outerTargetNodes == null) {
					outerTargetNodes = new ArrayList<>();
					innerNode2outerNodes.put(innerTargetNode, outerTargetNodes);
					for (Node outerSourceNode : outerSourceNodes) {
						NavigationEdge outerEdge = outerSourceNode.getNavigationEdge(innerEdge.getProperty());
						if (outerEdge != null) {
							Node outerTargetNode = outerEdge.getTarget();
							if (!outerTargetNodes.contains(outerTargetNode)) {
								outerTargetNodes.add(outerTargetNode);
								List<Node> outerOuterTargetNodes = innerNode2outerNodes.get(outerTargetNode);
								if (outerOuterTargetNodes != null) {
									outerTargetNodes.addAll(outerOuterTargetNodes);
								}		// FIXME accumulate an active binding
							}
							innerEdge2outerEdge.put(innerEdge, outerEdge);
						}
					}
					if (outerTargetNodes.size() > 0) {

					}
					propagateCommonNavigations(innerTargetNode, innerNode2outerNodes, region2innerEdge2outerEdge);
				}
			}
		}
	} */

	private Stream<String> dumpInputModels() {
		Stream<String> entries = inputModels.keySet().stream().map(
			k -> String.valueOf(k) + " : " + String.valueOf(inputModels.get(k)));
		return entries.sorted();
	}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return QVTp2QVTs.EMPTY_NODE_LIST;
	}

	/*	public @Nullable Iterable<@NonNull Node> getIntroducingNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		/ *	List<Node> introducingNodes = null;
		CompleteClass completeClass = classDatumAnalysis.getCompleteClass();
		for (ClassDatumAnalysis aClassDatumAnalysis : introducedClassDatumAnalysis2nodes.keySet()) {		// FIXME cache
			if (completeClass.conformsTo(aClassDatumAnalysis.getCompleteClass())) {
				if (introducingNodes == null) {
					introducingNodes = new ArrayList<>();
				}
				introducingNodes.addAll(introducedClassDatumAnalysis2nodes.get(aClassDatumAnalysis));
			}
		} * /
		return introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);	// Separate introduction of each consumed type
	} */

	public @Nullable Iterable<@NonNull Node> getIntroducingOrNewNodes(@NonNull Node headNode) {
		ClassDatumAnalysis classDatumAnalysis = headNode.getClassDatumAnalysis();
		if (classDatumAnalysis.getDomainUsage().isInput()) {
			return Collections.singletonList(rootContainmentRegion.getIntroducerNode(headNode));
		}
		else {
			return contentsAnalysis.getNewNodes(classDatumAnalysis);
		}
	}

	/*	public @NonNull List<ConnectionRegion> getConnectionRegions(@NonNull Region toRegion) {
		List<ConnectionRegion> joinRegions = new ArrayList<>();
		for (Connection edge : toRegion.getParentPassedConnections()) {
			Node sourceNode = edge.getSource();
			ConnectionRegion joinRegion;
			Region sourceRegion = sourceNode.getRegion();
			if (sourceRegion.isConnectionRegion()) {
				joinRegion = (ConnectionRegion) sourceRegion;
			}
			else {
				ClassDatumAnalysis classDatumAnalysis = sourceNode.getClassDatumAnalysis();
				String joinName = "-join-" + classDatumAnalysis.getCompleteClass().getName() + "-" + toRegion.getName();
				joinRegion = new ConnectionRegion(getMultiRegion(), joinName, classDatumAnalysis);
				Node joinNode = joinRegion.getConnectionNode();
				Connections.PASSED_BINDING.createConnection(this, sourceNode, null, joinNode);
				Connections.PASSED_BINDING.createConnection(this, joinNode, null, edge.getTarget());
			}
			joinRegions.add(joinRegion);
			addRegion(joinRegion);
		}
		return joinRegions;
	} */

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatumAnalysis requiredClassDatumAnalysis) {
		return contentsAnalysis.getNewEdges(edge, requiredClassDatumAnalysis);
	}

	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return contentsAnalysis.getNewNodes(classDatumAnalysis);
	}

	@Override
	public @NonNull RootScheduledRegion getRootScheduledRegion() {
		return this;
	}

	public @NonNull QVTp2QVTs getScheduler() {
		return (QVTp2QVTs)getSchedulerConstants();
	}

	/*	private @NonNull Node zzgetSourceOrConnectionNode(@NonNull Collection<Node> sourceNodes, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (sourceNodes.size() <= 1) {
			@SuppressWarnings("null")@NonNull Node sourceNode = sourceNodes.iterator().next();
			return sourceNode;
		}
		Map<Set<Node>, Connection> joins = classDatumAnalysis2nodes2connections.get(classDatumAnalysis);
		if (joins == null) {
			joins = new HashMap<>();
			classDatumAnalysis2nodes2connections.put(classDatumAnalysis, joins);
		}
		Set<Node> sources = new HashSet<>(sourceNodes);
		Connection joinRegion = joins.get(sources);
		if (joinRegion != null) {
			return joinRegion.getConnectionNode();
		}
		String joinName = "-join-" + classDatumAnalysis.getCompleteClass().getName() + "-" + joins.size();
		joinRegion = new ConnectionRegion(getMultiRegion(), joinName, classDatumAnalysis);
		joins.put(sources, joinRegion);
		Node joinNode = joinRegion.getConnectionNode();
		for (Node sourceNode : sourceNodes) {
			assert sourceNode != null;
			Connections.PASSED_BINDING.createConnection(this, sourceNode, null, joinNode);
		}
		return joinNode;
	} */

	/*	private final @NonNull Iterable<Edge> getUsedBindingEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(getEdges(), IsUsedBindingEdgePredicate.INSTANCE);
		return filter;
	} */

	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Region region : getCallableRegions()) {
			region.toCallGraph(s);
			///			s.appendNode(region);
			//			for (@SuppressWarnings("null")@NonNull Edge edge : region.getRecursionEdges()) {
			//				s.appendEdge(edge.getSource().getRegion(), edge, edge.getTarget().getRegion());
			//			}
		}
		//		for (@SuppressWarnings("null")@NonNull Node node : getNodes()) {
		//			s.appendNode(node);
		//		}
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
			s.appendEdge(edge.getSource(), edge, edge.getTarget());
		}
		for (@NonNull Connection connection : getConnections()) {
			connection.toGraph(s);
		}
		s.popCluster();
	}
}