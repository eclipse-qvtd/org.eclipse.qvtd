/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Extent.java,v 1.1 2008/07/23 09:55:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extent</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getExtent()
 * @model
 * @generated
 */
public interface Extent extends org.eclipse.qvt.declarative.emof.EMOF.Object {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ReflectiveSequence elements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.Boolean"
	 * @generated
	 */
	Boolean useContainment();

} // Extent
