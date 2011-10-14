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
 * $Id: Pattern.java,v 1.2 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

import org.eclipse.ocl.ecore.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Pattern#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Pattern#getBindsTo <em>Binds To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getPattern()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NoVariableIsAFunctionParameter'"
 * @generated
 */
public interface Pattern extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTBase.Predicate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Predicate#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getPattern_Predicate()
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.Predicate#getPattern
	 * @model opposite="pattern" containment="true" ordered="false"
	 * @generated
	 */
	EList<Predicate> getPredicate();

	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.ecore.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getPattern_BindsTo()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Variable> getBindsTo();

} // Pattern
