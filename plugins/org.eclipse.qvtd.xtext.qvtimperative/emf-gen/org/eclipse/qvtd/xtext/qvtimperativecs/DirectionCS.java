/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direction CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsOutput <em>Is Output</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS()
 * @model
 * @generated
 */
public interface DirectionCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS_Imports()
	 * @model
	 * @generated
	 */
	EList<org.eclipse.ocl.pivot.Package> getImports();

	/**
	 * Returns the value of the '<em><b>Is Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Input</em>' attribute.
	 * @see #setIsInput(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS_IsInput()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsInput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsInput <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Input</em>' attribute.
	 * @see #isIsInput()
	 * @generated
	 */
	void setIsInput(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Output</em>' attribute.
	 * @see #setIsOutput(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS_IsOutput()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsOutput <em>Is Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Output</em>' attribute.
	 * @see #isIsOutput()
	 * @generated
	 */
	void setIsOutput(boolean value);

} // DirectionCS
