/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.NumericLiteralExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IfNode;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.MapPartNode;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MergedPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NonPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowNode;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.InitUtility;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

import com.google.common.collect.Iterables;

/**
 * A RegionHelper provides stateless utility methods, mostly construction, for use within a Region
 * supervised by a ScheduleManager.
 */
public class RegionHelper<R extends Region> extends QVTscheduleUtil implements Nameable
{
	public static final @NonNull String EQUALS_NAME = "«equals»";
	public static final @NonNull String INCLUDES_NAME = "«includes»";
	public static final @NonNull String LOOP_ITERATOR_NAME = "«iterator»";

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull R region;

	public RegionHelper(@NonNull ScheduleManager scheduleManager, @NonNull R region) {
		this.scheduleManager = scheduleManager;
		this.region = region;
	}

	public @NonNull BasicPartition createBasicPartition(@NonNull String name, @NonNull Iterable<@NonNull Node> headNodes) {
		BasicPartition basicPartition = QVTscheduleFactory.eINSTANCE.createBasicPartition();
		basicPartition.setName(name);
		//	basicPartition.setRegion(region);
		((MappingRegion)region).getMappingPartitions().add(basicPartition);
		Iterables.addAll(QVTscheduleUtil.Internal.getHeadNodesList(basicPartition), headNodes);
		return basicPartition;
	}

	public @NonNull BooleanLiteralNode createBooleanLiteralNode(@NonNull InitUtility utility, boolean isTrue) {
		ClassDatum classDatum = scheduleManager.getBooleanClassDatum();
		BooleanLiteralNode booleanLiteralNode = QVTscheduleFactory.eINSTANCE.createBooleanLiteralNode();
		booleanLiteralNode.initialize(Role.CONSTANT, region, utility, Boolean.toString(isTrue), classDatum);
		booleanLiteralNode.setBooleanValue(isTrue);
		return booleanLiteralNode;
	}

	public @NonNull BooleanLiteralNode createBooleanLiteralNode(@NonNull InitUtility utility, boolean booleanValue, @Nullable BooleanLiteralExp booleanLiteralExp) {
		Role nodeRole = getOperationNodePhase(region, booleanLiteralExp);
		ClassDatum classDatum = scheduleManager.getBooleanClassDatum();
		BooleanLiteralNode booleanLiteralNode = QVTscheduleFactory.eINSTANCE.createBooleanLiteralNode();
		booleanLiteralNode.initialize(nodeRole, region, utility, Boolean.toString(booleanValue), classDatum);
		booleanLiteralNode.setBooleanValue(booleanValue);
		if (booleanLiteralExp != null) {
			booleanLiteralNode.setOriginatingElement(booleanLiteralExp);
		}
		return booleanLiteralNode;
	}

	public @NonNull CastEdge createCastEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull ClassDatum classDatum, @NonNull Node targetNode) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		Role edgeRole = phase;
		CastEdge castEdge = QVTscheduleFactory.eINSTANCE.createCastEdge();
		castEdge.initialize(edgeRole, utility, sourceNode, classDatum, targetNode);
		return castEdge;
	}

	public @NonNull CollectionLiteralNode createCollectionLiteralNode(@NonNull InitUtility utility, @NonNull String name, @NonNull CollectionLiteralExp collectionLiteralExp, @NonNull Node @NonNull [] partNodes) {
		Role nodeRole = getOperationNodePhase(region, collectionLiteralExp, partNodes);
		CollectionLiteralNode node = QVTscheduleFactory.eINSTANCE.createCollectionLiteralNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(collectionLiteralExp));
		node.setOriginatingElement(collectionLiteralExp);
		return node;
	}

	public @NonNull Edge createCollectionPartEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull CollectionLiteralPart collectionPart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		CollectionPartEdge edge = QVTscheduleFactory.eINSTANCE.createCollectionPartEdge();
		edge.setReferredPart(collectionPart);
		String partName = collectionPart.getName();			// Always null
		String label = partName != null ? "«" + partName + "»" : "«part»";
		edge.initialize(edgeRole, utility, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull CollectionRangeNode createCollectionRangeNode(@NonNull InitUtility utility, @NonNull String name, @NonNull CollectionRange collectionRange, @NonNull Node @NonNull [] argNodes) {
		Role nodeRole = getOperationNodePhase(region, collectionRange, argNodes);
		CollectionRangeNode node = QVTscheduleFactory.eINSTANCE.createCollectionRangeNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(collectionRange));
		node.setOriginatingElement(collectionRange);
		return node;
	}

	/** FIXME make non-static */
	public static @NonNull CyclicPartition createCyclicPartition(@NonNull String name, @NonNull Object scheduleManager) {
		CyclicPartition cyclicPartition = QVTscheduleFactory.eINSTANCE.createCyclicPartition();
		cyclicPartition.setName(name);
		//		cyclicPartition.setRegion(region);
		//		Iterables.addAll(cyclicPartition.getHeadNodes(), headNodes);
		return cyclicPartition;
	}

	public @NonNull Node createDataTypeNode(@NonNull InitUtility utility, @NonNull String name, @NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		Property property = PivotUtil.getReferredProperty(navigationCallExp);
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		assert sourceNode.isClass() || (property.getOpposite() != null);	// FIXME review is this relevant?
		//		String name = property.getName();
		//		assert name != null;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(navigationCallExp));
		node.setOriginatingElement(navigationCallExp);
		return node;
	}

	public @NonNull Node createDataTypeNode(@NonNull InitUtility utility, @NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
		Role nodeRole = getNodeRole(targetNode);
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		//		PatternNodeRole nodeRole = PatternNodeRole.getDataTypeNodeRole(targetNode, property);
		//		assert sourceNode.isClass();	// FIXME review is this relevant?
		String name = property.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = getTypedModel(targetNode);
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, type);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, utility, name, classDatum);
		node.setOriginatingElement(property);
		return node;
	}

	public @NonNull Node createDataTypeNode(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Property property) {
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		return createPatternNode(nodeRole, utility, sourceNode, property);
	}

	public @NonNull Node createDependencyClassNode(@NonNull InitUtility utility, @NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		assert parentNode.isClass();
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		assert property != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = getTypedModel(parentNode);
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, type);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		String name = property.getName();
		assert name != null;
		return createDependencyNode(utility, name, classDatum);
	}

	public @NonNull Edge createDependencyEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		DependencyEdge edge = QVTscheduleFactory.eINSTANCE.createDependencyEdge();
		edge.initialize(edgeRole, utility, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createDependencyNode(@NonNull InitUtility utility, @NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.PREDICATED;
		DependencyNode node = QVTscheduleFactory.eINSTANCE.createDependencyNode();
		node.initialize(nodeRole, region, utility, name, classDatum);
		return node;
	}

	/**
	 * Create, install and return the edgeRole edge for source2targetProperty from sourceNode to targetNode. If
	 * source2targetProperty has an opposite, the opposite edge is also created and installed.
	 *
	public @NonNull NavigableEdge createEdge(@NonNull Role edgeRole,
			@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		CastEdge castEdge = QVTscheduleFactory.eINSTANCE.createCastEdge();
		castEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		castEdge.initializeProperty(source2targetProperty);
		return castEdge;
	} */

	public @NonNull EnumLiteralNode createEnumLiteralNode(@NonNull InitUtility utility, @NonNull EnumerationLiteral enumValue, @NonNull EnumLiteralExp enumLiteralExp) {
		ClassDatum classDatum = scheduleManager.getClassDatum(enumLiteralExp);
		String typeName = PrettyPrinter.printType(enumValue);
		Role nodeRole = getOperationNodePhase(region, enumLiteralExp);
		EnumLiteralNode enumLiteralNode = QVTscheduleFactory.eINSTANCE.createEnumLiteralNode();
		enumLiteralNode.initialize(nodeRole, region, utility, typeName, classDatum);
		enumLiteralNode.setEnumValue(enumValue);
		enumLiteralNode.setOriginatingElement(enumLiteralExp);
		return enumLiteralNode;
	}

	//
	//	equals edges seem to be a legacy relic. They are used to equate two nodes that have been carelessly created as distinct. The difficulties
	//	of ensuring that downstream code accommodates the duality far outweight the difficulties of creating a single node in the first place.
	//
	//	This method is not used by any tests, but one anticipated usage arises if a variable has multiple initializers,
	//	and/or multiple predicates, in which case a hard initializer such as an operation call is preferred,
	//	and then other initializers are checked as predicates using equals edges.
	//
	public @NonNull Edge createEqualsEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Node targetNode) {
		if (!region.isOperationRegion()) {
			QVTruntimeUtil.errPrintln("Unexpected " + EQUALS_NAME + " edge in " + region + " from " + sourceNode + " to " + targetNode);
		}
		//		Role edgeRole = getNodeRole(sourceNode);
		//		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createEqualsEdge();
		//		edge.initialize(edgeRole, sourceNode, QVTscheduleConstants.EQUALS_NAME, targetNode);
		//		return edge;
		return createPredicateEdge(utility, sourceNode, EQUALS_NAME, targetNode);
	}

	public @NonNull Node createErrorNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.OTHER;
		ErrorNode node = QVTscheduleFactory.eINSTANCE.createErrorNode();
		node.initialize(nodeRole, region, InitUtility.NOT_KNOWN, name, classDatum);
		return node;
	}

	public @NonNull IfNode createIfNode(@NonNull InitUtility utility, @NonNull String name, @NonNull IfExp ifExp, @NonNull Node @NonNull [] argNodes) {
		Role nodeRole = getOperationNodePhase(region, ifExp, argNodes);
		IfNode node = QVTscheduleFactory.eINSTANCE.createIfNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(ifExp));
		node.setOriginatingElement(ifExp);
		return node;
	}
	public @NonNull IfNode createIfNode2(@NonNull InitUtility utility, @NonNull String name, @NonNull ClassDatum classDatum, @NonNull Node @NonNull [] argNodes) {
		Role nodeRole = getOperationNodePhase(region, null, argNodes);
		IfNode node = QVTscheduleFactory.eINSTANCE.createIfNode();
		node.initialize(nodeRole, region, utility, name, classDatum);
		return node;
	}

	public @NonNull Node createInputNode(@NonNull InitUtility utility, @NonNull Role nodeRole, @NonNull String name, @NonNull ClassDatum classDatum) {
		InputNode node = QVTscheduleFactory.eINSTANCE.createInputNode();
		node.initialize(nodeRole, region, utility, name, classDatum);
		return node;
	}

	public @NonNull Edge createIteratedEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		IteratedEdge edge = QVTscheduleFactory.eINSTANCE.createIteratedEdge();
		edge.initialize(edgeRole, utility, sourceNode, LOOP_ITERATOR_NAME, targetNode);
		return edge;
	}

	public @NonNull VariableNode createIteratorNode(@NonNull InitUtility utility, @NonNull VariableDeclaration iterator, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		IteratorNode node = QVTscheduleFactory.eINSTANCE.createIteratorNode();
		node.initialize(nodeRole, region, utility, getName(iterator), scheduleManager.getClassDatum(iterator));
		node.initializeVariable(region, iterator);
		return node;
	}

	public @NonNull Edge createKeyPartEdge(@NonNull InitUtility initUtility, @NonNull Node sourceNode, @NonNull PropertyDatum propertyDatum, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		KeyPartEdge edge = QVTscheduleFactory.eINSTANCE.createKeyPartEdge();
		edge.setReferredPart(propertyDatum);
		Property referredProperty = QVTscheduleUtil.getReferredProperty(propertyDatum);
		String name = "«" + QVTrelationUtil.getName(referredProperty) + "»";
		edge.initialize(edgeRole, initUtility, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createKeyedNode(@NonNull InitUtility utility, @NonNull String name, @NonNull VariableDeclaration templateVariable) {
		ClassDatum classDatum = scheduleManager.getClassDatum(templateVariable);
		KeyedValueNode node = QVTscheduleFactory.eINSTANCE.createKeyedValueNode();
		node.setClassDatumValue(classDatum);
		node.initialize(Role.REALIZED, region, utility, name, classDatum);
		region.addVariableNode(templateVariable, node);
		//		node.addTypedElement(templateVariable);
		return node;
	}

	public @NonNull VariableNode createLetVariableNode(@NonNull InitUtility utility, @NonNull VariableDeclaration letVariable, @NonNull Node inNode) {
		Role nodeRole = getNodeRole(inNode);
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, utility, getName(letVariable), scheduleManager.getClassDatum(letVariable));
		node.initializeVariable(region, letVariable);
		return node;
	}

	public @NonNull VariableNode createLoadedStepNode(@NonNull InitUtility utility, @NonNull VariableDeclaration stepVariable) {
		Role nodeRole = Role.LOADED;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, utility, getName(stepVariable), scheduleManager.getClassDatum(stepVariable));
		node.initializeVariable(region, stepVariable);
		return node;
	}

	public @NonNull LoadingPartition createLoadingPartition() {
		LoadingPartition loadingPartition = QVTscheduleFactory.eINSTANCE.createLoadingPartition();
		loadingPartition.setName(region.getName());
		//	loadingPartition.setRegion(region);
		((LoadingRegion)region).setLoadingPartition(loadingPartition);
		//		Iterables.addAll(loadingPartition.getHeadNodes(), headNodes);
		return loadingPartition;
	}

	public @NonNull MapLiteralNode createMapLiteralNode(@NonNull InitUtility utility, @NonNull String name, @NonNull MapLiteralExp mapLiteralExp, @NonNull Node @NonNull [] partNodes) {
		Role nodeRole = getOperationNodePhase(region, mapLiteralExp, partNodes);
		MapLiteralNode node = QVTscheduleFactory.eINSTANCE.createMapLiteralNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(mapLiteralExp));
		node.setOriginatingElement(mapLiteralExp);
		return node;
	}

	public @NonNull Edge createMapPartEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull MapLiteralPart mapPart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		MapPartEdge edge = QVTscheduleFactory.eINSTANCE.createMapPartEdge();
		edge.setReferredPart(mapPart);
		String label = "«" + mapPart.toString() + "»";
		edge.initialize(edgeRole, utility, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull Node createMapPartNode(@NonNull InitUtility utility, @NonNull String name, @NonNull MapLiteralPart mapLiteralPart, @NonNull Node @NonNull [] argNodes) {
		TypedElement typedElement = QVTbaseUtil.getOwnedValue(mapLiteralPart);		// FIXME delete this
		Role nodeRole = getOperationNodePhase(region, typedElement, argNodes);
		MapPartNode node = QVTscheduleFactory.eINSTANCE.createMapPartNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(typedElement));
		node.setOriginatingElement(mapLiteralPart);
		return node;
	}

	public @NonNull MergedPartition createMergedPartition(@NonNull String name, @NonNull Iterable<@NonNull Node> headNodes) {
		MergedPartition mergedPartition = QVTscheduleFactory.eINSTANCE.createMergedPartition();
		mergedPartition.setName(name);
		//	basicPartition.setRegion(region);
		((MappingRegion)region).getMappingPartitions().add(mergedPartition);
		Iterables.addAll(QVTscheduleUtil.Internal.getHeadNodesList(mergedPartition), headNodes);
		return mergedPartition;
	}

	public @NonNull NavigableEdge createNavigationEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, boolean isPartial) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		return createNavigationEdge(phase, utility, sourceNode, source2targetProperty, targetNode, isPartial);
	}

	public @NonNull NavigableEdge createNavigationEdge(@NonNull Role edgeRole, @NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, boolean isPartial) {
		NavigationEdge edge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		edge.initialize(edgeRole, utility, sourceNode, source2targetProperty.getName(), targetNode);
		edge.initializeProperty(source2targetProperty, utility, isPartial);
		return edge;
	}

	public @NonNull NonPartition createNonPartition(@NonNull String name) {
		NonPartition nonPartition = QVTscheduleFactory.eINSTANCE.createNonPartition();
		nonPartition.setName(name);
		//	nonPartition.setRegion(region);
		((MappingRegion)region).getMappingPartitions().add(nonPartition);
		//		Iterables.addAll(nonPartition.getHeadNodes(), headNodes);
		return nonPartition;
	}

	public @NonNull Node createNullLiteralNode(@NonNull InitUtility utility, @Nullable NullLiteralExp nullLiteralExp) {
		Role nodeRole = Role.CONSTANT;
		ClassDatum classDatum;
		if (nullLiteralExp != null) {
			classDatum = scheduleManager.getClassDatum(nullLiteralExp);
		}
		else {
			classDatum = scheduleManager.getOclVoidClassDatum();
		}
		NullLiteralNode node = QVTscheduleFactory.eINSTANCE.createNullLiteralNode();
		node.initialize(nodeRole, region, utility, "«null»", classDatum);
		if (nullLiteralExp != null) {
			node.setOriginatingElement(nullLiteralExp);
		}
		return node;
	}

	public @NonNull NumericLiteralNode createNumericLiteralNode(@NonNull InitUtility utility, @NonNull Number numericValue, @NonNull NumericLiteralExp numericLiteralExp) {
		Role nodeRole = getOperationNodePhase(region, numericLiteralExp);
		NumericLiteralNode node = QVTscheduleFactory.eINSTANCE.createNumericLiteralNode();
		node.initialize(nodeRole, region, utility, numericValue.toString(), scheduleManager.getClassDatum(numericLiteralExp));
		node.setNumericValue(numericValue);
		node.setOriginatingElement(numericLiteralExp);
		return node;
	}

	public @NonNull VariableNode createOldNode(@NonNull InitUtility utility, @NonNull VariableDeclaration variable) {
		Role nodeRole;
		boolean isThis = QVTbaseUtil.isThis(variable);
		if (isThis) {
			nodeRole = Role.LOADED;
		}
		else if (scheduleManager.isInput(scheduleManager.getDomainUsage(variable))) {
			nodeRole = Role.LOADED;
		}
		else {
			nodeRole = Role.PREDICATED;
		}
		ClassDatum classDatum = scheduleManager.getClassDatum(variable);
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, utility, getName(variable), classDatum);
		node.initializeVariable(region, variable);
		//	node.setMatched(QVTrelationUtil.isRequired(variable));
		if (isThis) {
			node.setThis();
			node.setHead();
		}
		return node;
	}

	public @NonNull OperationCallNode createOperationCallNode(@NonNull InitUtility utility, @Nullable String nameHint, @NonNull Operation operation, @NonNull TypedElement callExpOrCollectionTemplateExp, @NonNull Node ... argNodes) {
		String name = nameHint;
		if (name == null) {
			name = QVTbaseUtil.getName(operation);
		}
		Role nodeRole = getOperationNodePhase(region, callExpOrCollectionTemplateExp, argNodes);
		OperationCallNode node = QVTscheduleFactory.eINSTANCE.createOperationCallNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(callExpOrCollectionTemplateExp));
		node.setOriginatingElement(callExpOrCollectionTemplateExp);
		node.setReferredOperation(operation);
		return node;
	}
	public @NonNull OperationCallNode createOperationCallNode2(@NonNull Role nodeRole, @NonNull InitUtility utility, @Nullable String nameHint, @NonNull Operation operation, @NonNull ClassDatum classDatum, @NonNull Node ... argNodes) {
		String name = nameHint;
		if (name == null) {
			name = QVTbaseUtil.getName(operation);
		}
		assert nodeRole != null;
		OperationCallNode node = QVTscheduleFactory.eINSTANCE.createOperationCallNode();
		node.initialize(nodeRole, region, utility, name, classDatum);
		node.setReferredOperation(operation);
		return node;
	}

	public @NonNull Edge createOperationParameterEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Parameter parameter, int parameterIndex, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		String name;
		OperationParameterEdge edge = QVTscheduleFactory.eINSTANCE.createOperationParameterEdge();
		edge.setReferredParameter(parameter);
		if (parameterIndex >= 0) {
			//				assert parameter.isIsMany();
			edge.setParameterIndex(parameterIndex);
			name = "«" + parameter.getName() + "-" + parameterIndex + "»";
		}
		else {
			//				assert !parameter.isIsMany();
			name = "«" + parameter.getName() + "»";
		}
		//		edge.setReferredObject(typeOrParameter);		// FIXME redundant
		edge.initialize(edgeRole, utility, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Edge createOperationSelfEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Type type, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		OperationSelfEdge edge = QVTscheduleFactory.eINSTANCE.createOperationSelfEdge();
		edge.setReferredType(type);
		String name = "«" + PivotConstants.SELF_NAME + "»";
		//		edge.setReferredObject(typeOrParameter);		// FIXME redundant
		edge.initialize(edgeRole, utility, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createPatternNode(@NonNull Role nodeRole, @NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		assert sourceNode.isClass();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)source2targetProperty.getType();
		assert type != null;
		Type elementType = PivotUtil.getElementalType(type);
		TypedModel typedModel = elementType instanceof DataType ? scheduleManager.getDomainUsageAnalysis().getPrimitiveTypedModel() : sourceNode.getClassDatum().getReferredTypedModel();
		assert typedModel != null;
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, type);
		String name = source2targetProperty.getName();
		assert name != null;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, utility, name, classDatum);
		return node;
	}

	public @NonNull Edge createPredicateEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		PredicateEdge edge = QVTscheduleFactory.eINSTANCE.createPredicateEdge();
		edge.initialize(edgeRole, utility, sourceNode, name, targetNode);
		return edge;
	}

	/*	public @NonNull NavigableEdge createPredicatedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Role edgeRole = Role.PREDICATED;
		NavigationEdge forwardEdge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		forwardEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		boolean isPartial2 = QVTscheduleUtil.computeIsPartial(QVTscheduleUtil.getClassDatum(QVTscheduleUtil.getTargetNode(forwardEdge)), source2targetProperty, isPartial);
		forwardEdge.initializeProperty(source2targetProperty, isPartial2);
		return forwardEdge;
	} */

	public @NonNull Node createPredicatedNode(@NonNull InitUtility utility, @NonNull String name, @NonNull ClassDatum classDatum) {
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(Role.PREDICATED, region, utility, name, classDatum);
		return node;
	}

	public @NonNull Node createPredicatedStepNode(@NonNull InitUtility utility, @NonNull Node typedNode) {
		String name = getName(typedNode);
		ClassDatum classDatum = getClassDatum(typedNode);
		return createPredicatedNode(utility, name, classDatum);
	}

	/**
	 * Create a predicated source2targetProperty success edge from sourceNode to a true/false BooleanValueNode.
	 */
	public @NonNull SuccessEdge createPredicatedSuccess(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @Nullable Boolean isSuccess) {
		Node successNode;
		if (isSuccess != null) {
			successNode = createBooleanLiteralNode(utility, isSuccess, null);
		}
		else {
			successNode = createPredicatedNode(utility, "matches", scheduleManager.getBooleanClassDatum());
		}
		SuccessEdge edge = QVTscheduleFactory.eINSTANCE.createSuccessEdge();
		edge.initialize(Role.PREDICATED, utility, sourceNode, source2targetProperty.getName(), successNode);
		edge.initializeProperty(source2targetProperty, utility, false);
		return edge;
	}

	public @NonNull Node createRealizedDataTypeNode(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		Role nodeRole = Role.REALIZED;
		return createPatternNode(nodeRole, utility, sourceNode, source2targetProperty);
	}

	public @NonNull Edge createRealizedIncludesEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Node targetNode) {
		Role edgeRole = Role.REALIZED;
		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createIncludesEdge();
		edge.initialize(edgeRole, utility, sourceNode, INCLUDES_NAME, targetNode);
		return edge;
	}

	public @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, boolean isPartial) {
		Role edgeRole = Role.REALIZED;
		NavigationEdge forwardEdge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		forwardEdge.initialize(edgeRole, utility, sourceNode, source2targetProperty.getName(), targetNode);
		forwardEdge.initializeProperty(source2targetProperty, utility, isPartial);
		return forwardEdge;
	}

	public @NonNull VariableNode createRealizedNode(@NonNull InitUtility utility, @NonNull String name, @NonNull ClassDatum classDatum) {
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(Role.REALIZED, region, utility, name, classDatum);
		return node;
	}

	public @NonNull VariableNode createRealizedStepNode(@NonNull InitUtility initUtility, @NonNull VariableDeclaration stepVariable) {
		VariableNode node = createRealizedNode(initUtility, getName(stepVariable), scheduleManager.getClassDatum(stepVariable));
		node.initializeVariable(region, stepVariable);
		return node;
	}

	/**
	 * Create a realized source2targetProperty success edge from sourceNode to a true/false BooleanValueNode if isSuccesss is  non-null,
	 * else to a SuccessNode.
	 */
	public @NonNull SuccessEdge createRealizedSuccess(@NonNull InitUtility initUtility, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @Nullable Boolean isSuccess) {
		ClassDatum classDatum = scheduleManager.getBooleanClassDatum();
		Node node;
		if (isSuccess != null) {
			node = createBooleanLiteralNode(initUtility, isSuccess, null);
		}
		else {
			SuccessNode successNode = QVTscheduleFactory.eINSTANCE.createSuccessNode();
			successNode.initialize(Role.REALIZED, region, InitUtility.SUCCESS, "«success»", classDatum);
			node = successNode;
		}
		SuccessEdge edge = QVTscheduleFactory.eINSTANCE.createSuccessEdge();
		edge.initialize(Role.REALIZED, initUtility, sourceNode, source2targetProperty.getName(), node);
		edge.initializeProperty(source2targetProperty, initUtility, false);
		return edge;
	}

	/** FIXME make non-static */
	public static @NonNull RootPartition createRootPartition(@NonNull String name, @NonNull Object scheduleManager) {
		RootPartition rootPartition = QVTscheduleFactory.eINSTANCE.createRootPartition();
		rootPartition.setName(name);
		//		rootPartition.setRegion(region);
		//		Iterables.addAll(rootPartition.getHeadNodes(), headNodes);
		return rootPartition;
	}

	/*	public @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		Role edgeRole = Role.OTHER;
		RecursionEdge edge = QVTscheduleFactory.eINSTANCE.createRecursionEdge();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.setPrimary(isPrimary);
		return edge;
	} */

	public @NonNull ShadowNode createShadowNode(@NonNull InitUtility utility, @NonNull String name, @NonNull ShadowExp shadowExp, @NonNull Node @NonNull [] partNodes) {
		Role nodeRole = getOperationNodePhase(region, shadowExp, partNodes);
		ShadowNode node = QVTscheduleFactory.eINSTANCE.createShadowNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(shadowExp));
		node.setOriginatingElement(shadowExp);
		return node;
	}

	public @NonNull Edge createShadowPartEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull ShadowPart shadowPart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		ShadowPartEdge edge = QVTscheduleFactory.eINSTANCE.createShadowPartEdge();
		edge.setReferredPart(shadowPart);
		String label = "«" + shadowPart.getName() + "»";
		edge.initialize(edgeRole, utility, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull Node createStepNode(@NonNull InitUtility utility, @NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
		DomainUsage domainUsage = scheduleManager.getDomainUsage(callExp);
		boolean isMiddleOrOutput = scheduleManager.isOutputInRule(QVTbaseUtil.getContainingRule(callExp), callExp) || domainUsage.isMiddle();
		boolean isDirty = false;
		if (callExp instanceof NavigationCallExp) {
			Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
			isDirty = scheduleManager.isDirty(referredProperty);
		}
		Role phase = /*sourceNode.isPredicated() ||*/ isMiddleOrOutput || isDirty ? Role.PREDICATED : Role.LOADED;
		Role stepNodeRole = phase;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(stepNodeRole, region, utility, name, scheduleManager.getClassDatum(callExp));
		node.setOriginatingElement(callExp);
		return node;
	}

	/*	public @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		Role edgeRole = Role.OTHER;
		RecursionEdge edge = QVTscheduleFactory.eINSTANCE.createRecursionEdge();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.setPrimary(isPrimary);
		return edge;
	} */

	public @NonNull StringLiteralNode createStringLiteralNode(@NonNull InitUtility utility, @NonNull String stringValue, @NonNull StringLiteralExp stringLiteralExp) {
		Role nodeRole = getOperationNodePhase(region, stringLiteralExp);
		StringLiteralNode node = QVTscheduleFactory.eINSTANCE.createStringLiteralNode();
		node.initialize(nodeRole, region, utility, stringValue, scheduleManager.getClassDatum(stringLiteralExp));
		node.setStringValue(stringValue);
		node.setOriginatingElement(stringLiteralExp);
		return node;
	}

	public @NonNull TupleLiteralNode createTupleLiteralNode(@NonNull InitUtility utility, @NonNull String name, @NonNull TupleLiteralExp tupleLiteralExp, @NonNull Node @NonNull [] partNodes) {
		Role nodeRole = getOperationNodePhase(region, tupleLiteralExp, partNodes);
		TupleLiteralNode node = QVTscheduleFactory.eINSTANCE.createTupleLiteralNode();
		node.initialize(nodeRole, region, utility, name, scheduleManager.getClassDatum(tupleLiteralExp));
		node.setOriginatingElement(tupleLiteralExp);
		return node;
	}

	public @NonNull Edge createTuplePartEdge(@NonNull InitUtility utility, @NonNull Node sourceNode, @NonNull TupleLiteralPart tuplePart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		TuplePartEdge edge = QVTscheduleFactory.eINSTANCE.createTuplePartEdge();
		edge.setReferredPart(tuplePart);
		String label = "«" + tuplePart.getName() + "»";
		edge.initialize(edgeRole, utility, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull TypeLiteralNode createTypeLiteralNode(@NonNull InitUtility utility, @NonNull Type typeValue, @NonNull TypeExp typeExp) {
		ClassDatum classDatum = scheduleManager.getClassDatum(typeExp);
		//		String typeName = PrettyPrinter.printType(QVTscheduleUtil.getCompleteClass(classDatum));
		Role nodeRole = getOperationNodePhase(region, typeExp);
		TypeLiteralNode typeLiteralNode = QVTscheduleFactory.eINSTANCE.createTypeLiteralNode();
		typeLiteralNode.initialize(nodeRole, region, utility, String.valueOf(typeValue), classDatum);
		typeLiteralNode.setTypeValue(typeValue);
		typeLiteralNode.setOriginatingElement(typeExp);
		return typeLiteralNode;
	}

	public @NonNull Node createUnknownNode(@NonNull String name, @NonNull TypedElement typedElement) {
		Role nodeRole = Role.OTHER;
		UnknownNode node = QVTscheduleFactory.eINSTANCE.createUnknownNode();
		node.initialize(nodeRole, region, InitUtility.NOT_KNOWN, name, scheduleManager.getClassDatum(typedElement));
		return node;
	}

	@Override
	public @NonNull String getName() {
		return QVTscheduleUtil.getName(region);
	}

	protected @NonNull Role getPatternNodeRole(@NonNull Node sourceNode, @NonNull Property property) {
		Role phase;
		switch (getNodeRole(sourceNode)) {
			case REALIZED: phase = Role.REALIZED; break;
			case PREDICATED: phase = Role.PREDICATED; break;
			case LOADED: {
				boolean isDirty = scheduleManager.isDirty(property);
				phase = isDirty ? Role.PREDICATED : Role.LOADED; break;
			}
			case CONSTANT_SUCCESS_FALSE: /* fall through */
			case CONSTANT_SUCCESS_TRUE: /* fall through */
			case CONSTANT: phase = Role.CONSTANT; break;
			default: throw new UnsupportedOperationException();
		}
		return phase;
	}

	public @NonNull ProblemHandler getProblemHandler() {
		return scheduleManager.getProblemHandler();
	}

	public @NonNull R getRegion() {
		return region;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	@SuppressWarnings("null")
	@Override
	public String toString() {
		@Nullable R region2 = region;
		return region2 != null ? region2.toString() : super.toString();
	}
}