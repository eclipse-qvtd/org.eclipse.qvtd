/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
 * A representation of the model object '<em><b>Keyed Value Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A KeyedValueNode supports a globally unique value in a QVTs graph; repeated 'realizations' share the one value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode#getClassDatumValue <em>Class Datum Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getKeyedValueNode()
 * @model
 * @generated
 */
public interface KeyedValueNode extends OperationNode {
	/**
	 * Returns the value of the '<em><b>Class Datum Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Datum Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type and typed model of the unique value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Datum Value</em>' reference.
	 * @see #setClassDatumValue(ClassDatum)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getKeyedValueNode_ClassDatumValue()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!KeyedValueNode!classDatumValue'"
	 * @generated
	 */
	ClassDatum getClassDatumValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode#getClassDatumValue <em>Class Datum Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Datum Value</em>' reference.
	 * @see #getClassDatumValue()
	 * @generated
	 */
	void setClassDatumValue(ClassDatum value);

} // KeyedValueNode
