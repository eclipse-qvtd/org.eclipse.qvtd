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
 * $Id: Package.java,v 1.1 2008/07/23 09:55:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Package#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Package#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Package#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getPackage_NestedPackage()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='nestingPackage'"
	 * @generated
	 */
	EList<Package> getNestedPackage();

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Type}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EMOF.Type#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getPackage_OwnedType()
	 * @see org.eclipse.qvt.declarative.emof.EMOF.Type#getPackage
	 * @model opposite="package" containment="true" ordered="false"
	 * @generated
	 */
	EList<Type> getOwnedType();

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getPackage_Uri()
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.String"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EMOF.Package#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // Package
