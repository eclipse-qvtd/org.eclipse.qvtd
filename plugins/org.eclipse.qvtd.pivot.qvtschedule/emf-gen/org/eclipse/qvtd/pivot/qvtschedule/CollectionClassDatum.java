/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Class Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CollectionClassDatum identifies a Collection of Class-typed objects produced by one or more regions and consumed by one or more usually other regions. The collection is passed by reference, possibly within a Connection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum#getElementalClassDatum <em>Elemental Class Datum</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCollectionClassDatum()
 * @model
 * @generated
 */
public interface CollectionClassDatum extends ClassDatum {
	/**
	 * Returns the value of the '<em><b>Elemental Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elemental Class Datum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elemental Class Datum</em>' reference.
	 * @see #setElementalClassDatum(ClassDatum)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCollectionClassDatum_ElementalClassDatum()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
	ClassDatum getElementalClassDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum#getElementalClassDatum <em>Elemental Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elemental Class Datum</em>' reference.
	 * @see #getElementalClassDatum()
	 * @generated
	 */
	void setElementalClassDatum(ClassDatum value);

} // CollectionClassDatum
