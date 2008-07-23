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
 * $Id: CorePattern.java,v 1.1 2008/07/23 09:43:24 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.CorePattern#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getCorePattern()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='VariableNamesAreUnique'"
 * @generated
 */
public interface CorePattern extends Pattern {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.ecore.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getCorePattern_Variable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Variable> getAllVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Area getArea();

} // CorePattern
