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
 * A representation of the model object '<em><b>Micro Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getMappingRegion <em>Mapping Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getNamePrefix <em>Name Prefix</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getSymbolSuffix <em>Symbol Suffix</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMicroMappingRegion()
 * @model
 * @generated
 */
public interface MicroMappingRegion extends MappingRegion {

	/**
	 * Returns the value of the '<em><b>Mapping Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Region</em>' reference.
	 * @see #setMappingRegion(MappingRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMicroMappingRegion_MappingRegion()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MicroMappingRegion!mappingRegion'"
	 * @generated
	 */
	MappingRegion getMappingRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getMappingRegion <em>Mapping Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Region</em>' reference.
	 * @see #getMappingRegion()
	 * @generated
	 */
	void setMappingRegion(MappingRegion value);

	/**
	 * Returns the value of the '<em><b>Name Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Prefix</em>' attribute.
	 * @see #setNamePrefix(String)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMicroMappingRegion_NamePrefix()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MicroMappingRegion!namePrefix'"
	 * @generated
	 */
	String getNamePrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getNamePrefix <em>Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Prefix</em>' attribute.
	 * @see #getNamePrefix()
	 * @generated
	 */
	void setNamePrefix(String value);

	/**
	 * Returns the value of the '<em><b>Symbol Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol Suffix</em>' attribute.
	 * @see #setSymbolSuffix(String)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMicroMappingRegion_SymbolSuffix()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MicroMappingRegion!symbolSuffix'"
	 * @generated
	 */
	String getSymbolSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getSymbolSuffix <em>Symbol Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol Suffix</em>' attribute.
	 * @see #getSymbolSuffix()
	 * @generated
	 */
	void setSymbolSuffix(String value);
} // MicroMappingRegion
