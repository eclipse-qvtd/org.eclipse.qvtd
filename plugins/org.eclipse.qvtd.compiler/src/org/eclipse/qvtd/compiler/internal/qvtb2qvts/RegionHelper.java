package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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

	public @NonNull BooleanLiteralNode createBooleanValueNode(boolean isTrue) {
		ClassDatum classDatum = scheduleManager.getBooleanClassDatum();
		BooleanLiteralNode booleanValueNode = QVTscheduleFactory.eINSTANCE.createBooleanLiteralNode();
		booleanValueNode.initialize(Role.CONSTANT, region, Boolean.toString(isTrue), classDatum);
		booleanValueNode.setMatched(true);
		booleanValueNode.setBooleanValue(isTrue);
		return booleanValueNode;
	}

	public @NonNull NavigableEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		Role edgeRole = phase;
		CastEdge castEdge = QVTscheduleFactory.eINSTANCE.createCastEdge();
		castEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		castEdge.initializeProperty(source2targetProperty);
		return castEdge;
	}

	public @NonNull Edge createCollectionPartEdge(@NonNull Node sourceNode, @NonNull CollectionLiteralPart collectionPart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		CollectionPartEdge edge = QVTscheduleFactory.eINSTANCE.createCollectionPartEdge();
		edge.setReferredPart(collectionPart);
		String label = "«" + collectionPart.getName() + "»";
		edge.initialize(edgeRole, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull Node createDataTypeNode(@NonNull String name, @NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		Property property = PivotUtil.getReferredProperty(navigationCallExp);
		boolean isMatched = sourceNode.isMatched() && isMatched(property);
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		assert sourceNode.isClass() || (property.getOpposite() != null);	// FIXME review is this relevant?
		//		String name = property.getName();
		//		assert name != null;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(navigationCallExp));
		node.setMatched(isMatched);
		node.addTypedElement(navigationCallExp);
		return node;
	}

	public @NonNull Node createDataTypeNode(@NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
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
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(true);
		node.addTypedElement(property);
		return node;
	}

	public @NonNull Node createDataTypeNode(@NonNull Node sourceNode, @NonNull Property property) {
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		return createPatternNode(nodeRole, sourceNode, property, sourceNode.isMatched() && isMatched(property));
	}

	public @NonNull Node createDependencyClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
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
		return createDependencyNode(name, classDatum);
	}

	public @NonNull Edge createDependencyEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		DependencyEdge edge = QVTscheduleFactory.eINSTANCE.createDependencyEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createDependencyNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.PREDICATED;
		DependencyNode node = QVTscheduleFactory.eINSTANCE.createDependencyNode();
		node.initialize(nodeRole, region, name, classDatum);
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

	//
	//	equals edges seem to be a legacy relic. They are used to equate two nodes that have been carelessly created as distinct. The difficulties
	//	of ensuring that downstream code accommodates the duality far outweight the difficulties of creating a single node in the first place.
	//
	//	This method is not used by any tests, but one anticipated usage arises if a variable has multiple initializers,
	//	and/or multiple predicates, in which case a hard initializer such as an operation call is preferred,
	//	and then other initializers are checked as predicates using equals edges.
	//
	public @NonNull Edge createEqualsEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		System.err.println("Unexpected " + EQUALS_NAME + " edge in " + region + " from " + sourceNode + " to " + targetNode);
		//		Role edgeRole = getNodeRole(sourceNode);
		//		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createEqualsEdge();
		//		edge.initialize(edgeRole, sourceNode, QVTscheduleConstants.EQUALS_NAME, targetNode);
		//		return edge;
		return createPredicateEdge(sourceNode, EQUALS_NAME, targetNode);
	}

	public @NonNull Node createErrorNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.OTHER;
		ErrorNode node = QVTscheduleFactory.eINSTANCE.createErrorNode();
		node.initialize(nodeRole, region, name, classDatum);
		return node;
	}

	public @NonNull Node createInputNode(@NonNull Role nodeRole, @NonNull String name, @NonNull ClassDatum classDatum) {
		InputNode node = QVTscheduleFactory.eINSTANCE.createInputNode();
		node.initialize(nodeRole, region, name, classDatum);
		return node;
	}

	public @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		IteratedEdge edge = QVTscheduleFactory.eINSTANCE.createIteratedEdge();
		edge.initialize(edgeRole, sourceNode, LOOP_ITERATOR_NAME, targetNode);
		return edge;
	}

	public @NonNull VariableNode createIteratorNode(@NonNull VariableDeclaration iterator, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		IteratorNode node = QVTscheduleFactory.eINSTANCE.createIteratorNode();
		node.initialize(nodeRole, region, getName(iterator), scheduleManager.getClassDatum(iterator));
		node.initializeVariable(region, iterator);
		return node;
	}

	public @NonNull Edge createKeyPartEdge(@NonNull Node sourceNode, @NonNull PropertyDatum propertyDatum, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		KeyPartEdge edge = QVTscheduleFactory.eINSTANCE.createKeyPartEdge();
		edge.setReferredPart(propertyDatum);
		Property referredProperty = QVTscheduleUtil.getReferredProperty(propertyDatum);
		String name = "«" + QVTrelationUtil.getName(referredProperty) + "»";
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createKeyedNode(boolean isMatched, @NonNull String name, @NonNull VariableDeclaration templateVariable) {
		ClassDatum classDatum = scheduleManager.getClassDatum(templateVariable);
		KeyedValueNode node = QVTscheduleFactory.eINSTANCE.createKeyedValueNode();
		node.setClassDatumValue(classDatum);
		node.initialize(Role.REALIZED, region, name, classDatum);
		region.addVariableNode(templateVariable, node);
		node.setMatched(isMatched);
		//		node.addTypedElement(templateVariable);
		return node;
	}

	public @NonNull VariableNode createLetVariableNode(@NonNull VariableDeclaration letVariable, @NonNull Node inNode) {
		Role nodeRole = getNodeRole(inNode);
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(letVariable), scheduleManager.getClassDatum(letVariable));
		node.initializeVariable(region, letVariable);
		node.setMatched(inNode.isMatched());
		return node;
	}

	public @NonNull VariableNode createLoadedStepNode(@NonNull VariableDeclaration stepVariable) {
		Role nodeRole = Role.LOADED;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(stepVariable), scheduleManager.getClassDatum(stepVariable));
		node.initializeVariable(region, stepVariable);
		node.setMatched(true);
		return node;
	}

	public @NonNull Edge createMapPartEdge(@NonNull Node sourceNode, @NonNull MapLiteralPart mapPart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		MapPartEdge edge = QVTscheduleFactory.eINSTANCE.createMapPartEdge();
		edge.setReferredPart(mapPart);
		String label = "«" + mapPart.toString() + "»";
		edge.initialize(edgeRole, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull NavigableEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		Role edgeRole = phase;
		NavigationEdge edge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		edge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		edge.initializeProperty(source2targetProperty, isPartial);
		return edge;
	}

	public @NonNull Node createNullNode(boolean isMatched, @Nullable TypedElement typedElement) {
		Role nodeRole = Role.CONSTANT;
		ClassDatum classDatum;
		if (typedElement != null) {
			classDatum = scheduleManager.getClassDatum(typedElement);
		}
		else {
			classDatum = scheduleManager.getOclVoidClassDatum();
		}
		NullLiteralNode node = QVTscheduleFactory.eINSTANCE.createNullLiteralNode();
		node.initialize(nodeRole, region, "«null»", classDatum);
		node.setMatched(isMatched);
		if (typedElement != null) {
			node.addTypedElement(typedElement);
		}
		return node;
	}

	public @NonNull VariableNode createOldNode(@NonNull VariableDeclaration variable) {
		DomainUsage domainUsage = scheduleManager.getDomainUsage(variable);
		boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
		Role phase = isEnforceable ? Role.PREDICATED : Role.LOADED;
		Role nodeRole = phase;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(variable), scheduleManager.getClassDatum(variable));
		node.initializeVariable(region, variable);
		node.setMatched(true);
		return node;
	}

	public @NonNull Node createOperationNode(boolean isMatched, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		Role nodeRole = getOperationNodePhase(region, typedElement, argNodes);
		OperationNode node = QVTscheduleFactory.eINSTANCE.createOperationNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(typedElement));
		node.setMatched(isMatched);
		node.addTypedElement(typedElement);
		return node;
	}

	public @NonNull Node createOperationNode(boolean isMatched, @NonNull Operation operation, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		Role nodeRole = getOperationNodePhase(region, typedElement, argNodes);
		OperationValueNode node = QVTscheduleFactory.eINSTANCE.createOperationValueNode();
		node.setOperationValue(operation);
		node.initialize(nodeRole, region, operation.getName(), scheduleManager.getClassDatum(typedElement));
		node.setMatched(isMatched);
		//		node.addTypedElement(typedElement);
		return node;
	}

	public @NonNull Edge createOperationParameterEdge(@NonNull Node sourceNode, @NonNull Parameter parameter, int parameterIndex, @NonNull Node targetNode) {
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
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Edge createOperationSelfEdge(@NonNull Node sourceNode, @NonNull Type type, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		OperationSelfEdge edge = QVTscheduleFactory.eINSTANCE.createOperationSelfEdge();
		edge.setReferredType(type);
		String name = "«" + PivotConstants.SELF_NAME + "»";
		//		edge.setReferredObject(typeOrParameter);		// FIXME redundant
		edge.initialize(edgeRole, sourceNode, "«" + name + "»", targetNode);
		return edge;
	}

	public @NonNull Node createPatternNode(@NonNull Role nodeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty, boolean isMatched) {
		assert sourceNode.isClass();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)source2targetProperty.getType();
		assert type != null;
		Type elementType = PivotUtil.getElementalType(type);
		TypedModel typedModel = elementType instanceof DataType ? scheduleManager.getDomainUsageAnalysis().getPrimitiveTypeModel() : sourceNode.getClassDatum().getReferredTypedModel();
		assert typedModel != null;
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, type);
		String name = source2targetProperty.getName();
		assert name != null;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(isMatched);
		return node;
	}

	public @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		PredicateEdge edge = QVTscheduleFactory.eINSTANCE.createPredicateEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createPredicatedNode(@NonNull String name, @NonNull ClassDatum classDatum, boolean isMatched) {
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(Role.PREDICATED, region, name, classDatum);
		node.setMatched(isMatched);
		return node;
	}

	public @NonNull Node createPredicatedStepNode(@NonNull Node typedNode, boolean isMatched) {
		String name = getName(typedNode);
		ClassDatum classDatum = getClassDatum(typedNode);
		return createPredicatedNode(name, classDatum, isMatched);
	}

	/**
	 * Create a predicated source2targetProperty success edge from sourceNode to a true/false BooleanValueNode.
	 */
	public @NonNull SuccessEdge createPredicatedSuccess(@NonNull Node sourceNode, @NonNull Property source2targetProperty, boolean isSuccess) {
		BooleanLiteralNode successNode = createBooleanValueNode(isSuccess);
		SuccessEdge edge = QVTscheduleFactory.eINSTANCE.createSuccessEdge();
		edge.initialize(Role.PREDICATED, sourceNode, source2targetProperty.getName(), successNode);
		edge.initializeProperty(source2targetProperty, false);
		return edge;
	}

	public @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		Role nodeRole = Role.REALIZED;
		return createPatternNode(nodeRole, sourceNode, source2targetProperty, sourceNode.isMatched());
	}

	public @NonNull Edge createRealizedIncludesEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		Role edgeRole = Role.REALIZED;
		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createIncludesEdge();
		edge.initialize(edgeRole, sourceNode, INCLUDES_NAME, targetNode);
		return edge;
	}

	public @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Role edgeRole = Role.REALIZED;
		NavigationEdge forwardEdge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		forwardEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		forwardEdge.initializeProperty(source2targetProperty, isPartial);
		return forwardEdge;
	}

	public @NonNull VariableNode createRealizedNode(@NonNull String name, @NonNull ClassDatum classDatum, boolean isMatched) {
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(Role.REALIZED, region, name, classDatum);
		node.setMatched(isMatched);
		return node;
	}

	public @NonNull VariableNode createRealizedStepNode(@NonNull VariableDeclaration stepVariable) {
		VariableNode node = createRealizedNode(getName(stepVariable), scheduleManager.getClassDatum(stepVariable), true);
		node.initializeVariable(region, stepVariable);
		return node;
	}

	/**
	 * Create a realized source2targetProperty success edge from sourceNode to a true/false BooleanValueNode if isSuccesss is  non-null,
	 * else to a SuccessNode.
	 */
	public @NonNull SuccessEdge createRealizedSuccess(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @Nullable Boolean isSuccess) {
		ClassDatum classDatum = scheduleManager.getBooleanClassDatum();
		Node node;
		if (isSuccess != null) {
			node = createBooleanValueNode(isSuccess);
		}
		else {
			SuccessNode successNode = QVTscheduleFactory.eINSTANCE.createSuccessNode();
			successNode.initialize(Role.REALIZED, region, "«success»", classDatum);
			node = successNode;
		}
		SuccessEdge edge = QVTscheduleFactory.eINSTANCE.createSuccessEdge();
		edge.initialize(Role.REALIZED, sourceNode, source2targetProperty.getName(), node);
		edge.initializeProperty(source2targetProperty, false);
		return edge;
	}

	/*	public @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		Role edgeRole = Role.OTHER;
		RecursionEdge edge = QVTscheduleFactory.eINSTANCE.createRecursionEdge();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.setPrimary(isPrimary);
		return edge;
	} */

	public @NonNull Edge createShadowPartEdge(@NonNull Node sourceNode, @NonNull ShadowPart shadowPart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		ShadowPartEdge edge = QVTscheduleFactory.eINSTANCE.createShadowPartEdge();
		edge.setReferredPart(shadowPart);
		String label = "«" + shadowPart.getName() + "»";
		edge.initialize(edgeRole, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode, boolean isMatched) {
		DomainUsage domainUsage = scheduleManager.getDomainUsage(callExp);
		boolean isMiddleOrOutput = domainUsage.isOutput() || domainUsage.isMiddle();
		boolean isDirty = false;
		if (callExp instanceof NavigationCallExp) {
			Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
			isDirty = scheduleManager.isDirty(referredProperty);
		}
		Role phase = /*sourceNode.isPredicated() ||*/ isMiddleOrOutput || isDirty ? Role.PREDICATED : Role.LOADED;
		Role stepNodeRole = phase;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(stepNodeRole, region, name, scheduleManager.getClassDatum(callExp));
		node.setMatched(isMatched);
		node.addTypedElement(callExp);
		return node;
	}

	/*	public @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		Role edgeRole = Role.OTHER;
		RecursionEdge edge = QVTscheduleFactory.eINSTANCE.createRecursionEdge();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.setPrimary(isPrimary);
		return edge;
	} */

	public @NonNull Edge createTuplePartEdge(@NonNull Node sourceNode, @NonNull TupleLiteralPart tuplePart, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		TuplePartEdge edge = QVTscheduleFactory.eINSTANCE.createTuplePartEdge();
		edge.setReferredPart(tuplePart);
		String label = "«" + tuplePart.getName() + "»";
		edge.initialize(edgeRole, sourceNode, label, targetNode);
		return edge;
	}

	public @NonNull Node createUnknownNode(@NonNull String name, @NonNull TypedElement typedElement) {
		Role nodeRole = Role.OTHER;
		UnknownNode node = QVTscheduleFactory.eINSTANCE.createUnknownNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(typedElement));
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
			case CONSTANT: phase = Role.CONSTANT; break;
			default: throw new UnsupportedOperationException();
		}
		return phase;
	}

	public @NonNull R getRegion() {
		return region;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}
}