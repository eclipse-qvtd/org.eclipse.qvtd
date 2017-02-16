/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getSymbolNameSuffix <em>Symbol Name Suffix</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNamedMappingRegion()
 * @model
 * @generated
 */
public interface NamedMappingRegion extends MappingRegion {

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
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNamedMappingRegion_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NamedMappingRegion!name'"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Symbol Name Suffix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol Name Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol Name Suffix</em>' attribute.
	 * @see #setSymbolNameSuffix(String)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNamedMappingRegion_SymbolNameSuffix()
	 * @model default="" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NamedMappingRegion!symbolNameSuffix'"
	 * @generated
	 */
	String getSymbolNameSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getSymbolNameSuffix <em>Symbol Name Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol Name Suffix</em>' attribute.
	 * @see #getSymbolNameSuffix()
	 * @generated
	 */
	void setSymbolNameSuffix(String value);
} // NamedMappingRegion
