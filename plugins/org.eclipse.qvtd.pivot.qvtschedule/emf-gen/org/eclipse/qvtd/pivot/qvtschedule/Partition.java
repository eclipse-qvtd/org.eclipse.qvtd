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
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partition</b></em>'.
 * @extends Graphable, GraphNode
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Partion is a sub-sub-graph with selected Nodes and Edges in the graphical representation of a Rule. Derived Partitions provide distinct forms of execution semantics.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Partition#getPasses <em>Passes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Partition#getIntermediateConnections <em>Intermediate Connections</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Partition#getRootConnections <em>Root Connections</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPartition()
 * @model abstract="true"
 * @generated
 */
public interface Partition extends NamedElement, Graphable, GraphNode {

	/**
	 * Returns the value of the '<em><b>Passes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passes</em>' attribute list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPartition_Passes()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Partition!passes'"
	 * @generated
	 */
	List<Integer> getPasses();

	/**
	 * Returns the value of the '<em><b>Intermediate Connections</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The connections propagated as middle guards from a hosted by a parent partition and to one or more child partitions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Intermediate Connections</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPartition_IntermediateConnections()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Partition!intermediateConnections'"
	 * @generated
	 */
	List<NodeConnection> getIntermediateConnections();

	/**
	 * Returns the value of the '<em><b>Root Connections</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The connections hosted by this partition and passed to child partitions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Root Connections</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPartition_RootConnections()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Partition!rootConnections'"
	 * @generated
	 */
	List<NodeConnection> getRootConnections();

	void addIntermediateConnection(@NonNull NodeConnection connection);
	boolean addPass(int passNumber);
	void addRootConnection(@NonNull NodeConnection connection);
	int getFirstPass();
	List<Node> getHeadNodes();
	@NonNull Iterable<@NonNull NodeConnection> getIncomingPassedConnections();

	/**
	 * The schedule index at which the latest dependent becomes available and consequently the latest that deferred execution may occur.
	 */
	int getLastPass();
	@Override
	@NonNull String getName();
	@NonNull Iterable<@NonNull Edge> getPartialEdges();
	@NonNull Iterable<@NonNull Node> getPartialNodes();
	@NonNull String getPassRangeText();
	@Nullable String getPassesText();
	Region getRegion();
	@Nullable Role getRole(@NonNull Edge edge);
	@Nullable Role getRole(@NonNull Node node);
	@NonNull String getSymbolName();
	boolean isHead(@NonNull ConnectionEnd connectionEnd);
	void setPass(int pass);

} // Partition
