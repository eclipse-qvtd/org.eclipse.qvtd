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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;

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
	private final @NonNull Map<@NonNull Model, @NonNull DomainUsage> inputModels = new HashMap<@NonNull Model, @NonNull DomainUsage>();

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
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull Set<@NonNull Property>> containedClassDatumAnalysis2compositeProperties = new HashMap<@NonNull ClassDatumAnalysis, @NonNull Set<@NonNull Property>>();

	/**
	 * The input model classes that may be used as independent inputs by mappings and the nodes at which they are consumed.
	 * In the worst case a flat schedule just permutes allInstances() to provide all mapping inputs.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> consumedClassDatumAnalysis2headNodes = new HashMap<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>>();

	/**
	 * Mapping from each composite property to the classes consumed by mappings and transitive compositions.
	 * No mapping entry is created for composition properties that are not required to introduce model elements.
	 *
	 * For simple cases each composition introduces instances of just a single class corresponding to its composed type.
	 * In more complex cases a composition may also introduce instances of superclasses of its composed type.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull Set<@NonNull ClassDatumAnalysis>> consumedCompositeProperty2introducedClassDatumAnalyses = new HashMap<@NonNull Property, @NonNull Set<@NonNull ClassDatumAnalysis>>();

	/**
	 * The per-class join nodes that identify all introducers.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> introducedClassDatumAnalysis2nodes = new HashMap<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>>();

	/**
	 * The Realized Nodes that produce each ClassDatum.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> producedClassDatumAnalysis2realizedNodes = new HashMap<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>>();

	/**
	 * The Realized Edges that produce each PropertyDatum (or its opposite).
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull List<@NonNull NavigationEdge>> producedPropertyDatum2realizedEdges = new HashMap<@NonNull PropertyDatum, @NonNull List<@NonNull NavigationEdge>>();

	private final @NonNull RootCompositionRegion rootContainmentRegion = new RootCompositionRegion(multiRegion);

	public RootScheduledRegion(@NonNull String name, @NonNull Region primaryRegion) {
		super(primaryRegion.getMultiRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
	}

	public RootScheduledRegion(@NonNull String name, @NonNull List<Region> regions) {
		super(ClassUtil.nonNullState(regions.get(0)).getMultiRegion());
		this.name = name;
		this.completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
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
		List<@NonNull Node> nodes = consumedClassDatumAnalysis2headNodes.get(consumedClassDatumAnalysis);
		if (nodes == null) {
			nodes = new ArrayList<@NonNull Node>();
			consumedClassDatumAnalysis2headNodes.put(consumedClassDatumAnalysis, nodes);
		}
		if (!nodes.contains(headNode)) {
			nodes.add(headNode);
		}
	}

	private void addIntroducedNode(@NonNull Node introducedNode) {
		ClassDatumAnalysis classDatumAnalysis = getElementalClassDatumAnalysis(introducedNode);
		List<@NonNull Node> nodes = introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);
		if (nodes == null) {
			nodes = new ArrayList<@NonNull Node>();
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
		List<@NonNull NavigationEdge> edges = producedPropertyDatum2realizedEdges.get(propertyDatum);
		if (edges == null) {
			edges = new ArrayList<@NonNull NavigationEdge>();
			producedPropertyDatum2realizedEdges.put(propertyDatum, edges);
		}
		if (!edges.contains(producedEdge)) {
			edges.add(producedEdge);
			for (@NonNull AbstractDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuper())) {
				if (superAbstractDatum instanceof PropertyDatum) {
					addProducedEdge(producedEdge, (PropertyDatum) superAbstractDatum);
				}
			}
		}
	}

	private void addProducedNode(@NonNull Node producedNode) {
		ClassDatumAnalysis classDatumAnalysis = getElementalClassDatumAnalysis(producedNode);
		for (@NonNull ClassDatumAnalysis superClassDatumAnalysis : classDatumAnalysis.getSuperClassDatumAnalyses()) {
			List<@NonNull Node> nodes = producedClassDatumAnalysis2realizedNodes.get(superClassDatumAnalysis);
			if (nodes == null) {
				nodes = new ArrayList<@NonNull Node>();
				producedClassDatumAnalysis2realizedNodes.put(superClassDatumAnalysis, nodes);
			}
			nodes.add(producedNode);
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
		for (@NonNull Region region : getRegions()) {
			for (@NonNull Node predicatedNode : region.getOldNodes()) {
				if (!predicatedNode.isHead()) {
					if (!predicatedNode.isLoaded() && !predicatedNode.isConstant() && !predicatedNode.isInternal()) {
						if (!isOnlyCastOrRecursed(predicatedNode)) {			// FIXME Eliminate cast nodes
							addConsumedNode(predicatedNode);
						}
						/*						boolean isCast = true;
						for (Edge outgoingEdge : predicatedNode.getOutgoingEdges()) {
							if (!outgoingEdge.isCast()) {
								isCast = false;
								break;
							}
						}
						if (!isCast) {			// FIXME Eliminate cast nodes
							addConsumedNode(predicatedNode);
						} */
					}
				}
			}
			for (@NonNull Node headNode : region.getHeadNodes()) {
				//				if (headNode.isKnown() && !headNode.isInternal()) {
				if (headNode.isLoaded() && !headNode.isInternal()) {
					addConsumedNode(headNode);
				}
			}
		}
		//
		//	Multiple-node head groups contribute similarly, but just one corresponding class,
		//	preferably one that is already consumed.
		//
		/*		for (@SuppressWarnings("null")@NonNull Region region : getRegions()) {
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
		} */
	}

	/**
	 * Identify all the containment relationships in the input models.
	 */
	private void computeContainedClassDatumAnalysis2compositeProperties() {
		Map<org.eclipse.ocl.pivot.@NonNull Package, @NonNull DomainUsage> allPackagesSet = new HashMap<org.eclipse.ocl.pivot.@NonNull Package, @NonNull DomainUsage>();
		List<org.eclipse.ocl.pivot.@NonNull Package> allPackagesList = new ArrayList<org.eclipse.ocl.pivot.@NonNull Package>();
		for (@NonNull Model asModel : inputModels.keySet()) {
			DomainUsage domainUsage = inputModels.get(asModel);
			assert domainUsage != null;
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(asModel.getOwnedPackages())) {
				if (allPackagesSet.put(asPackage, domainUsage) == null) {
					allPackagesList.add(asPackage);
				}
			}
			for (@NonNull Import asImport : ClassUtil.nullFree(asModel.getOwnedImports())) {
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
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage2 : ClassUtil.nullFree(asPackage.getOwnedPackages())) {
				if (allPackagesSet.put(asPackage2, domainUsage) == null) {
					allPackagesList.add(asPackage2);
				}
			}
			for (org.eclipse.ocl.pivot.@NonNull Class asClass : ClassUtil.nullFree(asPackage.getOwnedClasses())) {
				for (@NonNull Property asProperty : ClassUtil.nullFree(asClass.getOwnedProperties())) {
					if (asProperty.isIsComposite()) {
						computeContainedClassDatumAnalysis2compositeProperties3(asProperty, domainUsage);
					}
					Type asType = asProperty.getType();
					if (asType instanceof org.eclipse.ocl.pivot.Class) {
						org.eclipse.ocl.pivot.Package asPackage2 = ((org.eclipse.ocl.pivot.Class)asType).getOwningPackage();
						if (asPackage2 != null) {
							if (allPackagesSet.put(asPackage2, domainUsage) == null) {
								allPackagesList.add(asPackage2);
							}
						}
					}
				}
			}
		}
		assert allPackagesSet.size() == allPackagesList.size();
		assert allPackagesSet.keySet().equals(new HashSet<org.eclipse.ocl.pivot.Package>(allPackagesList));
	}

	private void computeContainedClassDatumAnalysis2compositeProperties3(@NonNull Property asProperty, @NonNull DomainUsage domainUsage) {
		Type asType = PivotUtil.getElementalType(ClassUtil.nonNullState(asProperty.getType()));
		if (asType instanceof org.eclipse.ocl.pivot.Class) {
			ClassDatumAnalysis classDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis((Class) asType, ClassUtil.nonNullState(domainUsage.getTypedModel(null)));
			Set<@NonNull Property> compositeProperties = containedClassDatumAnalysis2compositeProperties.get(classDatumAnalysis);
			if (compositeProperties == null) {
				compositeProperties = new HashSet<@NonNull Property>();
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
		Set<@NonNull ClassDatumAnalysis> allConsumedClassDatumAnalyses = new HashSet<@NonNull ClassDatumAnalysis>(consumedClassDatumAnalysis2headNodes.keySet());
		List<@NonNull ClassDatumAnalysis> allConsumedClassDatumAnalysesList = new ArrayList<@NonNull ClassDatumAnalysis>(allConsumedClassDatumAnalyses);
		for (int i = 0; i < allConsumedClassDatumAnalysesList.size(); i++) {
			ClassDatumAnalysis consumedClassDatumAnalysis = allConsumedClassDatumAnalysesList.get(i);
			for (@NonNull ClassDatumAnalysis consumedSuperClassDatumAnalysis : consumedClassDatumAnalysis.getSuperClassDatumAnalyses()) {
				Set<@NonNull Property> consumedCompositeProperties = containedClassDatumAnalysis2compositeProperties.get(consumedSuperClassDatumAnalysis);
				if (consumedCompositeProperties != null) {
					for (@NonNull Property consumedCompositeProperty : consumedCompositeProperties) {
						Set<@NonNull ClassDatumAnalysis> introducedClassDatumAnalyses = consumedCompositeProperty2introducedClassDatumAnalyses.get(consumedCompositeProperty);
						if (introducedClassDatumAnalyses == null) {
							introducedClassDatumAnalyses = new HashSet<@NonNull ClassDatumAnalysis>();
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
			if (domainUsage.isInput() && !domainUsage.isOutput()) {
				Type type = classDatumAnalysis.getClassDatum().getType();
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
		for (@NonNull Region region : getRegions()) {
			for (@NonNull Node assignedNode : region.getAssignedNodes()) {
				if (assignedNode.isClass()) {
					addProducedNode(assignedNode);
				}
			}
			for (@NonNull NavigationEdge realizedNavigationEdge : region.getRealizedNavigationEdges()) {
				addProducedEdge(realizedNavigationEdge);
			}
		}
	}

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
		List<@NonNull Region> sortedCallableRegions = new ArrayList<@NonNull Region>();
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

		for (@NonNull Region region : getCallableRegions()) {
			for (@NonNull Node node : region.getHeadNodes()) {
				if (node.isLoaded()) {
					Node introducedNode = rootContainmentRegion.getIntroducerNode(node);
					addIntroducedNode(introducedNode);
				}
			}
		}
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
		//	Identify all the containment relationships in the input models.
		//
		computeContainedClassDatumAnalysis2compositeProperties();
		if (QVTp2QVTs.DUMP_CLASS_TO_CONTAINING_PROPERTIES.isActive()) {
			QVTp2QVTs.DUMP_CLASS_TO_CONTAINING_PROPERTIES.println(dumpClass2ContainingProperties().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify all classes that are produced by mappings.
		//
		computeProducedClassDatumAnalysis2realizedNodes();
		if (QVTp2QVTs.DUMP_CLASS_TO_REALIZED_NODES.isActive()) {
			QVTp2QVTs.DUMP_CLASS_TO_REALIZED_NODES.println(dumpClass2ProducingNode().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify all classes that are consumed as independent inputs of mappings.
		//
		computeConsumedConsumedClassDatumAnalysis2headNodes();
		if (QVTp2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.isActive()) {
			QVTp2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.println(dumpClass2consumingNode().reduce("", stringJoin("\n\t")));
		}
		//
		//	Identify all classes that are transitively consumed as containers of consumed classes.
		//
		computeConsumedCompositeProperty2introducedClassDatumAnalyses();
		if (QVTp2QVTs.DUMP_PROPERTY_TO_CONSUMING_CLASSES.isActive()) {
			QVTp2QVTs.DUMP_PROPERTY_TO_CONSUMING_CLASSES.println(dumpClass2ConsumingProperty().reduce("", stringJoin("\n\t")));
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
				return k.getDomainUsage() + " " + String.valueOf(k) + " : " +
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

	/**
	 * Return all Realized NavigationEdges corresponding to predicatedEdge that navigate an isComposite property in either direction.
	 * Returns null in the very unusual event that there are none.
	 *
	 * It is assumed that edge is an predicated oclContainer edge to which almost all containment edges are compatible for a pathological
	 * input model whose metamodel extends the transformed metamodel with derived classes that merge the containment relationship
	 * of predicated/realized candidates.
	 *
	 * FIXME In the event that the ends of the realized edges are realized variables, we do know the precise
	 * type and could filter accordingly; a not-yet-exploited optimisation.
	 */
	private @Nullable Iterable<@NonNull NavigationEdge> getCompositeRealizedEdges(@NonNull NavigationEdge predicatedEdge) {
		Set<@NonNull NavigationEdge> realizedEdges = null;
		for (Map.Entry<@NonNull PropertyDatum, @NonNull List<@NonNull NavigationEdge>> entry : producedPropertyDatum2realizedEdges.entrySet()) {
			Property property = entry.getKey().getProperty();
			if (property != null) {
				@Nullable Property compositeProperty = null;
				if (property.isIsComposite()) {
					compositeProperty = property;
				}
				else {
					Property oppositeProperty = property.getOpposite();
					if ((oppositeProperty != null) && oppositeProperty.isIsComposite()) {
						compositeProperty = oppositeProperty;
					}
				}
				if (compositeProperty != null) {
					if (realizedEdges == null) {
						realizedEdges = new HashSet<@NonNull NavigationEdge>();
					}
					realizedEdges.addAll(entry.getValue());
				}
			}
		}
		return realizedEdges;
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

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return QVTp2QVTs.EMPTY_NODE_LIST;
	}

	public @Nullable Iterable<@NonNull Node> getIntroducingNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
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

	public @Nullable Iterable<@NonNull Node> getIntroducingOrProducingNodes(@NonNull Node headNode) {
		ClassDatumAnalysis classDatumAnalysis = headNode.getClassDatumAnalysis();
		if (classDatumAnalysis.getDomainUsage().isInput()) {
			return Collections.singletonList(rootContainmentRegion.getIntroducerNode(headNode));
		}
		else {
			return getIntroducingOrProducingNodes(classDatumAnalysis);
		}
	}

	public @Nullable Iterable<@NonNull Node> getIntroducingOrProducingNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		//		Iterable<@NonNull Node> introducedNodes = introducedClassDatumAnalysis2nodes.get(classDatumAnalysis);
		Iterable<@NonNull Node> producedNodes = producedClassDatumAnalysis2realizedNodes.get(classDatumAnalysis);
		//		if (introducedNodes != null) {
		//			if (producedNodes != null) {
		//				return Iterables.concat(introducedNodes, producedNodes);
		//			}
		//			else {
		//				return introducedNodes;
		//			}
		//		}
		//		else {
		if (producedNodes != null) {
			return producedNodes;
		}
		else {
			return null;
		}
		//		}
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

	protected @Nullable PropertyDatum getPropertyDatum(@NonNull NavigationEdge producedEdge) {
		assert !producedEdge.isCast();				// Handled by caller
		Property property = producedEdge.getProperty();
		ClassDatumAnalysis classDatumAnalysis = producedEdge.getSource().getClassDatumAnalysis();
		ClassDatum forwardClassDatum = classDatumAnalysis.getClassDatum();
		Iterable<@NonNull PropertyDatum> forwardPropertyDatums = QVTp2QVTg.getAllPropertyDatums(forwardClassDatum);
		for (PropertyDatum propertyDatum : forwardPropertyDatums) {
			if ((propertyDatum.getProperty() == property) && (propertyDatum.getClassDatum() == forwardClassDatum)) {
				return propertyDatum;
			}
		}
		ClassRelationships classRelationships = getSchedulerConstants().getClassRelationships();
		PropertyDatum bestPropertyDatum = null;
		for (PropertyDatum propertyDatum : forwardPropertyDatums) {
			if (propertyDatum.getProperty() == property) {
				if (bestPropertyDatum == null) {
					bestPropertyDatum = propertyDatum;
				}
				else {
					org.eclipse.ocl.pivot.Class type = propertyDatum.getClassDatum().getType();
					assert type != null;
					Set<@NonNull Class> allSuperClasses = classRelationships.getAllSuperClasses(type);
					if (allSuperClasses.contains(bestPropertyDatum.getClassDatum().getType())) {
						bestPropertyDatum = propertyDatum;
					}
				}
			}
		}
		if (bestPropertyDatum != null) {
			return bestPropertyDatum;
		}
		property = property.getOpposite();
		classDatumAnalysis = producedEdge.getTarget().getClassDatumAnalysis();
		ClassDatum reverseClassDatum = classDatumAnalysis.getClassDatum();
		Iterable<@NonNull PropertyDatum> reversePropertyDatums = QVTp2QVTg.getAllPropertyDatums(reverseClassDatum);
		for (PropertyDatum propertyDatum : reversePropertyDatums) {
			if ((propertyDatum.getProperty() == property) && (propertyDatum.getClassDatum() == reverseClassDatum)) {
				return propertyDatum;
			}
		}
		for (PropertyDatum propertyDatum : reversePropertyDatums) {
			if (propertyDatum.getProperty() == property) {
				if (bestPropertyDatum == null) {
					bestPropertyDatum = propertyDatum;
				}
				else {
					org.eclipse.ocl.pivot.Class type = propertyDatum.getClassDatum().getType();
					assert type != null;
					Set<@NonNull Class> allSuperClasses = classRelationships.getAllSuperClasses(type);
					if (allSuperClasses.contains(bestPropertyDatum.getClassDatum().getType())) {
						bestPropertyDatum = propertyDatum;
					}
				}
			}
		}
		if (bestPropertyDatum != null) {
			return bestPropertyDatum;
		}
		return null;
	}

	public @Nullable Iterable<@NonNull NavigationEdge> getRealizedEdges(@NonNull NavigationEdge edge, @NonNull ClassDatumAnalysis requiredClassDatumAnalysis) {
		Property property = edge.getProperty();
		if (property.eContainer() == null) {			// Ignore pseudo-properties such as «iterate»
			return null;
		}
		PropertyDatum propertyDatum = getPropertyDatum(edge);
		if (propertyDatum == null) {
			if (property == getSchedulerConstants().getOclContainerProperty()) {
				return getCompositeRealizedEdges(edge);
			}
			propertyDatum = getPropertyDatum(edge);				// FIXME debugging
		}
		assert propertyDatum != null;
		Iterable<@NonNull NavigationEdge> realizedEdges = producedPropertyDatum2realizedEdges.get(propertyDatum);
		if (realizedEdges == null) {
			return null;
		}
		CompleteClass requiredClass = requiredClassDatumAnalysis.getCompleteClass();
		List<@NonNull NavigationEdge> conformantRealizedEdges = null;
		for (@NonNull NavigationEdge realizedEdge : realizedEdges) {
			Node targetNode = realizedEdge.getTarget();
			CompleteClass realizedClass = targetNode.getCompleteClass();
			if (realizedClass.conformsTo(requiredClass) /*|| realizedClass.conformsTo(requiredClass.getBehavioralClass())*/) {
				if (conformantRealizedEdges == null) {
					conformantRealizedEdges = new ArrayList<@NonNull NavigationEdge>();
				}
				conformantRealizedEdges.add(realizedEdge);
			}
		}
		return conformantRealizedEdges;
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
			joins = new HashMap<Set<Node>, Connection>();
			classDatumAnalysis2nodes2connections.put(classDatumAnalysis, joins);
		}
		Set<Node> sources = new HashSet<Node>(sourceNodes);
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