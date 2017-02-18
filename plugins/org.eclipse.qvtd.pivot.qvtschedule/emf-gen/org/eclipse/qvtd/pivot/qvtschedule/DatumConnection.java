/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;


import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Datum Connection</b></em>'.
 * @extends GraphEdge, GraphNode
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DatumConnection establishes that one or more source edges/nodes are available for use by one or more target edges/nodes.
 * Derivations refine the availability to edges or nodes, pass by value, optional existence or mandatory existence.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getConnectionRole <em>Connection Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getSourceEnds <em>Source Ends</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getDatumConnection()
 * @model abstract="true"
 * @generated
 */
public interface DatumConnection<CE extends ConnectionEnd> extends Connection, GraphEdge, GraphNode {
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
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getDatumConnection_ConnectionRole()
	 * @model default="UNDEFINED" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!DatumConnection{CE}!connectionRole'"
	 * @generated
	 */
	ConnectionRole getConnectionRole();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getConnectionRole <em>Connection Role</em>}' attribute.
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
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getDatumConnection_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!DatumConnection{CE}!name'"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source Ends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Ends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Ends</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getDatumConnection_SourceEnds()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!DatumConnection{CE}!sourceEnds'"
	 * @generated
	 */
	EList<CE> getSourceEnds();
	boolean addIndex(int index);
	@NonNull List<@NonNull Integer> getIndexes();
	@NonNull ConnectionEnd getSource(@NonNull Region sourceRegion);
	@NonNull String getSourceDisplayNames();
	@NonNull Iterable<@NonNull Node> getSourceNodes();
	@NonNull Iterable<@NonNull Region> getSourceRegions();
	@NonNull Iterable<@NonNull ? extends ConnectionEnd> getSources();
	@NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull ScheduledRegion scheduledRegion);
	@NonNull ConnectionEnd getTarget(@NonNull Region targetRegion);
	@NonNull Iterable<@NonNull Node> getTargetNodes();
	@NonNull Iterable<@NonNull Region> getTargetRegions();
	@NonNull Iterable<@NonNull Region> getTargetRegions(@NonNull ScheduledRegion scheduledRegion);
	@NonNull Map<@NonNull ? extends ConnectionEnd, @NonNull ConnectionRole> getTargets();

	/**
	 * Return true if this connection is from a nested region input port to the nested region's content.
	 */
	//	boolean isInput();
	boolean isMandatory();
	//	boolean isOutput();

	/**
	 * Return true if this connection passes a value to a region head.
	 */
	boolean isPassed();
	boolean isPassed(@NonNull Region targetRegion);
	boolean isRegion2Region(@NonNull Map<@NonNull Region, @NonNull Integer> sourceRegion2count, @NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles);
	void removeTargetRegion(@NonNull Region region);
}