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
import org.eclipse.ocl.pivot.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Cluster is a sub-graph with Nodes and Edges in the graphical representation of a Rule. A cluster identifies a sub-Region with uniform scheduling treatment.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion <em>Owning Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberNodes <em>Member Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberEdges <em>Member Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getPrecedingClusters <em>Preceding Clusters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getSucceedingClusters <em>Succeeding Clusters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getDepth <em>Depth</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCluster()
 * @model
 * @generated
 */
public interface Cluster extends NamedElement, Symbolable {
	/**
	 * Returns the value of the '<em><b>Owning Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedClusters <em>Owned Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Region</em>' container reference.
	 * @see #setOwningRegion(Region)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCluster_OwningRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedClusters
	 * @model opposite="ownedClusters" required="true" transient="false"
	 * @generated
	 */
	Region getOwningRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion <em>Owning Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Region</em>' container reference.
	 * @see #getOwningRegion()
	 * @generated
	 */
	void setOwningRegion(Region value);

	/**
	 * Returns the value of the '<em><b>Member Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCluster_MemberNodes()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster
	 * @model opposite="cluster"
	 * @generated
	 */
	List<Node> getMemberNodes();

	/**
	 * Returns the value of the '<em><b>Member Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCluster_MemberEdges()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster
	 * @model opposite="cluster"
	 * @generated
	 */
	List<Edge> getMemberEdges();

	/**
	 * Returns the value of the '<em><b>Preceding Clusters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Cluster}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getSucceedingClusters <em>Succeeding Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preceding Clusters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preceding Clusters</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCluster_PrecedingClusters()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getSucceedingClusters
	 * @model opposite="succeedingClusters"
	 * @generated
	 */
	List<Cluster> getPrecedingClusters();

	/**
	 * Returns the value of the '<em><b>Succeeding Clusters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Cluster}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getPrecedingClusters <em>Preceding Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Succeeding Clusters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Succeeding Clusters</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCluster_SucceedingClusters()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getPrecedingClusters
	 * @model opposite="precedingClusters"
	 * @generated
	 */
	List<Cluster> getSucceedingClusters();

	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(Integer)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCluster_Depth()
	 * @model
	 * @generated
	 */
	Integer getDepth();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(Integer value);

} // Cluster
