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

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable, GraphEdge, GraphNode
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Connection establishes that one or more source edges/nodes are available for use by one or more target edges/nodes.
 * Derivations refine the availability to edges or nodes, pass by value, optional existence or mandatory existence.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningRootRegion <em>Owning Root Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getConnectionRole <em>Connection Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getSourceEnds <em>Source Ends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getIntermediatePartitions <em>Intermediate Partitions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getCommonPartition <em>Common Partition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection()
 * @model abstract="true"
 * @generated
 */
public interface Connection extends Element, Symbolable, org.eclipse.ocl.pivot.utilities.Nameable, GraphEdge, GraphNode
{
	/**
	 * Returns the value of the '<em><b>Owning Root Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedConnections <em>Owned Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Root Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Root Region</em>' container reference.
	 * @see #setOwningRootRegion(RootRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection_OwningRootRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedConnections
	 * @model opposite="ownedConnections" required="true" transient="false"
	 * @generated
	 */
	RootRegion getOwningRootRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningRootRegion <em>Owning Root Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Root Region</em>' container reference.
	 * @see #getOwningRootRegion()
	 * @generated
	 */
	void setOwningRootRegion(RootRegion value);

	/**
	 * Returns the value of the '<em><b>Connection Role</b></em>' attribute.
	 * The default value is <code>"UNDEFINED"</code>.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Role</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @see #setConnectionRole(ConnectionRole)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection_ConnectionRole()
	 * @model default="UNDEFINED" required="true"
	 * @generated
	 */
	ConnectionRole getConnectionRole();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getConnectionRole <em>Connection Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Role</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @see #getConnectionRole()
	 * @generated
	 */
	void setConnectionRole(ConnectionRole value);

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
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection_Name()
	 * @model required="true"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source Ends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Rule represented by this RuleRegion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Ends</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection_SourceEnds()
	 * @model ordered="false"
	 * @generated
	 */
	List<ConnectionEnd> getSourceEnds();

	/**
	 * Returns the value of the '<em><b>Intermediate Partitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Partition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The partitions other than the common, source and target partitions through which the Connection is passed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Intermediate Partitions</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection_IntermediatePartitions()
	 * @model ordered="false"
	 * @generated
	 */
	List<Partition> getIntermediatePartitions();

	/**
	 * Returns the value of the '<em><b>Common Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The partition that manages the data structures for the Connection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Common Partition</em>' reference.
	 * @see #setCommonPartition(Partition)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection_CommonPartition()
	 * @model ordered="false"
	 * @generated
	 */
	Partition getCommonPartition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getCommonPartition <em>Common Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Common Partition</em>' reference.
	 * @see #getCommonPartition()
	 * @generated
	 */
	void setCommonPartition(Partition value);

	void destroy();

	boolean addPass(int pass);
	int getFirstPass();
	int getLastPass();
	@NonNull List<@NonNull Integer> getPasses();
	@NonNull ConnectionEnd getSource(@NonNull Partition sourcePartition);
	@NonNull Iterable<@NonNull Node> getSourceNodes();
	@NonNull Iterable<@NonNull Partition> getSourcePartitions();
	@NonNull Iterable<@NonNull ConnectionEnd> getTargetConnectionEnds(@NonNull Partition targetPartition);
	@NonNull ConnectionRole getTargetConnectionRole(@NonNull Partition targetPartition, @NonNull ConnectionEnd connectionEnd);
	@NonNull Set<? extends @NonNull ConnectionEnd> getTargetEnds();
	@NonNull Iterable<@NonNull Node> getTargetNodes();
	@NonNull Iterable<@NonNull Partition> getTargetPartitions();
	@Nullable ConnectionRole getTargetRole(@NonNull ConnectionEnd connectionEnd);

	boolean isMandatory();

	/**
	 * Return true if this connection passes a value to a region head.
	 */
	boolean isPassed();

	boolean isPassed(@NonNull Partition targetPartition);

	//	void removeTargetRegion(@NonNull Region targetRegion);

} // Connection
