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
 * $Id: OutlineBehavior.java,v 1.3 2008/08/24 18:56:21 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outline Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getOutlineBehavior()
 * @model
 * @generated
 */
public interface OutlineBehavior extends Behavior {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.editor.AbstractOutlineElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see #isSetElements()
	 * @see #unsetElements()
	 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getOutlineBehavior_Elements()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<AbstractOutlineElement> getElements();

	/**
	 * Unsets the value of the '{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#getElements <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElements()
	 * @see #getElements()
	 * @generated
	 */
	void unsetElements();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#getElements <em>Elements</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elements</em>' reference list is set.
	 * @see #unsetElements()
	 * @see #getElements()
	 * @generated
	 */
	boolean isSetElements();

} // OutlineBehavior
