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
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Target Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement#getTypedModel <em>Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement#getIterates <em>Iterates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getSimpleTargetElement()
 * @model
 * @generated
 */
public interface SimpleTargetElement extends TargetElement {
	/**
	 * Returns the value of the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Model</em>' reference.
	 * @see #setTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getSimpleTargetElement_TypedModel()
	 * @model required="true"
	 * @generated
	 */
	TypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement#getTypedModel <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Model</em>' reference.
	 * @see #getTypedModel()
	 * @generated
	 */
	void setTypedModel(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Iterates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of typed models whose elements are also part of this TypedModel. An input TypedModel that iterates an output TypedModel specfies a fixed point iteration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Iterates</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getSimpleTargetElement_Iterates()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedModel> getIterates();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.pivot.qvtbase.TargetElementKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtbase.TargetElementKind
	 * @see #setKind(TargetElementKind)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getSimpleTargetElement_Kind()
	 * @model required="true"
	 * @generated
	 */
	TargetElementKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtbase.TargetElementKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TargetElementKind value);

} // SimpleTargetElement
