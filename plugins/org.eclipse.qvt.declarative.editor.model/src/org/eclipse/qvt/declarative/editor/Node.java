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
 * $Id: Node.java,v 1.1 2008/08/08 16:39:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.editor.Node#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.editor.Node#getBase <em>Base</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.editor.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getNode_Behavior()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Behavior> getBehavior();

	/**
	 * Returns the value of the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' reference.
	 * @see #setBase(Node)
	 * @see org.eclipse.qvt.declarative.editor.EditorPackage#getNode_Base()
	 * @model
	 * @generated
	 */
	Node getBase();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.editor.Node#getBase <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(Node value);

} // Node
