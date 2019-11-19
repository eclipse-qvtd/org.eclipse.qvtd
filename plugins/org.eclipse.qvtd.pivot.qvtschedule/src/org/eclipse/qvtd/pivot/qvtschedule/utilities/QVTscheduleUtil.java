/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MergedPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;

public class QVTscheduleUtil extends QVTscheduleConstants
{
	public static class Internal
	{
		public static @NonNull List<@NonNull Region> getActiveRegionsList(@NonNull RootRegion rootRegion) {
			return ClassUtil.nullFree(rootRegion.getActiveRegions());
		}

		public static @NonNull List<@NonNull Node> getHeadNodesList(@NonNull BasicPartition basicPartition) {
			return ClassUtil.nullFree(basicPartition.getHeadNodes());
		}

		public static @NonNull List<@NonNull Node> getHeadNodesList(@NonNull Region region) {
			return ClassUtil.nullFree(region.getHeadNodes());
		}

		public static List<@NonNull RootRegion> getOwnedRootRegionsList(@NonNull ScheduleModel scheduleModel) {
			return ClassUtil.nullFree(scheduleModel.getOwnedRootRegions());
		}

		public static @NonNull List<@NonNull ClassDatum> getSuperClassDatumsList(@NonNull ClassDatum classDatum) {
			return ClassUtil.nullFree(classDatum.getSuperClassDatums());
		}
	}

	public static @NonNull Role asPhase(@NonNull Role nodeRole, @NonNull Role phase) {
		return phase;
	}

	public static @NonNull Role asPredicated(@NonNull Role nodeRole) {
		return asPhase(nodeRole, Role.PREDICATED);
	}

	public static @NonNull Role asSpeculated(@NonNull Role nodeRole) {
		return asPhase(nodeRole, Role.SPECULATED);
	}

	public static @NonNull Role asSpeculation(@NonNull Role nodeRole) {
		return asPhase(nodeRole, Role.SPECULATION);
	}

	public static @Nullable ScheduleModel basicGetContainingScheduleModel(@NonNull Element element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ScheduleModel) {
				return (ScheduleModel)eObject;
			}
		}
		return null;
	}

	public static @Nullable NavigationEdge basicGetOutgoingNavigationEdge(@NonNull Node traceNode, @NonNull Property property) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			if (edge instanceof NavigationEdge) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				if (QVTscheduleUtil.getReferredProperty(navigationEdge) == property) {
					return navigationEdge;
				}
			}
		}
		return null;
	}

	/**
	 * Return true if there may be a dynamic type conforming to both the firstType and secondType static types.
	 */
	public static boolean conformantWith(@NonNull ClassDatum thisClassDatum, @NonNull ClassDatum thatClassDatum) {
		//	if (conformsTo(thisClassDatum, thatClassDatum)) {
		//		return true;
		//	}
		//	if (conformsTo(thatClassDatum, thisClassDatum)) {
		//		return true;
		//	}
		if (conformsToClassOrBehavioralClass(thisClassDatum, thatClassDatum)) {
			return true;
		}
		if (conformsToClassOrBehavioralClass(thatClassDatum, thisClassDatum)) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if thisClassDatum conforms to, i.e can be used as, thatClassDatum.
	 *
	 * If the ClassDatum is a multi-CompleteClass there must be a CompleteClass, not necessarily the same CompleteClass, of thisClassDatum's CompleteClasses
	 * that conforms to each of thatClassDatum's CompleteClasses.
	 */
	public static boolean conformsTo(@NonNull ClassDatum thisClassDatum, @NonNull ClassDatum thatClassDatum) {
		List<@NonNull CompleteClass> thoseCompleteClasses = thatClassDatum.basicGetCompleteClasses();
		if (thoseCompleteClasses == null) {
			return false;
		}
		for (CompleteClass thatCompleteClass : thoseCompleteClasses) {
			if (!conformsTo(thisClassDatum, thatCompleteClass)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return true if thisClassDatum conforms to, i.e can be used as, thatCompleteClass.
	 *
	 * If the ClassDatum is a multi-CompleteClass it is sufficient that any one of thisClassDatum's CompleteClasses conforms to thatCompleteClass.
	 */
	public static boolean conformsTo(@NonNull ClassDatum thisClassDatum, @NonNull CompleteClass thatCompleteClass) {
		List<@NonNull CompleteClass> theseCompleteClasses = thisClassDatum.basicGetCompleteClasses();
		if (theseCompleteClasses == null) {
			return false;
		}
		for (@NonNull CompleteClass thisCompleteClass : theseCompleteClasses) {
			if (thisCompleteClass.conformsTo(thatCompleteClass)) {
				return true;
			}
		}
		return false;
	}

	public static boolean conformsTo(@NonNull CompleteClass thisCompleteClass, @NonNull ClassDatum thatClassDatum) {
		List<@NonNull CompleteClass> thoseCompleteClasses = thatClassDatum.basicGetCompleteClasses();
		if (thoseCompleteClasses == null) {
			return false;
		}
		for (@NonNull CompleteClass thatCompleteClass : thoseCompleteClasses) {
			if (!thisCompleteClass.conformsTo(thatCompleteClass)) {
				return false;
			}
		}
		return true;
	}

	public static boolean conformsToClassOrBehavioralClass(@NonNull CompleteClass thisCompleteClass, @NonNull CompleteClass thatCompleteClass) {
		return thisCompleteClass.conformsTo(thatCompleteClass) || thisCompleteClass.conformsTo(thatCompleteClass.getBehavioralClass());
	}

	public static boolean conformsToClassOrBehavioralClass(@NonNull ClassDatum thisClassDatum, @NonNull CompleteClass thatCompleteClass) {
		List<@NonNull CompleteClass> theseCompleteClasses = thisClassDatum.basicGetCompleteClasses();
		if (theseCompleteClasses == null) {
			return false;
		}
		for (@NonNull CompleteClass thisCompleteClass : theseCompleteClasses) {
			if (conformsToClassOrBehavioralClass(thisCompleteClass, thatCompleteClass)) {
				return true;
			}
		}
		return false;
	}

	public static boolean conformsToClassOrBehavioralClass(@NonNull ClassDatum thisClassDatum, @NonNull ClassDatum thatClassDatum) {
		List<@NonNull CompleteClass> thoseCompleteClasses = thatClassDatum.basicGetCompleteClasses();
		if (thoseCompleteClasses == null) {
			return false;
		}
		for (@NonNull CompleteClass thatCompleteClass : thoseCompleteClasses) {
			if (!conformsToClassOrBehavioralClass(thisClassDatum, thatCompleteClass)) {
				return false;
			}
		}
		return true;
	}

	public static boolean containsNone(@NonNull Iterable<@NonNull Node> firstNodes, @NonNull Iterable<@NonNull Node> secondNodes) {
		for (@NonNull Node firstNode : firstNodes) {
			for (@NonNull Node secondNode : secondNodes) {
				if (firstNode == secondNode) {
					return false;
				}
			}
		}
		return true;
	}

	public static @NonNull Iterable<@NonNull Region> getActiveRegions(@NonNull RootRegion rootRegion) {
		return ClassUtil.nullFree(rootRegion.getActiveRegions());
	}

	public static @NonNull ClassDatum getClassDatum(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getClassDatum());
	}

	public static @NonNull ClassDatum getClassDatum(@NonNull NodeConnection connection) {
		return ClassUtil.nonNullState(connection.getClassDatum());
	}

	public static @NonNull String getColor(@NonNull Role role) {
		switch (role) {
			case CONSTANT: return QVTscheduleConstants.CONSTANT_COLOR;
			case CONSTANT_SUCCESS_FALSE: return QVTscheduleConstants.CONSTANT_COLOR;
			case CONSTANT_SUCCESS_TRUE: return QVTscheduleConstants.CONSTANT_COLOR;
			case LOADED: return QVTscheduleConstants.LOADED_COLOR;
			case PREDICATED: return QVTscheduleConstants.PREDICATED_COLOR;
			case REALIZED: return QVTscheduleConstants.REALIZED_COLOR;
			case SPECULATION: return QVTscheduleConstants.SPECULATION_COLOR;
			case SPECULATED: return QVTscheduleConstants.SPECULATED_COLOR;
			default: return QVTscheduleConstants.OTHER_COLOR;
		}
	}

	public static @NonNull List<@NonNull CompleteClass> getCompleteClasses(@NonNull ClassDatum classDatum) {
		return ClassUtil.nullFree(classDatum.getCompleteClasses());
	}

	/*	public static @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> getCompleteClass2Nodes(@NonNull Region region) {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2nodes = new HashMap<>();
		for (@NonNull Node node : getOwnedNodes(region)) {
			CompleteClass completeClass = node.getCompleteClass();
			List<@NonNull Node> mergedNodes = completeClass2nodes.get(completeClass);
			if (mergedNodes == null) {
				mergedNodes = new ArrayList<>();
				completeClass2nodes.put(completeClass, mergedNodes);
			}
			if (!mergedNodes.contains(node)) {
				mergedNodes.add(node);
			}
		}
		return completeClass2nodes;
	} */

	public static @NonNull RootRegion getContainingRootRegion(@NonNull Region region) {
		return ClassUtil.nonNullState(region.getContainingRootRegion());
	}

	public static @NonNull Iterable<@NonNull Node> getDependencyNodes(@NonNull OperationRegion operationRegion) {
		return ClassUtil.nullFree(operationRegion.getDependencyNodes());
	}

	public static @NonNull Role getEdgeRole(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getEdgeRole());
	}

	public static @NonNull ClassDatum getElementalClassDatum(@NonNull CollectionClassDatum collectionClassDatum) {
		return ClassUtil.nonNullState(collectionClassDatum.getElementalClassDatum());
	}

	public static @NonNull EnumerationLiteral getEnumValue(@NonNull EnumLiteralNode node) {
		return ClassUtil.nonNullState(node.getEnumValue());
	}

	public static @NonNull Iterable<? extends @NonNull Partition> getExplicitPredecessors(@NonNull BasicPartition partition) {
		return ClassUtil.nullFree(partition.getExplicitPredecessors());
	}

	public static @NonNull String getFillColor(@NonNull Role nodeRole) {
		switch (nodeRole) {
			case CONSTANT: return LIGHT_CONSTANT_COLOR;
			case LOADED: return LIGHT_LOADED_COLOR;
			case PREDICATED: return LIGHT_PREDICATED_COLOR;
			case REALIZED: return LIGHT_REALIZED_COLOR;
			case SPECULATION: return LIGHT_SPECULATION_COLOR;
			case SPECULATED: return LIGHT_SPECULATED_COLOR;
			default: return LIGHT_OTHER_COLOR;
		}
	}

	public static @NonNull Iterable<@NonNull Node> getHeadNodes(@NonNull Partition partition) {
		return ClassUtil.nullFree(partition.getHeadNodes());
	}

	public static @NonNull Iterable<@NonNull Node> getHeadNodes(@NonNull Region region) {
		return ClassUtil.nullFree(region.getHeadNodes());
	}

	public static @NonNull Iterable<@NonNull Edge> getIncomingEdges(@NonNull Node node) {
		return ClassUtil.nullFree(node.getIncomingEdges());
	}

	public static @NonNull List<@NonNull NodeConnection> getIntermediateConnections(@NonNull Partition partition) {
		return ClassUtil.nullFree(partition.getIntermediateConnections());
	}

	public static @NonNull List<@NonNull Partition> getIntermediatePartitions(@NonNull NodeConnection connection) {
		return ClassUtil.nullFree(connection.getIntermediatePartitions());
	}

	public static @NonNull LoadingPartition getLoadingPartition(@NonNull LoadingRegion loadingRegion) {
		return ClassUtil.nonNullState(loadingRegion.getLoadingPartition());
	}

	public static @NonNull Iterable<@NonNull MappingPartition> getMappingPartitions(@NonNull MappingRegion mappingRegion) {
		return ClassUtil.nullFree(mappingRegion.getMappingPartitions());
	}

	/**
	 * Return the merged partition that replaces this or this if not merged.
	 */
	public static @Nullable Partition getMergedPartition(@NonNull Partition partition) {
		if (partition instanceof BasicPartition) {
			for (MergedPartition mergedPartition; (mergedPartition = ((BasicPartition)partition).getOwningMergedPartition()) != null;  ) {
				partition = mergedPartition;
			}
		}
		return partition;
	}

	public static @NonNull String getName(@NonNull Nameable nameable) {
		return ClassUtil.nonNullState(nameable.getName());
	}

	public static @NonNull Role getNodeRole(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getNodeRole());
	}

	public static @NonNull Role getOperationNodePhase(@NonNull Region region, @Nullable TypedElement typedElement, @NonNull Node... argNodes) {
		boolean isLoaded = false;
		boolean isPredicated = false;
		boolean isRealized = false;
		if (argNodes != null) {
			for (Node argNode : argNodes) {
				if (argNode.isRealized()) {
					isRealized = true;
				}
				else if (argNode.isPredicated()) {
					isPredicated = true;
				}
				else if (argNode.isLoaded()) {
					isLoaded = true;
				}
			}
		}
		if (typedElement instanceof OperationCallExp) {
			Operation asOperation = ((OperationCallExp)typedElement).getReferredOperation();
			if (QVTbaseUtil.isIdentification(asOperation)) {
				//				DomainUsage usage = getScheduleManager(region).getDomainUsage(typedElement);
				//				if (!usage.isInput()) {
				isRealized = true;
				//				}
			}
		}
		if (isRealized) {
			return Role.REALIZED;
		}
		else if (isPredicated) {
			return Role.PREDICATED;
		}
		else if (isLoaded) {
			return Role.LOADED;
		}
		else {
			return Role.CONSTANT;
		}
	}

	public static @NonNull PropertyDatum getOpposite(@NonNull PropertyDatum propertyDatum) {
		return ClassUtil.nonNullState(propertyDatum.getOpposite());
	}

	public static @NonNull NavigationEdge getOppositeEdge(@NonNull NavigationEdge navigationEdge) {
		return ClassUtil.nonNullState(navigationEdge.getOppositeEdge());
	}

	public static @NonNull Iterable<@NonNull EdgeConnection> getOutgoingConnections(@NonNull NavigableEdge navigableEdge) {
		return ClassUtil.nullFree(navigableEdge.getOutgoingConnections());
	}

	public static @NonNull Iterable<@NonNull NodeConnection> getOutgoingConnections(@NonNull Node node) {
		return ClassUtil.nullFree(node.getOutgoingConnections());
	}

	public static @NonNull Iterable<@NonNull Edge> getOutgoingEdges(@NonNull Node node) {
		return ClassUtil.nullFree(node.getOutgoingEdges());
	}

	public static @NonNull Iterable<@NonNull ClassDatum> getOwnedClassDatums(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedClassDatums());
	}

	public static @NonNull Iterable<@NonNull Connection> getOwnedConnections(@NonNull RootRegion rootRegion) {
		return ClassUtil.nullFree(rootRegion.getOwnedConnections());
	}

	public static @NonNull Iterable<@NonNull Edge> getOwnedEdges(@NonNull Region region) {
		return ClassUtil.nullFree(region.getOwnedEdges());
	}

	public static @NonNull LoadingRegion getOwnedLoadingRegion(@NonNull RootRegion rootRegion) {
		return ClassUtil.nonNullState(rootRegion.getOwnedLoadingRegion());
	}

	public static @NonNull Iterable<@NonNull MappingPartition> getOwnedMappingPartitions(@NonNull CompositePartition composedPartition) {
		return ClassUtil.nullFree(composedPartition.getOwnedMappingPartitions());
	}

	public static @NonNull Iterable<@NonNull Node> getOwnedNodes(@NonNull Region region) {
		return ClassUtil.nullFree(region.getOwnedNodes());
	}

	public static @NonNull Iterable<@NonNull PropertyDatum> getOwnedPropertyDatums(@NonNull ClassDatum classDatum) {
		return ClassUtil.nullFree(classDatum.getOwnedPropertyDatums());
	}

	public static @NonNull Iterable<@NonNull MappingRegion> getOwnedMappingRegions(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedMappingRegions());
	}

	public static @NonNull Iterable<@NonNull OperationRegion> getOwnedOperationRegions(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedOperationRegions());
	}

	public static @NonNull Iterable<@NonNull RootRegion> getOwnedRootRegions(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedRootRegions());
	}

	public static @NonNull ClassDatum getOwningClassDatum(@NonNull PropertyDatum propertyDatum) {
		return ClassUtil.nonNullState(propertyDatum.getOwningClassDatum());
	}

	public static @NonNull Region getOwningRegion(@NonNull ConnectionEnd connectionEnd) {
		return ClassUtil.nonNullState(connectionEnd.getOwningRegion());
	}

	public static @NonNull Region getOwningRegion(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getOwningRegion());
	}

	public static RootRegion getOwningRootRegion(@NonNull RootPartition rootPartition) {
		return ClassUtil.nonNullState(rootPartition.getOwningRootRegion());
	}

	public static @NonNull ScheduleModel getOwningScheduleModel(@NonNull RootRegion rootRegion) {
		return ClassUtil.nonNullState(rootRegion.getOwningScheduleModel());
	}

	public static @NonNull Iterable<@NonNull Integer> getPasses(@NonNull Partition partition) {
		return ClassUtil.nullFree(partition.getPasses());
	}

	public static @NonNull NavigationEdge getPrimaryEdge(@NonNull NavigationEdge navigationEdge) {
		return navigationEdge.isSecondary() ? getOppositeEdge(navigationEdge) : navigationEdge;
	}

	/**
	 * Return the forward/reverse variant of property that is more easily navigable and therefore
	 * to be preferred. When both variants are equally navigable a deterministic name-based choice is made.
	 */
	public static @NonNull Property getPrimaryProperty(@NonNull Property property) {
		Property oppositeProperty = property.getOpposite();
		if (oppositeProperty == null) {			// No opposite - no choice to make
			return property;
		}
		if (oppositeProperty.isIsComposite()) {	// Container preferred
			assert !property.isIsMany();
			return property;
		}
		if (property.isIsComposite()) {			// Container preferred
			assert !oppositeProperty.isIsMany();
			return oppositeProperty;
		}
		if (property.isIsImplicit()) {			// Non-implicit preferred
			return oppositeProperty;
		}
		if (oppositeProperty.isIsImplicit()) {	// Non-implicit preferred
			return property;
		}
		if (property.isIsDerived() && !oppositeProperty.isIsDerived()) {	// choose non-derived
			return oppositeProperty;
		}
		if (!property.isIsDerived() && oppositeProperty.isIsDerived()) {	// choose non-derived
			return property;
		}
		if (property.isIsTransient() && !oppositeProperty.isIsTransient()) {	// choose non-transient
			return oppositeProperty;
		}
		if (!property.isIsTransient() && oppositeProperty.isIsTransient()) {	// choose non-transient
			return property;
		}
		if (property.isIsVolatile() && !oppositeProperty.isIsVolatile()) {	// choose non-volatile
			return oppositeProperty;
		}
		if (!property.isIsVolatile() && oppositeProperty.isIsVolatile()) {	// choose non-volatile
			return property;
		}
		if (property.isIsMany() && !oppositeProperty.isIsMany()) {			// 1:N - choose N:1
			return oppositeProperty;
		}
		if (!property.isIsMany() && oppositeProperty.isIsMany()) {			// N:1 - choose N:1
			return property;
		}
		// use name hierarchy
		EObject e1 = property;
		EObject e2 = oppositeProperty;
		while ((e1 != null) && (e2 != null)) {
			String n1 = e1 instanceof Nameable ? ((Nameable)e1).getName() : null;
			String n2 = e2 instanceof Nameable ? ((Nameable)e2).getName() : null;
			if ((n1 != null) || (n2 != null)) {
				if (n1 == null) {
					return oppositeProperty;
				}
				if (n2 == null) {
					return property;
				}
				int diff = n1.compareTo(n2);
				if (diff != 0) {
					return diff > 0 ? property : oppositeProperty;
				}
			}
			e1 = e1.eContainer();
			e2 = e2.eContainer();
		}
		if ((e1 != null) || (e2 != null)) {
			if (e1 == null) {
				return oppositeProperty;
			}
			if (e2 == null) {
				return property;
			}
		}
		// last resort - never happens - use hash codes
		int diff = System.identityHashCode(property) - System.identityHashCode(oppositeProperty);
		return diff >= 0 ? property : oppositeProperty;
	}

	//
	//	Commented out since getCompleteClass() is usually more appropriate.
	//
	//	public static org.eclipse.ocl.pivot.@NonNull Class getReferredClass(@NonNull ClassDatum classDatum) {
	//		return ClassUtil.nonNullState(classDatum.getReferredClass());
	//	}

	public static @NonNull Operation getReferredOperation(@NonNull OperationCallNode operationCallNode) {
		return ClassUtil.nonNullState(operationCallNode.getReferredOperation());		// FIXME should be declared as [1..1]
	}

	public static @NonNull PropertyDatum getReferredPart(@NonNull KeyPartEdge keyPartEdge) {
		return ClassUtil.nonNullState(keyPartEdge.getReferredPart());
	}

	public static @NonNull ShadowPart getReferredPart(@NonNull ShadowPartEdge shadowPartEdge) {
		return ClassUtil.nonNullState(shadowPartEdge.getReferredPart());
	}

	public static @NonNull Property getReferredProperty(@NonNull PropertyDatum propertyDatum) {
		return ClassUtil.nonNullState(propertyDatum.getReferredProperty());
	}

	public static @NonNull Rule getReferredRule(@NonNull RuleRegion ruleRegion) {
		return ClassUtil.nonNullState(ruleRegion.getReferredRule());
	}

	public static @NonNull Transformation getReferredTransformation(@NonNull RootRegion rootRegion) {
		return ClassUtil.nonNullState(rootRegion.getReferredTransformation());
	}

	public static @NonNull TypedModel getReferredTypedModel(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum.getReferredTypedModel());
	}

	public static @NonNull Region getRegion(@NonNull Partition partition) {
		return ClassUtil.nonNullState(partition.getRegion());
	}

	public static @NonNull Property getReferredProperty(@NonNull NavigationEdge navigationEdge) {
		return ClassUtil.nonNullState(navigationEdge.getReferredProperty());
	}

	public static @NonNull Iterable<@NonNull MappingPartition> getRegionPartitions(@NonNull Region region) {
		Iterable<@NonNull MappingPartition> sourceRegionPartitions;
		if (region instanceof LoadingRegion) {
			sourceRegionPartitions = Collections.singletonList(getLoadingPartition((LoadingRegion)region));
		}
		else if (region instanceof MappingRegion) {
			sourceRegionPartitions = getMappingPartitions((MappingRegion)region);
		}
		else {
			throw new UnsupportedOperationException();
		}
		return sourceRegionPartitions;
	}

	public static @Nullable Role getRole(@NonNull Partition partition, @NonNull ConnectionEnd connectionEnd) {
		return connectionEnd instanceof Node ? partition.getRole((Node)connectionEnd) : connectionEnd instanceof Edge ? partition.getRole((Edge)connectionEnd) : null;
	}

	public static @NonNull List<@NonNull NodeConnection> getRootConnections(@NonNull Partition partition) {
		return ClassUtil.nullFree(partition.getRootConnections());
	}

	public static @NonNull RootRegion getRootRegion(@NonNull Region region) {
		return ClassUtil.nonNullState(region.getRootRegion());
	}

	public static @NonNull ScheduleModel getScheduleModel(@NonNull Region region) {
		for (EObject eObject = region; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ScheduleModel) {
				return (ScheduleModel)eObject;
			}
		}
		return ClassUtil.nonNullState(null);
	}

	public static @NonNull List<@NonNull ConnectionEnd> getSourceEnds(@NonNull Connection connection) {
		return ClassUtil.nullFree(connection.getSourceEnds());
	}

	@SuppressWarnings("unchecked")
	public static @NonNull List<@NonNull NavigableEdge> getSourceEnds(@NonNull EdgeConnection connection) {
		return (List<@NonNull NavigableEdge>)(Object)ClassUtil.nullFree(connection.getSourceEnds());
	}

	@SuppressWarnings("unchecked")
	public static @NonNull List<@NonNull Node> getSourceEnds(@NonNull NodeConnection connection) {
		return (List<@NonNull Node>)(Object)ClassUtil.nullFree(connection.getSourceEnds());
	}

	public static @NonNull Node getSourceNode(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getSourceNode());
	}

	public static @NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum) {
		return ClassUtil.nullFree(classDatum.getSuperClassDatums());
	}

	@Deprecated /* @deprecated no longer used - cache too flaky, all candidates ssessed at consumption point */
	public static @NonNull Iterable<@NonNull PropertyDatum> getSuperPropertyDatums(@NonNull PropertyDatum propertyDatum) {
		return ClassUtil.nullFree(propertyDatum.getSuperPropertyDatums());
	}

	public static @NonNull Node getTargetNode(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getTargetNode());
	}

	public static @NonNull TypedModel getTypedModel(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum.getReferredTypedModel());
	}

	public static @NonNull TypedModel getTypedModel(@NonNull Node node) {
		return getTypedModel(getClassDatum(node));
	}

	//
	// FIXME this is a legacy compatiility supporting the obsolescence of TrueNode.
	//
	@Deprecated
	public static boolean hasPredicates(@NonNull Region mappingRegion) {
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (node.isConstant()) {
				for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(node)) {
					if (incomingEdge.isOld()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Return true if the target of thatEdge is compatible with the target of thisEdge.
	 */
	public static boolean isConformantTarget(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatTarget = thatEdge.getEdgeTarget();
		Node thisTarget = thisEdge.getEdgeTarget();
		ClassDatum thatType = getClassDatum(thatTarget);
		ClassDatum thisType = getClassDatum(thisTarget);
		if (conformsToClassOrBehavioralClass(thatType, thisType)) {
			return true;
		}
		if (thatTarget.isRealized()) {
			return false;
		}
		if (conformsToClassOrBehavioralClass(thisType, thatType)) {
			return true;
		}
		return false;
	}

	/*	public static boolean isRealizedIncludes(@NonNull Edge edge) {	// FIXME includes should be a pseudo-navigation edge
		if (!edge.isRealized()) {
			return false;
		}
		if (!edge.isComputation()) {
			return false;
		}
		return "«includes»".equals(edge.getName()) || "«includesAll»".equals(edge.getName());
	} */

	public static @NonNull Role mergeToLessKnownPhase(Role firstRole, Role secondRole) {
		if (firstRole == Role.REALIZED) {
			return firstRole;
		}
		else if (secondRole == Role.REALIZED) {
			return secondRole;
		}
		else if (firstRole == Role.PREDICATED){
			return firstRole;
		}
		else if (secondRole == Role.PREDICATED){
			return secondRole;
		}
		else if (firstRole == Role.SPECULATED){
			return Role.PREDICATED;
		}
		else if (secondRole == Role.SPECULATED){
			return Role.PREDICATED;
		}
		else if (firstRole == Role.LOADED) {
			return firstRole;
		}
		else if (secondRole == Role.LOADED) {
			return secondRole;
		}
		else if (firstRole == Role.CONSTANT) {
			return firstRole;
		}
		else if (secondRole == Role.CONSTANT) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}

	public static @NonNull Role mergeToMoreKnownPhase(@NonNull Role firstRole, @NonNull Role secondRole) {
		if (firstRole == Role.CONSTANT) {
			return firstRole;
		}
		else if (secondRole == Role.CONSTANT) {
			return secondRole;
		}
		else if (firstRole == Role.LOADED) {
			return firstRole;
		}
		else if (secondRole == Role.LOADED) {
			return secondRole;
		}
		else if (firstRole == Role.REALIZED) {
			return firstRole;
		}
		else if (secondRole == Role.REALIZED) {
			return secondRole;
		}
		else if (firstRole == Role.SPECULATED) {
			return firstRole;
		}
		else if (secondRole == Role.SPECULATED) {
			return secondRole;
		}
		else if (firstRole == Role.SPECULATION) {
			return firstRole;
		}
		else if (secondRole == Role.SPECULATION) {
			return secondRole;
		}
		else if (firstRole == Role.PREDICATED) {
			return firstRole;
		}
		else if (secondRole == Role.PREDICATED) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}

	/*	public static Node.@NonNull Utility mergeToStrongerUtility(Node.@NonNull Utility nodeUtility1, Node.@NonNull Utility nodeUtility2) {
		if (nodeUtility1 == Node.Utility.DISPATCH) {
			assert (nodeUtility2 == Node.Utility.DISPATCH);
			return Node.Utility.DISPATCH;
		}
		else if (nodeUtility1 == Node.Utility.TRACE) {
			assert (nodeUtility2 == Node.Utility.TRACE);
			return Node.Utility.TRACE;
		}
		else if ((nodeUtility1 == Node.Utility.STRONGLY_MATCHED) || (nodeUtility2 == Node.Utility.STRONGLY_MATCHED)) {
			return Node.Utility.STRONGLY_MATCHED;
		}
		else if ((nodeUtility1 == Node.Utility.WEAKLY_MATCHED) || (nodeUtility2 == Node.Utility.WEAKLY_MATCHED)) {
			return Node.Utility.WEAKLY_MATCHED;
		}
		else if ((nodeUtility1 == Node.Utility.CONDITIONAL) || (nodeUtility2 == Node.Utility.CONDITIONAL)) {
			return Node.Utility.CONDITIONAL;
		}
		else if ((nodeUtility1 == Node.Utility.DEPENDENCY) || (nodeUtility2 == Node.Utility.DEPENDENCY)) {
			return Node.Utility.DEPENDENCY;
		}
		else {
			return Node.Utility.DEAD;
		}
	} */

	public static @NonNull BinaryOperator<@NonNull String> stringJoin(@NonNull String delimiter) {
		return (a, b) -> String.valueOf(a) + delimiter + String.valueOf(b);
	}
}