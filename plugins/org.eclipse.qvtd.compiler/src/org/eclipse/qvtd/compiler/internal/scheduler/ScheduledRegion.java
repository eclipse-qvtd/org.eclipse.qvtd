/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.schedule2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ScheduledRegion extends AbstractRegion
{	
	public static final class IsPassedBindingEdgePredicate implements Predicate<Connection>
	{
		public static final @NonNull IsPassedBindingEdgePredicate INSTANCE = new IsPassedBindingEdgePredicate();

		@Override
		public boolean apply(Connection connection) {
			return connection.isPassed();
		}
	}

	public static final class IsUsedBindingEdgePredicate implements Predicate<Connection>
	{
		public static final @NonNull IsUsedBindingEdgePredicate INSTANCE = new IsUsedBindingEdgePredicate();

		@Override
		public boolean apply(Connection connection) {
			return connection.isUsed();
		}
	}

	/**
	 * Propagate the used bindings from callingNode to calledNode.
	 */
	private static void createUsedBindings(@NonNull Node calledNode, @Nullable Node callingNode, @NonNull Map<Node, Node> bindings) {
		Node oldPrevNode = bindings.get(calledNode);
		if (oldPrevNode != null) {					// been here before
			assert (oldPrevNode == callingNode) || (callingNode == null);
			return;
		}
		if (bindings.containsKey(calledNode) && (callingNode == null)) {		// here before and consistently null
			return;
		}
		bindings.put(calledNode, callingNode);
		for (NavigationEdge calledEdge : calledNode.getNavigationEdges()) {
			Node nextCalledNode = calledEdge.getTarget();//.getCastEquivalentNode();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isAttributeNode()) {
				Edge nextCallingEdge = callingNode != null ? callingNode.getNavigationEdge(calledEdge.getProperty()) : null;
				if (nextCallingEdge != null) {
					Node nextCallingNode = nextCallingEdge.getTarget();//.getCastEquivalentNode();
					assert nextCallingNode.isNull() == nextCalledNode.isNull();
					if (!nextCalledNode.isNull()) {
						createUsedBindings(nextCalledNode, nextCallingNode, bindings);
					}
				}
				else {
					createUsedBindings(nextCalledNode, null, bindings);
				}
			}
		}
	}
	
	/**
	 * Return true if the predicates of calledNode are not in conflict with the navigable paths from callingNode.
	 * bindings identifies already identified conflict free pairs that do not need re-assessment.
	 */
	private static boolean isConflictFree(@NonNull Node calledNode, @NonNull Node callingNode, @NonNull Map<Node, Node> bindings) {
		Node oldPrevNode = bindings.put(calledNode, callingNode);
		if (oldPrevNode != null) {
			assert oldPrevNode == callingNode;
			return true;
		}
		for (NavigationEdge calledEdge : calledNode.getNavigationEdges()) {
			Node nextCalledNode = calledEdge.getTarget();//.getCastEquivalentNode();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isAttributeNode()) {
				Edge nextCallingEdge = callingNode.getNavigationEdge(calledEdge.getProperty());
				if (nextCallingEdge != null) {
					Node nextCallingNode = nextCallingEdge.getTarget();//.getCastEquivalentNode();
					if ((nextCallingNode.isNull() != nextCalledNode.isNull())) {
						return false;
					}
					if (!isConflictFree(nextCalledNode, nextCallingNode, bindings)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static @NonNull BinaryOperator<@NonNull String> stringJoin(@NonNull String delimiter) {
		return (a, b) -> String.valueOf(a) + delimiter + String.valueOf(b);
	}
	
	private final @NonNull String name;	
	protected final @NonNull CompleteModel completeModel;

	/**
	 */
	private final @NonNull List<Region> regions = new ArrayList<Region>();

	/**
	 * All the connections defined in this region, but not those in nested regions.
	 */
	private @NonNull List<Connection> connections = new ArrayList<Connection>();
	
	/**
	 * The input models that may introduce model elements for transformation. 
	 */
	private final @NonNull HashMap<Model, DomainUsage> inputModels = new HashMap<Model, DomainUsage>();
	
	/**
	 * Mapping from each input class to the composite properties that may contain the class or its subclasses.
	 *-- The mapping incorporates an inheritance closure; a composition property that may compose B instances
	 *-- is also registered as a composition of all of B's superclasses such as OclAny. Consequently a consumer
	 *-- of some type need only lookup the consumed type to obtain all the composition properties that could
	 *-- introduce the consumed type; the exact type or its superclasses that may need dynamic type selection.
	 *-- If an input model is unhelpful enough to provide a composes-OclAny relationship, then this unhelpful
	 *-- relationship is included in every entry since it must be considered as an introducer for every possible
	 *-- consumption.
	 */
	private final @NonNull Map<ClassDatumAnalysis, @NonNull Set<Property>> containedClassDatumAnalysis2compositeProperties = new HashMap<ClassDatumAnalysis, @NonNull Set<Property>>();

	/**
	 * The input model classes that may be used as independent inputs by mappings and the nodes at which they are consumed.
	 * In the worst case a flat schedule just permutes allInstances() to provide all mapping inputs.
	 */
	private final @NonNull Map<ClassDatumAnalysis, @NonNull List<Node>> consumedClassDatumAnalysis2headNodes = new HashMap<ClassDatumAnalysis, @NonNull List<Node>>();

	/**
	 * Mapping from each composite property to the classes consumed by mappings and transitive compositions.
	 * No mapping entry is created for composition properties that are not required to introduce model elements.
	 * 
	 * For simple cases each composition introduces instances of just a single class corresponding to its composed type.
	 * In more complex cases a composition may also introduce instances of superclasses of its composed type.
	 */
	private final @NonNull Map<Property, @NonNull Set<ClassDatumAnalysis>> consumedCompositeProperty2introducedClassDatumAnalyses = new HashMap<Property, @NonNull Set<ClassDatumAnalysis>>();

	/**
	 * The per-class join nodes that identify all introducers.
	 */
	private final @NonNull Map<ClassDatumAnalysis, List<Node>> introducedClassDatumAnalysis2nodes = new HashMap<ClassDatumAnalysis, List<Node>>();

	/**
	 * The Realized Nodes that produce each ClassDatum.
	 */
	private final @NonNull Map<ClassDatumAnalysis, @NonNull List<Node>> producedClassDatumAnalysis2realizedNodes = new HashMap<ClassDatumAnalysis, @NonNull List<Node>>();

	/**
	 * The Realized Edges that produce each PropertyDatum (or its opposite).
	 */
	private final @NonNull Map<PropertyDatum, List<NavigationEdge>> producedPropertyDatum2realizedEdges = new HashMap<PropertyDatum, List<NavigationEdge>>();

	/**
	 * The per-class connections that unite a set of sources via a shared connection.
	 */
	private final @NonNull Map<ClassDatumAnalysis, Map<Set<Node>, Connection>> classDatumAnalysis2nodes2connections = new HashMap<ClassDatumAnalysis, Map<Set<Node>, Connection>>();

	/**
	 * The per-class connections that unite all producers and their non-input consumers.
	 */
//	private final @NonNull Map<ClassDatumAnalysis, Node> producedClassDatumAnalysis2joinNodes = new HashMap<ClassDatumAnalysis, Node>();
	
	/**
	 * The composition properties that can introduce instances for each ClassDatumAnalysis.
	 */
//	private final @NonNull Map<ClassDatumAnalysis, Set<Property>> consumedClassDatumAnalysis2compositionProperties = new HashMap<ClassDatumAnalysis, Set<Property>>();

	private RegionOrdering regionOrderer = null;
	
	public ScheduledRegion(@NonNull String name, @NonNull Region primaryRegion) {
		super(primaryRegion.getSuperRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
	}

	public ScheduledRegion(@NonNull String name, @NonNull List<Region> regions) {
		super(ClassUtil.nonNullState(regions.get(0)).getSuperRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		for (@SuppressWarnings("null")@NonNull Region region : regions) {
			addRegion(region);
		}
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRootRegion(this);
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
				region2orderingEdge2usedEdges = new HashMap<Region, Map<Edge, Set<Edge>>>();
			}
			Node targetNode = usedBindingEdge.getTarget();
//			Iterable<Node> passedBindingSources = targetNode.getUsedBindingSources();
			for (@SuppressWarnings("null")@NonNull Node sourceNode : targetNode.getUsedBindingSources()) {
				Set<Edge> orderingEdges = region2depths.accumulateOrderingDependency(sourceNode, targetNode);
				for (Edge orderingEdge : orderingEdges) {
					Region commonRegion = orderingEdge.getRegion();
					Map<Edge, Set<Edge>> orderingEdge2usedEdges = region2orderingEdge2usedEdges.get(commonRegion);
					if (orderingEdge2usedEdges == null) {
						orderingEdge2usedEdges = new HashMap<Edge, Set<Edge>>();
						region2orderingEdge2usedEdges.put(commonRegion, orderingEdge2usedEdges);
					}
					Set<Edge> usedEdges = orderingEdge2usedEdges.get(orderingEdge);
					if (usedEdges == null) {
						usedEdges = new HashSet<Edge>();
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
					region2orderingEdge2usedEdges = new HashMap<Region, Map<Edge, Set<Edge>>>();
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
									orderingEdge2usedEdges = new HashMap<Edge, Set<Edge>>();
									region2orderingEdge2usedEdges.put(commonRegion, orderingEdge2usedEdges);
								}
								Set<Edge> recursionEdges = orderingEdge2usedEdges.get(orderingEdge);
								if (recursionEdges == null) {
									recursionEdges = new HashSet<Edge>();
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

	private void addConsumedNode(@NonNull Node headNode) {
//		assert !"EObject".equals(headNode.getCompleteClass().getName());
		Region region = headNode.getRegion();
		Region invokingRegion = region.getInvokingRegion();
		assert (invokingRegion == this) || (invokingRegion == null);
		ClassDatumAnalysis consumedClassDatumAnalysis = headNode.getClassDatumAnalysis();
//		if ("EObject".equals(consumedClassDatumAnalysis.getCompleteClass().getName())) {
//			System.out.println("Got it");
//		}
		List<Node> nodes = consumedClassDatumAnalysis2headNodes.get(consumedClassDatumAnalysis);
		if (nodes == null) {
			nodes = new ArrayList<Node>();
			consumedClassDatumAnalysis2headNodes.put(consumedClassDatumAnalysis, nodes);
		}
		if (!nodes.contains(headNode)) {
			nodes.add(headNode);
		}
	}

//	@Override
	public void addConnection(@NonNull Connection connection) {
		assert !connections.contains(connection);
//		for (Connection oldConnection : connections) {
//			if (oldConnection.getConnectionRole() == connection.getConnectionRole()) {
//				assert (edge.getSource() != oldConnection.getSource()) || (edge.getTarget() != oldConnection.getTarget());
//			}
//		}
		connections.add(connection);
	}

	private void addIntroducedNode(@NonNull Node introducedNode) {
		ClassDatumAnalysis classDatumAnalysis = getElementalClassDatumAnalysis(introducedNode);
		List<Node> nodes = introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);
		if (nodes == null) {
			nodes = new ArrayList<Node>();
			introducedClassDatumAnalysis2nodes.put(classDatumAnalysis, nodes);
		}
		nodes.add(introducedNode);
	}

	private void addProducedEdge(@NonNull NavigationEdge producedEdge) {
		PropertyDatum propertyDatum = getPropertyDatum(producedEdge);
		if (propertyDatum == null) {
			propertyDatum = getPropertyDatum(producedEdge);		// FIXME debugging
		}
		assert propertyDatum != null;
		addProducedEdge(producedEdge, propertyDatum);
	}
	private void addProducedEdge(@NonNull NavigationEdge producedEdge, @NonNull PropertyDatum propertyDatum) {
		List<NavigationEdge> edges = producedPropertyDatum2realizedEdges.get(propertyDatum);
		if (edges == null) {
			edges = new ArrayList<NavigationEdge>();
			producedPropertyDatum2realizedEdges.put(propertyDatum, edges);
		}
		assert !edges.contains(producedEdge);
		edges.add(producedEdge);
		for (AbstractDatum superAbstractDatum : propertyDatum.getSuper()) {
			if (superAbstractDatum instanceof PropertyDatum) {
				addProducedEdge(producedEdge, (PropertyDatum) superAbstractDatum);
			}
		}
	}

	private void addProducedNode(@NonNull Node producedNode) {
		ClassDatumAnalysis classDatumAnalysis = getElementalClassDatumAnalysis(producedNode);
		for (ClassDatumAnalysis superClassDatumAnalysis : classDatumAnalysis.getSuperClassDatumAnalyses()) {
			List<Node> nodes = producedClassDatumAnalysis2realizedNodes.get(superClassDatumAnalysis);
			if (nodes == null) {
				nodes = new ArrayList<Node>();
				producedClassDatumAnalysis2realizedNodes.put(superClassDatumAnalysis, nodes);
			}
			nodes.add(producedNode);
		}
	}

	public void addRegion(@NonNull Region region) {
		assert !regions.contains(region);
		if (regions.add(region)) {
			region.setInvokingRegion(this);
//			allMappingRegions.addAll(nestedRegion.getAllMappingRegions());
		}
	}
	
/*	private void assignDepths() {
		Map<Region, Integer> region2depth = new HashMap<Region, Integer>();
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

	/**
	 * Identify all the classes whose instances may be required as independent mapping inputs.
	 */
	private void computeConsumedConsumedClassDatumAnalysis2headNodes() {
		//
		//	Single-node head groups contribute a corresponding consumed class provided the
		//	class is part of the input model and is not an internal convenience.
		//
		for (@SuppressWarnings("null")@NonNull Region region : getRegions()) {
			for (Node predicatedNode : region.getMatchableNodes()) {
				if (!predicatedNode.isHead()) {
					if (!predicatedNode.isLoaded() && !predicatedNode.isConstant() && !predicatedNode.isInternal()) {
						if (!isOnlyCastOrRecursed(predicatedNode)) {			// FIXME Eliminate cast nodes
							addConsumedNode(predicatedNode);
						}
					}
				}
			}
			for (List<Node> headNodes : region.getHeadNodeGroups()) {
				if (headNodes.size() == 1) {
					Node headNode = headNodes.get(0);
//					if (headNode.isKnown() && !headNode.isInternal()) {
					if (headNode.isLoaded() && !headNode.isInternal()) {
						addConsumedNode(headNode);
					}
				}
			}
		}
		//
		//	Multiple-node head groups contribute similarly, but just one corresponding class,
		//	preferably one that is already consumed.
		//
		for (@SuppressWarnings("null")@NonNull Region region : getRegions()) {
			for (List<Node> headNodes : region.getHeadNodeGroups()) {
				if (headNodes.size() != 1) {
					boolean gotOne = false;
					for (Node headNode : headNodes) {
						if (!headNode.isKnown()) {
							gotOne = true;
							break;
						}
						else {
							ClassDatumAnalysis consumedClassDatumAnalysis = headNode.getClassDatumAnalysis();
							if (consumedClassDatumAnalysis2headNodes.containsKey(consumedClassDatumAnalysis)) {
								gotOne = true;
								break;
							}
						}
					}
					if (!gotOne) {
						Node bestHeadNode = selectBestHeadNode(headNodes);
						addConsumedNode(bestHeadNode);
					}
				}
			}
		}
	}

	/**
	 * Identify all the containment relationships in the input models.
	 */
	private void computeContainedClassDatumAnalysis2compositeProperties() {
		Map<org.eclipse.ocl.pivot.Package, DomainUsage> allPackagesSet = new HashMap<org.eclipse.ocl.pivot.Package, DomainUsage>();
		List<org.eclipse.ocl.pivot.Package> allPackagesList = new ArrayList<org.eclipse.ocl.pivot.Package>();
		for (@SuppressWarnings("null")@NonNull Model asModel : inputModels.keySet()) {
			DomainUsage domainUsage = inputModels.get(asModel);
			for (@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package asPackage : asModel.getOwnedPackages()) {
				if (allPackagesSet.put(asPackage, domainUsage) == null) {
					allPackagesList.add(asPackage);
				}
			}
			for (@SuppressWarnings("null")@NonNull Import asImport : asModel.getOwnedImports()) {
				EObject importedObject = asImport.getImportedNamespace();
				while ((importedObject != null) && !(importedObject instanceof org.eclipse.ocl.pivot.Package)) {
					importedObject = importedObject.eContainer();
				}
				if (importedObject instanceof org.eclipse.ocl.pivot.Package) {
					org.eclipse.ocl.pivot.Package asPackage = (org.eclipse.ocl.pivot.Package)importedObject;
					if (allPackagesSet.put(asPackage, domainUsage) == null) {
						allPackagesList.add(asPackage);
					}
				}
			}
		}
		for (int i = 0; i < allPackagesList.size(); i++) {
			org.eclipse.ocl.pivot.Package asPackage = allPackagesList.get(i);
			DomainUsage domainUsage = ClassUtil.nonNullState(allPackagesSet.get(asPackage));
			for (@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package asPackage2 : asPackage.getOwnedPackages()) {
				if (allPackagesSet.put(asPackage2, domainUsage) == null) {
					allPackagesList.add(asPackage2);
				}
			}
			for (@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Class asClass : asPackage.getOwnedClasses()) {
				for (@SuppressWarnings("null")@NonNull Property asProperty : asClass.getOwnedProperties()) {
					if (asProperty.isIsComposite()) {
						computeContainedClassDatumAnalysis2compositeProperties3(asProperty, domainUsage);
					}
					Type asType = asProperty.getType();
					if (asType instanceof org.eclipse.ocl.pivot.Class) {
						org.eclipse.ocl.pivot.Package asPackage2 = ((org.eclipse.ocl.pivot.Class)asType).getOwningPackage();
						if (allPackagesSet.put(asPackage2,  domainUsage) == null) {
							allPackagesList.add(asPackage2);
						}
					}
				}
			}
		}
		assert allPackagesSet.size() == allPackagesList.size();
		assert allPackagesSet.keySet().equals(new HashSet<org.eclipse.ocl.pivot.Package>(allPackagesList));
	}

	private void computeContainedClassDatumAnalysis2compositeProperties3(@NonNull Property asProperty, @NonNull DomainUsage domainUsage) {
		Type asType = QVTbaseUtil.getElementalType(ClassUtil.nonNullState(asProperty.getType()));
		if (asType instanceof org.eclipse.ocl.pivot.Class) {
			ClassDatumAnalysis classDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis((Class) asType, ClassUtil.nonNullState(domainUsage.getTypedModel()));
			Set<Property> compositeProperties = containedClassDatumAnalysis2compositeProperties.get(classDatumAnalysis);
			if (compositeProperties == null) {
				compositeProperties = new HashSet<Property>();
				containedClassDatumAnalysis2compositeProperties.put(classDatumAnalysis, compositeProperties);
			}
			compositeProperties.add(asProperty);
		}
	}

	/**
	 * Identify all the classes/superClasses/subClasses that each compositeProperty may introduce for use as mapping heads. We do not
	 * need to worry about arbitrary user extensions since the introducer will introduce such an extension as one or more of the types
	 * that are actually interesting as inputs.
	 * 
	 * NB. A mapping expecting an instance of K is statically applicable for any instance of a class derived from K,
	 * and dynamically applicable for any instance of K masquerading as one of its super Class.
	 */
	private void computeConsumedCompositeProperty2introducedClassDatumAnalyses() {
		//
		//	Find the composite properties for each consumed class and its super classes, and accumulate
		//	the container classes of all used properties as additional consumed classes.
		//
		Set<ClassDatumAnalysis> allConsumedClassDatumAnalyses = new HashSet<ClassDatumAnalysis>(consumedClassDatumAnalysis2headNodes.keySet());
		List<ClassDatumAnalysis> allConsumedClassDatumAnalysesList = new ArrayList<ClassDatumAnalysis>(allConsumedClassDatumAnalyses);
		for (int i = 0; i < allConsumedClassDatumAnalysesList.size(); i++) {
			ClassDatumAnalysis consumedClassDatumAnalysis = allConsumedClassDatumAnalysesList.get(i);
			for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis consumedSuperClassDatumAnalysis : consumedClassDatumAnalysis.getSuperClassDatumAnalyses()) {
				Set<Property> consumedCompositeProperties = containedClassDatumAnalysis2compositeProperties.get(consumedSuperClassDatumAnalysis);
				if (consumedCompositeProperties != null) {
					for (Property consumedCompositeProperty : consumedCompositeProperties) {
	//					Set<Property> consumedCompositeProperties = consumedClassDatumAnalysis2compositionProperties.get(consumedClassDatumAnalysis);
	//					if (consumedCompositeProperties == null) {
	//						consumedCompositeProperties = new HashSet<Property>();
	//						consumedClassDatumAnalysis2compositionProperties.put(consumedClassDatumAnalysis, consumedCompositeProperties);
	//					}
	//					consumedCompositeProperties.add(compositeProperty);
						Set<ClassDatumAnalysis> introducedClassDatumAnalyses = consumedCompositeProperty2introducedClassDatumAnalyses.get(consumedCompositeProperty);
						if (introducedClassDatumAnalyses == null) {
							introducedClassDatumAnalyses = new HashSet<ClassDatumAnalysis>();
							consumedCompositeProperty2introducedClassDatumAnalyses.put(consumedCompositeProperty, introducedClassDatumAnalyses);
						}
						introducedClassDatumAnalyses.add(consumedClassDatumAnalysis);
						org.eclipse.ocl.pivot.Class containerClass = consumedCompositeProperty.getOwningClass();
						assert containerClass != null;
						ClassDatumAnalysis containerSuperClassDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(containerClass, consumedClassDatumAnalysis.getTypedModel());
						if (allConsumedClassDatumAnalyses.add(containerSuperClassDatumAnalysis)) {
							allConsumedClassDatumAnalysesList.add(containerSuperClassDatumAnalysis);
						}
					}
				}
			}
		}
		assert allConsumedClassDatumAnalyses.size() == allConsumedClassDatumAnalysesList.size();
	}
	
	private void computeInputModels() {
		for (ClassDatumAnalysis classDatumAnalysis : getSchedulerConstants().getClassDatumAnalyses()) {
			DomainUsage domainUsage = classDatumAnalysis.getDomainUsage();
			if (domainUsage.isCheckable() && !domainUsage.isEnforceable()) {
				Type type = classDatumAnalysis.getClassDatum().getType();
				org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(type);
				if ((asPackage != null) && !PivotConstants.ORPHANAGE_URI.equals(asPackage.getURI())) {
					Model model = PivotUtil.getContainingModel(type);
					if (model != null) {
						inputModels.put(model, domainUsage);
					}
				}
			}
		}
	}

/*	private void computeProperty2introducedClasses() {
		//
		//	Find the composite properties for each consumed class and its super classes, and accumulate
		//	the container classes of all used properties as additional consumed classes.
		//
		Set<ClassDatumAnalysis> allConsumedClassDatumAnalyses = new HashSet<ClassDatumAnalysis>(consumedClassDatumAnalysis2headNodes.keySet());
		List<ClassDatumAnalysis> allConsumedClassDatumAnalysesList = new ArrayList<ClassDatumAnalysis>(allConsumedClassDatumAnalyses);
		for (int i = 0; i < allConsumedClassDatumAnalysesList.size(); i++) {
			ClassDatumAnalysis consumedClassDatumAnalysis = allConsumedClassDatumAnalysesList.get(i);
			for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis consumedSuperClassDatumAnalysis : consumedClassDatumAnalysis.getSuperClassDatumAnalyses()) {
				Set<Property> compositeProperties = containedClassDatumAnalysisClosure2compositeProperties.get(consumedSuperClassDatumAnalysis);
				if (compositeProperties != null) {
					for (Property compositeProperty : compositeProperties) {
						Set<Property> consumedCompositeProperties = consumedClassDatumAnalysis2compositionProperties.get(consumedClassDatumAnalysis);
						if (consumedCompositeProperties == null) {
							consumedCompositeProperties = new HashSet<Property>();
							consumedClassDatumAnalysis2compositionProperties.put(consumedClassDatumAnalysis, consumedCompositeProperties);
						}
						consumedCompositeProperties.add(compositeProperty);
						Set<ClassDatumAnalysis> introducedClassDatumAnalyses = consumedCompositeProperty2introducedClassDatumAnalyses.get(compositeProperty);
						if (introducedClassDatumAnalyses == null) {
							introducedClassDatumAnalyses = new HashSet<ClassDatumAnalysis>();
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
							introducedClassDatumAnalyses = new HashSet<ClassDatumAnalysis>();
							consumedCompositeProperty2introducedClassDatumAnalyses.put(compositeProperty, introducedClassDatumAnalyses);
						}
						introducedClassDatumAnalyses.add(superClassDatumAnalysis);
					}
				}
			}
		}
	} */

	/**
	 * Identify all the classes that are produced by mappings.
	 */
	private void computeProducedClassDatumAnalysis2realizedNodes() {
		//
		//	Single-node head groups contribute a corresponding consumed class provided the
		//	class is part of the input model and is not an internal convenience.
		//
		for (@SuppressWarnings("null")@NonNull Region region : getRegions()) {
			for (Node assignedNode : region.getAssignedNodes()) {
				if (assignedNode.isClassNode()) {
					addProducedNode(assignedNode);
				}
			}
			for (@SuppressWarnings("null")@NonNull NavigationEdge realizedNavigationEdge : region.getRealizedNavigationEdges()) {
				addProducedEdge(realizedNavigationEdge);
			}
		}
	}

	/**
	 * Where multiple child consumers are ordered, redirect the later consumers to use the
	 * preceding consumer making all the state of the preceding consumers available for re-use.
	 *
	@SuppressWarnings("unused")
	private void convertConsumedOrdering(@NonNull Region commonRegion, @NonNull Map<Edge, Set<Edge>> orderingEdge2usedEdges) {
		for (Node node : commonRegion.getNodes()) {
			Iterable<Node> passedBindingTargets = node.getPassedBindingTargets();
			if (Iterables.size(passedBindingTargets) > 0) {
				Iterable<Node> sortedCalledNodes = AbstractNode.getSortedTargets(passedBindingTargets);
				Set<Node> availableSources = new HashSet<Node>();
				Set<Node> oldConnections = null;
				Node sourceNode = node;
				availableSources.add(sourceNode);
				for (Node calledNode : sortedCalledNodes) {
					Edge callingEdge = calledNode.getPassedBindingEdge();
					assert callingEdge != null;
					Node oldSource = callingEdge.getSource();
					if (oldSource.isConnection()) {
						if (oldConnections == null) {
							oldConnections = new HashSet<Node>();
						}
						oldConnections.add(oldSource);
					}
					Set<Node> requiredSources = new HashSet<Node>();
					for (Node requiredSource : calledNode.getPassedBindingSources()) {
						requiredSources.add(requiredSource);
					}
					requiredSources.removeAll(availableSources);
					requiredSources.add(sourceNode);
					Node sourceOrConnectionNode = getSourceOrConnectionNode(requiredSources, sourceNode.getClassDatumAnalysis());
					if (oldSource != sourceOrConnectionNode) {
						callingEdge.setSource(sourceOrConnectionNode);
					}
					availableSources.addAll(requiredSources);
					sourceNode = calledNode;
				}
				if (oldConnections != null) {
					for (Node oldConnection : oldConnections) {
						if (oldConnection.getOutgoingEdges().size() <= 0) {
							oldConnection.destroy();
						}
					}
				}
			}
		}
	} */

	/**
	 * Create the Passed Binding edges and join nodes between all introducers and their corresponding consuming heads. 
	 */
	private void createBindings() {
		for (Region region : getCallableRegions()) {
			if (region instanceof RootRegion) {
				continue;
			}
			//
			//	Single-node head groups contribute a corresponding consumed class provided the
			//	class is part of the input model and is not an internal convenience.
			//
			for (List<Node> headNodes : region.getHeadNodeGroups()) {
				Node headNode;
				if (headNodes.size() == 1) {
					headNode = headNodes.get(0);
				}
				else {
					headNode = selectBestHeadNode(headNodes);
				}
				if (/*headNode.isLoaded() &&*/ !headNode.isInternal()) {
					createBinding(headNode);
				}
			}
			//
			//	Bind the non-navigable predicated nodes too
			//
			for (NavigationEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
				Node predicatedNode = predicatedEdge.getTarget();
				if (predicatedEdge.isNavigation() && !predicatedEdge.isCast()) {			// FIXME isCast does not need to be isNavigation now that it can be isNavigable
					PropertyDatum propertyDatum = getPropertyDatum(predicatedEdge);
					List<NavigationEdge> realizedEdges = producedPropertyDatum2realizedEdges.get(propertyDatum);
					if (realizedEdges != null) {
						Property predicatedProperty = predicatedEdge.getProperty();
						List<Node> realizingNodes = new ArrayList<Node>();
						for (NavigationEdge realizedEdge : realizedEdges) {
							Node realizedNode;
							if (realizedEdge.getProperty() == predicatedProperty) {
								realizedNode = realizedEdge.getTarget();
							}
							else {
								assert realizedEdge.getProperty() == predicatedProperty.getOpposite();
								realizedNode = realizedEdge.getSource();
							}
							if (!realizingNodes.contains(realizedNode)) {
								realizingNodes.add(realizedNode);
							}
						}
						boolean isCast = false;
						boolean isOther = false;
						boolean isRecursion = false;
						for (Edge outgoingEdge : predicatedNode.getOutgoingEdges()) {
							if (outgoingEdge.isCast()) {
								isCast = true;
								Node castNode = outgoingEdge.getTarget();
								assert !castNode.isConstant();
								assert !castNode.isLoaded();
								Connection predicatedConnection = getConnection(realizingNodes, castNode.getClassDatumAnalysis());
								if (!Iterables.contains(predicatedConnection.getTargets(), castNode)) {
									predicatedConnection.addUsedTargetNode(castNode, false);
								}
							}
							else if (outgoingEdge.isRecursion()) {
								isRecursion = true;
							}
							else {
								isOther = true;
							}
						}
						if (isOther || !(isCast || isRecursion)) {
	//						Iterable<Connection> passedConnections = predicatedNode.getIncomingPassedConnections();
	//						Connection usedConnection = predicatedNode.getIncomingUsedConnection();
	//						boolean isNew = (usedConnection == null) && Iterables.isEmpty(passedConnections);
	//						if (!isNew) {		// FIXME could be multiple
	//							isNew = (usedConnection == null) && Iterables.isEmpty(passedConnections);
	//						}		// FIXME could be multiple
							Connection predicatedConnection = getConnection(realizingNodes, predicatedNode.getClassDatumAnalysis());
							if (!Iterables.contains(predicatedConnection.getTargets(), predicatedNode)) {
								predicatedConnection.addUsedTargetNode(predicatedNode, false);
							}
						}
					}
				}
//				if (!predicatedNode.isLoaded() && !predicatedNode.isConstant() && !isOnlyCastOrRecursed(predicatedNode)) {
//				}
			}
		}
	}
	private void createBinding(@NonNull Node headNode) {
		List<Node> sourceNodes = null;
		ClassDatumAnalysis classDatumAnalysis = headNode.getClassDatumAnalysis();
		//
		//	Locate viable introducers
		//
		Iterable<Node> recursionSources = headNode.getRecursionSources();
		List<Node> introducingNodes = getIntroducingNodes(classDatumAnalysis);
		if (introducingNodes != null) {
			for (@SuppressWarnings("null")@NonNull Node introducingNode : introducingNodes) {
				if (isConflictFree(headNode, introducingNode, new HashMap<Node, Node>()) && !Iterables.contains(recursionSources, introducingNode)) {
					if (sourceNodes == null) {
						sourceNodes = new ArrayList<Node>();
					}
					sourceNodes.add(introducingNode);
				}
			}
		}
		//
		//	Locate viable producers
		//
		List<Node> producingNodes = getProducingNodes(classDatumAnalysis);
		if (producingNodes != null) {
			for (@SuppressWarnings("null")@NonNull Node producingNode : producingNodes) {
				if (isConflictFree(headNode, producingNode, new HashMap<Node, Node>())) {
					if (sourceNodes == null) {
						sourceNodes = new ArrayList<Node>();
					}
					sourceNodes.add(producingNode);
				}
			}
		}
		if (sourceNodes != null) {
			//
			//	Connection up the head
			//
			Connection headConnection = getConnection(sourceNodes, headNode.getClassDatumAnalysis());
			if (headNode.getNodeRole().isExtraGuardVariable()) {
				headConnection.addUsedTargetNode(headNode, false);
			}
			else {
				headConnection.addPassedTargetNode(headNode);
			}
			//
			//	Locate the corresponding sources for each guard in each calling region. 
			//
			HashMap<Node, List<Node>> predicated2availableSources = new HashMap<Node, List<Node>>();
			HashMap<Node, List<Region>> predicated2missingSources = new HashMap<Node, List<Region>>();
			for (Node sourceNode : sourceNodes) {
				Region headRegion = headNode.getRegion();
				if ((headRegion != sourceNode.getRegion()) && !(headRegion instanceof CompositionRegion)) {
					HashMap<Node, Node> predicated2source = new HashMap<Node, Node>();
					createUsedBindings(headNode, sourceNode, predicated2source);
					for (Map.Entry<Node, Node> entry : predicated2source.entrySet()) {
						@SuppressWarnings("null")@NonNull Node calledNode = entry.getKey();
						if (!calledNode.isHead()) {
							Node callingNode = entry.getValue();
							if (callingNode != null) {
								List<Node> availableSources = predicated2availableSources.get(calledNode);
								if (availableSources == null) {
									availableSources = new ArrayList<Node>();
									predicated2availableSources.put(calledNode, availableSources);
								}
								availableSources.add(callingNode);
							}
							else {
								List<Region> missingSources = predicated2missingSources.get(calledNode);
								if (missingSources == null) {
									missingSources = new ArrayList<Region>();
									predicated2missingSources.put(calledNode, missingSources);
								}
								missingSources.add(sourceNode.getRegion());
							}
						}
					}
				}
			}
			//
			//	Connection the available calling sources to their called guards.
			//
			for (Map.Entry<Node, List<Node>> entry : predicated2availableSources.entrySet()) {
				@SuppressWarnings("null")@NonNull Node calledNode = entry.getKey();
				if (!calledNode.isLoaded() && !calledNode.isConstant()) {
					@SuppressWarnings("null")@NonNull List<Node> availableNodes = entry.getValue();
					Connection guardConnection = getConnection(availableNodes, calledNode.getClassDatumAnalysis());
					guardConnection.addUsedTargetNode(calledNode, false);
				}
			}
			for (Map.Entry<Node, List<Region>> entry : predicated2missingSources.entrySet()) {
				@SuppressWarnings("null")@NonNull Node calledNode = entry.getKey();
//				@SuppressWarnings("null")@NonNull List<Region> missingRegions = entry.getValue();
//				for (Region missingRegion : missingRegions) {
					ClassDatumAnalysis classDatumAnalysis2 = calledNode.getClassDatumAnalysis();
					List<Node> missingSourceNodes = new ArrayList<Node>();
					List<Node> introducedNodes = getIntroducingNodes(classDatumAnalysis2);
					if (introducedNodes != null) {
						missingSourceNodes.addAll(introducedNodes);
					}
					List<Node> producedNodes = getProducingNodes(classDatumAnalysis2);
					if (producedNodes != null) {
						missingSourceNodes.addAll(producedNodes);
					}
					for (int i = missingSourceNodes.size(); --i >= 0; ) {
						Node missingSourceNode = missingSourceNodes.get(i);
						if (missingSourceNode.getRegion() == calledNode.getRegion()) {
							missingSourceNodes.remove(i);		// FIXME only if a Recursion Edge
						}
					}
					if ((missingSourceNodes.size() > 0) && !calledNode.isLoaded()) {
						Connection missingConnection = getConnection(missingSourceNodes, calledNode.getClassDatumAnalysis());
						missingConnection.addUsedTargetNode(calledNode, false);
					}
//				}
			}
			// FIXME guard2missingSources
		}
	}

	/**
	 * Create a ContainmentRegion for each in-use composition property with a head consuming node to consume the containing class
	 * and an introduced node for each class by which the composed instances are consumed. 
	 */
	private @NonNull List<Region> createContainmentRegions() {
		List<Region> containmentRegions = new ArrayList<Region>();
		for (Entry<Property, Set<ClassDatumAnalysis>> entry : consumedCompositeProperty2introducedClassDatumAnalyses.entrySet()) {
			@SuppressWarnings("null")@NonNull Property parent2childrenProperty = entry.getKey();
			TypedModel typedModel = entry.getValue().iterator().next().getTypedModel();
			CompositionRegion containmentRegion = new CompositionRegion(superRegion, parent2childrenProperty, typedModel);
			Node headNode = containmentRegion.getComposingNode();
			CompleteClass parentClass = headNode.getCompleteClass();
			addConsumedNode(headNode);
			for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis classDatumAnalysis : entry.getValue()) {
				Node introducedNode = containmentRegion.addClassDatumAnalysis(classDatumAnalysis);
				addIntroducedNode(introducedNode);
				CompleteClass childClass = introducedNode.getCompleteClass();
				Type childType = childClass.getPrimaryClass();
				if (childType instanceof CollectionType) {
					@SuppressWarnings("null")@NonNull Type elementType = ((CollectionType)childType).getElementType();
					childClass = getSchedulerConstants().getEnvironmentFactory().getCompleteModel().getCompleteClass(elementType);
				}
				if (childClass.conformsTo(parentClass)) {
					Edges.PRIMARY_RECURSION.createEdge(containmentRegion, introducedNode, headNode);
				}
			}
			containmentRegions.add(containmentRegion);
			getSchedulerConstants().writeDOTfile(containmentRegion, "-3-contained");
			getSchedulerConstants().writeGraphMLfile(containmentRegion, "-3-contained");
			addRegion(containmentRegion);
		}
		return containmentRegions;
	}

	/**
	 * Create the Used Binding edges and join nodes between all introducers and their corresponding non-head guards.
	 *
	private void createNonHeadUsedBindings() {
		for (Region region : getRegions()) {
			for (Node predicatedNode : region.getMatchableNodes()) {
				if (/*!predicatedNode.isHead() &&* / predicatedNode.isClassNode()) {
					if (/*!predicatedNode.isLoaded() &&* / !predicatedNode.isHead() && !predicatedNode.isInternal() && (predicatedNode == predicatedNode.getCastEquivalentNode())) {
//						predicatedNode = predicatedNode.getCastEquivalentNode();
						createNonHeadUsedBinding(predicatedNode);
					}
				}
			}
		}
	} */
	/**
	 * Create the bindings and if necessary a join node to ensure that all sources of consumingNode's
	 * ClassDatum are passed to consumingNode using a bindingFactory edge.
	 *
	private void createNonHeadUsedBinding(@NonNull Node guardNode) {
		List<Node> sourceNodes = null;
		ClassDatumAnalysis classDatumAnalysis = guardNode.getClassDatumAnalysis();
		//
		//	Locate viable introducers
		//
		List<Node> introducingNodes = introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);
		if (introducingNodes != null) {
			for (Node introducingNode : introducingNodes) {
				if (introducingNode.getRegion().isConflictFree(introducingNode, guardNode)) {
					if (sourceNodes == null) {
						sourceNodes = new ArrayList<Node>();
					}
					sourceNodes.add(introducingNode);
				}
			}
		}
		//
		//	Locate viable producers
		//
		List<Node> producingNodes = producedClassDatumAnalysis2realizedNodes.get(classDatumAnalysis);
		if (producingNodes != null) {
			for (Node producingNode : producingNodes) {
				if (producingNode.getRegion().isConflictFree(producingNode, guardNode)) {
					if (sourceNodes == null) {
						sourceNodes = new ArrayList<Node>();
					}
					sourceNodes.add(producingNode);
				}
			}
		}
		//
		//	Connection them up
		//
		ClassDatumAnalysis classDatumAnalysis = guardNode.getClassDatumAnalysis();
		List<Node> introducedNodes = introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);
		List<Node> producedNodes = producedClassDatumAnalysis2realizedNodes.get(classDatumAnalysis);
		int size = (introducedNodes != null ? introducedNodes.size() : 0) + (producedNodes != null ? producedNodes.size() : 0);
		if (size <= 1) {
			if (introducedNodes != null) {
				for (@SuppressWarnings("null")@NonNull Node introducedNode : introducedNodes) {
					Edges.USED_BINDING.createEdge(this, introducedNode, null, guardNode);
				}
			}
			if (producedNodes != null) {
				for (@SuppressWarnings("null")@NonNull Node producedNode : producedNodes) {
					Edges.USED_BINDING.createEdge(this, producedNode, null, guardNode);
				}
			}
		}
		else {
			Node joinNode = classDatumAnalysis2joinNodes.get(classDatumAnalysis);
			if (joinNode == null) {
				joinNode = Nodes.JOIN.createNode(this, "-join-", classDatumAnalysis);
				classDatumAnalysis2joinNodes.put(classDatumAnalysis, joinNode);
				if (introducedNodes != null) {
					for (@SuppressWarnings("null")@NonNull Node introducedNode : introducedNodes) {
						Edges.PASSED_BINDING.createEdge(this, introducedNode, null, joinNode);
					}
				}
				if (producedNodes != null) {
					for (@SuppressWarnings("null")@NonNull Node producedNode : producedNodes) {
						Edges.PASSED_BINDING.createEdge(this, producedNode, null, joinNode);
					}
				}
			}
			Edges.USED_BINDING.createEdge(this, joinNode, null, guardNode);
		}
	} */

	/**
	 * Create a RootContainmentRegion that introduces model elements directly from the input model root, or from
	 * composition relationships that form part of an extended metamodel that is not known until run-time.
	 */
	private @NonNull RootRegion createRootContainmentRegion() {
		RootRegion rootContainmentRegion = new RootRegion(superRegion);
/*		Set<ClassDatumAnalysis> rootClassDatumAnalyses = new HashSet<ClassDatumAnalysis>();
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
		Set<ClassDatumAnalysis> consumedClassDatumAnalyses = consumedClassDatumAnalysis2headNodes.keySet();		// FIXME all consumed classes
		for (@SuppressWarnings("null")@NonNull ClassDatumAnalysis consumedClassDatumAnalysis : consumedClassDatumAnalyses) {
//			System.out.println("ScheduledRegion.createRootContainmentRegion: " + consumedClassDatumAnalysis);
			boolean canBeAtRoot = !consumedClassDatumAnalysis.getDomainUsage().isEnforceable();
			if (consumedClassDatumAnalysis.getClassDatum().getType() instanceof DataType) {
				canBeAtRoot = false;
			}
			else {
				Set<Property> containments = containedClassDatumAnalysis2compositeProperties.get(consumedClassDatumAnalysis);
				if (containments != null) {
					Set<Property> containments2 = new HashSet<Property>();		// FIXME omits independent containers
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
		}
		getSchedulerConstants().writeDOTfile(rootContainmentRegion, "");
		return rootContainmentRegion;
	}

	public void createSchedule() {
		//
		//	Identify the input models.
		//
		computeInputModels();
		if (Scheduler.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.isActive()) {
			Scheduler.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.println(dumpInputModels().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify all the containment relationships in the input models.
		//
		computeContainedClassDatumAnalysis2compositeProperties();
		if (Scheduler.DUMP_CLASS_TO_CONTAINING_PROPERTIES.isActive()) {
			Scheduler.DUMP_CLASS_TO_CONTAINING_PROPERTIES.println(dumpClass2ContainingProperties().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify all classes that are produced by mappings.
		//
		computeProducedClassDatumAnalysis2realizedNodes();
		if (Scheduler.DUMP_CLASS_TO_REALIZED_NODES.isActive()) {
			Scheduler.DUMP_CLASS_TO_REALIZED_NODES.println(dumpClass2ProducingNode().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify all classes that are consumed as independent inputs of mappings.
		//
		computeConsumedConsumedClassDatumAnalysis2headNodes();
		if (Scheduler.DUMP_CLASS_TO_CONSUMING_NODES.isActive()) {
			Scheduler.DUMP_CLASS_TO_CONSUMING_NODES.println(dumpClass2consumingNode().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify all classes that are transitively consumed as containers of consumed classes.
		//
		computeConsumedCompositeProperty2introducedClassDatumAnalyses();
		if (Scheduler.DUMP_PROPERTY_TO_CONSUMING_CLASSES.isActive()) {
			Scheduler.DUMP_PROPERTY_TO_CONSUMING_CLASSES.println(dumpClass2ConsumingProperty().reduce("", stringJoin("\n\t")));
		}
		//
		//	Create containment regions to traverse all in-use compositions to introduce all consumed classes.
		//
		@SuppressWarnings("unused")
		List<Region> containmentRegions = createContainmentRegions();
		//
		//	Create the root containment region to introduce all root and otherwise contained consumed classes.
		//
		@SuppressWarnings("unused")
		RootRegion rootContainmentRegion = createRootContainmentRegion();
		//
		// Grab all the easy single-headed regions as a first pass
		//
//		Region firstPassRegion = encapsulateFirstPass(rootContainmentRegion, containmentRegions);
		//
		//	Bind each head node to the viable introducer/producer of its type.
		//
		createBindings();
//		for (Map<Set<Node>, Connection> connections : classDatumAnalysis2nodes2connections.values()) {
//			for (@SuppressWarnings("null")@NonNull Connection connectionRegion : connections.values()) {
//				addRegion(connectionRegion);
//			}
//		}
		//
		//	Bind each remaining guard node to the viable introducer/producer of its type.
		//
//		createNonHeadUsedBindings();
//
		getSchedulerConstants().writeDOTfile(this, "-4-bindings");
		getSchedulerConstants().writeGraphMLfile(this, "-4-bindings");
		getSchedulerConstants().writeRegionDOTfile(this, "-4r-bindings");
		getSchedulerConstants().writeRegionGraphMLfile(this, "-4r-bindings");
		//
		//	Accumulate ordering dependencies at the common region.
		//
		Region2Depth region2depth = new Region2Depth();
		regionOrderer = new RegionOrdering(region2depth, getRegions());
		List<Schedulable> schedulableOrdering = regionOrderer.computeOrdering();
		getSchedulerConstants().writeRegionDOTfile(this, "-5r-indexed");
		getSchedulerConstants().writeRegionGraphMLfile(this, "-5r-indexed");
		getSchedulerConstants().writeCallDOTfile(this, "-5c-indexed");
		getSchedulerConstants().writeCallGraphMLfile(this, "-5c-indexed");
//		Region2Index region2order = new Region2Index();
		
		
//		region2order.computeRegionIndexes(getCallableRegions());
//		Iterable<Region> sortedCallableRegions = regionOrdering;//AbstractRegion.EarliestRegionComparator.sort(getCallableRegions());
		//
		//	Index all predicated and realized edges by typed model and property.
		//
		Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2predicatedEdges = new HashMap<TypedModel, Map<Property, List<NavigationEdge>>>();
		Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2realizedEdges = new HashMap<TypedModel, Map<Property, List<NavigationEdge>>>();
		for (@SuppressWarnings("null")@NonNull Schedulable schedulable : schedulableOrdering) {
			if (schedulable instanceof Region) {
				Region region = (Region) schedulable;
				QVTs2QVTiVisitor.POLLED_PROPERTIES.println("building indexes for " + region + " " + region.getEarliestIndex() + ".." + region.getLatestIndex());
				region.buildPredicatedNavigationEdgesIndex(typedModel2property2predicatedEdges);
				region.buildRealizedNavigationEdgesIndex(typedModel2property2realizedEdges);
			}
		}
		for (@SuppressWarnings("null")@NonNull Schedulable schedulable : schedulableOrdering) {
			if (schedulable instanceof Region) {
				Region region = (Region) schedulable;
				region.computeCheckedOrEnforcedEdges(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
			}
		}
		/*	suspended - just an optimization - needs more hierarchical consideration
		//
		//	Redirect ordered consumers to depend on each other's heads thereby respecting the ordering and
		//	making earlier results available to later mappings.
		//	
		if (region2orderingEdge2usedEdges != null) {
			for (@SuppressWarnings("null")@NonNull Region commonRegion : region2orderingEdge2usedEdges.keySet()) {
				@SuppressWarnings("null")@NonNull Map<Edge, Set<Edge>> orderingEdge2usedEdges = region2orderingEdge2usedEdges.get(commonRegion);
				convertConsumedOrdering(commonRegion, orderingEdge2usedEdges);
			}
		}
		writeDOTfile("-5-reconsume");
		writeGraphMLfile("-5-reconsume"); */
		/*	suspended - just an optimization - needs more hierarchical consideration
		//
		//	Merge again now that dependencies may be available.
		//
		Region2Depth region2depths = new Region2Depth();
		List<Region> sortedRegions = region2depths.getSortedRegions(getRegions());
		for (Region calledRegion : sortedRegions) {
			List<List<Node>> headNodeGroups = calledRegion.getHeadNodeGroups();
			if ((headNodeGroups.size() == 1) && !(calledRegion instanceof CompositionRegion)) {
				Region callingRegion = null;
				boolean isMergeable = true;
				for (Node headNode : headNodeGroups.get(0)) {
					for (Node callingNode : headNode.getPassedBindingSources()) {
						if (callingRegion == null) {
							callingRegion = callingNode.getRegion();
						}
						else if (callingRegion != callingNode.getRegion()) {
							isMergeable = false;
							break;
						}
					}
				}
				if ((callingRegion != null) && isMergeable && callingRegion.isLateMergeable(calledRegion, region2depths)) {
					Map<Node, Node> node2mergedNode = callingRegion.canMerge(calledRegion, region2depths, true);
					if (node2mergedNode != null) {
						MergedRegion mergedRegion;
						if (callingRegion instanceof MergedRegion) {
							mergedRegion = (MergedRegion)callingRegion;
						}
						else {
							getRegions().remove(calledRegion);
							mergedRegion = new MergedRegion((MergeableRegion)callingRegion);
							Region invokingRegion = callingRegion.getInvokingRegion();
							assert invokingRegion != null;
							List<Region> regions = invokingRegion.getRegions();
							int index = regions.indexOf(callingRegion);
							assert index >= 0;
							regions.set(index, mergedRegion);
//							mergedRegion.writeDOTfile("-6-merged");
//							mergedRegion.writeGraphMLfile("-6-merged");
						}
						mergedRegion.mergeRegion(calledRegion, node2mergedNode);
						getRegions().remove(calledRegion);
						mergedRegion.writeDOTfile("-6-merged");
						mergedRegion.writeGraphMLfile("-6-merged");
						mergedRegion.resolveRecursion();
						mergedRegion.writeDOTfile("-7-merged");
						mergedRegion.writeGraphMLfile("-7-merged");
						region2depths.addRegion(mergedRegion);
					}
				}
			}
		} */
		//
		//	Propagate early results down to later mappings that need them.
		//
/*		for (Region calledRegion : sortedRegions) {
			calledRegion.refineBindings(this);
		} */
/*		HashMap<Node, List<Node>> outerNode2outerNodes = new HashMap<Node, List<Node>>();
		Map<Region, Map<NavigationEdge, NavigationEdge>> region2innerEdge2outerEdge = new HashMap<Region, Map<NavigationEdge, NavigationEdge>>();
		propagateCommonNavigations(rootContainmentRegion, outerNode2outerNodes, region2innerEdge2outerEdge);
		for (@SuppressWarnings("null")@NonNull Map.Entry<Region, Map<NavigationEdge, NavigationEdge>> entry1 : region2innerEdge2outerEdge.entrySet()) {
			Region innerRegion = entry1.getKey();
			for (@SuppressWarnings("null")@NonNull NavigationEdge innerEdge : entry1.getValue().keySet()) {
				Node innerNode = innerEdge.getTarget();
				List<NavigationEdge> bestPath = null;
				for (@SuppressWarnings("null")@NonNull List<Node> headGroup : innerRegion.getHeadNodeGroups()) {
					for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						bestPath = getBestPath(bestPath, getPath(headNode, innerNode, new HashSet<Edge>()));
					}
				}
				assert bestPath != null;
				for (@SuppressWarnings("null")@NonNull Node node : innerRegion.getNodes()) {
					for (@SuppressWarnings("null")@NonNull Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
						assert edge.getTarget() == node;		
						Region outerRegion = edge.getSource().getRegion();
						Map<Edge, Edge> innerEdge2outerEdge = createPath(edge.getSource(), bestPath);
						for (@SuppressWarnings("null")@NonNull Map.Entry<Edge, Edge> entry : innerEdge2outerEdge.entrySet()) {
							Edge outerEdge = entry.getValue();
							Edge innerEdge2 = entry.getKey();
							Edges.USED_BINDING.createEdge(outerRegion, outerEdge.getTarget(), innerEdge2.getName(), innerEdge2.getTarget());
						}
//						innerNode2outerNode.put(node, edge.getSource());
//						propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);
						
						
						
						
//						propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
					}
				}
			} */
/*			Map<Node, Edge> innerNode2edge = new HashMap<Node, Edge>();
			Map<Node, Node> innerNode2outerNode = new HashMap<Node, Node>();
//			for (NavigationEdge innerEdge : entry1.getValue().keySet()) {
//				innerNode2edge.put(innerEdge.getSource(), innerEdge);
//			}
			for (Node node : innerRegion.getNodes()) {
				for (Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
					assert edge.getTarget() == node;
					
					Node outerNode = createPath(edge.getRegion(), bestEdge);
					
					innerNode2outerNode.put(node, edge.getSource());
					propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);
					
					
					
					
					propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
				}
			}
			for (Map.Entry<NavigationEdge, NavigationEdge> entry2 : entry1.getValue().entrySet()) {
				NavigationEdge innerEdge = entry2.getKey();
				NavigationEdge outerEdge = entry2.getValue();
				propagateEdge(outerEdge.getSource(), innerEdge.getSource());
				propagateEdge(outerEdge.getTarget(), innerEdge.getTarget());
			} */
//		}
//		firstPassRegion.writeDOTfile();
//		firstPassRegion.writeGraphMLfile();
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
//		Map<Node, Set<Node>> node2consumers = new HashMap<Node, Set<Node>>();
		for (Node outerNode : region.getNodes()) {
			for (Edge edge : outerNode.getOutgoingPassedBindingEdges()) {
				Node innerNode = edge.getTarget();
				Iterable<Edge> incomingPassedBindingEdges = innerNode.getIncomingPassedBindingEdges();
				if (Iterables.size(incomingPassedBindingEdges) == 1) {				// FIXME is passing to multi-called regions viable?
					Map<Node, List<Node>> innerNode2outerNodes = new HashMap<Node, List<Node>>();
					for (Map.Entry<Node, List<Node>> entry : outerNode2outerNodes.entrySet()) {
						innerNode2outerNodes.put(entry.getKey(), new ArrayList<Node>(entry.getValue()));
					}
					assert outerNode == edge.getSource();
					List<Node> outerNodes = innerNode2outerNodes.get(innerNode);
					if (outerNodes == null) {
						List<Node> outerOuterNodes = outerNode2outerNodes.get(outerNode);
						outerNodes = outerOuterNodes != null ? new ArrayList<Node>(outerOuterNodes) : new ArrayList<Node>();
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
			innerEdge2outerEdge = new HashMap<NavigationEdge, NavigationEdge>();
			region2innerEdge2outerEdge.put(innerRegion, innerEdge2outerEdge);
		}
		List<Node> outerSourceNodes = innerNode2outerNodes.get(innerSourceNode);
		for (NavigationEdge innerEdge : innerSourceNode.getNavigationEdges()) {
			Node innerTargetNode = innerEdge.getTarget();
			if (innerTargetNode.isClassNode() && !innerEdge.getProperty().isIsMany()) {
				List<Node> outerTargetNodes = innerNode2outerNodes.get(innerTargetNode);
				if (outerTargetNodes == null) {
					outerTargetNodes = new ArrayList<Node>();
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

	public Stream<String> dumpClass2consumingNode() {
		Stream<String> entries = consumedClassDatumAnalysis2headNodes.keySet().stream().map(
			k -> {
				List<Node> list = consumedClassDatumAnalysis2headNodes.get(k);
				assert list != null;
				return String.valueOf(k) + " : " + list.stream().map(
					p -> p.getDisplayName()
				).sorted().reduce("", stringJoin("\n\t\t"));
			}
		);
		return entries.sorted();
	}

	public Stream<String> dumpClass2ConsumingProperty() {
		Stream<String> entries = consumedCompositeProperty2introducedClassDatumAnalyses.keySet().stream().map(
			k -> {
				Set<ClassDatumAnalysis> set = consumedCompositeProperty2introducedClassDatumAnalyses.get(k);
				assert set != null;
				return String.valueOf(k) + " : " +
					set.stream().map(
						p -> p.toString()
					).sorted().reduce("", stringJoin("\n\t\t"));
			}
		);
		return entries.sorted();
	}

	public Stream<String> dumpClass2ContainingProperties() {
		Stream<String> entries = containedClassDatumAnalysis2compositeProperties.keySet().stream().map(
			k -> {
				Set<Property> set = containedClassDatumAnalysis2compositeProperties.get(k);
				assert set != null;
				return String.valueOf(k) + " " + k.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(k)) + " : " + set.stream().map(
					p -> String.valueOf(p)).sorted().reduce("", stringJoin("\n\t\t")
				);
			}
		);
		return entries.sorted();
	}

	public Stream<String> dumpClass2ProducingNode() {
		Stream<String> entries = producedClassDatumAnalysis2realizedNodes.keySet().stream().map(
			k -> {
				List<Node> list = producedClassDatumAnalysis2realizedNodes.get(k);
				assert list != null;
				return String.valueOf(k) + " : " +
					list.stream().map(
						p -> p.getDisplayName()
					).sorted().reduce("", stringJoin("\n\t\t")
				);
			}
		);
		return entries.sorted();
	}

	public Stream<String> dumpInputModels() {
		Stream<String> entries = inputModels.keySet().stream().map(
			k -> String.valueOf(k) + " : " + String.valueOf(inputModels.get(k)));
		return entries.sorted();
	}

	public @NonNull Iterable<Region> getCallableRegions() {
		List<Region> callableRegions = new ArrayList<Region>();
		for (@SuppressWarnings("null")@NonNull Region region : getRegions()) {
			if (/*!region.isConnectionRegion() &&*/ !region.isOperationRegion()) {
				callableRegions.add(region);
			}
		}
		return callableRegions;
	}

	public @NonNull Connection getConnection(@NonNull Iterable<Node> sourceNodes, @NonNull ClassDatumAnalysis classDatumAnalysis) {
//		assert !"EObject".equals(classDatumAnalysis.getCompleteClass().getName());
		Map<Set<Node>, Connection> nodes2connection = classDatumAnalysis2nodes2connections.get(classDatumAnalysis);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<Set<Node>, Connection>();
			classDatumAnalysis2nodes2connections.put(classDatumAnalysis, nodes2connection);
		}
		Set<Node> sources = new HashSet<Node>();
		for (Node sourceNode : sourceNodes) {
			sources.add(sourceNode);
		}
		Connection connection = nodes2connection.get(sources);
		if (connection != null) {
			return connection;
		}
		String joinName = "«join-" + classDatumAnalysis.getCompleteClass().getName() + "-" + nodes2connection.size() + "»";
		connection = new BasicConnection(this, sources, joinName);
		nodes2connection.put(sources, connection);
		return connection;
	}

//	@Override
	public @NonNull Collection<Connection> getConnections() {
		return connections;
	}

	protected @NonNull ClassDatumAnalysis getElementalClassDatumAnalysis(@NonNull Node calledNode) {
		ClassDatumAnalysis classDatumAnalysis = calledNode.getClassDatumAnalysis();
		CompleteClass completeClass = classDatumAnalysis.getCompleteClass();
		org.eclipse.ocl.pivot.Class primaryClass = completeClass.getPrimaryClass();
		if (primaryClass instanceof CollectionType) {
			org.eclipse.ocl.pivot.Class elementType = (org.eclipse.ocl.pivot.Class)((CollectionType)primaryClass).getElementType();
			assert elementType != null;
			classDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(elementType, classDatumAnalysis.getTypedModel());
		}
		return classDatumAnalysis;
	}

	protected @Nullable List<Node> getIntroducingNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
	/*	List<Node> introducingNodes = null;
		CompleteClass completeClass = classDatumAnalysis.getCompleteClass();
		for (ClassDatumAnalysis aClassDatumAnalysis : introducedClassDatumAnalysis2nodes.keySet()) {		// FIXME cache
			if (completeClass.conformsTo(aClassDatumAnalysis.getCompleteClass())) {
				if (introducingNodes == null) {
					introducingNodes = new ArrayList<Node>();
				}
				introducingNodes.addAll(introducedClassDatumAnalysis2nodes.get(aClassDatumAnalysis));
			}
		} */
		return introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);	// Separate introduction of each consumed type
	}

/*	public @NonNull List<ConnectionRegion> getConnectionRegions(@NonNull Region toRegion) {
		List<ConnectionRegion> joinRegions = new ArrayList<ConnectionRegion>();
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
				joinRegion = new ConnectionRegion(getSuperRegion(), joinName, classDatumAnalysis);
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

	protected @Nullable List<Node> getProducingNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
/*		List<Node> producingNodes = null;
		CompleteClass completeClass = classDatumAnalysis.getCompleteClass();
		for (ClassDatumAnalysis aClassDatumAnalysis : producedClassDatumAnalysis2realizedNodes.keySet()) {		// FIXME cache
			if (completeClass.conformsTo(aClassDatumAnalysis.getCompleteClass())) {
				if (producingNodes == null) {
					producingNodes = new ArrayList<Node>();
				}
				producingNodes.addAll(producedClassDatumAnalysis2realizedNodes.get(aClassDatumAnalysis));
			}
		} */
		return producedClassDatumAnalysis2realizedNodes.get(classDatumAnalysis);
	}

	protected @Nullable PropertyDatum getPropertyDatum(@NonNull NavigationEdge producedEdge) {
		assert !producedEdge.isCast();				// Handled by caller
		Property property = producedEdge.getProperty();
		ClassDatumAnalysis classDatumAnalysis = producedEdge.getSource().getClassDatumAnalysis();
		ClassDatum classDatum = classDatumAnalysis.getClassDatum();
		for (PropertyDatum propertyDatum : classDatum.getPropertyDatums()) {
			if (propertyDatum.getProperty() == property) {
				return propertyDatum;
			}
		}
		property = property.getOpposite();
		classDatumAnalysis = producedEdge.getTarget().getClassDatumAnalysis();
		classDatum = classDatumAnalysis.getClassDatum();
		for (PropertyDatum propertyDatum : classDatum.getPropertyDatums()) {
			if (propertyDatum.getProperty() == property) {
				return propertyDatum;
			}
		}
		return null;
	}
	
	public @NonNull RegionOrdering getRegionOrderer() {
		assert regionOrderer != null;
		return regionOrderer;
	}

//	@Override
	public @NonNull List<Region> getRegions() {
		return regions;
	}

/*	private @NonNull Node zzgetSourceOrConnectionNode(@NonNull Collection<Node> sourceNodes, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (sourceNodes.size() <= 1) {
			@SuppressWarnings("null")@NonNull Node sourceNode = sourceNodes.iterator().next();
			return sourceNode;
		}
		Map<Set<Node>, Connection> joins = classDatumAnalysis2nodes2connections.get(classDatumAnalysis);
		if (joins == null) {
			joins = new HashMap<Set<Node>, Connection>();
			classDatumAnalysis2nodes2connections.put(classDatumAnalysis, joins);
		}
		Set<Node> sources = new HashSet<Node>(sourceNodes);
		Connection joinRegion = joins.get(sources);
		if (joinRegion != null) {
			return joinRegion.getConnectionNode();
		}
		String joinName = "-join-" + classDatumAnalysis.getCompleteClass().getName() + "-" + joins.size();
		joinRegion = new ConnectionRegion(getSuperRegion(), joinName, classDatumAnalysis);
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

	/**
	 * Return true if this node is consumed solely by casts (or recursions) and so need not be considered as a true consumer.
	 * The downstream usages will consume more accurately.
	 */
	protected boolean isOnlyCastOrRecursed(@NonNull Node predicatedNode) {
		boolean isCast = false;
		for (Edge outgoingEdge : predicatedNode.getOutgoingEdges()) {
			if (!outgoingEdge.isCast() && !outgoingEdge.isRecursion()) {
				return false;
			}
			isCast = true;
		}
		return isCast;
	}
	
	@Override
	public boolean isLateMergeable(@NonNull Region innerRegion, @NonNull Region2Depth region2depths) {
		return false;
	}

//	@Override
	public void removeConnection(@NonNull Connection connection) {
		boolean wasRemoved = connections.remove(connection);
		assert wasRemoved;
	}

	private @NonNull Node selectBestHeadNode(@NonNull List<Node> headNodes) {
		return ClassUtil.nonNullState(headNodes.get(0));				// FIXME compute best navigability
	}
	
//	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@SuppressWarnings("null")@NonNull Region region : getCallableRegions()) {
			s.appendNode(region);
			for (@SuppressWarnings("null")@NonNull Edge edge : region.getRecursionEdges()) {
				s.appendEdge(edge.getSource().getRegion(), edge, edge.getTarget().getRegion());
			}
		}
//		for (@SuppressWarnings("null")@NonNull Node node : getNodes()) {
//			s.appendNode(node);
//		}
		for (@SuppressWarnings("null")@NonNull Connection connection : getConnections()) {
			connection.toRegionGraph(s);
		}
		s.popCluster();
	}
	
	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (Region region : regions) {
			region.toGraph(s);
		}
		for (@SuppressWarnings("null")@NonNull Node node : getNodes()) {
			s.appendNode(node);
		}
		for (@SuppressWarnings("null")@NonNull Edge edge : getEdges()) {
			s.appendEdge(edge);
		}
		for (@SuppressWarnings("null")@NonNull Connection connection : getConnections()) {
			connection.toGraph(s);
		}
		s.popCluster();
	}
	
//	@Override
	public void toRegionGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@SuppressWarnings("null")@NonNull Region region : getCallableRegions()) {
			s.appendNode(region);
			for (@SuppressWarnings("null")@NonNull Edge edge : region.getRecursionEdges()) {
				s.appendEdge(edge.getSource().getRegion(), edge, edge.getTarget().getRegion());
			}
		}
//		for (@SuppressWarnings("null")@NonNull Node node : getNodes()) {
//			s.appendNode(node);
//		}
		for (@SuppressWarnings("null")@NonNull Connection connection : getConnections()) {
			connection.toRegionGraph(s);
		}
		s.popCluster();
	}
}