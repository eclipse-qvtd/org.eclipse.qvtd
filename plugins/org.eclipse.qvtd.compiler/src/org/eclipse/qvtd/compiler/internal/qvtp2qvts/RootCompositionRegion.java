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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class RootCompositionRegion extends AbstractRegion
{
	/**
	 * The null node that is the 'container' of all root model elements.
	 */
	private /*@LazyNonNull*/ Node nullNode = null;

	/**
	 * The introducer node for each consumed ClassDatumAnalysis and for each known container property where the containing property is known.
	 * The null containing property is used for introducer nodes required to be at the root.
	 */
	private final @NonNull Map<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Map<@Nullable Property, @NonNull Node>> classDatumAnalysis2property2node = new HashMap<>();

	/**
	 * The introducer node for each consumed ClassDatumAnalysis and for each known containing type where the containing property is just oclContainer.
	 * The null type is used when no containing property or type is known.
	 */
	private final @NonNull Map<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Map<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Node>> classDatumAnalysis2type2node = new HashMap<>();

	protected RootCompositionRegion(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRootCompositionRegion(this);
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString(QVTimperativeUtil.ROOT_MAPPING_NAME);
		return s;
	}

	@Override
	public void createIncomingConnections() {}

	public @NonNull Node getIntroducerNode(@NonNull Node consumerNode) {
		//
		//	Identify the containment pattern.
		//
		NavigableEdge containerEdge = null;
		Property parent2childProperty = null;
		ClassDatumAnalysis containingClassDatumAnalysis = null;
		SchedulerConstants scheduler = getSchedulerConstants();
		for (@NonNull NavigableEdge edge : consumerNode.getNavigationEdges()) {
			Property property = edge.getProperty().getOpposite();
			if ((property != null) && property.isIsComposite() && !property.isIsRequired()) {
				containerEdge = edge;
				parent2childProperty = property;
				if (property == scheduler.getStandardLibraryHelper().getOclContainerProperty()) {
					containingClassDatumAnalysis = edge.getSource().getClassDatumAnalysis();
				}
				break;
			}
		}
		CompleteEnvironment completeEnvironment = scheduler.getEnvironmentFactory().getCompleteEnvironment();
		ClassDatumAnalysis consumedClassDatumAnalysis = /*getCastTarget(consumerNode)*/consumerNode.getClassDatumAnalysis();
		org.eclipse.ocl.pivot.Class elementType = consumedClassDatumAnalysis.getCompleteClass().getPrimaryClass();
		TypedModel typedModel = consumedClassDatumAnalysis.getTypedModel();
		CollectionType childCollectionType = completeEnvironment.getSetType(elementType, true,  null, null);
		ClassDatumAnalysis childrenClassDatumAnalysis = scheduler.getClassDatumAnalysis(childCollectionType, typedModel);
		//
		//	Create / re-use the appropriate containment pattern.
		//
		Node introducedNode;
		if (parent2childProperty == null) {												// No known containment, owned by null type
			Map<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Node> type2node = classDatumAnalysis2type2node.get(consumedClassDatumAnalysis);
			if (type2node == null) {
				type2node = new HashMap<>();
				classDatumAnalysis2type2node.put(consumedClassDatumAnalysis, type2node);
			}
			introducedNode = type2node.get(null);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(this, "«" + elementType.getName() + "»", childrenClassDatumAnalysis);
				type2node.put(null, introducedNode);
			}
		}
		else if ((containerEdge != null) && containerEdge.getTarget().isExplicitNull()) {		// At root, owned by null property
			Map<@Nullable Property, @NonNull Node> property2node = classDatumAnalysis2property2node.get(consumedClassDatumAnalysis);
			if (property2node == null) {
				property2node = new HashMap<>();
				classDatumAnalysis2property2node.put(consumedClassDatumAnalysis, property2node);
			}
			introducedNode = property2node.get(null);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(this, "«" + elementType.getName() + "-null»", childrenClassDatumAnalysis);
				property2node.put(null, introducedNode);
				RegionUtil.createNavigationEdge(getNullNode(), parent2childProperty, introducedNode);
			}
		}
		else if (containingClassDatumAnalysis != null) {								// Non-root oclContainer ownership
			Map<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Node> type2node = classDatumAnalysis2type2node.get(consumedClassDatumAnalysis);
			if (type2node == null) {
				type2node = new HashMap<>();
				classDatumAnalysis2type2node.put(consumedClassDatumAnalysis, type2node);
			}
			introducedNode = type2node.get(containingClassDatumAnalysis);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(this, "«" + elementType.getName() + "-oclContents»", childrenClassDatumAnalysis);
				type2node.put(containingClassDatumAnalysis, introducedNode);
				Node containerNode = RegionUtil.createComposingNode(this, "«" + containingClassDatumAnalysis.getCompleteClass().getName() + "-oclContainer»", containingClassDatumAnalysis);
				RegionUtil.createNavigationEdge(containerNode, parent2childProperty, introducedNode);
			}
		}
		else {																			// Knonw distinctive containment
			Map<@Nullable Property, @NonNull Node> property2node = classDatumAnalysis2property2node.get(consumedClassDatumAnalysis);
			if (property2node == null) {
				property2node = new HashMap<>();
				classDatumAnalysis2property2node.put(consumedClassDatumAnalysis, property2node);
			}
			introducedNode = property2node.get(parent2childProperty);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(this, "«" + elementType.getName() + "-" + parent2childProperty.getName() + "»", childrenClassDatumAnalysis);
				property2node.put(parent2childProperty, introducedNode);
				org.eclipse.ocl.pivot.Class owningClass = parent2childProperty.getOwningClass();
				assert owningClass != null;
				containingClassDatumAnalysis = scheduler.getClassDatumAnalysis(owningClass, typedModel);
				Node containerNode = RegionUtil.createComposingNode(this, "«" + owningClass.getName() + "-" + parent2childProperty.getName() + "»", containingClassDatumAnalysis);
				RegionUtil.createNavigationEdge(containerNode, parent2childProperty, introducedNode);
			}
		}
		return introducedNode;
	}

	@Override
	public @NonNull String getName() {
		return QVTimperativeUtil.ROOT_MAPPING_NAME;
	}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return SchedulerConstants.EMPTY_NODE_LIST;
	}

	private @NonNull Node getNullNode() {
		Node nullNode2 = nullNode;
		if (nullNode2 == null) {
			nullNode = nullNode2 = RegionUtil.createNullNode(this, true, null);
		}
		return nullNode2;
	}

	@Override
	public boolean isLateMergeable(@NonNull Region innerRegion, @NonNull Region2Depth region2depths) {
		return false;
	}

	@Override
	public boolean isRootCompositionRegion() {
		return true;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.setColor("lightblue");
		s.setPenwidth(Role.LINE_WIDTH);
		s.pushCluster();
		for (@NonNull Node node : getNodes()) {
			s.appendNode(node);
		}
		for (@NonNull Edge edge : getEdges()) {
			s.appendEdge(edge.getSource(), edge, edge.getTarget());
		}
		s.popCluster();
	}
}