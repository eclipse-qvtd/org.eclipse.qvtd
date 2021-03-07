/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Target Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getTypedModel <em>Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getIterates <em>Iterates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getVia <em>Via</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getSimpleTargetElementCS()
 * @model
 * @generated
 */
public interface SimpleTargetElementCS extends TargetElementCS
{
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
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getSimpleTargetElementCS_TypedModel()
	 * @model required="true"
	 * @generated
	 */
	TypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getTypedModel <em>Typed Model</em>}' reference.
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
	 * <p>
	 * If the meaning of the '<em>Iterates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterates</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getSimpleTargetElementCS_Iterates()
	 * @model
	 * @generated
	 */
	EList<TypedModel> getIterates();

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(Boolean)
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getSimpleTargetElementCS_Input()
	 * @model
	 * @generated
	 */
	Boolean getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Boolean value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(Boolean)
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getSimpleTargetElementCS_Output()
	 * @model
	 * @generated
	 */
	Boolean getOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Boolean value);

	/**
	 * Returns the value of the '<em><b>Via</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Via</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Via</em>' attribute.
	 * @see #setVia(Boolean)
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getSimpleTargetElementCS_Via()
	 * @model
	 * @generated
	 */
	Boolean getVia();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getVia <em>Via</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Via</em>' attribute.
	 * @see #getVia()
	 * @generated
	 */
	void setVia(Boolean value);

} // SimpleTargetElementCS
