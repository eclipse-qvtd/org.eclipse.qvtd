/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.source;

import example1.target.util.Visitable;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SElement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.source.SElement#getAst <em>Ast</em>}</li>
 * </ul>
 *
 * @see example1.source.SourcePackage#getSElement()
 * @model
 * @generated
 */
public interface SElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast</em>' reference.
	 * @see #setAst(Visitable)
	 * @see example1.source.SourcePackage#getSElement_Ast()
	 * @model type="example1.target.Visitable"
	 * @generated
	 */
	Visitable getAst();

	/**
	 * Sets the value of the '{@link example1.source.SElement#getAst <em>Ast</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast</em>' reference.
	 * @see #getAst()
	 * @generated
	 */
	void setAst(Visitable value);

} // SElement
