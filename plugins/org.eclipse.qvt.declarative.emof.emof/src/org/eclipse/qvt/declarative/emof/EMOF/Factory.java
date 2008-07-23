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
 * $Id: Factory.java,v 1.1 2008/07/23 09:55:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Factory#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getFactory()
 * @model
 * @generated
 */
public interface Factory extends Element {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see #setPackage(org.eclipse.qvt.declarative.emof.EMOF.Package)
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getFactory_Package()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Package getPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EMOF.Factory#getPackage <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(org.eclipse.qvt.declarative.emof.EMOF.Package value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.String"
	 * @generated
	 */
	String convertToString(DataType dataType, org.eclipse.qvt.declarative.emof.EMOF.Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Element create(org.eclipse.qvt.declarative.emof.EMOF.Class metaClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model stringDataType="org.eclipse.qvt.declarative.emof.EMOF.String"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Object createFromString(DataType dataType, String string);

} // Factory
