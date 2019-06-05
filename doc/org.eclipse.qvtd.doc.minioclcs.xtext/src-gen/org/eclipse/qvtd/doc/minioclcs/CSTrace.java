/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.doc.miniocl.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CS Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.CSTrace#getAst <em>Ast</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getCSTrace()
 * @model abstract="true"
 * @generated
 */
public interface CSTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast</em>' reference.
	 * @see #setAst(Element)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getCSTrace_Ast()
	 * @model transient="true"
	 * @generated
	 */
	Element getAst();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.CSTrace#getAst <em>Ast</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast</em>' reference.
	 * @see #getAst()
	 * @generated
	 */
	void setAst(Element value);

} // CSTrace
