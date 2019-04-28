/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigable Edge</b></em>'.
 *
 * deprecated See Bug 534371
 *
 * The concepts of NavigableEdge should be dynamically applicable to all mapping edges rather
 * than just NavigationEdge and irregularly CastEdge.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A NavigableEdge is directed and abstracts any type-based relationship as a Node to Node interconnection within a Region.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getIncomingConnection <em>Incoming Connection</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigableEdge()
 * @model abstract="true"
 * @generated
 */
public interface NavigableEdge extends Edge, ConnectionEnd
{
	/**
	 * Returns the value of the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Connection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Connection</em>' reference.
	 * @see #setIncomingConnection(EdgeConnection)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigableEdge_IncomingConnection()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NavigableEdge!incomingConnection'"
	 * @generated
	 */
	EdgeConnection getIncomingConnection();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getIncomingConnection <em>Incoming Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Connection</em>' reference.
	 * @see #getIncomingConnection()
	 * @generated
	 */
	void setIncomingConnection(EdgeConnection value);
	/**
	 * Returns the value of the '<em><b>Outgoing Connections</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Connections</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigableEdge_OutgoingConnections()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NavigableEdge!outgoingConnections'"
	 * @generated
	 */
	List<EdgeConnection> getOutgoingConnections();

	@NonNull String getEdgeName();
}