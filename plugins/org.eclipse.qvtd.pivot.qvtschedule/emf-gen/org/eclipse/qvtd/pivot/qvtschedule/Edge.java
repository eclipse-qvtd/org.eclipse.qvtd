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
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * @extends GraphEdge
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An edge is directed and abstracts any Node interconnection within a Region.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster <em>Cluster</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole <em>Edge Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion <em>Owning Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdge()
 * @model abstract="true"
 * @generated
 */
public interface Edge extends Element, org.eclipse.ocl.pivot.utilities.Nameable, GraphEdge {
	/**
	 * Returns the value of the '<em><b>Cluster</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberEdges <em>Member Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster</em>' reference.
	 * @see #setCluster(Cluster)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdge_Cluster()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberEdges
	 * @model opposite="memberEdges"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Edge!cluster'"
	 * @generated
	 */
	Cluster getCluster();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster <em>Cluster</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster</em>' reference.
	 * @see #getCluster()
	 * @generated
	 */
	void setCluster(Cluster value);

	/**
	 * Returns the value of the '<em><b>Edge Role</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.pivot.qvtschedule.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Role</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @see #setEdgeRole(Role)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdge_EdgeRole()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Edge!edgeRole'"
	 * @generated
	 */
	Role getEdgeRole();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole <em>Edge Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Role</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @see #getEdgeRole()
	 * @generated
	 */
	void setEdgeRole(Role value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdge_Name()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Edge!name'"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owning Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges <em>Owned Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Region</em>' container reference.
	 * @see #setOwningRegion(Region)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdge_OwningRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges
	 * @model opposite="ownedEdges" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Edge!owningRegion'"
	 * @generated
	 */
	Region getOwningRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion <em>Owning Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Region</em>' container reference.
	 * @see #getOwningRegion()
	 * @generated
	 */
	void setOwningRegion(Region value);

	/**
	 * Returns the value of the '<em><b>Source Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Node</em>' reference.
	 * @see #setSourceNode(Node)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdge_SourceNode()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingEdges
	 * @model opposite="outgoingEdges" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Edge!sourceNode'"
	 * @generated
	 */
	Node getSourceNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode <em>Source Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Node</em>' reference.
	 * @see #getSourceNode()
	 * @generated
	 */
	void setSourceNode(Node value);

	/**
	 * Returns the value of the '<em><b>Target Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Node</em>' reference.
	 * @see #setTargetNode(Node)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdge_TargetNode()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingEdges
	 * @model opposite="incomingEdges" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Edge!targetNode'"
	 * @generated
	 */
	Node getTargetNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(Node value);

	/**
	 * Create an edgeRole edge from sourceNode to targetNode with the same name as this edge.
	 */
	@NonNull Edge createEdge(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode);

	void destroy();

	/**
	 * Return a non-standard style for the arrow head.
	 */
	@Nullable String getArrowhead();

	/**
	 * Return a non-standard style for the arrow tail, non-null selects bidirectional.
	 */
	@Nullable String getArrowtail();

	/**
	 * Return the color with which this edge is drawn.
	 */
	@Override
	@NonNull String getColor();

	@NonNull String getDisplayName();

	/**
	 * Return the source Node.
	 */
	@Override
	@NonNull Node getEdgeSource();

	/**
	 * Return the target Node.
	 */
	@Override
	@NonNull Node getEdgeTarget();

	/**
	 * Return the forward form of this edge if this is a bidirectional edge, this edge otherwise.
	 */
	@NonNull Edge getForwardEdge();

	/**
	 * Return a formatted label to accompany the edge, or null for no label.
	 */
	@Nullable String getLabel();

	void initialize(@NonNull Role edgeRole, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode);

	/**
	 * Return true if this edge is for an oclAsType cast.
	 */
	boolean isCast();

	/**
	 * Return true if this edge is checked; i.e. isPredicated() or isSpeculated().
	 */
	boolean isChecked();

	/**
	 * Return true if this node is part of the computation functionality of the region.
	 */
	boolean isComputation();

	/**
	 * Return true if this edge conveys a compile-time constant.
	 */
	boolean isConstant();

	/**
	 * Return true if this edge is a dependency echoing that in an instantiated operation. A tree of dependency
	 * nodes and edges may provide an incoming edge for an operation to express the hidden computations of the operation.
	 */
	boolean isDependency();

	/**
	 * Return true if this edge is for an expression.
	 */
	boolean isExpression();

	/**
	 * Return true if this edge conveys a value that is loadable from an input model.
	 */
	boolean isLoaded();

	/**
	 * Return true if after execution this edge exactly corresponds to a relationship between its matching ends.
	 * Conversely return false if this edge is a conditional execution path or its ends my be optional nulls.
	 * Collections are never null-valued, not even empty collections.
	 *
	 * *deprecated try to use isUnconditional or getUtility
	 */
	boolean isMatched();

	/**
	 * Return true if this edge is for a speculation/realized relationship.
	 */
	boolean isNew();

	/**
	 * Return true if this edge is for a constant/loaded/predicated/speculated relationship.
	 */
	boolean isOld();

	/**
	 * Return true if this edge is a property navigation.
	 */
	boolean isNavigation();

	/**
	 * Return true if this edge is for a partial many-to-one relationship.
	 */
	boolean isPartial();

	/**
	 * Return true if this edge is for a predicate.
	 */
	boolean isPredicate();

	/**
	 * Return true if this edge is for a predicated relationship.
	 */
	boolean isPredicated();

	/**
	 * Return true if this edge is for an assignment.
	 */
	boolean isRealized();

	/**
	 * Return true if this edge is for a recursion.
	 */
	boolean isRecursion();

	/**
	 * Return true is this edge is the auto-created inverse edge of a bidirectional pair of edges.
	 */
	boolean isSecondary();

	/**
	 * Return true if this edge is for a multi-region speculated predicate.
	 */
	boolean isSpeculated();

	/**
	 * Return true is this edge is from a trace node to its success node.
	 */
	boolean isSuccess();


	/**
	 * Return true is this edge is used as part of an unconditional navigation or computation.
	 * i.e. it is not part of a loop or dependent upon if conditions.
	 */
	boolean isUnconditional();

	void setSource(@NonNull Node sourceNode);

	void setTarget(@NonNull Node targetNode);
} // Edge
