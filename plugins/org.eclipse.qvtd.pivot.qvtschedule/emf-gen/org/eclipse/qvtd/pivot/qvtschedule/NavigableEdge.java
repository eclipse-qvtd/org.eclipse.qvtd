/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

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
	EList<EdgeConnection> getOutgoingConnections();
	/**
	 * Returns the value of the '<em><b>Secondary</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this edge is the auto-created second half of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secondary</em>' attribute.
	 * @see #setSecondary(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigableEdge_Secondary()
	 * @model default="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NavigableEdge!secondary'"
	 * @generated
	 */
	@Override
	boolean isSecondary();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#isSecondary <em>Secondary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary</em>' attribute.
	 * @see #isSecondary()
	 * @generated
	 */
	void setSecondary(boolean value);
	/**
	 * Returns the value of the '<em><b>Opposite Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Opposite Edge</em>' reference.
	 * @see #setOppositeEdge(NavigableEdge)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigableEdge_OppositeEdge()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NavigableEdge!oppositeEdge'"
	 * @generated
	 */
	NavigableEdge getOppositeEdge();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOppositeEdge <em>Opposite Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Edge</em>' reference.
	 * @see #getOppositeEdge()
	 * @generated
	 */
	void setOppositeEdge(NavigableEdge value);
	void addOutgoingConnection(@NonNull EdgeConnection edgeConnection);

	@Override
	@NonNull NavigableEdge getForwardEdge();

	Property getProperty();

	void removeOutgoingConnection(@NonNull EdgeConnection edgeConnection);
}