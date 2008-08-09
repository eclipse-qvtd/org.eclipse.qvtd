/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: OutlineBehavior.java,v 1.2 2008/08/09 17:33:58 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outline Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#isContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getOutlineBehavior()
 * @model
 * @generated
 */
public interface OutlineBehavior extends Behavior {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(boolean)
	 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getOutlineBehavior_Container()
	 * @model default="false"
	 * @generated
	 */
	boolean isContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#isContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #isContainer()
	 * @generated
	 */
	void setContainer(boolean value);

	/**
	 * Returns the value of the '<em><b>Terminal</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminal</em>' attribute.
	 * @see #setTerminal(boolean)
	 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getOutlineBehavior_Terminal()
	 * @model default="false"
	 * @generated
	 */
	boolean isTerminal();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#isTerminal <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminal</em>' attribute.
	 * @see #isTerminal()
	 * @generated
	 */
	void setTerminal(boolean value);

} // OutlineBehavior
