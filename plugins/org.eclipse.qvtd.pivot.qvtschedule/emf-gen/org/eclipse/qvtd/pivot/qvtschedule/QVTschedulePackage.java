/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface QVTschedulePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtschedule";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2017/QVTschedule";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvts";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtschedule";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTschedulePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum
	 * @generated
	 */
	EClass getAbstractDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getReferredTypedModel()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_ReferredTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge <em>Argument Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge
	 * @generated
	 */
	EClass getArgumentEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition <em>Basic Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition
	 * @generated
	 */
	EClass getBasicPartition();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantEdges <em>Constant Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constant Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantEdges()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_ConstantEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantNodes <em>Constant Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constant Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_ConstantNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantSuccessFalseNodes <em>Constant Success False Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constant Success False Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantSuccessFalseNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_ConstantSuccessFalseNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantSuccessTrueNodes <em>Constant Success True Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constant Success True Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantSuccessTrueNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_ConstantSuccessTrueNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getHeadNodes <em>Head Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Head Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getHeadNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_HeadNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getLoadedEdges <em>Loaded Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Loaded Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getLoadedEdges()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_LoadedEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getLoadedNodes <em>Loaded Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Loaded Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getLoadedNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_LoadedNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getPredicatedEdges <em>Predicated Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Predicated Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getPredicatedEdges()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_PredicatedEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getPredicatedNodes <em>Predicated Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Predicated Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getPredicatedNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_PredicatedNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getRealizedEdges <em>Realized Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getRealizedEdges()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_RealizedEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getRealizedNodes <em>Realized Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getRealizedNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_RealizedNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculatedEdges <em>Speculated Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Speculated Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculatedEdges()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_SpeculatedEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculatedNodes <em>Speculated Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Speculated Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculatedNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_SpeculatedNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculationNodes <em>Speculation Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Speculation Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculationNodes()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_SpeculationNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getOwningMergedPartition <em>Owning Merged Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Merged Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getOwningMergedPartition()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_OwningMergedPartition();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getExplicitPredecessors <em>Explicit Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Explicit Predecessors</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getExplicitPredecessors()
	 * @see #getBasicPartition()
	 * @generated
	 */
	EReference getBasicPartition_ExplicitPredecessors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode <em>Boolean Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode
	 * @generated
	 */
	EClass getBooleanLiteralNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode#isBooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode#isBooleanValue()
	 * @see #getBooleanLiteralNode()
	 * @generated
	 */
	EAttribute getBooleanLiteralNode_BooleanValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge <em>Cast Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cast Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CastEdge
	 * @generated
	 */
	EClass getCastEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getReferredClassDatum <em>Referred Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getReferredClassDatum()
	 * @see #getCastEdge()
	 * @generated
	 */
	EReference getCastEdge_ReferredClassDatum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum
	 * @generated
	 */
	EClass getClassDatum();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getCompleteClasses <em>Complete Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complete Classes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getCompleteClasses()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_CompleteClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwnedPropertyDatums <em>Owned Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwnedPropertyDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_OwnedPropertyDatums();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_OwningScheduleModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getReferredClass()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_ReferredClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getSuperClassDatums <em>Super Class Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Class Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getSuperClassDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_SuperClassDatums();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cluster</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster
	 * @generated
	 */
	EClass getCluster();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_OwningRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberNodes <em>Member Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberNodes()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_MemberNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberEdges <em>Member Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberEdges()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_MemberEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getPrecedingClusters <em>Preceding Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Preceding Clusters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getPrecedingClusters()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_PrecedingClusters();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getSucceedingClusters <em>Succeeding Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Succeeding Clusters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getSucceedingClusters()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_SucceedingClusters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getDepth()
	 * @see #getCluster()
	 * @generated
	 */
	EAttribute getCluster_Depth();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum <em>Collection Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum
	 * @generated
	 */
	EClass getCollectionClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum#getElementalClassDatum <em>Elemental Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Elemental Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum#getElementalClassDatum()
	 * @see #getCollectionClassDatum()
	 * @generated
	 */
	EReference getCollectionClassDatum_ElementalClassDatum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode <em>Collection Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode
	 * @generated
	 */
	EClass getCollectionLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge <em>Collection Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge
	 * @generated
	 */
	EClass getCollectionPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge#getReferredPart()
	 * @see #getCollectionPartEdge()
	 * @generated
	 */
	EReference getCollectionPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode <em>Collection Range Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode
	 * @generated
	 */
	EClass getCollectionRangeNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ComposedNode <em>Composed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ComposedNode
	 * @generated
	 */
	EClass getComposedNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CompositePartition <em>Composite Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CompositePartition
	 * @generated
	 */
	EClass getCompositePartition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.CompositePartition#getOwnedMappingPartitions <em>Owned Mapping Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Partitions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CompositePartition#getOwnedMappingPartitions()
	 * @see #getCompositePartition()
	 * @generated
	 */
	EReference getCompositePartition_OwnedMappingPartitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningRootRegion <em>Owning Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Root Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningRootRegion()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_OwningRootRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getConnectionRole <em>Connection Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getConnectionRole()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ConnectionRole();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getName()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getSourceEnds <em>Source Ends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Ends</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getSourceEnds()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_SourceEnds();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getIntermediatePartitions <em>Intermediate Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Intermediate Partitions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getIntermediatePartitions()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_IntermediatePartitions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getCommonPartition <em>Common Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Common Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getCommonPartition()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_CommonPartition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection End</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @generated
	 */
	EClass getConnectionEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion <em>Cyclic Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cyclic Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion
	 * @generated
	 */
	EClass getCyclicMappingRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion#getElementRegions <em>Element Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion#getElementRegions()
	 * @see #getCyclicMappingRegion()
	 * @generated
	 */
	EReference getCyclicMappingRegion_ElementRegions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition <em>Cyclic Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cyclic Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition
	 * @generated
	 */
	EClass getCyclicPartition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge <em>Dependency Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge
	 * @generated
	 */
	EClass getDependencyEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DependencyNode <em>Dependency Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DependencyNode
	 * @generated
	 */
	EClass getDependencyNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion <em>Dispatch Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion
	 * @generated
	 */
	EClass getDispatchRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion#getReferredRuleRegion <em>Referred Rule Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rule Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion#getReferredRuleRegion()
	 * @see #getDispatchRegion()
	 * @generated
	 */
	EReference getDispatchRegion_ReferredRuleRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cluster</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Cluster();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole <em>Edge Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_EdgeRole();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getName()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_OwningRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_SourceNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_TargetNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection <em>Edge Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection
	 * @generated
	 */
	EClass getEdgeConnection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getReferredProperty()
	 * @see #getEdgeConnection()
	 * @generated
	 */
	EReference getEdgeConnection_ReferredProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getMandatoryTargetEdges <em>Mandatory Target Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mandatory Target Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getMandatoryTargetEdges()
	 * @see #getEdgeConnection()
	 * @generated
	 */
	EReference getEdgeConnection_MandatoryTargetEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getPreferredTargetEdges <em>Preferred Target Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Preferred Target Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getPreferredTargetEdges()
	 * @see #getEdgeConnection()
	 * @generated
	 */
	EReference getEdgeConnection_PreferredTargetEdges();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode <em>Enum Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode
	 * @generated
	 */
	EClass getEnumLiteralNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode#getEnumValue <em>Enum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode#getEnumValue()
	 * @see #getEnumLiteralNode()
	 * @generated
	 */
	EReference getEnumLiteralNode_EnumValue();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @generated
	 */
	EEnum getRole();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A primitive type representing the mathematical concept of real or integer.
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getNumber();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel <em>Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel
	 * @generated
	 */
	EClass getScheduleModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedClassDatums <em>Owned Class Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Class Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedClassDatums()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedClassDatums();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedOperationRegions <em>Owned Operation Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedOperationRegions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedOperationRegions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedRootRegions <em>Owned Root Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Root Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedRootRegions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedRootRegions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingRegions <em>Owned Mapping Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingRegions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedMappingRegions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowNode <em>Shadow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowNode
	 * @generated
	 */
	EClass getShadowNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge <em>Shadow Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge
	 * @generated
	 */
	EClass getShadowPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge#getReferredPart()
	 * @see #getShadowPartEdge()
	 * @generated
	 */
	EReference getShadowPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode <em>String Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode
	 * @generated
	 */
	EClass getStringLiteralNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode#getStringValue()
	 * @see #getStringLiteralNode()
	 * @generated
	 */
	EAttribute getStringLiteralNode_StringValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge <em>Success Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Success Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge
	 * @generated
	 */
	EClass getSuccessEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.SuccessNode <em>Success Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Success Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.SuccessNode
	 * @generated
	 */
	EClass getSuccessNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
	 * @generated
	 */
	EClass getSymbolable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable#getSymbolName <em>Symbol Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable#getSymbolName()
	 * @see #getSymbolable()
	 * @generated
	 */
	EAttribute getSymbolable_SymbolName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode <em>Tuple Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode
	 * @generated
	 */
	EClass getTupleLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge <em>Tuple Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge
	 * @generated
	 */
	EClass getTuplePartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge#getReferredPart()
	 * @see #getTuplePartEdge()
	 * @generated
	 */
	EReference getTuplePartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode <em>Type Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode
	 * @generated
	 */
	EClass getTypeLiteralNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode#getTypeValue <em>Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode#getTypeValue()
	 * @see #getTypeLiteralNode()
	 * @generated
	 */
	EReference getTypeLiteralNode_TypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.UnknownNode <em>Unknown Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.UnknownNode
	 * @generated
	 */
	EClass getUnknownNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.VariableNode <em>Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VariableNode
	 * @generated
	 */
	EClass getVariableNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.VariableNode#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VariableNode#getReferredVariable()
	 * @see #getVariableNode()
	 * @generated
	 */
	EReference getVariableNode_ReferredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion <em>Verdict Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verdict Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion
	 * @generated
	 */
	EClass getVerdictRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion#getReferredRuleRegion <em>Referred Rule Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rule Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion#getReferredRuleRegion()
	 * @see #getVerdictRegion()
	 * @generated
	 */
	EReference getVerdictRegion_ReferredRuleRegion();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @generated
	 */
	EEnum getConnectionRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ErrorNode <em>Error Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ErrorNode
	 * @generated
	 */
	EClass getErrorNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge <em>Expression Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge
	 * @generated
	 */
	EClass getExpressionEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IfNode <em>If Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IfNode
	 * @generated
	 */
	EClass getIfNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge <em>Includes Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Includes Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge
	 * @generated
	 */
	EClass getIncludesEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.InputNode <em>Input Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.InputNode
	 * @generated
	 */
	EClass getInputNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge <em>Iterated Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterated Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge
	 * @generated
	 */
	EClass getIteratedEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratorNode <em>Iterator Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratorNode
	 * @generated
	 */
	EClass getIteratorNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge <em>Key Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge
	 * @generated
	 */
	EClass getKeyPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge#getReferredPart()
	 * @see #getKeyPartEdge()
	 * @generated
	 */
	EReference getKeyPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode <em>Keyed Value Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyed Value Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode
	 * @generated
	 */
	EClass getKeyedValueNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode#getClassDatumValue <em>Class Datum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Datum Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode#getClassDatumValue()
	 * @see #getKeyedValueNode()
	 * @generated
	 */
	EReference getKeyedValueNode_ClassDatumValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition <em>Loading Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loading Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition
	 * @generated
	 */
	EClass getLoadingPartition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition#getReferredLoadingRegion <em>Referred Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Loading Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition#getReferredLoadingRegion()
	 * @see #getLoadingPartition()
	 * @generated
	 */
	EReference getLoadingPartition_ReferredLoadingRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion <em>Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loading Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion
	 * @generated
	 */
	EClass getLoadingRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getLoadingPartition <em>Loading Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loading Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getLoadingPartition()
	 * @see #getLoadingRegion()
	 * @generated
	 */
	EReference getLoadingRegion_LoadingPartition();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningRootRegion <em>Owning Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Root Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningRootRegion()
	 * @see #getLoadingRegion()
	 * @generated
	 */
	EReference getLoadingRegion_OwningRootRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode <em>Map Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode
	 * @generated
	 */
	EClass getMapLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge <em>Map Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge
	 * @generated
	 */
	EClass getMapPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge#getReferredPart()
	 * @see #getMapPartEdge()
	 * @generated
	 */
	EReference getMapPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartNode <em>Map Part Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Part Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartNode
	 * @generated
	 */
	EClass getMapPartNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingNode <em>Mapping Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingNode
	 * @generated
	 */
	EClass getMappingNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingNode#isMatched <em>Matched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matched</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingNode#isMatched()
	 * @see #getMappingNode()
	 * @generated
	 */
	EAttribute getMappingNode_Matched();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition <em>Mapping Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition
	 * @generated
	 */
	EClass getMappingPartition();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getOwningCompositePartition <em>Owning Composite Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Composite Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getOwningCompositePartition()
	 * @see #getMappingPartition()
	 * @generated
	 */
	EReference getMappingPartition_OwningCompositePartition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getReferedMappingRegion <em>Refered Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refered Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getReferedMappingRegion()
	 * @see #getMappingPartition()
	 * @generated
	 */
	EReference getMappingPartition_ReferedMappingRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getRegion()
	 * @see #getMappingPartition()
	 * @generated
	 */
	EReference getMappingPartition_Region();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getExplicitSuccessors <em>Explicit Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Explicit Successors</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getExplicitSuccessors()
	 * @see #getMappingPartition()
	 * @generated
	 */
	EReference getMappingPartition_ExplicitSuccessors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion <em>Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion
	 * @generated
	 */
	EClass getMappingRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getHeadNodes <em>Head Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Head Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getHeadNodes()
	 * @see #getMappingRegion()
	 * @generated
	 */
	EReference getMappingRegion_HeadNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getMappingPartitions <em>Mapping Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mapping Partitions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getMappingPartitions()
	 * @see #getMappingRegion()
	 * @generated
	 */
	EReference getMappingRegion_MappingPartitions();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduleModel()
	 * @see #getMappingRegion()
	 * @generated
	 */
	EReference getMappingRegion_OwningScheduleModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MergedPartition <em>Merged Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merged Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MergedPartition
	 * @generated
	 */
	EClass getMergedPartition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MergedPartition#getOwnedMergedPartitions <em>Owned Merged Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Merged Partitions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MergedPartition#getOwnedMergedPartitions()
	 * @see #getMergedPartition()
	 * @generated
	 */
	EReference getMergedPartition_OwnedMergedPartitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge <em>Navigable Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigable Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge
	 * @generated
	 */
	EClass getNavigableEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getIncomingConnection <em>Incoming Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getIncomingConnection()
	 * @see #getNavigableEdge()
	 * @generated
	 */
	EReference getNavigableEdge_IncomingConnection();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOutgoingConnections()
	 * @see #getNavigableEdge()
	 * @generated
	 */
	EReference getNavigableEdge_OutgoingConnections();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge <em>Navigation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge
	 * @generated
	 */
	EClass getNavigationEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getOppositeEdge <em>Opposite Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getOppositeEdge()
	 * @see #getNavigationEdge()
	 * @generated
	 */
	EReference getNavigationEdge_OppositeEdge();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isPartial <em>Partial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partial</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isPartial()
	 * @see #getNavigationEdge()
	 * @generated
	 */
	EAttribute getNavigationEdge_Partial();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getReferredProperty()
	 * @see #getNavigationEdge()
	 * @generated
	 */
	EReference getNavigationEdge_ReferredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isSecondary <em>Secondary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secondary</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isSecondary()
	 * @see #getNavigationEdge()
	 * @generated
	 */
	EAttribute getNavigationEdge_Secondary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getClassDatum()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_ClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cluster</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Cluster();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingConnection <em>Incoming Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingConnection()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole <em>Node Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_NodeRole();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingConnections()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingConnections();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingEdges();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingEdges();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OwningRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection <em>Node Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection
	 * @generated
	 */
	EClass getNodeConnection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getClassDatum()
	 * @see #getNodeConnection()
	 * @generated
	 */
	EReference getNodeConnection_ClassDatum();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getMandatoryTargetNodes <em>Mandatory Target Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mandatory Target Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getMandatoryTargetNodes()
	 * @see #getNodeConnection()
	 * @generated
	 */
	EReference getNodeConnection_MandatoryTargetNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getPassedTargetNodes <em>Passed Target Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Passed Target Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getPassedTargetNodes()
	 * @see #getNodeConnection()
	 * @generated
	 */
	EReference getNodeConnection_PassedTargetNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getPreferredTargetNodes <em>Preferred Target Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Preferred Target Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getPreferredTargetNodes()
	 * @see #getNodeConnection()
	 * @generated
	 */
	EReference getNodeConnection_PreferredTargetNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NonPartition <em>Non Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NonPartition
	 * @generated
	 */
	EClass getNonPartition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode <em>Null Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode
	 * @generated
	 */
	EClass getNullLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode <em>Numeric Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode
	 * @generated
	 */
	EClass getNumericLiteralNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode#getNumericValue <em>Numeric Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numeric Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode#getNumericValue()
	 * @see #getNumericLiteralNode()
	 * @generated
	 */
	EAttribute getNumericLiteralNode_NumericValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode <em>Operation Call Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode
	 * @generated
	 */
	EClass getOperationCallNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode#getReferredOperation()
	 * @see #getOperationCallNode()
	 * @generated
	 */
	EReference getOperationCallNode_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationNode
	 * @generated
	 */
	EClass getOperationNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion <em>Operation Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion
	 * @generated
	 */
	EClass getOperationRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getDependencyNodes <em>Dependency Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependency Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getDependencyNodes()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_DependencyNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getHeadNodes <em>Head Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Head Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getHeadNodes()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_HeadNodes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getReferredOperation()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_ReferredOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getResultNode <em>Result Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getResultNode()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_ResultNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getOwningScheduleModel()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_OwningScheduleModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge <em>Operation Parameter Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Parameter Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge
	 * @generated
	 */
	EClass getOperationParameterEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getReferredParameter <em>Referred Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getReferredParameter()
	 * @see #getOperationParameterEdge()
	 * @generated
	 */
	EReference getOperationParameterEdge_ReferredParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getParameterIndex <em>Parameter Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Index</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getParameterIndex()
	 * @see #getOperationParameterEdge()
	 * @generated
	 */
	EAttribute getOperationParameterEdge_ParameterIndex();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge <em>Operation Self Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Self Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge
	 * @generated
	 */
	EClass getOperationSelfEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge#getReferredType <em>Referred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Type</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge#getReferredType()
	 * @see #getOperationSelfEdge()
	 * @generated
	 */
	EReference getOperationSelfEdge_ReferredType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Partition <em>Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Partition
	 * @generated
	 */
	EClass getPartition();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.pivot.qvtschedule.Partition#getPasses <em>Passes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Passes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Partition#getPasses()
	 * @see #getPartition()
	 * @generated
	 */
	EAttribute getPartition_Passes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Partition#getIntermediateConnections <em>Intermediate Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Intermediate Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Partition#getIntermediateConnections()
	 * @see #getPartition()
	 * @generated
	 */
	EReference getPartition_IntermediateConnections();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Partition#getRootConnections <em>Root Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Partition#getRootConnections()
	 * @see #getPartition()
	 * @generated
	 */
	EReference getPartition_RootConnections();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode <em>Pattern Typed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Typed Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode
	 * @generated
	 */
	EClass getPatternTypedNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode <em>Pattern Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Variable Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode
	 * @generated
	 */
	EClass getPatternVariableNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge <em>Predicate Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge
	 * @generated
	 */
	EClass getPredicateEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum <em>Property Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum
	 * @generated
	 */
	EClass getPropertyDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOpposite()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Opposite();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum <em>Owning Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_OwningClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getReferredProperty()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_ReferredProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getSuperPropertyDatums <em>Super Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Property Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getSuperPropertyDatums()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_SuperPropertyDatums();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#isKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#isKey()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EAttribute getPropertyDatum_Key();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge <em>Recursion Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recursion Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge
	 * @generated
	 */
	EClass getRecursionEdge();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge#isPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge#isPrimary()
	 * @see #getRecursionEdge()
	 * @generated
	 */
	EAttribute getRecursionEdge_Primary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion <em>Rule Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RuleRegion
	 * @generated
	 */
	EClass getRuleRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getReferredRule <em>Referred Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rule</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getReferredRule()
	 * @see #getRuleRegion()
	 * @generated
	 */
	EReference getRuleRegion_ReferredRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges <em>Owned Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedEdges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedClusters <em>Owned Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Clusters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedClusters()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedClusters();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getRootRegion <em>Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getRootRegion()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_RootRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition <em>Root Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootPartition
	 * @generated
	 */
	EClass getRootPartition();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getOwningRootRegion <em>Owning Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Root Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getOwningRootRegion()
	 * @see #getRootPartition()
	 * @generated
	 */
	EReference getRootPartition_OwningRootRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getLoadingPartition <em>Loading Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loading Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getLoadingPartition()
	 * @see #getRootPartition()
	 * @generated
	 */
	EReference getRootPartition_LoadingPartition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion <em>Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion
	 * @generated
	 */
	EClass getRootRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getActiveRegions <em>Active Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getActiveRegions()
	 * @see #getRootRegion()
	 * @generated
	 */
	EReference getRootRegion_ActiveRegions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedConnections <em>Owned Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedConnections()
	 * @see #getRootRegion()
	 * @generated
	 */
	EReference getRootRegion_OwnedConnections();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedLoadingRegion <em>Owned Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Loading Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedLoadingRegion()
	 * @see #getRootRegion()
	 * @generated
	 */
	EReference getRootRegion_OwnedLoadingRegion();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwningScheduleModel()
	 * @see #getRootRegion()
	 * @generated
	 */
	EReference getRootRegion_OwningScheduleModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getReferredTransformation <em>Referred Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getReferredTransformation()
	 * @see #getRootRegion()
	 * @generated
	 */
	EReference getRootRegion_ReferredTransformation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedRootPartition <em>Owned Root Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Root Partition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedRootPartition()
	 * @see #getRootRegion()
	 * @generated
	 */
	EReference getRootRegion_OwnedRootPartition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes <em>Owned Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedNodes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTscheduleFactory getQVTscheduleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getAbstractDatum()
		 * @generated
		 */
		EClass ABSTRACT_DATUM = eINSTANCE.getAbstractDatum();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__REFERRED_TYPED_MODEL = eINSTANCE.getAbstractDatum_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ArgumentEdgeImpl <em>Argument Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ArgumentEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getArgumentEdge()
		 * @generated
		 */
		EClass ARGUMENT_EDGE = eINSTANCE.getArgumentEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl <em>Basic Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getBasicPartition()
		 * @generated
		 */
		EClass BASIC_PARTITION = eINSTANCE.getBasicPartition();

		/**
		 * The meta object literal for the '<em><b>Constant Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__CONSTANT_EDGES = eINSTANCE.getBasicPartition_ConstantEdges();

		/**
		 * The meta object literal for the '<em><b>Constant Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__CONSTANT_NODES = eINSTANCE.getBasicPartition_ConstantNodes();

		/**
		 * The meta object literal for the '<em><b>Constant Success False Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__CONSTANT_SUCCESS_FALSE_NODES = eINSTANCE.getBasicPartition_ConstantSuccessFalseNodes();

		/**
		 * The meta object literal for the '<em><b>Constant Success True Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__CONSTANT_SUCCESS_TRUE_NODES = eINSTANCE.getBasicPartition_ConstantSuccessTrueNodes();

		/**
		 * The meta object literal for the '<em><b>Head Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__HEAD_NODES = eINSTANCE.getBasicPartition_HeadNodes();

		/**
		 * The meta object literal for the '<em><b>Loaded Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__LOADED_EDGES = eINSTANCE.getBasicPartition_LoadedEdges();

		/**
		 * The meta object literal for the '<em><b>Loaded Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__LOADED_NODES = eINSTANCE.getBasicPartition_LoadedNodes();

		/**
		 * The meta object literal for the '<em><b>Predicated Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__PREDICATED_EDGES = eINSTANCE.getBasicPartition_PredicatedEdges();

		/**
		 * The meta object literal for the '<em><b>Predicated Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__PREDICATED_NODES = eINSTANCE.getBasicPartition_PredicatedNodes();

		/**
		 * The meta object literal for the '<em><b>Realized Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__REALIZED_EDGES = eINSTANCE.getBasicPartition_RealizedEdges();

		/**
		 * The meta object literal for the '<em><b>Realized Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__REALIZED_NODES = eINSTANCE.getBasicPartition_RealizedNodes();

		/**
		 * The meta object literal for the '<em><b>Speculated Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__SPECULATED_EDGES = eINSTANCE.getBasicPartition_SpeculatedEdges();

		/**
		 * The meta object literal for the '<em><b>Speculated Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__SPECULATED_NODES = eINSTANCE.getBasicPartition_SpeculatedNodes();

		/**
		 * The meta object literal for the '<em><b>Speculation Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__SPECULATION_NODES = eINSTANCE.getBasicPartition_SpeculationNodes();

		/**
		 * The meta object literal for the '<em><b>Owning Merged Partition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__OWNING_MERGED_PARTITION = eINSTANCE.getBasicPartition_OwningMergedPartition();

		/**
		 * The meta object literal for the '<em><b>Explicit Predecessors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_PARTITION__EXPLICIT_PREDECESSORS = eINSTANCE.getBasicPartition_ExplicitPredecessors();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BooleanLiteralNodeImpl <em>Boolean Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.BooleanLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getBooleanLiteralNode()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_NODE = eINSTANCE.getBooleanLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_NODE__BOOLEAN_VALUE = eINSTANCE.getBooleanLiteralNode_BooleanValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl <em>Cast Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCastEdge()
		 * @generated
		 */
		EClass CAST_EDGE = eINSTANCE.getCastEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Class Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAST_EDGE__REFERRED_CLASS_DATUM = eINSTANCE.getCastEdge_ReferredClassDatum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getClassDatum()
		 * @generated
		 */
		EClass CLASS_DATUM = eINSTANCE.getClassDatum();

		/**
		 * The meta object literal for the '<em><b>Complete Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__COMPLETE_CLASSES = eINSTANCE.getClassDatum_CompleteClasses();

		/**
		 * The meta object literal for the '<em><b>Owned Property Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__OWNED_PROPERTY_DATUMS = eINSTANCE.getClassDatum_OwnedPropertyDatums();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__OWNING_SCHEDULE_MODEL = eINSTANCE.getClassDatum_OwningScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__REFERRED_CLASS = eINSTANCE.getClassDatum_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Super Class Datums</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__SUPER_CLASS_DATUMS = eINSTANCE.getClassDatum_SuperClassDatums();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl <em>Cluster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCluster()
		 * @generated
		 */
		EClass CLUSTER = eINSTANCE.getCluster();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__OWNING_REGION = eINSTANCE.getCluster_OwningRegion();

		/**
		 * The meta object literal for the '<em><b>Member Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__MEMBER_NODES = eINSTANCE.getCluster_MemberNodes();

		/**
		 * The meta object literal for the '<em><b>Member Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__MEMBER_EDGES = eINSTANCE.getCluster_MemberEdges();

		/**
		 * The meta object literal for the '<em><b>Preceding Clusters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__PRECEDING_CLUSTERS = eINSTANCE.getCluster_PrecedingClusters();

		/**
		 * The meta object literal for the '<em><b>Succeeding Clusters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__SUCCEEDING_CLUSTERS = eINSTANCE.getCluster_SucceedingClusters();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLUSTER__DEPTH = eINSTANCE.getCluster_Depth();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionClassDatumImpl <em>Collection Class Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionClassDatumImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionClassDatum()
		 * @generated
		 */
		EClass COLLECTION_CLASS_DATUM = eINSTANCE.getCollectionClassDatum();

		/**
		 * The meta object literal for the '<em><b>Elemental Class Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_CLASS_DATUM__ELEMENTAL_CLASS_DATUM = eINSTANCE.getCollectionClassDatum_ElementalClassDatum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionLiteralNodeImpl <em>Collection Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionLiteralNode()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_NODE = eINSTANCE.getCollectionLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionPartEdgeImpl <em>Collection Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionPartEdge()
		 * @generated
		 */
		EClass COLLECTION_PART_EDGE = eINSTANCE.getCollectionPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PART_EDGE__REFERRED_PART = eINSTANCE.getCollectionPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionRangeNodeImpl <em>Collection Range Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionRangeNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionRangeNode()
		 * @generated
		 */
		EClass COLLECTION_RANGE_NODE = eINSTANCE.getCollectionRangeNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl <em>Composed Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getComposedNode()
		 * @generated
		 */
		EClass COMPOSED_NODE = eINSTANCE.getComposedNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CompositePartitionImpl <em>Composite Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CompositePartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCompositePartition()
		 * @generated
		 */
		EClass COMPOSITE_PARTITION = eINSTANCE.getCompositePartition();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PARTITION__OWNED_MAPPING_PARTITIONS = eINSTANCE.getCompositePartition_OwnedMappingPartitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Owning Root Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__OWNING_ROOT_REGION = eINSTANCE.getConnection_OwningRootRegion();

		/**
		 * The meta object literal for the '<em><b>Connection Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__CONNECTION_ROLE = eINSTANCE.getConnection_ConnectionRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__NAME = eINSTANCE.getConnection_Name();

		/**
		 * The meta object literal for the '<em><b>Source Ends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__SOURCE_ENDS = eINSTANCE.getConnection_SourceEnds();

		/**
		 * The meta object literal for the '<em><b>Intermediate Partitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__INTERMEDIATE_PARTITIONS = eINSTANCE.getConnection_IntermediatePartitions();

		/**
		 * The meta object literal for the '<em><b>Common Partition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__COMMON_PARTITION = eINSTANCE.getConnection_CommonPartition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionEnd()
		 * @generated
		 */
		EClass CONNECTION_END = eINSTANCE.getConnectionEnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicMappingRegionImpl <em>Cyclic Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicMappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCyclicMappingRegion()
		 * @generated
		 */
		EClass CYCLIC_MAPPING_REGION = eINSTANCE.getCyclicMappingRegion();

		/**
		 * The meta object literal for the '<em><b>Element Regions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CYCLIC_MAPPING_REGION__ELEMENT_REGIONS = eINSTANCE.getCyclicMappingRegion_ElementRegions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicPartitionImpl <em>Cyclic Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicPartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCyclicPartition()
		 * @generated
		 */
		EClass CYCLIC_PARTITION = eINSTANCE.getCyclicPartition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyEdgeImpl <em>Dependency Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDependencyEdge()
		 * @generated
		 */
		EClass DEPENDENCY_EDGE = eINSTANCE.getDependencyEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDependencyNode()
		 * @generated
		 */
		EClass DEPENDENCY_NODE = eINSTANCE.getDependencyNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DispatchRegionImpl <em>Dispatch Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DispatchRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDispatchRegion()
		 * @generated
		 */
		EClass DISPATCH_REGION = eINSTANCE.getDispatchRegion();

		/**
		 * The meta object literal for the '<em><b>Referred Rule Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPATCH_REGION__REFERRED_RULE_REGION = eINSTANCE.getDispatchRegion_ReferredRuleRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Cluster</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__CLUSTER = eINSTANCE.getEdge_Cluster();

		/**
		 * The meta object literal for the '<em><b>Edge Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__EDGE_ROLE = eINSTANCE.getEdge_EdgeRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__NAME = eINSTANCE.getEdge_Name();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__OWNING_REGION = eINSTANCE.getEdge_OwningRegion();

		/**
		 * The meta object literal for the '<em><b>Source Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE_NODE = eINSTANCE.getEdge_SourceNode();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET_NODE = eINSTANCE.getEdge_TargetNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl <em>Edge Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdgeConnection()
		 * @generated
		 */
		EClass EDGE_CONNECTION = eINSTANCE.getEdgeConnection();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_CONNECTION__REFERRED_PROPERTY = eINSTANCE.getEdgeConnection_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Mandatory Target Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_CONNECTION__MANDATORY_TARGET_EDGES = eINSTANCE.getEdgeConnection_MandatoryTargetEdges();

		/**
		 * The meta object literal for the '<em><b>Preferred Target Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_CONNECTION__PREFERRED_TARGET_EDGES = eINSTANCE.getEdgeConnection_PreferredTargetEdges();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EnumLiteralNodeImpl <em>Enum Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EnumLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEnumLiteralNode()
		 * @generated
		 */
		EClass ENUM_LITERAL_NODE = eINSTANCE.getEnumLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Enum Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_NODE__ENUM_VALUE = eINSTANCE.getEnumLiteralNode_EnumValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRole()
		 * @generated
		 */
		EEnum ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em>Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNumber()
		 * @generated
		 */
		EDataType NUMBER = eINSTANCE.getNumber();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl <em>Schedule Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduleModel()
		 * @generated
		 */
		EClass SCHEDULE_MODEL = eINSTANCE.getScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Owned Class Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_CLASS_DATUMS = eINSTANCE.getScheduleModel_OwnedClassDatums();

		/**
		 * The meta object literal for the '<em><b>Owned Operation Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_OPERATION_REGIONS = eINSTANCE.getScheduleModel_OwnedOperationRegions();

		/**
		 * The meta object literal for the '<em><b>Owned Root Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_ROOT_REGIONS = eINSTANCE.getScheduleModel_OwnedRootRegions();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_MAPPING_REGIONS = eINSTANCE.getScheduleModel_OwnedMappingRegions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowNodeImpl <em>Shadow Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getShadowNode()
		 * @generated
		 */
		EClass SHADOW_NODE = eINSTANCE.getShadowNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowPartEdgeImpl <em>Shadow Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getShadowPartEdge()
		 * @generated
		 */
		EClass SHADOW_PART_EDGE = eINSTANCE.getShadowPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_PART_EDGE__REFERRED_PART = eINSTANCE.getShadowPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.StringLiteralNodeImpl <em>String Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.StringLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getStringLiteralNode()
		 * @generated
		 */
		EClass STRING_LITERAL_NODE = eINSTANCE.getStringLiteralNode();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_NODE__STRING_VALUE = eINSTANCE.getStringLiteralNode_StringValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessEdgeImpl <em>Success Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSuccessEdge()
		 * @generated
		 */
		EClass SUCCESS_EDGE = eINSTANCE.getSuccessEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessNodeImpl <em>Success Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSuccessNode()
		 * @generated
		 */
		EClass SUCCESS_NODE = eINSTANCE.getSuccessNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSymbolable()
		 * @generated
		 */
		EClass SYMBOLABLE = eINSTANCE.getSymbolable();

		/**
		 * The meta object literal for the '<em><b>Symbol Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYMBOLABLE__SYMBOL_NAME = eINSTANCE.getSymbolable_SymbolName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TupleLiteralNodeImpl <em>Tuple Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TupleLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTupleLiteralNode()
		 * @generated
		 */
		EClass TUPLE_LITERAL_NODE = eINSTANCE.getTupleLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TuplePartEdgeImpl <em>Tuple Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TuplePartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTuplePartEdge()
		 * @generated
		 */
		EClass TUPLE_PART_EDGE = eINSTANCE.getTuplePartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_PART_EDGE__REFERRED_PART = eINSTANCE.getTuplePartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TypeLiteralNodeImpl <em>Type Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TypeLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTypeLiteralNode()
		 * @generated
		 */
		EClass TYPE_LITERAL_NODE = eINSTANCE.getTypeLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Type Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LITERAL_NODE__TYPE_VALUE = eINSTANCE.getTypeLiteralNode_TypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl <em>Unknown Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getUnknownNode()
		 * @generated
		 */
		EClass UNKNOWN_NODE = eINSTANCE.getUnknownNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl <em>Variable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVariableNode()
		 * @generated
		 */
		EClass VARIABLE_NODE = eINSTANCE.getVariableNode();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_NODE__REFERRED_VARIABLE = eINSTANCE.getVariableNode_ReferredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VerdictRegionImpl <em>Verdict Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VerdictRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVerdictRegion()
		 * @generated
		 */
		EClass VERDICT_REGION = eINSTANCE.getVerdictRegion();

		/**
		 * The meta object literal for the '<em><b>Referred Rule Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERDICT_REGION__REFERRED_RULE_REGION = eINSTANCE.getVerdictRegion_ReferredRuleRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionRole()
		 * @generated
		 */
		EEnum CONNECTION_ROLE = eINSTANCE.getConnectionRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl <em>Error Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getErrorNode()
		 * @generated
		 */
		EClass ERROR_NODE = eINSTANCE.getErrorNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl <em>Expression Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getExpressionEdge()
		 * @generated
		 */
		EClass EXPRESSION_EDGE = eINSTANCE.getExpressionEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IfNodeImpl <em>If Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IfNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIfNode()
		 * @generated
		 */
		EClass IF_NODE = eINSTANCE.getIfNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IncludesEdgeImpl <em>Includes Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IncludesEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIncludesEdge()
		 * @generated
		 */
		EClass INCLUDES_EDGE = eINSTANCE.getIncludesEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl <em>Input Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getInputNode()
		 * @generated
		 */
		EClass INPUT_NODE = eINSTANCE.getInputNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl <em>Iterated Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratedEdge()
		 * @generated
		 */
		EClass ITERATED_EDGE = eINSTANCE.getIteratedEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl <em>Iterator Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratorNode()
		 * @generated
		 */
		EClass ITERATOR_NODE = eINSTANCE.getIteratorNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.KeyPartEdgeImpl <em>Key Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.KeyPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getKeyPartEdge()
		 * @generated
		 */
		EClass KEY_PART_EDGE = eINSTANCE.getKeyPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_PART_EDGE__REFERRED_PART = eINSTANCE.getKeyPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.KeyedValueNodeImpl <em>Keyed Value Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.KeyedValueNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getKeyedValueNode()
		 * @generated
		 */
		EClass KEYED_VALUE_NODE = eINSTANCE.getKeyedValueNode();

		/**
		 * The meta object literal for the '<em><b>Class Datum Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEYED_VALUE_NODE__CLASS_DATUM_VALUE = eINSTANCE.getKeyedValueNode_ClassDatumValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingPartitionImpl <em>Loading Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingPartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getLoadingPartition()
		 * @generated
		 */
		EClass LOADING_PARTITION = eINSTANCE.getLoadingPartition();

		/**
		 * The meta object literal for the '<em><b>Referred Loading Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOADING_PARTITION__REFERRED_LOADING_REGION = eINSTANCE.getLoadingPartition_ReferredLoadingRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl <em>Loading Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getLoadingRegion()
		 * @generated
		 */
		EClass LOADING_REGION = eINSTANCE.getLoadingRegion();

		/**
		 * The meta object literal for the '<em><b>Loading Partition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOADING_REGION__LOADING_PARTITION = eINSTANCE.getLoadingRegion_LoadingPartition();

		/**
		 * The meta object literal for the '<em><b>Owning Root Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOADING_REGION__OWNING_ROOT_REGION = eINSTANCE.getLoadingRegion_OwningRootRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapLiteralNodeImpl <em>Map Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapLiteralNode()
		 * @generated
		 */
		EClass MAP_LITERAL_NODE = eINSTANCE.getMapLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartEdgeImpl <em>Map Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapPartEdge()
		 * @generated
		 */
		EClass MAP_PART_EDGE = eINSTANCE.getMapPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_PART_EDGE__REFERRED_PART = eINSTANCE.getMapPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartNodeImpl <em>Map Part Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapPartNode()
		 * @generated
		 */
		EClass MAP_PART_NODE = eINSTANCE.getMapPartNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingNodeImpl <em>Mapping Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingNode()
		 * @generated
		 */
		EClass MAPPING_NODE = eINSTANCE.getMappingNode();

		/**
		 * The meta object literal for the '<em><b>Matched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_NODE__MATCHED = eINSTANCE.getMappingNode_Matched();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingPartitionImpl <em>Mapping Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingPartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingPartition()
		 * @generated
		 */
		EClass MAPPING_PARTITION = eINSTANCE.getMappingPartition();

		/**
		 * The meta object literal for the '<em><b>Owning Composite Partition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION = eINSTANCE.getMappingPartition_OwningCompositePartition();

		/**
		 * The meta object literal for the '<em><b>Refered Mapping Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARTITION__REFERED_MAPPING_REGION = eINSTANCE.getMappingPartition_ReferedMappingRegion();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARTITION__REGION = eINSTANCE.getMappingPartition_Region();

		/**
		 * The meta object literal for the '<em><b>Explicit Successors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARTITION__EXPLICIT_SUCCESSORS = eINSTANCE.getMappingPartition_ExplicitSuccessors();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl <em>Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingRegion()
		 * @generated
		 */
		EClass MAPPING_REGION = eINSTANCE.getMappingRegion();

		/**
		 * The meta object literal for the '<em><b>Head Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REGION__HEAD_NODES = eINSTANCE.getMappingRegion_HeadNodes();

		/**
		 * The meta object literal for the '<em><b>Mapping Partitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REGION__MAPPING_PARTITIONS = eINSTANCE.getMappingRegion_MappingPartitions();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REGION__OWNING_SCHEDULE_MODEL = eINSTANCE.getMappingRegion_OwningScheduleModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MergedPartitionImpl <em>Merged Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MergedPartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMergedPartition()
		 * @generated
		 */
		EClass MERGED_PARTITION = eINSTANCE.getMergedPartition();

		/**
		 * The meta object literal for the '<em><b>Owned Merged Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGED_PARTITION__OWNED_MERGED_PARTITIONS = eINSTANCE.getMergedPartition_OwnedMergedPartitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl <em>Navigable Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigableEdge()
		 * @generated
		 */
		EClass NAVIGABLE_EDGE = eINSTANCE.getNavigableEdge();

		/**
		 * The meta object literal for the '<em><b>Incoming Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGABLE_EDGE__INCOMING_CONNECTION = eINSTANCE.getNavigableEdge_IncomingConnection();

		/**
		 * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGABLE_EDGE__OUTGOING_CONNECTIONS = eINSTANCE.getNavigableEdge_OutgoingConnections();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl <em>Navigation Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigationEdge()
		 * @generated
		 */
		EClass NAVIGATION_EDGE = eINSTANCE.getNavigationEdge();

		/**
		 * The meta object literal for the '<em><b>Opposite Edge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_EDGE__OPPOSITE_EDGE = eINSTANCE.getNavigationEdge_OppositeEdge();

		/**
		 * The meta object literal for the '<em><b>Partial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_EDGE__PARTIAL = eINSTANCE.getNavigationEdge_Partial();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_EDGE__REFERRED_PROPERTY = eINSTANCE.getNavigationEdge_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Secondary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_EDGE__SECONDARY = eINSTANCE.getNavigationEdge_Secondary();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Class Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CLASS_DATUM = eINSTANCE.getNode_ClassDatum();

		/**
		 * The meta object literal for the '<em><b>Cluster</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CLUSTER = eINSTANCE.getNode_Cluster();

		/**
		 * The meta object literal for the '<em><b>Incoming Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_CONNECTION = eINSTANCE.getNode_IncomingConnection();

		/**
		 * The meta object literal for the '<em><b>Node Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NODE_ROLE = eINSTANCE.getNode_NodeRole();

		/**
		 * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_CONNECTIONS = eINSTANCE.getNode_OutgoingConnections();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_EDGES = eINSTANCE.getNode_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Outgoing Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_EDGES = eINSTANCE.getNode_OutgoingEdges();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OWNING_REGION = eINSTANCE.getNode_OwningRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl <em>Node Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNodeConnection()
		 * @generated
		 */
		EClass NODE_CONNECTION = eINSTANCE.getNodeConnection();

		/**
		 * The meta object literal for the '<em><b>Class Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CONNECTION__CLASS_DATUM = eINSTANCE.getNodeConnection_ClassDatum();

		/**
		 * The meta object literal for the '<em><b>Mandatory Target Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CONNECTION__MANDATORY_TARGET_NODES = eINSTANCE.getNodeConnection_MandatoryTargetNodes();

		/**
		 * The meta object literal for the '<em><b>Passed Target Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CONNECTION__PASSED_TARGET_NODES = eINSTANCE.getNodeConnection_PassedTargetNodes();

		/**
		 * The meta object literal for the '<em><b>Preferred Target Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CONNECTION__PREFERRED_TARGET_NODES = eINSTANCE.getNodeConnection_PreferredTargetNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NonPartitionImpl <em>Non Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NonPartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNonPartition()
		 * @generated
		 */
		EClass NON_PARTITION = eINSTANCE.getNonPartition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NullLiteralNodeImpl <em>Null Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NullLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNullLiteralNode()
		 * @generated
		 */
		EClass NULL_LITERAL_NODE = eINSTANCE.getNullLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NumericLiteralNodeImpl <em>Numeric Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NumericLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNumericLiteralNode()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_NODE = eINSTANCE.getNumericLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Numeric Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_LITERAL_NODE__NUMERIC_VALUE = eINSTANCE.getNumericLiteralNode_NumericValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationCallNodeImpl <em>Operation Call Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationCallNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationCallNode()
		 * @generated
		 */
		EClass OPERATION_CALL_NODE = eINSTANCE.getOperationCallNode();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_NODE__REFERRED_OPERATION = eINSTANCE.getOperationCallNode_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl <em>Operation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationNode()
		 * @generated
		 */
		EClass OPERATION_NODE = eINSTANCE.getOperationNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl <em>Operation Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationRegion()
		 * @generated
		 */
		EClass OPERATION_REGION = eINSTANCE.getOperationRegion();

		/**
		 * The meta object literal for the '<em><b>Dependency Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__DEPENDENCY_NODES = eINSTANCE.getOperationRegion_DependencyNodes();

		/**
		 * The meta object literal for the '<em><b>Head Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__HEAD_NODES = eINSTANCE.getOperationRegion_HeadNodes();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__REFERRED_OPERATION = eINSTANCE.getOperationRegion_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Result Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__RESULT_NODE = eINSTANCE.getOperationRegion_ResultNode();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__OWNING_SCHEDULE_MODEL = eINSTANCE.getOperationRegion_OwningScheduleModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl <em>Operation Parameter Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationParameterEdge()
		 * @generated
		 */
		EClass OPERATION_PARAMETER_EDGE = eINSTANCE.getOperationParameterEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PARAMETER_EDGE__REFERRED_PARAMETER = eINSTANCE.getOperationParameterEdge_ReferredParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PARAMETER_EDGE__PARAMETER_INDEX = eINSTANCE.getOperationParameterEdge_ParameterIndex();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationSelfEdgeImpl <em>Operation Self Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationSelfEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationSelfEdge()
		 * @generated
		 */
		EClass OPERATION_SELF_EDGE = eINSTANCE.getOperationSelfEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_SELF_EDGE__REFERRED_TYPE = eINSTANCE.getOperationSelfEdge_ReferredType();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PartitionImpl <em>Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPartition()
		 * @generated
		 */
		EClass PARTITION = eINSTANCE.getPartition();

		/**
		 * The meta object literal for the '<em><b>Passes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTITION__PASSES = eINSTANCE.getPartition_Passes();

		/**
		 * The meta object literal for the '<em><b>Intermediate Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITION__INTERMEDIATE_CONNECTIONS = eINSTANCE.getPartition_IntermediateConnections();

		/**
		 * The meta object literal for the '<em><b>Root Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITION__ROOT_CONNECTIONS = eINSTANCE.getPartition_RootConnections();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl <em>Pattern Typed Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternTypedNode()
		 * @generated
		 */
		EClass PATTERN_TYPED_NODE = eINSTANCE.getPatternTypedNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl <em>Pattern Variable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternVariableNode()
		 * @generated
		 */
		EClass PATTERN_VARIABLE_NODE = eINSTANCE.getPatternVariableNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl <em>Predicate Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPredicateEdge()
		 * @generated
		 */
		EClass PREDICATE_EDGE = eINSTANCE.getPredicateEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
		 * @generated
		 */
		EClass PROPERTY_DATUM = eINSTANCE.getPropertyDatum();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__OPPOSITE = eINSTANCE.getPropertyDatum_Opposite();

		/**
		 * The meta object literal for the '<em><b>Owning Class Datum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__OWNING_CLASS_DATUM = eINSTANCE.getPropertyDatum_OwningClassDatum();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__REFERRED_PROPERTY = eINSTANCE.getPropertyDatum_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Super Property Datums</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__SUPER_PROPERTY_DATUMS = eINSTANCE.getPropertyDatum_SuperPropertyDatums();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DATUM__KEY = eINSTANCE.getPropertyDatum_Key();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl <em>Recursion Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRecursionEdge()
		 * @generated
		 */
		EClass RECURSION_EDGE = eINSTANCE.getRecursionEdge();

		/**
		 * The meta object literal for the '<em><b>Primary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSION_EDGE__PRIMARY = eINSTANCE.getRecursionEdge_Primary();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl <em>Rule Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRuleRegion()
		 * @generated
		 */
		EClass RULE_REGION = eINSTANCE.getRuleRegion();

		/**
		 * The meta object literal for the '<em><b>Referred Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_REGION__REFERRED_RULE = eINSTANCE.getRuleRegion_ReferredRule();

		/**
		 * The meta object literal for the '<em><b>Owned Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_EDGES = eINSTANCE.getRegion_OwnedEdges();

		/**
		 * The meta object literal for the '<em><b>Owned Clusters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_CLUSTERS = eINSTANCE.getRegion_OwnedClusters();

		/**
		 * The meta object literal for the '<em><b>Root Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__ROOT_REGION = eINSTANCE.getRegion_RootRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootPartitionImpl <em>Root Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RootPartitionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRootPartition()
		 * @generated
		 */
		EClass ROOT_PARTITION = eINSTANCE.getRootPartition();

		/**
		 * The meta object literal for the '<em><b>Owning Root Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_PARTITION__OWNING_ROOT_REGION = eINSTANCE.getRootPartition_OwningRootRegion();

		/**
		 * The meta object literal for the '<em><b>Loading Partition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_PARTITION__LOADING_PARTITION = eINSTANCE.getRootPartition_LoadingPartition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl <em>Root Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRootRegion()
		 * @generated
		 */
		EClass ROOT_REGION = eINSTANCE.getRootRegion();

		/**
		 * The meta object literal for the '<em><b>Active Regions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_REGION__ACTIVE_REGIONS = eINSTANCE.getRootRegion_ActiveRegions();

		/**
		 * The meta object literal for the '<em><b>Owned Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_REGION__OWNED_CONNECTIONS = eINSTANCE.getRootRegion_OwnedConnections();

		/**
		 * The meta object literal for the '<em><b>Owned Loading Region</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_REGION__OWNED_LOADING_REGION = eINSTANCE.getRootRegion_OwnedLoadingRegion();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_REGION__OWNING_SCHEDULE_MODEL = eINSTANCE.getRootRegion_OwningScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Referred Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_REGION__REFERRED_TRANSFORMATION = eINSTANCE.getRootRegion_ReferredTransformation();

		/**
		 * The meta object literal for the '<em><b>Owned Root Partition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_REGION__OWNED_ROOT_PARTITION = eINSTANCE.getRootRegion_OwnedRootPartition();

		/**
		 * The meta object literal for the '<em><b>Owned Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_NODES = eINSTANCE.getRegion_OwnedNodes();

	}

} //QVTschedulePackage
