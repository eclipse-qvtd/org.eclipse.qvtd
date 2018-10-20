/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.qvtd.pivot.qvtschedule.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage
 * @generated
 */
public class QVTscheduleAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTschedulePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTscheduleAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QVTschedulePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTscheduleSwitch<@Nullable Adapter> modelSwitch =
			new QVTscheduleSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseAbstractDatum(AbstractDatum object) {
				return createAbstractDatumAdapter();
			}
			@Override
			public Adapter caseArgumentEdge(ArgumentEdge object) {
				return createArgumentEdgeAdapter();
			}
			@Override
			public Adapter caseBasicPartition(BasicPartition object) {
				return createBasicPartitionAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralNode(BooleanLiteralNode object) {
				return createBooleanLiteralNodeAdapter();
			}
			@Override
			public Adapter caseCastEdge(CastEdge object) {
				return createCastEdgeAdapter();
			}
			@Override
			public Adapter caseClassDatum(ClassDatum object) {
				return createClassDatumAdapter();
			}
			@Override
			public Adapter caseCluster(Cluster object) {
				return createClusterAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralNode(CollectionLiteralNode object) {
				return createCollectionLiteralNodeAdapter();
			}
			@Override
			public Adapter caseCollectionPartEdge(CollectionPartEdge object) {
				return createCollectionPartEdgeAdapter();
			}
			@Override
			public Adapter caseCollectionRangeNode(CollectionRangeNode object) {
				return createCollectionRangeNodeAdapter();
			}
			@Override
			public Adapter caseComposedNode(ComposedNode object) {
				return createComposedNodeAdapter();
			}
			@Override
			public Adapter caseCompositePartition(CompositePartition object) {
				return createCompositePartitionAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseConnectionEnd(ConnectionEnd object) {
				return createConnectionEndAdapter();
			}
			@Override
			public Adapter caseCyclicMappingRegion(CyclicMappingRegion object) {
				return createCyclicMappingRegionAdapter();
			}
			@Override
			public Adapter caseCyclicPartition(CyclicPartition object) {
				return createCyclicPartitionAdapter();
			}
			@Override
			public Adapter caseDependencyEdge(DependencyEdge object) {
				return createDependencyEdgeAdapter();
			}
			@Override
			public Adapter caseDependencyNode(DependencyNode object) {
				return createDependencyNodeAdapter();
			}
			@Override
			public Adapter caseDispatchRegion(DispatchRegion object) {
				return createDispatchRegionAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
			}
			@Override
			public Adapter caseEdgeConnection(EdgeConnection object) {
				return createEdgeConnectionAdapter();
			}
			@Override
			public Adapter caseEnumLiteralNode(EnumLiteralNode object) {
				return createEnumLiteralNodeAdapter();
			}
			@Override
			public Adapter caseErrorNode(ErrorNode object) {
				return createErrorNodeAdapter();
			}
			@Override
			public Adapter caseExpressionEdge(ExpressionEdge object) {
				return createExpressionEdgeAdapter();
			}
			@Override
			public Adapter caseIfNode(IfNode object) {
				return createIfNodeAdapter();
			}
			@Override
			public Adapter caseIncludesEdge(IncludesEdge object) {
				return createIncludesEdgeAdapter();
			}
			@Override
			public Adapter caseInputNode(InputNode object) {
				return createInputNodeAdapter();
			}
			@Override
			public Adapter caseIteratedEdge(IteratedEdge object) {
				return createIteratedEdgeAdapter();
			}
			@Override
			public Adapter caseIteratorNode(IteratorNode object) {
				return createIteratorNodeAdapter();
			}
			@Override
			public Adapter caseKeyPartEdge(KeyPartEdge object) {
				return createKeyPartEdgeAdapter();
			}
			@Override
			public Adapter caseKeyedValueNode(KeyedValueNode object) {
				return createKeyedValueNodeAdapter();
			}
			@Override
			public Adapter caseLoadingPartition(LoadingPartition object) {
				return createLoadingPartitionAdapter();
			}
			@Override
			public Adapter caseLoadingRegion(LoadingRegion object) {
				return createLoadingRegionAdapter();
			}
			@Override
			public Adapter caseMapLiteralNode(MapLiteralNode object) {
				return createMapLiteralNodeAdapter();
			}
			@Override
			public Adapter caseMapPartEdge(MapPartEdge object) {
				return createMapPartEdgeAdapter();
			}
			@Override
			public Adapter caseMapPartNode(MapPartNode object) {
				return createMapPartNodeAdapter();
			}
			@Override
			public Adapter caseMappingNode(MappingNode object) {
				return createMappingNodeAdapter();
			}
			@Override
			public Adapter caseMappingPartition(MappingPartition object) {
				return createMappingPartitionAdapter();
			}
			@Override
			public Adapter caseMappingRegion(MappingRegion object) {
				return createMappingRegionAdapter();
			}
			@Override
			public Adapter caseMicroMappingRegion(MicroMappingRegion object) {
				return createMicroMappingRegionAdapter();
			}
			@Override
			public Adapter caseNamedMappingRegion(NamedMappingRegion object) {
				return createNamedMappingRegionAdapter();
			}
			@Override
			public Adapter caseNavigableEdge(NavigableEdge object) {
				return createNavigableEdgeAdapter();
			}
			@Override
			public Adapter caseNavigationEdge(NavigationEdge object) {
				return createNavigationEdgeAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseNodeConnection(NodeConnection object) {
				return createNodeConnectionAdapter();
			}
			@Override
			public Adapter caseNonPartition(NonPartition object) {
				return createNonPartitionAdapter();
			}
			@Override
			public Adapter caseNullLiteralNode(NullLiteralNode object) {
				return createNullLiteralNodeAdapter();
			}
			@Override
			public Adapter caseNumericLiteralNode(NumericLiteralNode object) {
				return createNumericLiteralNodeAdapter();
			}
			@Override
			public Adapter caseOperationCallNode(OperationCallNode object) {
				return createOperationCallNodeAdapter();
			}
			@Override
			public Adapter caseOperationNode(OperationNode object) {
				return createOperationNodeAdapter();
			}
			@Override
			public Adapter caseOperationRegion(OperationRegion object) {
				return createOperationRegionAdapter();
			}
			@Override
			public Adapter caseOperationParameterEdge(OperationParameterEdge object) {
				return createOperationParameterEdgeAdapter();
			}
			@Override
			public Adapter caseOperationSelfEdge(OperationSelfEdge object) {
				return createOperationSelfEdgeAdapter();
			}
			@Override
			public Adapter casePartition(Partition object) {
				return createPartitionAdapter();
			}
			@Override
			public Adapter casePatternTypedNode(PatternTypedNode object) {
				return createPatternTypedNodeAdapter();
			}
			@Override
			public Adapter casePatternVariableNode(PatternVariableNode object) {
				return createPatternVariableNodeAdapter();
			}
			@Override
			public Adapter casePredicateEdge(PredicateEdge object) {
				return createPredicateEdgeAdapter();
			}
			@Override
			public Adapter casePropertyDatum(PropertyDatum object) {
				return createPropertyDatumAdapter();
			}
			@Override
			public Adapter caseRecursionEdge(RecursionEdge object) {
				return createRecursionEdgeAdapter();
			}
			@Override
			public Adapter caseRegion(Region object) {
				return createRegionAdapter();
			}
			@Override
			public Adapter caseRootPartition(RootPartition object) {
				return createRootPartitionAdapter();
			}
			@Override
			public Adapter caseRuleRegion(RuleRegion object) {
				return createRuleRegionAdapter();
			}
			@Override
			public Adapter caseScheduleModel(ScheduleModel object) {
				return createScheduleModelAdapter();
			}
			@Override
			public Adapter caseScheduledRegion(ScheduledRegion object) {
				return createScheduledRegionAdapter();
			}
			@Override
			public Adapter caseShadowNode(ShadowNode object) {
				return createShadowNodeAdapter();
			}
			@Override
			public Adapter caseShadowPartEdge(ShadowPartEdge object) {
				return createShadowPartEdgeAdapter();
			}
			@Override
			public Adapter caseStringLiteralNode(StringLiteralNode object) {
				return createStringLiteralNodeAdapter();
			}
			@Override
			public Adapter caseSuccessEdge(SuccessEdge object) {
				return createSuccessEdgeAdapter();
			}
			@Override
			public Adapter caseSuccessNode(SuccessNode object) {
				return createSuccessNodeAdapter();
			}
			@Override
			public Adapter caseSymbolable(Symbolable object) {
				return createSymbolableAdapter();
			}
			@Override
			public Adapter caseTupleLiteralNode(TupleLiteralNode object) {
				return createTupleLiteralNodeAdapter();
			}
			@Override
			public Adapter caseTuplePartEdge(TuplePartEdge object) {
				return createTuplePartEdgeAdapter();
			}
			@Override
			public Adapter caseTypeLiteralNode(TypeLiteralNode object) {
				return createTypeLiteralNodeAdapter();
			}
			@Override
			public Adapter caseUnknownNode(UnknownNode object) {
				return createUnknownNodeAdapter();
			}
			@Override
			public Adapter caseVariableNode(VariableNode object) {
				return createVariableNodeAdapter();
			}
			@Override
			public Adapter caseVerdictRegion(VerdictRegion object) {
				return createVerdictRegionAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseNamespace(Namespace object) {
				return createNamespaceAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum
	 * @generated
	 */
	public Adapter createAbstractDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge <em>Argument Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge
	 * @generated
	 */
	public Adapter createArgumentEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition <em>Basic Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition
	 * @generated
	 */
	public Adapter createBasicPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode <em>Boolean Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode
	 * @generated
	 */
	public Adapter createBooleanLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge <em>Cast Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CastEdge
	 * @generated
	 */
	public Adapter createCastEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum
	 * @generated
	 */
	public Adapter createClassDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster
	 * @generated
	 */
	public Adapter createClusterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode <em>Collection Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode
	 * @generated
	 */
	public Adapter createCollectionLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge <em>Collection Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge
	 * @generated
	 */
	public Adapter createCollectionPartEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode <em>Collection Range Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode
	 * @generated
	 */
	public Adapter createCollectionRangeNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ComposedNode <em>Composed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ComposedNode
	 * @generated
	 */
	public Adapter createComposedNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CompositePartition <em>Composite Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CompositePartition
	 * @generated
	 */
	public Adapter createCompositePartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @generated
	 */
	public Adapter createConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion <em>Cyclic Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion
	 * @generated
	 */
	public Adapter createCyclicMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition <em>Cyclic Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition
	 * @generated
	 */
	public Adapter createCyclicPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge <em>Dependency Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge
	 * @generated
	 */
	public Adapter createDependencyEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.DependencyNode <em>Dependency Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DependencyNode
	 * @generated
	 */
	public Adapter createDependencyNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion <em>Dispatch Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion
	 * @generated
	 */
	public Adapter createDispatchRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection <em>Edge Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection
	 * @generated
	 */
	public Adapter createEdgeConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode <em>Enum Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode
	 * @generated
	 */
	public Adapter createEnumLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel <em>Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel
	 * @generated
	 */
	public Adapter createScheduleModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion <em>Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion
	 * @generated
	 */
	public Adapter createScheduledRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowNode <em>Shadow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowNode
	 * @generated
	 */
	public Adapter createShadowNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge <em>Shadow Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge
	 * @generated
	 */
	public Adapter createShadowPartEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode <em>String Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode
	 * @generated
	 */
	public Adapter createStringLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge <em>Success Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge
	 * @generated
	 */
	public Adapter createSuccessEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.SuccessNode <em>Success Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.SuccessNode
	 * @generated
	 */
	public Adapter createSuccessNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
	 * @generated
	 */
	public Adapter createSymbolableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode <em>Tuple Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode
	 * @generated
	 */
	public Adapter createTupleLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge <em>Tuple Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge
	 * @generated
	 */
	public Adapter createTuplePartEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode <em>Type Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode
	 * @generated
	 */
	public Adapter createTypeLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.UnknownNode <em>Unknown Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.UnknownNode
	 * @generated
	 */
	public Adapter createUnknownNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.VariableNode <em>Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VariableNode
	 * @generated
	 */
	public Adapter createVariableNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion <em>Verdict Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion
	 * @generated
	 */
	public Adapter createVerdictRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ErrorNode <em>Error Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ErrorNode
	 * @generated
	 */
	public Adapter createErrorNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge <em>Expression Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge
	 * @generated
	 */
	public Adapter createExpressionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.IfNode <em>If Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IfNode
	 * @generated
	 */
	public Adapter createIfNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge <em>Includes Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge
	 * @generated
	 */
	public Adapter createIncludesEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.InputNode <em>Input Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.InputNode
	 * @generated
	 */
	public Adapter createInputNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge <em>Iterated Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge
	 * @generated
	 */
	public Adapter createIteratedEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratorNode <em>Iterator Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratorNode
	 * @generated
	 */
	public Adapter createIteratorNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge <em>Key Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge
	 * @generated
	 */
	public Adapter createKeyPartEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode <em>Keyed Value Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode
	 * @generated
	 */
	public Adapter createKeyedValueNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition <em>Loading Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition
	 * @generated
	 */
	public Adapter createLoadingPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion <em>Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion
	 * @generated
	 */
	public Adapter createLoadingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode <em>Map Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode
	 * @generated
	 */
	public Adapter createMapLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge <em>Map Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge
	 * @generated
	 */
	public Adapter createMapPartEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartNode <em>Map Part Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartNode
	 * @generated
	 */
	public Adapter createMapPartNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingNode <em>Mapping Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingNode
	 * @generated
	 */
	public Adapter createMappingNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition <em>Mapping Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition
	 * @generated
	 */
	public Adapter createMappingPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion <em>Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion
	 * @generated
	 */
	public Adapter createMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion <em>Micro Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion
	 * @generated
	 */
	public Adapter createMicroMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion <em>Named Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion
	 * @generated
	 */
	public Adapter createNamedMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge <em>Navigable Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge
	 * @generated
	 */
	public Adapter createNavigableEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge <em>Navigation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge
	 * @generated
	 */
	public Adapter createNavigationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection <em>Node Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection
	 * @generated
	 */
	public Adapter createNodeConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NonPartition <em>Non Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NonPartition
	 * @generated
	 */
	public Adapter createNonPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode <em>Null Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode
	 * @generated
	 */
	public Adapter createNullLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode <em>Numeric Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode
	 * @generated
	 */
	public Adapter createNumericLiteralNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode <em>Operation Call Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode
	 * @generated
	 */
	public Adapter createOperationCallNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationNode
	 * @generated
	 */
	public Adapter createOperationNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion <em>Operation Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion
	 * @generated
	 */
	public Adapter createOperationRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge <em>Operation Parameter Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge
	 * @generated
	 */
	public Adapter createOperationParameterEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge <em>Operation Self Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge
	 * @generated
	 */
	public Adapter createOperationSelfEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Partition <em>Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Partition
	 * @generated
	 */
	public Adapter createPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode <em>Pattern Typed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode
	 * @generated
	 */
	public Adapter createPatternTypedNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode <em>Pattern Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode
	 * @generated
	 */
	public Adapter createPatternVariableNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge <em>Predicate Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge
	 * @generated
	 */
	public Adapter createPredicateEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum <em>Property Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum
	 * @generated
	 */
	public Adapter createPropertyDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge <em>Recursion Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge
	 * @generated
	 */
	public Adapter createRecursionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region
	 * @generated
	 */
	public Adapter createRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition <em>Root Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootPartition
	 * @generated
	 */
	public Adapter createRootPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion <em>Rule Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RuleRegion
	 * @generated
	 */
	public Adapter createRuleRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //QVTscheduleAdapterFactory
