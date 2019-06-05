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
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * @extends Graphable, GraphNode
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Region is a sub-graph with Nodes and Edges in the graphical representation of a Rule. Derived Regions provide distinct forms of execution semantics.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes <em>Owned Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges <em>Owned Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedClusters <em>Owned Clusters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getRootRegion <em>Root Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion()
 * @model abstract="true"
 * @generated
 */
public interface Region extends NamedElement, Symbolable, Graphable, GraphNode
{
	/**
	 * Returns the value of the '<em><b>Owned Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Edges</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_OwnedEdges()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion
	 * @model opposite="owningRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!ownedEdges'"
	 * @generated
	 */
	List<Edge> getOwnedEdges();

	/**
	 * Returns the value of the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Cluster}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Clusters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Clusters</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_OwnedClusters()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion
	 * @model opposite="owningRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!ownedClusters'"
	 * @generated
	 */
	List<Cluster> getOwnedClusters();

	/**
	 * Returns the value of the '<em><b>Root Region</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getActiveRegions <em>Active Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Region</em>' reference.
	 * @see #setRootRegion(RootRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_RootRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getActiveRegions
	 * @model opposite="activeRegions"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!rootRegion'"
	 * @generated
	 */
	RootRegion getRootRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getRootRegion <em>Root Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Region</em>' reference.
	 * @see #getRootRegion()
	 * @generated
	 */
	void setRootRegion(RootRegion value);

	/**
	 * Returns the value of the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_OwnedNodes()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion
	 * @model opposite="owningRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!ownedNodes'"
	 * @generated
	 */
	List<Node> getOwnedNodes();

	void addVariableNode(@NonNull VariableDeclaration variable, @NonNull Node node);
	@Nullable RootRegion getContainingRootRegion();
	List<Node> getHeadNodes();
	int getNextPartitionNumber();

	@Nullable String getShape();
	@Nullable String getStyle();
	boolean isLoadingRegion();
	boolean isOperationRegion();
	void resetHead(@NonNull Node headNode);
} // Region
