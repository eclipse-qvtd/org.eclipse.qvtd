/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example4.kiamacs;

import example4.kiamaas.Element;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example4.kiamacs.BaseCS#getAst <em>Ast</em>}</li>
 * </ul>
 *
 * @see example4.kiamacs.KiamacsPackage#getBaseCS()
 * @model abstract="true"
 * @generated
 */
public interface BaseCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast</em>' reference.
	 * @see #setAst(Element)
	 * @see example4.kiamacs.KiamacsPackage#getBaseCS_Ast()
	 * @model
	 * @generated
	 */
	Element getAst();

	/**
	 * Sets the value of the '{@link example4.kiamacs.BaseCS#getAst <em>Ast</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast</em>' reference.
	 * @see #getAst()
	 * @generated
	 */
	void setAst(Element value);

} // BaseCS
