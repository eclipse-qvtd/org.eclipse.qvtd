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
 * $Id: EnumerationLiteral.java,v 1.1 2008/07/23 09:55:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.EnumerationLiteral#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getEnumerationLiteral()
 * @model
 * @generated
 */
public interface EnumerationLiteral extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EMOF.Enumeration#getOwnedLiteral <em>Owned Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' container reference.
	 * @see #setEnumeration(Enumeration)
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getEnumerationLiteral_Enumeration()
	 * @see org.eclipse.qvt.declarative.emof.EMOF.Enumeration#getOwnedLiteral
	 * @model opposite="ownedLiteral"
	 * @generated
	 */
	Enumeration getEnumeration();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EMOF.EnumerationLiteral#getEnumeration <em>Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' container reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(Enumeration value);

} // EnumerationLiteral
