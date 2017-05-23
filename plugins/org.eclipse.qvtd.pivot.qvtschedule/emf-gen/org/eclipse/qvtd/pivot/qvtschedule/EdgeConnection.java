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

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

/**
 * @generated
 */
public interface EdgeConnection extends DatumConnection<NavigableEdge>
{
	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEdgeConnection_ReferredProperty()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!EdgeConnection!referredProperty'"
	 * @generated
	 */
	Property getReferredProperty();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);
	void addUsedTargetEdge(@NonNull NavigableEdge targetEdge, boolean mustBeLater);
	@Override
	@NonNull Iterable<@NonNull NavigableEdge> getSources();
	//	@NonNull ConnectionRole getConnectionRole(@NonNull NavigableEdge targetEdge);
	@NonNull Iterable<@NonNull NavigableEdge> getTargetEdges();
	@Override
	@NonNull Map<@NonNull NavigableEdge, @NonNull ConnectionRole> getTargets();
	boolean isEdge2Edge();
}