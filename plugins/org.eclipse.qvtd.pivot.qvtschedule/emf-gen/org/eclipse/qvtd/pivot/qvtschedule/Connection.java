/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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

import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningScheduledRegion <em>Owning Scheduled Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection()
 * @model abstract="true"
 * @generated
 */
public interface Connection extends Element, Symbolable, org.eclipse.ocl.pivot.utilities.Nameable
{
	/**
	 * Returns the value of the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedConnections <em>Owned Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Scheduled Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #setOwningScheduledRegion(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection_OwningScheduledRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedConnections
	 * @model opposite="ownedConnections" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Connection!owningScheduledRegion'"
	 * @generated
	 */
	ScheduledRegion getOwningScheduledRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningScheduledRegion <em>Owning Scheduled Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #getOwningScheduledRegion()
	 * @generated
	 */
	void setOwningScheduledRegion(ScheduledRegion value);

	void destroy();
} // Connection
