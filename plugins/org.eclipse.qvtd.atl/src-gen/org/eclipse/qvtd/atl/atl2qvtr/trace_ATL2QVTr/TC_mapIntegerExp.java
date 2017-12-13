/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Integer Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIntegerExp#getPrimitive_symbol <em>Primitive symbol</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapIntegerExp()
 * @model
 * @generated
 */
public interface TC_mapIntegerExp extends TI_mapIntegerExp {
	/**
	 * Returns the value of the '<em><b>Primitive symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive symbol</em>' attribute.
	 * @see #setPrimitive_symbol(BigInteger)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapIntegerExp_Primitive_symbol()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	BigInteger getPrimitive_symbol();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIntegerExp#getPrimitive_symbol <em>Primitive symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive symbol</em>' attribute.
	 * @see #getPrimitive_symbol()
	 * @generated
	 */
	void setPrimitive_symbol(BigInteger value);

} // TC_mapIntegerExp
