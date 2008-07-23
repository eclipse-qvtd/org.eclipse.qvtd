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
 * $Id: Pattern.java,v 1.1 2008/07/23 09:57:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EMOF.Element;

import org.eclipse.qvt.declarative.emof.EssentialOCL.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Pattern#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Pattern#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends Element {
	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getPattern_BindsTo()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Variable> getBindsTo();

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.QVTBase.Predicate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTBase.Predicate#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getPattern_Predicate()
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.Predicate#getPattern
	 * @model opposite="pattern" containment="true" ordered="false"
	 * @generated
	 */
	EList<Predicate> getPredicate();

} // Pattern
