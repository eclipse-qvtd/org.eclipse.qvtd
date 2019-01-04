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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.utilities.LazyXMIidAssigningResourceImpl;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Cluster;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode;
import org.eclipse.qvtd.pivot.qvtschedule.ComposedNode;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IfNode;
import org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge;
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
import org.eclipse.qvtd.pivot.qvtschedule.MappingNode;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MergedPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NonPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowNode;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.Symbolable;
import org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTschedulePackageImpl extends EPackageImpl implements QVTschedulePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractDatumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass castEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classDatumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clusterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionPartEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionRangeNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composedNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositePartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cyclicMappingRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cyclicPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shadowNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shadowPartEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass successEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass successNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tuplePartEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verdictRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionRoleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum roleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass includesEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratedEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyPartEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyedValueNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadingPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadingRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapPartEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapPartNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergedPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigableEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericLiteralNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationParameterEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationSelfEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternTypedNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternVariableNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDatumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recursionEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleRegionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTschedulePackageImpl() {
		super(eNS_URI, QVTscheduleFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link QVTschedulePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTschedulePackage init() {
		if (isInited) return (QVTschedulePackage)EPackage.Registry.INSTANCE.getEPackage(QVTschedulePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTschedulePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTschedulePackageImpl theQVTschedulePackage = registeredQVTschedulePackage instanceof QVTschedulePackageImpl ? (QVTschedulePackageImpl)registeredQVTschedulePackage : new QVTschedulePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTschedulePackage.createPackageContents();

		// Initialize created meta-data
		theQVTschedulePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTschedulePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTschedulePackage.eNS_URI, theQVTschedulePackage);
		return theQVTschedulePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractDatum() {
		return abstractDatumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractDatum_ReferredTypedModel() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArgumentEdge() {
		return argumentEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBasicPartition() {
		return basicPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_ConstantEdges() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_ConstantNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_ConstantSuccessFalseNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_ConstantSuccessTrueNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_HeadNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_LoadedEdges() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_LoadedNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_PredicatedEdges() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_PredicatedNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_RealizedEdges() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_RealizedNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_SpeculatedEdges() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_SpeculatedNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_SpeculationNodes() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_OwningMergedPartition() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicPartition_ExplicitPredecessors() {
		return (EReference)basicPartitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanLiteralNode() {
		return booleanLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanLiteralNode_BooleanValue() {
		return (EAttribute)booleanLiteralNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCastEdge() {
		return castEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCastEdge_Property() {
		return (EReference)castEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCastEdge_ReferredClass() {
		return (EReference)castEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassDatum() {
		return classDatumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassDatum_CompleteClass() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassDatum_OwnedPropertyDatums() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassDatum_OwningScheduleModel() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassDatum_ReferredClass() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassDatum_SuperClassDatums() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCluster() {
		return clusterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCluster_OwningRegion() {
		return (EReference)clusterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCluster_MemberNodes() {
		return (EReference)clusterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCluster_MemberEdges() {
		return (EReference)clusterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCluster_PrecedingClusters() {
		return (EReference)clusterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCluster_SucceedingClusters() {
		return (EReference)clusterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCluster_Depth() {
		return (EAttribute)clusterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionLiteralNode() {
		return collectionLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionPartEdge() {
		return collectionPartEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionPartEdge_ReferredPart() {
		return (EReference)collectionPartEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionRangeNode() {
		return collectionRangeNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComposedNode() {
		return composedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositePartition() {
		return compositePartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositePartition_OwnedMappingPartitions() {
		return (EReference)compositePartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnection_OwningRootRegion() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConnection_ConnectionRole() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConnection_Name() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnection_SourceEnds() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnection_IntermediatePartitions() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnection_CommonPartition() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectionEnd() {
		return connectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCyclicMappingRegion() {
		return cyclicMappingRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCyclicMappingRegion_ElementRegions() {
		return (EReference)cyclicMappingRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCyclicPartition() {
		return cyclicPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependencyEdge() {
		return dependencyEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependencyNode() {
		return dependencyNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDispatchRegion() {
		return dispatchRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDispatchRegion_ReferredRuleRegion() {
		return (EReference)dispatchRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_Cluster() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEdge_EdgeRole() {
		return (EAttribute)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEdge_Name() {
		return (EAttribute)edgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_OwningRegion() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_SourceNode() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_TargetNode() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeConnection() {
		return edgeConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgeConnection_ReferredProperty() {
		return (EReference)edgeConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgeConnection_MandatoryTargetEdges() {
		return (EReference)edgeConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgeConnection_PreferredTargetEdges() {
		return (EReference)edgeConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumLiteralNode() {
		return enumLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumLiteralNode_EnumValue() {
		return (EReference)enumLiteralNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRole() {
		return roleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getNumber() {
		return numberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScheduleModel() {
		return scheduleModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduleModel_OwnedClassDatums() {
		return (EReference)scheduleModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduleModel_OwnedOperationRegions() {
		return (EReference)scheduleModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduleModel_OwnedRootRegions() {
		return (EReference)scheduleModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduleModel_OwnedMappingRegions() {
		return (EReference)scheduleModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShadowNode() {
		return shadowNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShadowPartEdge() {
		return shadowPartEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShadowPartEdge_ReferredPart() {
		return (EReference)shadowPartEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteralNode() {
		return stringLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringLiteralNode_StringValue() {
		return (EAttribute)stringLiteralNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSuccessEdge() {
		return successEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSuccessNode() {
		return successNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSymbolable() {
		return symbolableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSymbolable_SymbolName() {
		return (EAttribute)symbolableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTupleLiteralNode() {
		return tupleLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTuplePartEdge() {
		return tuplePartEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTuplePartEdge_ReferredPart() {
		return (EReference)tuplePartEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeLiteralNode() {
		return typeLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeLiteralNode_TypeValue() {
		return (EReference)typeLiteralNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnknownNode() {
		return unknownNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableNode() {
		return variableNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableNode_ReferredVariable() {
		return (EReference)variableNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVerdictRegion() {
		return verdictRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVerdictRegion_ReferredRuleRegion() {
		return (EReference)verdictRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getConnectionRole() {
		return connectionRoleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorNode() {
		return errorNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionEdge() {
		return expressionEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIfNode() {
		return ifNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIncludesEdge() {
		return includesEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInputNode() {
		return inputNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIteratedEdge() {
		return iteratedEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIteratorNode() {
		return iteratorNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKeyPartEdge() {
		return keyPartEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyPartEdge_ReferredPart() {
		return (EReference)keyPartEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKeyedValueNode() {
		return keyedValueNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyedValueNode_ClassDatumValue() {
		return (EReference)keyedValueNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLoadingPartition() {
		return loadingPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoadingPartition_ReferredLoadingRegion() {
		return (EReference)loadingPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLoadingRegion() {
		return loadingRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoadingRegion_LoadingPartition() {
		return (EReference)loadingRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoadingRegion_OwningRootRegion() {
		return (EReference)loadingRegionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapLiteralNode() {
		return mapLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapPartEdge() {
		return mapPartEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapPartEdge_ReferredPart() {
		return (EReference)mapPartEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapPartNode() {
		return mapPartNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingNode() {
		return mappingNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingNode_Matched() {
		return (EAttribute)mappingNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingPartition() {
		return mappingPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingPartition_OwningCompositePartition() {
		return (EReference)mappingPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingPartition_ReferedMappingRegion() {
		return (EReference)mappingPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingPartition_Region() {
		return (EReference)mappingPartitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingPartition_RootPartition() {
		return (EReference)mappingPartitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingPartition_ExplicitSuccessors() {
		return (EReference)mappingPartitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingRegion() {
		return mappingRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingRegion_HeadNodes() {
		return (EReference)mappingRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingRegion_MappingPartitions() {
		return (EReference)mappingRegionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingRegion_OwningScheduleModel() {
		return (EReference)mappingRegionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMergedPartition() {
		return mergedPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMergedPartition_OwnedMergedPartitions() {
		return (EReference)mergedPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigableEdge() {
		return navigableEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigableEdge_IncomingConnection() {
		return (EReference)navigableEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigableEdge_OutgoingConnections() {
		return (EReference)navigableEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigableEdge_Secondary() {
		return (EAttribute)navigableEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigableEdge_OppositeEdge() {
		return (EReference)navigableEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationEdge() {
		return navigationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigationEdge_Partial() {
		return (EAttribute)navigationEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigationEdge_ReferredProperty() {
		return (EReference)navigationEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_ClassDatum() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Cluster() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_IncomingConnection() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_NodeRole() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_OutgoingConnections() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_IncomingEdges() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Name() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_OutgoingEdges() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_OwningRegion() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeConnection() {
		return nodeConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeConnection_ClassDatum() {
		return (EReference)nodeConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeConnection_MandatoryTargetNodes() {
		return (EReference)nodeConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeConnection_PassedTargetNodes() {
		return (EReference)nodeConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeConnection_PreferredTargetNodes() {
		return (EReference)nodeConnectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNonPartition() {
		return nonPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNullLiteralNode() {
		return nullLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumericLiteralNode() {
		return numericLiteralNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNumericLiteralNode_NumericValue() {
		return (EAttribute)numericLiteralNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationCallNode() {
		return operationCallNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationCallNode_ReferredOperation() {
		return (EReference)operationCallNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationNode() {
		return operationNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationRegion() {
		return operationRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationRegion_DependencyNodes() {
		return (EReference)operationRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationRegion_HeadNodes() {
		return (EReference)operationRegionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationRegion_ReferredOperation() {
		return (EReference)operationRegionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationRegion_ResultNode() {
		return (EReference)operationRegionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationRegion_OwningScheduleModel() {
		return (EReference)operationRegionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationParameterEdge() {
		return operationParameterEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationParameterEdge_ReferredParameter() {
		return (EReference)operationParameterEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationParameterEdge_ParameterIndex() {
		return (EAttribute)operationParameterEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationSelfEdge() {
		return operationSelfEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationSelfEdge_ReferredType() {
		return (EReference)operationSelfEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPartition() {
		return partitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPartition_Passes() {
		return (EAttribute)partitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartition_IntermediateConnections() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartition_RootConnections() {
		return (EReference)partitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPatternTypedNode() {
		return patternTypedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPatternVariableNode() {
		return patternVariableNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredicateEdge() {
		return predicateEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyDatum() {
		return propertyDatumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyDatum_Opposite() {
		return (EReference)propertyDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyDatum_OwningClassDatum() {
		return (EReference)propertyDatumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyDatum_ReferredProperty() {
		return (EReference)propertyDatumEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyDatum_SuperPropertyDatums() {
		return (EReference)propertyDatumEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyDatum_Key() {
		return (EAttribute)propertyDatumEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecursionEdge() {
		return recursionEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecursionEdge_Primary() {
		return (EAttribute)recursionEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRegion() {
		return regionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRuleRegion() {
		return ruleRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRuleRegion_ReferredRule() {
		return (EReference)ruleRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRegion_OwnedEdges() {
		return (EReference)regionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRegion_OwnedClusters() {
		return (EReference)regionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRegion_RootRegion() {
		return (EReference)regionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRootPartition() {
		return rootPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootPartition_OwningRootRegion() {
		return (EReference)rootPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootPartition_LoadingPartition() {
		return (EReference)rootPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRootRegion() {
		return rootRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootRegion_ActiveRegions() {
		return (EReference)rootRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootRegion_OwnedConnections() {
		return (EReference)rootRegionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootRegion_OwnedLoadingRegion() {
		return (EReference)rootRegionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootRegion_OwningScheduleModel() {
		return (EReference)rootRegionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootRegion_ReferredTransformation() {
		return (EReference)rootRegionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootRegion_OwnedRootPartition() {
		return (EReference)rootRegionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRegion_OwnedNodes() {
		return (EReference)regionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTscheduleFactory getQVTscheduleFactory() {
		return (QVTscheduleFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractDatumEClass = createEClass(ABSTRACT_DATUM);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__REFERRED_TYPED_MODEL);

		argumentEdgeEClass = createEClass(ARGUMENT_EDGE);

		basicPartitionEClass = createEClass(BASIC_PARTITION);
		createEReference(basicPartitionEClass, BASIC_PARTITION__CONSTANT_EDGES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__CONSTANT_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__CONSTANT_SUCCESS_FALSE_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__CONSTANT_SUCCESS_TRUE_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__EXPLICIT_PREDECESSORS);
		createEReference(basicPartitionEClass, BASIC_PARTITION__HEAD_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__LOADED_EDGES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__LOADED_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__PREDICATED_EDGES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__PREDICATED_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__REALIZED_EDGES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__REALIZED_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__SPECULATED_EDGES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__SPECULATED_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__SPECULATION_NODES);
		createEReference(basicPartitionEClass, BASIC_PARTITION__OWNING_MERGED_PARTITION);

		booleanLiteralNodeEClass = createEClass(BOOLEAN_LITERAL_NODE);
		createEAttribute(booleanLiteralNodeEClass, BOOLEAN_LITERAL_NODE__BOOLEAN_VALUE);

		castEdgeEClass = createEClass(CAST_EDGE);
		createEReference(castEdgeEClass, CAST_EDGE__PROPERTY);
		createEReference(castEdgeEClass, CAST_EDGE__REFERRED_CLASS);

		classDatumEClass = createEClass(CLASS_DATUM);
		createEReference(classDatumEClass, CLASS_DATUM__COMPLETE_CLASS);
		createEReference(classDatumEClass, CLASS_DATUM__OWNED_PROPERTY_DATUMS);
		createEReference(classDatumEClass, CLASS_DATUM__OWNING_SCHEDULE_MODEL);
		createEReference(classDatumEClass, CLASS_DATUM__REFERRED_CLASS);
		createEReference(classDatumEClass, CLASS_DATUM__SUPER_CLASS_DATUMS);

		clusterEClass = createEClass(CLUSTER);
		createEReference(clusterEClass, CLUSTER__OWNING_REGION);
		createEReference(clusterEClass, CLUSTER__MEMBER_NODES);
		createEReference(clusterEClass, CLUSTER__MEMBER_EDGES);
		createEReference(clusterEClass, CLUSTER__PRECEDING_CLUSTERS);
		createEReference(clusterEClass, CLUSTER__SUCCEEDING_CLUSTERS);
		createEAttribute(clusterEClass, CLUSTER__DEPTH);

		collectionLiteralNodeEClass = createEClass(COLLECTION_LITERAL_NODE);

		collectionPartEdgeEClass = createEClass(COLLECTION_PART_EDGE);
		createEReference(collectionPartEdgeEClass, COLLECTION_PART_EDGE__REFERRED_PART);

		collectionRangeNodeEClass = createEClass(COLLECTION_RANGE_NODE);

		composedNodeEClass = createEClass(COMPOSED_NODE);

		compositePartitionEClass = createEClass(COMPOSITE_PARTITION);
		createEReference(compositePartitionEClass, COMPOSITE_PARTITION__OWNED_MAPPING_PARTITIONS);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__OWNING_ROOT_REGION);
		createEAttribute(connectionEClass, CONNECTION__CONNECTION_ROLE);
		createEAttribute(connectionEClass, CONNECTION__NAME);
		createEReference(connectionEClass, CONNECTION__SOURCE_ENDS);
		createEReference(connectionEClass, CONNECTION__INTERMEDIATE_PARTITIONS);
		createEReference(connectionEClass, CONNECTION__COMMON_PARTITION);

		connectionEndEClass = createEClass(CONNECTION_END);

		cyclicMappingRegionEClass = createEClass(CYCLIC_MAPPING_REGION);
		createEReference(cyclicMappingRegionEClass, CYCLIC_MAPPING_REGION__ELEMENT_REGIONS);

		cyclicPartitionEClass = createEClass(CYCLIC_PARTITION);

		dependencyEdgeEClass = createEClass(DEPENDENCY_EDGE);

		dependencyNodeEClass = createEClass(DEPENDENCY_NODE);

		dispatchRegionEClass = createEClass(DISPATCH_REGION);
		createEReference(dispatchRegionEClass, DISPATCH_REGION__REFERRED_RULE_REGION);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__CLUSTER);
		createEAttribute(edgeEClass, EDGE__EDGE_ROLE);
		createEAttribute(edgeEClass, EDGE__NAME);
		createEReference(edgeEClass, EDGE__OWNING_REGION);
		createEReference(edgeEClass, EDGE__SOURCE_NODE);
		createEReference(edgeEClass, EDGE__TARGET_NODE);

		edgeConnectionEClass = createEClass(EDGE_CONNECTION);
		createEReference(edgeConnectionEClass, EDGE_CONNECTION__REFERRED_PROPERTY);
		createEReference(edgeConnectionEClass, EDGE_CONNECTION__MANDATORY_TARGET_EDGES);
		createEReference(edgeConnectionEClass, EDGE_CONNECTION__PREFERRED_TARGET_EDGES);

		enumLiteralNodeEClass = createEClass(ENUM_LITERAL_NODE);
		createEReference(enumLiteralNodeEClass, ENUM_LITERAL_NODE__ENUM_VALUE);

		errorNodeEClass = createEClass(ERROR_NODE);

		expressionEdgeEClass = createEClass(EXPRESSION_EDGE);

		ifNodeEClass = createEClass(IF_NODE);

		includesEdgeEClass = createEClass(INCLUDES_EDGE);

		inputNodeEClass = createEClass(INPUT_NODE);

		iteratedEdgeEClass = createEClass(ITERATED_EDGE);

		iteratorNodeEClass = createEClass(ITERATOR_NODE);

		keyPartEdgeEClass = createEClass(KEY_PART_EDGE);
		createEReference(keyPartEdgeEClass, KEY_PART_EDGE__REFERRED_PART);

		keyedValueNodeEClass = createEClass(KEYED_VALUE_NODE);
		createEReference(keyedValueNodeEClass, KEYED_VALUE_NODE__CLASS_DATUM_VALUE);

		loadingPartitionEClass = createEClass(LOADING_PARTITION);
		createEReference(loadingPartitionEClass, LOADING_PARTITION__REFERRED_LOADING_REGION);

		loadingRegionEClass = createEClass(LOADING_REGION);
		createEReference(loadingRegionEClass, LOADING_REGION__LOADING_PARTITION);
		createEReference(loadingRegionEClass, LOADING_REGION__OWNING_ROOT_REGION);

		mapLiteralNodeEClass = createEClass(MAP_LITERAL_NODE);

		mapPartEdgeEClass = createEClass(MAP_PART_EDGE);
		createEReference(mapPartEdgeEClass, MAP_PART_EDGE__REFERRED_PART);

		mapPartNodeEClass = createEClass(MAP_PART_NODE);

		mappingNodeEClass = createEClass(MAPPING_NODE);
		createEAttribute(mappingNodeEClass, MAPPING_NODE__MATCHED);

		mappingPartitionEClass = createEClass(MAPPING_PARTITION);
		createEReference(mappingPartitionEClass, MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION);
		createEReference(mappingPartitionEClass, MAPPING_PARTITION__REFERED_MAPPING_REGION);
		createEReference(mappingPartitionEClass, MAPPING_PARTITION__REGION);
		createEReference(mappingPartitionEClass, MAPPING_PARTITION__ROOT_PARTITION);
		createEReference(mappingPartitionEClass, MAPPING_PARTITION__EXPLICIT_SUCCESSORS);

		mappingRegionEClass = createEClass(MAPPING_REGION);
		createEReference(mappingRegionEClass, MAPPING_REGION__HEAD_NODES);
		createEReference(mappingRegionEClass, MAPPING_REGION__MAPPING_PARTITIONS);
		createEReference(mappingRegionEClass, MAPPING_REGION__OWNING_SCHEDULE_MODEL);

		mergedPartitionEClass = createEClass(MERGED_PARTITION);
		createEReference(mergedPartitionEClass, MERGED_PARTITION__OWNED_MERGED_PARTITIONS);

		navigableEdgeEClass = createEClass(NAVIGABLE_EDGE);
		createEReference(navigableEdgeEClass, NAVIGABLE_EDGE__INCOMING_CONNECTION);
		createEReference(navigableEdgeEClass, NAVIGABLE_EDGE__OPPOSITE_EDGE);
		createEReference(navigableEdgeEClass, NAVIGABLE_EDGE__OUTGOING_CONNECTIONS);
		createEAttribute(navigableEdgeEClass, NAVIGABLE_EDGE__SECONDARY);

		navigationEdgeEClass = createEClass(NAVIGATION_EDGE);
		createEAttribute(navigationEdgeEClass, NAVIGATION_EDGE__PARTIAL);
		createEReference(navigationEdgeEClass, NAVIGATION_EDGE__REFERRED_PROPERTY);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__CLASS_DATUM);
		createEReference(nodeEClass, NODE__CLUSTER);
		createEReference(nodeEClass, NODE__INCOMING_CONNECTION);
		createEReference(nodeEClass, NODE__INCOMING_EDGES);
		createEAttribute(nodeEClass, NODE__NAME);
		createEAttribute(nodeEClass, NODE__NODE_ROLE);
		createEReference(nodeEClass, NODE__OUTGOING_CONNECTIONS);
		createEReference(nodeEClass, NODE__OUTGOING_EDGES);
		createEReference(nodeEClass, NODE__OWNING_REGION);

		nodeConnectionEClass = createEClass(NODE_CONNECTION);
		createEReference(nodeConnectionEClass, NODE_CONNECTION__CLASS_DATUM);
		createEReference(nodeConnectionEClass, NODE_CONNECTION__MANDATORY_TARGET_NODES);
		createEReference(nodeConnectionEClass, NODE_CONNECTION__PASSED_TARGET_NODES);
		createEReference(nodeConnectionEClass, NODE_CONNECTION__PREFERRED_TARGET_NODES);

		nonPartitionEClass = createEClass(NON_PARTITION);

		nullLiteralNodeEClass = createEClass(NULL_LITERAL_NODE);

		numericLiteralNodeEClass = createEClass(NUMERIC_LITERAL_NODE);
		createEAttribute(numericLiteralNodeEClass, NUMERIC_LITERAL_NODE__NUMERIC_VALUE);

		operationCallNodeEClass = createEClass(OPERATION_CALL_NODE);
		createEReference(operationCallNodeEClass, OPERATION_CALL_NODE__REFERRED_OPERATION);

		operationNodeEClass = createEClass(OPERATION_NODE);

		operationRegionEClass = createEClass(OPERATION_REGION);
		createEReference(operationRegionEClass, OPERATION_REGION__DEPENDENCY_NODES);
		createEReference(operationRegionEClass, OPERATION_REGION__HEAD_NODES);
		createEReference(operationRegionEClass, OPERATION_REGION__REFERRED_OPERATION);
		createEReference(operationRegionEClass, OPERATION_REGION__RESULT_NODE);
		createEReference(operationRegionEClass, OPERATION_REGION__OWNING_SCHEDULE_MODEL);

		operationParameterEdgeEClass = createEClass(OPERATION_PARAMETER_EDGE);
		createEReference(operationParameterEdgeEClass, OPERATION_PARAMETER_EDGE__REFERRED_PARAMETER);
		createEAttribute(operationParameterEdgeEClass, OPERATION_PARAMETER_EDGE__PARAMETER_INDEX);

		operationSelfEdgeEClass = createEClass(OPERATION_SELF_EDGE);
		createEReference(operationSelfEdgeEClass, OPERATION_SELF_EDGE__REFERRED_TYPE);

		partitionEClass = createEClass(PARTITION);
		createEAttribute(partitionEClass, PARTITION__PASSES);
		createEReference(partitionEClass, PARTITION__INTERMEDIATE_CONNECTIONS);
		createEReference(partitionEClass, PARTITION__ROOT_CONNECTIONS);

		patternTypedNodeEClass = createEClass(PATTERN_TYPED_NODE);

		patternVariableNodeEClass = createEClass(PATTERN_VARIABLE_NODE);

		predicateEdgeEClass = createEClass(PREDICATE_EDGE);

		propertyDatumEClass = createEClass(PROPERTY_DATUM);
		createEReference(propertyDatumEClass, PROPERTY_DATUM__OPPOSITE);
		createEReference(propertyDatumEClass, PROPERTY_DATUM__OWNING_CLASS_DATUM);
		createEReference(propertyDatumEClass, PROPERTY_DATUM__REFERRED_PROPERTY);
		createEReference(propertyDatumEClass, PROPERTY_DATUM__SUPER_PROPERTY_DATUMS);
		createEAttribute(propertyDatumEClass, PROPERTY_DATUM__KEY);

		recursionEdgeEClass = createEClass(RECURSION_EDGE);
		createEAttribute(recursionEdgeEClass, RECURSION_EDGE__PRIMARY);

		regionEClass = createEClass(REGION);
		createEReference(regionEClass, REGION__OWNED_NODES);
		createEReference(regionEClass, REGION__OWNED_EDGES);
		createEReference(regionEClass, REGION__OWNED_CLUSTERS);
		createEReference(regionEClass, REGION__ROOT_REGION);

		rootPartitionEClass = createEClass(ROOT_PARTITION);
		createEReference(rootPartitionEClass, ROOT_PARTITION__OWNING_ROOT_REGION);
		createEReference(rootPartitionEClass, ROOT_PARTITION__LOADING_PARTITION);

		rootRegionEClass = createEClass(ROOT_REGION);
		createEReference(rootRegionEClass, ROOT_REGION__ACTIVE_REGIONS);
		createEReference(rootRegionEClass, ROOT_REGION__OWNED_CONNECTIONS);
		createEReference(rootRegionEClass, ROOT_REGION__OWNED_LOADING_REGION);
		createEReference(rootRegionEClass, ROOT_REGION__OWNING_SCHEDULE_MODEL);
		createEReference(rootRegionEClass, ROOT_REGION__REFERRED_TRANSFORMATION);
		createEReference(rootRegionEClass, ROOT_REGION__OWNED_ROOT_PARTITION);

		ruleRegionEClass = createEClass(RULE_REGION);
		createEReference(ruleRegionEClass, RULE_REGION__REFERRED_RULE);

		scheduleModelEClass = createEClass(SCHEDULE_MODEL);
		createEReference(scheduleModelEClass, SCHEDULE_MODEL__OWNED_CLASS_DATUMS);
		createEReference(scheduleModelEClass, SCHEDULE_MODEL__OWNED_MAPPING_REGIONS);
		createEReference(scheduleModelEClass, SCHEDULE_MODEL__OWNED_OPERATION_REGIONS);
		createEReference(scheduleModelEClass, SCHEDULE_MODEL__OWNED_ROOT_REGIONS);

		shadowNodeEClass = createEClass(SHADOW_NODE);

		shadowPartEdgeEClass = createEClass(SHADOW_PART_EDGE);
		createEReference(shadowPartEdgeEClass, SHADOW_PART_EDGE__REFERRED_PART);

		stringLiteralNodeEClass = createEClass(STRING_LITERAL_NODE);
		createEAttribute(stringLiteralNodeEClass, STRING_LITERAL_NODE__STRING_VALUE);

		successEdgeEClass = createEClass(SUCCESS_EDGE);

		successNodeEClass = createEClass(SUCCESS_NODE);

		symbolableEClass = createEClass(SYMBOLABLE);
		createEAttribute(symbolableEClass, SYMBOLABLE__SYMBOL_NAME);

		tupleLiteralNodeEClass = createEClass(TUPLE_LITERAL_NODE);

		tuplePartEdgeEClass = createEClass(TUPLE_PART_EDGE);
		createEReference(tuplePartEdgeEClass, TUPLE_PART_EDGE__REFERRED_PART);

		typeLiteralNodeEClass = createEClass(TYPE_LITERAL_NODE);
		createEReference(typeLiteralNodeEClass, TYPE_LITERAL_NODE__TYPE_VALUE);

		unknownNodeEClass = createEClass(UNKNOWN_NODE);

		variableNodeEClass = createEClass(VARIABLE_NODE);
		createEReference(variableNodeEClass, VARIABLE_NODE__REFERRED_VARIABLE);

		verdictRegionEClass = createEClass(VERDICT_REGION);
		createEReference(verdictRegionEClass, VERDICT_REGION__REFERRED_RULE_REGION);

		// Create enums
		connectionRoleEEnum = createEEnum(CONNECTION_ROLE);
		roleEEnum = createEEnum(ROLE);

		// Create data types
		numberEDataType = createEDataType(NUMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractDatumEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		argumentEdgeEClass.getESuperTypes().add(this.getExpressionEdge());
		basicPartitionEClass.getESuperTypes().add(this.getMappingPartition());
		booleanLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		castEdgeEClass.getESuperTypes().add(this.getNavigableEdge());
		classDatumEClass.getESuperTypes().add(this.getAbstractDatum());
		clusterEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		clusterEClass.getESuperTypes().add(this.getSymbolable());
		collectionLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		collectionPartEdgeEClass.getESuperTypes().add(this.getArgumentEdge());
		collectionRangeNodeEClass.getESuperTypes().add(this.getOperationNode());
		composedNodeEClass.getESuperTypes().add(this.getNode());
		compositePartitionEClass.getESuperTypes().add(this.getPartition());
		connectionEClass.getESuperTypes().add(thePivotPackage.getElement());
		connectionEClass.getESuperTypes().add(this.getSymbolable());
		cyclicMappingRegionEClass.getESuperTypes().add(this.getMappingRegion());
		cyclicPartitionEClass.getESuperTypes().add(this.getCompositePartition());
		cyclicPartitionEClass.getESuperTypes().add(this.getMappingPartition());
		dependencyEdgeEClass.getESuperTypes().add(this.getEdge());
		dependencyNodeEClass.getESuperTypes().add(this.getNode());
		dispatchRegionEClass.getESuperTypes().add(this.getRuleRegion());
		edgeEClass.getESuperTypes().add(thePivotPackage.getElement());
		edgeConnectionEClass.getESuperTypes().add(this.getConnection());
		enumLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		errorNodeEClass.getESuperTypes().add(this.getMappingNode());
		expressionEdgeEClass.getESuperTypes().add(this.getEdge());
		ifNodeEClass.getESuperTypes().add(this.getOperationNode());
		includesEdgeEClass.getESuperTypes().add(this.getExpressionEdge());
		inputNodeEClass.getESuperTypes().add(this.getNode());
		iteratedEdgeEClass.getESuperTypes().add(this.getEdge());
		iteratorNodeEClass.getESuperTypes().add(this.getVariableNode());
		keyPartEdgeEClass.getESuperTypes().add(this.getArgumentEdge());
		keyedValueNodeEClass.getESuperTypes().add(this.getOperationNode());
		loadingPartitionEClass.getESuperTypes().add(this.getMappingPartition());
		loadingRegionEClass.getESuperTypes().add(this.getRegion());
		mapLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		mapPartEdgeEClass.getESuperTypes().add(this.getArgumentEdge());
		mapPartNodeEClass.getESuperTypes().add(this.getOperationNode());
		mappingNodeEClass.getESuperTypes().add(this.getNode());
		mappingPartitionEClass.getESuperTypes().add(this.getPartition());
		mappingRegionEClass.getESuperTypes().add(this.getRegion());
		mergedPartitionEClass.getESuperTypes().add(this.getBasicPartition());
		navigableEdgeEClass.getESuperTypes().add(this.getEdge());
		navigableEdgeEClass.getESuperTypes().add(this.getConnectionEnd());
		navigationEdgeEClass.getESuperTypes().add(this.getNavigableEdge());
		nodeEClass.getESuperTypes().add(thePivotPackage.getElement());
		nodeEClass.getESuperTypes().add(this.getConnectionEnd());
		nodeConnectionEClass.getESuperTypes().add(this.getConnection());
		nonPartitionEClass.getESuperTypes().add(this.getMappingPartition());
		nullLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		numericLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		operationCallNodeEClass.getESuperTypes().add(this.getOperationNode());
		operationNodeEClass.getESuperTypes().add(this.getMappingNode());
		operationRegionEClass.getESuperTypes().add(this.getRegion());
		operationParameterEdgeEClass.getESuperTypes().add(this.getArgumentEdge());
		operationSelfEdgeEClass.getESuperTypes().add(this.getArgumentEdge());
		partitionEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		patternTypedNodeEClass.getESuperTypes().add(this.getMappingNode());
		patternVariableNodeEClass.getESuperTypes().add(this.getVariableNode());
		predicateEdgeEClass.getESuperTypes().add(this.getEdge());
		propertyDatumEClass.getESuperTypes().add(this.getAbstractDatum());
		recursionEdgeEClass.getESuperTypes().add(this.getEdge());
		regionEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		regionEClass.getESuperTypes().add(this.getSymbolable());
		rootPartitionEClass.getESuperTypes().add(this.getCompositePartition());
		rootRegionEClass.getESuperTypes().add(this.getRegion());
		ruleRegionEClass.getESuperTypes().add(this.getMappingRegion());
		scheduleModelEClass.getESuperTypes().add(thePivotPackage.getModel());
		shadowNodeEClass.getESuperTypes().add(this.getOperationNode());
		shadowPartEdgeEClass.getESuperTypes().add(this.getArgumentEdge());
		stringLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		successEdgeEClass.getESuperTypes().add(this.getNavigationEdge());
		successNodeEClass.getESuperTypes().add(this.getMappingNode());
		tupleLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		tuplePartEdgeEClass.getESuperTypes().add(this.getArgumentEdge());
		typeLiteralNodeEClass.getESuperTypes().add(this.getOperationNode());
		unknownNodeEClass.getESuperTypes().add(this.getMappingNode());
		variableNodeEClass.getESuperTypes().add(this.getMappingNode());
		verdictRegionEClass.getESuperTypes().add(this.getRuleRegion());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractDatumEClass, AbstractDatum.class, "AbstractDatum", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractDatum_ReferredTypedModel(), theQVTbasePackage.getTypedModel(), null, "referredTypedModel", null, 1, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(argumentEdgeEClass, ArgumentEdge.class, "ArgumentEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicPartitionEClass, BasicPartition.class, "BasicPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicPartition_ConstantEdges(), this.getEdge(), null, "constantEdges", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_ConstantNodes(), this.getNode(), null, "constantNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_ConstantSuccessFalseNodes(), this.getNode(), null, "constantSuccessFalseNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_ConstantSuccessTrueNodes(), this.getNode(), null, "constantSuccessTrueNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_ExplicitPredecessors(), this.getMappingPartition(), this.getMappingPartition_ExplicitSuccessors(), "explicitPredecessors", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_HeadNodes(), this.getNode(), null, "headNodes", null, 1, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicPartition_LoadedEdges(), this.getEdge(), null, "loadedEdges", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_LoadedNodes(), this.getNode(), null, "loadedNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_PredicatedEdges(), this.getEdge(), null, "predicatedEdges", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_PredicatedNodes(), this.getNode(), null, "predicatedNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_RealizedEdges(), this.getEdge(), null, "realizedEdges", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_RealizedNodes(), this.getNode(), null, "realizedNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_SpeculatedEdges(), this.getEdge(), null, "speculatedEdges", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_SpeculatedNodes(), this.getNode(), null, "speculatedNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_SpeculationNodes(), this.getNode(), null, "speculationNodes", null, 0, -1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicPartition_OwningMergedPartition(), this.getMergedPartition(), this.getMergedPartition_OwnedMergedPartitions(), "owningMergedPartition", null, 0, 1, BasicPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralNodeEClass, BooleanLiteralNode.class, "BooleanLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteralNode_BooleanValue(), thePivotPackage.getBoolean(), "booleanValue", null, 1, 1, BooleanLiteralNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(castEdgeEClass, CastEdge.class, "CastEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCastEdge_Property(), thePivotPackage.getProperty(), null, "property", null, 1, 1, CastEdge.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCastEdge_ReferredClass(), thePivotPackage.getClass_(), null, "referredClass", null, 1, 1, CastEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classDatumEClass, ClassDatum.class, "ClassDatum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassDatum_CompleteClass(), thePivotPackage.getCompleteClass(), null, "completeClass", null, 1, 1, ClassDatum.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getClassDatum_OwnedPropertyDatums(), this.getPropertyDatum(), this.getPropertyDatum_OwningClassDatum(), "ownedPropertyDatums", null, 0, -1, ClassDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassDatum_OwningScheduleModel(), this.getScheduleModel(), this.getScheduleModel_OwnedClassDatums(), "owningScheduleModel", null, 1, 1, ClassDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassDatum_ReferredClass(), thePivotPackage.getClass_(), null, "referredClass", null, 1, 1, ClassDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassDatum_SuperClassDatums(), this.getClassDatum(), null, "superClassDatums", null, 0, -1, ClassDatum.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clusterEClass, Cluster.class, "Cluster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCluster_OwningRegion(), this.getRegion(), this.getRegion_OwnedClusters(), "owningRegion", null, 1, 1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCluster_MemberNodes(), this.getNode(), this.getNode_Cluster(), "memberNodes", null, 0, -1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCluster_MemberEdges(), this.getEdge(), this.getEdge_Cluster(), "memberEdges", null, 0, -1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCluster_PrecedingClusters(), this.getCluster(), this.getCluster_SucceedingClusters(), "precedingClusters", null, 0, -1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCluster_SucceedingClusters(), this.getCluster(), this.getCluster_PrecedingClusters(), "succeedingClusters", null, 0, -1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCluster_Depth(), ecorePackage.getEIntegerObject(), "depth", null, 0, 1, Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionLiteralNodeEClass, CollectionLiteralNode.class, "CollectionLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionPartEdgeEClass, CollectionPartEdge.class, "CollectionPartEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionPartEdge_ReferredPart(), thePivotPackage.getCollectionLiteralPart(), null, "referredPart", null, 1, 1, CollectionPartEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionRangeNodeEClass, CollectionRangeNode.class, "CollectionRangeNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(composedNodeEClass, ComposedNode.class, "ComposedNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositePartitionEClass, CompositePartition.class, "CompositePartition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositePartition_OwnedMappingPartitions(), this.getMappingPartition(), this.getMappingPartition_OwningCompositePartition(), "ownedMappingPartitions", null, 0, -1, CompositePartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_OwningRootRegion(), this.getRootRegion(), this.getRootRegion_OwnedConnections(), "owningRootRegion", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_ConnectionRole(), this.getConnectionRole(), "connectionRole", "UNDEFINED", 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_Name(), ecorePackage.getEString(), "name", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_SourceEnds(), this.getConnectionEnd(), null, "sourceEnds", null, 0, -1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnection_IntermediatePartitions(), this.getPartition(), null, "intermediatePartitions", null, 0, -1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnection_CommonPartition(), this.getPartition(), null, "commonPartition", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(connectionEndEClass, ConnectionEnd.class, "ConnectionEnd", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cyclicMappingRegionEClass, CyclicMappingRegion.class, "CyclicMappingRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCyclicMappingRegion_ElementRegions(), this.getMappingRegion(), null, "elementRegions", null, 1, -1, CyclicMappingRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cyclicPartitionEClass, CyclicPartition.class, "CyclicPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dependencyEdgeEClass, DependencyEdge.class, "DependencyEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dependencyNodeEClass, DependencyNode.class, "DependencyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dispatchRegionEClass, DispatchRegion.class, "DispatchRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatchRegion_ReferredRuleRegion(), this.getRuleRegion(), null, "referredRuleRegion", null, 1, 1, DispatchRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Cluster(), this.getCluster(), this.getCluster_MemberEdges(), "cluster", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEdge_EdgeRole(), this.getRole(), "edgeRole", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEdge_Name(), ecorePackage.getEString(), "name", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_OwningRegion(), this.getRegion(), this.getRegion_OwnedEdges(), "owningRegion", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_SourceNode(), this.getNode(), this.getNode_OutgoingEdges(), "sourceNode", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_TargetNode(), this.getNode(), this.getNode_IncomingEdges(), "targetNode", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeConnectionEClass, EdgeConnection.class, "EdgeConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeConnection_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 1, 1, EdgeConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgeConnection_MandatoryTargetEdges(), this.getNavigableEdge(), null, "mandatoryTargetEdges", null, 0, -1, EdgeConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEdgeConnection_PreferredTargetEdges(), this.getNavigableEdge(), null, "preferredTargetEdges", null, 0, -1, EdgeConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumLiteralNodeEClass, EnumLiteralNode.class, "EnumLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumLiteralNode_EnumValue(), thePivotPackage.getEnumerationLiteral(), null, "enumValue", null, 1, 1, EnumLiteralNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorNodeEClass, ErrorNode.class, "ErrorNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionEdgeEClass, ExpressionEdge.class, "ExpressionEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifNodeEClass, IfNode.class, "IfNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(includesEdgeEClass, IncludesEdge.class, "IncludesEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputNodeEClass, InputNode.class, "InputNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iteratedEdgeEClass, IteratedEdge.class, "IteratedEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iteratorNodeEClass, IteratorNode.class, "IteratorNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(keyPartEdgeEClass, KeyPartEdge.class, "KeyPartEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyPartEdge_ReferredPart(), this.getPropertyDatum(), null, "referredPart", null, 1, 1, KeyPartEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyedValueNodeEClass, KeyedValueNode.class, "KeyedValueNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyedValueNode_ClassDatumValue(), this.getClassDatum(), null, "classDatumValue", null, 1, 1, KeyedValueNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadingPartitionEClass, LoadingPartition.class, "LoadingPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoadingPartition_ReferredLoadingRegion(), this.getLoadingRegion(), this.getLoadingRegion_LoadingPartition(), "referredLoadingRegion", null, 1, 1, LoadingPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadingRegionEClass, LoadingRegion.class, "LoadingRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoadingRegion_LoadingPartition(), this.getLoadingPartition(), this.getLoadingPartition_ReferredLoadingRegion(), "loadingPartition", null, 1, 1, LoadingRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoadingRegion_OwningRootRegion(), this.getRootRegion(), this.getRootRegion_OwnedLoadingRegion(), "owningRootRegion", null, 1, 1, LoadingRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapLiteralNodeEClass, MapLiteralNode.class, "MapLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapPartEdgeEClass, MapPartEdge.class, "MapPartEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapPartEdge_ReferredPart(), thePivotPackage.getMapLiteralPart(), null, "referredPart", null, 1, 1, MapPartEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapPartNodeEClass, MapPartNode.class, "MapPartNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingNodeEClass, MappingNode.class, "MappingNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingNode_Matched(), ecorePackage.getEBoolean(), "matched", "false", 1, 1, MappingNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingPartitionEClass, MappingPartition.class, "MappingPartition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingPartition_OwningCompositePartition(), this.getCompositePartition(), this.getCompositePartition_OwnedMappingPartitions(), "owningCompositePartition", null, 0, 1, MappingPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingPartition_ReferedMappingRegion(), this.getMappingRegion(), this.getMappingRegion_MappingPartitions(), "referedMappingRegion", null, 0, 1, MappingPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingPartition_Region(), this.getRegion(), null, "region", null, 1, 1, MappingPartition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingPartition_RootPartition(), this.getRootPartition(), null, "rootPartition", null, 1, 1, MappingPartition.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingPartition_ExplicitSuccessors(), this.getBasicPartition(), this.getBasicPartition_ExplicitPredecessors(), "explicitSuccessors", null, 0, -1, MappingPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mappingRegionEClass, MappingRegion.class, "MappingRegion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingRegion_HeadNodes(), this.getNode(), null, "headNodes", null, 0, -1, MappingRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingRegion_MappingPartitions(), this.getMappingPartition(), this.getMappingPartition_ReferedMappingRegion(), "mappingPartitions", null, 0, -1, MappingRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingRegion_OwningScheduleModel(), this.getScheduleModel(), this.getScheduleModel_OwnedMappingRegions(), "owningScheduleModel", null, 0, 1, MappingRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mergedPartitionEClass, MergedPartition.class, "MergedPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMergedPartition_OwnedMergedPartitions(), this.getBasicPartition(), this.getBasicPartition_OwningMergedPartition(), "ownedMergedPartitions", null, 0, -1, MergedPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigableEdgeEClass, NavigableEdge.class, "NavigableEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigableEdge_IncomingConnection(), this.getEdgeConnection(), null, "incomingConnection", null, 0, 1, NavigableEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigableEdge_OppositeEdge(), this.getNavigableEdge(), null, "oppositeEdge", null, 0, 1, NavigableEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigableEdge_OutgoingConnections(), this.getEdgeConnection(), null, "outgoingConnections", null, 0, -1, NavigableEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigableEdge_Secondary(), ecorePackage.getEBoolean(), "secondary", "false", 1, 1, NavigableEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigationEdgeEClass, NavigationEdge.class, "NavigationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNavigationEdge_Partial(), ecorePackage.getEBoolean(), "partial", "false", 1, 1, NavigationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigationEdge_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 1, 1, NavigationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_ClassDatum(), this.getClassDatum(), null, "classDatum", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Cluster(), this.getCluster(), this.getCluster_MemberNodes(), "cluster", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_IncomingConnection(), this.getNodeConnection(), null, "incomingConnection", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_IncomingEdges(), this.getEdge(), this.getEdge_TargetNode(), "incomingEdges", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_NodeRole(), this.getRole(), "nodeRole", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OutgoingConnections(), this.getNodeConnection(), null, "outgoingConnections", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OutgoingEdges(), this.getEdge(), this.getEdge_SourceNode(), "outgoingEdges", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OwningRegion(), this.getRegion(), this.getRegion_OwnedNodes(), "owningRegion", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeConnectionEClass, NodeConnection.class, "NodeConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeConnection_ClassDatum(), this.getClassDatum(), null, "classDatum", null, 1, 1, NodeConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeConnection_MandatoryTargetNodes(), this.getNode(), null, "mandatoryTargetNodes", null, 0, -1, NodeConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNodeConnection_PassedTargetNodes(), this.getNode(), null, "passedTargetNodes", null, 0, -1, NodeConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNodeConnection_PreferredTargetNodes(), this.getNode(), null, "preferredTargetNodes", null, 0, -1, NodeConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nonPartitionEClass, NonPartition.class, "NonPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullLiteralNodeEClass, NullLiteralNode.class, "NullLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericLiteralNodeEClass, NumericLiteralNode.class, "NumericLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericLiteralNode_NumericValue(), this.getNumber(), "numericValue", null, 1, 1, NumericLiteralNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationCallNodeEClass, OperationCallNode.class, "OperationCallNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCallNode_ReferredOperation(), thePivotPackage.getOperation(), null, "referredOperation", null, 0, 1, OperationCallNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationNodeEClass, OperationNode.class, "OperationNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationRegionEClass, OperationRegion.class, "OperationRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationRegion_DependencyNodes(), this.getNode(), null, "dependencyNodes", null, 0, -1, OperationRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationRegion_HeadNodes(), this.getNode(), null, "headNodes", null, 0, -1, OperationRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationRegion_ReferredOperation(), thePivotPackage.getOperation(), null, "referredOperation", null, 1, 1, OperationRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationRegion_ResultNode(), this.getNode(), null, "resultNode", null, 0, 1, OperationRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationRegion_OwningScheduleModel(), this.getScheduleModel(), this.getScheduleModel_OwnedOperationRegions(), "owningScheduleModel", null, 1, 1, OperationRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationParameterEdgeEClass, OperationParameterEdge.class, "OperationParameterEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationParameterEdge_ReferredParameter(), thePivotPackage.getParameter(), null, "referredParameter", null, 1, 1, OperationParameterEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationParameterEdge_ParameterIndex(), ecorePackage.getEInt(), "parameterIndex", "-1", 1, 1, OperationParameterEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationSelfEdgeEClass, OperationSelfEdge.class, "OperationSelfEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationSelfEdge_ReferredType(), thePivotPackage.getType(), null, "referredType", null, 1, 1, OperationSelfEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partitionEClass, Partition.class, "Partition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartition_Passes(), ecorePackage.getEInt(), "passes", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartition_IntermediateConnections(), this.getNodeConnection(), null, "intermediateConnections", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPartition_RootConnections(), this.getNodeConnection(), null, "rootConnections", null, 0, -1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(patternTypedNodeEClass, PatternTypedNode.class, "PatternTypedNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternVariableNodeEClass, PatternVariableNode.class, "PatternVariableNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(predicateEdgeEClass, PredicateEdge.class, "PredicateEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyDatumEClass, PropertyDatum.class, "PropertyDatum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyDatum_Opposite(), this.getPropertyDatum(), null, "opposite", null, 0, 1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyDatum_OwningClassDatum(), this.getClassDatum(), this.getClassDatum_OwnedPropertyDatums(), "owningClassDatum", null, 1, 1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyDatum_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 1, 1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyDatum_SuperPropertyDatums(), this.getPropertyDatum(), null, "superPropertyDatums", null, 0, -1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyDatum_Key(), ecorePackage.getEBoolean(), "key", null, 0, 1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recursionEdgeEClass, RecursionEdge.class, "RecursionEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecursionEdge_Primary(), ecorePackage.getEBoolean(), "primary", "false", 1, 1, RecursionEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regionEClass, Region.class, "Region", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegion_OwnedNodes(), this.getNode(), this.getNode_OwningRegion(), "ownedNodes", null, 0, -1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegion_OwnedEdges(), this.getEdge(), this.getEdge_OwningRegion(), "ownedEdges", null, 0, -1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegion_OwnedClusters(), this.getCluster(), this.getCluster_OwningRegion(), "ownedClusters", null, 0, -1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegion_RootRegion(), this.getRootRegion(), this.getRootRegion_ActiveRegions(), "rootRegion", null, 0, 1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootPartitionEClass, RootPartition.class, "RootPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootPartition_OwningRootRegion(), this.getRootRegion(), this.getRootRegion_OwnedRootPartition(), "owningRootRegion", null, 1, 1, RootPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootPartition_LoadingPartition(), this.getLoadingPartition(), null, "loadingPartition", null, 0, 1, RootPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootRegionEClass, RootRegion.class, "RootRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootRegion_ActiveRegions(), this.getRegion(), this.getRegion_RootRegion(), "activeRegions", null, 0, -1, RootRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootRegion_OwnedConnections(), this.getConnection(), this.getConnection_OwningRootRegion(), "ownedConnections", null, 0, -1, RootRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootRegion_OwnedLoadingRegion(), this.getLoadingRegion(), this.getLoadingRegion_OwningRootRegion(), "ownedLoadingRegion", null, 1, 1, RootRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootRegion_OwningScheduleModel(), this.getScheduleModel(), this.getScheduleModel_OwnedRootRegions(), "owningScheduleModel", null, 1, 1, RootRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootRegion_ReferredTransformation(), theQVTbasePackage.getTransformation(), null, "referredTransformation", null, 0, 1, RootRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootRegion_OwnedRootPartition(), this.getRootPartition(), this.getRootPartition_OwningRootRegion(), "ownedRootPartition", null, 0, 1, RootRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleRegionEClass, RuleRegion.class, "RuleRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleRegion_ReferredRule(), theQVTbasePackage.getRule(), null, "referredRule", null, 1, 1, RuleRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scheduleModelEClass, ScheduleModel.class, "ScheduleModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduleModel_OwnedClassDatums(), this.getClassDatum(), this.getClassDatum_OwningScheduleModel(), "ownedClassDatums", null, 0, -1, ScheduleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduleModel_OwnedMappingRegions(), this.getMappingRegion(), this.getMappingRegion_OwningScheduleModel(), "ownedMappingRegions", null, 0, -1, ScheduleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduleModel_OwnedOperationRegions(), this.getOperationRegion(), this.getOperationRegion_OwningScheduleModel(), "ownedOperationRegions", null, 0, -1, ScheduleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduleModel_OwnedRootRegions(), this.getRootRegion(), this.getRootRegion_OwningScheduleModel(), "ownedRootRegions", null, 0, -1, ScheduleModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shadowNodeEClass, ShadowNode.class, "ShadowNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shadowPartEdgeEClass, ShadowPartEdge.class, "ShadowPartEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShadowPartEdge_ReferredPart(), thePivotPackage.getShadowPart(), null, "referredPart", null, 1, 1, ShadowPartEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralNodeEClass, StringLiteralNode.class, "StringLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralNode_StringValue(), thePivotPackage.getString(), "stringValue", null, 1, 1, StringLiteralNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(successEdgeEClass, SuccessEdge.class, "SuccessEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(successNodeEClass, SuccessNode.class, "SuccessNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(symbolableEClass, Symbolable.class, "Symbolable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSymbolable_SymbolName(), ecorePackage.getEString(), "symbolName", null, 1, 1, Symbolable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tupleLiteralNodeEClass, TupleLiteralNode.class, "TupleLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tuplePartEdgeEClass, TuplePartEdge.class, "TuplePartEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTuplePartEdge_ReferredPart(), thePivotPackage.getTupleLiteralPart(), null, "referredPart", null, 1, 1, TuplePartEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeLiteralNodeEClass, TypeLiteralNode.class, "TypeLiteralNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeLiteralNode_TypeValue(), thePivotPackage.getType(), null, "typeValue", null, 1, 1, TypeLiteralNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unknownNodeEClass, UnknownNode.class, "UnknownNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableNodeEClass, VariableNode.class, "VariableNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableNode_ReferredVariable(), thePivotPackage.getVariableDeclaration(), null, "referredVariable", null, 1, 1, VariableNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(verdictRegionEClass, VerdictRegion.class, "VerdictRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVerdictRegion_ReferredRuleRegion(), this.getRuleRegion(), null, "referredRuleRegion", null, 1, 1, VerdictRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(connectionRoleEEnum, ConnectionRole.class, "ConnectionRole");
		addEEnumLiteral(connectionRoleEEnum, ConnectionRole.MANDATORY_EDGE);
		addEEnumLiteral(connectionRoleEEnum, ConnectionRole.MANDATORY_NODE);
		addEEnumLiteral(connectionRoleEEnum, ConnectionRole.PASSED);
		addEEnumLiteral(connectionRoleEEnum, ConnectionRole.PREFERRED_EDGE);
		addEEnumLiteral(connectionRoleEEnum, ConnectionRole.PREFERRED_NODE);
		addEEnumLiteral(connectionRoleEEnum, ConnectionRole.UNDEFINED);

		initEEnum(roleEEnum, Role.class, "Role");
		addEEnumLiteral(roleEEnum, Role.CONSTANT);
		addEEnumLiteral(roleEEnum, Role.CONSTANT_SUCCESS_FALSE);
		addEEnumLiteral(roleEEnum, Role.CONSTANT_SUCCESS_TRUE);
		addEEnumLiteral(roleEEnum, Role.LOADED);
		addEEnumLiteral(roleEEnum, Role.REALIZED);
		addEEnumLiteral(roleEEnum, Role.PREDICATED);
		addEEnumLiteral(roleEEnum, Role.SPECULATION);
		addEEnumLiteral(roleEEnum, Role.SPECULATED);
		addEEnumLiteral(roleEEnum, Role.OTHER);

		// Initialize data types
		initEDataType(numberEDataType, Number.class, "Number", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
		   });
	}

	/**
	 * Overridden to populate the idToEObjectMap/eObjectToIDMap maps when an attempt is made to use them.
	 *
	 * @generated NOT
	 */
	@Override
	protected Resource createResource(/*@NonNull*/ String uri) {
		return LazyXMIidAssigningResourceImpl.createResource(uri, this);
	}
} //QVTschedulePackageImpl
