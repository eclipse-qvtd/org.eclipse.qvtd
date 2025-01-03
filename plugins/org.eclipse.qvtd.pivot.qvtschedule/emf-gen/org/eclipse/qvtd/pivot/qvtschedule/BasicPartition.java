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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantEdges <em>Constant Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantNodes <em>Constant Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantSuccessFalseNodes <em>Constant Success False Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getConstantSuccessTrueNodes <em>Constant Success True Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getExplicitPredecessors <em>Explicit Predecessors</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getHeadNodes <em>Head Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getLoadedEdges <em>Loaded Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getLoadedNodes <em>Loaded Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getPredicatedEdges <em>Predicated Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getPredicatedNodes <em>Predicated Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getRealizedEdges <em>Realized Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getRealizedNodes <em>Realized Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculatedEdges <em>Speculated Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculatedNodes <em>Speculated Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getSpeculationNodes <em>Speculation Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getOwningMergedPartition <em>Owning Merged Partition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition()
 * @model
 * @generated
 */
public interface BasicPartition extends MappingPartition {

	/**
	 * Returns the value of the '<em><b>Constant Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_ConstantEdges()
	 * @model ordered="false"
	 * @generated
	 */
	List<Edge> getConstantEdges();

	/**
	 * Returns the value of the '<em><b>Constant Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_ConstantNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getConstantNodes();

	/**
	 * Returns the value of the '<em><b>Constant Success False Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Success False Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Success False Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_ConstantSuccessFalseNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getConstantSuccessFalseNodes();

	/**
	 * Returns the value of the '<em><b>Constant Success True Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Success True Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Success True Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_ConstantSuccessTrueNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getConstantSuccessTrueNodes();

	/**
	 * Returns the value of the '<em><b>Head Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_HeadNodes()
	 * @model required="true"
	 * @generated
	 */
	@Override
	List<Node> getHeadNodes();

	/**
	 * Returns the value of the '<em><b>Loaded Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaded Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaded Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_LoadedEdges()
	 * @model ordered="false"
	 * @generated
	 */
	List<Edge> getLoadedEdges();

	/**
	 * Returns the value of the '<em><b>Loaded Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaded Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaded Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_LoadedNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getLoadedNodes();

	/**
	 * Returns the value of the '<em><b>Predicated Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicated Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicated Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_PredicatedEdges()
	 * @model ordered="false"
	 * @generated
	 */
	List<Edge> getPredicatedEdges();

	/**
	 * Returns the value of the '<em><b>Predicated Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicated Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicated Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_PredicatedNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getPredicatedNodes();

	/**
	 * Returns the value of the '<em><b>Realized Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_RealizedEdges()
	 * @model ordered="false"
	 * @generated
	 */
	List<Edge> getRealizedEdges();

	/**
	 * Returns the value of the '<em><b>Realized Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_RealizedNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getRealizedNodes();

	/**
	 * Returns the value of the '<em><b>Speculated Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speculated Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speculated Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_SpeculatedEdges()
	 * @model ordered="false"
	 * @generated
	 */
	List<Edge> getSpeculatedEdges();

	/**
	 * Returns the value of the '<em><b>Speculated Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speculated Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speculated Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_SpeculatedNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getSpeculatedNodes();

	/**
	 * Returns the value of the '<em><b>Speculation Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speculation Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speculation Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_SpeculationNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getSpeculationNodes();

	/**
	 * Returns the value of the '<em><b>Owning Merged Partition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.MergedPartition#getOwnedMergedPartitions <em>Owned Merged Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Merged Partition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Merged Partition</em>' container reference.
	 * @see #setOwningMergedPartition(MergedPartition)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_OwningMergedPartition()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MergedPartition#getOwnedMergedPartitions
	 * @model opposite="ownedMergedPartitions" transient="false"
	 * @generated
	 */
	MergedPartition getOwningMergedPartition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getOwningMergedPartition <em>Owning Merged Partition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Merged Partition</em>' container reference.
	 * @see #getOwningMergedPartition()
	 * @generated
	 */
	void setOwningMergedPartition(MergedPartition value);

	/**
	 * Returns the value of the '<em><b>Explicit Predecessors</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getExplicitSuccessors <em>Explicit Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Predecessors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Predecessors</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicPartition_ExplicitPredecessors()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getExplicitSuccessors
	 * @model opposite="explicitSuccessors" ordered="false"
	 * @generated
	 */
	List<MappingPartition> getExplicitPredecessors();

	void addExplicitPredecessor(@NonNull BasicPartition precedingPartition);
	void destroy();
	boolean hasEdge(@NonNull Edge edge);
	boolean hasNode(@NonNull Node node);
	@Nullable Role putEdgeRole(@NonNull Edge edge, @NonNull Role newEdgeRole);
	@Nullable Role putNodeRole(@NonNull Node node, @NonNull Role newNodeRole);
} // BasicPartition
